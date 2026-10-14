package nl.townsandkingdoms.tfacfix;

import com.google.gson.GsonBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.QuartPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.chunk.status.ChunkStatus;
import net.neoforged.fml.loading.FMLPaths;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartedEvent;
import nl.townsandkingdoms.tfacfix.mixin.CaveCarvingFactory;

import java.nio.file.Files;
import java.util.LinkedHashMap;
import java.util.Map;

/** Runs only under the developer's explicit integration-test JVM flag. */
public final class IntegrationChecks {
    private IntegrationChecks() {}
    public static void register() {
        if (!System.getProperty("tfacfix.integrationTest", "false").equals("false")) {
            NeoForge.EVENT_BUS.addListener(IntegrationChecks::onStarted);
        }
    }

    private static void require(boolean value, String message) {
        if (!value) throw new AssertionError(message);
    }

    private static void onStarted(ServerStartedEvent event) {
        MinecraftServer server = event.getServer();
        var report = new LinkedHashMap<String, Object>();
        try {
            ServerLevel level = server.overworld();
            var sampler = level.getChunkSource().randomState().sampler();
            var context = TerraforgedAlexCavesFix.context(sampler);
            if (System.getProperty("tfacfix.integrationTest").equals("vanilla")) {
                require(context == null, "Vanilla Overworld must remain unbound while UltraTerraForged is installed");
                report.put("vanillaOverworldUnchanged", true);
            } else {
                require(context != null, "UltraTerraForged Overworld binding missing");
                report.put("ultraterraforgedSamplerBound", true);
                var positions = new LinkedHashMap<String, Object>();
                BlockPos magnetic = null;
                for (var entry : VerifiedLocator.NAMES.entrySet()) {
                    BlockPos found = VerifiedLocator.find(level, BlockPos.ZERO, entry.getValue());
                    require(found != null, "No verified biome found: " + entry.getKey());
                    var source = level.getChunkSource().getGenerator().getBiomeSource();
                    require(source.getNoiseBiome(found.getX() >> 2, found.getY() >> 2, found.getZ() >> 2, sampler).is(entry.getValue()), "Locator verification mismatch");
                    require(source.getNoiseBiome(found.getX() >> 2, found.getY() >> 2, found.getZ() >> 2, sampler).is(entry.getValue()), "Repeated sampling changed the result");
                    positions.put(entry.getKey(), Map.of("x", found.getX(), "y", found.getY(), "z", found.getZ()));
                    if (entry.getKey().equals("magnetic_caves")) magnetic = found;
                }
                report.put("verifiedBiomes", positions);
                require(magnetic != null, "Magnetic sample missing");
                TerraforgedAlexCavesFix.LOG.info("TFACFix integration: all six biome sources verified; generating one cave chunk for write protection tests.");
                // A biome can contain solid rock between separate native chamber structures.
                // Verify a real nearby chamber start rather than assuming every biome sample is inside a chamber.
                var ferrocave = level.registryAccess().registryOrThrow(Registries.STRUCTURE)
                        .get(ResourceLocation.fromNamespaceAndPath("alexscaves", "ferrocave"));
                require(ferrocave != null, "Magnetic chamber structure missing from registry");
                BlockPos chamberSample = null;
                int mcx = magnetic.getX() >> 4;
                int mcz = magnetic.getZ() >> 4;
                search: for (int radius = 0; radius <= 8; radius++) {
                    for (int dx = -radius; dx <= radius; dx++) {
                        for (int dz = -radius; dz <= radius; dz++) {
                            if (radius > 0 && Math.abs(dx) != radius && Math.abs(dz) != radius) continue;
                            var candidate = level.getChunk(mcx + dx, mcz + dz, ChunkStatus.STRUCTURE_STARTS);
                            var start = candidate.getStartForStructure(ferrocave);
                            if (start != null && start.isValid()) {
                                BlockPos point = new BlockPos((mcx + dx) * 16 + 8, -16, (mcz + dz) * 16 + 8);
                                if (start.getBoundingBox().isInside(point)) { chamberSample = point; break search; }
                            }
                        }
                    }
                }
                require(chamberSample != null, "No native Magnetic Caves chamber start near the verified biome");
                magnetic = chamberSample;
                var chunk = level.getChunkAt(magnetic);
                var magneticKey = VerifiedLocator.NAMES.get("magnetic_caves");
                require(chunk.getNoiseBiome(magnetic.getX() >> 2, magnetic.getY() >> 2, magnetic.getZ() >> 2).is(magneticKey), "Stored generated chunk biome differs from sampled biome");
                report.put("generatedChunkBiomeVerified", true);
                var chamber = level.structureManager().getStructureAt(magnetic, ferrocave);
                require(chamber.isValid(), "Generated chamber start is missing from the completed chunk's structure references");
                report.put("magneticChamberStructureVerified", true);
                report.put("generatedMagneticChamberSample", Map.of("x", magnetic.getX(), "y", magnetic.getY(), "z", magnetic.getZ()));
                require(server.getCommands().getDispatcher().execute("tfacfix status", server.createCommandSourceStack()) == 1,
                        "Status command did not report an active world");
                require(server.getCommands().getDispatcher().execute("locateacbiome primordial_caves", server.createCommandSourceStack()) == 1,
                        "Verified locator command failed");
                report.put("statusAndLocateCommandsVerified", true);
                var carving = CaveCarvingFactory.tfacfix$create(chunk, context.terrain);
                var original = chunk.getBlockState(magnetic);
                try {
                    chunk.setBlockState(magnetic, Blocks.STONE.defaultBlockState(), false);
                    carving.clear(magnetic.getX(), magnetic.getY(), magnetic.getZ(), Integer.MIN_VALUE);
                    require(chunk.getBlockState(magnetic).is(Blocks.STONE), "Protected biome was cleared");
                    carving.set(magnetic.getX(), magnetic.getY(), magnetic.getZ(), Blocks.GOLD_BLOCK.defaultBlockState());
                    require(chunk.getBlockState(magnetic).is(Blocks.STONE), "Protected biome was decorated");
                    carving.line(magnetic.getX() + 0.5f, magnetic.getY() + 0.5f, magnetic.getZ() + 0.5f,
                            0.1f, 0.1f, 0.1f, 0.1f, (x, y, z) -> Blocks.GOLD_BLOCK.defaultBlockState());
                    require(chunk.getBlockState(magnetic).is(Blocks.STONE), "Protected biome was relined");
                } finally {
                    chunk.setBlockState(magnetic, original, false);
                }
                report.put("protectedClearSetAndLineVerified", true);
                BlockPos outside = magnetic.atY(level.getMaxBuildHeight() - 4);
                var surfaceOriginal = chunk.getBlockState(outside);
                try {
                    chunk.setBlockState(outside, Blocks.STONE.defaultBlockState(), false);
                    carving.clear(outside.getX(), outside.getY(), outside.getZ(), Integer.MIN_VALUE);
                    require(chunk.getBlockState(outside).isAir(), "Ordinary biome carving was blocked");
                    carving.set(outside.getX(), outside.getY(), outside.getZ(), Blocks.GOLD_BLOCK.defaultBlockState());
                    require(chunk.getBlockState(outside).is(Blocks.GOLD_BLOCK), "Ordinary biome decoration was blocked");
                } finally {
                    chunk.setBlockState(outside, surfaceOriginal, false);
                }
                report.put("ordinaryBiomeWritesUnchanged", true);
            }
            for (var dimension : java.util.List.of(Level.NETHER, Level.END)) {
                var other = server.getLevel(dimension);
                require(other != null && TerraforgedAlexCavesFix.context(other.getChunkSource().randomState().sampler()) == null,
                        "Non-Overworld sampler was modified");
            }
            report.put("netherAndEndUnchanged", true);
            report.put("passed", true);
        } catch (Throwable failure) {
            report.put("passed", false);
            report.put("error", failure.toString());
            TerraforgedAlexCavesFix.LOG.error("TFACFix integration checks failed", failure);
        }
        try {
            Files.writeString(FMLPaths.GAMEDIR.get().resolve("tfacfix-integration-results.json"),
                    new GsonBuilder().setPrettyPrinting().create().toJson(report));
        } catch (Exception failure) {
            TerraforgedAlexCavesFix.LOG.error("Could not write integration results", failure);
        }
        TerraforgedAlexCavesFix.LOG.info("TFACFix integration checks finished: {}", report);
        server.halt(false);
    }
}

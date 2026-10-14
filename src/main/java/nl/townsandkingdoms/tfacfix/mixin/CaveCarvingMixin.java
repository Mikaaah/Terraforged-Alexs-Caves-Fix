package nl.townsandkingdoms.tfacfix.mixin;

import com.pandaismyname1.ultraterraforged.world.worldgen.cave.CaveCarving;
import net.minecraft.core.BlockPos;
import net.minecraft.core.QuartPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import nl.townsandkingdoms.tfacfix.FixConfig;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = CaveCarving.class, remap = false)
public abstract class CaveCarvingMixin {
    @Shadow @Final public ChunkAccess chunk;
    @Unique private static final TagKey<Biome> TFACFIX_PROTECTED = TagKey.create(Registries.BIOME,
            ResourceLocation.fromNamespaceAndPath("tfacfix", "protected_caves"));

    @Unique private boolean tfacfix$isProtected(int x, int y, int z) {
        return FixConfig.PROTECT_CAVES.get() && chunk.getNoiseBiome(
                QuartPos.fromBlock(x), QuartPos.fromBlock(y), QuartPos.fromBlock(z)).is(TFACFIX_PROTECTED);
    }

    @Inject(method = "clear(IIII)V", at = @At("HEAD"), cancellable = true)
    private void tfacfix$clear(int x, int y, int z, int water, CallbackInfo ci) {
        if (tfacfix$isProtected(x, y, z)) ci.cancel();
    }

    @Inject(method = "set(IIILnet/minecraft/world/level/block/state/BlockState;)V", at = @At("HEAD"), cancellable = true)
    private void tfacfix$set(int x, int y, int z, BlockState state, CallbackInfo ci) {
        if (tfacfix$isProtected(x, y, z)) ci.cancel();
    }

    @Redirect(method = "line", at = @At(value = "INVOKE", target =
            "Lnet/minecraft/world/level/chunk/ChunkAccess;setBlockState(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;Z)Lnet/minecraft/world/level/block/state/BlockState;"))
    private BlockState tfacfix$lining(ChunkAccess target, BlockPos pos, BlockState state, boolean moving) {
        if (tfacfix$isProtected(pos.getX(), pos.getY(), pos.getZ())) return target.getBlockState(pos);
        return target.setBlockState(pos, state, moving);
    }
}

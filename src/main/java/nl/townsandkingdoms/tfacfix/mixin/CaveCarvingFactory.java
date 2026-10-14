package nl.townsandkingdoms.tfacfix.mixin;

import com.pandaismyname1.ultraterraforged.world.worldgen.GeneratorContext;
import com.pandaismyname1.ultraterraforged.world.worldgen.cave.CaveCarving;
import net.minecraft.world.level.chunk.ChunkAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value = CaveCarving.class, remap = false)
public interface CaveCarvingFactory {
    @Invoker("<init>")
    static CaveCarving tfacfix$create(ChunkAccess chunk, GeneratorContext context) {
        throw new AssertionError("Mixin constructor invoker not applied");
    }
}

package nl.townsandkingdoms.tfacfix.mixin;

import net.minecraft.world.level.biome.Climate;
import nl.townsandkingdoms.tfacfix.SamplerAccess;
import nl.townsandkingdoms.tfacfix.WorldContext;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(value = Climate.Sampler.class, remap = false)
public abstract class ClimateSamplerMixin implements SamplerAccess {
    @Unique private volatile WorldContext tfacfix$context;
    @Override public WorldContext tfacfix$getContext() { return tfacfix$context; }
    @Override public void tfacfix$setContext(WorldContext context) { tfacfix$context = context; }
}

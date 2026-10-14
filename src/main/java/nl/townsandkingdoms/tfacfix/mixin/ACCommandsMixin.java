package nl.townsandkingdoms.tfacfix.mixin;

import com.github.alexmodguy.alexscaves.server.command.ACCommands;
import net.minecraft.commands.CommandSourceStack;
import nl.townsandkingdoms.tfacfix.FixConfig;
import nl.townsandkingdoms.tfacfix.TerraforgedAlexCavesFix;
import nl.townsandkingdoms.tfacfix.VerifiedLocator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = ACCommands.class, remap = false)
public abstract class ACCommandsMixin {
    @Inject(method = "locateACBiome(Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I",
            at = @At("HEAD"), cancellable = true)
    private static void tfacfix$locate(CommandSourceStack source, String name, CallbackInfoReturnable<Integer> cir) {
        if (FixConfig.VERIFY_LOCATOR.get()
                && TerraforgedAlexCavesFix.context(source.getLevel().getChunkSource().randomState().sampler()) != null) {
            cir.setReturnValue(VerifiedLocator.run(source, name));
        }
    }
}

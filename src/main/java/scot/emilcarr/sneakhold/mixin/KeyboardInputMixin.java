package scot.emilcarr.sneakhold.mixin;

import scot.emilcarr.sneakhold.SneakHold;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.input.KeyboardInput;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(KeyboardInput.class)
public abstract class KeyboardInputMixin {

    // Inject into end of tick function and set sneaking state
    @Inject(
        method="tick",
        at=@At("TAIL")
    )
    public void tick(boolean slowDown, CallbackInfo callbackInfo) {
        MinecraftClient client = MinecraftClient.getInstance();
        client.player.input.sneaking = SneakHold.keySneakToggle.isPressed() || client.options.keySneak.isPressed();
    }
}

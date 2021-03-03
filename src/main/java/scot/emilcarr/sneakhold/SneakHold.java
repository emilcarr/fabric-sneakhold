package scot.emilcarr.sneakhold;

import org.lwjgl.glfw.GLFW;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.options.KeyBinding;
import net.minecraft.client.options.StickyKeyBinding;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;

public class SneakHold implements ModInitializer {

    public static KeyBinding keySneakToggle = 
        KeyBindingHelper.registerKeyBinding(
            new StickyKeyBinding(
                "key.sneakhold.sneak",
                GLFW.GLFW_KEY_UNKNOWN,
                "key.categories.movement",
                () -> true
            )
        );
    public static KeyBinding keySprintToggle =
        KeyBindingHelper.registerKeyBinding(
            new StickyKeyBinding(
                "key.sneakhold.sprint",
                GLFW.GLFW_KEY_UNKNOWN,
                "key.categories.movement",
                () -> true
            )
        );


    @Override
    public void onInitialize() {
        ClientTickEvents.START_CLIENT_TICK.register(this::onTickStart);
    }

    public void onTickStart(MinecraftClient client) {
        // Sneaking is set by scot.emilcarr.sneakhold.mixin.KeyboardInputMixin, before the value is read by net.minecraft.client.network.ClientPlayerEntity tick
        if(keySprintToggle.isPressed())
            client.player.setSprinting(true);
    }
}

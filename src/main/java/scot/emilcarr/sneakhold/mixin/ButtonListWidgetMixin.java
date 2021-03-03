package scot.emilcarr.sneakhold.mixin;

import net.minecraft.text.Text;
import net.minecraft.client.options.Option; 
import net.minecraft.client.gui.widget.ButtonListWidget;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ButtonListWidget.class)
public class ButtonListWidgetMixin {
    
    // Hide SNEAK_TOGGLED and SPRINT_TOGGLED options from the Accessibility Menu, since we are moving that functionality
    @Inject(
        method="addOptionEntry",
        at=@At("HEAD"),
        cancellable=true
    )
    public void removeHoldOptions(Option firstOption, Option secondOption, CallbackInfo callbackInfo) {
        if(firstOption == Option.SNEAK_TOGGLED)
            callbackInfo.cancel();
    }
}

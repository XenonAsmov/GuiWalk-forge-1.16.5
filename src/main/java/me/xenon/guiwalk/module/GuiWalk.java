package me.xenon.guiwalk.module;

import me.xenon.guiwalk.Wrapper;
import me.xenon.guiwalk.hooks.MovementInputFromOptions;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class GuiWalk implements Wrapper {

    @SubscribeEvent
    public void onTick(TickEvent.PlayerTickEvent event) {
        assert mc.player != null;

        if (!(mc.player.input instanceof MovementInputFromOptions)) {
            mc.player.input = new MovementInputFromOptions(mc.options);
        }
    }
}

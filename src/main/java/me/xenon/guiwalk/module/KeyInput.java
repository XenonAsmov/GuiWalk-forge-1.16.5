package me.xenon.guiwalk.module;

import me.xenon.guiwalk.Wrapper;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.lwjgl.glfw.GLFW;

public class KeyInput implements Wrapper {
    private GuiWalk guiWalk;

    public KeyInput() {
        guiWalk = new GuiWalk();
        EVENT_BUS.register(guiWalk);
    }

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        if (event.getKey() == GLFW.GLFW_KEY_F7 && event.getAction() == GLFW.GLFW_PRESS) {
            if (guiWalk == null) {
                guiWalk = new GuiWalk();
                EVENT_BUS.register(guiWalk);
            }
        }

        if (event.getKey() == GLFW.GLFW_KEY_F8 && event.getAction() == GLFW.GLFW_PRESS) {
            if (guiWalk != null) {
                EVENT_BUS.unregister(guiWalk);
                guiWalk = null;

                assert mc.player != null;
                mc.player.input = new net.minecraft.util.MovementInputFromOptions(mc.options);
            }
        }
    }
}

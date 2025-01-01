package me.xenon.guiwalk.hooks;

import me.xenon.guiwalk.Wrapper;
import net.minecraft.client.*;
import net.minecraft.client.gui.screen.*;
import net.minecraft.client.util.*;


public class MovementInputFromOptions extends net.minecraft.util.MovementInputFromOptions implements Wrapper {
    private final GameSettings options;

    public MovementInputFromOptions(final GameSettings p_i1237_1_) {
        super(p_i1237_1_);
        this.options = p_i1237_1_;
    }

    public void tick(final boolean p_225607_1_) {
        this.up = this.isDown(this.options.keyUp.getKey().getValue());
        this.down = this.isDown(this.options.keyDown.getKey().getValue());
        this.left = this.isDown(this.options.keyLeft.getKey().getValue());
        this.right = this.isDown(this.options.keyRight.getKey().getValue());
        this.forwardImpulse = ((this.up == this.down) ? 0.0f : (this.up ? 1.0f : -1.0f));
        this.leftImpulse = ((this.left == this.right) ? 0.0f : (this.left ? 1.0f : -1.0f));
        this.jumping = this.isDown(this.options.keyJump.getKey().getValue());
        this.shiftKeyDown = this.options.keyShift.isDown();
        if (p_225607_1_) {
            this.leftImpulse *= (float)0.3;
            this.forwardImpulse *= (float)0.3;
        }
    }

    private boolean isDown(final int a) {
        return !(mc.screen instanceof ChatScreen) && InputMappings.isKeyDown(mc.getWindow().getWindow(), a);
    }
}

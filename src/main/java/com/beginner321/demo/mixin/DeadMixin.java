package com.beginner321.demo.mixin;

import com.beginner321.demo.event.DeadCallback;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.util.ActionResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public class DeadMixin {

    @Inject(method = "onDeath", at = @At(value = "INVOKE"), cancellable = true)
    private void onDeath(DamageSource source, CallbackInfo ci) {
        ActionResult result = DeadCallback.EVENT.invoker().interact(source);
        System.out.println(source.name);
        System.out.println(source.getPosition());
        if(result == ActionResult.FAIL) {
            ci.cancel();
        }
    }
}
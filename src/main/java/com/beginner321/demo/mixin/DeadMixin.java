package com.beginner321.demo.mixin;

import com.beginner321.demo.event.DeadCallback;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class DeadMixin extends Entity{

    @Shadow protected int playerHitTimer;

    public DeadMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Inject(method = "onDeath", at = @At(value = "HEAD"), cancellable = true)
    private void onDeath(DamageSource source, CallbackInfo ci) {
        ActionResult result = DeadCallback.EVENT.invoker().interact(source);
        System.out.println("111111111111 "+super.getName().toString());
        if(result == ActionResult.FAIL) {
            ci.cancel();
        }
    }
}
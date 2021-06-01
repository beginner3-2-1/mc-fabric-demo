package com.beginner321.demo.mixin;

import com.alibaba.fastjson.JSON;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.tag.ItemTags;
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

    @Inject(method = "onDeath", at = @At(value = "RETURN"), cancellable = true)
    private void onDeathMixin(DamageSource source, CallbackInfo ci) {
        if(!world.isClient){
            System.out.println(source.name);
            System.out.println(JSON.toJSONString(super.getType()));
        }
    }
}
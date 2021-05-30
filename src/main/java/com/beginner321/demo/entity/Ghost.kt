package com.beginner321.demo.entity

import net.minecraft.entity.EntityType
import net.minecraft.entity.damage.DamageSource
import net.minecraft.entity.mob.HostileEntity
import net.minecraft.world.World

class Ghost(entityType: EntityType<out HostileEntity>?, world: World?) : HostileEntity(entityType, world) {

    override fun onDeath(source: DamageSource?) {
        super.onDeath(source)

    }

}
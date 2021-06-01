package com.beginner321.demo.block

import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.block.Material
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.text.LiteralText
import net.minecraft.util.ActionResult
import net.minecraft.util.Hand
import net.minecraft.util.hit.BlockHitResult
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

/**
 *  @author beginner
 *  2021/5/28 15:35
 */
class FirstBlock(settings : Settings?) : Block(settings)
{
    constructor():this(FabricBlockSettings.of(Material.METAL).hardness(1f))

    override fun onUse(state : BlockState? , world : World? , pos : BlockPos? ,
                       player : PlayerEntity? , hand : Hand? , hit : BlockHitResult?) : ActionResult
    {
        return if(world?.isClient != true){
            player?.sendMessage(LiteralText("TEST"),false)
            ActionResult.SUCCESS
        }else{
            super.onUse(state, world, pos, player, hand, hit)
        }
    }
}
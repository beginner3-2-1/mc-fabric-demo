package com.beginner321.demo.block

import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Block
import net.minecraft.block.Material

/**
 *  @author beginner
 *  2021/5/28 15:35
 */
class FirstBlock(settings : Settings?) : Block(settings)
{
    constructor():this(FabricBlockSettings.of(Material.METAL).hardness(1f))
}
package com.beginner321.demo.block

import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.*
import net.minecraft.item.ItemPlacementContext
import net.minecraft.state.StateManager
import net.minecraft.state.property.Properties
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Direction
import net.minecraft.util.shape.VoxelShape
import net.minecraft.util.shape.VoxelShapes
import net.minecraft.world.BlockView

/**
 *  @author beginner
 *  2021/6/3 11:29
 */
class ThirdBlock(settings : Settings?) : Block(settings)
{
    constructor() : this(FabricBlockSettings.of(Material.STONE).hardness(1f))

    init
    {
        defaultState =
                this.stateManager.defaultState.with(Properties.HORIZONTAL_FACING , Direction.NORTH)
    }

    override fun appendProperties(builder : StateManager.Builder<Block , BlockState>?)
    {
        builder?.add(Properties.HORIZONTAL_FACING)
    }

    override fun getPlacementState(ctx : ItemPlacementContext?) : BlockState?
    {
        return defaultState.with(HorizontalFacingBlock.FACING , ctx?.playerFacing)
    }

    override fun getOutlineShape(state : BlockState? , world : BlockView? , pos : BlockPos? ,
                                 context : ShapeContext?) : VoxelShape
    {
        val dir = state?.get(HorizontalFacingBlock.FACING)
        val d_2 = 1.0 / 8
        val d_14 = 7.0 / 8
        val d_1_5 = 1.5 / 16
        val d_7 = 7.0 / 16
        val d_9 = 9.0 / 16
        val d_6 = 3.0 / 16
        val d_13 = 13.0 / 16
        val d_11 = 11.0 / 16
        dir?.let {
            return when (it)
            {
                Direction.NORTH -> VoxelShapes.union(
                        VoxelShapes.cuboid(d_2 , 0.0 , d_2 , d_14 , d_1_5 , d_14) ,
                        VoxelShapes.cuboid(d_7 , d_1_5 , d_7 , d_9 , 1.0 , d_9) ,
                        VoxelShapes.cuboid(d_6 , d_9 , d_7 , d_13 , d_11 , d_9))
                Direction.SOUTH -> VoxelShapes.union(
                        VoxelShapes.cuboid(d_2 , 0.0 , d_2 , d_14 , d_1_5 , d_14) ,
                        VoxelShapes.cuboid(d_7 , d_1_5 , d_7 , d_9 , 1.0 , d_9) ,
                        VoxelShapes.cuboid(d_6 , d_9 , d_7 , d_13 , d_11 , d_9))
                Direction.EAST  -> VoxelShapes.union(
                        VoxelShapes.cuboid(d_2 , 0.0 , d_2 , d_14 , d_1_5 , d_14) ,
                        VoxelShapes.cuboid(d_7 , d_1_5 , d_7 , d_9 , 1.0 , d_9) ,
                        VoxelShapes.cuboid(d_7 , d_9 , d_6 , d_9 , d_11 , d_13))
                Direction.WEST  -> VoxelShapes.union(
                        VoxelShapes.cuboid(d_2 , 0.0 , d_2 , d_14 , d_1_5 , d_14) ,
                        VoxelShapes.cuboid(d_7 , d_1_5 , d_7 , d_9 , 1.0 , d_9) ,
                        VoxelShapes.cuboid(d_7 , d_9 , d_6 , d_9 , d_11 , d_13))
                else            -> VoxelShapes.fullCube()
            }
        }
        return super.getOutlineShape(state , world , pos , context)
    }
}
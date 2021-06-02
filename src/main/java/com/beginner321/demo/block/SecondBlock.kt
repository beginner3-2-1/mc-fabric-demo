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
 * 带有方向的方块
 *  @author beginner
 *  2021/6/2 17:17
 */
class SecondBlock(settings : Settings?) : HorizontalFacingBlock(settings)
{
    constructor() : this(FabricBlockSettings.of(Material.METAL).hardness(1f))

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
        return defaultState.with(FACING , ctx?.playerFacing)
    }

    override fun getOutlineShape(state : BlockState? , world : BlockView? , pos : BlockPos? ,
                                 context : ShapeContext?) : VoxelShape
    {
        val dir = state?.get(FACING)
        dir?.let {
            return when (it)
            {
                Direction.NORTH -> VoxelShapes.cuboid(0.0 , 0.0 , 0.0 , 1.0 , 1.0 , 0.5)
                Direction.SOUTH -> VoxelShapes.cuboid(0.0 , 0.0 , 0.5 , 1.0 , 1.0 , 1.0)
                Direction.EAST  -> VoxelShapes.cuboid(0.5 , 0.0 , 0.0 , 1.0 , 1.0 , 1.0)
                Direction.WEST  -> VoxelShapes.cuboid(0.0 , 0.0 , 0.0 , 0.5 , 1.0 , 1.0)
                else            -> VoxelShapes.fullCube()
            }
        }
        return super.getOutlineShape(state , world , pos , context)
    }
}
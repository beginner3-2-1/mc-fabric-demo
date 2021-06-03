package com.beginner321.demo.block.entity

import com.beginner321.demo.Demo
import net.minecraft.block.BlockState
import net.minecraft.block.entity.BlockEntity
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.inventory.Inventories
import net.minecraft.item.ItemStack
import net.minecraft.nbt.CompoundTag
import net.minecraft.util.collection.DefaultedList

class FirstBlockEntity(type: BlockEntityType<*>?) : BlockEntity(type),ImplementedInventory {

    val mItems :DefaultedList<ItemStack> = DefaultedList.ofSize(2,ItemStack.EMPTY)!!

    constructor() : this(Demo.FIRST_BLOCK_ENTITY)

    override fun fromTag(state: BlockState?, tag: CompoundTag?) {
        super.fromTag(state, tag)
        Inventories.fromTag(tag,mItems);
    }

    override fun toTag(tag: CompoundTag?): CompoundTag {
        Inventories.toTag(tag,mItems)
        return super.toTag(tag)
    }

    override fun getItems(): DefaultedList<ItemStack> {
        return mItems
    }

    override fun removeStack(slot: Int, amount: Int): ItemStack {
        return super.removeStack(slot)
    }

    override fun markDirty() {

    }

}
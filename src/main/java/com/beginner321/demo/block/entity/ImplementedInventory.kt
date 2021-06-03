package com.beginner321.demo.block.entity

import net.minecraft.entity.player.PlayerEntity
import net.minecraft.inventory.Inventories
import net.minecraft.inventory.Inventory
import net.minecraft.item.ItemStack
import net.minecraft.util.collection.DefaultedList

typealias u = () -> DefaultedList<ItemStack>

public interface ImplementedInventory : Inventory {
//    companion object {
//        fun of(items: DefaultedList<ItemStack>): ImplementedInventory {
//            return ImplementedInventory({ items })
//        }
//
//
//        fun ofSize(size: Int): ImplementedInventory {
//            return of(DefaultedList.ofSize(size, ItemStack.EMPTY))
//        }
//    }
    fun getItems(): DefaultedList<ItemStack>
    override fun size(): Int {
        return getItems().size
    }

    override fun isEmpty(): Boolean {
        for (i in 0 until size()) {
            val stack = getStack(i)
            if (!stack.isEmpty) {
                return false
            }
        }
        return true
    }

    override fun getStack(slot: Int): ItemStack {
        return getItems()[slot]
    }

    override fun removeStack(slot: Int): ItemStack {
        return Inventories.removeStack(getItems(), slot)
    }

    override fun setStack(slot: Int, stack: ItemStack?) {
        getItems()[slot] = stack
        if (stack?.count ?: 0 > maxCountPerStack) {
            stack?.count = maxCountPerStack
        }
    }

    override fun clear() {
        getItems().clear()
    }

    override fun markDirty() {

    }

    override fun canPlayerUse(player: PlayerEntity?): Boolean {
        return true
    }

}
package com.beginner321.demo

import com.beginner321.demo.block.FirstBlock
import com.beginner321.demo.items.FirstItem
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import net.minecraft.block.Blocks
import net.minecraft.block.FireBlock
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import java.util.function.Supplier

class Demo : ModInitializer {
    companion object{
        val ITEM_GROUP:ItemGroup= FabricItemGroupBuilder.build(Identifier("demo","group"),
                Supplier {
                    return@Supplier ItemStack(Blocks.ACACIA_LEAVES)
                })
        val firstItem:FirstItem by lazy {
            FirstItem()
        }
        val firstBlock:FirstBlock by lazy {
            FirstBlock()
        }
        const val NAME_SPACE="demo"
    }



    override fun onInitialize() {
        registryEvery()
    }

    private fun registryEvery() {
        registerBlock()
        registerItems()
    }

    private fun registerItems(){
        Registry.register(Registry.ITEM, Identifier(NAME_SPACE,"first_item") ,firstItem)
        Registry.register(Registry.ITEM, Identifier(NAME_SPACE,"first_block"),BlockItem(firstBlock,
                Item.Settings().group(ITEM_GROUP)))
    }

    private fun registerBlock(){
        Registry.register(Registry.BLOCK, Identifier(NAME_SPACE,"first_block"), firstBlock)
    }

}
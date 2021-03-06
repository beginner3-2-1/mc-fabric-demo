package com.beginner321.demo

import com.beginner321.demo.block.FirstBlock
import com.beginner321.demo.block.SecondBlock
import com.beginner321.demo.block.ThirdBlock
import com.beginner321.demo.block.entity.FirstBlockEntity
import com.beginner321.demo.items.FirstItem
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import net.fabricmc.fabric.api.event.player.AttackEntityCallback
import net.minecraft.block.Blocks
import net.minecraft.block.entity.BeehiveBlockEntity
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.util.ActionResult
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
        val secondBlock:SecondBlock by lazy {
            SecondBlock()
        }
        val thirdBlock:ThirdBlock by lazy {
            ThirdBlock()
        }
        const val NAME_SPACE="demo"

        lateinit var FIRST_BLOCK_ENTITY:BlockEntityType<FirstBlockEntity>
    }



    override fun onInitialize() {
        registryEvery()
    }

    private fun registryEvery() {
        registerBlock()
        registerItems()
        registerEvent()
    }

    private fun registerItems(){
        Registry.register(Registry.ITEM, Identifier(NAME_SPACE,"first_item") ,firstItem)
        Registry.register(Registry.ITEM, Identifier(NAME_SPACE,"first_block"),BlockItem(firstBlock,
                Item.Settings().group(ITEM_GROUP)))
        Registry.register(Registry.ITEM, Identifier(NAME_SPACE,"second_block"),BlockItem(secondBlock,
                Item.Settings().group(ITEM_GROUP)))
        Registry.register(Registry.ITEM, Identifier(NAME_SPACE,"third_block"),BlockItem(thirdBlock,
                Item.Settings().group(ITEM_GROUP)))
    }

    private fun registerBlock(){
        Registry.register(Registry.BLOCK, Identifier(NAME_SPACE,"first_block"), firstBlock)
        Registry.register(Registry.BLOCK, Identifier(NAME_SPACE,"second_block"), secondBlock)
        Registry.register(Registry.BLOCK, Identifier(NAME_SPACE,"third_block"), thirdBlock)

        FIRST_BLOCK_ENTITY=Registry.register(Registry.BLOCK_ENTITY_TYPE,"demo:first_block_entity",
            BlockEntityType.Builder.create({ FirstBlockEntity() }, thirdBlock).build(null))
    }

    private fun registerEvent(){
        AttackEntityCallback.EVENT.register(AttackEntityCallback { player, world, hand, entity, hitResult ->
            System.out.println("1 ${entity} ${hitResult}" )
            return@AttackEntityCallback ActionResult.PASS
        })

    }
}
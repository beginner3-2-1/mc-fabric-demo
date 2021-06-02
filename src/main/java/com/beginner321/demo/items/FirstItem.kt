package com.beginner321.demo.items

import com.beginner321.demo.Demo
import net.minecraft.client.item.TooltipContext
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.text.Text
import net.minecraft.text.TranslatableText
import net.minecraft.world.World

class FirstItem(settings: Settings) : Item(settings) {

    constructor():this(
            Settings()
            .maxCount(30)
            .fireproof()
            .group(Demo.ITEM_GROUP))

    override fun appendTooltip(stack : ItemStack? , world : World? , tooltip : MutableList<Text>? ,
                               context : TooltipContext?)
    {
        tooltip?.add(TranslatableText("item.demo.first_item.tooltip",10))
        tooltip?.add(TranslatableText("item.demo.first_item.tooltip_1"))
        tooltip?.add(TranslatableText("item.demo.first_item.tooltip_2"))
    }

}
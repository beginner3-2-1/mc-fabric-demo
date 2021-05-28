package com.beginner321.demo.items

import com.beginner321.demo.Demo
import net.minecraft.item.Item

class FirstItem(settings: Settings) : Item(settings) {

    constructor():this(
            Settings()
            .maxCount(30)
            .fireproof()
            .group(Demo.ITEM_GROUP))

}
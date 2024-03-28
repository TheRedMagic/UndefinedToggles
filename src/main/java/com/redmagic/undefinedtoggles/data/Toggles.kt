package com.redmagic.undefinedtoggles.data

import com.redmagic.undefinedtoggles.UndefinedToggles

class Toggles(var armorTrimsCopying: Boolean, var upgradeTemplateCopying: Boolean, var villagerChangeTrade: Boolean, var tntBlockDamage: Boolean, private val plugin: UndefinedToggles) {

    fun save(){
        plugin.configuration.set("toggles.armor-trims-copying", armorTrimsCopying)
        plugin.configuration.set("toggles.upgrade-template-copying", upgradeTemplateCopying)
        plugin.configuration.set("toggles.villager-change-trade", villagerChangeTrade)
        plugin.configuration.set("toggles.tnt-block-damage", tntBlockDamage)
    }

}
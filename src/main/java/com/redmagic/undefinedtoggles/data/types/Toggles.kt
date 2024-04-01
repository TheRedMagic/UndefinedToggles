package com.redmagic.undefinedtoggles.data.types

import com.redmagic.undefinedtoggles.UndefinedToggles

class Toggles(var armorTrimsCopying: Boolean, var upgradeTemplateCopying: Boolean, var villagerChangeTrade: Boolean, var tntBlockDamage: Boolean, var allowElytra: Boolean, var allowFireworksWithElytra: Boolean, private val plugin: UndefinedToggles) {

    fun save(){
        plugin.configuration.set("toggles.block-armor-trims-copying", armorTrimsCopying)
        plugin.configuration.set("toggles.block-upgrade-template-copying", upgradeTemplateCopying)
        plugin.configuration.set("toggles.block-villager-change-trade", villagerChangeTrade)
        plugin.configuration.set("toggles.block-tnt-block-damage", tntBlockDamage)
        plugin.configuration.set("toggles.block-allow-elytra", allowElytra)
        plugin.configuration.set("toggles.block-allow-fireworks-with-elytra", allowFireworksWithElytra)
    }

}
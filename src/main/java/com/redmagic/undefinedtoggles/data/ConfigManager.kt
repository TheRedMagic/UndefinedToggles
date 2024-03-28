package com.redmagic.undefinedtoggles.data

import com.redmagic.undefinedtoggles.UndefinedToggles

class ConfigManager(plugin: UndefinedToggles) {

    val cooldowns = Cooldowns(
        plugin.configuration.getInt("cooldowns.ender-pearls"),
        plugin.configuration.getInt("cooldowns.fireworks"),
        plugin.configuration.getInt("cooldowns.bow"),
        plugin.configuration.getInt("cooldowns.trident"),
        plugin
    )
    val toggles = Toggles(
        plugin.configuration.getBoolean("toggles.armor-trims-copying"),
        plugin.configuration.getBoolean("toggles.upgrade-template-coping"),
        plugin.configuration.getBoolean("toggles.villager-change-trade"),
        plugin.configuration.getBoolean("toggles.tnt-block-damage"),
        plugin
    )

    val reduction = Reduction(
        plugin.configuration.getDouble("reduction.crystals"),
        plugin.configuration.getDouble("reduction.tnt-minecart"),
        plugin.configuration.getDouble("reduction.tnt"),
        plugin.configuration.getDouble("reduction.anchors"),
        plugin
    )


    fun saveAll(){
        toggles.save()
        cooldowns.save()
        reduction.save()
    }

}
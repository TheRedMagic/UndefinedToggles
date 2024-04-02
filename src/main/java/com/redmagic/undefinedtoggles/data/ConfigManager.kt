package com.redmagic.undefinedtoggles.data

import com.redmagic.undefinedtoggles.UndefinedToggles
import com.redmagic.undefinedtoggles.data.types.*

class ConfigManager(plugin: UndefinedToggles) {

    val cooldowns = Cooldowns(
        plugin.configuration.getDouble("cooldowns.ender-pearls"),
        plugin.configuration.getDouble("cooldowns.fireworks"),
        plugin.configuration.getDouble("cooldowns.bow"),
        plugin.configuration.getDouble("cooldowns.trident"),
        plugin.configuration.getDouble("cooldowns.crossbow"),
        plugin.configuration.getDouble("cooldowns.axe"),
        plugin
    )
    val toggles = Toggles(
        plugin.configuration.getBoolean("toggles.block-armor-trims-copying"),
        plugin.configuration.getBoolean("toggles.block-upgrade-template-coping"),
        plugin.configuration.getBoolean("toggles.block-villager-change-trade"),
        plugin.configuration.getBoolean("toggles.block-tnt-block-damage"),
        plugin.configuration.getBoolean("toggles.block-allow-elytra"),
        plugin.configuration.getBoolean("toggles.block-allow-fireworks-with-elytra"),
        plugin
    )

    val reduction = Reduction(
        plugin.configuration.getDouble("reduction.crystals"),
        plugin.configuration.getDouble("reduction.tnt-minecart"),
        plugin.configuration.getDouble("reduction.tnt"),
        plugin.configuration.getDouble("reduction.anchors"),
        plugin.configuration.getDouble("reduction.bed-explosions"),
        plugin.configuration.getDouble("reduction.fall-damage"),
        plugin
    )

    val maxAmount = Amount(
        plugin.configuration.getInt("blocked.max-amount.totems"),
        plugin.configuration.getInt("blocked.max-amount.potion"),
        plugin
    )

    val blocks = Blocks(plugin)


    fun saveAll(){
        toggles.save()
        cooldowns.save()
        reduction.save()
        blocks.save()
        maxAmount.save()
    }

}
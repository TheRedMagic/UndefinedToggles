package com.redmagic.undefinedtoggles.data.types

import com.redmagic.undefinedtoggles.UndefinedToggles
import org.bukkit.Material

class Cooldowns(var enderPearls: Double, var fireworks: Double, var bow: Double, var trident: Double, var crossbow: Double, var axe: Double, private val plugin: UndefinedToggles) {


    fun save(){
        plugin.configuration.set("cooldowns.ender-pearls", enderPearls)
        plugin.configuration.set("cooldowns.fireworks", fireworks)
        plugin.configuration.set("cooldowns.bow", bow)
        plugin.configuration.set("cooldowns.trident", trident)
        plugin.configuration.set("cooldowns.crossbow", crossbow)
        plugin.configuration.set("cooldowns.axe", axe)
    }


    fun getCooldownFromMaterial(material: Material): Double? =
        if (material.name.contains("AXE")) axe
        else
            when (material){
                Material.ENDER_PEARL -> enderPearls
                Material.FIREWORK_ROCKET -> fireworks
                Material.BOW -> bow
                Material.TRIDENT -> trident
                Material.CROSSBOW -> crossbow
                else -> null
            }


}
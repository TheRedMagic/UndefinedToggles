package com.redmagic.undefinedtoggles.data.types

import com.redmagic.undefinedtoggles.UndefinedToggles
import org.bukkit.Material
import org.bukkit.entity.EntityType

class Reduction(
    var crystals: Double,
    var tntMinecart: Double,
    var tnt: Double,
    var anchors: Double,
    var bedExplosions: Double,
    var fallDamage: Double,
    private val plugin: UndefinedToggles
) {

    fun save(){
        plugin.configuration.set("reduction.crystals", crystals)
        plugin.configuration.set("reduction.tnt-minecart", tntMinecart)
        plugin.configuration.set("reduction.tnt", tnt)
        plugin.configuration.set("reduction.anchors", anchors)
        plugin.configuration.set("reduction.bed-explosions", bedExplosions)
        plugin.configuration.set("reduction.fall-damage", fallDamage)
    }

    fun getRedctionFromEntityType(entityType: EntityType): Double? =
        when (entityType){
            EntityType.ENDER_CRYSTAL -> crystals
            EntityType.MINECART_TNT -> tntMinecart
            EntityType.PRIMED_TNT -> tnt
            else -> null
        }

    fun getReductionFromMaterial(material: Material): Double? {

        if (material == Material.RESPAWN_ANCHOR){
            return anchors
        }

        if (material.name.contains("BED")){
            return bedExplosions
        }

        return null
    }

}
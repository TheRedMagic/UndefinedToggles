package com.redmagic.undefinedtoggles.data.types

import com.redmagic.undefinedtoggles.UndefinedToggles

class Reduction(var crystals: Double, var tntMinecart: Double, var tnt: Double, var anchors: Double, var bedExplosions: Double, private val plugin: UndefinedToggles) {

    fun save(){
        plugin.configuration.set("reduction.crystals", crystals)
        plugin.configuration.set("reduction.tnt-minecart", tntMinecart)
        plugin.configuration.set("reduction.tnt", tnt)
        plugin.configuration.set("reduction.anchors", anchors)
        plugin.configuration.set("reduction.bed-explosions", bedExplosions)
    }

}
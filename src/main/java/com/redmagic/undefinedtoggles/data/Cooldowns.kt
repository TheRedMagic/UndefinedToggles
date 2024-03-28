package com.redmagic.undefinedtoggles.data

import com.redmagic.undefinedtoggles.UndefinedToggles

class Cooldowns(var enderPearls: Int, var fireworks: Int, var bow: Int, var trident: Int, private val plugin: UndefinedToggles) {


    fun save(){
        plugin.configuration.set("cooldowns.ender-pearls", enderPearls)
        plugin.configuration.set("cooldowns.fireworks", fireworks)
        plugin.configuration.set("cooldowns.bow", bow)
        plugin.configuration.set("cooldowns.trident", trident)
    }


}
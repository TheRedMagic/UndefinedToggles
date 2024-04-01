package com.redmagic.undefinedtoggles.data.types

import com.redmagic.undefinedtoggles.UndefinedToggles

class Amount(var totems: Int, var potion: Int, private val plugin: UndefinedToggles) {

    fun save(){
        plugin.configuration.set("blocked.max-amount.totems", totems)
        plugin.configuration.set("blocked.max-amount.potion", potion)
    }
}
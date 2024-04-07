package com.redmagic.undefinedtoggles.data.types

import com.redmagic.undefinedtoggles.UndefinedToggles
import org.bukkit.Bukkit
import org.bukkit.Material

class Amount(private val plugin: UndefinedToggles) {

    var maxAmount = HashMap<Material, Int>()

    init {

        plugin.config.getConfigurationSection("blocked.max-amount")!!.getKeys(false).forEach(){

            val amount = plugin.config.getInt("blocked.max-amount.$it")

            try {
                maxAmount[Material.valueOf(it.toUpperCase())] = amount
            }catch (_: Exception){
                Bukkit.getLogger().warning("$it is not a item material. Please check https://mcutils.com/item-ids")
            }

        }

    }

    fun save(){

        plugin.config.set("blocked.max-amount", null)
        maxAmount.forEach(){
            plugin.config.set("blocked.max-amount.${it.key.name}", it.value)
        }

    }
}
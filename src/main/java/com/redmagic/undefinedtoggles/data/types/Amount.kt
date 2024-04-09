package com.redmagic.undefinedtoggles.data.types

import com.redmagic.undefinedapi.builders.ItemBuilder
import com.redmagic.undefinedapi.extension.string.toSmallText
import com.redmagic.undefinedapi.extension.string.translateColor
import com.redmagic.undefinedtoggles.UndefinedToggles
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class Amount(private val plugin: UndefinedToggles) {

    var maxAmount = HashMap<Material, Int>()

    init {

        plugin.config.getConfigurationSection("blocked.max-amount")!!.getKeys(false).forEach(){
            val amount = plugin.config.getInt("blocked.max-amount.$it")
            try {
                maxAmount[Material.valueOf(it.uppercase())] = amount
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

fun HashMap<Material, Int>.toItemStacks(): MutableList<ItemStack> = map<Material, Int, ItemStack> {
    ItemBuilder(it.key)
        .setName("<reset><#ebb734>${it.key.name.replace("_", " ").toSmallText()}".translateColor())
        .addLine(" ")
        .addLine("<reset><aqua>ᴍᴀx ᴀᴍᴏᴜɴᴛ <gray>${it.value}".translateColor())
        .addLine(" ")
        .addLine("<reset><gray>ʟᴇꜰᴛ ᴄʟɪᴄᴋ ᴛᴏ ᴇᴅɪᴛ ᴍᴀx ᴀᴍᴏᴜɴᴛ".translateColor())
        .addLine("<reset><gray>ʀɪɢʜᴛ ᴄʟɪᴄᴋ ᴛᴏ ʀᴇᴍᴏᴠᴇ ꜰʀᴏᴍ ᴍᴀx ᴀᴍᴏᴜɴᴛѕ".translateColor())
        .build()
}.toMutableList()
package com.redmagic.undefinedtoggles.exstions

import com.redmagic.undefinedapi.builders.ItemBuilder
import com.redmagic.undefinedapi.extension.string.toSmallText
import com.redmagic.undefinedapi.extension.string.translateColor
import com.redmagic.undefinedtoggles.UndefinedToggles
import org.bukkit.Material
import org.bukkit.entity.EntityType
import org.bukkit.entity.Item
import org.bukkit.inventory.ItemStack

fun Material.getSpawnEggItems(): MutableList<ItemStack> {
    return Material.entries
        .filter { it.name.contains("_SPAWN_EGG") }
        .mapNotNull {
            try {
                val entityType = EntityType.valueOf(it.name.removeSuffix("_SPAWN_EGG"))
                if (!UndefinedToggles.plugin.configManager.blocks.spawning.blockedMobs.contains(entityType)) {
                    ItemBuilder(it)
                        .setName("<reset><#42f5bf>${entityType.name.replace("_", " ").toSmallText()}".translateColor())
                        .addLine(" ")
                        .addLine("<reset><gray>ᴄʟɪᴄᴋ ᴛᴏ ᴀᴅᴅ ᴛᴏ ʙʟᴏᴄᴋ ᴇɴᴛɪᴛʏѕ".translateColor())
                        .setLocalizedName(entityType.name)
                        .build()
                } else null
            } catch (_: Exception) {
                null
            }
        }
        .toMutableList()
}

fun Material.getItemItems(): MutableList<ItemStack> {
    val mutableList: MutableList<ItemStack> = mutableListOf()
    Material.entries.forEach(){
        if (!UndefinedToggles.plugin.configManager.blocks.spawning.blockedItems.contains(it)){
            if (it.isItem){
                mutableList.add(ItemBuilder(it)
                    .setName("<reset><#f5e642>${it.name.replace("_", " ").toSmallText()}".translateColor())
                    .addLine(" ")
                    .setLocalizedName(it.name)
                    .addLine("<reset><gray>ᴄʟɪᴄᴋ ᴛᴏ ᴀᴅᴅ ᴛᴏ ʙʟᴏᴄᴋ ɪᴛᴇᴍѕ".translateColor()).build())
            }
        }
    }
    return mutableList
}

fun Material.getMaxAmount(): MutableList<ItemStack> {
    val mutableList: MutableList<ItemStack> = mutableListOf()
    Material.entries.forEach(){
        if (!UndefinedToggles.plugin.configManager.blocks.spawning.blockedItems.contains(it)){
            if (it.isItem){
                mutableList.add(ItemBuilder(it)
                    .setName("<reset><#ebb734>${it.name.replace("_", " ").toSmallText()}".translateColor())
                    .addLine(" ")
                    .setLocalizedName(it.name)
                    .addLine("<reset><gray>ᴄʟɪᴄᴋ ᴛᴏ ᴀᴅᴅ ɴᴇᴡ ᴍᴀx ᴀᴍᴏᴜɴᴛ".translateColor()).build())
            }
        }
    }
    return mutableList
}
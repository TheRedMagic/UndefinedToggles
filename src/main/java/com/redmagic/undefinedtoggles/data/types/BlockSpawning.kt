package com.redmagic.undefinedtoggles.data.types

import com.redmagic.undefinedapi.builders.ItemBuilder
import com.redmagic.undefinedapi.extension.string.toSmallText
import com.redmagic.undefinedapi.extension.string.translateColor
import com.redmagic.undefinedtoggles.UndefinedToggles
import org.bukkit.Material
import org.bukkit.entity.EntityType
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.SpawnEggMeta

class BlockSpawning(val blockedMobs: MutableList<EntityType>, val blockedItems: MutableList<Material>, private val plugin: UndefinedToggles) {

    fun save(){

        val entityList: MutableList<String> = mutableListOf()

        val materialList: MutableList<String> = mutableListOf()

        blockedMobs.forEach {
            entityList.add(it.name)
        }

        blockedItems.forEach {
            materialList.add(it.name)
        }

        plugin.configuration.set("blocked.spawning.mobs", entityList)
        plugin.configuration.set("blocked.spawning.items", materialList)

    }

}


fun MutableList<EntityType>.toItemStackList(): MutableList<ItemStack> =
    this.map {
        var material = getMaterials(it)
        if (material == null) material = Material.ALLAY_SPAWN_EGG
        ItemBuilder(material)
            .setName("<reset><#42f5bf>${it.name.replace("_", " ").toSmallText()}".translateColor())
            .addLine(" ")
            .addLine("<reset><gray>ᴄʟɪᴄᴋ ᴛᴏ ʀᴇᴍᴏᴠᴇ ꜰʀᴏᴍ ʙʟᴏᴄᴋᴇᴅ ᴇɴᴛɪᴛʏѕ".translateColor())
            .setLocalizedName(it.name)
            .build()
    }.toMutableList()

private fun getMaterials(entityType: EntityType): Material? = Material.entries.filter { it.name.contains("_SPAWN_EGG") && it.name.contains(entityType.name) }[0]

fun MutableList<Material>.toItemStackMaterialList(): MutableList<ItemStack> = this.map {
    ItemBuilder(it)
        .setName("<reset><#f5e642>${it.name.replace("_", " ").toSmallText()}".translateColor())
        .addLine(" ")
        .addLine("<reset><gray>ᴄʟɪᴄᴋ ᴛᴏ ʀᴇᴍᴏᴠᴇ ꜰʀᴏᴍ ʙʟᴏᴄᴋᴇᴅ ɪᴛᴇᴍѕ".translateColor())
        .setLocalizedName(it.name)
        .build()
}.toMutableList()
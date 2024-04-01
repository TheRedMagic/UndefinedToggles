package com.redmagic.undefinedtoggles.data.types

import com.redmagic.undefinedtoggles.UndefinedToggles
import org.bukkit.Material
import org.bukkit.entity.EntityType

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
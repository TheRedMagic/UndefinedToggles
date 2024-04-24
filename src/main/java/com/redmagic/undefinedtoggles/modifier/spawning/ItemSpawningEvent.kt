package com.redmagic.undefinedtoggles.modifier.spawning

import com.redmagic.undefinedapi.event.event
import com.redmagic.undefinedtoggles.UndefinedToggles
import org.bukkit.event.world.LootGenerateEvent
import org.bukkit.inventory.ItemStack

class ItemSpawningEvent {

    init {

        event<LootGenerateEvent> {

            val removeList: MutableList<ItemStack> = mutableListOf()

            loot.forEach(){
                if (it != null){
                   if (UndefinedToggles.plugin.configManager.blocks.spawning.blockedItems.contains(it.type)){
                       removeList.add(it)
                   }
                }
            }

            removeList.forEach() {
                loot.remove(it)
            }

            removeList.clear()

        }

    }

}
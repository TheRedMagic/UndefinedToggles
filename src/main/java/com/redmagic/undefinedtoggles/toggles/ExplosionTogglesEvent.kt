package com.redmagic.undefinedtoggles.toggles

import com.redmagic.undefinedapi.event.event
import com.redmagic.undefinedtoggles.UndefinedToggles
import org.bukkit.Material
import org.bukkit.entity.EntityType
import org.bukkit.event.entity.EntityExplodeEvent

class ExplosionTogglesEvent {

    init {
        event<EntityExplodeEvent> {
            if (entityType == EntityType.PRIMED_TNT && UndefinedToggles.plugin.configManager.toggles.tntBlockDamage){
                blockList().clear()
            }
        }
    }
}
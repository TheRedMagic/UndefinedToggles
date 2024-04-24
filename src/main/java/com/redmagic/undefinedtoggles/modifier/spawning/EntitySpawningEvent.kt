package com.redmagic.undefinedtoggles.modifier.spawning

import com.redmagic.undefinedapi.event.event
import com.redmagic.undefinedtoggles.UndefinedToggles
import org.bukkit.event.entity.EntitySpawnEvent

class EntitySpawningEvent {

    init {

        event<EntitySpawnEvent> {

            if (UndefinedToggles.plugin.configManager.blocks.spawning.blockedMobs.contains(entityType))
                isCancelled = true

        }

    }

}
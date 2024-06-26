package com.redmagic.undefinedtoggles.modifier.reduction

import com.redmagic.undefinedapi.event.event
import com.redmagic.undefinedapi.extension.isNegative
import com.redmagic.undefinedtoggles.UndefinedToggles
import org.bukkit.Bukkit
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.event.entity.EntityDamageEvent

class EntityReductionEvent {

    init {

        event<EntityDamageByEntityEvent> {

            val reduction = UndefinedToggles.plugin.configManager.reduction.getRedctionFromEntityType(damager.type) ?: return@event

            if (reduction.isNegative()){
                return@event
            }
            val reducedDamage: Double = damage * (1 - (reduction / 100))
            this.damage = reducedDamage
        }

        event<EntityDamageEvent> {

            if (cause != EntityDamageEvent.DamageCause.FALL){
                return@event
            }

            val reduction = UndefinedToggles.plugin.configManager.reduction.fallDamage

            if (reduction.isNegative()){
                return@event
            }

            val reductionDamage = damage * (1 - (reduction / 100))
            damage = reductionDamage
        }

    }

}
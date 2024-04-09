package com.redmagic.undefinedtoggles.toggles

import com.redmagic.undefinedapi.event.event
import com.redmagic.undefinedapi.scheduler.delay
import com.redmagic.undefinedtoggles.UndefinedToggles
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.entity.EntityToggleGlideEvent
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.inventory.EquipmentSlot

class ElytraTogglesEvent {

    init {

        event<EntityToggleGlideEvent> {
            val player = entity as Player
            if (UndefinedToggles.plugin.configManager.toggles.allowElytra){
                delay(1) { player.isGliding = false }
            }
        }

        event<PlayerInteractEvent> {

            if (!player.isGliding) return@event
            if (!UndefinedToggles.plugin.configManager.toggles.allowFireworksWithElytra) return@event
            val currentItem = when (hand) {
                EquipmentSlot.OFF_HAND -> player.inventory.itemInOffHand
                else -> player.inventory.itemInMainHand
            }
            if (currentItem.type != Material.FIREWORK_ROCKET) return@event

            isCancelled = true


        }

    }

}
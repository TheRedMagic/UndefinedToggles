package com.redmagic.undefinedtoggles.modifier.reduction

import com.redmagic.undefinedapi.event.event
import com.redmagic.undefinedapi.extension.isNegative
import com.redmagic.undefinedapi.scheduler.delay
import com.redmagic.undefinedtoggles.UndefinedToggles
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.EventPriority
import org.bukkit.event.entity.EntityDamageEvent
import org.bukkit.event.entity.EntityDamageEvent.DamageCause
import org.bukkit.event.player.PlayerInteractEvent

class BlockReductionEvent {

    init {

        val map: HashMap<Location, Material> = hashMapOf()



        event<EntityDamageEvent>(priority = EventPriority.HIGHEST) {

            if (entity !is Player) return@event


            if (cause != DamageCause.BLOCK_EXPLOSION){
                return@event
            }

            map.entries.forEach {
                if (it.key.distance(entity.location) < 7.5){


                    val reduction = if (it.value == Material.RESPAWN_ANCHOR) UndefinedToggles.plugin.configManager.reduction.anchors else UndefinedToggles.plugin.configManager.reduction.bedExplosions

                    val reductionDamage = damage * (1 - (reduction / 100))
                    damage = reductionDamage
                    return@event
                }
            }
        }

        event<PlayerInteractEvent>(priority = EventPriority.LOWEST) {
            if (clickedBlock == null){
                return@event
            }
            if (UndefinedToggles.plugin.configManager.reduction.bedExplosions.isNegative() && UndefinedToggles.plugin.configManager.reduction.anchors.isNegative()){
                return@event
            }
            if (clickedBlock!!.type == Material.RESPAWN_ANCHOR || clickedBlock!!.type.name.contains("BED")){
                val location = clickedBlock!!.location
                map[location] = clickedBlock!!.type
                delay(2) { map.remove(location) }
            }
        }

    }

}
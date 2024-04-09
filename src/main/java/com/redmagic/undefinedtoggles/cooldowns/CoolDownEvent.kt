package com.redmagic.undefinedtoggles.cooldowns

import com.redmagic.undefinedapi.event.event
import com.redmagic.undefinedapi.extension.isNegative
import com.redmagic.undefinedapi.scheduler.delay
import com.redmagic.undefinedtoggles.UndefinedToggles
import org.bukkit.Material
import org.bukkit.entity.EnderPearl
import org.bukkit.entity.Player
import org.bukkit.event.entity.ProjectileLaunchEvent
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.inventory.EquipmentSlot
import java.util.UUID

class CoolDownEvent {


    init {

        // Mutable Set for storing player IDs to avoid multiple event triggers
        val players = mutableSetOf<UUID>()

        // Map of players to keep track of last interacted item
        val playerItems = mutableMapOf<UUID, Material>()

        // Set of restricted items that do not induce any interaction effect
        val restrictedItems = setOf(Material.AIR, Material.BOW, Material.TRIDENT, Material.CROSSBOW)

        // Event handler for player interactions
        event<PlayerInteractEvent> {
            val player = this.player

            // If player has already been interacted then return
            if (players.contains(player.uniqueId)) return@event

            players.apply {
                // Add player ID to the interacted players set
                add(player.uniqueId)
                // Remove player ID from the interacted players set after 1 unit delay
                delay(1) { remove(player.uniqueId) }
            }

            // Fetch the proper item player is interacting with
            val currentItem = when (hand) {
                EquipmentSlot.OFF_HAND -> player.inventory.itemInOffHand
                else -> player.inventory.itemInMainHand
            }

            // Associate the player with the interacted item
            playerItems[player.uniqueId] = currentItem.type

            // If the interacted item is in the list of restricted items then return
            if (currentItem.type in restrictedItems) return@event

            // Fetch the cooldown period associated with the current interacted item type
            val cooldown = UndefinedToggles.plugin.configManager.cooldowns.getCooldownFromMaterial(currentItem.type)

            // If the cooldown is not null and not negative, then apply cooldown to the player
            cooldown?.takeUnless { it.isNegative() }?.let {
                // If player is already in cooldown mode then cancel the interaction
                if (player.getCooldown(currentItem.type) > 0) {
                    isCancelled = true
                    return@event
                }
                // Apply the cooldown to the player after 1 unit delay
                delay(1) { player.setCooldown(currentItem.type, (it * 20).toInt()) }
            }
        }

        // Event handler for projectile launch
        event<ProjectileLaunchEvent> {
            // If entity shooter is not a player then return from the event
            val player = entity.shooter as? Player ?: return@event

            // Fetch the last interacted item type of the player
            val lastItem = playerItems[player.uniqueId] ?: return@event

            // Fetch the cooldown period associated with the last interacted item type
            val cooldown = UndefinedToggles.plugin.configManager.cooldowns.getCooldownFromMaterial(lastItem)

            // If the cooldown is not null and not negative, then apply cooldown to the player
            cooldown?.takeUnless { it.isNegative() }?.let {
                // If player is already in cooldown mode then cancel the interaction
                if (player.getCooldown(lastItem) > 0) {
                    isCancelled = true
                    return@event
                }
                // Apply the cooldown to the player after 1 unit delay
                delay(1) { player.setCooldown(lastItem, (it * 20).toInt()) }
            }
        }

    }



}
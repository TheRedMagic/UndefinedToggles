package com.redmagic.undefinedtoggles.modifier.maxAmount

import com.redmagic.undefinedapi.event.event
import com.redmagic.undefinedapi.extension.isNegative
import com.redmagic.undefinedapi.extension.isPositive
import com.redmagic.undefinedapi.extension.string.getAmountOf
import com.redmagic.undefinedtoggles.UndefinedToggles
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.entity.Player
import org.bukkit.event.entity.EntityPickupItemEvent
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.inventory.InventoryType
import org.bukkit.event.player.PlayerPickupItemEvent
import org.bukkit.inventory.ItemStack

class MaxAmountEvent {

    init {

        event<EntityPickupItemEvent> {

            val player = entity as Player ?: return@event

            val type = this.item.itemStack.type

            val maxAmount = UndefinedToggles.plugin.configManager.maxAmount.maxAmount[type] ?: return@event

            val inInventory = player.inventory.getAmountOf(type)

            val amount = item.itemStack.amount

            if (inInventory + amount > maxAmount) {
                val amountToPickUp = maxAmount - inInventory

                val itemGive = item.itemStack.clone()
                itemGive.amount = amountToPickUp

                // Pick up only the amount that would make the total items in inventory equals maxAmount
                player.inventory.addItem(itemGive)
                // reduce the amount on ground
                item.itemStack.amount = amount - amountToPickUp
                isCancelled = true
            }

        }

        event<InventoryClickEvent> {

            if (clickedInventory == null) {
                return@event
            }

            if (clickedInventory!!.type != InventoryType.PLAYER) {
                return@event
            }

            val player = whoClicked as Player ?: return@event
            val type = cursor?.type ?: return@event
            val amount = cursor!!.amount

            val maxAmount = UndefinedToggles.plugin.configManager.maxAmount.maxAmount[type] ?: return@event

            val inInventory = player.inventory.getAmountOf(type)

            if (inInventory + amount <= maxAmount) {
                // If total amount doesn't exceed maxAmount, just let event proceed as normal
                return@event
            } else {
                // Cancel event and adjust behaviour
                isCancelled = true

                val amountToAllow = maxAmount - inInventory
                // Adjust cursor amount to the allowed amount
                cursor!!.amount = amount - amountToAllow

                // Add allowed amount to inventory slot
                val slotIndex = rawSlot
                val existingStack: ItemStack? = player.inventory.getItem(slotIndex)
                if (existingStack == null) {

                    val item = cursor!!.clone()
                    item.amount = amountToAllow

                    player.inventory.setItem(slotIndex, item)
                } else {

                    existingStack.amount += amountToAllow
                }
            }

        }

    }
}
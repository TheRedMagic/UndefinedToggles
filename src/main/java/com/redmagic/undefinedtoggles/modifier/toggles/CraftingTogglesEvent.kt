package com.redmagic.undefinedtoggles.modifier.toggles

import com.redmagic.undefinedapi.event.event
import com.redmagic.undefinedtoggles.UndefinedToggles
import org.bukkit.Material
import org.bukkit.event.inventory.PrepareItemCraftEvent
import org.bukkit.inventory.ItemStack

class CraftingTogglesEvent {

    init {

        event<PrepareItemCraftEvent> {

            val itemType = recipe?.result?.type ?: return@event

            if (itemType.name.contains("TRIM") && UndefinedToggles.plugin.configManager.toggles.armorTrimsCopying ||
                itemType == Material.NETHERITE_UPGRADE_SMITHING_TEMPLATE && UndefinedToggles.plugin.configManager.toggles.upgradeTemplateCopying)
                inventory.result = ItemStack(Material.AIR)

        }

    }
}
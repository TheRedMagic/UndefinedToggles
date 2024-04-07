package com.redmagic.undefinedtoggles.gui.admin.sub

import com.redmagic.undefinedapi.builders.ItemBuilder
import com.redmagic.undefinedapi.extension.string.translateColor
import com.redmagic.undefinedapi.menu.MenuSize
import com.redmagic.undefinedapi.menu.normal.UndefinedMenu
import com.redmagic.undefinedapi.menu.normal.button.Button
import com.redmagic.undefinedapi.menu.normal.button.MenuButton
import com.redmagic.undefinedtoggles.UndefinedToggles
import org.bukkit.Material
import org.bukkit.inventory.Inventory

class TogglesGUI(private val plugin: UndefinedToggles): UndefinedMenu("ᴛᴏɢɢʟᴇѕ", MenuSize.MINI) {

    override fun generateInventory(): Inventory = createInventory {

        fillEmpty(ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build())

        setItem(18, ItemBuilder(Material.RED_STAINED_GLASS_PANE)
            .setName("<reset><#d92323>ʙᴀᴄᴋ ᴛᴏ ᴀᴅᴍɪɴ ᴍᴇɴᴜ".translateColor())
            .addLine(" ")
            .addLine("<reset><gray>ᴄʟɪᴄᴋ ᴛᴏ ɢᴏ ʙᴀᴄᴋ ᴛᴏ ᴀᴅᴍɪɴ ᴍᴇɴᴜ".translateColor()).build())

        addButton(MenuButton(18, plugin.guiManager.adminGUI){})

        setArmorTrimsCopyingItem(this)
        setUpgradeTemplateItem(this)
        setVillagerChangeWork(this)
        setTnTBlockDamage(this)
        setElytra(this)
        setElytraFireWork(this)

        addButton(Button(10){
            plugin.configManager.toggles.armorTrimsCopying = !plugin.configManager.toggles.armorTrimsCopying
            setArmorTrimsCopyingItem(this@createInventory)
        })
        addButton(Button(11){
            plugin.configManager.toggles.upgradeTemplateCopying = !plugin.configManager.toggles.upgradeTemplateCopying
            setUpgradeTemplateItem(this@createInventory)
        })
        addButton(Button(12){
            plugin.configManager.toggles.villagerChangeTrade = !plugin.configManager.toggles.villagerChangeTrade
            setVillagerChangeWork(this@createInventory)
        })
        addButton(Button(14){
            plugin.configManager.toggles.tntBlockDamage = !plugin.configManager.toggles.tntBlockDamage
            setTnTBlockDamage(this@createInventory)
        })
        addButton(Button(15){
            plugin.configManager.toggles.allowElytra = !plugin.configManager.toggles.allowElytra
            setElytra(this@createInventory)
        })
        addButton(Button(16){
            plugin.configManager.toggles.allowFireworksWithElytra = !plugin.configManager.toggles.allowFireworksWithElytra
            setElytraFireWork(this@createInventory)
        })

    }

    private fun toggleMessage(boolean: Boolean): String = if (boolean){ "<reset><#32e67d>ʙʟᴏᴄᴋᴇᴅ".translateColor() } else "<reset><#d92323>ɴᴏᴛ ᴍᴏᴅɪꜰɪᴇᴅ".translateColor()

    private fun toggleMaterial(boolean: Boolean): Material = if (boolean){ Material.LIME_CONCRETE }else Material.RED_CONCRETE

    private fun setArmorTrimsCopyingItem(inventory: Inventory){
        inventory.setItem(10, ItemBuilder(toggleMaterial(plugin.configManager.toggles.armorTrimsCopying))
            .setName("<reset><#11ed61>ᴄᴏᴘʏɪɴɢ ᴀʀᴍᴏʀ ᴛʀɪᴍѕ".translateColor())
            .setLore(mutableListOf())
            .addLine(" ")
            .addLine("<gray>ʙʟᴏᴄᴋ ᴄᴏᴘʏɪɴɢ ᴀʀᴍᴏʀ ᴛʀɪᴍѕ ɪɴ ᴄʀᴀꜰᴛɪɴɢ ᴛᴀʙʟᴇ".translateColor())
            .addLine(" ")
            .addLine(toggleMessage(plugin.configManager.toggles.armorTrimsCopying))
            .addLine(" ")
            .addLine("<reset><gray>ᴄʟɪᴄᴋ ᴛᴏ ᴛᴏɢɢʟᴇ".translateColor()).build())
    }

    private fun setUpgradeTemplateItem(inventory: Inventory){
        inventory.setItem(11, ItemBuilder(toggleMaterial(plugin.configManager.toggles.upgradeTemplateCopying))
            .setName("<reset><#e86925>ᴄᴏᴘʏɪɴɢ ᴜᴘɢʀᴀᴅᴇ ᴛᴇᴍᴘʟᴀᴛᴇ".translateColor())
            .setLore(mutableListOf())
            .addLine(" ")
            .addLine("<gray>ʙʟᴏᴄᴋ ᴄᴏᴘʏɪɴɢ ᴏꜰ ᴜᴘɢʀᴀᴅᴇ ᴛᴇᴍᴘʟᴀᴛᴇ ɪɴ ᴄʀᴀꜰᴛɪɴɢ ᴛᴀʙʟᴇ".translateColor())
            .addLine(" ")
            .addLine(toggleMessage(plugin.configManager.toggles.upgradeTemplateCopying))
            .addLine(" ")
            .addLine("<reset><gray>ᴄʟɪᴄᴋ ᴛᴏ ᴛᴏɢɢʟᴇ".translateColor()).build())
    }
    private fun setVillagerChangeWork(inventory: Inventory){
        inventory.setItem(12, ItemBuilder(toggleMaterial(plugin.configManager.toggles.villagerChangeTrade))
            .setName("<reset><#42f551>ᴠɪʟʟᴀɢᴇʀ ᴄʜᴀɴɢɪɴɢ ᴡᴏʀᴋ".translateColor())
            .setLore(mutableListOf())
            .addLine(" ")
            .addLine("<gray>ʙʟᴏᴄᴋ ᴠɪʟʟᴀɢᴇʀѕ ꜰʀᴏᴍ ᴄʜᴀɴɢɪɴɢ ᴡᴏʀᴋ".translateColor())
            .addLine(" ")
            .addLine(toggleMessage(plugin.configManager.toggles.villagerChangeTrade))
            .addLine(" ")
            .addLine("<reset><gray>ᴄʟɪᴄᴋ ᴛᴏ ᴛᴏɢɢʟᴇ".translateColor()).build())
    }

    private fun setTnTBlockDamage(inventory: Inventory){
        inventory.setItem(14, ItemBuilder(toggleMaterial(plugin.configManager.toggles.tntBlockDamage))
            .setName("<reset><#e64229>ᴛɴᴛ ʙʟᴏᴄᴋ ᴅᴀᴍᴀɢᴇ".translateColor())
            .setLore(mutableListOf())
            .addLine(" ")
            .addLine("<gray>ʙʟᴏᴄᴋ ᴛɴᴛ ꜰʀᴏᴍ ᴅᴏɪɴɢ ʙʟᴏᴄᴋ ᴅᴀᴍᴀɢᴇ".translateColor())
            .addLine(" ")
            .addLine(toggleMessage(plugin.configManager.toggles.tntBlockDamage))
            .addLine(" ")
            .addLine("<reset><gray>ᴄʟɪᴄᴋ ᴛᴏ ᴛᴏɢɢʟᴇ".translateColor()).build())
    }

    private fun setElytra(inventory: Inventory){
        inventory.setItem(15, ItemBuilder(toggleMaterial(plugin.configManager.toggles.allowElytra))
            .setName("<reset><#791df2>ᴇʟʏᴛʀᴀ".translateColor())
            .setLore(mutableListOf())
            .addLine(" ")
            .addLine("<gray>ʙʟᴏᴄᴋ ᴛʜᴇ ᴜѕᴇ ᴏꜰ ᴇʟʏᴛʀᴀѕ".translateColor())
            .addLine(" ")
            .addLine(toggleMessage(plugin.configManager.toggles.allowElytra))
            .addLine(" ")
            .addLine("<reset><gray>ᴄʟɪᴄᴋ ᴛᴏ ᴛᴏɢɢʟᴇ".translateColor()).build())
    }
    private fun setElytraFireWork(inventory: Inventory){
        inventory.setItem(16, ItemBuilder(toggleMaterial(plugin.configManager.toggles.allowFireworksWithElytra))
            .setName("<reset><#1576ed>ꜰɪʀᴇᴡᴏʀᴋ ʙᴏᴏѕᴛ".translateColor())
            .setLore(mutableListOf())
            .addLine(" ")
            .addLine("<gray>ʙʟᴏᴄᴋ ꜰɪʀᴇᴡᴏʀᴋ ꜰʀᴏᴍ ʙᴏᴏѕᴛɪɴɢ ᴡɪᴛʜ ᴇʟʏᴛʀᴀ".translateColor())
            .addLine(" ")
            .addLine(toggleMessage(plugin.configManager.toggles.allowFireworksWithElytra))
            .addLine(" ")
            .addLine("<reset><gray>ᴄʟɪᴄᴋ ᴛᴏ ᴛᴏɢɢʟᴇ".translateColor()).build())
    }
}
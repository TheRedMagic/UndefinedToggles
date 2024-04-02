package com.redmagic.undefinedtoggles.gui.admin.sub

import com.redmagic.undefinedapi.builders.ItemBuilder
import com.redmagic.undefinedapi.extension.string.toComponent
import com.redmagic.undefinedapi.menu.MenuSize
import com.redmagic.undefinedapi.menu.normal.UndefinedMenu
import com.redmagic.undefinedapi.menu.normal.button.Button
import com.redmagic.undefinedapi.menu.normal.button.MenuButton
import com.redmagic.undefinedtoggles.UndefinedToggles
import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.entity.Item
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemFlag

class TogglesGUI(private val plugin: UndefinedToggles): UndefinedMenu("ᴛᴏɢɢʟᴇѕ", MenuSize.MINI) {

    override fun generateInventory(): Inventory = createInventory {

        fillEmpty(ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build())

        setItem(18, ItemBuilder(Material.RED_STAINED_GLASS_PANE)
            .setName("<!i><#d92323>ʙᴀᴄᴋ ᴛᴏ ᴀᴅᴍɪɴ ᴍᴇɴᴜ".toComponent())
            .addLine(" ".toComponent())
            .addLine("<!i><gray>ᴄʟɪᴄᴋ ᴛᴏ ɢᴏ ʙᴀᴄᴋ ᴛᴏ ᴀᴅᴍɪɴ ᴍᴇɴᴜ".toComponent()).build())

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

    private fun toggleMessage(boolean: Boolean): Component = if (boolean){ "<!i><#32e67d>ʙʟᴏᴄᴋᴇᴅ".toComponent() } else "<!i><#d92323>ɴᴏᴛ ᴍᴏᴅɪꜰɪᴇᴅ".toComponent()

    private fun toggleMaterial(boolean: Boolean): Material = if (boolean){ Material.LIME_CONCRETE }else Material.RED_CONCRETE

    private fun setArmorTrimsCopyingItem(inventory: Inventory){
        inventory.setItem(10, ItemBuilder(toggleMaterial(plugin.configManager.toggles.armorTrimsCopying))
            .setName("<!i><#11ed61>ᴄᴏᴘʏɪɴɢ ᴀʀᴍᴏʀ ᴛʀɪᴍѕ".toComponent())
            .setLore(mutableListOf())
            .addLine(" ".toComponent())
            .addLine("<gray>ʙʟᴏᴄᴋ ᴄᴏᴘʏɪɴɢ ᴀʀᴍᴏʀ ᴛʀɪᴍѕ ɪɴ ᴄʀᴀꜰᴛɪɴɢ ᴛᴀʙʟᴇ".toComponent())
            .addLine(" ".toComponent())
            .addLine(toggleMessage(plugin.configManager.toggles.armorTrimsCopying))
            .addLine(" ".toComponent())
            .addLine("<!i><gray>ᴄʟɪᴄᴋ ᴛᴏ ᴛᴏɢɢʟᴇ".toComponent()).build())
    }

    private fun setUpgradeTemplateItem(inventory: Inventory){
        inventory.setItem(11, ItemBuilder(toggleMaterial(plugin.configManager.toggles.upgradeTemplateCopying))
            .setName("<!i><#e86925>ᴄᴏᴘʏɪɴɢ ᴜᴘɢʀᴀᴅᴇ ᴛᴇᴍᴘʟᴀᴛᴇ".toComponent())
            .setLore(mutableListOf())
            .addLine(" ".toComponent())
            .addLine("<gray>ʙʟᴏᴄᴋ ᴄᴏᴘʏɪɴɢ ᴏꜰ ᴜᴘɢʀᴀᴅᴇ ᴛᴇᴍᴘʟᴀᴛᴇ ɪɴ ᴄʀᴀꜰᴛɪɴɢ ᴛᴀʙʟᴇ".toComponent())
            .addLine(" ".toComponent())
            .addLine(toggleMessage(plugin.configManager.toggles.upgradeTemplateCopying))
            .addLine(" ".toComponent())
            .addLine("<!i><gray>ᴄʟɪᴄᴋ ᴛᴏ ᴛᴏɢɢʟᴇ".toComponent()).build())
    }
    private fun setVillagerChangeWork(inventory: Inventory){
        inventory.setItem(12, ItemBuilder(toggleMaterial(plugin.configManager.toggles.villagerChangeTrade))
            .setName("<!i><#42f551>ᴠɪʟʟᴀɢᴇʀ ᴄʜᴀɴɢɪɴɢ ᴡᴏʀᴋ".toComponent())
            .setLore(mutableListOf())
            .addLine(" ".toComponent())
            .addLine("<gray>ʙʟᴏᴄᴋ ᴠɪʟʟᴀɢᴇʀѕ ꜰʀᴏᴍ ᴄʜᴀɴɢɪɴɢ ᴡᴏʀᴋ".toComponent())
            .addLine(" ".toComponent())
            .addLine(toggleMessage(plugin.configManager.toggles.villagerChangeTrade))
            .addLine(" ".toComponent())
            .addLine("<!i><gray>ᴄʟɪᴄᴋ ᴛᴏ ᴛᴏɢɢʟᴇ".toComponent()).build())
    }

    private fun setTnTBlockDamage(inventory: Inventory){
        inventory.setItem(14, ItemBuilder(toggleMaterial(plugin.configManager.toggles.tntBlockDamage))
            .setName("<!i><#e64229>ᴛɴᴛ ʙʟᴏᴄᴋ ᴅᴀᴍᴀɢᴇ".toComponent())
            .setLore(mutableListOf())
            .addLine(" ".toComponent())
            .addLine("<gray>ʙʟᴏᴄᴋ ᴛɴᴛ ꜰʀᴏᴍ ᴅᴏɪɴɢ ʙʟᴏᴄᴋ ᴅᴀᴍᴀɢᴇ".toComponent())
            .addLine(" ".toComponent())
            .addLine(toggleMessage(plugin.configManager.toggles.tntBlockDamage))
            .addLine(" ".toComponent())
            .addLine("<!i><gray>ᴄʟɪᴄᴋ ᴛᴏ ᴛᴏɢɢʟᴇ".toComponent()).build())
    }

    private fun setElytra(inventory: Inventory){
        inventory.setItem(15, ItemBuilder(toggleMaterial(plugin.configManager.toggles.allowElytra))
            .setName("<!i><#791df2>ᴇʟʏᴛʀᴀ".toComponent())
            .setLore(mutableListOf())
            .addLine(" ".toComponent())
            .addLine("<gray>ʙʟᴏᴄᴋ ᴛʜᴇ ᴜѕᴇ ᴏꜰ ᴇʟʏᴛʀᴀѕ".toComponent())
            .addLine(" ".toComponent())
            .addLine(toggleMessage(plugin.configManager.toggles.allowElytra))
            .addLine(" ".toComponent())
            .addLine("<!i><gray>ᴄʟɪᴄᴋ ᴛᴏ ᴛᴏɢɢʟᴇ".toComponent()).build())
    }
    private fun setElytraFireWork(inventory: Inventory){
        inventory.setItem(16, ItemBuilder(toggleMaterial(plugin.configManager.toggles.allowFireworksWithElytra))
            .setName("<!i><#1576ed>ꜰɪʀᴇᴡᴏʀᴋ ʙᴏᴏѕᴛ".toComponent())
            .setLore(mutableListOf())
            .addLine(" ".toComponent())
            .addLine("<gray>ʙʟᴏᴄᴋ ꜰɪʀᴇᴡᴏʀᴋ ꜰʀᴏᴍ ʙᴏᴏѕᴛɪɴɢ ᴡɪᴛʜ ᴇʟʏᴛʀᴀ".toComponent())
            .addLine(" ".toComponent())
            .addLine(toggleMessage(plugin.configManager.toggles.allowFireworksWithElytra))
            .addLine(" ".toComponent())
            .addLine("<!i><gray>ᴄʟɪᴄᴋ ᴛᴏ ᴛᴏɢɢʟᴇ".toComponent()).build())
    }
}
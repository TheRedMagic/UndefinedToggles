package com.redmagic.undefinedtoggles.gui

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

class TogglesGUI(private val plugin: UndefinedToggles): UndefinedMenu("ᴛᴏɢɢʟᴇ ᴍᴇɴᴜ", MenuSize.MINI) {

    override fun generateInventory(): Inventory = createInventory {

        fillEmpty(ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build())

        setItem(18, ItemBuilder(Material.RED_STAINED_GLASS_PANE)
            .setName("<!i><#d92323>ʙᴀᴄᴋ ᴛᴏ ᴀᴅᴍɪɴ ᴍᴇɴᴜ".toComponent())
            .addLine(" ".toComponent())
            .addLine("<!i><gray>ᴄʟɪᴄᴋ ᴛᴏ ɢᴏ ʙᴀᴄᴋ ᴛᴏ ᴀᴅᴍɪɴ ᴍᴇɴᴜ".toComponent()).build())

        addButton(MenuButton(18, plugin.guiManager.adminGUI){})

        setArmorTrimsCopyingItem(this)
        setUpgradeTemplateItem(this)

        addButton(Button(10){
            plugin.configManager.toggles.armorTrimsCopying = !plugin.configManager.toggles.armorTrimsCopying
            setArmorTrimsCopyingItem(this@createInventory)
        })
        addButton(Button(11){
            plugin.configManager.toggles.upgradeTemplateCopying = !plugin.configManager.toggles.upgradeTemplateCopying
            setUpgradeTemplateItem(this@createInventory)
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
}
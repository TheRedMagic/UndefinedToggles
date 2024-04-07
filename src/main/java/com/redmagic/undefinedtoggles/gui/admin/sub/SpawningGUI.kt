package com.redmagic.undefinedtoggles.gui.admin.sub

import com.redmagic.undefinedapi.builders.ItemBuilder
import com.redmagic.undefinedapi.extension.string.translateColor
import com.redmagic.undefinedapi.menu.MenuManager.openMenu
import com.redmagic.undefinedapi.menu.MenuSize
import com.redmagic.undefinedapi.menu.normal.UndefinedMenu
import com.redmagic.undefinedapi.menu.normal.button.Button
import com.redmagic.undefinedapi.menu.normal.button.MenuButton
import com.redmagic.undefinedtoggles.UndefinedToggles
import com.redmagic.undefinedtoggles.data.types.toItemStackList
import com.redmagic.undefinedtoggles.data.types.toItemStackMaterialList
import com.redmagic.undefinedtoggles.gui.admin.sub.page.entity.BlockedEntityPageGUI
import com.redmagic.undefinedtoggles.gui.admin.sub.page.items.BlockedItemPageGUI
import org.bukkit.Material
import org.bukkit.inventory.Inventory

class SpawningGUI(private val plugin: UndefinedToggles): UndefinedMenu("ѕᴘᴀᴡɴɪɴɢ", MenuSize.MINI) {

    override fun generateInventory(): Inventory = createInventory {

        fillEmpty(ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build())

        setItem(18, ItemBuilder(Material.RED_STAINED_GLASS_PANE)
            .setName("<reset><#d92323>ʙᴀᴄᴋ ᴛᴏ ʙʟᴏᴄᴋᴇᴅ ᴍᴇɴᴜ".translateColor())
            .addLine(" ")
            .addLine("<gray>ᴄʟɪᴄᴋ ᴛᴏ ɢᴏ ʙᴀᴄᴋ ᴛᴏ ʙʟᴏᴄᴋᴇᴅ ᴍᴇɴᴜ".translateColor()).build())

        addButton(MenuButton(18, plugin.guiManager.blocksGUI){})

        setItem(11, ItemBuilder(Material.ALLAY_SPAWN_EGG)
            .setName("<reset><#9134ed>ᴇɴᴛɪᴛʏѕ".translateColor())
            .addLine(" ")
            .addLine("<reset><gray>ѕᴛᴏᴘᴘɪɴɢ ᴇɴᴛɪᴛʏ ꜰʀᴏᴍ ѕᴘᴀᴡɴɪɴɢ ɪɴ ᴛʜᴇ ᴡᴏʀʟᴅ".translateColor())
            .addLine(" ")
            .addLine("<reset><gray>ᴄʟɪᴄᴋ ᴛᴏ ᴠɪᴇᴡ / ᴇᴅɪᴛ ʙʟᴏᴄᴋᴇᴅ ᴇɴᴛɪᴛʏѕ".translateColor()).build())

        addButton(Button(11){

            player.openMenu(BlockedEntityPageGUI(plugin, plugin.configManager.blocks.spawning.blockedMobs.toItemStackList()))

        })

        setItem(15, ItemBuilder(Material.ENCHANTED_GOLDEN_APPLE)
            .setName("<reset><#7b42f5>ɪᴛᴇᴍѕ".translateColor())
            .addLine(" ")
            .addLine("<reset><gray>ѕᴛᴏᴘᴘɪɴɢ ɪᴛᴇᴍѕ ꜰʀᴏᴍ ɢᴇɴᴇʀᴀᴛɪɴɢ ɪɴ ᴛʜᴇ ᴡᴏʀʟᴅ".translateColor())
            .addLine(" ")
            .addLine("<reset><gray>ᴄʟɪᴄᴋ ᴛᴏ ᴠɪᴇᴡ / ᴇᴅɪᴛ ʙʟᴏᴄᴋᴇᴅ ɪᴛᴇᴍѕ".translateColor()).build())


        addButton(Button(15){

            player.openMenu(BlockedItemPageGUI(plugin, plugin.configManager.blocks.spawning.blockedItems.toItemStackMaterialList()))

        })
    }
}
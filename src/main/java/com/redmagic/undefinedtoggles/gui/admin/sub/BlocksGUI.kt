package com.redmagic.undefinedtoggles.gui.admin.sub

import com.redmagic.undefinedapi.builders.ItemBuilder
import com.redmagic.undefinedapi.extension.string.translateColor
import com.redmagic.undefinedapi.menu.MenuManager.openMenu
import com.redmagic.undefinedapi.menu.MenuSize
import com.redmagic.undefinedapi.menu.normal.UndefinedMenu
import com.redmagic.undefinedapi.menu.normal.button.Button
import com.redmagic.undefinedapi.menu.normal.button.MenuButton
import com.redmagic.undefinedapi.menu.presets.UndefinedDefaultPageMenu
import com.redmagic.undefinedtoggles.UndefinedToggles
import com.redmagic.undefinedtoggles.data.types.getList
import com.redmagic.undefinedtoggles.data.types.toItemStacks
import com.redmagic.undefinedtoggles.exstions.getMaxAmount
import com.redmagic.undefinedtoggles.gui.admin.sub.page.command.BlockedCommandPageGUI
import com.redmagic.undefinedtoggles.gui.admin.sub.page.maxAmount.MaxAmountChoosePageGUI
import com.redmagic.undefinedtoggles.gui.admin.sub.page.maxAmount.MaxAmountPageMenu
import net.wesjd.anvilgui.AnvilGUI
import org.bukkit.Material
import org.bukkit.inventory.Inventory

class BlocksGUI(private val plugin: UndefinedToggles): UndefinedMenu("ʙʟᴏᴄᴋᴇᴅѕ", MenuSize.MINI) {
    override fun generateInventory(): Inventory = createInventory {

        fillEmpty(ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build())

        setItem(
            18, ItemBuilder(Material.RED_STAINED_GLASS_PANE)
                .setName("<reset><#d92323>ʙᴀᴄᴋ ᴛᴏ ᴀᴅᴍɪɴ ᴍᴇɴᴜ".translateColor())
                .addLine(" ")
                .addLine("<reset><gray>ᴄʟɪᴄᴋ ᴛᴏ ɢᴏ ʙᴀᴄᴋ ᴛᴏ ᴀᴅᴍɪɴ ᴍᴇɴᴜ".translateColor()).build()
        )

        addButton(MenuButton(18, plugin.guiManager.adminGUI) {})

        setItem(11, ItemBuilder(Material.OAK_SIGN)
            .setName("<reset><#1d7ff0>ᴄᴏᴍᴍᴀɴᴅѕ".translateColor())
            .addLine(" ")
            .addLine("<reset><gray>ʙʟᴏᴄᴋ ᴄᴏᴍᴍᴀɴᴅ ᴀɴᴅ ᴛᴀʙ ᴄᴏᴍᴘʟᴇᴛɪᴏɴ".translateColor())
            .addLine(" ")
            .addLine("<reset><gray>ᴄʟɪᴄᴋ ᴛᴏ ᴏᴘᴇɴ ᴄᴏᴍᴍᴀɴᴅѕ ʙʟᴏᴄᴋᴇᴅ ᴍᴇɴᴜ".translateColor()).build())

        addButton(Button(11){
            player.openMenu(BlockedCommandPageGUI(plugin.configManager.blocks.blockedCommands.getList(), plugin))
        })

        addButton(Button(13){
            player.openMenu(plugin.guiManager.spawningGUI)
        })

        setItem(13, ItemBuilder(Material.ALLAY_SPAWN_EGG)
            .setName("<reset><#9134ed>ѕᴘᴀᴡɴɪɴɢ".translateColor())
            .addLine(" ")
            .addLine("<reset><gray>ʙʟᴏᴄᴋ ᴇɴᴛɪᴛʏ ᴀɴᴅ ɪᴛᴇᴍѕ ꜰʀᴏᴍ ɢᴇɴᴇʀᴀᴛɪɴɢ".translateColor())
            .addLine(" ")
            .addLine("<reset><gray>ᴄʟɪᴄᴋ ᴛᴏ ᴏᴘᴇɴ ѕᴘᴀᴡɴᴇʀ ʙʟᴏᴄᴋᴇᴅ ᴍᴇɴᴜ".translateColor()).build())

        setItem(15, ItemBuilder(Material.REDSTONE_BLOCK)
            .setName("<reset><#ed9134>ᴍᴀx ᴀᴍᴏᴜɴᴛ".translateColor())
            .addLine(" ")
            .addLine("<reset><gray>ʙʟᴏᴄᴋ ᴛʜᴇ ᴀᴍᴏᴜɴᴛ ᴏꜰ ᴀɴ ɪᴛᴇᴍ ɪɴ ᴀ ɪɴᴠᴇɴᴛᴏʀʏ".translateColor())
            .addLine(" ")
            .addLine("<reset><gray>ᴄʟɪᴄᴋ ᴛᴏ ᴏᴘᴇɴ ᴍᴀx ᴀᴍᴏᴜɴᴛ ᴍᴇɴᴜ".translateColor()).build())

        addButton(Button(15){

            player.openMenu(MaxAmountPageMenu(plugin, plugin.configManager.maxAmount.maxAmount.toItemStacks()))

        })

    }

}
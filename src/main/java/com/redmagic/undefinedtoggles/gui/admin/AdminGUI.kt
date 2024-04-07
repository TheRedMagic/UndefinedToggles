package com.redmagic.undefinedtoggles.gui.admin

import com.redmagic.undefinedapi.builders.ItemBuilder
import com.redmagic.undefinedapi.extension.string.translateColor
import com.redmagic.undefinedapi.menu.MenuManager.openMenu
import com.redmagic.undefinedapi.menu.MenuSize
import com.redmagic.undefinedapi.menu.normal.UndefinedMenu
import com.redmagic.undefinedapi.menu.normal.button.Button
import com.redmagic.undefinedtoggles.UndefinedToggles
import org.bukkit.Material
import org.bukkit.inventory.Inventory

class AdminGUI(private val plugin: UndefinedToggles): UndefinedMenu("ᴀᴅᴍɪɴ ᴛᴏɢɢʟᴇѕ", MenuSize.MINI) {

    override fun generateInventory(): Inventory = createInventory {

        fillEmpty(ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build())

        setItem(10, ItemBuilder(Material.CLOCK)
            .setName("<reset><#fcd63a>ᴄᴏᴏʟᴅᴏᴡɴѕ".translateColor())
            .addLine(" ")
            .addLine("<reset><gray>ᴄʟɪᴄᴋ ᴛᴏ ᴇᴅɪᴛ ᴄᴏᴏʟᴅᴏᴡɴѕ".translateColor()).build())


        setItem(
            12, ItemBuilder(Material.LEVER)
                .setName("<reset><#f00e0e>ᴛᴏɢɢʟᴇѕ".translateColor())
                .addLine(" ")
                .addLine("<reset><gray>ᴄʟɪᴄᴋ ᴛᴏ ᴇᴅɪᴛ ᴛᴏɢɢʟᴇѕ".translateColor()).build()
        )

        setItem(
            14, ItemBuilder(Material.REPEATER)
                .setName("<reset><#08bd77>ʀᴇᴅᴜᴄᴛɪᴏɴ".translateColor())
                .addLine(" ")
                .addLine("<reset><gray>ᴄʟɪᴄᴋ ᴛᴏ ᴇᴅɪᴛ ᴛʜᴇ ʀᴇᴅᴜᴄᴛɪᴏɴ".translateColor()).build()
        )

        setItem(
            16, ItemBuilder(Material.BARRIER)
                .setName("<reset><#1fc0ed>ʙʟᴏᴄᴋѕ".translateColor())
                .addLine(" ")
                .addLine("<reset><gray>ᴄʟɪᴄᴋ ᴛᴏ ᴇᴅɪᴛ ᴛʜᴇ ʙʟᴏᴄᴋѕ".translateColor()).build()
        )


        addButton(Button(10){
            player.openMenu(plugin.guiManager.cooldownGUI)
        })

        addButton(Button(12){
            player.openMenu(plugin.guiManager.togglesGUI)
        })

        addButton(Button(14){
            player.openMenu(plugin.guiManager.reductionGUI)
        })

        addButton(Button(16){
            player.openMenu(plugin.guiManager.blocksGUI)
        })

    }
}
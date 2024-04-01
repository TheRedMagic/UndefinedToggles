package com.redmagic.undefinedtoggles.gui

import com.redmagic.undefinedapi.builders.ItemBuilder
import com.redmagic.undefinedapi.extension.string.toComponent
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
            .setName("<!i><#fcd63a>ᴄᴏᴏʟᴅᴏᴡɴѕ".toComponent())
            .addLine(" ".toComponent())
            .addLine("<!i><gray>ᴄʟɪᴄᴋ ᴛᴏ ᴇᴅɪᴛ ᴄᴏᴏʟᴅᴏᴡɴѕ".toComponent()).build())


        setItem(
            12, ItemBuilder(Material.LEVER)
                .setName("<!i><#f00e0e>ᴛᴏɢɢʟᴇѕ".toComponent())
                .addLine(" ".toComponent())
                .addLine("<!i><gray>ᴄʟɪᴄᴋ ᴛᴏ ᴇᴅɪᴛ ᴛᴏɢɢʟᴇѕ".toComponent()).build()
        )

        setItem(
            14, ItemBuilder(Material.REPEATER)
                .setName("<!i><#08bd77>ʀᴇᴅᴜᴄᴛɪᴏɴ".toComponent())
                .addLine(" ".toComponent())
                .addLine("<!i><gray>ᴄʟɪᴄᴋ ᴛᴏ ᴇᴅɪᴛ ᴛʜᴇ ʀᴇᴅᴜᴄᴛɪᴏɴ".toComponent()).build()
        )

        setItem(
            16, ItemBuilder(Material.BARRIER)
                .setName("<!i><#1fc0ed>ʙʟᴏᴄᴋѕ".toComponent())
                .addLine(" ".toComponent())
                .addLine("<!i><gray>ᴄʟɪᴄᴋ ᴛᴏ ᴇᴅɪᴛ ᴛʜᴇ ʙʟᴏᴄᴋѕ".toComponent()).build()
        )


        addButton(Button(10){
            player.openMenu(plugin.guiManager.cooldownGUI)
        })

        addButton(Button(12){
            player.openMenu(plugin.guiManager.togglesGUI)
        })

    }
}
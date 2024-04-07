package com.redmagic.undefinedtoggles.gui.admin.sub.page.items

import com.redmagic.undefinedapi.builders.ItemBuilder
import com.redmagic.undefinedapi.extension.string.translateColor
import com.redmagic.undefinedapi.menu.MenuManager.openMenu
import com.redmagic.undefinedapi.menu.MenuSize
import com.redmagic.undefinedapi.menu.normal.button.ClickData
import com.redmagic.undefinedapi.menu.normal.button.MenuButton
import com.redmagic.undefinedapi.menu.page.UndefinedPageMenu
import com.redmagic.undefinedapi.menu.page.button.PageButton
import com.redmagic.undefinedapi.menu.setRow
import com.redmagic.undefinedtoggles.UndefinedToggles
import com.redmagic.undefinedtoggles.data.types.toItemStackList
import com.redmagic.undefinedtoggles.data.types.toItemStackMaterialList
import com.redmagic.undefinedtoggles.gui.admin.sub.page.entity.BlockedEntityPageGUI
import org.bukkit.Material
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack

class ChooseBlockedItemPageGUI(private val plugin: UndefinedToggles, private val list: MutableList<ItemStack>): UndefinedPageMenu("ᴄʜᴏᴏѕᴇ ʙʟᴏᴄᴋᴇᴅ ɪᴛᴇᴍѕ", MenuSize.LARGE, list) {

    override fun generateInventory(): Inventory = createPageInventory {

        setBackButton(
            PageButton(45, ItemBuilder(Material.RED_STAINED_GLASS_PANE)
                .setName("<reset><#d92323>ʙᴀᴄᴋ ᴀ ᴘᴀɢᴇ".translateColor())
                .addLine(" ")
                .addLine("<reset><gray>ᴄʟɪᴄᴋ ᴛᴏ ɢᴏ ʙᴀᴄᴋ ᴀɴ ᴘᴀɢᴇ".translateColor()).build(),
                ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build())
        )

        setNextButton(
            PageButton(53, ItemBuilder(Material.LIME_STAINED_GLASS_PANE)
                .setName("<reset><#32e67d>ɴᴇxᴛ ᴘᴀɢᴇ".translateColor())
                .addLine(" ")
                .addLine("<reset><gray>ᴄʟɪᴄᴋ ᴛᴏ ɢᴏ ᴛᴏ ᴛʜᴇ ɴᴇxᴛ ᴘᴀɢᴇ".translateColor()).build(), ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build())
        )

        setRow(5, ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build())


        setItem(49, ItemBuilder(Material.BARRIER)
            .setName("<reset><#d92323>ʙᴀᴄᴋ ᴛᴏ ʙʟᴏᴄᴋᴇᴅ ɪᴛᴇᴍѕ ᴍᴇɴᴜ".translateColor())
            .addLine(" ")
            .addLine("<gray>ᴄʟɪᴄᴋ ᴛᴏ ɢᴏ ʙᴀᴄᴋ ᴛᴏ ʙʟᴏᴄᴋᴇᴅ ɪᴛᴇᴍѕ ᴍᴇɴᴜ".translateColor()).build())

        addButton(MenuButton(49, BlockedItemPageGUI(plugin, plugin.configManager.blocks.spawning.blockedItems.toItemStackMaterialList())){})

    }

    override var clickData: ClickData.() -> Unit = {

        plugin.configManager.blocks.spawning.blockedItems.add(item!!.type)

        player.openMenu(BlockedItemPageGUI(plugin, plugin.configManager.blocks.spawning.blockedItems.toItemStackMaterialList()))

    }
}
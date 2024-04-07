package com.redmagic.undefinedtoggles.gui.admin.sub.page.entity

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
import org.bukkit.Material
import org.bukkit.entity.EntityType
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack

class ChooseBlockedEntityPageGUI(private val plugin: UndefinedToggles, private val list: MutableList<ItemStack>): UndefinedPageMenu("ᴄʜᴏᴏѕᴇ ᴇɴᴛɪᴛʏ", MenuSize.LARGE, list) {

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
            .setName("<reset><#d92323>ʙᴀᴄᴋ ᴛᴏ ʙʟᴏᴄᴋᴇᴅ ᴇɴᴛɪᴛʏ ᴍᴇɴᴜ".translateColor())
            .addLine(" ")
            .addLine("<gray>ᴄʟɪᴄᴋ ᴛᴏ ɢᴏ ʙᴀᴄᴋ ᴛᴏ ʙʟᴏᴄᴋᴇᴅ ᴇɴᴛɪᴛʏ ᴍᴇɴᴜ".translateColor()).build())

        addButton(MenuButton(49, BlockedEntityPageGUI(plugin, plugin.configManager.blocks.spawning.blockedMobs.toItemStackList())){})

    }

    override var clickData: ClickData.() -> Unit = {

        if (item!!.hasItemMeta()){
            val itemMeta = item!!.itemMeta

            try {

                val entityType = EntityType.valueOf(itemMeta!!.localizedName)

                plugin.configManager.blocks.spawning.blockedMobs.add(entityType)

                player.openMenu(BlockedEntityPageGUI(plugin, plugin.configManager.blocks.spawning.blockedMobs.toItemStackList()))

            }catch (e: Exception){

            }

        }
    }
}
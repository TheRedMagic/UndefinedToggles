package com.redmagic.undefinedtoggles.gui.admin.sub.page.maxAmount

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
import com.redmagic.undefinedtoggles.data.types.toItemStacks
import net.wesjd.anvilgui.AnvilGUI
import org.bukkit.Material
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack

class MaxAmountChoosePageGUI(private val plugin: UndefinedToggles, list: MutableList<ItemStack>): UndefinedPageMenu("ᴄʜᴏᴏѕᴇ ᴍᴀx ᴀᴍᴏᴜɴᴛ", MenuSize.LARGE, list) {

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
            .setName("<reset><#d92323>ʙᴀᴄᴋ ᴛᴏ ᴍᴀx ᴀᴍᴏᴜɴᴛ ᴍᴇɴᴜ".translateColor())
            .addLine(" ")
            .addLine("<gray>ᴄʟɪᴄᴋ ᴛᴏ ɢᴏ ʙᴀᴄᴋ ᴛᴏ ᴍᴀx ᴀᴍᴏᴜɴᴛ ᴍᴇɴᴜ".translateColor()).build())

        addButton(MenuButton(49, MaxAmountPageMenu(plugin, plugin.configManager.maxAmount.maxAmount.toItemStacks())){})
    }

    override var clickData: ClickData.() -> Unit = {

        val builder = AnvilGUI.Builder()
            .itemLeft(ItemBuilder(item!!.type).setName("<reset><#d92323>ᴍᴀx ᴀᴍᴏᴜɴᴛ".translateColor()).build())
            .title("ᴍᴀx ᴀᴍᴏᴜɴᴛ")
            .text(item!!.type.maxStackSize.toString())
            .plugin(plugin)
        builder.onClick { _, clickEvent ->

            val text = clickEvent.text

            try {

                val maxAmount = text.toDouble()

                plugin.configManager.maxAmount.maxAmount[item!!.type] = maxAmount.toInt()

            } catch (e: NumberFormatException) {
                player.sendMessage("<reset><#d92323>$text ɪѕ ɴᴏᴛ ᴀ ɴᴜᴍʙᴇʀ.".translateColor())
            }

            return@onClick listOf(AnvilGUI.ResponseAction.run {
                player.openMenu(MaxAmountPageMenu(plugin, plugin.configManager.maxAmount.maxAmount.toItemStacks()))
            })

        }

        builder.open(player)

    }
}
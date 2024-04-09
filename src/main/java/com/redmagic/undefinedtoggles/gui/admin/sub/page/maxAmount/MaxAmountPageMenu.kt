package com.redmagic.undefinedtoggles.gui.admin.sub.page.maxAmount

import com.redmagic.undefinedapi.builders.ItemBuilder
import com.redmagic.undefinedapi.extension.string.translateColor
import com.redmagic.undefinedapi.menu.MenuManager.openMenu
import com.redmagic.undefinedapi.menu.MenuSize
import com.redmagic.undefinedapi.menu.normal.button.Button
import com.redmagic.undefinedapi.menu.normal.button.ClickData
import com.redmagic.undefinedapi.menu.normal.button.MenuButton
import com.redmagic.undefinedapi.menu.page.UndefinedPageMenu
import com.redmagic.undefinedapi.menu.page.button.PageButton
import com.redmagic.undefinedapi.menu.setRow
import com.redmagic.undefinedtoggles.UndefinedToggles
import com.redmagic.undefinedtoggles.data.types.toItemStacks
import com.redmagic.undefinedtoggles.exstions.getMaxAmount
import net.wesjd.anvilgui.AnvilGUI
import org.bukkit.Material
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack
import org.bukkit.plugin.Plugin

class MaxAmountPageMenu(private val plugin: UndefinedToggles, list: MutableList<ItemStack>): UndefinedPageMenu("ᴍᴀx ᴀᴍᴏᴜɴᴛ", MenuSize.LARGE, list) {

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

        setItem(48, ItemBuilder(Material.BARRIER)
            .setName("<reset><#d92323>ʙᴀᴄᴋ ᴛᴏ ʙʟᴏᴄᴋᴇᴅ ᴍᴇɴᴜ".translateColor())
            .addLine(" ")
            .addLine("<gray>ᴄʟɪᴄᴋ ᴛᴏ ɢᴏ ʙᴀᴄᴋ ᴛᴏ ʙʟᴏᴄᴋᴇᴅ ᴍᴇɴᴜ".translateColor()).build())

        addButton(MenuButton(48, plugin.guiManager.blocksGUI){})

        setItem(50, ItemBuilder(Material.LIME_CONCRETE)
            .setName("<reset><#32e67d>ᴀᴅᴅ ɴᴇᴡ ᴍᴀx ᴀᴍᴏᴜɴᴛ ɪᴛᴇᴍ".translateColor())
            .addLine(" ")
            .addLine("<reset><gray>ᴄʟɪᴄᴋ ᴛᴏ ᴀᴅᴅ ᴀ ɴᴇᴡ ᴍᴀx ᴀᴍᴏᴜɴᴛ ɪᴛᴇᴍ".translateColor()).build())

        addButton(Button(50){

            player.openMenu(MaxAmountChoosePageGUI(plugin, Material.SPAWNER.getMaxAmount()))

        })

    }

    override var clickData: ClickData.() -> Unit = {
        if (click.isLeftClick){


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

        }else if (click.isRightClick){

            plugin.configManager.maxAmount.maxAmount.remove(item!!.type)

            player.openMenu(MaxAmountPageMenu(plugin, plugin.configManager.maxAmount.maxAmount.toItemStacks()))

        }
    }
}
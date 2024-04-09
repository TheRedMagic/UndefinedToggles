package com.redmagic.undefinedtoggles.gui.admin.sub.page.command

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
import com.redmagic.undefinedtoggles.data.types.BlockCommand
import com.redmagic.undefinedtoggles.data.types.getFromName
import com.redmagic.undefinedtoggles.data.types.getList
import com.redmagic.undefinedtoggles.gui.admin.sub.BlockCommandGUI
import net.wesjd.anvilgui.AnvilGUI
import org.bukkit.Material
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack

class BlockedCommandPageGUI(list: List<ItemStack>, private val plugin: UndefinedToggles): UndefinedPageMenu("ʙʟᴏᴄᴋᴇᴅ ᴄᴏᴍᴍᴀɴᴅѕ", MenuSize.LARGE, list) {

    override fun generateInventory(): Inventory = createPageInventory {

        setBackButton(PageButton(45, ItemBuilder(Material.RED_STAINED_GLASS_PANE)
            .setName("<reset><#d92323>ʙᴀᴄᴋ ᴀ ᴘᴀɢᴇ".translateColor())
            .addLine(" ")
            .addLine("<reset><gray>ᴄʟɪᴄᴋ ᴛᴏ ɢᴏ ʙᴀᴄᴋ ᴀɴ ᴘᴀɢᴇ".translateColor()).build(),
            ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build()))

        setNextButton(PageButton(53, ItemBuilder(Material.LIME_STAINED_GLASS_PANE)
            .setName("<reset><#32e67d>ɴᴇxᴛ ᴘᴀɢᴇ".translateColor())
            .addLine(" ")
            .addLine("<reset><gray>ᴄʟɪᴄᴋ ᴛᴏ ɢᴏ ᴛᴏ ᴛʜᴇ ɴᴇxᴛ ᴘᴀɢᴇ".translateColor()).build(), ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build()))

        setRow(5, ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build())


        setItem(48, ItemBuilder(Material.BARRIER)
            .setName("<reset><#d92323>ʙᴀᴄᴋ ᴛᴏ ʙʟᴏᴄᴋᴇᴅ ᴍᴇɴᴜ".translateColor())
            .addLine(" ")
            .addLine("<gray>ᴄʟɪᴄᴋ ᴛᴏ ɢᴏ ʙᴀᴄᴋ ᴛᴏ ʙʟᴏᴄᴋᴇᴅ ᴍᴇɴᴜ".translateColor()).build())

        addButton(MenuButton(48, plugin.guiManager.blocksGUI){})

        setItem(50, ItemBuilder(Material.LIME_CONCRETE)
            .setName("<reset><#32e67d>ᴀᴅᴅ ʙʟᴏᴄᴋᴇᴅ ᴄᴏᴍᴍᴀɴᴅ".translateColor())
            .addLine(" ")
            .addLine("<reset><gray>ᴄʟɪᴄᴋ ᴛᴏ ᴀᴅᴅ ᴀ ʙʟᴏᴄᴋᴇᴅ ᴄᴏᴍᴍᴀɴᴅ".translateColor()).build())


        addButton(Button(50){

            val builder = AnvilGUI.Builder()
                .itemLeft(ItemBuilder(Material.OAK_SIGN).setName("<reset><#32e67d>ɴᴇᴡ ʙʟᴏᴄᴋᴇᴅ ᴄᴏᴍᴍᴀɴᴅ".translateColor()).build())
                .title("ɴᴇᴡ ʙʟᴏᴄᴋᴇᴅ ᴄᴏᴍᴍᴀɴᴅ")
                .text("ʙʟᴏᴄᴋᴇᴅ ᴄᴏᴍᴍᴀɴᴅ ᴡɪᴛʜᴏᴜᴛ /")
                .plugin(plugin)
            builder.onClick { _, clickEvent ->

                val text = clickEvent.text

                if (text.contains(" ")){
                    player.sendMessage("<#d92323>ɴᴏᴛ ᴀɴ ᴄᴏᴍᴍᴀɴᴅ".translateColor())
                    return@onClick listOf(AnvilGUI.ResponseAction.close())
                }


                val blockCommand = BlockCommand(text, "undefined.toggle.tabcomplete.default", false)

                plugin.configManager.blocks.blockedCommands.add(blockCommand)



                return@onClick listOf(AnvilGUI.ResponseAction.run{
                    player.openMenu(BlockCommandGUI(plugin, blockCommand))
                })
            }

            builder.open(player)

        })

    }

    override var clickData: ClickData.() -> Unit = {

        val blockCommand = plugin.configManager.blocks.blockedCommands.getFromName(item!!.itemMeta!!.localizedName)

        if (blockCommand != null) {
            if (click.isLeftClick) {
                player.openMenu(BlockCommandGUI(plugin, blockCommand))
            }else if (click.isRightClick){

                plugin.configManager.blocks.blockedCommands.remove(blockCommand)

                player.openMenu(BlockedCommandPageGUI(plugin.configManager.blocks.blockedCommands.getList(), plugin))

            }
        }

    }
}
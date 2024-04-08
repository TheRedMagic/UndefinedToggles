package com.redmagic.undefinedtoggles.gui.admin.sub

import com.redmagic.undefinedapi.builders.ItemBuilder
import com.redmagic.undefinedapi.extension.string.toSmallText
import com.redmagic.undefinedapi.extension.string.translateColor
import com.redmagic.undefinedapi.menu.MenuManager.openMenu
import com.redmagic.undefinedapi.menu.MenuSize
import com.redmagic.undefinedapi.menu.normal.UndefinedMenu
import com.redmagic.undefinedapi.menu.normal.button.Button
import com.redmagic.undefinedapi.menu.normal.button.MenuButton
import com.redmagic.undefinedtoggles.UndefinedToggles
import com.redmagic.undefinedtoggles.data.types.BlockCommand
import com.redmagic.undefinedtoggles.data.types.getFromName
import com.redmagic.undefinedtoggles.data.types.getList
import com.redmagic.undefinedtoggles.gui.admin.sub.page.BlockedCommandPageGUI
import net.wesjd.anvilgui.AnvilGUI
import org.bukkit.Material
import org.bukkit.entity.Item
import org.bukkit.inventory.Inventory

class BlockCommandGUI(private val plugin: UndefinedToggles, private val blockCommand: BlockCommand): UndefinedMenu("ʙʟᴏᴄᴋᴇᴅ ᴄᴏᴍᴍᴀɴᴅѕ : ${blockCommand.command.toSmallText()}", MenuSize.MINI) {
    override fun generateInventory(): Inventory = createInventory {

        fillEmpty(ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build())

        setItem(18, ItemBuilder(Material.RED_STAINED_GLASS_PANE)
            .setName("<reset><#d92323>ʙᴀᴄᴋ ᴛᴏ ʙʟᴏᴄᴋᴇᴅ ᴄᴏᴍᴍᴀɴᴅѕ ᴍᴇɴᴜ".translateColor())
            .addLine(" ")
            .addLine("<reset><gray>ᴄʟɪᴄᴋ ᴛᴏ ɢᴏ ʙᴀᴄᴋ ᴛᴏ ʙʟᴏᴄᴋᴇᴅ ᴄᴏᴍᴍᴀɴᴅѕ ᴍᴇɴᴜ".translateColor()).build())

        addButton(MenuButton(18, BlockedCommandPageGUI(plugin.configManager.blocks.blockedCommands.getList(), plugin)){})



        setItem(13, ItemBuilder(Material.OAK_SIGN)
            .setName("<reset><#34ebcc>ᴄᴏᴍᴍᴀɴᴅ".translateColor())
            .addLine(" ")
            .addLine("<reset><aqua>ɴᴀᴍᴇ <gray>${blockCommand.command.toSmallText()}".translateColor())
            .addLine(" ")
            .build())

        setTabComplete(this)
        setPermissionItem(this)


        addButton(Button(11){

            if (click.isLeftClick){
                val builder = AnvilGUI.Builder()
                    .itemLeft(ItemBuilder(Material.COMPARATOR).setName("<reset><#eb9234>ɴᴏᴅᴇ".translateColor()).build())
                    .title("ᴄʜᴀɴɢᴇ ᴘᴇʀᴍɪѕѕɪᴏɴ ɴᴏᴅᴇ")
                    .text("ɴᴇᴡ ɴᴏᴅᴇ")
                    .plugin(plugin)
                builder.onClick { _, clickEvent ->

                    val text = clickEvent.text

                    if (text.contains(" ")){
                        return@onClick listOf(AnvilGUI.ResponseAction.close())

                        player.sendMessage("<#d92323>ɴᴏᴛ ᴀɴ ᴘᴇʀᴍɪѕѕɪᴏɴ ɴᴏᴅᴇ".translateColor())
                    }

                    blockCommand.permission = text

                    setPermissionItem(this@createInventory)
                    player.openMenu(this@BlockCommandGUI)

                    return@onClick listOf(AnvilGUI.ResponseAction.run{
                        player.openMenu(this@BlockCommandGUI)
                    })
                }

                builder.open(player)
            }else if (click.isRightClick){

                blockCommand.permission = "NONE"
                setPermissionItem(this@createInventory)

            }

        })
        addButton(Button(15){
            blockCommand.blockTabComplete = !blockCommand.blockTabComplete
            setTabComplete(this@createInventory)
        })

    }

    private fun setTabComplete(inventory: Inventory){
        inventory.setItem(15, ItemBuilder(
            if(blockCommand.blockTabComplete){Material.LIME_CONCRETE}else{Material.RED_CONCRETE}
        )
            .setName(
                "<reset><#8feb34>ᴛᴀʙ ᴄᴏᴍᴘʟᴇᴛᴇ".translateColor()
            )
            .addLine(" ")
            .addLine(
                if (blockCommand.blockTabComplete){"<reset><#32e67d>ɴᴏᴛ ѕʜᴏᴡɪɴɢ".translateColor()}else{"<reset><#d92323>ѕʜᴏᴡɪɴɢ".translateColor()}
            )
            .addLine(" ")
            .addLine("<reset><gray>ᴄʟɪᴄᴋ ᴛᴏ ᴛᴏɢɢʟᴇ ᴛᴀʙ ᴄᴏᴍᴘʟᴇᴛᴇ".translateColor())
            .build())
    }

    private fun setPermissionItem(inventory: Inventory){
        inventory.setItem(11, ItemBuilder(Material.COMPARATOR)
            .setName("<reset><#eb9234>ᴘᴇʀᴍɪѕѕɪᴏɴ ɴᴏᴅᴇ".translateColor())
            .addLine(" ")
            .addLine("<reset><aqua>ɴᴏᴅᴇ <gray>${if (blockCommand.permission.equals("none", true)){"<#d92323>".translateColor()} else {""}
            }${blockCommand.permission.toSmallText()}".translateColor())
            .addLine(" ")
            .addLine("<reset><gray>ʟᴇꜰᴛ ᴄʟɪᴄᴋ ᴛᴏ ᴇᴅɪᴛ ᴛʜᴇ ᴘᴇʀᴍɪѕѕɪᴏɴ ɴᴏᴅᴇ".translateColor())
            .addLine("<reset><gray>ʀɪɢʜᴛ ᴄʟɪᴄᴋ ᴛᴏ ѕᴇᴛ ᴘᴇʀᴍɪѕѕɪᴏɴ ᴛᴏ ɴᴏɴᴇ".translateColor()).build())
    }
}
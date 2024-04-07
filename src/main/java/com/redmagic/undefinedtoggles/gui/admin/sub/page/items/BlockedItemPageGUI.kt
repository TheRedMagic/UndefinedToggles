package com.redmagic.undefinedtoggles.gui.admin.sub.page.items

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
import com.redmagic.undefinedtoggles.data.types.toItemStackList
import com.redmagic.undefinedtoggles.data.types.toItemStackMaterialList
import com.redmagic.undefinedtoggles.exstions.getItemItems
import com.redmagic.undefinedtoggles.exstions.getSpawnEggItems
import com.redmagic.undefinedtoggles.gui.admin.sub.page.entity.BlockedEntityPageGUI
import com.redmagic.undefinedtoggles.gui.admin.sub.page.entity.ChooseBlockedEntityPageGUI
import org.bukkit.Material
import org.bukkit.entity.EntityType
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack

class BlockedItemPageGUI(private val plugin: UndefinedToggles, private val list: MutableList<ItemStack>): UndefinedPageMenu("ʙʟᴏᴄᴋᴇᴅ ɪᴛᴇᴍѕ", MenuSize.LARGE, list) {

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
            .setName("<reset><#d92323>ʙᴀᴄᴋ ᴛᴏ ѕᴘᴀᴡɴɪɴɢ ᴍᴇɴᴜ".translateColor())
            .addLine(" ")
            .addLine("<gray>ᴄʟɪᴄᴋ ᴛᴏ ɢᴏ ʙᴀᴄᴋ ᴛᴏ ѕᴘᴀᴡɴɪɴɢ ᴍᴇɴᴜ".translateColor()).build())

        addButton(MenuButton(48, plugin.guiManager.spawningGUI){})

        setItem(50, ItemBuilder(Material.LIME_CONCRETE)
            .setName("<reset><#32e67d>ᴀᴅᴅ ʙʟᴏᴄᴋᴇᴅ ɪᴛᴇᴍѕ".translateColor())
            .addLine(" ")
            .addLine("<reset><gray>ᴄʟɪᴄᴋ ᴛᴏ ᴀᴅᴅ ᴀ ʙʟᴏᴄᴋᴇᴅ ɪᴛᴇᴍѕ".translateColor()).build())

        addButton(Button(50){

            player.openMenu(ChooseBlockedItemPageGUI(plugin, org.bukkit.Material.SPAWNER.getItemItems().toMutableList()))

        })

    }

    override var clickData: ClickData.() -> Unit = {

        plugin.configManager.blocks.spawning.blockedItems.remove(item!!.type)

        player.openMenu(BlockedItemPageGUI(plugin, plugin.configManager.blocks.spawning.blockedItems.toItemStackMaterialList()))

    }
}
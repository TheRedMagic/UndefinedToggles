package com.redmagic.undefinedtoggles.gui

import com.redmagic.undefinedapi.builders.ItemBuilder
import com.redmagic.undefinedapi.extension.string.toComponent
import com.redmagic.undefinedapi.menu.MenuManager.openMenu
import com.redmagic.undefinedapi.menu.MenuSize
import com.redmagic.undefinedapi.menu.normal.UndefinedMenu
import com.redmagic.undefinedapi.menu.normal.button.Button
import com.redmagic.undefinedapi.menu.normal.button.MenuButton
import com.redmagic.undefinedtoggles.UndefinedToggles
import com.redmagic.undefinedtoggles.exstions.isNegative
import net.wesjd.anvilgui.AnvilGUI
import org.bukkit.Material
import org.bukkit.inventory.Inventory

class CooldownGUI(private val plugin: UndefinedToggles): UndefinedMenu("ᴄᴏᴏʟᴅᴏᴡɴѕ", MenuSize.MINI) {
    override fun generateInventory(): Inventory = createInventory {

        fillEmpty(ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build())

        setEnderPearlItem(this)

        setFirework(this)

        setBow(this)

        setTrident(this)

        setCrossBow(this)

        setAxe(this)

        setItem(18, ItemBuilder(Material.RED_STAINED_GLASS_PANE)
            .setName("<!i><#d92323>ʙᴀᴄᴋ ᴛᴏ ᴀᴅᴍɪɴ ᴍᴇɴᴜ".toComponent())
            .addLine(" ".toComponent())
            .addLine("<!i><gray>ᴄʟɪᴄᴋ ᴛᴏ ɢᴏ ʙᴀᴄᴋ ᴛᴏ ᴀᴅᴍɪɴ ᴍᴇɴᴜ".toComponent()).build())

        addButton(MenuButton(18, plugin.guiManager.adminGUI){})

        addButton(Button(10){

            if (click.isRightClick){

                if (plugin.configManager.cooldowns.enderPearls.isNegative()){
                    plugin.configManager.cooldowns.enderPearls = 3.0
                }else{
                    plugin.configManager.cooldowns.enderPearls = -1.0
                }

                setEnderPearlItem(this@createInventory)

            }else if (click.isLeftClick){

                val builder = AnvilGUI.Builder()
                    .itemLeft(ItemBuilder(item!!.type).setName("<!i><#9710e6>ᴇɴᴅᴇʀ ᴘᴇᴀʀʟ ᴄᴏᴏʟᴅᴏᴡɴ".toComponent()).build())
                    .title("ᴇɴᴅᴇʀ ᴘᴇᴀʀʟ ᴄᴏᴏʟᴅᴏᴡɴ")
                    .text(plugin.configManager.cooldowns.enderPearls.toString())
                    .plugin(plugin)
                builder.onClick { _, clickEvent ->

                    val text = clickEvent.text

                    try {

                        val cooldown = text.toDouble()

                        plugin.configManager.cooldowns.enderPearls = cooldown

                        setEnderPearlItem(this@createInventory)

                    }catch (e: NumberFormatException){
                        player.sendMessage("<!i><#d92323>$text ɪѕ ɴᴏᴛ ᴀ ɴᴜᴍʙᴇʀ.".toComponent())
                    }

                    return@onClick listOf(AnvilGUI.ResponseAction.run{
                        player.openMenu(plugin.guiManager.cooldownGUI)
                    })
                }

                builder.open(player)

            }

        })
        addButton(Button(11){

            if (click.isRightClick){

                if (plugin.configManager.cooldowns.fireworks.isNegative()){
                    plugin.configManager.cooldowns.fireworks = 1.0
                }else{
                    plugin.configManager.cooldowns.fireworks = -1.0
                }

                setFirework(this@createInventory)

            }else if (click.isLeftClick){

                val builder = AnvilGUI.Builder()
                    .itemLeft(ItemBuilder(item!!.type).setName("<!i><#f56b3d>ꜰɪʀᴇᴡᴏʀᴋ ᴄᴏᴏʟᴅᴏᴡɴ".toComponent()).build())
                    .title("ꜰɪʀᴇᴡᴏʀᴋ ᴄᴏᴏʟᴅᴏᴡɴ")
                    .text(plugin.configManager.cooldowns.fireworks.toString())
                    .plugin(plugin)
                builder.onClick { _, clickEvent ->

                    val text = clickEvent.text

                    try {

                        val cooldown = text.toDouble()

                        plugin.configManager.cooldowns.fireworks = cooldown

                        setEnderPearlItem(this@createInventory)

                    }catch (e: NumberFormatException){
                        player.sendMessage("<!i><#d92323>$text ɪѕ ɴᴏᴛ ᴀ ɴᴜᴍʙᴇʀ.".toComponent())
                    }

                    return@onClick listOf(AnvilGUI.ResponseAction.run{
                        player.openMenu(plugin.guiManager.cooldownGUI)
                    })
                }

                builder.open(player)

            }

        })
        addButton(Button(15){

            if (click.isRightClick){

                if (plugin.configManager.cooldowns.bow.isNegative()){
                    plugin.configManager.cooldowns.bow = 1.0
                }else{
                    plugin.configManager.cooldowns.bow = -1.0
                }

                setBow(this@createInventory)

            }else if (click.isLeftClick){

                val builder = AnvilGUI.Builder()
                    .itemLeft(ItemBuilder(item!!.type).setName("<!i><#f5be3d>ʙᴏᴡ ᴄᴏᴏʟᴅᴏᴡɴ".toComponent()).build())
                    .title("ʙᴏᴡ ᴄᴏᴏʟᴅᴏᴡɴ")
                    .text(plugin.configManager.cooldowns.bow.toString())
                    .plugin(plugin)
                builder.onClick { _, clickEvent ->

                    val text = clickEvent.text

                    try {

                        val cooldown = text.toDouble()

                        plugin.configManager.cooldowns.bow = cooldown

                        setBow(this@createInventory)

                    }catch (e: NumberFormatException){
                        player.sendMessage("<!i><#d92323>$text ɪѕ ɴᴏᴛ ᴀ ɴᴜᴍʙᴇʀ.".toComponent())
                    }

                    return@onClick listOf(AnvilGUI.ResponseAction.run{
                        player.openMenu(plugin.guiManager.cooldownGUI)
                    })
                }

                builder.open(player)

            }

        })
        addButton(Button(16){

            if (click.isRightClick){

                if (plugin.configManager.cooldowns.trident.isNegative()){
                    plugin.configManager.cooldowns.trident = 1.0
                }else{
                    plugin.configManager.cooldowns.trident = -1.0
                }

                setTrident(this@createInventory)

            }else if (click.isLeftClick){

                val builder = AnvilGUI.Builder()
                    .itemLeft(ItemBuilder(item!!.type).setName("<!i><#3da5f5>ᴛʀɪᴅᴇɴᴛ ᴄᴏᴏʟᴅᴏᴡɴ".toComponent()).build())
                    .title("ᴛʀɪᴅᴇɴᴛ ᴄᴏᴏʟᴅᴏᴡɴ")
                    .text(plugin.configManager.cooldowns.trident.toString())
                    .plugin(plugin)
                builder.onClick { _, clickEvent ->

                    val text = clickEvent.text

                    try {

                        val cooldown = text.toDouble()

                        plugin.configManager.cooldowns.trident = cooldown

                        setBow(this@createInventory)

                    }catch (e: NumberFormatException){
                        player.sendMessage("<!i><#d92323>$text ɪѕ ɴᴏᴛ ᴀ ɴᴜᴍʙᴇʀ.".toComponent())
                    }

                    return@onClick listOf(AnvilGUI.ResponseAction.run{
                        player.openMenu(plugin.guiManager.cooldownGUI)
                    })
                }

                builder.open(player)

            }

        })
        addButton(Button(14){

            if (click.isRightClick){

                if (plugin.configManager.cooldowns.crossbow.isNegative()){
                    plugin.configManager.cooldowns.crossbow = 1.0
                }else{
                    plugin.configManager.cooldowns.crossbow = -1.0
                }

                setCrossBow(this@createInventory)

            }else if (click.isLeftClick){

                val builder = AnvilGUI.Builder()
                    .itemLeft(ItemBuilder(item!!.type).setName("<!i><#87f53d>ᴄʀᴏѕѕʙᴏᴡ ᴄᴏᴏʟᴅᴏᴡɴ".toComponent()).build())
                    .title("ᴄʀᴏѕѕʙᴏᴡ ᴄᴏᴏʟᴅᴏᴡɴ")
                    .text(plugin.configManager.cooldowns.crossbow.toString())
                    .plugin(plugin)
                builder.onClick { _, clickEvent ->

                    val text = clickEvent.text

                    try {

                        val cooldown = text.toDouble()

                        plugin.configManager.cooldowns.crossbow = cooldown

                        setCrossBow(this@createInventory)

                    }catch (e: NumberFormatException){
                        player.sendMessage("<!i><#d92323>$text ɪѕ ɴᴏᴛ ᴀ ɴᴜᴍʙᴇʀ.".toComponent())
                    }

                    return@onClick listOf(AnvilGUI.ResponseAction.run{
                        player.openMenu(plugin.guiManager.cooldownGUI)
                    })
                }

                builder.open(player)

            }

        })



        addButton(Button(12){

            if (click.isRightClick){

                if (plugin.configManager.cooldowns.axe.isNegative()){
                    plugin.configManager.cooldowns.axe = 1.0
                }else{
                    plugin.configManager.cooldowns.axe = -1.0
                }

                setAxe(this@createInventory)

            }else if (click.isLeftClick){

                val builder = AnvilGUI.Builder()
                    .itemLeft(ItemBuilder(item!!.type).setName("<!i><#8b50f2>ᴀxᴇ ᴄᴏᴏʟᴅᴏᴡɴ".toComponent()).build())
                    .title("ᴀxᴇ ᴄᴏᴏʟᴅᴏᴡɴ")
                    .text(plugin.configManager.cooldowns.crossbow.toString())
                    .plugin(plugin)
                builder.onClick { _, clickEvent ->

                    val text = clickEvent.text

                    try {

                        val cooldown = text.toDouble()

                        plugin.configManager.cooldowns.axe = cooldown

                        setAxe(this@createInventory)

                    }catch (e: NumberFormatException){
                        player.sendMessage("<!i><#d92323>$text ɪѕ ɴᴏᴛ ᴀ ɴᴜᴍʙᴇʀ.".toComponent())
                    }

                    return@onClick listOf(AnvilGUI.ResponseAction.run{
                        player.openMenu(plugin.guiManager.cooldownGUI)
                    })
                }

                builder.open(player)

            }

        })

    }


    private fun setEnderPearlItem(inventory: Inventory){

        val disable = plugin.configManager.cooldowns.enderPearls.isNegative()

        val itemBuilder = ItemBuilder(Material.ENDER_PEARL)
            .setName("<!i><#9710e6>ᴇɴᴅᴇʀ ᴘᴇᴀʀʟ".toComponent())
            .addLine(" ".toComponent())

        if (disable){
            itemBuilder.addLine("<!i><#d92323>ɴᴏᴛ ᴍᴏᴅɪꜰɪᴇᴅ".toComponent())
        }else{
            itemBuilder.addLine("<!i><aqua>ᴄᴏᴏʟᴅᴏᴡɴ <gray>${plugin.configManager.cooldowns.enderPearls} ѕᴇᴄᴏɴᴅѕ".toComponent())
        }

        itemBuilder.addLine(" ".toComponent())
        itemBuilder.addLine("<!i><gray>ʟᴇꜰᴛ ᴄʟɪᴄᴋ ᴛᴏ ᴄʜᴀɴɢᴇ ᴄᴏᴏʟᴅᴏᴡɴ".toComponent())
        itemBuilder.addLine("<!i><gray>ʀɪɢʜᴛ ᴄʟɪᴄᴋ ᴛᴏ ᴛᴏɢɢʟᴇ ᴄᴜѕᴛᴏᴍ ᴄᴏᴏʟᴅᴏᴡɴ".toComponent())

        inventory.setItem(10, itemBuilder.build())

    }
    private fun setFirework(inventory: Inventory){

        val disable = plugin.configManager.cooldowns.fireworks.isNegative()

        val itemBuilder = ItemBuilder(Material.FIREWORK_ROCKET)
            .setName("<!i><#f56b3d>ꜰɪʀᴇᴡᴏʀᴋ".toComponent())
            .addLine(" ".toComponent())

        if (disable){
            itemBuilder.addLine("<!i><#d92323>ɴᴏᴛ ᴍᴏᴅɪꜰɪᴇᴅ".toComponent())
        }else{
            itemBuilder.addLine("<!i><aqua>ᴄᴏᴏʟᴅᴏᴡɴ <gray>${plugin.configManager.cooldowns.fireworks} ѕᴇᴄᴏɴᴅѕ".toComponent())
        }

        itemBuilder.addLine(" ".toComponent())
        itemBuilder.addLine("<!i><gray>ʟᴇꜰᴛ ᴄʟɪᴄᴋ ᴛᴏ ᴄʜᴀɴɢᴇ ᴄᴏᴏʟᴅᴏᴡɴ".toComponent())
        itemBuilder.addLine("<!i><gray>ʀɪɢʜᴛ ᴄʟɪᴄᴋ ᴛᴏ ᴛᴏɢɢʟᴇ ᴄᴜѕᴛᴏᴍ ᴄᴏᴏʟᴅᴏᴡɴ".toComponent())

        inventory.setItem(11, itemBuilder.build())

    }
    private fun setBow(inventory: Inventory){

        val disable = plugin.configManager.cooldowns.bow.isNegative()

        val itemBuilder = ItemBuilder(Material.BOW)
            .setName("<!i><#f5be3d>ʙᴏᴡ".toComponent())
            .addLine(" ".toComponent())

        if (disable){
            itemBuilder.addLine("<!i><#d92323>ɴᴏᴛ ᴍᴏᴅɪꜰɪᴇᴅ".toComponent())
        }else{
            itemBuilder.addLine("<!i><aqua>ᴄᴏᴏʟᴅᴏᴡɴ <gray>${plugin.configManager.cooldowns.bow} ѕᴇᴄᴏɴᴅѕ".toComponent())
        }

        itemBuilder.addLine(" ".toComponent())
        itemBuilder.addLine("<!i><gray>ʟᴇꜰᴛ ᴄʟɪᴄᴋ ᴛᴏ ᴄʜᴀɴɢᴇ ᴄᴏᴏʟᴅᴏᴡɴ".toComponent())
        itemBuilder.addLine("<!i><gray>ʀɪɢʜᴛ ᴄʟɪᴄᴋ ᴛᴏ ᴛᴏɢɢʟᴇ ᴄᴜѕᴛᴏᴍ ᴄᴏᴏʟᴅᴏᴡɴ".toComponent())

        inventory.setItem(15, itemBuilder.build())


    }
    private fun setCrossBow(inventory: Inventory){

        val disable = plugin.configManager.cooldowns.crossbow.isNegative()

        val itemBuilder = ItemBuilder(Material.CROSSBOW)
            .setName("<!i><#87f53d>ᴄʀᴏѕѕʙᴏᴡ".toComponent())
            .addLine(" ".toComponent())

        if (disable){
            itemBuilder.addLine("<!i><#d92323>ɴᴏᴛ ᴍᴏᴅɪꜰɪᴇᴅ".toComponent())
        }else{
            itemBuilder.addLine("<!i><aqua>ᴄᴏᴏʟᴅᴏᴡɴ <gray>${plugin.configManager.cooldowns.crossbow} ѕᴇᴄᴏɴᴅѕ".toComponent())
        }

        itemBuilder.addLine(" ".toComponent())
        itemBuilder.addLine("<!i><gray>ʟᴇꜰᴛ ᴄʟɪᴄᴋ ᴛᴏ ᴄʜᴀɴɢᴇ ᴄᴏᴏʟᴅᴏᴡɴ".toComponent())
        itemBuilder.addLine("<!i><gray>ʀɪɢʜᴛ ᴄʟɪᴄᴋ ᴛᴏ ᴛᴏɢɢʟᴇ ᴄᴜѕᴛᴏᴍ ᴄᴏᴏʟᴅᴏᴡɴ".toComponent())

        inventory.setItem(14, itemBuilder.build())


    }
    private fun setTrident(inventory: Inventory){

        val disable = plugin.configManager.cooldowns.trident.isNegative()

        val itemBuilder = ItemBuilder(Material.TRIDENT)
            .setName("<!i><#3da5f5>ᴛʀɪᴅᴇɴᴛ".toComponent())
            .addLine(" ".toComponent())

        if (disable){
            itemBuilder.addLine("<!i><#d92323>ɴᴏᴛ ᴍᴏᴅɪꜰɪᴇᴅ".toComponent())
        }else{
            itemBuilder.addLine("<!i><aqua>ᴄᴏᴏʟᴅᴏᴡɴ <gray>${plugin.configManager.cooldowns.trident} ѕᴇᴄᴏɴᴅѕ".toComponent())
        }

        itemBuilder.addLine(" ".toComponent())
        itemBuilder.addLine("<!i><gray>ʟᴇꜰᴛ ᴄʟɪᴄᴋ ᴛᴏ ᴄʜᴀɴɢᴇ ᴄᴏᴏʟᴅᴏᴡɴ".toComponent())
        itemBuilder.addLine("<!i><gray>ʀɪɢʜᴛ ᴄʟɪᴄᴋ ᴛᴏ ᴛᴏɢɢʟᴇ ᴄᴜѕᴛᴏᴍ ᴄᴏᴏʟᴅᴏᴡɴ".toComponent())

        inventory.setItem(16, itemBuilder.build())


    }
    private fun setAxe(inventory: Inventory){

        val disable = plugin.configManager.cooldowns.axe.isNegative()

        val itemBuilder = ItemBuilder(Material.DIAMOND_AXE)
            .setName("<!i><#8b50f2>ᴀxᴇ".toComponent())
            .addLine(" ".toComponent())

        if (disable){
            itemBuilder.addLine("<!i><#d92323>ɴᴏᴛ ᴍᴏᴅɪꜰɪᴇᴅ".toComponent())
        }else{
            itemBuilder.addLine("<!i><aqua>ᴄᴏᴏʟᴅᴏᴡɴ <gray>${plugin.configManager.cooldowns.axe} ѕᴇᴄᴏɴᴅѕ".toComponent())
        }

        itemBuilder.addLine(" ".toComponent())
        itemBuilder.addLine("<!i><gray>ʟᴇꜰᴛ ᴄʟɪᴄᴋ ᴛᴏ ᴄʜᴀɴɢᴇ ᴄᴏᴏʟᴅᴏᴡɴ".toComponent())
        itemBuilder.addLine("<!i><gray>ʀɪɢʜᴛ ᴄʟɪᴄᴋ ᴛᴏ ᴛᴏɢɢʟᴇ ᴄᴜѕᴛᴏᴍ ᴄᴏᴏʟᴅᴏᴡɴ".toComponent())

        inventory.setItem(12, itemBuilder.build())


    }
}
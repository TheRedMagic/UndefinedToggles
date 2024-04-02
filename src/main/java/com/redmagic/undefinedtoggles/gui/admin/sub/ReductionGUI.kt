package com.redmagic.undefinedtoggles.gui.admin.sub

import com.redmagic.undefinedapi.builders.ItemBuilder
import com.redmagic.undefinedapi.extension.string.toComponent
import com.redmagic.undefinedapi.menu.MenuManager.openMenu
import com.redmagic.undefinedapi.menu.MenuSize
import com.redmagic.undefinedapi.menu.normal.UndefinedMenu
import com.redmagic.undefinedapi.menu.normal.button.Button
import com.redmagic.undefinedapi.menu.normal.button.MenuButton
import com.redmagic.undefinedtoggles.UndefinedToggles
import com.redmagic.undefinedtoggles.exstions.isNegative
import net.kyori.adventure.text.Component
import net.wesjd.anvilgui.AnvilGUI
import org.bukkit.Material
import org.bukkit.inventory.Inventory

class ReductionGUI(private val plugin: UndefinedToggles): UndefinedMenu("ʀᴇᴅᴜᴄᴛɪᴏɴ", MenuSize.MINI) {
    override fun generateInventory(): Inventory = createInventory {

        fillEmpty(ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName(" ").build())

        setItem(
            18, ItemBuilder(Material.RED_STAINED_GLASS_PANE)
                .setName("<!i><#d92323>ʙᴀᴄᴋ ᴛᴏ ᴀᴅᴍɪɴ ᴍᴇɴᴜ".toComponent())
                .addLine(" ".toComponent())
                .addLine("<!i><gray>ᴄʟɪᴄᴋ ᴛᴏ ɢᴏ ʙᴀᴄᴋ ᴛᴏ ᴀᴅᴍɪɴ ᴍᴇɴᴜ".toComponent()).build()
        )

        addButton(MenuButton(18, plugin.guiManager.adminGUI) {})

        setCrystals(this)
        setAnchors(this)
        setBedExplosions(this)
        setTntMinecart(this)
        setTnt(this)
        setFallDamage(this)

        addButton(Button(10) {

            if (click.isLeftClick) {

                val builder = AnvilGUI.Builder()
                    .itemLeft(ItemBuilder(item!!.type).setName("<!i><#870ee3>ᴇɴᴅ ᴄʀʏѕᴛᴀʟ".toComponent()).build())
                    .title("ᴇɴᴅ ᴄʀʏѕᴛᴀʟ ʀᴇᴅᴜᴄᴛɪᴏɴ")
                    .text(plugin.configManager.reduction.crystals.toString())
                    .plugin(plugin)
                builder.onClick { _, clickEvent ->

                    val text = clickEvent.text

                    try {

                        val cooldown = text.toDouble()

                        plugin.configManager.reduction.crystals = cooldown

                        setCrystals(this@createInventory)

                    } catch (e: NumberFormatException) {
                        player.sendMessage("<!i><#d92323>$text ɪѕ ɴᴏᴛ ᴀ ɴᴜᴍʙᴇʀ.".toComponent())
                    }

                    return@onClick listOf(AnvilGUI.ResponseAction.run {
                        player.openMenu(plugin.guiManager.reductionGUI)
                    })

                }

                builder.open(player)

            }else if (click.isRightClick){
                plugin.configManager.reduction.crystals = if (plugin.configManager.reduction.crystals == 0.0) 100.0 else 0.0
                setCrystals(this@createInventory)
            }
        })
        addButton(Button(11) {

            if (click.isLeftClick) {

                val builder = AnvilGUI.Builder()
                    .itemLeft(ItemBuilder(item!!.type).setName("<!i><#e3950e>ʀᴇѕᴘᴀᴡɴ ᴀɴᴄʜᴏʀѕ".toComponent()).build())
                    .title("ʀᴇѕᴘᴀᴡɴ ᴀɴᴄʜᴏʀѕ ʀᴇᴅᴜᴄᴛɪᴏɴ")
                    .text(plugin.configManager.reduction.anchors.toString())
                    .plugin(plugin)
                builder.onClick { _, clickEvent ->

                    val text = clickEvent.text

                    try {

                        val cooldown = text.toDouble()

                        plugin.configManager.reduction.anchors = cooldown

                        setAnchors(this@createInventory)

                    } catch (e: NumberFormatException) {
                        player.sendMessage("<!i><#d92323>$text ɪѕ ɴᴏᴛ ᴀ ɴᴜᴍʙᴇʀ.".toComponent())
                    }

                    return@onClick listOf(AnvilGUI.ResponseAction.run {
                        player.openMenu(plugin.guiManager.reductionGUI)
                    })

                }

                builder.open(player)

            }else if (click.isRightClick){
                plugin.configManager.reduction.anchors = if (plugin.configManager.reduction.anchors == 0.0) 100.0 else 0.0
                setAnchors(this@createInventory)
            }
        })
        addButton(Button(12) {

            if (click.isLeftClick) {

                val builder = AnvilGUI.Builder()
                    .itemLeft(ItemBuilder(item!!.type).setName("<!i><#e3670e>ʙᴇᴅ ᴇxᴘʟᴏѕɪᴏɴѕ".toComponent()).build())
                    .title("ʙᴇᴅ ᴇxᴘʟᴏѕɪᴏɴѕ ʀᴇᴅᴜᴄᴛɪᴏɴ")
                    .text(plugin.configManager.reduction.bedExplosions.toString())
                    .plugin(plugin)
                builder.onClick { _, clickEvent ->

                    val text = clickEvent.text

                    try {

                        val cooldown = text.toDouble()

                        plugin.configManager.reduction.bedExplosions = cooldown

                        setBedExplosions(this@createInventory)

                    } catch (e: NumberFormatException) {
                        player.sendMessage("<!i><#d92323>$text ɪѕ ɴᴏᴛ ᴀ ɴᴜᴍʙᴇʀ.".toComponent())
                    }

                    return@onClick listOf(AnvilGUI.ResponseAction.run {
                        player.openMenu(plugin.guiManager.reductionGUI)
                    })

                }

                builder.open(player)

            }else if (click.isRightClick){
                plugin.configManager.reduction.bedExplosions = if (plugin.configManager.reduction.bedExplosions == 0.0) 100.0 else 0.0
                setBedExplosions(this@createInventory)
            }
        })
        addButton(Button(14) {

            if (click.isLeftClick) {

                val builder = AnvilGUI.Builder()
                    .itemLeft(ItemBuilder(item!!.type).setName("<!i><#4e0ee3>ᴛɴᴛ ᴍɪɴᴇᴄᴀʀᴛ".toComponent()).build())
                    .title("ᴛɴᴛ ᴍɪɴᴇᴄᴀʀᴛ ʀᴇᴅᴜᴄᴛɪᴏɴ")
                    .text(plugin.configManager.reduction.tntMinecart.toString())
                    .plugin(plugin)
                builder.onClick { _, clickEvent ->

                    val text = clickEvent.text

                    try {

                        val cooldown = text.toDouble()

                        plugin.configManager.reduction.tntMinecart = cooldown

                        setTntMinecart(this@createInventory)

                    } catch (e: NumberFormatException) {
                        player.sendMessage("<!i><#d92323>$text ɪѕ ɴᴏᴛ ᴀ ɴᴜᴍʙᴇʀ.".toComponent())
                    }

                    return@onClick listOf(AnvilGUI.ResponseAction.run {
                        player.openMenu(plugin.guiManager.reductionGUI)
                    })

                }

                builder.open(player)

            }else if (click.isRightClick){
                plugin.configManager.reduction.tntMinecart = if (plugin.configManager.reduction.tntMinecart == 0.0) 100.0 else 0.0
                setTntMinecart(this@createInventory)
            }
        })
        addButton(Button(15) {

            if (click.isLeftClick) {

                val builder = AnvilGUI.Builder()
                    .itemLeft(ItemBuilder(item!!.type).setName("<!i><#eb5959>ᴛɴᴛ".toComponent()).build())
                    .title("ᴛɴᴛ ʀᴇᴅᴜᴄᴛɪᴏɴ")
                    .text(plugin.configManager.reduction.tnt.toString())
                    .plugin(plugin)
                builder.onClick { _, clickEvent ->

                    val text = clickEvent.text

                    try {

                        val cooldown = text.toDouble()

                        plugin.configManager.reduction.tnt = cooldown

                        setTnt(this@createInventory)

                    } catch (e: NumberFormatException) {
                        player.sendMessage("<!i><#d92323>$text ɪѕ ɴᴏᴛ ᴀ ɴᴜᴍʙᴇʀ.".toComponent())
                    }

                    return@onClick listOf(AnvilGUI.ResponseAction.run {
                        player.openMenu(plugin.guiManager.reductionGUI)
                    })

                }

                builder.open(player)

            }else if (click.isRightClick){
                plugin.configManager.reduction.tnt = if (plugin.configManager.reduction.tnt == 0.0) 100.0 else 0.0
                setTnt(this@createInventory)
            }
        })
        addButton(Button(16) {

            if (click.isLeftClick) {

                val builder = AnvilGUI.Builder()
                    .itemLeft(ItemBuilder(item!!.type).setName("<!i><#59d5eb>ꜰᴀʟʟ ᴅᴀᴍᴀɢᴇ".toComponent()).build())
                    .title("ꜰᴀʟʟ ᴅᴀᴍᴀɢᴇ")
                    .text(plugin.configManager.reduction.fallDamage.toString())
                    .plugin(plugin)
                builder.onClick { _, clickEvent ->

                    val text = clickEvent.text

                    try {

                        val cooldown = text.toDouble()

                        plugin.configManager.reduction.fallDamage = cooldown

                        setFallDamage(this@createInventory)

                    } catch (e: NumberFormatException) {
                        player.sendMessage("<!i><#d92323>$text ɪѕ ɴᴏᴛ ᴀ ɴᴜᴍʙᴇʀ.".toComponent())
                    }

                    return@onClick listOf(AnvilGUI.ResponseAction.run {
                        player.openMenu(plugin.guiManager.reductionGUI)
                    })

                }

                builder.open(player)

            }else if (click.isRightClick){
                plugin.configManager.reduction.fallDamage = if (plugin.configManager.reduction.fallDamage == 0.0) 100.0 else 0.0
                setFallDamage(this@createInventory)
            }
        })
    }


    private fun setCrystals(inventory: Inventory){

        val disable = plugin.configManager.reduction.crystals.isNegative()

        val itemBuilder = ItemBuilder(Material.END_CRYSTAL)
            .setName("<!i><#870ee3>ᴇɴᴅ ᴄʀʏѕᴛᴀʟ".toComponent())
            .addLine(" ".toComponent())

        if (disable || plugin.configManager.reduction.crystals == 0.0){
            itemBuilder.addLine("<!i><#d92323>ɴᴏᴛ ᴍᴏᴅɪꜰɪᴇᴅ".toComponent())
        }else if (plugin.configManager.reduction.crystals >= 100.0){
            itemBuilder.addLine("<!i><#32e67d>ꜰᴜʟʟʏ ʀᴇᴅᴜᴄᴇᴅ".toComponent())
        }else{
            itemBuilder.addLine("<!i><aqua>ʀᴇᴅᴜᴄᴇᴅ ʙʏ <gray>${plugin.configManager.reduction.crystals}%".toComponent())
        }
        itemBuilder.addLine(" ".toComponent())
            .addLine("<!i><gray>ʟᴇꜰᴛ ᴄʟɪᴄᴋ ᴛᴏ ѕᴇᴛ ᴀɴ ᴄᴜѕᴛᴏᴍ ʀᴇᴅᴜᴄᴛɪᴏɴ".toComponent())
            .addLine("<!i><gray>ʀɪɢʜᴛ ᴄʟɪᴄᴋ ᴛᴏ ᴛᴏɢɢʟᴇ ᴛʜᴇ ʀᴇᴅᴜᴄᴛɪᴏɴ".toComponent())

        inventory.setItem(10, itemBuilder.build())

    }
    private fun setAnchors(inventory: Inventory){

        val disable = plugin.configManager.reduction.anchors.isNegative()

        val itemBuilder = ItemBuilder(Material.RESPAWN_ANCHOR)
            .setName("<!i><#e3950e>ʀᴇѕᴘᴀᴡɴ ᴀɴᴄʜᴏʀѕ".toComponent())
            .addLine(" ".toComponent())

        if (disable || plugin.configManager.reduction.anchors == 0.0){
            itemBuilder.addLine("<!i><#d92323>ɴᴏᴛ ᴍᴏᴅɪꜰɪᴇᴅ".toComponent())
        }else if (plugin.configManager.reduction.anchors >= 100.0){
            itemBuilder.addLine("<!i><#32e67d>ꜰᴜʟʟʏ ʀᴇᴅᴜᴄᴇᴅ".toComponent())
        }else{
            itemBuilder.addLine("<!i><aqua>ʀᴇᴅᴜᴄᴇᴅ ʙʏ <gray>${plugin.configManager.reduction.anchors}%".toComponent())
        }
        itemBuilder.addLine(" ".toComponent())
            .addLine("<!i><gray>ʟᴇꜰᴛ ᴄʟɪᴄᴋ ᴛᴏ ѕᴇᴛ ᴀɴ ᴄᴜѕᴛᴏᴍ ʀᴇᴅᴜᴄᴛɪᴏɴ".toComponent())
            .addLine("<!i><gray>ʀɪɢʜᴛ ᴄʟɪᴄᴋ ᴛᴏ ᴛᴏɢɢʟᴇ ᴛʜᴇ ʀᴇᴅᴜᴄᴛɪᴏɴ".toComponent())

        inventory.setItem(11, itemBuilder.build())

    }
    private fun setBedExplosions(inventory: Inventory){

        val disable = plugin.configManager.reduction.anchors.isNegative()

        val itemBuilder = ItemBuilder(Material.RED_BED)
            .setName("<!i><#e3670e>ʙᴇᴅ ᴇxᴘʟᴏѕɪᴏɴѕ".toComponent())
            .addLine(" ".toComponent())

        if (disable || plugin.configManager.reduction.bedExplosions == 0.0){
            itemBuilder.addLine("<!i><#d92323>ɴᴏᴛ ᴍᴏᴅɪꜰɪᴇᴅ".toComponent())
        }else if (plugin.configManager.reduction.bedExplosions >= 100.0){
            itemBuilder.addLine("<!i><#32e67d>ꜰᴜʟʟʏ ʀᴇᴅᴜᴄᴇᴅ".toComponent())
        }else{
            itemBuilder.addLine("<!i><aqua>ʀᴇᴅᴜᴄᴇᴅ ʙʏ <gray>${plugin.configManager.reduction.bedExplosions}%".toComponent())
        }
        itemBuilder.addLine(" ".toComponent())
            .addLine("<!i><gray>ʟᴇꜰᴛ ᴄʟɪᴄᴋ ᴛᴏ ѕᴇᴛ ᴀɴ ᴄᴜѕᴛᴏᴍ ʀᴇᴅᴜᴄᴛɪᴏɴ".toComponent())
            .addLine("<!i><gray>ʀɪɢʜᴛ ᴄʟɪᴄᴋ ᴛᴏ ᴛᴏɢɢʟᴇ ᴛʜᴇ ʀᴇᴅᴜᴄᴛɪᴏɴ".toComponent())

        inventory.setItem(12, itemBuilder.build())

    }
    private fun setTntMinecart(inventory: Inventory){

        val disable = plugin.configManager.reduction.tntMinecart.isNegative()

        val itemBuilder = ItemBuilder(Material.TNT_MINECART)
            .setName("<!i><#4e0ee3>ᴛɴᴛ ᴍɪɴᴇᴄᴀʀᴛ".toComponent())
            .addLine(" ".toComponent())

        if (disable || plugin.configManager.reduction.tntMinecart == 0.0){
            itemBuilder.addLine("<!i><#d92323>ɴᴏᴛ ᴍᴏᴅɪꜰɪᴇᴅ".toComponent())
        }else if (plugin.configManager.reduction.tntMinecart >= 100.0){
            itemBuilder.addLine("<!i><#32e67d>ꜰᴜʟʟʏ ʀᴇᴅᴜᴄᴇᴅ".toComponent())
        }else{
            itemBuilder.addLine("<!i><aqua>ʀᴇᴅᴜᴄᴇᴅ ʙʏ <gray>${plugin.configManager.reduction.tntMinecart}%".toComponent())
        }
        itemBuilder.addLine(" ".toComponent())
            .addLine("<!i><gray>ʟᴇꜰᴛ ᴄʟɪᴄᴋ ᴛᴏ ѕᴇᴛ ᴀɴ ᴄᴜѕᴛᴏᴍ ʀᴇᴅᴜᴄᴛɪᴏɴ".toComponent())
            .addLine("<!i><gray>ʀɪɢʜᴛ ᴄʟɪᴄᴋ ᴛᴏ ᴛᴏɢɢʟᴇ ᴛʜᴇ ʀᴇᴅᴜᴄᴛɪᴏɴ".toComponent())

        inventory.setItem(14, itemBuilder.build())

    }
    private fun setTnt(inventory: Inventory){

        val disable = plugin.configManager.reduction.tnt.isNegative()

        val itemBuilder = ItemBuilder(Material.TNT)
            .setName("<!i><#eb5959>ᴛɴᴛ".toComponent())
            .addLine(" ".toComponent())

        if (disable || plugin.configManager.reduction.tnt == 0.0){
            itemBuilder.addLine("<!i><#d92323>ɴᴏᴛ ᴍᴏᴅɪꜰɪᴇᴅ".toComponent())
        }else if (plugin.configManager.reduction.tnt >= 100.0){
            itemBuilder.addLine("<!i><#32e67d>ꜰᴜʟʟʏ ʀᴇᴅᴜᴄᴇᴅ".toComponent())
        }else{
            itemBuilder.addLine("<!i><aqua>ʀᴇᴅᴜᴄᴇᴅ ʙʏ <gray>${plugin.configManager.reduction.tnt}%".toComponent())
        }
        itemBuilder.addLine(" ".toComponent())
            .addLine("<!i><gray>ʟᴇꜰᴛ ᴄʟɪᴄᴋ ᴛᴏ ѕᴇᴛ ᴀɴ ᴄᴜѕᴛᴏᴍ ʀᴇᴅᴜᴄᴛɪᴏɴ".toComponent())
            .addLine("<!i><gray>ʀɪɢʜᴛ ᴄʟɪᴄᴋ ᴛᴏ ᴛᴏɢɢʟᴇ ᴛʜᴇ ʀᴇᴅᴜᴄᴛɪᴏɴ".toComponent())

        inventory.setItem(15, itemBuilder.build())

    }
    private fun setFallDamage(inventory: Inventory){

        val disable = plugin.configManager.reduction.fallDamage.isNegative()

        val itemBuilder = ItemBuilder(Material.FEATHER)
            .setName("<!i><#59d5eb>ꜰᴀʟʟ ᴅᴀᴍᴀɢᴇ".toComponent())
            .addLine(" ".toComponent())

        if (disable || plugin.configManager.reduction.fallDamage == 0.0){
            itemBuilder.addLine("<!i><#d92323>ɴᴏᴛ ᴍᴏᴅɪꜰɪᴇᴅ".toComponent())
        }else if (plugin.configManager.reduction.fallDamage >= 100.0){
            itemBuilder.addLine("<!i><#32e67d>ꜰᴜʟʟʏ ʀᴇᴅᴜᴄᴇᴅ".toComponent())
        }else{
            itemBuilder.addLine("<!i><aqua>ʀᴇᴅᴜᴄᴇᴅ ʙʏ <gray>${plugin.configManager.reduction.fallDamage}%".toComponent())
        }
        itemBuilder.addLine(" ".toComponent())
            .addLine("<!i><gray>ʟᴇꜰᴛ ᴄʟɪᴄᴋ ᴛᴏ ѕᴇᴛ ᴀɴ ᴄᴜѕᴛᴏᴍ ʀᴇᴅᴜᴄᴛɪᴏɴ".toComponent())
            .addLine("<!i><gray>ʀɪɢʜᴛ ᴄʟɪᴄᴋ ᴛᴏ ᴛᴏɢɢʟᴇ ᴛʜᴇ ʀᴇᴅᴜᴄᴛɪᴏɴ".toComponent())

        inventory.setItem(16, itemBuilder.build())

    }
}
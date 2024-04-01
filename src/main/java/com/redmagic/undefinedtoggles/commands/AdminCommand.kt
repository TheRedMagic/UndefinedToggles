package com.redmagic.undefinedtoggles.commands

import com.redmagic.undefinedapi.command.CommandTabUtil
import com.redmagic.undefinedapi.command.CommandType
import com.redmagic.undefinedapi.command.UndefinedCommand
import com.redmagic.undefinedapi.menu.MenuManager.openMenu
import com.redmagic.undefinedtoggles.UndefinedToggles
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class AdminCommand(val plugin: UndefinedToggles): UndefinedCommand("admintoggles", permission = "undefined.toggles.admin.command", description = "The admin gui for the toggles", commandType = CommandType.PLAYER, aliases = listOf("at")) {

    override fun execute(sender: CommandSender, args: Array<out String>) {

        val player = sender as Player
        player.openMenu(plugin.guiManager.adminGUI)

    }

    override fun tabComplete(sender: CommandSender, args: Array<out String>): CommandTabUtil = CommandTabUtil(listOf(), 0)
}
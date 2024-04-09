package com.redmagic.undefinedtoggles.commands

import com.redmagic.undefinedapi.menu.MenuManager.openMenu
import com.redmagic.undefinedtoggles.UndefinedToggles
import com.redmagic.undefinedtoggles.gui.admin.AdminGUI
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class AdminCommand(val plugin: UndefinedToggles): CommandExecutor {
    override fun onCommand(p0: CommandSender, p1: Command, p2: String, p3: Array<out String>): Boolean {
        if (p0 is Player) {
            p0.openMenu(AdminGUI(plugin))
        }
        return true
    }

}
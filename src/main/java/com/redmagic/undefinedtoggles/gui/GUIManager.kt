package com.redmagic.undefinedtoggles.gui

import com.redmagic.undefinedtoggles.UndefinedToggles

class GUIManager(private val plugin: UndefinedToggles) {

    val adminGUI = AdminGUI(plugin)

    val cooldownGUI = CooldownGUI(plugin)

    val togglesGUI = TogglesGUI(plugin)


}
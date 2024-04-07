package com.redmagic.undefinedtoggles.gui

import com.redmagic.undefinedtoggles.UndefinedToggles
import com.redmagic.undefinedtoggles.gui.admin.AdminGUI
import com.redmagic.undefinedtoggles.gui.admin.sub.*

class GUIManager(private val plugin: UndefinedToggles) {

    val adminGUI = AdminGUI(plugin)

    val blocksGUI = BlocksGUI(plugin)

    val cooldownGUI = CooldownGUI(plugin)

    val togglesGUI = TogglesGUI(plugin)

    val reductionGUI = ReductionGUI(plugin)

    val spawningGUI = SpawningGUI(plugin)


}
package com.redmagic.undefinedtoggles.gui

import com.redmagic.undefinedtoggles.UndefinedToggles
import com.redmagic.undefinedtoggles.gui.admin.AdminGUI
import com.redmagic.undefinedtoggles.gui.admin.sub.CooldownGUI
import com.redmagic.undefinedtoggles.gui.admin.sub.ReductionGUI
import com.redmagic.undefinedtoggles.gui.admin.sub.TogglesGUI

class GUIManager(private val plugin: UndefinedToggles) {

    val adminGUI = AdminGUI(plugin)

    val cooldownGUI = CooldownGUI(plugin)

    val togglesGUI = TogglesGUI(plugin)

    val reductionGUI = ReductionGUI(plugin)


}
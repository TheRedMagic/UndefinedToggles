package com.redmagic.undefinedtoggles.toggles

import com.redmagic.undefinedapi.event.event
import com.redmagic.undefinedtoggles.UndefinedToggles
import org.bukkit.event.entity.VillagerCareerChangeEvent

class VillagerTogglesEvent {

    init {

        event<VillagerCareerChangeEvent> {

            if (this.reason == VillagerCareerChangeEvent.ChangeReason.LOSING_JOB && UndefinedToggles.plugin.configManager.toggles.villagerChangeTrade)
                isCancelled = true

        }

    }

}
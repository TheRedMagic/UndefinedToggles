package com.redmagic.undefinedtoggles

import com.redmagic.undefinedapi.UndefinedAPI
import com.redmagic.undefinedapi.event.event
import com.redmagic.undefinedapi.nms.extension.getConnection
import com.redmagic.undefinedapi.nms.minecraftVersion.v1_20_4.NMSPlayer1_20_4
import com.redmagic.undefinedapi.scheduler.TimeUnit
import com.redmagic.undefinedapi.scheduler.repeatingTask
import com.redmagic.undefinedtoggles.commands.AdminCommand
import com.redmagic.undefinedtoggles.modifier.cooldowns.CoolDownEvent
import com.redmagic.undefinedtoggles.data.ConfigManager
import com.redmagic.undefinedtoggles.gui.GUIManager
import com.redmagic.undefinedtoggles.modifier.reduction.BlockReductionEvent
import com.redmagic.undefinedtoggles.modifier.reduction.EntityReductionEvent
import com.redmagic.undefinedtoggles.modifier.spawning.EntitySpawningEvent
import com.redmagic.undefinedtoggles.modifier.spawning.ItemSpawningEvent
import com.redmagic.undefinedtoggles.modifier.toggles.CraftingTogglesEvent
import com.redmagic.undefinedtoggles.modifier.toggles.ElytraTogglesEvent
import com.redmagic.undefinedtoggles.modifier.toggles.ExplosionTogglesEvent
import com.redmagic.undefinedtoggles.modifier.toggles.VillagerTogglesEvent
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.plugin.java.JavaPlugin
import java.io.File

class UndefinedToggles : JavaPlugin() {

    lateinit var configuration: YamlConfiguration

    private lateinit var configFile: File

    lateinit var configManager: ConfigManager

    lateinit var guiManager: GUIManager


    companion object{
        lateinit var plugin: UndefinedToggles
    }

    override fun onEnable() {

        plugin = this

        UndefinedAPI(this)


        getCommand("admintoggles")!!.setExecutor(AdminCommand(this))

        loadConfig()

        configManager = ConfigManager(this)

        guiManager = GUIManager(this)

        startAutoSaving()

        events()

    }

    override fun onDisable() {

        configManager.saveAll()

        configuration.save(configFile)
    }

    private fun commands(){
        AdminCommand(this)
    }

    private fun events(){
        CoolDownEvent()
        CraftingTogglesEvent()
        VillagerTogglesEvent()
        ExplosionTogglesEvent()
        ElytraTogglesEvent()
        EntityReductionEvent()
        BlockReductionEvent()
        EntitySpawningEvent()
        ItemSpawningEvent()
        //MaxAmountEvent()
    }

    private fun loadConfig(){
        configFile = File(dataFolder, "config.yml")

        if (!configFile.exists()){
            configFile.parentFile.mkdir()
            saveResource("config.yml", true)
        }

        configuration = YamlConfiguration.loadConfiguration(configFile)
    }


    private fun startAutoSaving(){
        repeatingTask(10, TimeUnit.MINUTES){
            configManager.saveAll()
            configuration.save(configFile)
        }
    }
}

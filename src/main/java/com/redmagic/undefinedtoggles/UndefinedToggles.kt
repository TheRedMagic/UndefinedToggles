package com.redmagic.undefinedtoggles

import com.redmagic.undefinedapi.UndefinedAPI
import com.redmagic.undefinedapi.scheduler.TimeUnit
import com.redmagic.undefinedapi.scheduler.repeatingTask
import com.redmagic.undefinedtoggles.commands.AdminCommand
import com.redmagic.undefinedtoggles.cooldowns.CoolDownEvent
import com.redmagic.undefinedtoggles.data.ConfigManager
import com.redmagic.undefinedtoggles.data.types.Cooldowns
import com.redmagic.undefinedtoggles.gui.GUIManager
import com.redmagic.undefinedtoggles.toggles.CraftingTogglesEvent
import com.redmagic.undefinedtoggles.toggles.ElytraTogglesEvent
import com.redmagic.undefinedtoggles.toggles.ExplosionTogglesEvent
import com.redmagic.undefinedtoggles.toggles.VillagerTogglesEvent
import org.bukkit.Material
import org.bukkit.configuration.file.YamlConfiguration
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

        UndefinedAPI(this)

        plugin = this

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

package com.redmagic.undefinedtoggles

import com.redmagic.undefinedapi.UndefinedAPI
import com.redmagic.undefinedapi.scheduler.TimeUnit
import com.redmagic.undefinedapi.scheduler.repeatingTask
import com.redmagic.undefinedtoggles.commands.AdminCommand
import com.redmagic.undefinedtoggles.data.ConfigManager
import com.redmagic.undefinedtoggles.gui.GUIManager
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.plugin.java.JavaPlugin
import java.io.File

class UndefinedToggles : JavaPlugin() {

    lateinit var configuration: YamlConfiguration

    private lateinit var configFile: File

    lateinit var configManager: ConfigManager

    lateinit var guiManager: GUIManager

    override fun onEnable() {

        UndefinedAPI(this)

        loadConfig()

        configManager = ConfigManager(this)

        guiManager = GUIManager(this)

        commands()

        startAutoSaving()

    }



    override fun onDisable() {

        configManager.saveAll()

        configuration.save(configFile)

    }


    private fun commands(){
        AdminCommand(this)
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

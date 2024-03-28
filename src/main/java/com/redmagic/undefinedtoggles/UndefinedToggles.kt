package com.redmagic.undefinedtoggles

import com.redmagic.undefinedapi.UndefinedAPI
import com.redmagic.undefinedtoggles.data.ConfigManager
import com.redmagic.undefinedtoggles.exstions.isNegative
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.plugin.java.JavaPlugin
import java.io.File

class UndefinedToggles : JavaPlugin() {

    lateinit var configuration: YamlConfiguration;

    private lateinit var configFile: File;

    lateinit var configManager: ConfigManager

    override fun onEnable() {

        UndefinedAPI(this)

        loadConfig()

        configManager = ConfigManager(this)

    }



    override fun onDisable() {

        configManager.saveAll()

        configuration.save(configFile)

    }


    private fun loadConfig(){
        configFile = File(dataFolder, "config.yml")

        if (!configFile.exists()){
            configFile.parentFile.mkdir()
            saveResource("config.yml", true)
        }

        configuration = YamlConfiguration.loadConfiguration(configFile)
    }
}

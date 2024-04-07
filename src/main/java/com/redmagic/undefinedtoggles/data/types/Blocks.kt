package com.redmagic.undefinedtoggles.data.types

import com.redmagic.undefinedapi.builders.ItemBuilder
import com.redmagic.undefinedapi.extension.string.toSmallText
import com.redmagic.undefinedapi.extension.string.translateColor
import com.redmagic.undefinedtoggles.UndefinedToggles
import org.bukkit.Material
import org.bukkit.entity.EntityType
import org.bukkit.inventory.ItemStack

class Blocks(private val plugin: UndefinedToggles) {

    val blockedCommands: MutableList<BlockCommand> = mutableListOf()

    val spawning: BlockSpawning

    init {
        plugin.configuration.getConfigurationSection("blocked.commands")?.getKeys(false)?.forEach {
            val command = it
            val permission = plugin.configuration.getString("blocked.commands.$command.permission")!!
            val blockTabComplete = plugin.configuration.getBoolean("blocked.commands.$command.block-tab-complete")
            blockedCommands.add(BlockCommand(command, permission, blockTabComplete))
        }

        val blockedEntity: MutableList<EntityType> = mutableListOf()

        val blockItem: MutableList<Material> = mutableListOf()

        plugin.configuration.getStringList("blocked.spawning.mobs").forEach {
            blockedEntity.add(EntityType.valueOf(it))
        }

        plugin.configuration.getStringList("blocked.spawning.item").forEach {
            blockItem.add(Material.valueOf(it))
        }

        spawning = BlockSpawning(blockedEntity, blockItem, plugin)


    }

    fun save(){

        blockedCommands.forEach {
            plugin.configuration.set("blocked.commands.${it.command}.permission", it.permission)
            plugin.configuration.set("blocked.commands.${it.command}.block-tab-complete", it.blockTabComplete)
        }

        spawning.save()
    }

}


fun MutableList<BlockCommand>.getList() = map {
    ItemBuilder(Material.OAK_SIGN)
        .setName("<reset><#34ebc0>${it.command.toSmallText()}".translateColor())
        .addLine(" ")
        .addLine("<gray>ʟᴇꜰᴛ ᴄʟɪᴄᴋ ᴛᴏ ᴇᴅɪᴛ / ᴠɪᴇᴡ ʙʟᴏᴄᴋᴇᴅ ᴄᴏᴍᴍᴀɴᴅ".translateColor())
        .addLine("<gray>ʀɪɢʜᴛ ᴄʟɪᴄᴋ ᴛᴏ ʀᴇᴍᴏᴠᴇ ʙʟᴏᴄᴋᴇᴅ ᴄᴏᴍᴍᴀɴᴅ".translateColor())
        .setLocalizedName(it.command)
        .build()
}.toMutableList()

fun MutableList<BlockCommand>.getFromName(name: String): BlockCommand? {
    forEach(){
        if (it.command.equals(name))
            return it
    }
    return null
}
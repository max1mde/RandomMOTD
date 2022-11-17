package com.maximde.randommotd.utils

import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.entity.Player
import java.io.File
import java.io.IOException

object MotdList {

    var file = File("plugins/RandomMOTD", "motd-list.yml")

    var config: YamlConfiguration = YamlConfiguration.loadConfiguration(file)

    fun reloadFile() {
        config = YamlConfiguration.loadConfiguration(file)
    }

    fun setupList() {
        if(!config.isSet("MOTD")) {
            config.set("MOTD.1", "Example MOTD 1");
            config.set("MOTD.1", "Example MOTD 2");
            config.set("MOTD.1", "Example MOTD 3");
            saveConfig();
        }
    }

    fun getMOTDList() : ArrayList<String> {
        val cs = config.getConfigurationSection("MOTD")!!
        var list: ArrayList<String> = ArrayList()
        if (cs.isSet("MOTD")) {
            for (key in cs.getKeys(false)) {
                config.getString("MOTD.$key")?.let { list.add(it) }
            }
        }
        return list
    }

    fun saveConfig() {
        try {
            config.save(file)
        } catch (e: IOException) {
            System.err.println("[RandomMOTD] Error! cant save motd list file!")
            e.printStackTrace()
        }
    }
    /**
     * MaximDe 2022.
     *
     * LINKS:
     * https://github.com/JavaDevMC
     * https://www.spigotmc.org/members/1620695/
     */
}
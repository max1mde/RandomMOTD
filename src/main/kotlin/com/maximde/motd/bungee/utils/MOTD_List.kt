package com.maximde.motd.bungee.utils




import com.maximde.motd.configuration.file.YamlConfiguration
import java.io.File
import java.io.IOException

object MOTD_List {

    var file = File("plugins/RandomMOTD", "motd-list.yml")
    var config: YamlConfiguration = YamlConfiguration.loadConfiguration(file)

    fun reloadFile() {
        config = YamlConfiguration.loadConfiguration(file)
    }

    fun setupList() {
        if(!config.isSet("MOTD")) {
            config.set("MOTD.1", "Example MOTD 1\\nExample Line 2");
            config.set("MOTD.2", "§cExample MOTD 2\\nExample Line 2");
            config.set("MOTD.3", "§6Example MOTD 3\\nExample Line 2");
            saveConfig();
        }
    }

    fun getMOTDList() : ArrayList<String> {
        val cs = config.getConfigurationSection("MOTD")!!
        var list: ArrayList<String> = ArrayList()
        if(config.isSet("MOTD")) {
            for (key in cs.getKeys(false)) {
                list.add(config.getString("MOTD." + key)!!)
            }
            return list
        }
        System.out.println("[RandomMOTD] Error! List file is empty!")
        return list
    }

    private fun saveConfig() {
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
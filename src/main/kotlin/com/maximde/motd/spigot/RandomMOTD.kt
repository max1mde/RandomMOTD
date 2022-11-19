package com.maximde.motd.spigot

import com.maximde.motd.spigot.events.ServerPing
import com.maximde.motd.spigot.utils.MOTD_List
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin


class RandomMOTD : JavaPlugin() {

    override fun onEnable() {
        MOTD_List.setupList()
        Bukkit.getPluginManager().registerEvents(ServerPing(), this)
    }

    /**
     * MaximDe 2022.
     *
     * LINKS:
     * https://github.com/JavaDevMC
     * https://www.spigotmc.org/members/1620695/
     */
}
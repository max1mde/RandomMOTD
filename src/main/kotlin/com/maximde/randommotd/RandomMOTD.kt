package com.maximde.randommotd

import com.maximde.randommotd.events.ServerPing
import com.maximde.randommotd.utils.MotdList
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin


class RandomMOTD : JavaPlugin() {

    override fun onEnable() {
        MotdList.setupList()
        Bukkit.getPluginManager().registerEvents(ServerPing(), this)
    }

    override fun onDisable() {

    }

    /**
     * MaximDe 2022.
     *
     * LINKS:
     * https://github.com/JavaDevMC
     * https://www.spigotmc.org/members/1620695/
     */
}
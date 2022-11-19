package com.maximde.motd.bungee

import com.maximde.motd.bungee.events.ServerPing
import com.maximde.motd.bungee.utils.MOTD_List
import net.md_5.bungee.api.plugin.Listener
import net.md_5.bungee.api.plugin.Plugin


class RandomMOTD : Plugin() {

    override fun onEnable() {
        MOTD_List.setupList()
        proxy.pluginManager.registerListener(this, ServerPing() as Listener)
    }

    /**
     * MaximDe 2022.
     *
     * LINKS:
     * https://github.com/JavaDevMC
     * https://www.spigotmc.org/members/1620695/
     */
}
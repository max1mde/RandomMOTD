package com.maximde.motd.bungee.events

import com.maximde.motd.bungee.utils.MOTD_List
import net.md_5.bungee.api.event.ProxyPingEvent
import net.md_5.bungee.api.plugin.Listener
import net.md_5.bungee.event.EventHandler
import net.md_5.bungee.event.EventPriority
import java.util.concurrent.ThreadLocalRandom


class ServerPing : Listener {

    var motd_list = ArrayList<String>()

    @EventHandler(priority = EventPriority.HIGH)
    fun onServerPing(event: ProxyPingEvent) {
        motd_list = MOTD_List.getMOTDList()
        try {
            if(motd_list.isEmpty()) {
                motd_list = MOTD_List.getMOTDList()
            }
            val max = motd_list.size
            if(max != 0) {
                val message: Int = ThreadLocalRandom.current().nextInt(max)
                event.response.description = motd_list[message]
            }
        } catch (ex: IndexOutOfBoundsException) {
            ex.printStackTrace()
        }

        //Update config file
        Thread {
            MOTD_List.reloadFile()
        }.start()
    }

    /**
     * MaximDe 2022.
     *
     * LINKS:
     * https://github.com/JavaDevMC
     * https://www.spigotmc.org/members/1620695/
     */
}
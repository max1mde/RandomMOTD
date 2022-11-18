package com.maximde.motd.events

import com.maximde.motd.utils.MotdList
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.server.ServerListPingEvent
import java.util.concurrent.ThreadLocalRandom


class ServerPing : Listener {

    var motd_list = ArrayList<String>()

    @EventHandler(priority = EventPriority.HIGH)
    fun onServerPing(event: ServerListPingEvent) {
        Thread {
            MotdList.reloadFile()
        }.start()
        motd_list = MotdList.getMOTDList()
        try {
            if(motd_list.isEmpty()) {
                motd_list = MotdList.getMOTDList()
            }
            val max = motd_list.size
            if(max != 0) {
                val message: Int = ThreadLocalRandom.current().nextInt(max)
                event.motd = motd_list[message]
            }
        } catch (ex: IndexOutOfBoundsException) {
            ex.printStackTrace()
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
package com.maximde.randommotd.events

import com.maximde.randommotd.utils.MotdList
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.server.ServerListPingEvent
import java.util.concurrent.ThreadLocalRandom


class ServerPing : Listener {

    var list = ArrayList<String>()

    @EventHandler(priority = EventPriority.HIGH)
    fun onServerPing(event: ServerListPingEvent) {
        try {
            if(list.isEmpty()) {
                list = MotdList.getMOTDList()
            }
            val max = list.size
            val message: Int = ThreadLocalRandom.current().nextInt(max)
            event.motd = list[message]
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
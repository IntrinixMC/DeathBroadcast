package me.intrinix.deathbroadcast.events;

import me.intrinix.deathbroadcast.DeathBroadcast;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.List;
import java.util.Random;

public class PlayerDeath implements Listener {

    DeathBroadcast plugin;
    Random random = new Random();
    public PlayerDeath(DeathBroadcast plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        final String PREFIX = "[Server]";
        Player player = event.getEntity().getPlayer();
        assert player != null;
        String playerName = player.getDisplayName();
        String defaultBroadcastMsg = ChatColor.translateAlternateColorCodes('&', "&4&lF");
        List<String> deathBroadcastMsg = plugin.getConfig().getStringList("death-broadcast-message");
        int msgIndex = random.nextInt(deathBroadcastMsg.size());
        String newBroadcastMsg = ChatColor.translateAlternateColorCodes('&', deathBroadcastMsg.get(msgIndex).replaceAll("%player%", playerName));
        if (!deathBroadcastMsg.isEmpty()) {
            Bukkit.broadcastMessage(PREFIX + " " + newBroadcastMsg);
        } else {
            Bukkit.broadcastMessage(PREFIX + " " + defaultBroadcastMsg);
        }

    }


}

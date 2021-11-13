package me.intrinix.deathbroadcast.events;

import me.intrinix.deathbroadcast.DeathBroadcast;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeath implements Listener {

    DeathBroadcast plugin;

    public PlayerDeath(DeathBroadcast plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event){
        final String PREFIX = "[Server]";
        Player player = event.getEntity().getPlayer();
        assert player != null;
        String playerName = player.getDisplayName();
        String defaultBroadcastMsg = "&4&lF";
        defaultBroadcastMsg = ChatColor.translateAlternateColorCodes('&', defaultBroadcastMsg);
        String deathBroadcastMsg = plugin.getConfig().getString("death-broadcast-message");
        if(deathBroadcastMsg != null){
            deathBroadcastMsg = ChatColor.translateAlternateColorCodes('&', deathBroadcastMsg);
            if(deathBroadcastMsg.contains("%player%")){
                deathBroadcastMsg = deathBroadcastMsg.replaceAll("%player%", playerName);
            }

            if(deathBroadcastMsg.isEmpty()){
                Bukkit.broadcastMessage(PREFIX + " " + defaultBroadcastMsg);
            } else {
                Bukkit.broadcastMessage(PREFIX + " " + deathBroadcastMsg);
            }
        }


    }


}

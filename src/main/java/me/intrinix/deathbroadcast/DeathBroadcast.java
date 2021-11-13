package me.intrinix.deathbroadcast;

import me.intrinix.deathbroadcast.events.PlayerDeath;
import org.bukkit.plugin.java.JavaPlugin;

public final class DeathBroadcast extends JavaPlugin {

    @Override
    public void onEnable() {

        new PlayerDeath(this);

        getConfig().options().copyDefaults();
        saveDefaultConfig();
    }
}

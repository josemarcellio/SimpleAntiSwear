package com.josemarcellio.simpleantiswear;

import com.josemarcellio.simpleantiswear.command.ReloadCommand;
import com.josemarcellio.simpleantiswear.listener.PlayerChatListener;
import com.josemarcellio.simpleantiswear.metrics.Metrics;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class SimpleAntiSwear extends JavaPlugin {

    private String patternString;

    public String getPatternString() {
        return patternString;
    }

    @Override
    public void onEnable() {

        new Metrics(this, 17115);

        saveDefaultConfig();
        readConfig();
        getServer().getPluginManager().registerEvents(new PlayerChatListener(this), this);
        getCommand("sawreload").setExecutor(new ReloadCommand(this));
        getLogger().info("SimpleAntiSwear by JoseMarcellio");
    }

    @Override
    public void onDisable() {
        getLogger().info("SimpleAntiSwear by JoseMarcellio");
    }

    public void readConfig() {

        FileConfiguration config = getConfig();
        patternString = config.getString("bannedWord");
        patternString = String.join("|", patternString);
    }
}

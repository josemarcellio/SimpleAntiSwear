package com.josemarcellio.simpleantiswear;

import com.josemarcellio.simpleantiswear.listener.PlayerChatListener;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class SimpleAntiSwear extends JavaPlugin {

    private String patternString;

    public String getPatternString() {
        return patternString;
    }

    @Override
    public void onEnable() {

        saveDefaultConfig();
        readConfig();
        getServer().getPluginManager().registerEvents(new PlayerChatListener(this), this);
        getLogger().info("SimpleAntiSwear by JoseMarcellio");
    }

    @Override
    public void onDisable() {
        getLogger().info("SimpleAntiSwear by JoseMarcellio");
    }

    private void readConfig() {

        FileConfiguration config = getConfig();
        patternString = config.getString("bannedWord");
        String settingConfig = config.getString("setting");
        patternString = String.join("|", patternString);
        patternString = settingConfig.replace("{bannedWord}", patternString);
    }
}

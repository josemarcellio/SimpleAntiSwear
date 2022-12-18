package com.josemarcellio.simpleantiswear.listener;

import com.josemarcellio.simpleantiswear.SimpleAntiSwear;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlayerChatListener implements Listener {
    private final SimpleAntiSwear plugin;

    public PlayerChatListener(SimpleAntiSwear plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        String chatMessage = event.getMessage();
        Player player = event.getPlayer();

        if (containsbannedWord(chatMessage)) {
            event.setCancelled(true);

            String bannedMessage = plugin.getConfig().getString("bannedMessage");
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', bannedMessage));
        }
    }

    private boolean containsbannedWord(String message) {
        String patternString = plugin.getPatternString();
        Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(message);

        return matcher.find();
    }
}

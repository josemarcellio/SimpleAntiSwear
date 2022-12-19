package com.josemarcellio.simpleantiswear.command;

import com.josemarcellio.simpleantiswear.SimpleAntiSwear;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReloadCommand implements CommandExecutor {
    private final SimpleAntiSwear plugin;

    public ReloadCommand(SimpleAntiSwear plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }

        Player player = (Player) sender;

        if (!player.hasPermission("simpleantiswear.reload")) {
            player.sendMessage(ChatColor.RED + "You don't have permission to use this command.");
            return true;
        }

        plugin.reloadConfig();
        plugin.readConfig();
        player.sendMessage(ChatColor.GREEN + "Configuration reloaded.");
        return true;
    }
}
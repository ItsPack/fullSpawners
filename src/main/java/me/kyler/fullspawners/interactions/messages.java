package me.kyler.fullspawners.interactions;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class messages {

    public static void message(Player p, String message) {

        p.sendMessage(ChatColor.translateAlternateColorCodes('&', message));

    }

}

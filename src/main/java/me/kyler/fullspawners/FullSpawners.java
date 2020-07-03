package me.kyler.fullspawners;

import com.deanveloper.skullcreator.SkullCreator;
import me.kyler.fullspawners.commands.customHead;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public final class FullSpawners extends JavaPlugin implements Listener {

    public void onEnable(){
        System.out.println("Working I Think");
        if (getServer().getOnlinePlayers().size() > 0) {
            for (Player p : getServer().getOnlinePlayers()) {
                p.getInventory().addItem(getCustomHead());
            }
        }
        getCommand("fullspawners").setExecutor(new customHead());

    }

    public static ItemStack getCustomHead() {
        // Got this base64 string from minecraft-heads.com
        String base64 = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L" +
                "3RleHR1cmUvNTIyODRlMTMyYmZkNjU5YmM2YWRhNDk3YzRmYTMwOTRjZDkzMjMxYTZiNTA1YTEyY2U3Y2Q1MTM1YmE4ZmY5MyJ9fX0=";

        return SkullCreator.withBase64(new ItemStack(Material.PLAYER_HEAD), base64);
    }
}

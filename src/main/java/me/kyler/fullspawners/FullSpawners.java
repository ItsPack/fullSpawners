package me.kyler.fullspawners;

import com.deanveloper.skullcreator.SkullCreator;
import me.kyler.fullspawners.commands.fullSpawnerCommand;
import org.bukkit.Material;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public final class FullSpawners extends JavaPlugin {

    private static File messages, spawnerData;
    private static YamlConfiguration messagesConfig, spawnerDataConfig;
    private static Configuration config;

    public void onEnable(){
        config = getConfig();
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        try {
            initiateFiles();
        } catch (IOException e) {
            e.printStackTrace();
        }

        getCommand("fullspawners").setExecutor(new fullSpawnerCommand(getServer(), getConfig()));

    }

    public static File getMessages() {
        return messages;
    }

    public static File getSpawnerData() {
        return spawnerData;
    }

    public static YamlConfiguration getMessagesConfig() {
        return messagesConfig;
    }

    public static YamlConfiguration getSpawnerDataConfig() {
        return spawnerDataConfig;
    }

    public static Configuration getLocalConfig() {
        return config;
    }

    public void initiateFiles() throws IOException {
        messages = new File(getServer().getPluginManager().getPlugin("FullSpawners").getDataFolder(), "messages.yml");
        spawnerData = new File(getServer().getPluginManager().getPlugin("FullSpawners").getDataFolder(), "SpawnerData.yml");
        if (!messages.exists()) {
            messages.createNewFile();
        }
        if (!spawnerData.exists()) {
            spawnerData.createNewFile();
        }

        messagesConfig = YamlConfiguration.loadConfiguration(messages);
        spawnerDataConfig = YamlConfiguration.loadConfiguration(spawnerData);
    }
}

package me.kyler.fullspawners.commands;

import com.deanveloper.skullcreator.SkullCreator;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import static me.kyler.fullspawners.FullSpawners.getMessagesConfig;

public class fullSpawnerCommand implements CommandExecutor {

    private Server server;

    private YamlConfiguration messages;
    private Configuration config;

    public fullSpawnerCommand(Server server, Configuration config) {
        this.server = server;
        messages = getMessagesConfig();
        this.config = config;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player pSender = (Player) sender;
            switch (args[0]) {
                case "give":
                    if (args.length == 3 || args.length == 4) {
                        Player pTarget = server.getPlayer(args[1]);
                        if (pTarget.isOnline()) {
                            if (config.getConfigurationSection("spawnerTypes").contains(args[2])) {
                                ItemStack spawner = SkullCreator.withBase64(new ItemStack(Material.PLAYER_HEAD), config.getString("spawnerTypes." + args[2] + ".base64"));
                                ItemMeta spawnerMeta = spawner.getItemMeta();
                                spawnerMeta.setDisplayName(config.getString("spawnerTypes." + args[2] + ".name"));
                                spawner.setItemMeta(spawnerMeta);
                                pTarget.getInventory().addItem(spawner);
                            } else {
                                pSender.sendMessage(messages.getString("messages.giveCommand.errorEntity"));
                            }
                        } else {
                            pSender.sendMessage(messages.getString("messages.giveCommand.errorPlayer"));
                        }
                    } else {
                        pSender.sendMessage(messages.getString("messages.giveCommand.commandUsage"));
                    }

                    break;
                case "set":
                    break;
            }
        }

        return false;
    }

}

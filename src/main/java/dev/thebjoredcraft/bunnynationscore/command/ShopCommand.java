package dev.thebjoredcraft.bunnynationscore.command;

import dev.thebjoredcraft.bunnynationscore.manager.ShopManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ShopCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player player) {
            if(args.length == 1 && args[0].equalsIgnoreCase("setup")){
                ShopManager.spawnBuyTrader(player.getLocation());
            }else{
                ShopManager.openShopGUI(player);
            }
        }
        return false;
    }
}

package dev.thebjoredcraft.bunnynationscore.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

public class SeeArmorCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player player){
            Inventory gui = Bukkit.createInventory(null, 9, "Armor and Offhand");
            Player target = Bukkit.getPlayer(args[0]);
            if(target != null || args.length != 1){
                gui.setItem(0, target.getInventory().getHelmet());
                gui.setItem(1, target.getInventory().getChestplate());
                gui.setItem(2, target.getInventory().getLeggings());
                gui.setItem(3, target.getInventory().getBoots());
                gui.setItem(4, target.getInventory().getItemInOffHand());

                player.openInventory(gui);
            }else{
                player.sendMessage("Der Spieler wurde nicht gefunden!");
            }
        }
        return false;
    }
}

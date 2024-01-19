package dev.thebjoredcraft.bunnynationscore.command.money;

import dev.thebjoredcraft.bunnynationscore.manager.PlayerDataManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class PayCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player player){
            int count = Integer.parseInt(args[1]);
            Player target = Bukkit.getPlayer(args[0]);
            if(target != null){
                PlayerDataManager.addMoney(target, count);
                PlayerDataManager.removeMoney(player, count);
                player.sendMessage("Taler updated. Nun: " + PlayerDataManager.getMoney(player));
                target.sendMessage("Taler updated. Nun: " + PlayerDataManager.getMoney(target));
            }
        }
        return false;
    }
}

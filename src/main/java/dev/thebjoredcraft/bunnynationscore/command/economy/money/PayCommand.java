package dev.thebjoredcraft.bunnynationscore.command.economy.money;

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
            String counts = String.valueOf(count);
            if(target != null) {
                if (!counts.contains("-")) {
                    if (PlayerDataManager.getMoney(player) >= count) {
                        PlayerDataManager.addMoney(target, count);
                        PlayerDataManager.removeMoney(player, count);
                        player.sendMessage("Taler updated. Nun: " + PlayerDataManager.getMoney(player));
                        target.sendMessage("Taler updated. Nun: " + PlayerDataManager.getMoney(target));
                    } else {
                        player.sendMessage("Du hast nicht so viel Geld!");
                    }
                }else{
                    player.sendMessage("Bitte keine Minus-Betraege!");
                }
            }
        }
        return false;
    }
}

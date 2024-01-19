package dev.thebjoredcraft.bunnynationscore.command.money;

import dev.thebjoredcraft.bunnynationscore.manager.PlayerDataManager;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class MoneyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player player) {
            if (args.length == 2) {
                if (player.hasPermission("bunnynationscore.command.money.args")) {
                    if (args[0].equalsIgnoreCase("add")) {
                        int count = Integer.parseInt(args[1]);
                        PlayerDataManager.addMoney(player, count);
                        //<color:#3b92d1>
                        player.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>Du hast aktuell " + PlayerDataManager.getMoney(player) + " Taler!"));
                    } else if (args[0].equalsIgnoreCase("remove")) {
                        int count = Integer.parseInt(args[1]);
                        PlayerDataManager.removeMoney(player, count);
                        player.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>Deine Taler haben sich verändert. Du hast nun " + PlayerDataManager.getMoney(player) + " Taler!"));
                    } else if (args[0].equalsIgnoreCase("set")) {
                        int count = Integer.parseInt(args[1]);
                        PlayerDataManager.setMoney(player, count);
                        player.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>Deine Taler haben sich verändert. Du hast nun " + PlayerDataManager.getMoney(player) + " Taler!"));
                    }
                }else{
                    player.sendMessage("No Permission!");
                }
            }else if(args.length == 3) {
                Player target = Bukkit.getPlayer(args[1]);

                if (target != null) {
                    if (player.hasPermission("bunnynationscore.command.money.args")) {
                        if (args[0].equalsIgnoreCase("add")) {
                            int count = Integer.parseInt(args[2]);
                            PlayerDataManager.addMoney(target, count);
                            target.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>Deine Taler haben sich verändert. Du hast nun " + PlayerDataManager.getMoney(target) + " Taler!"));
                            player.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>"+ target.getName() + " Taler haben sich verändert. Nun " + PlayerDataManager.getMoney(target) + " Taler!"));
                        } else if (args[0].equalsIgnoreCase("remove")) {
                            int count = Integer.parseInt(args[2]);
                            PlayerDataManager.removeMoney(target, count);
                            target.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>Deine Taler haben sich verändert. Du hast nun " + PlayerDataManager.getMoney(target) + " Taler!"));
                            player.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>"+ target.getName() + " Taler haben sich verändert. Nun " + PlayerDataManager.getMoney(target) + " Taler!"));
                        } else if (args[0].equalsIgnoreCase("set")) {
                            int count = Integer.parseInt(args[2]);
                            PlayerDataManager.setMoney(target, count);
                            target.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>Deine Taler haben sich verändert. Du hast nun " + PlayerDataManager.getMoney(target) + " Taler!"));
                            player.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>"+ target.getName() + " Taler haben sich verändert. Nun " + PlayerDataManager.getMoney(target) + " Taler!"));
                        } else if (args[0].equalsIgnoreCase("get")) {
                            player.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>"+ target.getName() + " hat aktuell " + PlayerDataManager.getMoney(target) + " Taler!"));
                        }
                    } else {
                        player.sendMessage("No Permission!");
                    }
                }else{
                    player.sendMessage("Der Spieler wurde nicht gefunden!");
                }
            }else if(args.length == 0){
                player.sendMessage("Deine Taler: " + PlayerDataManager.getMoney(player));
            }else{
                player.sendMessage("Incorrect Usage!");
            }
        }
        return false;
    }
}

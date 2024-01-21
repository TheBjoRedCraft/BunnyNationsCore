package dev.thebjoredcraft.bunnynationscore.command.economy;

import dev.thebjoredcraft.bunnynationscore.manager.PlayerDataManager;
import dev.thebjoredcraft.bunnynationscore.manager.ShopManager;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.sound.Sound;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class SellCommand implements CommandExecutor {
    public static HashMap<Material, Integer> itemsToSell = new HashMap<>();
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player player){
            if(args.length == 1 && args[0].equalsIgnoreCase("list")){
                player.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>Zum Verkauf:"));
                player.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>1x Diamant - 50 Taler"));
                player.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>1x Iron Ingot - 25 Taler"));
                player.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>1x Gold Ingot - 50 Taler"));
                player.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>1x Emerald - 20 Taler"));
                player.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>1x Oak Holz Stamm - 1 Taler"));
                player.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>1x Blaze Rod - 50 Taler"));
                player.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>1x Kohle - 25 Taler"));
                player.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>1x Drachen Kopf - 1000 Taler"));
                player.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>1x Drachen Ei - 1000000 Taler"));
                player.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>1x Elytra - 10000 Taler"));
                player.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>1x Drachen Atem - 1000 Taler"));
                player.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>1x Verzauberter Goldener Apfel - 100000 Taler"));
                player.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>1x Goldener Apfel - 100 Taler"));
                player.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>1x Goldene Karotte - 100 Taler"));
            }else if(args.length == 1 && args[0].equalsIgnoreCase("setup")){
                ShopManager.spawnSellTrader(player.getLocation());
            }else{
                ShopManager.openSellGUI(player);
            }
        }
        return false;
    }
}

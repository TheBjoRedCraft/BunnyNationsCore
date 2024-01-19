package dev.thebjoredcraft.bunnynationscore.manager;

import dev.thebjoredcraft.bunnynationscore.BunnyNationsCore;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;

public class PlayerDataManager {
    public static NamespacedKey rules = new NamespacedKey(BunnyNationsCore.getInstance(), "accepted_rules");
    public static NamespacedKey money = new NamespacedKey(BunnyNationsCore.getInstance(), "money");
    public static void setAcceptedRules(Player player, Boolean arg){
        player.getPersistentDataContainer().set(rules, PersistentDataType.BOOLEAN, arg);
    }
    public static Boolean getAcceptedRules(Player player){
        return player.getPersistentDataContainer().get(rules, PersistentDataType.BOOLEAN);
    }
    public static void setMoney(Player player, int count){
        player.getPersistentDataContainer().set(money, PersistentDataType.INTEGER, count);
    }
    public static int getMoney(Player player){
        return player.getPersistentDataContainer().get(money, PersistentDataType.INTEGER);
    }
    public static void addMoney(Player player, int count){
        player.getPersistentDataContainer().set(money, PersistentDataType.INTEGER, getMoney(player) + count);
    }
    public static void removeMoney(Player player, int count){
        player.getPersistentDataContainer().set(money, PersistentDataType.INTEGER, getMoney(player) - count);
    }

}
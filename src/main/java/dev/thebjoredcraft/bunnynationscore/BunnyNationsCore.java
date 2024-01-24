package dev.thebjoredcraft.bunnynationscore;

import dev.thebjoredcraft.bunnynationscore.command.ActionbarCommand;
import dev.thebjoredcraft.bunnynationscore.command.SeeArmorCommand;
import dev.thebjoredcraft.bunnynationscore.command.ShopCommand;
import dev.thebjoredcraft.bunnynationscore.command.economy.SellCommand;
import dev.thebjoredcraft.bunnynationscore.command.broadcast.BroadcastAsCommand;
import dev.thebjoredcraft.bunnynationscore.command.broadcast.BroadcastCommand;
import dev.thebjoredcraft.bunnynationscore.command.RuleCommand;
import dev.thebjoredcraft.bunnynationscore.command.economy.money.MoneyCommand;
import dev.thebjoredcraft.bunnynationscore.command.economy.money.PayCommand;
import dev.thebjoredcraft.bunnynationscore.manager.ActionbarManager;
import dev.thebjoredcraft.bunnynationscore.manager.EventManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.plugin.java.JavaPlugin;

public final class BunnyNationsCore extends JavaPlugin {
    public static BunnyNationsCore instance;

    public static BunnyNationsCore getInstance() {
        return instance;
    }
    @Override
    public void onLoad() {
        // Plugin shutdown logic
        instance = this;
    }

    @Override
    public void onEnable() {
        getCommand("rules").setExecutor(new RuleCommand());
        getCommand("broadcast").setExecutor(new BroadcastCommand());
        getCommand("broadcastas").setExecutor(new BroadcastAsCommand());
        getCommand("pay").setExecutor(new PayCommand());
        getCommand("money").setExecutor(new MoneyCommand());
        getCommand("shop").setExecutor(new ShopCommand());
        getCommand("actionbar").setExecutor(new ActionbarCommand());
        getCommand("sell").setExecutor(new SellCommand());
        getCommand("armorsee").setExecutor(new SeeArmorCommand());
        Bukkit.getPluginManager().registerEvents(new EventManager(), this);
        ActionbarManager.startActionbar();
        // Plugin startup logic

        SellCommand.itemsToSell.put(Material.DIAMOND, 15);
        SellCommand.itemsToSell.put(Material.IRON_INGOT, 10);
        SellCommand.itemsToSell.put(Material.GOLD_INGOT, 10);
        SellCommand.itemsToSell.put(Material.EMERALD, 15);
        SellCommand.itemsToSell.put(Material.OAK_LOG, 1);
        SellCommand.itemsToSell.put(Material.BLAZE_ROD, 15);
        SellCommand.itemsToSell.put(Material.COAL, 10);
        SellCommand.itemsToSell.put(Material.DRAGON_HEAD, 1000);
        SellCommand.itemsToSell.put(Material.DRAGON_EGG, 1000000);
        SellCommand.itemsToSell.put(Material.ELYTRA, 10000);
        SellCommand.itemsToSell.put(Material.DRAGON_BREATH, 1000);
        SellCommand.itemsToSell.put(Material.ENCHANTED_GOLDEN_APPLE, 10000);
        SellCommand.itemsToSell.put(Material.GOLDEN_APPLE, 100);
        SellCommand.itemsToSell.put(Material.GOLDEN_CARROT, 100);

    }

    @Override
    public void onDisable() {
        ActionbarManager.stopActionbar();
        // Plugin shutdown logic
    }
    public static void setPermission(Player player, String permission, Boolean arg) {
        PermissionAttachment attachment = player.addAttachment(BunnyNationsCore.getInstance());
        attachment.setPermission(permission, arg);

        player.recalculatePermissions();
    }
}

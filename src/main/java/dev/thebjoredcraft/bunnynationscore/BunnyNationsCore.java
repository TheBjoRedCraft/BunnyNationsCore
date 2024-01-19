package dev.thebjoredcraft.bunnynationscore;

import dev.thebjoredcraft.bunnynationscore.command.broadcast.BroadcastAsCommand;
import dev.thebjoredcraft.bunnynationscore.command.broadcast.BroadcastCommand;
import dev.thebjoredcraft.bunnynationscore.command.RuleCommand;
import dev.thebjoredcraft.bunnynationscore.command.money.MoneyCommand;
import dev.thebjoredcraft.bunnynationscore.command.money.PayCommand;
import dev.thebjoredcraft.bunnynationscore.manager.EventManager;
import org.bukkit.Bukkit;
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
        Bukkit.getPluginManager().registerEvents(new EventManager(), this);
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    public static void setPermission(Player player, String permission, Boolean arg) {
        PermissionAttachment attachment = player.addAttachment(BunnyNationsCore.getInstance());
        attachment.setPermission(permission, arg);

        player.recalculatePermissions();
    }
}

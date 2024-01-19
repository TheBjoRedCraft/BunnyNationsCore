package dev.thebjoredcraft.bunnynationscore.command.broadcast;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class BroadcastCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        String msg = "";

        for( int i = 0; i < args.length; i++) {
            msg = msg + args[i]+" ";
        }

        Bukkit.broadcast(MiniMessage.miniMessage().deserialize(msg));
        return false;
    }
}

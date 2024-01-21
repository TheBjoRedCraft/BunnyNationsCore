package dev.thebjoredcraft.bunnynationscore.command;

import dev.thebjoredcraft.bunnynationscore.manager.ActionbarManager;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.sound.Sound;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ActionbarCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        String msg = "";

        for( int i = 0; i < args.length; i++) {
            msg = msg + args[i]+" ";
        }
        ActionbarManager.messages.put(2, msg);
        for(Player player : Bukkit.getOnlinePlayers()){
            Sound sound = Sound.sound(Key.key("block.note_block.bit"), Sound.Source.MASTER, 1f, 0f);

            player.playSound(sound);
        }

        return false;
    }
}

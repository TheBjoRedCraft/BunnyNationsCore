package dev.thebjoredcraft.bunnynationscore.command;

import dev.thebjoredcraft.bunnynationscore.manager.PlayerDataManager;
import dev.thebjoredcraft.bunnynationscore.manager.RuleManager;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RuleCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player player){
            if(args.length == 1) {
                if (args[0].equalsIgnoreCase("accept")) {
                    PlayerDataManager.setAcceptedRules(player, true);
                    player.sendMessage(MiniMessage.miniMessage().deserialize("<#3b92d1>Viel Spass auf dem Server!"));
                } else if (args[0].equalsIgnoreCase("reject")) {
                    PlayerDataManager.setAcceptedRules(player, false);
                    player.kick(MiniMessage.miniMessage().deserialize("<red>Du musst die Regeln akzeptieren um auf dem Server zu spielen!"));
                }
            }else{
                RuleManager.sendRules(player);
            }
        }
        return false;
    }
    private final String[] subcommands = new String[]{"accept", "reject"};
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        List<String> completions = new ArrayList<>();
        if(args.length <= 1) {
            StringUtil.copyPartialMatches(args[0], Arrays.asList(subcommands), completions);
        }
        Collections.sort(completions);
        return completions;
    }
}
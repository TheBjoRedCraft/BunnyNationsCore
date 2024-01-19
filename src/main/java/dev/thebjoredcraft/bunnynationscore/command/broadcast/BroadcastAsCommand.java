package dev.thebjoredcraft.bunnynationscore.command.broadcast;

import dev.thebjoredcraft.bunnynationscore.util.Person;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class BroadcastAsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(args.length == 0){
            sender.sendMessage(MiniMessage.miniMessage().deserialize(Person.CONSOLE.get() + "<gray>, " + Person.ALERT.get() + "<gray>, " + Person.SERVER.get() + "<gray>, " + Person.PROFESSOR.get() + "<gray>, " + Person.PROXY.get()));
        }else {
            String msg = "";
            String personPrefix = "";
            Person person = Person.valueOf(args[0]);
            personPrefix = person.get();

            for (int i = 1; i < args.length; i++) {
                msg = msg + args[i] + " ";
            }

            Bukkit.broadcast(MiniMessage.miniMessage().deserialize(personPrefix + msg));
        }
        return false;
    }
}

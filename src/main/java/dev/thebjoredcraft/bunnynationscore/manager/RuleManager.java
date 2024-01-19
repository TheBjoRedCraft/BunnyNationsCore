package dev.thebjoredcraft.bunnynationscore.manager;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class RuleManager {
    public static File getFile(){
        File rulesFile = new File("plugins/BunnyNationsCore/rules.txt");
       return rulesFile;
    }

    public static void sendRules(Player player){
        File rulesFile = new File("plugins/BunnyNationsCore/rules.txt");

        if (!rulesFile.exists()) {
            Bukkit.getConsoleSender().sendMessage("Die Regeln-Datei wurde nicht gefunden.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(rulesFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                player.sendMessage(MiniMessage.miniMessage().deserialize(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
            Bukkit.getConsoleSender().sendMessage("Fehler beim Lesen der Regeln-Datei.");
        }
    }
}
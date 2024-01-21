package dev.thebjoredcraft.bunnynationscore.manager;

import dev.thebjoredcraft.bunnynationscore.BunnyNationsCore;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;

public class ActionbarManager {
    public static HashMap<Integer, String> messages = new HashMap<>();//2 = custom, 1 = default

    public static BukkitRunnable runnable;
    public static Boolean custom;

    public static void sendActionbar(){
        for(Player player : Bukkit.getOnlinePlayers()){
            if(custom){
                player.sendActionBar(MiniMessage.miniMessage().deserialize(messages.get(2).replace("%playername%", player.getName())));
            }else{
                player.sendActionBar(MiniMessage.miniMessage().deserialize(messages.get(1).replace("%money%", String.valueOf(PlayerDataManager.getMoney(player)))));
            }
        }
    }
    public static void startActionbar(){
        messages.put(1, "<color:#3b92d1>Du hast aktuell <bold>%money% <reset><color:#3b92d1>Taler!");
        messages.put(2, "<color:#3b92d1>hosted by DeSynch and Hexle");
        custom = true;
        runnable = new BukkitRunnable() {
            @Override
            public void run() {
                custom = !custom;
                sendActionbar();

            }
        };
        BukkitTask bukkitTask = runnable.runTaskTimer(BunnyNationsCore.getInstance(), 0, 50);
    }
    public static void stopActionbar(){
        try {
            if(!runnable.isCancelled()) {
                runnable.cancel();
            }
        } catch(Exception exception) {
            Bukkit.getConsoleSender().sendMessage("ERROR in stopActionbar");
        }
    }
}

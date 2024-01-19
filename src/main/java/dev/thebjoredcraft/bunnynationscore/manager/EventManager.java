package dev.thebjoredcraft.bunnynationscore.manager;

import dev.thebjoredcraft.bunnynationscore.BunnyNationsCore;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;

public class EventManager implements Listener {
    @EventHandler
    public void onCmd(PlayerCommandPreprocessEvent event){
        String command = event.getMessage();
        Player player = event.getPlayer();
        if(!player.hasPermission("bunnynationscore.cmd.use.disabled")) {
            if (command.startsWith("/pl") || command.startsWith("/plugins")) {
                event.setCancelled(true);
                Bukkit.getConsoleSender().sendMessage(MiniMessage.miniMessage().deserialize("<yellow>[BunnyNationsCore] <bold>The player " + player.getName() + "tried to use " + command));
                Bukkit.getConsoleSender().sendMessage("The Server´s IP is: " + Bukkit.getServer().getIp());
            } else if (command.startsWith("/ver") || command.startsWith("/version")) {
                event.setCancelled(true);
                Bukkit.getConsoleSender().sendMessage(MiniMessage.miniMessage().deserialize("<yellow>[BunnyNationsCore] <bold>The player " + player.getName() + "tried to use " + command));
            }
        }
    }
    @EventHandler
    public void onMove(PlayerMoveEvent event){
        Player player = event.getPlayer();
        if(event.getFrom().getBlockX() != event.getTo().getBlockX() || event.getFrom().getBlockZ() != event.getTo().getBlockZ()){
            if(PlayerDataManager.getAcceptedRules(player) == null){
                PlayerDataManager.setAcceptedRules(player, false);
            }else {
                if (!PlayerDataManager.getAcceptedRules(player)) {
                    event.setCancelled(true);
                    player.sendMessage(MiniMessage.miniMessage().deserialize("<red>Du musst die Regeln akzeptieren! -> /rules accept | Regeln: /rules"));
                }
            }
        }
    }
    @EventHandler
    public void onPortal(PlayerPortalEvent event){
        Player player = event.getPlayer();
        if(event.getCause() == PlayerTeleportEvent.TeleportCause.END_PORTAL && !player.hasPermission("bunnynationscore.portal.end.use")){
            event.setCancelled(true);
            if(!player.hasPermission("bunnynationscore.portal.end.cooldown")){
                player.sendMessage(MiniMessage.miniMessage().deserialize("<#3b92d1><bold>[Professor Dr. Anonymus] <reset><#3b92d1>Hey! Das End ist noch nicht repariert. Bitte komm spaeter wieder."));
                BunnyNationsCore.setPermission(player, "bunnynationscore.portal.end.cooldown", true);
                BunnyNationsCore.getInstance().getServer().getScheduler().runTaskLater(BunnyNationsCore.getInstance(), () -> {
                    BunnyNationsCore.setPermission(player, "bunnynationscore.portal.end.cooldown", false);
                }, 20);
            }
        }
    }
    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        if(event.getPlayer().hasPermission("bunnynationscore.portal.end.cooldown")){
            BunnyNationsCore.setPermission(event.getPlayer(), "bunnynationscore.portal.end.cooldown", false);
        }
    }
}

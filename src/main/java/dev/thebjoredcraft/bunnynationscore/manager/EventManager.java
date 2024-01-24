package dev.thebjoredcraft.bunnynationscore.manager;

import dev.thebjoredcraft.bunnynationscore.BunnyNationsCore;
import dev.thebjoredcraft.bunnynationscore.command.economy.SellCommand;
import dev.thebjoredcraft.bunnynationscore.gui.BuyGraphicalUserInterfaceOne;
import dev.thebjoredcraft.bunnynationscore.gui.BuyGraphicalUserInterfaceTwo;
import dev.thebjoredcraft.bunnynationscore.util.ShopItem;
import dev.thebjoredcraft.bunnynationscore.util.ShopItems;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.sound.Sound;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class EventManager implements Listener {
    @EventHandler
    public void onCmd(PlayerCommandPreprocessEvent event) {
        String command = event.getMessage();
        Player player = event.getPlayer();
        if (!player.hasPermission("bunnynationscore.cmd.use.disabled")) {
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
    public void onMove(PlayerMoveEvent event) {
        try {
            Player player = event.getPlayer();
            if (event.getFrom().getBlockX() != event.getTo().getBlockX() || event.getFrom().getBlockZ() != event.getTo().getBlockZ()) {
                if (PlayerDataManager.getAcceptedRules(player) == null) {
                    PlayerDataManager.setAcceptedRules(player, false);
                } else {
                    if (!PlayerDataManager.getAcceptedRules(player)) {
                        event.setCancelled(true);
                        player.sendMessage(MiniMessage.miniMessage().deserialize("<red>Du musst die Regeln akzeptieren! -> /rules accept | Regeln: /rules"));
                    }
                }
            }
            if (player.getInventory().getItemInOffHand().getItemMeta() != null) {
                if (player.getInventory().getItemInOffHand().getItemMeta().displayName().equals(ShopManager.manaName)) {
                    player.setWalkSpeed(0.6F);
                } else {
                    player.setWalkSpeed(0.2F);
                }
            } else {
                player.setWalkSpeed(0.2F);
            }
        }catch (NullPointerException ignored){
            //
        }
    }

    @EventHandler
    public void onPortal(PlayerPortalEvent event) {
        Player player = event.getPlayer();
        if (event.getCause() == PlayerTeleportEvent.TeleportCause.END_PORTAL && !player.hasPermission("bunnynationscore.portal.end.use")) {
            event.setCancelled(true);
            if (!player.hasPermission("bunnynationscore.portal.end.cooldown")) {
                player.sendMessage(MiniMessage.miniMessage().deserialize("<#3b92d1><bold>[Professor Dr. Anonymus] <reset><#3b92d1>Hey! Das End ist noch nicht repariert. Bitte komm spaeter wieder."));
                BunnyNationsCore.setPermission(player, "bunnynationscore.portal.end.cooldown", true);
                BunnyNationsCore.getInstance().getServer().getScheduler().runTaskLater(BunnyNationsCore.getInstance(), () -> {
                    BunnyNationsCore.setPermission(player, "bunnynationscore.portal.end.cooldown", false);
                }, 20);
            }
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        if (event.getPlayer().hasPermission("bunnynationscore.portal.end.cooldown")) {
            BunnyNationsCore.setPermission(event.getPlayer(), "bunnynationscore.portal.end.cooldown", false);
        }
        try {
            PlayerDataManager.getMoney(event.getPlayer());
        }catch (NullPointerException e){
            PlayerDataManager.setMoney(event.getPlayer(), 0);
        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        try {
            BuyGraphicalUserInterfaceOne.handle(event);
            BuyGraphicalUserInterfaceTwo.handle(event);

            if (event.getInventory() == ShopManager.sellShop) {
                event.setCancelled(true);
                if (event.getCurrentItem() != null && event.getCurrentItem().getType() != Material.AIR) {
                    Material clickedMaterial = event.getCurrentItem().getType();
                    Player player = (Player) event.getWhoClicked();

                    if (player.getInventory().contains(clickedMaterial)) {
                        for (ItemStack s : player.getInventory().getContents()) {
                            if (s != null) {
                                if (s.getType() == clickedMaterial) {
                                    Sound sound = Sound.sound(Key.key("block.note_block.bit"), Sound.Source.MASTER, 1f, 0f);

                                    PlayerDataManager.addMoney(player, SellCommand.itemsToSell.get(clickedMaterial));
                                    player.playSound(sound);
                                    player.sendActionBar(MiniMessage.miniMessage().deserialize("<color:#3b92d1>+" + SellCommand.itemsToSell.get(clickedMaterial)));
                                    s.setAmount(s.getAmount() - 1);
                                    return;
                                }
                            }
                        }

                    } else {
                        player.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>Du hast dises Item nicht!"));
                    }
                }
            }
            //        if (event.getInventory().getType().equals(InventoryType.CRAFTING) && event.getSlot() == 40) {
            //            ItemStack clickedItem = event.getCurrentItem();
            //            if (clickedItem != null) {
            //                if (clickedItem.getItemMeta().displayName().equals(ShopManager.manaName)) {
            //                    event.setCancelled(true);
            //                }
            //            }
            //        }
        }catch (NullPointerException ignored){
            //
        }
    }
    //    @EventHandler
    //    public void onSwap(PlayerSwapHandItemsEvent event) {
    //        Player player = event.getPlayer();
    //        if (event.getOffHandItem() != null) {
    //            if (event.getOffHandItem().hasItemMeta()) {
    //                if (event.getOffHandItem().getItemMeta().displayName().equals(ShopManager.manaName)) {
    //                    player.setWalkSpeed(0.5F);
    //                } else {
    //                    player.setWalkSpeed(0.2F);
    //                }
    //            } else {
    //                player.setWalkSpeed(0.2F);
    //            }
    //        } else {
    //            player.setWalkSpeed(0.2F);
    //        }
    //    }
    @EventHandler
    public void onInteract(PlayerInteractEntityEvent event){
        if(event.getRightClicked().getScoreboardTags().contains(ShopManager.traderTag)){
            BuyGraphicalUserInterfaceOne.open(event.getPlayer());
        }else if(event.getRightClicked().getScoreboardTags().contains(ShopManager.traderSellTag)){
            ShopManager.openSellGUI(event.getPlayer());
        }
    }
    @EventHandler
    public void onEat(PlayerItemConsumeEvent event){
        if(event.getItem().getItemMeta() != null) {
            if(event.getItem().getItemMeta().displayName() != null) {
                if (event.getItem().getItemMeta().displayName().equals(ShopManager.ultra_gap)) {
                    event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 3600, 3));
                    event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 3600, 250));
                    event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 3600, 5));
                    event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 3600, 3));
                }
            }
        }
    }
    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        if (event.getPlayer().getItemInHand().hasItemMeta()) {
            if(event.getPlayer().getItemInHand().getItemMeta().displayName() != null) {
                if (event.getPlayer().getItemInHand().getItemMeta().displayName().equals(ShopManager.gluecky_name) && !event.getPlayer().getItemInHand().getItemMeta().hasEnchants()) {

                    event.getPlayer().getItemInHand().addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 4);
                    event.getPlayer().getItemInHand().addUnsafeEnchantment(Enchantment.DIG_SPEED, 7);
                    event.getPlayer().getItemInHand().addUnsafeEnchantment(Enchantment.DURABILITY, 5);
                    event.getPlayer().getItemInHand().addUnsafeEnchantment(Enchantment.MENDING, 1);
                } else if (event.getPlayer().getItemInHand().getItemMeta().displayName().equals(ShopManager.diapicke_name) && !event.getPlayer().getItemInHand().getItemMeta().hasEnchants()) {

                    event.getPlayer().getItemInHand().addUnsafeEnchantment(Enchantment.SILK_TOUCH, 1);
                    event.getPlayer().getItemInHand().addUnsafeEnchantment(Enchantment.DIG_SPEED, 7);
                    event.getPlayer().getItemInHand().addUnsafeEnchantment(Enchantment.DURABILITY, 5);
                    event.getPlayer().getItemInHand().addUnsafeEnchantment(Enchantment.MENDING, 1);
                } else if (event.getPlayer().getItemInHand().getItemMeta().displayName().equals(ShopManager.shovel) && !event.getPlayer().getItemInHand().getItemMeta().hasEnchants()) {

                    event.getPlayer().getItemInHand().addUnsafeEnchantment(Enchantment.DIG_SPEED, 7);
                    event.getPlayer().getItemInHand().addUnsafeEnchantment(Enchantment.DURABILITY, 5);
                    event.getPlayer().getItemInHand().addUnsafeEnchantment(Enchantment.MENDING, 1);
                } else if (event.getPlayer().getItemInHand().getItemMeta().displayName().equals(ShopManager.axe) && !event.getPlayer().getItemInHand().getItemMeta().hasEnchants()) {

                    event.getPlayer().getItemInHand().addUnsafeEnchantment(Enchantment.DIG_SPEED, 7);
                    event.getPlayer().getItemInHand().addUnsafeEnchantment(Enchantment.DURABILITY, 5);
                    event.getPlayer().getItemInHand().addUnsafeEnchantment(Enchantment.MENDING, 1);
                }
            }
        }
    }
    @EventHandler
    public void onAttack(EntityDamageByEntityEvent event){
        if(event.getDamager() instanceof Player player){
            if (player.getItemInHand() != null) {
                if (player.getItemInHand().getItemMeta() != null) {
                    if (player.getItemInHand().getItemMeta().displayName() != null) {
                        if (player.getItemInHand().getItemMeta().displayName().equals(ShopManager.diamond_sword_name) && !player.getItemInHand().getItemMeta().hasEnchants()) {
                            player.getItemInHand().addUnsafeEnchantment(Enchantment.DURABILITY, 5);
                            player.getItemInHand().addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 10);
                            player.getItemInHand().addUnsafeEnchantment(Enchantment.MENDING, 1);
                            player.getItemInHand().addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 3);
                            player.getItemInHand().addUnsafeEnchantment(Enchantment.LOOT_BONUS_MOBS, 4);
                        } else if (player.getItemInHand().getItemMeta().displayName().equals(ShopManager.monster_hunter) && !player.getItemInHand().getItemMeta().hasEnchants()) {
                            player.getItemInHand().addUnsafeEnchantment(Enchantment.DURABILITY, 5);
                            player.getItemInHand().addUnsafeEnchantment(Enchantment.DAMAGE_UNDEAD, 7);
                            player.getItemInHand().addUnsafeEnchantment(Enchantment.DAMAGE_ARTHROPODS, 7);
                            player.getItemInHand().addUnsafeEnchantment(Enchantment.MENDING, 1);
                            player.getItemInHand().addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 3);
                            player.getItemInHand().addUnsafeEnchantment(Enchantment.LOOT_BONUS_MOBS, 4);
                        }
                    }
                }
            }
        }
    }
    @EventHandler
    public void onDamage(EntityDamageEvent event){
        if(event.getEntity() instanceof Player player) {
            if (player.getInventory().getHelmet() != null) {
                if(player.getInventory().getHelmet().hasItemMeta()){
                    if (player.getInventory().getHelmet().getItemMeta().displayName() != null) {
                        if (player.getInventory().getHelmet().getItemMeta().displayName().equals(ShopManager.helm)) {
                            player.getInventory().getHelmet().addUnsafeEnchantment(Enchantment.MENDING, 1);
                            player.getInventory().getHelmet().addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
                            player.getInventory().getHelmet().addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 5);
                            player.getInventory().getHelmet().addUnsafeEnchantment(Enchantment.MENDING, 1);
                        }
                    }
                }
            }
            if (player.getInventory().getChestplate() != null) {
                if(player.getInventory().getChestplate().hasItemMeta()) {
                    if (player.getInventory().getChestplate().getItemMeta().displayName() != null) {
                        if (player.getInventory().getChestplate().getItemMeta().displayName().equals(ShopManager.chestplate)) {
                            player.getInventory().getChestplate().addUnsafeEnchantment(Enchantment.MENDING, 1);
                            player.getInventory().getChestplate().addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
                            player.getInventory().getChestplate().addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 5);
                            player.getInventory().getChestplate().addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 5);
                            player.getInventory().getChestplate().addUnsafeEnchantment(Enchantment.MENDING, 1);
                        }
                    }
                }
            }
            if (player.getInventory().getLeggings() != null) {
                if(player.getInventory().getLeggings().hasItemMeta()) {
                    if (player.getInventory().getLeggings().getItemMeta().displayName() != null) {
                        if (player.getInventory().getLeggings().getItemMeta().displayName().equals(ShopManager.leggings)) {
                            player.getInventory().getLeggings().addUnsafeEnchantment(Enchantment.MENDING, 1);
                            player.getInventory().getLeggings().addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
                            player.getInventory().getLeggings().addUnsafeEnchantment(Enchantment.SWIFT_SNEAK, 5);
                            player.getInventory().getLeggings().addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 5);
                            player.getInventory().getLeggings().addUnsafeEnchantment(Enchantment.MENDING, 1);
                        }
                    }
                }
            }
            if (player.getInventory().getBoots() != null) {
                if(player.getInventory().getBoots().hasItemMeta()) {
                    if (player.getInventory().getBoots().getItemMeta().displayName() != null) {
                        if (player.getInventory().getBoots().getItemMeta().displayName().equals(ShopManager.boots)) {
                            player.getInventory().getBoots().addUnsafeEnchantment(Enchantment.MENDING, 1);
                            player.getInventory().getBoots().addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
                            player.getInventory().getBoots().addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 5);
                            player.getInventory().getBoots().addUnsafeEnchantment(Enchantment.DEPTH_STRIDER, 5);
                            player.getInventory().getBoots().addUnsafeEnchantment(Enchantment.SOUL_SPEED, 5);
                            player.getInventory().getBoots().addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 5);
                            player.getInventory().getBoots().addUnsafeEnchantment(Enchantment.MENDING, 1);
                        }
                    }
                }
            }
        }
    }
    @EventHandler
    public void onPlace(BlockPlaceEvent event){
        if(event.getPlayer().getItemInHand().getItemMeta() != null) {
            if (event.getPlayer().getItemInHand().getItemMeta().displayName() != null) {
                if (event.getPlayer().getItemInHand().getItemMeta().displayName().equals(ShopManager.manaName)) {
                    event.setCancelled(true);
                }
            }
        }
    }
    @EventHandler
    public void onInteract(PlayerInteractEvent event){
        Player player = event.getPlayer();

        if(player.getInventory().getItemInOffHand().getItemMeta() != null){
            if(player.getInventory().getItemInOffHand().getItemMeta().displayName() != null) {
                if (player.getInventory().getItemInOffHand().getItemMeta().displayName().equals(ShopManager.manaBoostName)) {
                    if (!event.getPlayer().hasPermission("bunnynationscore.boost.cooldown")) {
                        Vector boostDirection = event.getPlayer().getLocation().getDirection().normalize().multiply(2);
                        event.getPlayer().setVelocity(boostDirection);

                        BunnyNationsCore.setPermission(event.getPlayer(), "bunnynationscore.boost.cooldown", true);
                        BunnyNationsCore.getInstance().getServer().getScheduler().runTaskLater(BunnyNationsCore.getInstance(), () -> {
                            BunnyNationsCore.setPermission(event.getPlayer(), "bunnynationscore.boost.cooldown", false);
                        }, 120);
                    } else {
                        event.getPlayer().sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>Bitte warte einen Moment!"));
                    }
                }
            }
        }
    }
}

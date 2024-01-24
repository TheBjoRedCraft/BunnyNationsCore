package dev.thebjoredcraft.bunnynationscore.gui;

import dev.thebjoredcraft.bunnynationscore.manager.PlayerDataManager;
import dev.thebjoredcraft.bunnynationscore.manager.ShopManager;
import dev.thebjoredcraft.bunnynationscore.util.ShopItem;
import dev.thebjoredcraft.bunnynationscore.util.ShopItems;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class BuyGraphicalUserInterfaceOne {
    public static Inventory gui = Bukkit.createInventory(null, 54, MiniMessage.miniMessage().deserialize("<bold>Verkauf"));
    public static void open(Player player){
        for (int i = 0; i < 54; i++) {
            gui.setItem(i, ShopItem.convertToItemStack(ShopItems.NOT_AVAILABLE));
        }
        gui.setItem(10, ShopItem.convertToItemStack(ShopItems.HELM));
        gui.setItem(12, ShopItem.convertToItemStack(ShopItems.DIAMOND_SWORD));
        gui.setItem(14, ShopItem.convertToItemStack(ShopItems.DIAMOND_PICKAXE));
        gui.setItem(16, ShopItem.convertToItemStack(ShopItems.TOTEM));
        gui.setItem(19, ShopItem.convertToItemStack(ShopItems.CHESTPLATE));
        gui.setItem(21, ShopItem.convertToItemStack(ShopItems.MONSTER_HUNTER));
        gui.setItem(23, ShopItem.convertToItemStack(ShopItems.DIAMOND_PICKAXE_GLUECKY));
        gui.setItem(25, ShopItem.convertToItemStack(ShopItems.ROCKET));
        gui.setItem(28, ShopItem.convertToItemStack(ShopItems.LIGGINGS));
        gui.setItem(30, ShopItem.convertToItemStack(ShopItems.MANA_SPEED));
        gui.setItem(32, ShopItem.convertToItemStack(ShopItems.DIAMOND_AXE));
        gui.setItem(34, ShopItem.convertToItemStack(ShopItems.GUNPOWDER));
        gui.setItem(37, ShopItem.convertToItemStack(ShopItems.BOOTS));
        gui.setItem(39, ShopItem.convertToItemStack(ShopItems.MANA_BOOST));
        gui.setItem(41, ShopItem.convertToItemStack(ShopItems.DIAMOND_SHOVEL));
        gui.setItem(43, ShopItem.convertToItemStack(ShopItems.PAPER));
        gui.setItem(53, ShopItem.convertToItemStack(ShopItems.NEXTBuy));

        player.openInventory(gui);

    }
    public static void handle(InventoryClickEvent event) {
        if (event.getView().getTopInventory() == gui) {
            event.setCancelled(true);
            if (event.getCurrentItem() != null) {
                if (event.getCurrentItem().getItemMeta().hasLocalizedName()) {
                    Component component = event.getCurrentItem().getItemMeta().displayName();
                    Player player = (Player) event.getWhoClicked();
                    if (component.equals(ShopManager.manaName)) {
                        ShopItems item = ShopItems.MANA_SPEED;

                        if (PlayerDataManager.getMoney(player) >= item.getPrize()) {
                            event.getWhoClicked().getLocation().getWorld().dropItem(event.getWhoClicked().getLocation(), ShopItem.convertToItemStack(item));
                            PlayerDataManager.removeMoney(player, item.getPrize());
                        } else {
                            player.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>Du hast nicht genuegend Taler!"));
                        }
                    } else if (component.equals(ShopManager.ultra_gap)) {
                        ShopItems item3 = ShopItems.ULTRA_GAP;

                        if (PlayerDataManager.getMoney(player) >= item3.getPrize()) {
                            event.getWhoClicked().getLocation().getWorld().dropItem(event.getWhoClicked().getLocation(), ShopItem.convertToItemStack(item3));
                            PlayerDataManager.removeMoney(player, item3.getPrize());
                        } else {
                            player.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>Du hast nicht genuegend Taler!"));
                        }
                    } else if (component.equals(ShopManager.diapicke_name)) {
                        ShopItems item3 = ShopItems.DIAMOND_PICKAXE;

                        if (PlayerDataManager.getMoney(player) >= item3.getPrize()) {
                            event.getWhoClicked().getLocation().getWorld().dropItem(event.getWhoClicked().getLocation(), ShopItem.convertToItemStack(item3));
                            PlayerDataManager.removeMoney(player, item3.getPrize());
                        } else {
                            player.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>Du hast nicht genuegend Taler!"));
                        }
                    } else if (component.equals(ShopManager.gluecky_name)) {
                        ShopItems item3 = ShopItems.DIAMOND_PICKAXE_GLUECKY;

                        if (PlayerDataManager.getMoney(player) >= item3.getPrize()) {
                            event.getWhoClicked().getLocation().getWorld().dropItem(event.getWhoClicked().getLocation(), ShopItem.convertToItemStack(item3));
                            PlayerDataManager.removeMoney(player, item3.getPrize());
                        } else {
                            player.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>Du hast nicht genuegend Taler!"));
                        }
                    } else if (component.equals(ShopManager.diamond_sword_name)) {
                        ShopItems item3 = ShopItems.DIAMOND_SWORD;

                        if (PlayerDataManager.getMoney(player) >= item3.getPrize()) {
                            event.getWhoClicked().getLocation().getWorld().dropItem(event.getWhoClicked().getLocation(), ShopItem.convertToItemStack(item3));
                            PlayerDataManager.removeMoney(player, item3.getPrize());
                        } else {
                            player.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>Du hast nicht genuegend Taler!"));
                        }
                    } else if (component.equals(ShopManager.monster_hunter)) {
                        ShopItems item3 = ShopItems.MONSTER_HUNTER;

                        if (PlayerDataManager.getMoney(player) >= item3.getPrize()) {
                            event.getWhoClicked().getLocation().getWorld().dropItem(event.getWhoClicked().getLocation(), ShopItem.convertToItemStack(item3));
                            PlayerDataManager.removeMoney(player, item3.getPrize());
                        } else {
                            player.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>Du hast nicht genuegend Taler!"));
                        }
                    } else if (component.equals(ShopManager.helm)) {
                        ShopItems item3 = ShopItems.HELM;

                        if (PlayerDataManager.getMoney(player) >= item3.getPrize()) {
                            event.getWhoClicked().getLocation().getWorld().dropItem(event.getWhoClicked().getLocation(), ShopItem.convertToItemStack(item3));
                            PlayerDataManager.removeMoney(player, item3.getPrize());
                        } else {
                            player.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>Du hast nicht genuegend Taler!"));
                        }
                    } else if (component.equals(ShopManager.chestplate)) {
                        ShopItems item3 = ShopItems.CHESTPLATE;

                        if (PlayerDataManager.getMoney(player) >= item3.getPrize()) {
                            event.getWhoClicked().getLocation().getWorld().dropItem(event.getWhoClicked().getLocation(), ShopItem.convertToItemStack(item3));
                            PlayerDataManager.removeMoney(player, item3.getPrize());
                        } else {
                            player.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>Du hast nicht genuegend Taler!"));
                        }
                    } else if (component.equals(ShopManager.leggings)) {
                        ShopItems item3 = ShopItems.LIGGINGS;

                        if (PlayerDataManager.getMoney(player) >= item3.getPrize()) {
                            event.getWhoClicked().getLocation().getWorld().dropItem(event.getWhoClicked().getLocation(), ShopItem.convertToItemStack(item3));
                            PlayerDataManager.removeMoney(player, item3.getPrize());
                        } else {
                            player.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>Du hast nicht genuegend Taler!"));
                        }
                    } else if (component.equals(ShopManager.boots)) {
                        ShopItems item3 = ShopItems.BOOTS;

                        if (PlayerDataManager.getMoney(player) >= item3.getPrize()) {
                            event.getWhoClicked().getLocation().getWorld().dropItem(event.getWhoClicked().getLocation(), ShopItem.convertToItemStack(item3));
                            PlayerDataManager.removeMoney(player, item3.getPrize());
                        } else {
                            player.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>Du hast nicht genuegend Taler!"));
                        }
                    } else if (component.equals(ShopManager.manaBoostName)) {
                        ShopItems item3 = ShopItems.MANA_BOOST;

                        if (PlayerDataManager.getMoney(player) >= item3.getPrize()) {
                            event.getWhoClicked().getLocation().getWorld().dropItem(event.getWhoClicked().getLocation(), ShopItem.convertToItemStack(item3));
                            PlayerDataManager.removeMoney(player, item3.getPrize());
                        } else {
                            player.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>Du hast nicht genuegend Taler!"));
                        }
                    } else if (component.equals(ShopManager.rocket1)) {
                        ShopItems item3 = ShopItems.ROCKET;

                        if (PlayerDataManager.getMoney(player) >= item3.getPrize()) {
                            event.getWhoClicked().getLocation().getWorld().dropItem(event.getWhoClicked().getLocation(), ShopItem.convertToItemStack(item3));
                            PlayerDataManager.removeMoney(player, item3.getPrize());
                        } else {
                            player.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>Du hast nicht genuegend Taler!"));
                        }
                    } else if (component.equals(ShopManager.totem)) {
                        ShopItems item3 = ShopItems.TOTEM;

                        if (PlayerDataManager.getMoney(player) >= item3.getPrize()) {
                            event.getWhoClicked().getLocation().getWorld().dropItem(event.getWhoClicked().getLocation(), ShopItem.convertToItemStack(item3));
                            PlayerDataManager.removeMoney(player, item3.getPrize());
                        } else {
                            player.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>Du hast nicht genuegend Taler!"));
                        }
                    } else if (component.equals(ShopManager.paper)) {
                        ShopItems item3 = ShopItems.PAPER;

                        if (PlayerDataManager.getMoney(player) >= item3.getPrize()) {
                            event.getWhoClicked().getLocation().getWorld().dropItem(event.getWhoClicked().getLocation(), ShopItem.convertToItemStack(item3));
                            PlayerDataManager.removeMoney(player, item3.getPrize());
                        } else {
                            player.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>Du hast nicht genuegend Taler!"));
                        }
                    } else if (component.equals(ShopManager.gunpowder)) {
                        ShopItems item3 = ShopItems.GUNPOWDER;

                        if (PlayerDataManager.getMoney(player) >= item3.getPrize()) {
                            event.getWhoClicked().getLocation().getWorld().dropItem(event.getWhoClicked().getLocation(), ShopItem.convertToItemStack(item3));
                            PlayerDataManager.removeMoney(player, item3.getPrize());
                        } else {
                            player.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>Du hast nicht genuegend Taler!"));
                        }
                    } else if (component.equals(ShopManager.axe)) {
                        ShopItems item3 = ShopItems.DIAMOND_AXE;

                        if (PlayerDataManager.getMoney(player) >= item3.getPrize()) {
                            event.getWhoClicked().getLocation().getWorld().dropItem(event.getWhoClicked().getLocation(), ShopItem.convertToItemStack(item3));
                            PlayerDataManager.removeMoney(player, item3.getPrize());
                        } else {
                            player.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>Du hast nicht genuegend Taler!"));
                        }
                    } else if (component.equals(ShopManager.shovel)) {
                        ShopItems item3 = ShopItems.DIAMOND_SHOVEL;

                        if (PlayerDataManager.getMoney(player) >= item3.getPrize()) {
                            event.getWhoClicked().getLocation().getWorld().dropItem(event.getWhoClicked().getLocation(), ShopItem.convertToItemStack(item3));
                            PlayerDataManager.removeMoney(player, item3.getPrize());
                        } else {
                            player.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>Du hast nicht genuegend Taler!"));
                        }
                    } else if (component.equals(ShopManager.otherStuffBuy)) {
                        BuyGraphicalUserInterfaceTwo.open(player);
                    }
                }
            }
        }
    }
}

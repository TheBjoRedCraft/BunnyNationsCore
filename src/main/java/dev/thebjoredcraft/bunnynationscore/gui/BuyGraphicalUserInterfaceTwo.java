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

public class BuyGraphicalUserInterfaceTwo {
    public static Inventory gui = Bukkit.createInventory(null, 54, MiniMessage.miniMessage().deserialize("<bold>Verkauf"));
    public static void open(Player player){
        for (int i = 0; i < 54; i++) {
            gui.setItem(i, ShopItem.convertToItemStack(ShopItems.NOT_AVAILABLE));
        }
        gui.setItem(10, ShopItem.convertToItemStack(ShopItems.ULTRA_GAP));
        gui.setItem(12, ShopItem.convertToItemStack(ShopItems.UPGRADE));
        gui.setItem(14, ShopItem.convertToItemStack(ShopItems.DIAMOND));
        gui.setItem(16, ShopItem.convertToItemStack(ShopItems.SLIME));
        gui.setItem(19, ShopItem.convertToItemStack(ShopItems.CARROT));
        gui.setItem(21, ShopItem.convertToItemStack(ShopItems.SILENCE));
        gui.setItem(23, ShopItem.convertToItemStack(ShopItems.REDSTONE));
        gui.setItem(25, ShopItem.convertToItemStack(ShopItems.HONEY));
        gui.setItem(28, ShopItem.convertToItemStack(ShopItems.BREAD));
        gui.setItem(30, ShopItem.convertToItemStack(ShopItems.SPIRE));
        gui.setItem(32, ShopItem.convertToItemStack(ShopItems.IRON));
        gui.setItem(34, ShopItem.convertToItemStack(ShopItems.LAVA));
        gui.setItem(37, ShopItem.convertToItemStack(ShopItems.STEAK));
        gui.setItem(39, ShopItem.convertToItemStack(ShopItems.DUNE));
        gui.setItem(41, ShopItem.convertToItemStack(ShopItems.GOLD));
        gui.setItem(43, ShopItem.convertToItemStack(ShopItems.WATER));
        gui.setItem(53, ShopItem.convertToItemStack(ShopItems.BACKBuy));

        player.openInventory(gui);

    }
    public static void handle(InventoryClickEvent event){
        if (event.getView().getTopInventory() == gui) {
            event.setCancelled(true);
            if(event.getCurrentItem() != null){
                if (event.getCurrentItem().getItemMeta().hasLocalizedName()) {
                    Component component = event.getCurrentItem().getItemMeta().displayName();
                    Player player = (Player) event.getWhoClicked();
                    try {
                        if (component.equals(ShopManager.ultra_gap)) {
                            ShopItems item = ShopItems.ULTRA_GAP;

                            if (PlayerDataManager.getMoney(player) >= item.getPrize()) {
                                event.getWhoClicked().getLocation().getWorld().dropItem(event.getWhoClicked().getLocation(), ShopItem.convertToItemStack(item));
                                PlayerDataManager.removeMoney(player, item.getPrize());
                            } else {
                                player.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>Du hast nicht genuegend Taler!"));
                            }
                        } else if (component.equals(ShopManager.upgrade_template)) {
                            ShopItems item1 = ShopItems.UPGRADE;

                            if (PlayerDataManager.getMoney(player) >= item1.getPrize()) {
                                event.getWhoClicked().getLocation().getWorld().dropItem(event.getWhoClicked().getLocation(), ShopItem.convertToItemStack(item1));
                                PlayerDataManager.removeMoney(player, item1.getPrize());
                            } else {
                                player.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>Du hast nicht genuegend Taler!"));
                            }
                        } else if (component.equals(ShopManager.diamond_name)) {
                            ShopItems item1 = ShopItems.DIAMOND;

                            if (PlayerDataManager.getMoney(player) >= item1.getPrize()) {
                                event.getWhoClicked().getLocation().getWorld().dropItem(event.getWhoClicked().getLocation(), ShopItem.convertToItemStack(item1));
                                PlayerDataManager.removeMoney(player, item1.getPrize());
                            } else {
                                player.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>Du hast nicht genuegend Taler!"));
                            }
                        } else if (component.equals(ShopManager.slime)) {
                            ShopItems item1 = ShopItems.SLIME;

                            if (PlayerDataManager.getMoney(player) >= item1.getPrize()) {
                                event.getWhoClicked().getLocation().getWorld().dropItem(event.getWhoClicked().getLocation(), ShopItem.convertToItemStack(item1));
                                PlayerDataManager.removeMoney(player, item1.getPrize());
                            } else {
                                player.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>Du hast nicht genuegend Taler!"));
                            }
                        } else if (component.equals(ShopManager.carrot)) {
                            ShopItems item1 = ShopItems.CARROT;

                            if (PlayerDataManager.getMoney(player) >= item1.getPrize()) {
                                event.getWhoClicked().getLocation().getWorld().dropItem(event.getWhoClicked().getLocation(), ShopItem.convertToItemStack(item1));
                                PlayerDataManager.removeMoney(player, item1.getPrize());
                            } else {
                                player.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>Du hast nicht genuegend Taler!"));
                            }
                        } else if (component.equals(ShopManager.silence)) {
                            ShopItems item1 = ShopItems.SILENCE;

                            if (PlayerDataManager.getMoney(player) >= item1.getPrize()) {
                                event.getWhoClicked().getLocation().getWorld().dropItem(event.getWhoClicked().getLocation(), ShopItem.convertToItemStack(item1));
                                PlayerDataManager.removeMoney(player, item1.getPrize());
                            } else {
                                player.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>Du hast nicht genuegend Taler!"));
                            }
                        } else if (component.equals(ShopManager.redstone)) {
                            ShopItems item1 = ShopItems.REDSTONE;

                            if (PlayerDataManager.getMoney(player) >= item1.getPrize()) {
                                event.getWhoClicked().getLocation().getWorld().dropItem(event.getWhoClicked().getLocation(), ShopItem.convertToItemStack(item1));
                                PlayerDataManager.removeMoney(player, item1.getPrize());
                            } else {
                                player.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>Du hast nicht genuegend Taler!"));
                            }
                        } else if (component.equals(ShopManager.honey)) {
                            ShopItems item1 = ShopItems.HONEY;

                            if (PlayerDataManager.getMoney(player) >= item1.getPrize()) {
                                event.getWhoClicked().getLocation().getWorld().dropItem(event.getWhoClicked().getLocation(), ShopItem.convertToItemStack(item1));
                                PlayerDataManager.removeMoney(player, item1.getPrize());
                            } else {
                                player.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>Du hast nicht genuegend Taler!"));
                            }
                        } else if (component.equals(ShopManager.breadName)) {
                            ShopItems item1 = ShopItems.BREAD;

                            if (PlayerDataManager.getMoney(player) >= item1.getPrize()) {
                                event.getWhoClicked().getLocation().getWorld().dropItem(event.getWhoClicked().getLocation(), ShopItem.convertToItemStack(item1));
                                PlayerDataManager.removeMoney(player, item1.getPrize());
                            } else {
                                player.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>Du hast nicht genuegend Taler!"));
                            }
                        } else if (component.equals(ShopManager.spire)) {
                            ShopItems item1 = ShopItems.SPIRE;

                            if (PlayerDataManager.getMoney(player) >= item1.getPrize()) {
                                event.getWhoClicked().getLocation().getWorld().dropItem(event.getWhoClicked().getLocation(), ShopItem.convertToItemStack(item1));
                                PlayerDataManager.removeMoney(player, item1.getPrize());
                            } else {
                                player.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>Du hast nicht genuegend Taler!"));
                            }
                        } else if (component.equals(ShopManager.iron_name)) {
                            ShopItems item1 = ShopItems.IRON;

                            if (PlayerDataManager.getMoney(player) >= item1.getPrize()) {
                                event.getWhoClicked().getLocation().getWorld().dropItem(event.getWhoClicked().getLocation(), ShopItem.convertToItemStack(item1));
                                PlayerDataManager.removeMoney(player, item1.getPrize());
                            } else {
                                player.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>Du hast nicht genuegend Taler!"));
                            }
                        } else if (component.equals(ShopManager.lava)) {
                            ShopItems item1 = ShopItems.LAVA;

                            if (PlayerDataManager.getMoney(player) >= item1.getPrize()) {
                                event.getWhoClicked().getLocation().getWorld().dropItem(event.getWhoClicked().getLocation(), ShopItem.convertToItemStack(item1));
                                PlayerDataManager.removeMoney(player, item1.getPrize());
                            } else {
                                player.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>Du hast nicht genuegend Taler!"));
                            }
                        } else if (component.equals(ShopManager.steak)) {
                            ShopItems item1 = ShopItems.STEAK;

                            if (PlayerDataManager.getMoney(player) >= item1.getPrize()) {
                                event.getWhoClicked().getLocation().getWorld().dropItem(event.getWhoClicked().getLocation(), ShopItem.convertToItemStack(item1));
                                PlayerDataManager.removeMoney(player, item1.getPrize());
                            } else {
                                player.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>Du hast nicht genuegend Taler!"));
                            }
                        } else if (component.equals(ShopManager.dune)) {
                            ShopItems item1 = ShopItems.DUNE;

                            if (PlayerDataManager.getMoney(player) >= item1.getPrize()) {
                                event.getWhoClicked().getLocation().getWorld().dropItem(event.getWhoClicked().getLocation(), ShopItem.convertToItemStack(item1));
                                PlayerDataManager.removeMoney(player, item1.getPrize());
                            } else {
                                player.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>Du hast nicht genuegend Taler!"));
                            }
                        } else if (component.equals(ShopManager.gold)) {
                            ShopItems item1 = ShopItems.GOLD;

                            if (PlayerDataManager.getMoney(player) >= item1.getPrize()) {
                                event.getWhoClicked().getLocation().getWorld().dropItem(event.getWhoClicked().getLocation(), ShopItem.convertToItemStack(item1));
                                PlayerDataManager.removeMoney(player, item1.getPrize());
                            } else {
                                player.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>Du hast nicht genuegend Taler!"));
                            }
                        } else if (component.equals(ShopManager.water)) {
                            ShopItems item1 = ShopItems.WATER;

                            if (PlayerDataManager.getMoney(player) >= item1.getPrize()) {
                                event.getWhoClicked().getLocation().getWorld().dropItem(event.getWhoClicked().getLocation(), ShopItem.convertToItemStack(item1));
                                PlayerDataManager.removeMoney(player, item1.getPrize());
                            } else {
                                player.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>Du hast nicht genuegend Taler!"));
                            }
                        } else if (component.equals(ShopManager.invStuffBuy)) {
                            BuyGraphicalUserInterfaceOne.open(player);
                        }
                    }catch (NullPointerException e){
                        player.sendMessage(MiniMessage.miniMessage().deserialize("<color:#3b92d1>Du hast noch kein Geld!"));
                        PlayerDataManager.addMoney(player, 1);
                    }
                }
            }
        }
    }
}

package dev.thebjoredcraft.bunnynationscore.manager;

import dev.thebjoredcraft.bunnynationscore.util.ShopItem;
import dev.thebjoredcraft.bunnynationscore.util.ShopItems;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

public class ShopManager {
    public static Inventory shop;
    public static void openShopGUI(){
        shop = Bukkit.createInventory(null, 54, MiniMessage.miniMessage().deserialize("<bold>Shop"));

        ShopItems manaItem = ShopItems.MANA;
        ShopItems unavailableItem = ShopItems.NOT_AVAILABLE;

        for (int i = 0; i < 54; i++) {
            shop.setItem(i, ShopItem.convertToItemStack(unavailableItem));
        }
        shop.setItem(1, ShopItem.convertToItemStack(manaItem));

    }
}

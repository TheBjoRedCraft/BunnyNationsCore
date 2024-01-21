package dev.thebjoredcraft.bunnynationscore.manager;

import dev.thebjoredcraft.bunnynationscore.util.LootBoxItem;
import dev.thebjoredcraft.bunnynationscore.util.LootBoxItems;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LootBoxManager {

    public static List<ItemStack> lootBoxItems = new ArrayList<>();
    public static List<ItemStack> selectedItems = lootBoxItems.subList(0, 5);


    public static void giveLootItems(Player player){
        lootBoxItems.add(LootBoxItem.convertToItemStack(LootBoxItems.MANA));
        lootBoxItems.add(LootBoxItem.convertToItemStack(LootBoxItems.LOOT_BOX));
        lootBoxItems.add(LootBoxItem.convertToItemStack(LootBoxItems.DIAMOND));
        lootBoxItems.add(LootBoxItem.convertToItemStack(LootBoxItems.DIRT));
        lootBoxItems.add(LootBoxItem.convertToItemStack(LootBoxItems.DIAMOND_PICKAXE));
        lootBoxItems.add(LootBoxItem.convertToItemStack(LootBoxItems.DIAMOND_SWORD));
        lootBoxItems.add(LootBoxItem.convertToItemStack(LootBoxItems.OAK_PLANKS));
        lootBoxItems.add(LootBoxItem.convertToItemStack(LootBoxItems.IRON));
        lootBoxItems.add(LootBoxItem.convertToItemStack(LootBoxItems.DIAMOND_PICKAXE_GLUECKY));

        Collections.shuffle(lootBoxItems);

        for (ItemStack item : selectedItems) {
            player.getInventory().addItem(item);
        }

        for (ItemStack item : selectedItems) {
            player.sendMessage("- " + item.getType());
        }
    }
}

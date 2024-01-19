package dev.thebjoredcraft.bunnynationscore.manager;

import dev.thebjoredcraft.bunnynationscore.util.LootBoxItem;
import dev.thebjoredcraft.bunnynationscore.util.LootBoxItems;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class LootBoxManager {
    public static HashMap<Double, LootBoxItems> itemChances = new HashMap<>();

    public static LootBoxItem getRandomItem(){
        itemChances.put(0.1, LootBoxItems.MANA);
        itemChances.put(0.9, LootBoxItems.NOT_AVAILABLE);


        ItemStack randomStack = null;

        return null;
    }
}

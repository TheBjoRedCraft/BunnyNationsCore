package dev.thebjoredcraft.bunnynationscore.util;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class LootBoxItem extends ItemStack {
    private final Material material;
    private final Component lore;
    private final Component displayName;
    private final int prize;


    LootBoxItem(Material material, Component displayName, Component lore, int prize) {
        this.material = material;
        this.lore = lore;
        this.displayName = displayName;
        this.prize = prize;
    }


    public Material getMaterial() {
        return this.material;
    }
    public Component getLoree() {
        return this.lore;
    }
    public Component getDisplayName() {
        return this.displayName;
    }
    public int getPrize() {
        return this.prize;
    }
}

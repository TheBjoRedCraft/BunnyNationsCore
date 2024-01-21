package dev.thebjoredcraft.bunnynationscore.util;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class LootBoxItem extends ItemStack {
    private final Material material;
    private final Component lore;
    private final Component displayName;
    private int id;


    LootBoxItem(Material material, Component displayName, Component lore, int id) {
        this.material = material;
        this.lore = lore;
        this.displayName = displayName;
        this.id = id;
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

    public int getId() {
        return id;
    }

    public static ItemStack convertToItemStack(LootBoxItems data){
        ItemStack stack = new ItemStack(data.getMaterial());
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(data.getLore());
        meta.displayName(data.getDisplayName());
        meta.lore(lore);
        meta.setLocalizedName(String.valueOf(data.getId()));

        stack.setItemMeta(meta);
        return stack;
    }
}

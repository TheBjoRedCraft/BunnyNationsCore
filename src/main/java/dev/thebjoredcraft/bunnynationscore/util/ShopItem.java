package dev.thebjoredcraft.bunnynationscore.util;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class ShopItem extends ItemStack {
    private final Material material;
    private final Component lore;
    private final Component displayName;
    private final int prize;
    private int id;


    ShopItem(Material material, Component displayName, Component lore, int prize, int id) {
        this.material = material;
        this.lore = lore;
        this.displayName = displayName;
        this.prize = prize;
    }


    public Material getMaterial() {
        return this.material;
    }
    public int getId(){
        return this.id;
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

    public static ItemStack convertToItemStack(ShopItems data){
        ItemStack stack = new ItemStack(data.getMaterial());
        ItemMeta meta = stack.getItemMeta();
        ArrayList<Component> lore = new ArrayList<>();

        lore.add(data.getLore());
        if(data.getPrize() == 0) {
            lore.add(MiniMessage.miniMessage().deserialize("<color:#3b92d1>Du kannst dieses Item nicht kaufen!"));
        }else{
            lore.add(MiniMessage.miniMessage().deserialize("<color:#3b92d1>Preis: " + data.getPrize() + " Taler"));
        }
        meta.displayName(data.getDisplayName());
        meta.lore(lore);
        meta.setLocalizedName(String.valueOf(data.getId()));

        stack.setItemMeta(meta);
        return stack;
    }
}

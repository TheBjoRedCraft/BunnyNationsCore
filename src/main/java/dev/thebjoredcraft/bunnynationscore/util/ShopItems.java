package dev.thebjoredcraft.bunnynationscore.util;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;

public enum ShopItems {
    MANA(new ShopItem(Material.REDSTONE, MiniMessage.miniMessage().deserialize("<b><color:#ff5714>Mana</color></b"), MiniMessage.miniMessage().deserialize("<color:#3b92d1>Gibt dir <b>Speed 10</b> wenn in der Offhand!"), 1000000, 1)),
    LOOT_BOX(new ShopItem(Material.CHEST, MiniMessage.miniMessage().deserialize("<color:#8a00b0><st>III</st> <b>LootBox </b><st>III</st></color>"), MiniMessage.miniMessage().deserialize("<color:#3b92d1>Verschiedene Sachen - /lootbox"), 10000, 2)),
    NOT_AVAILABLE(new ShopItem(Material.BARRIER, MiniMessage.miniMessage().deserialize("<red>Not available"), MiniMessage.miniMessage().deserialize("<red>Not available"), 0, 3));

    private final Material material;
    private final Component lore;
    private final Component displayName;
    private final int prize;
    private int id;


    ShopItems(ShopItem shopItem) {
        this.material = shopItem.getMaterial();
        this.lore = shopItem.getLoree();
        this.displayName = shopItem.getDisplayName();
        this.prize = shopItem.getPrize();
        this.id = shopItem.getId();
    }


    public Material getMaterial() {
        return this.material;
    }
    public Component getLore() {
        return this.lore;
    }
    public Component getDisplayName() {
        return this.displayName;
    }

    public int getId() {
        return id;
    }

    public int getPrize() {
        return this.prize;
    }

}

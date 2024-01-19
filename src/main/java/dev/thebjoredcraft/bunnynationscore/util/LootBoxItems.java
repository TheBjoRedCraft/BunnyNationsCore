package dev.thebjoredcraft.bunnynationscore.util;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;

public enum LootBoxItems {
    MANA(new LootBoxItem(Material.REDSTONE, MiniMessage.miniMessage().deserialize("<b><color:#ff5714>Mana</color></b"), MiniMessage.miniMessage().deserialize("<color:#3b92d1>Gibt dir <b>Speed 10</b> wenn in der Offhand!"), 1000000)),
    LOOT_BOX(new LootBoxItem(Material.CHEST, MiniMessage.miniMessage().deserialize("<color:#8a00b0><st>III</st> <b>LootBox </b><st>III</st></color>"), MiniMessage.miniMessage().deserialize("<color:#3b92d1>Verschiedene Sachen - /lootbox"), 10000)),
    NOT_AVAILABLE(new LootBoxItem(Material.BARRIER, MiniMessage.miniMessage().deserialize("<red>Not available"), MiniMessage.miniMessage().deserialize("<red>Not available"), 0));

    private final Material material;
    private final Component lore;
    private final Component displayName;
    private final int prize;


    LootBoxItems(LootBoxItem lootBoxItem) {
        this.material = lootBoxItem.getMaterial();
        this.lore = lootBoxItem.getLoree();
        this.displayName = lootBoxItem.getDisplayName();
        this.prize = lootBoxItem.getPrize();
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
    public int getPrize() {
        return this.prize;
    }
}

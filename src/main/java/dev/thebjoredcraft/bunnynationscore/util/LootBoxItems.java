package dev.thebjoredcraft.bunnynationscore.util;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;

public enum LootBoxItems {
    MANA(new LootBoxItem(Material.REDSTONE, MiniMessage.miniMessage().deserialize("<b><color:#ff5714>Mana</color></b"), MiniMessage.miniMessage().deserialize("<color:#3b92d1>Gibt dir <b>Speed 10</b> wenn in der Offhand!"), 1)),
    LOOT_BOX(new LootBoxItem(Material.CHEST, MiniMessage.miniMessage().deserialize("<color:#8a00b0><st>III</st> <b>LootBox </b><st>III</st></color>"), MiniMessage.miniMessage().deserialize("<color:#3b92d1>Verschiedene Sachen - /lootbox"), 2)),
    DIRT(new LootBoxItem(Material.DIRT, MiniMessage.miniMessage().deserialize("<color:#613613><b>Niete</b></color>"), MiniMessage.miniMessage().deserialize("<color:#3b92d1>Niete"), 3)),
    OAK_PLANKS(new LootBoxItem(Material.OAK_PLANKS, MiniMessage.miniMessage().deserialize("<color:#696613><b>Holz</b></color>"), MiniMessage.miniMessage().deserialize("<color:#3b92d1>Ein bisschen Holz"), 4)),
    DIAMOND(new LootBoxItem(Material.DIAMOND, MiniMessage.miniMessage().deserialize("<color:#37bddb><b>Diamant"), MiniMessage.miniMessage().deserialize("<color:#3b92d1>Diamanten!"), 5)),
    IRON(new LootBoxItem(Material.IRON_INGOT, MiniMessage.miniMessage().deserialize("<gray><b>Eisen"), MiniMessage.miniMessage().deserialize("<color:#3b92d1>Hartes Metal"), 6)),
    DIAMOND_PICKAXE(new LootBoxItem(Material.DIAMOND_PICKAXE, MiniMessage.miniMessage().deserialize("<gradient:#aaaaaa:#4d4d4d><b>Silke"), MiniMessage.miniMessage().deserialize("<color:#3b92d1>Silke"), 7)),
    DIAMOND_SWORD(new LootBoxItem(Material.DIAMOND_SWORD, MiniMessage.miniMessage().deserialize("<gradient:#aa0000:#ffcc00><b>Schwert des Professors"), MiniMessage.miniMessage().deserialize("<color:#3b92d1>Schwerti - Signiert von <bold>TheBjoRedCraft"), 8)),
    NOT_AVAILABLE(new LootBoxItem(Material.BARRIER, MiniMessage.miniMessage().deserialize("<red>Not available"), MiniMessage.miniMessage().deserialize("<red>Not available"), 9)),
    DIAMOND_PICKAXE_GLUECKY(new LootBoxItem(Material.DIAMOND_PICKAXE, MiniMessage.miniMessage().deserialize("<gradient:#aaaaaa:#4d4d4d><b>Gluecky"), MiniMessage.miniMessage().deserialize("<color:#3b92d1>Gluecky"), 10));

    private final Material material;
    private final Component lore;
    private final Component displayName;
    private final int id;


    LootBoxItems(LootBoxItem lootBoxItem) {
        this.material = lootBoxItem.getMaterial();
        this.lore = lootBoxItem.getLoree();
        this.displayName = lootBoxItem.getDisplayName();
        this.id = lootBoxItem.getId();
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
}

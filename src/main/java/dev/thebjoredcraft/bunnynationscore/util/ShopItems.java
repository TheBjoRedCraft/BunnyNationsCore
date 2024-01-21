package dev.thebjoredcraft.bunnynationscore.util;

import dev.thebjoredcraft.bunnynationscore.manager.ShopManager;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;

public enum ShopItems {
    MANA_SPEED(new ShopItem(Material.GLOWSTONE_DUST, ShopManager.manaName, MiniMessage.miniMessage().deserialize("<color:#3b92d1>Gibt dir <b>Speed</b> wenn in der Offhand!"), 1000000, 1)),
    LOOT_BOX(new ShopItem(Material.CHEST, ShopManager.lootBoxName, MiniMessage.miniMessage().deserialize("<color:#3b92d1>Verschiedene Sachen - /lootbox"), 10000, 2)),
    ULTRA_GAP(new ShopItem(Material.ENCHANTED_GOLDEN_APPLE, ShopManager.ultra_gap, MiniMessage.miniMessage().deserialize("<color:#3b92d1>Regeneration, Resistance und Health Boost"), 1000000, 3)),
    DIRT(new ShopItem(Material.DIRT, ShopManager.dirt_name, MiniMessage.miniMessage().deserialize("<color:#3b92d1>Niete"), 10, 4)),
    OAK_PLANKS(new ShopItem(Material.OAK_PLANKS, ShopManager.oak_name, MiniMessage.miniMessage().deserialize("<color:#3b92d1>Ein bisschen Holz"), 5, 5)),
    DIAMOND(new ShopItem(Material.DIAMOND, ShopManager.diamond_name, MiniMessage.miniMessage().deserialize("<color:#3b92d1>Diamanten!"), 100, 6)),
    IRON(new ShopItem(Material.IRON_INGOT, ShopManager.iron_name, MiniMessage.miniMessage().deserialize("<color:#3b92d1>Hartes Metal"), 50, 7)),
    DIAMOND_PICKAXE(new ShopItem(Material.DIAMOND_PICKAXE, ShopManager.diapicke_name, MiniMessage.miniMessage().deserialize("<color:#3b92d1>Silke"), 750, 8)),
    DIAMOND_SWORD(new ShopItem(Material.DIAMOND_SWORD, ShopManager.diamond_sword_name, MiniMessage.miniMessage().deserialize("<color:#3b92d1>Schwerti - Signiert von <bold>TheBjoRedCraft"), 1000, 9)),
    NOT_AVAILABLE(new ShopItem(Material.BARRIER, ShopManager.notAvailableName, MiniMessage.miniMessage().deserialize("<red>Not available"), 0, 10)),
    DIAMOND_PICKAXE_GLUECKY(new ShopItem(Material.DIAMOND_PICKAXE, ShopManager.gluecky_name, MiniMessage.miniMessage().deserialize("<color:#3b92d1>Gluecky"), 750, 11)),
    MONSTER_HUNTER(new ShopItem(Material.DIAMOND_SWORD, ShopManager.monster_hunter, MiniMessage.miniMessage().deserialize("<color:#3b92d1>Schwert des Monster Koenigs"), 1000, 12)),
    HELM(new ShopItem(Material.DIAMOND_HELMET, ShopManager.helm, MiniMessage.miniMessage().deserialize("<color:#3b92d1>Alter Helm"), 5000, 13)),
    CHESTPLATE(new ShopItem(Material.DIAMOND_CHESTPLATE, ShopManager.chestplate, MiniMessage.miniMessage().deserialize("<color:#3b92d1>Alter Harnisch"), 10000, 14)),
    LIGGINGS(new ShopItem(Material.DIAMOND_LEGGINGS, ShopManager.leggings, MiniMessage.miniMessage().deserialize("<color:#3b92d1>Alte Hose"), 10000, 15)),
    BOOTS(new ShopItem(Material.DIAMOND_BOOTS, ShopManager.boots, MiniMessage.miniMessage().deserialize("<color:#3b92d1>Alte Schuhe... Fehlt einer?"), 5000, 16)),
    MANA_BOOST(new ShopItem(Material.GLOWSTONE_DUST, ShopManager.manaBoostName, MiniMessage.miniMessage().deserialize("<color:#3b92d1>Verleiht dir beim Click ein Boost"), 1000000, 17));


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

package dev.thebjoredcraft.bunnynationscore.util;

import dev.thebjoredcraft.bunnynationscore.manager.ShopManager;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;

public enum ShopItems {
    MANA_SPEED(new ShopItem(Material.GLOWSTONE_DUST, ShopManager.manaName, MiniMessage.miniMessage().deserialize("<color:#3b92d1>Gibt dir <b>Speed</b> wenn in der Offhand!"), 100000, 1)),
    LOOT_BOX(new ShopItem(Material.CHEST, ShopManager.lootBoxName, MiniMessage.miniMessage().deserialize("<color:#3b92d1>Verschiedene Sachen - /lootbox"), 10000, 2)),
    ULTRA_GAP(new ShopItem(Material.ENCHANTED_GOLDEN_APPLE, ShopManager.ultra_gap, MiniMessage.miniMessage().deserialize("<color:#3b92d1>Regeneration, Resistance und Health Boost"), 100000, 3)),
    DIRT(new ShopItem(Material.DIRT, ShopManager.dirt_name, MiniMessage.miniMessage().deserialize("<color:#3b92d1>Niete"), 10, 4)),
    OAK_PLANKS(new ShopItem(Material.OAK_PLANKS, ShopManager.oak_name, MiniMessage.miniMessage().deserialize("<color:#3b92d1>Ein bisschen Holz"), 5, 5)),
    DIAMOND(new ShopItem(Material.DIAMOND, ShopManager.diamond_name, MiniMessage.miniMessage().deserialize("<color:#3b92d1>Diamanten!"), 100, 6)),
    IRON(new ShopItem(Material.IRON_INGOT, ShopManager.iron_name, MiniMessage.miniMessage().deserialize("<color:#3b92d1>Hartes Metal"), 50, 7)),
    DIAMOND_PICKAXE(new ShopItem(Material.DIAMOND_PICKAXE, ShopManager.diapicke_name, MiniMessage.miniMessage().deserialize("<color:#3b92d1>Silke"), 3000, 8)),
    DIAMOND_SWORD(new ShopItem(Material.DIAMOND_SWORD, ShopManager.diamond_sword_name, MiniMessage.miniMessage().deserialize("<color:#3b92d1>Schwerti - Signiert von <bold>TheBjoRedCraft"), 3000, 9)),
    NOT_AVAILABLE(new ShopItem(Material.BARRIER, ShopManager.notAvailableName, MiniMessage.miniMessage().deserialize("<red>Not available"), 0, 10)),
    DIAMOND_PICKAXE_GLUECKY(new ShopItem(Material.DIAMOND_PICKAXE, ShopManager.gluecky_name, MiniMessage.miniMessage().deserialize("<color:#3b92d1>Gluecky"), 3000, 11)),
    MONSTER_HUNTER(new ShopItem(Material.DIAMOND_SWORD, ShopManager.monster_hunter, MiniMessage.miniMessage().deserialize("<color:#3b92d1>Schwert des Monster Koenigs"), 3000, 12)),
    HELM(new ShopItem(Material.DIAMOND_HELMET, ShopManager.helm, MiniMessage.miniMessage().deserialize("<color:#3b92d1>Alter Helm"), 5000, 13)),
    CHESTPLATE(new ShopItem(Material.DIAMOND_CHESTPLATE, ShopManager.chestplate, MiniMessage.miniMessage().deserialize("<color:#3b92d1>Alter Harnisch"), 10000, 14)),
    LIGGINGS(new ShopItem(Material.DIAMOND_LEGGINGS, ShopManager.leggings, MiniMessage.miniMessage().deserialize("<color:#3b92d1>Alte Hose"), 10000, 15)),
    BOOTS(new ShopItem(Material.DIAMOND_BOOTS, ShopManager.boots, MiniMessage.miniMessage().deserialize("<color:#3b92d1>Alte Schuhe... Fehlt einer?"), 5000, 16)),
    MANA_BOOST(new ShopItem(Material.GLOWSTONE_DUST, ShopManager.manaBoostName, MiniMessage.miniMessage().deserialize("<color:#3b92d1>Verleiht dir beim Click ein Boost"), 1000000, 17)),

    TOTEM(new ShopItem(Material.TOTEM_OF_UNDYING, ShopManager.totem, MiniMessage.miniMessage().deserialize("<color:#3b92d1>1 Leben mehr..."), 10000, 17)),
    ROCKET(new ShopItem(Material.FIREWORK_ROCKET, ShopManager.rocket1, MiniMessage.miniMessage().deserialize("<color:#3b92d1>Flieeeeeegggg"), 100, 17)),
    CARROT(new ShopItem(Material.GOLDEN_CARROT, ShopManager.carrot, MiniMessage.miniMessage().deserialize("<color:#3b92d1>Lecker!"), 100, 17)),
    STEAK(new ShopItem(Material.COOKED_BEEF, ShopManager.steak, MiniMessage.miniMessage().deserialize("<color:#3b92d1>Lecker!"), 50, 17)),
    UPGRADE(new ShopItem(Material.NETHERITE_UPGRADE_SMITHING_TEMPLATE, ShopManager.upgrade_template, MiniMessage.miniMessage().deserialize("<color:#3b92d1>Zum Upgraden von Diamant-Ruestung"), 1000, 17)),
    SILENCE(new ShopItem(Material.SILENCE_ARMOR_TRIM_SMITHING_TEMPLATE, ShopManager.silence, MiniMessage.miniMessage().deserialize("<color:#3b92d1>Das seltenste Ruestungs-Template"), 10000, 17)),
    SPIRE(new ShopItem(Material.SPIRE_ARMOR_TRIM_SMITHING_TEMPLATE, ShopManager.spire, MiniMessage.miniMessage().deserialize("<color:#3b92d1>Ein Ruestung-Template"), 1000, 17)),
    DUNE(new ShopItem(Material.DUNE_ARMOR_TRIM_SMITHING_TEMPLATE, ShopManager.dune, MiniMessage.miniMessage().deserialize("<color:#3b92d1>Ein Ruestung-Template"), 1000, 17)),
    REDSTONE(new ShopItem(Material.REDSTONE, ShopManager.redstone, MiniMessage.miniMessage().deserialize("<color:#3b92d1>Red?"), 25, 17)),
    GOLD(new ShopItem(Material.GOLD_INGOT, ShopManager.gold, MiniMessage.miniMessage().deserialize("<color:#3b92d1>Goldi!"), 100, 17)),
    SLIME(new ShopItem(Material.SLIME_BALL, ShopManager.slime, MiniMessage.miniMessage().deserialize("<color:#3b92d1>Schleimig"), 100, 17)),
    HONEY(new ShopItem(Material.HONEY_BOTTLE, ShopManager.honey, MiniMessage.miniMessage().deserialize("<color:#3b92d1>Klebrig!"), 25, 17)),
    LAVA(new ShopItem(Material.LAVA_BUCKET, ShopManager.lava, MiniMessage.miniMessage().deserialize("<color:#3b92d1>Heiss!"), 50, 17)),
    WATER(new ShopItem(Material.WATER_BUCKET, ShopManager.water, MiniMessage.miniMessage().deserialize("<color:#3b92d1>Woraus besteht Wasser?"), 50, 17)),
    NEXTBuy(new ShopItem(Material.ARROW, ShopManager.otherStuffBuy, MiniMessage.miniMessage().deserialize("<color:#3b92d1>Naechste Seite"), 1000000, 17)),
    BACKBuy(new ShopItem(Material.ARROW, ShopManager.invStuffBuy, MiniMessage.miniMessage().deserialize("<color:#3b92d1>Zurueck"), 1000000, 17)),
    DIAMOND_AXE(new ShopItem(Material.DIAMOND_AXE, ShopManager.axe, MiniMessage.miniMessage().deserialize("<color:#3b92d1>Axe"), 1500, 17)),
    DIAMOND_SHOVEL(new ShopItem(Material.DIAMOND_SHOVEL, ShopManager.shovel, MiniMessage.miniMessage().deserialize("<color:#3b92d1>Ahoiiii!"), 1500, 17)),
    GUNPOWDER(new ShopItem(Material.GUNPOWDER, ShopManager.gunpowder, MiniMessage.miniMessage().deserialize("<color:#3b92d1>Schiesspulver!"), 10, 17)),
    PAPER(new ShopItem(Material.PAPER, ShopManager.paper, MiniMessage.miniMessage().deserialize("<color:#3b92d1>Papier!"), 10, 17)),
    BREAD(new ShopItem(Material.BREAD, ShopManager.breadName, MiniMessage.miniMessage().deserialize("<color:#3b92d1>Eine kleine Nahrungsquelle"), 100, 18));



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

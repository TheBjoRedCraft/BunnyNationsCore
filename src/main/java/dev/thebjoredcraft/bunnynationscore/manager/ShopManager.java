package dev.thebjoredcraft.bunnynationscore.manager;

import dev.thebjoredcraft.bunnynationscore.command.economy.SellCommand;
import dev.thebjoredcraft.bunnynationscore.util.ItemUtils;
import dev.thebjoredcraft.bunnynationscore.util.ShopItem;
import dev.thebjoredcraft.bunnynationscore.util.ShopItems;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ShopManager {
    public static String traderTag = "bunnynations:trader:id:6548795758745865704986450968867784867476776779348968767";
    public static String traderSellTag = "bunnynations:trader:id:6548795758745865704986450968867784867476776779348968767787";

    public static Inventory shop = Bukkit.createInventory(null, 54, MiniMessage.miniMessage().deserialize("<bold>Verkauf"));
    public static Inventory shop1 = Bukkit.createInventory(null, 54, MiniMessage.miniMessage().deserialize("<bold>Verkauf"));
    public static Inventory sellShop = Bukkit.createInventory(null, 54, MiniMessage.miniMessage().deserialize("<bold>Ankauf"));

    public static Component notAvailableName = MiniMessage.miniMessage().deserialize("<red><bold>Not available");

    public static Component breadName = MiniMessage.miniMessage().deserialize("<b><color:#ff5714>Saftiges Brot");

    public static Component dirt_name = MiniMessage.miniMessage().deserialize("<color:#613613><b>Niete</b></color>");
    public static Component oak_name = MiniMessage.miniMessage().deserialize("<color:#696613><b>Holz</b></color>");
    public static Component diamond_name = MiniMessage.miniMessage().deserialize("<color:#37bddb><b>Diamant");
    public static Component iron_name = MiniMessage.miniMessage().deserialize("<gray><b>Eisen");

    public static Component diapicke_name = MiniMessage.miniMessage().deserialize("<gradient:#aaaaaa:#4d4d4d><b>Silke");
    public static Component gluecky_name = MiniMessage.miniMessage().deserialize("<gradient:#aaaaaa:#4d4d4d><b>Gluecky");
    public static Component diamond_sword_name = MiniMessage.miniMessage().deserialize("<gradient:#aa0000:#ffcc00><b>Schwert des Professors");
    public static Component monster_hunter = MiniMessage.miniMessage().deserialize("<b><gradient:#00aa00:#5555ff>Monster Hunter");
    public static Component axe = MiniMessage.miniMessage().deserialize("<b><gradient:#aaaaaa:#4d4d4d>Axt of Diamond");
    public static Component shovel = MiniMessage.miniMessage().deserialize("<b><gradient:#00aa00:#5555ff>Schaufel eines Piraten!");

    public static Component helm = MiniMessage.miniMessage().deserialize("<gradient:#55ffff:#00aa63><b>Helm des Ritters");
    public static Component chestplate = MiniMessage.miniMessage().deserialize("<gradient:#55ffff:#00aa63><b>Harnisch des Ritters");
    public static Component leggings = MiniMessage.miniMessage().deserialize("<gradient:#55ffff:#00aa63><b>Hose des Ritters");
    public static Component boots = MiniMessage.miniMessage().deserialize("<gradient:#55ffff:#00aa63><b>Schuhe des Ritters");

    public static Component manaBoostName = MiniMessage.miniMessage().deserialize("<b><color:#ff5714>Boost Mana");
    public static Component manaName = MiniMessage.miniMessage().deserialize("<b><color:#ff5714>Speed Mana");

    public static Component lootBoxName = MiniMessage.miniMessage().deserialize("<color:#8a00b0><st>III</st> <b>LootBox </b><st>III");
    public static Component ultra_gap = MiniMessage.miniMessage().deserialize("<b><gradient:#8a008a:#ff00ff>Ultra Goldapfel");

    public static Component totem = MiniMessage.miniMessage().deserialize("<gold>Totem eines echten Ritters");
    public static Component rocket1 = MiniMessage.miniMessage().deserialize("<gradient:red:white>Rakete Stufe 1");
    public static Component carrot = MiniMessage.miniMessage().deserialize("<color:#ff5714>Leckere Karotte");
    public static Component steak = MiniMessage.miniMessage().deserialize("<color:#ff5714>Leckeres Steak");
    public static Component upgrade_template = MiniMessage.miniMessage().deserialize("<gray>Upgrade Template");
    public static Component silence = MiniMessage.miniMessage().deserialize("<blue>Silence - Armor Trim");
    public static Component spire = MiniMessage.miniMessage().deserialize("<blue>Silence - Armor Spire");
    public static Component dune = MiniMessage.miniMessage().deserialize("<blue>Silence - Armor Dune");
    public static Component redstone = MiniMessage.miniMessage().deserialize("<red>Redstone");
    public static Component gold = MiniMessage.miniMessage().deserialize("<gold>Gold");
    public static Component slime = MiniMessage.miniMessage().deserialize("<green>Slime");
    public static Component honey = MiniMessage.miniMessage().deserialize("<yellow>Honig");
    public static Component lava = MiniMessage.miniMessage().deserialize("<color:#ff8400>Lava Eimer");
    public static Component water = MiniMessage.miniMessage().deserialize("<blue>Wasser Eimer");
    public static Component gunpowder = MiniMessage.miniMessage().deserialize("<gray>Schiesspulver");
    public static Component paper = MiniMessage.miniMessage().deserialize("<white>Papier aus der Wueste");

    public static Component otherStuffBuy = MiniMessage.miniMessage().deserialize("<color:#3b92d1>Weiteres");
    public static Component invStuffBuy = MiniMessage.miniMessage().deserialize("<color:#3b92d1>Zurueck");
    public static void openShopGUI(Player player){
        for (int i = 0; i < 54; i++) {
            shop.setItem(i, ShopItem.convertToItemStack(ShopItems.NOT_AVAILABLE));
        }


        player.openInventory(shop);

    }
    public static void openShop2GUI(Player player){
        for (int i = 0; i < 54; i++) {
            shop.setItem(i, ShopItem.convertToItemStack(ShopItems.NOT_AVAILABLE));
        }

        player.openInventory(shop);

    }
    public static void openSellGUI(Player player){
        for (int i = 0; i < 54; i++) {
            sellShop.setItem(i, ShopItem.convertToItemStack(ShopItems.NOT_AVAILABLE));
        }
        ItemStack i10 = ItemUtils.createItem(Material.DRAGON_HEAD, "<color:#3b92d1>Du bekommst: " + SellCommand.itemsToSell.get(Material.DRAGON_HEAD));
        ItemStack i12 = ItemUtils.createItem(Material.ENCHANTED_GOLDEN_APPLE, "<color:#3b92d1>Du bekommst: " + SellCommand.itemsToSell.get(Material.ENCHANTED_GOLDEN_APPLE));
        ItemStack i14 = ItemUtils.createItem(Material.EMERALD, "<color:#3b92d1>Du bekommst: " + SellCommand.itemsToSell.get(Material.EMERALD));
        ItemStack i16 = ItemUtils.createItem(Material.OAK_LOG, "<color:#3b92d1>Du bekommst: " + SellCommand.itemsToSell.get(Material.OAK_LOG));
        ItemStack i19 = ItemUtils.createItem(Material.DRAGON_EGG, "<color:#3b92d1>Du bekommst: " + SellCommand.itemsToSell.get(Material.DRAGON_EGG));
        ItemStack i21 = ItemUtils.createItem(Material.GOLDEN_APPLE, "<color:#3b92d1>Du bekommst: " + SellCommand.itemsToSell.get(Material.GOLDEN_APPLE));
        ItemStack i23 = ItemUtils.createItem(Material.DIAMOND, "<color:#3b92d1>Du bekommst: " + SellCommand.itemsToSell.get(Material.DIAMOND));
        ItemStack i25 = ItemUtils.createItem(Material.BLAZE_ROD, "<color:#3b92d1>Du bekommst: " + SellCommand.itemsToSell.get(Material.BLAZE_ROD));
        ItemStack i28 = ItemUtils.createItem(Material.ELYTRA, "<color:#3b92d1>Du bekommst: " + SellCommand.itemsToSell.get(Material.ELYTRA));
        ItemStack i30 = ItemUtils.createItem(Material.GOLDEN_CARROT, "<color:#3b92d1>Du bekommst: " + SellCommand.itemsToSell.get(Material.GOLDEN_CARROT));
        ItemStack i32 = ItemUtils.createItem(Material.IRON_INGOT, "<color:#3b92d1>Du bekommst: " + SellCommand.itemsToSell.get(Material.IRON_INGOT));
        ItemStack i34 = ItemUtils.createItem(Material.COAL, "<color:#3b92d1>Du bekommst: " + SellCommand.itemsToSell.get(Material.COAL));
        ItemStack i37 = ItemUtils.createItem(Material.DRAGON_BREATH, "<color:#3b92d1>Du bekommst: " + SellCommand.itemsToSell.get(Material.DRAGON_BREATH));
        ItemStack i39 = ItemUtils.createItem(Material.GOLD_INGOT, "<color:#3b92d1>Du bekommst: " + SellCommand.itemsToSell.get(Material.GOLD_INGOT));

        sellShop.setItem(10, i10);
        sellShop.setItem(12, i12);
        sellShop.setItem(14, i14);
        sellShop.setItem(16, i16);
        sellShop.setItem(19, i19);
        sellShop.setItem(21, i21);
        sellShop.setItem(23, i23);
        sellShop.setItem(25, i25);
        sellShop.setItem(28, i28);
        sellShop.setItem(30, i30);
        sellShop.setItem(32, i32);
        sellShop.setItem(34, i34);
        sellShop.setItem(37, i37);
        sellShop.setItem(39, i39);




        player.openInventory(sellShop);
    }
    public static void spawnBuyTrader(Location loc){
        Entity trader = loc.getWorld().spawnEntity(loc, EntityType.VILLAGER);

        trader.setCustomNameVisible(true);
        trader.customName(MiniMessage.miniMessage().deserialize("<bold>Verkauf"));

        trader.setInvulnerable(true);
        trader.setSilent(true);
        trader.setGravity(false);
        trader.addScoreboardTag(traderTag);

        LivingEntity livingEntity = (LivingEntity) trader;
        livingEntity.setAI(false);
    }
    public static void spawnSellTrader(Location loc){
        Entity trader = loc.getWorld().spawnEntity(loc, EntityType.VILLAGER);

        trader.setCustomNameVisible(true);
        trader.customName(MiniMessage.miniMessage().deserialize("<bold>Ankauf"));

        trader.setInvulnerable(true);
        trader.setSilent(true);
        trader.setGravity(false);
        trader.addScoreboardTag(traderSellTag);

        LivingEntity livingEntity = (LivingEntity) trader;
        livingEntity.setAI(false);
    }
}

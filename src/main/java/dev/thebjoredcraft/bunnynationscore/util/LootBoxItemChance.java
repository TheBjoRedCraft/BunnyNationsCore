package dev.thebjoredcraft.bunnynationscore.util;

public class LootBoxItemChance {

    private final LootBoxItems item;
    private final double chance;

    public LootBoxItemChance(LootBoxItems item, double chance) {
        this.item = item;
        this.chance = chance;
    }

    public LootBoxItems getItem() {
        return item;
    }

    public double getChance() {
        return chance;
    }
}

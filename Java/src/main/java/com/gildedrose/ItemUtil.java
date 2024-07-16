package com.gildedrose;

public class ItemUtil {
    public static boolean isSellInLessThanZero(Item item) {
        return item.sellIn < 0;
    }

    public static int decrementSellInByOne(Item item) {
        return item.sellIn -= 1;
    }

    public static int decrementQualityByOne(Item item) {
        return item.quality -= 1;
    }

    public static int decrementQualityByTwo(Item item) {
        if (item.quality - 2 >= 0) {
            return item.quality -= 2;
        }
        return item.quality;
    }

    public static int incrementQualityByOne(Item item) {
        if ((isSulfuras(item) && item.quality < 80) || (!isSulfuras(item) && item.quality < 50)) {
            return ++item.quality;
        }
        return item.quality;
    }

    private static boolean isSulfuras(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    public static boolean isLessThanQualityMaximum(Item item) {
        if (isSulfuras(item)) {
            return item.quality < 80;
        }
        return item.quality < 50;
    }
    public static boolean isQtyHigherOrEqualToZero(Item item) {
        return item.quality >= 0;
    }
}

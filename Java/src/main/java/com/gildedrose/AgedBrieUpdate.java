package com.gildedrose;


import static com.gildedrose.ItemUtil.*;

public class AgedBrieUpdate implements UpdateItem {
    @Override
    public void updateQuality(Item item) {
        if (isLessThanQualityMaximum(item) && isQtyHigherOrEqualToZero(item)) {
            item.quality = incrementQualityByOne(item);
            item.sellIn = decrementSellInByOne(item);
        }
    }
}

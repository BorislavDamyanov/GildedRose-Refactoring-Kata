package com.gildedrose;

import static com.gildedrose.ItemUtil.*;

public class UpdateDefaultItem implements UpdateItem {
    @Override
    public void updateQuality(Item item) {
        if (isQtyHigherOrEqualToZero(item)) {
            decrementQualityByOne(item);
        }
        if (item.sellIn < 0 && isQtyHigherOrEqualToZero(item)) {
            decrementQualityByOne(item);
        }
    }
}

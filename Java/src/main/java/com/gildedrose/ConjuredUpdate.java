package com.gildedrose;

import static com.gildedrose.ItemUtil.*;

public class ConjuredUpdate implements UpdateItem {
    @Override
    public void updateQuality(Item item) {
        if (!isLessThanQualityMaximum(item)) {
            decrementQualityByTwo(item);
        }
        decrementSellInByOne(item);
        if (isSellInLessThanZero(item) && isQtyHigherOrEqualToZero(item)) {
            decrementQualityByTwo(item);
        }
    }


    public static int decrementQualityByTwo(Item item) {
        if (item.quality - 2 >= 0) {
            return item.quality -= 2;
        }
        return item.quality = 0;
    }
}

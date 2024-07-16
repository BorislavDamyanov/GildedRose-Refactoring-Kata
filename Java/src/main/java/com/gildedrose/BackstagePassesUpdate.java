package com.gildedrose;

import static com.gildedrose.ItemUtil.*;


public class BackstagePassesUpdate implements UpdateItem {



    @Override
    public void updateQuality(Item item) {
        if(item.quality < 50) {
            decrementSellInByOne(item);
            if (checkSellInMoreRestDays(item,10)) {
                increaseQualityBy(item,1);
            } else if (checkSellInMoreRestDays(item,5)) {
                increaseQualityBy(item,2);
            } else if (checkSellInMoreRestDays(item,0)) {
                increaseQualityBy(item,3);
            } else {
                initQualityToZero(item);
            }
        }
    }

    private boolean checkSellInMoreRestDays(Item item, int restDays) {
        return item.sellIn > restDays;
    }

    private void initQualityToZero(Item item) {
        item.quality = 0;
    }

    private void increaseQualityBy(Item item, int qualityValue) {
        item.quality += qualityValue;
    }
}

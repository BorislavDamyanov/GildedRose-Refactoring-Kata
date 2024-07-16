package com.gildedrose;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AgedBrieUpdateTest {


    AgedBrieUpdate updater;
    @BeforeEach
    void setUp() {
        updater = new AgedBrieUpdate();
    }


    @Test
    void updateQuality_WithQualityBelowMax_IncreasesQualityByOne() {
        Item item = new Item("Aged Brie", 10, 49);
        updater.updateQuality(item);
        assertEquals(50, item.quality, "Quality should increase by 1");
    }

    @Test
    void updateQuality_WithSellInAboveZero_DecreasesSellInByOne() {
        Item item = new Item("Aged Brie", 10, 20);
        updater.updateQuality(item);
        assertEquals(9, item.sellIn, "SellIn should decrease by 1");
    }

    @Test
    void updateQuality_WithQualityAtMax_KeepsQualityUnchanged() {
        Item item = new Item("Aged Brie", 5, 50);
        updater.updateQuality(item);
        assertEquals(50, item.quality, "Quality should remain unchanged");
    }

    @Test
    void updateQuality_WithNegativeQuality_KeepsQualityUnchanged() {
        Item item = new Item("Aged Brie", 5, -1);
        updater.updateQuality(item);
        assertEquals(-1, item.quality, "Quality should remain unchanged");
    }

}

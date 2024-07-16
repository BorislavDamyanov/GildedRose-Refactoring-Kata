package com.gildedrose;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UpdateDefaultItemTest {


    private UpdateDefaultItem updater;
    private Item item;

    @BeforeEach
    void setUp() {
        updater = new UpdateDefaultItem();
    }

    @Test
    void updateQuality_WithPositiveQualityAndSellIn_DecreasesQualityByOne() {
        item = new Item("foo", 5, 10);
        updater.updateQuality(item);
        assertEquals(9, item.quality, "Quality should decrease by 1");
    }

    @Test
    void updateQuality_WithZeroQuality_returnOne() {
        item = new Item("foo", 5, 0);
        updater.updateQuality(item);
        assertEquals(1, item.quality, "Quality should remain unchanged");
    }

    @Test
    void updateQuality_WithNegativeSellInAndPositiveQuality_DecreasesQualityByTwo() {
        item = new Item("foo", -1, 10);
        updater.updateQuality(item);
        assertEquals(8, item.quality, "Quality should decrease by 2");
    }

    @Test
    void updateQuality_WithNegativeSellInAndQualityOne_DecreasesQualityToOne() {
        item = new Item("foo", -1, 1);
        updater.updateQuality(item);
        assertEquals(0, item.quality, "Quality should decrease to 0");
    }
}


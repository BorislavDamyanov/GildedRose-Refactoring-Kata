package com.gildedrose;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConjuredUpdateTest {

    ConjuredUpdate updater;
    @BeforeEach
    public void setUp() {
        updater = new ConjuredUpdate();
    }


    @Test
    public void qualityDecreasesByTwoWhenAboveMaximum() {
        Item item = new Item("Conjured Mana Cake", 3, 55);
        updater.updateQuality(item);
        assertEquals(item.quality, 53,"Quality should decrease by 2 when above maximum");
        assertEquals( item.sellIn, 2,"SellIn should decrease by 1 after update");
    }


    @Test
    public void qualityDoesNotGoNegative() {
        Item item = new Item("Conjured Mana Cake", -1, 0);
        updater.updateQuality(item);
        assertEquals(0, item.quality, "Quality should not go negative");
        assertEquals(-2, item.sellIn, "SellIn should decrease by 1 after update");
    }
}

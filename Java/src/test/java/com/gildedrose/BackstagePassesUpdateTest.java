package com.gildedrose;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BackstagePassesUpdateTest {

    BackstagePassesUpdate updater;
    @BeforeEach
    void setUp() {
        updater = new BackstagePassesUpdate();
    }


    @Test
    public void qualityIncreasesByOneWhenSellInAboveTen() {
        Item item = new Item("Backstage passes", 12, 20);
        updater.updateQuality(item);
        assertEquals(21, item.quality);
        assertEquals( item.sellIn,11);
    }

    @Test
    public void qualityIncreasesByTwoWhenSellInBetweenSixAndTen() {
        Item item = new Item("Backstage passes", 10, 20);
        updater.updateQuality(item);
        assertEquals(22, item.quality);
        assertEquals(9, item.sellIn);
    }

    @Test
    public void qualityIncreasesByThreeWhenSellInBetweenOneAndFive() {
        Item item = new Item("Backstage passes", 5, 20);
        updater.updateQuality(item);
        assertEquals(23, item.quality);
        assertEquals(4, item.sellIn);
    }

    @Test
    public void qualityDropsToZeroAfterConcert() {
        Item item = new Item("Backstage passes", 0, 20);
        updater.updateQuality(item);
        assertEquals(0, item.quality);
        assertEquals(-1, item.sellIn);
    }

    @Test
    public void qualityDoesNotIncreasePastMaximum() {
        Item item = new Item("Backstage passes", 12, 49);
        updater.updateQuality(item);
        assertEquals(50, item.quality); // Assuming 50 is the max quality
        assertEquals(item.sellIn,11);
    }
}

package com.gildedrose;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemUtilTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void isSellInLessThanZero_WithNegativeSellIn_ReturnsTrue() {
        Item item = new Item("Test", -1, 10);
        assertTrue(ItemUtil.isSellInLessThanZero(item));
    }

    @Test
    void isSellInLessThanZero_WithPositiveSellIn_ReturnsFalse() {
        Item item = new Item("Test", 1, 10);
        assertFalse(ItemUtil.isSellInLessThanZero(item));
    }

    @Test
    void decrementSellInByOne_DecreasesSellInByOne() {
        Item item = new Item("Test", 10, 10);
        ItemUtil.decrementSellInByOne(item);
        assertEquals(9, item.sellIn);
    }

    @Test
    void decrementQualityByOne_DecreasesQualityByOne() {
        Item item = new Item("Test", 10, 10);
        ItemUtil.decrementQualityByOne(item);
        assertEquals(9, item.quality);
    }

    @Test
    void decrementQualityByTwo_DecreasesQualityByTwo() {
        Item item = new Item("Test", 10, 10);
        ItemUtil.decrementQualityByTwo(item);
        assertEquals(8, item.quality);
    }


    @Test
    void incrementQualityByOne_IncreasesQualityByOne() {
        Item item = new Item("Test", 10, 10);
        ItemUtil.incrementQualityByOne(item);
        assertEquals(11, item.quality);
    }

    @Test
    void incrementQualityByOne_WithSulfurasAndQualityBelow80_IncreasesQualityByOne() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 10, 79);
        ItemUtil.incrementQualityByOne(item);
        assertEquals(80, item.quality);
    }

    @Test
    void isLessThanQualityMaximum_WithSulfurasAndQuality79_ReturnsTrue() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 10, 79);
        assertTrue(ItemUtil.isLessThanQualityMaximum(item));
    }

    @Test
    void isLessThanQualityMaximum_WithNonSulfurasAndQuality49_ReturnsTrue() {
        Item item = new Item("Test", 10, 49);
        assertTrue(ItemUtil.isLessThanQualityMaximum(item));
    }

    @Test
    void isQualityHigherOrEqualToZero_WithPositiveQty_ReturnsTrue() {
        Item item = new Item("Test", 10, 1);
        assertTrue(ItemUtil.isQtyHigherOrEqualToZero(item));
    }

    @Test
    void isQualityHigherOrEqualToZero_WithNegativeQty_ReturnsFalse() {
        Item item = new Item("Test", 10, -1);
        assertFalse(ItemUtil.isQtyHigherOrEqualToZero(item));
    }
}

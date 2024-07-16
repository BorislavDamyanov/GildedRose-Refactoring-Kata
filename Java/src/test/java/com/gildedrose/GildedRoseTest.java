package com.gildedrose;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {


    private GildedRose app;

    @BeforeEach
    void setUp() {
        Item[] items = new Item[]{
            new Item("Aged Brie", 2, 0),
            new Item("Sulfuras, Hand of Ragnaros", 0, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Conjured", 3, 6),
            new Item("foo", 5, 7)
        };
        app = new GildedRose(items);
    }

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }




    @Test
    void updateQuality_AgedBrie_IncreasesQuality() {
        app.updateQuality();
        assertEquals(1, app.items[0].quality, "Aged Brie quality should increase");
    }

    @Test
    void updateQuality_Sulfuras_QualityUnchanged() {
        app.updateQuality();
        assertEquals(80, app.items[1].quality, "Sulfuras quality should remain unchanged");
    }

    @Test
    void updateQuality_BackstagePasses_IncreasesQuality() {
        app.updateQuality();
        assertEquals(21, app.items[2].quality, "Backstage passes quality should increase");
    }



    @Test
    void updateQuality_DefaultItem_DecreasesQuality() {
        app.updateQuality();
        assertEquals(6, app.items[4].quality, "Default item quality should decrease");
    }

}

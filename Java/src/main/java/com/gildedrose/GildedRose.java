package com.gildedrose;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }



    public void updateQuality() {
        for (Item item : items) {
            UpdateItem updater = updateItem(item);
            updater.updateQuality(item);
        }
    }

    private UpdateItem updateItem(Item item) {
        switch (item.name) {
            case "Aged Brie":
                return new AgedBrieUpdate();
            case "Sulfuras, Hand of Ragnaros":
                return new SulfurasUpdate();
            case "Backstage passes to a TAFKAL80ETC concert":
                return new BackstagePassesUpdate();
            case "Conjured":
                return new ConjuredUpdate();
            default:
                return new UpdateDefaultItem();
        }
    }
}

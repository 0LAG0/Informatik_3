package gildedrose;

import java.util.ArrayList;
import java.util.List;

public class GildedRose {

    private static List<Item> items = null;

    public void updateQuality() {
        for (Item i : items) {
            Category category = label(i);
            category.updateItem(i);
        }
    }

    private Category label(Item i) {
        if (i.getName().equals("Sulfuras, Hand of Ragnaros")) {
            return new Legendary();
        }
        if (i.getName().equals("Aged Brie")) {
            return new Cheese();
        }
        if (i.getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
            return new BackstagePass();
        }
        if (i.getName().equals("Conjured Mana Cake")) {
            return new Conjured();
        } else return new Category();
    }

    private static void decQuality(Item i) {
        i.setQuality(i.getQuality() - 1);
    }

    private static void incQuality(Item i) {
        i.setQuality(i.getQuality() + 1);
    }

    private static void decSellin(Item i) {
        i.setSellIn(i.getSellIn() - 1);
    }

    public static void setItems(List<Item> items) {
        GildedRose.items = items;
    }

    public class Category {
        public void updateItem(Item i) {
            decSellin(i);
            decQuality(i);
            if (i.sellIn < 0) {
                decQuality(i);
            }
            if (i.quality < 0) {
                i.setQuality(0);
            }
            if (i.quality > 50) {
                i.setQuality(50);
            }
        }
    }

    private class Cheese extends Category {
        @Override
        public void updateItem(Item i) {
            decSellin(i);
            incQuality(i);
            if (i.quality > 50) {
                i.setQuality(50);
            }
        }
    }

    private class Legendary extends Category {
        @Override
        public void updateItem(Item i) {
            if (i.quality != 80) {
                i.setQuality(80);
            }
            if (i.sellIn != 0) {
                i.setSellIn(0);
            }
        }
    }

    private class BackstagePass extends Category {
        @Override
        public void updateItem(Item i) {
            decSellin(i);
            incQuality(i);
            if (i.getSellIn() < 11) {
                incQuality(i);
            }
            if (i.getSellIn() < 6) {
                incQuality(i);
            }
            if (i.quality > 50) {
                i.setQuality(50);
            }
            if (i.sellIn < 0) {
                i.setQuality(0);
            }
        }
    }

    private class Conjured extends Category {
        @Override
        public void updateItem(Item i) {
            decSellin(i);
            decQuality(i);
            decQuality(i);
            if (i.sellIn < 0) {
                decQuality(i);
                decQuality(i);
            }
            if (i.quality < 0) {
                i.setQuality(0);
            }
        }
    }
}
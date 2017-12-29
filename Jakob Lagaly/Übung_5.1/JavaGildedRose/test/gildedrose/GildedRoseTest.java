package gildedrose;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class GildedRoseTest {

    @Parameters
    public static Collection<Object[]> data() {
        Collection<Object[]> data = new ArrayList<Object[]>();
        data.addAll(Arrays
                .asList(new Object[][]{{"At the end of each day our system lowers both quality and sell-in for every item",
                        "Item with arbitrary name", 5, 49, 4, 48},
                        {"At the end of each day our system lowers both quality and sell-in for every item",
                                "+5 Dexterity Vest", 10, 20, 9, 19},

                        // Cheese
                        {"At the end of each day our system lowers both quality and sell-in for every item",
                                "Aged Brie", 17, 0, 16, 1},
                        // test if quality doesnt exceed 50 (and corrects it)
                        {"At the end of each day our system lowers both quality and sell-in for every item",
                                "Aged Brie", 17, 51, 16, 50},

                        // Elixir
                        // test if both sellin and quality decreases
                        {"At the end of each day our system lowers both quality and sell-in for every item",
                                "Elixir of the Mongoose", 5, 7, 4, 6},
                        // test if quality stays 0 if the sellin date is negative
                        {"At the end of each day our system lowers both quality and sell-in for every item",
                                "Elixir of the Mongoose", -1, 0, -2, 0},
                        // test if quality stays/corrects at 50
                        {"At the end of each day our system lowers both quality and sell-in for every item",
                                "Elixir of the Mongoose", 10, 100, 9, 50},

                        // Ragnaros
                        // test if neither sellin nor quality decreases or increases
                        {"At the end of each day our system lowers both quality and sell-in for every item",
                                "Sulfuras, Hand of Ragnaros", 0, 80, 0, 80},
                        // test if quality and sellin stays/corrects at !80 and !0
                        {"At the end of each day our system lowers both quality and sell-in for every item",
                                "Sulfuras, Hand of Ragnaros", 45, 45, 0, 80},

                        // BackstagePass:
                        {"At the end of each day our system lowers both quality and sell-in for every item",
                                "Backstage passes to a TAFKAL80ETC concert", 15, 20, 14, 21},
                        // test backstagepass when date is expired
                        {"At the end of each day our system lowers both quality and sell-in for every item",
                                "Backstage passes to a TAFKAL80ETC concert", 0, 20, -1, 0},
                        // test backstagepass when date is 10 days away
                        {"At the end of each day our system lowers both quality and sell-in for every item",
                                "Backstage passes to a TAFKAL80ETC concert", 10, 20, 9, 22},
                        // test backstagepass when date is 5 days away
                        {"At the end of each day our system lowers both quality and sell-in for every item",
                                "Backstage passes to a TAFKAL80ETC concert", 5, 20, 4, 23},
                        // test backstagepass qualitry doesnt exceed 50 (and corrects it)
                        {"At the end of each day our system lowers both quality and sell-in for every item",
                                "Backstage passes to a TAFKAL80ETC concert", 5, 51, 4, 50},

                        // Conjured
                        {"At the end of each day our system lowers both quality and sell-in for every item",
                                "Conjured Mana Cake", 3, 6, 2, 4},
                        // test if quality decreases by 4 at negative sellin
                        {"At the end of each day our system lowers both quality and sell-in for every item",
                                "Conjured Mana Cake", -10, 6, -11, 2},
                        // test if quality stays at 0 (and corrects it)
                        {"At the end of each day our system lowers both quality and sell-in for every item",
                                "Conjured Mana Cake", 3, -1, 2, 0},

                        // Vest
                        // test if quality stays at 0 (and corrects it)
                        {"At the end of each day our system lowers both quality and sell-in for every item",
                                "+5 Dexterity Vest", -1, -1, -2, 0},
                        // test if quality corrects at >50
                        {"At the end of each day our system lowers both quality and sell-in for every item",
                                "+5 Dexterity Vest", 2, 500, 1, 50}








    }));

        return data;
    }

    String message;
    String itemName;
    int sellIn;
    int quality;
    int expectedSellIn;
    int expectedQuality;
    Item item;
    GildedRose guild = new GildedRose();

    public GildedRoseTest(String message, String itemName, int sellIn,
                          int quality, int expectedSellIn, int expectedQuality) {
        this.message = message;
        this.itemName = itemName;
        this.sellIn = sellIn;
        this.quality = quality;
        this.expectedSellIn = expectedSellIn;
        this.expectedQuality = expectedQuality;
    }

    @Before
    public void setUp() {
        List<Item> items = new ArrayList<Item>();
        items.add(item = new Item(itemName, sellIn, quality));
        GildedRose.setItems(items);
    }

    @Test
    public void testQualityUpdate() {
        guild.updateQuality();
        assertEquals(message + " Quality ", expectedQuality, item.getQuality());
    }

    @Test
    public void testSellInUpdate() {
        guild.updateQuality();
        assertEquals(message + " SellIn", expectedSellIn, item.getSellIn());
    }
}

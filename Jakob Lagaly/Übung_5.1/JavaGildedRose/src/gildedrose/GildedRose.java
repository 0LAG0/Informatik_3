package gildedrose;

import java.util.ArrayList;
import java.util.List;

public class GildedRose {

	private static List<Item> items = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("OMGHAI!");

		GildedRose newGuild = new GildedRose();

		items = new ArrayList<Item>();
		items.add(new Item("+5 Dexterity Vest", 10, 20));
		items.add(new Item("Aged Brie", 2, 0));
		items.add(new Item("Elixir of the Mongoose", 5, 7));
		items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		items.add(new Item("Conjured Mana Cake", 3, 6));

		newGuild.updateQuality();
	}

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
		}
		return new Category();
	}

	private static void decQuality(Item i) {

		i.setQuality(i.getQuality() - 1);
	}

	private static void incQuality(Item i) {

		i.setQuality(i.getQuality() + 1);
	}

	private static void updateSellin(Item i) {
		i.setSellIn(i.getSellIn() - 1);
	}
	/*
	 * minimal addition to ensure testability
	 */

	public static void setItems(List<Item> items) {
		GildedRose.items = items;
	}

	public static void expire() {

	}

	public class Category {
		// TODO
		public void updateItem(Item i) {
			updateSellin(i);
			decQuality(i);
			if (i.sellIn < 0) {
				decQuality(i);
			}

		}
	}

	private class Cheese extends Category {
		// TODO

		@Override
		public void updateItem(Item i) {
			// TODO Auto-generated method stub
			incQuality(i);
		}

	}

	private class Legendary extends Category {
		// TODO
		@Override
		public void updateItem(Item i) {
			// deos nothun
		}

	}

	private class BackstagePass extends Category {
		// TODO
		@Override

		public void updateItem(Item i) {
			if (i.getSellIn() < 11) {
				incQuality(i);
			}
			if (i.getSellIn() < 6) {
				incQuality(i);
			} else {
				decQuality(i);
			}

		}
	}

	private class Conjured extends Category {

		@Override
		public void updateItem(Item i) {
			if (i.getName().equals("Conjured Mana Cake")) {
				decQuality(i);
				decQuality(i);
			}
		}

	}
}
package org.example;

/***************************
 Gilded Rose Refactoring Kata

 We also buy and sell only the finest goods. Unfortunately, our goods are constantly degrading in quality as they approach their sell by date. We have a system in place that updates our inventory for us.

 All items have a SellIn value which denotes the number of days we have to sell the item
 All items have a Quality value which denotes how valuable the item is
 At the end of each day our system lowers both values for every item

 Once the sell by date has passed, Quality degrades twice as fast
 The Quality of an item is never negative
 "Aged Brie" actually increases in Quality the older it gets
 The Quality of an item is never more than 50
 "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
 "Backstage passes", like aged brie, increases in Quality as it's SellIn value approaches; Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but Quality drops to 0 after the concert
 An item can never have its Quality increase above 50, however "Sulfuras" is a legendary item and as such its Quality is 80 and it never alters.

 We have recently signed a supplier of conjured items. This requires an update to our system:
 "Conjured" items degrade in Quality twice as fast as normal items

 *************************/


import java.util.ArrayList;
import java.util.List;

public class Program {
    private static List<Item> items;

    public static void main(String[] args) {
        System.out.println("OMGHAI!");

        Program app = new Program();
        items = new ArrayList<Item>();
        app.items.add(new Item("+5 Dexterity Vest", 10, 20));
        app.items.add(new Item("Aged Brie", 2, 0));
        app.items.add(new Item("Elixir of the Mongoose", 5, 7));
        app.items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        app.items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        app.items.add(new Item("Conjured Mana Cake", 3, 6));

        app.updateQuality();
    }

    public void updateQuality() {
        for (int i = 0; i < items.size(); i++) {
            if (!items.get(i).name.equals("Aged Brie")
                && !items.get(i).name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items.get(i).quality > 0) {
                    if (!items.get(i).name.equals("Sulfuras, Hand of Ragnaros")) {
                        items.get(i).quality = items.get(i).quality - 1;
                    }
                }
            } else {
                if (items.get(i).quality < 50) {
                    items.get(i).quality = items.get(i).quality + 1;

                    if (items.get(i).name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items.get(i).sellIn < 11) {
                            if (items.get(i).quality < 50) {
                                items.get(i).quality = items.get(i).quality + 1;
                            }
                        }

                        if (items.get(i).sellIn < 6) {
                            if (items.get(i).quality < 50) {
                                items.get(i).quality = items.get(i).quality + 1;
                            }
                        }
                    }
                }
            }

            if (!items.get(i).name.equals("Sulfuras, Hand of Ragnaros")) {
                items.get(i).sellIn = items.get(i).sellIn - 1;
            }

            if (items.get(i).sellIn < 0) {
                if (!items.get(i).name.equals("Aged Brie")) {
                    if (!items.get(i).name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items.get(i).quality > 0) {
                            if (!items.get(i).name.equals("Sulfuras, Hand of Ragnaros")) {
                                items.get(i).quality = items.get(i).quality - 1;
                            }
                        }
                    } else {
                        items.get(i).quality = 0;
                    }
                } else {
                    if (items.get(i).quality < 50) {
                        items.get(i).quality = items.get(i).quality + 1;
                    }
                }
            }
        }
    }

    public static class Item {
    private String name;
    private int sellIn;
    private int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSellIn() {
        return sellIn;
    }

    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }
}


}



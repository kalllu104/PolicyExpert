package kata.supermarket.basket;

import kata.supermarket.item.Item;
import kata.supermarket.item.Items;
import kata.supermarket.item.ItemsList;

public class Basket {
    private final Items items;

    public Basket() {
        this.items = new ItemsList();
    }

    public void add(final Item item) {
        items.add(item);
    }

    public Items items() {
        return items;
    }
}

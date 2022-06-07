package kata.supermarket.item;

import java.util.ArrayList;
import java.util.List;

public class ItemsList implements Items{
    private final List<Item> items;

    public ItemsList() {
        this.items = new ArrayList<>();
    }

    @Override
    public List<Item> getItems() {
        return items;
    }

    @Override
    public void add(Item item) {
        items.add(item);
    }
}

package kata.supermarket.item;

import java.util.Collection;

public interface Items {
    Collection<Item> getItems();

    void add(Item item);
}

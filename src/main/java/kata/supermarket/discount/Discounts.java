package kata.supermarket.discount;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Discounts {
    private final List<Discount> discounts;

    public Discounts() {
        this.discounts = new ArrayList<>();
    }

    public void add(Discount discount) {
        discounts.add(discount);
    }

    public Collection<Discount> discounts() {
        return Collections.unmodifiableCollection(discounts);
    }
}

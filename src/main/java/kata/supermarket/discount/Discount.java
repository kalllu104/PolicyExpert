package kata.supermarket.discount;

import kata.supermarket.item.Items;

import java.math.BigDecimal;

public interface Discount {
    BigDecimal apply(Items items);
}

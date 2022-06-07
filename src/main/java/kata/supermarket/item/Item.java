package kata.supermarket.item;

import java.math.BigDecimal;

public interface Item {
    long productId();

    BigDecimal price();
}

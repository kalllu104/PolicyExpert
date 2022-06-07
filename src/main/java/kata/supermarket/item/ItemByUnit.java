package kata.supermarket.item;

import kata.supermarket.product.Product;

import java.math.BigDecimal;

public class ItemByUnit implements Item {

    private final Product product;

    public ItemByUnit(final Product product) {
        this.product = product;
    }

    @Override
    public long productId() {
        return product.id();
    }

    public BigDecimal price() {
        return product.price();
    }
}

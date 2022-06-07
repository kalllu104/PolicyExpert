package kata.supermarket.item;

import kata.supermarket.product.Product;
import kata.supermarket.product.WeighedProduct;

import java.math.BigDecimal;

public class ItemByWeight implements Item {

    private final Product product;
    private final BigDecimal weightInKilos;

    public ItemByWeight(final WeighedProduct product, final BigDecimal weightInKilos) {
        this.product = product;
        this.weightInKilos = weightInKilos;
    }

    @Override
    public long productId() {
        return product.id();
    }

    @Override
    public BigDecimal price() {
        return product.price().multiply(weightInKilos).setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}

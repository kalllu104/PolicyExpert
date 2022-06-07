package kata.supermarket.product;

import java.math.BigDecimal;

public class WeighedProduct implements Product {
    private final long id;
    private final BigDecimal pricePerKilo;

    public WeighedProduct(long id, final BigDecimal pricePerKilo) {
        this.id = id;
        this.pricePerKilo = pricePerKilo;
    }

    @Override
    public BigDecimal price() {
        return pricePerKilo;
    }

    @Override
    public long id() {
        return id;
    }
}

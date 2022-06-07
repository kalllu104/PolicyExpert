package kata.supermarket.product;

import java.math.BigDecimal;

public class UnitProduct implements Product {
    private final long id;
    private final BigDecimal pricePerUnit;

    public UnitProduct(long id, BigDecimal pricePerUnit) {
        this.id = id;
        this.pricePerUnit = pricePerUnit;
    }

    @Override
    public BigDecimal price() {
        return pricePerUnit;
    }

    @Override
    public long id() {
        return id;
    }
}

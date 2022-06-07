package kata.supermarket.discount;

import kata.supermarket.item.Item;
import kata.supermarket.item.Items;
import kata.supermarket.product.Product;

import java.math.BigDecimal;
import java.util.Collection;

public class TwoForOneDiscount implements Discount {
    private final long discountedProductId;
    private final BigDecimal price;

    public TwoForOneDiscount(Product product) {
        this.discountedProductId = product.id();
        this.price = product.price();
    }

    @Override
    public BigDecimal apply(Items items) {
        long discountedProductsCount = findDiscountedProductCount(items.getItems());
        if (discountedProductsCount % 2 == 0) {
            return discountForEvenProductCount(discountedProductsCount);
        } else {
            return discountForOddProductCount(discountedProductsCount);
        }
    }

    private BigDecimal discountForEvenProductCount(long discountedProductsCount) {
        return calculateDiscount(discountedProductsCount);
    }

    private BigDecimal discountForOddProductCount(long discountedProductsCount) {
        return calculateDiscount(discountedProductsCount - 1);
    }

    private BigDecimal calculateDiscount(long productCount) {
        return new BigDecimal(productCount / 2).multiply(price);
    }

    private long findDiscountedProductCount(Collection<Item> items) {
        return items.stream().filter(item -> item.productId() == discountedProductId).count();
    }
}

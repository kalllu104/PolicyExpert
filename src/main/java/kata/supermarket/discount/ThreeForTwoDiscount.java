package kata.supermarket.discount;

import kata.supermarket.item.Item;
import kata.supermarket.item.Items;
import kata.supermarket.product.Product;

import java.math.BigDecimal;
import java.util.Collection;

public class ThreeForTwoDiscount implements Discount {

    private final long discountedProductId;
    private final BigDecimal price;

    public ThreeForTwoDiscount(Product product) {
        this.discountedProductId = product.id();
        this.price = product.price();
    }

    @Override
    public BigDecimal apply(Items items) {
        long discountedProductsCount = findDiscountedProductCount(items.getItems());
        long groupsOfThree = discountedProductsCount / 3;
        return price.multiply(new BigDecimal(groupsOfThree));
    }

    private long findDiscountedProductCount(Collection<Item> items) {
        return items.stream().filter(item -> item.productId() == discountedProductId).count();
    }
}

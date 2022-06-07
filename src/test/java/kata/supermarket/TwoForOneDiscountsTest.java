package kata.supermarket;

import kata.supermarket.basket.Basket;
import kata.supermarket.calculator.TotalPriceCalculator;
import kata.supermarket.discount.Discount;
import kata.supermarket.discount.Discounts;
import kata.supermarket.discount.TwoForOneDiscount;
import kata.supermarket.item.ItemByUnit;
import kata.supermarket.product.Product;
import kata.supermarket.product.UnitProduct;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TwoForOneDiscountsTest {

    @Test
    void withFourDiscountedProducts() {
        Product product = new UnitProduct(1, BigDecimal.TEN);
        TotalPriceCalculator calculator = new TotalPriceCalculator(createBasicBasket(product), createBasicDiscounts(product));
        assertEquals(new BigDecimal(20).setScale(2, RoundingMode.HALF_UP), calculator.calculate());
    }

    @Test
    void withZeroDiscountedProducts() {
        Product product = new UnitProduct(1, BigDecimal.TEN);
        TotalPriceCalculator calculator = new TotalPriceCalculator(createBasicBasket(product), createBasicDiscounts(new UnitProduct(2, BigDecimal.TEN)));
        assertEquals(new BigDecimal(40).setScale(2, RoundingMode.HALF_UP), calculator.calculate());
    }

    @Test
    void withFiveDiscountedProducts() {
        Product product = new UnitProduct(1, BigDecimal.TEN);
        Basket basket = createBasicBasket(product);
        basket.add(new ItemByUnit(product));
        TotalPriceCalculator calculator = new TotalPriceCalculator(basket, createBasicDiscounts(product));
        assertEquals(new BigDecimal(30).setScale(2, RoundingMode.HALF_UP), calculator.calculate());
    }

    private Discounts createBasicDiscounts(Product product) {
        Discount discount = new TwoForOneDiscount(product);
        Discounts discounts = new Discounts();
        discounts.add(discount);
        return discounts;
    }

    private Basket createBasicBasket(Product product) {
        Basket basket = new Basket();
        basket.add(new ItemByUnit(product));
        basket.add(new ItemByUnit(product));
        basket.add(new ItemByUnit(product));
        basket.add(new ItemByUnit(product));
        return basket;
    }
}

package kata.supermarket;

import kata.supermarket.basket.Basket;
import kata.supermarket.calculator.TotalPriceCalculator;
import kata.supermarket.discount.Discount;
import kata.supermarket.discount.Discounts;
import kata.supermarket.discount.ThreeForTwoDiscount;
import kata.supermarket.item.ItemByUnit;
import kata.supermarket.product.Product;
import kata.supermarket.product.UnitProduct;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ThreeForTwoDiscountTest {

    @Test
    void withThreeProducts() {
        Product product = new UnitProduct(1, BigDecimal.TEN);
        TotalPriceCalculator calculator = new TotalPriceCalculator(createBasicBasket(3, product), createBasicDiscounts(product));
        assertEquals(new BigDecimal(20).setScale(2, RoundingMode.HALF_UP), calculator.calculate());
    }

    @Test
    void withSixProducts() {
        Product product = new UnitProduct(1, BigDecimal.TEN);
        TotalPriceCalculator calculator = new TotalPriceCalculator(createBasicBasket(6, product), createBasicDiscounts(product));
        assertEquals(new BigDecimal(40).setScale(2, RoundingMode.HALF_UP), calculator.calculate());
    }

    @Test
    void withSevenProducts() {
        Product product = new UnitProduct(1, BigDecimal.TEN);
        TotalPriceCalculator calculator = new TotalPriceCalculator(createBasicBasket(7, product), createBasicDiscounts(product));
        assertEquals(new BigDecimal(50).setScale(2, RoundingMode.HALF_UP), calculator.calculate());
    }

    @Test
    void withZeroProducts() {
        Product product = new UnitProduct(1, BigDecimal.TEN);
        TotalPriceCalculator calculator = new TotalPriceCalculator(createBasicBasket(0, product), createBasicDiscounts(product));
        assertEquals(new BigDecimal(0).setScale(2, RoundingMode.HALF_UP), calculator.calculate());
    }

    @Test
    void withUndiscountedProduct() {
        Product product = new UnitProduct(1, BigDecimal.TEN);
        Basket basket = createBasicBasket(3, product);
        basket.add(new ItemByUnit(new UnitProduct(2, BigDecimal.ONE)));
        TotalPriceCalculator calculator = new TotalPriceCalculator(basket, createBasicDiscounts(product));
        assertEquals(new BigDecimal(21).setScale(2, RoundingMode.HALF_UP), calculator.calculate());
    }

    @Test
    void withUndiscountedGroup() {
        Product product = new UnitProduct(1, BigDecimal.TEN);
        Basket basket = createBasicBasket(3, product);
        basket.add(new ItemByUnit(new UnitProduct(2, BigDecimal.ONE)));
        basket.add(new ItemByUnit(new UnitProduct(2, BigDecimal.ONE)));
        basket.add(new ItemByUnit(new UnitProduct(2, BigDecimal.ONE)));
        TotalPriceCalculator calculator = new TotalPriceCalculator(basket, createBasicDiscounts(product));
        assertEquals(new BigDecimal(23).setScale(2, RoundingMode.HALF_UP), calculator.calculate());
    }

    @Test
    void withOnlyUndiscountedGroup() {
        Product product = new UnitProduct(1, BigDecimal.TEN);
        Product undiscountedProduct = new UnitProduct(2, BigDecimal.TEN);
        Basket basket = createBasicBasket(3, undiscountedProduct);
        TotalPriceCalculator calculator = new TotalPriceCalculator(basket, createBasicDiscounts(product));
        assertEquals(new BigDecimal(30).setScale(2, RoundingMode.HALF_UP), calculator.calculate());
    }

    @Test
    void withUnroundedPrice() {
        Product product = new UnitProduct(1, new BigDecimal(3.1456));
        TotalPriceCalculator calculator = new TotalPriceCalculator(createBasicBasket(3, product), createBasicDiscounts(product));
        assertEquals(new BigDecimal(6.29).setScale(2, RoundingMode.HALF_UP), calculator.calculate());
    }

    private Basket createBasicBasket(int count, Product product) {
        Basket basket = new Basket();
        for (int i = 0; i < count; i++) {
            basket.add(new ItemByUnit(product));
        }
        return basket;
    }

    private Discounts createBasicDiscounts(Product product) {
        Discount discount = new ThreeForTwoDiscount(product);
        Discounts discounts = new Discounts();
        discounts.add(discount);
        return discounts;
    }

}

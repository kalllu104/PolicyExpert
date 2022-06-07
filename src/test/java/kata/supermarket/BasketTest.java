package kata.supermarket;

import kata.supermarket.basket.Basket;
import kata.supermarket.item.*;
import kata.supermarket.product.UnitProduct;
import kata.supermarket.product.WeighedProduct;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BasketTest {

    @Test
    void baskedContainsAddedItems() {
        Basket basket = new Basket();
        basket.add(new ItemByUnit(new UnitProduct(1, BigDecimal.TEN)));
        basket.add(new ItemByWeight(new WeighedProduct(2, BigDecimal.TEN), BigDecimal.TEN));

        assertEquals(basket.items().getItems().size(), 2);
    }

}
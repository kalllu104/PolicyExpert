package kata.supermarket.calculator;

import kata.supermarket.basket.Basket;
import kata.supermarket.discount.Discounts;
import kata.supermarket.item.Item;
import kata.supermarket.item.Items;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TotalPriceCalculator implements Calculator {
    private final Calculator discountsCalculator;
    private final Items items;

    public TotalPriceCalculator(Basket basket, Discounts discounts) {
        this.items = basket.items();
        this.discountsCalculator = new DiscountsCalculator(basket, discounts);
    }

    @Override
    public BigDecimal calculate() {
        return subtotal().subtract(discountsCalculator.calculate());
    }

    private BigDecimal subtotal() {
        return items.getItems().stream().map(Item::price)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO)
                .setScale(2, RoundingMode.HALF_UP);
    }
}

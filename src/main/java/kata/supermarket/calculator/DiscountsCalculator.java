package kata.supermarket.calculator;

import kata.supermarket.basket.Basket;
import kata.supermarket.discount.Discounts;
import kata.supermarket.item.Items;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DiscountsCalculator implements Calculator {
    private final Items items;
    private final Discounts discounts;

    DiscountsCalculator(Basket basket, Discounts discounts) {
        this.discounts = discounts;
        this.items = basket.items();
    }

    @Override
    public BigDecimal calculate() {
        return discounts.discounts().stream().map(discount -> discount.apply(items))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO)
                .setScale(2, RoundingMode.HALF_UP);
    }

}

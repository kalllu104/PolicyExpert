package kata.supermarket;

import kata.supermarket.item.ItemByWeight;
import kata.supermarket.product.WeighedProduct;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WeighedProductTest {

    @ParameterizedTest
    @MethodSource
    void itemFromWeighedProductHasExpectedUnitPrice(long id, String pricePerKilo, String weightInKilos, String expectedPrice) {
        final WeighedProduct weighedProduct = new WeighedProduct(id, new BigDecimal(pricePerKilo));
        assertEquals(new BigDecimal(expectedPrice), new ItemByWeight(weighedProduct, new BigDecimal(weightInKilos)).price());
    }

    static Stream<Arguments> itemFromWeighedProductHasExpectedUnitPrice() {
        return Stream.of(
                Arguments.of(1, "100.00", "1.00", "100.00"),
                Arguments.of(2, "100.00", "0.33333", "33.33"),
                Arguments.of(3, "100.00", "0.33335", "33.34"),
                Arguments.of(4, "100.00", "0", "0.00")
        );
    }

}
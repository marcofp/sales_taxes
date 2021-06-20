package org.marcofp.sales.usecase;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.marcofp.sales.domain.entity.Good;
import org.marcofp.sales.domain.entity.ItemBasket;
import org.marcofp.sales.domain.entity.ShoppingBasket;
import org.marcofp.sales.domain.usecase.CalculateShoppingBasketUseCase;

/**
 * The type Calculate shopping basket use case implementation.
 *
 * @author <a href="mailto:marcofp@gmail.com">Marco Fuentelsaz</a>
 * @since 1.0.0
 */
public class CalculateShoppingBasketUseCaseImpl implements CalculateShoppingBasketUseCase {

    public static final BigDecimal INCREMENT = new BigDecimal("0.05");
    private static final BigDecimal BASE_TAX = new BigDecimal("0.10");
    private static final BigDecimal IMPORT_TAX = new BigDecimal("0.05");

    /**
     * Rounds a value to the nearest 0.05.
     *
     * @param value value to round
     * @return rounded value
     */
    public static BigDecimal round(BigDecimal value) {
        BigDecimal divided = value.divide(INCREMENT, 0, RoundingMode.UP);
        return divided.multiply(INCREMENT);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ShoppingBasket calculateShoppingBasket(final List<ItemBasket> items) {

        final BigDecimal[] totalTaxes = {BigDecimal.ZERO};
        final BigDecimal[] totalPrice = {BigDecimal.ZERO};

        items.forEach(itemBasket -> {
            final Good good = itemBasket.getGood();
            BigDecimal baseTax = (good.getType().isTaxFree() ? BigDecimal.ZERO : BASE_TAX).add(good.isImported()
                ? IMPORT_TAX : BigDecimal.ZERO);
            if (baseTax.compareTo(BigDecimal.ZERO) > 0) {
                final BigDecimal price = itemBasket.getGood().getPrice();
                final BigDecimal taxes = round(price.multiply(baseTax));
                final BigDecimal finalCost = good.getPrice().add(taxes);
                itemBasket.setFinalPrice(finalCost);
                totalPrice[0] = totalPrice[0].add(finalCost);
                totalTaxes[0] = totalTaxes[0].add(taxes);
            } else {
                itemBasket.setFinalPrice(itemBasket.getGood().getPrice());
                totalPrice[0] = totalPrice[0].add(itemBasket.getGood().getPrice());
            }
        });

        ShoppingBasket shoppingBasket = new ShoppingBasket();
        shoppingBasket.setItems(items);
        shoppingBasket.setTotalPrice(totalPrice[0]);
        shoppingBasket.setTotalSalesTaxes(totalTaxes[0]);
        return shoppingBasket;
    }

}

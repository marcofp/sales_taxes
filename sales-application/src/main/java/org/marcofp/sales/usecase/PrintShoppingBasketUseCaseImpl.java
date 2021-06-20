package org.marcofp.sales.usecase;

import org.marcofp.sales.domain.entity.ShoppingBasket;
import org.marcofp.sales.domain.usecase.PrintShoppingBasketUseCase;

/**
 * The type Calculate shopping basket use case implementation.
 *
 * @author <a href="mailto:marcofp@gmail.com">Marco Fuentelsaz</a>
 * @since 1.0.0
 */
public class PrintShoppingBasketUseCaseImpl implements PrintShoppingBasketUseCase {

    /**
     * {@inheritDoc}
     */
    @Override
    public void printShoppingBasket(ShoppingBasket shoppingBasket) {
        shoppingBasket.getItems().forEach(itemBasket ->
            System.out.println(itemBasket.getQuantity() + " " + itemBasket.getGood().getName() + " at " + itemBasket
                .getFinalPrice()));
        System.out.println("Sales taxes: " + shoppingBasket.getTotalSalesTaxes());
        System.out.println("Total: " + shoppingBasket.getTotalPrice());
    }
}

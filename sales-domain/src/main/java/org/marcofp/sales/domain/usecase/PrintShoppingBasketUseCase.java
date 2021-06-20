package org.marcofp.sales.domain.usecase;

import org.marcofp.sales.domain.entity.ShoppingBasket;

/**
 * The interface Calculate shopping basket use case.
 *
 * @author <a href="mailto:marcofp@gmail.com">Marco Fuentelsaz</a>
 * @since 1.0.0
 */
public interface PrintShoppingBasketUseCase {

    /**
     * Prints the provided shopping basket.
     *
     * @param shoppingBasket the shopping basket
     */
    void printShoppingBasket(ShoppingBasket shoppingBasket);

}

package org.marcofp.sales.domain.usecase;

import java.util.List;

import org.marcofp.sales.domain.entity.ItemBasket;
import org.marcofp.sales.domain.entity.ShoppingBasket;

/**
 * The interface Calculate shopping basket use case.
 *
 * @author <a href="mailto:marcofp@gmail.com">Marco Fuentelsaz</a>
 * @since 1.0.0
 */
public interface CalculateShoppingBasketUseCase {

    /**
     * Calculates the shopping basket.
     *
     * @param items the items
     * @return the shopping basket
     */
    ShoppingBasket calculateShoppingBasket(List<ItemBasket> items);

}

package org.marcofp.sales.service;

import java.util.List;

import org.marcofp.sales.dto.GoodDto;
import org.marcofp.sales.dto.ItemBasketDto;
import org.marcofp.sales.dto.ShoppingBasketDto;

/**
 * The sales interface.
 *
 * @author <a href="mailto:marcofp@gmail.com">Marco Fuentelsaz</a>
 * @since 1.0.0
 */
public interface SalesApi {

    /**
     * Calculates a shopping cart.
     * @param items the items.
     * @return the cart.
     */
    ShoppingBasketDto calculateShoppingBasket(List<ItemBasketDto> items);

    /**
     * Prints a shopping basket.
     * @param shoppingBasket the shopping basket
     */
    void printShoppingBasket(ShoppingBasketDto shoppingBasket);

    /**
     * Finds a good by name.
     * @param name the good name
     * @return the found good
     */
    GoodDto findGoodByName(String name);
}

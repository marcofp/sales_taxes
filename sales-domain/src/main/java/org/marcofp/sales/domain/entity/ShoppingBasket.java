package org.marcofp.sales.domain.entity;

import java.util.Set;

/**
 * The shopping basket.
 *
 * @author <a href="mailto:marcofp@gmail.com">Marco Fuentelsaz</a>
 * @since 1.0.0
 */
public class ShoppingBasket {


    /**
     * Items associated with the basket.
     */
    private Set<ItemBasket> items;

    /**
     * The sales taxes.
     */
    private double totalSalesTaxes;

    /**
     * The total price.
     */
    private double totalPrice;

    public Set<ItemBasket> getItems() {
        return items;
    }

    public void setItems(Set<ItemBasket> items) {
        this.items = items;
    }

    public double getTotalSalesTaxes() {
        return totalSalesTaxes;
    }

    public void setTotalSalesTaxes(double totalSalesTaxes) {
        this.totalSalesTaxes = totalSalesTaxes;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}

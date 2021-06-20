package org.marcofp.sales.domain.entity;

import java.math.BigDecimal;
import java.util.List;

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
    private List<ItemBasket> items;

    /**
     * The sales taxes.
     */
    private BigDecimal totalSalesTaxes;

    /**
     * The total price.
     */
    private BigDecimal totalPrice;

    public List<ItemBasket> getItems() {
        return items;
    }

    public void setItems(List<ItemBasket> items) {
        this.items = items;
    }

    public BigDecimal getTotalSalesTaxes() {
        return totalSalesTaxes;
    }

    public void setTotalSalesTaxes(BigDecimal totalSalesTaxes) {
        this.totalSalesTaxes = totalSalesTaxes;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}

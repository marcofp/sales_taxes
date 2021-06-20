package org.marcofp.sales.dto;

import java.util.List;

/**
 * The shopping basket DTO.
 *
 * @author <a href="mailto:marcofp@gmail.com">Marco Fuentelsaz</a>
 * @since 1.0.0
 */
public class ShoppingBasketDto {

    private static final String DEFAULT_TOTAL_PRICE = "0.0";

    /**
     * Items associated with the basket.
     */
    private List<ItemBasketDto> items;

    /**
     * The sales taxes.
     */
    private String totalSalesTaxes;

    /**
     * The total price.
     */
    private String totalPrice = DEFAULT_TOTAL_PRICE;

    public List<ItemBasketDto> getItems() {
        return items;
    }

    public void setItems(List<ItemBasketDto> items) {
        this.items = items;
    }

    public String getTotalSalesTaxes() {
        return totalSalesTaxes;
    }

    public void setTotalSalesTaxes(String totalSalesTaxes) {
        this.totalSalesTaxes = totalSalesTaxes;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }
}

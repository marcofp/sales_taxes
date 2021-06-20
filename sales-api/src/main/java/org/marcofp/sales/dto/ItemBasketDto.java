package org.marcofp.sales.dto;

/**
 * Represents a item of the basket DTO.
 *
 * @author <a href="mailto:marcofp@gmail.com">Marco Fuentelsaz</a>
 * @since 1.0.0
 */
public class ItemBasketDto {

    private static final String DEFAULT_FINAL_PRICE = "0.0";

    /**
     * The good.
     */
    private final GoodDto good;

    /**
     * The number of items.
     */
    private final int quantity;

    /**
     * The final price.
     */
    private String finalPrice = DEFAULT_FINAL_PRICE;


    /**
     * Constructor.
     *
     * @param good the good.
     * @param quantity the quantity.
     */
    public ItemBasketDto(final GoodDto good, final int quantity) {
        this.good = good;
        this.quantity = quantity;
    }

    /**
     * Gets the associated good.
     *
     * @return the good.
     */
    public GoodDto getGood() {
        return good;
    }

    /**
     * Gets the final price.
     *
     * @return the final price
     */
    public String getFinalPrice() {
        return finalPrice;
    }

    /**
     * Sets the final price.
     *
     * @param finalPrice the final price
     */
    public void setFinalPrice(String finalPrice) {
        this.finalPrice = finalPrice;
    }

    /**
     * Gets the quantity of items.
     *
     * @return the item quantity
     */
    public int getQuantity() {
        return quantity;
    }
}

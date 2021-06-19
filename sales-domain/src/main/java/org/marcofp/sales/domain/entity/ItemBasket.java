package org.marcofp.sales.domain.entity;

/**
 * Represents a item of the basket.
 *
 * @author <a href="mailto:marcofp@gmail.com">Marco Fuentelsaz</a>
 * @since 1.0.0
 */
public class ItemBasket {

    /**
     * The good.
     */
    private final Good good;

    /**
     * The number of items.
     */
    private final int quantity;

    /**
     * The final price.
     */
    private double finalPrice;

    /**
     * The applied taxes.
     */
    private double taxes;

    /**
     * Constructor.
     * @param good the good.
     * @param quantity the quantity.
     */
    public ItemBasket(final Good good, final int quantity) {
        this.good = good;
        this.quantity = quantity;
    }


    /**
     * Gets the associated good.
     * @return the good.
     */
    public Good getGood() {
        return good;
    }

    /**
     * Gets the final price.
     * @return the final price
     */
    public double getFinalPrice() {
        return finalPrice;
    }

    /**
     * Sets the final price.
     * @param finalPrice the final price
     */
    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    /**
     * Gets the applied taxes.
     * @return the taxes applied
     */
    public double getTaxes() {
        return taxes;
    }

    /**
     * Sets the taxes.
     * @param taxes the taxes
     */
    public void setTaxes(double taxes) {
        this.taxes = taxes;
    }

    /**
     * Gets the quantity of items.
     * @return the item quantity
     */
    public int getQuantity() {
        return quantity;
    }

}

package org.marcofp.sales.dto;

import java.math.BigDecimal;

/**
 * The type good DTO.
 *
 * @author <a href="mailto:marcofp@gmail.com">Marco Fuentelsaz</a>
 * @since 1.0.0
 */
public class GoodDto {

    /**
     * The good name.
     */
    private String name;

    /**
     * The good price.
     */
    private String price;

    /**
     * The good type.
     */
    private String type;

    /**
     * Indicates if the good is imported.
     */
    private boolean imported;

    /**
     * Provides the good name.
     *
     * @return the good name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the good name.
     *
     * @param name the good name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Provides the good price.
     *
     * @return the good price
     */
    public String getPrice() {
        return price;
    }

    /**
     * Sets the good price.
     *
     * @param price the good price
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * Provides the good type.
     *
     * @return the good type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of good.
     *
     * @param type the type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Indicates whether the good is imported.
     *
     * @return is imported
     */
    public boolean isImported() {
        return imported;
    }

    /**
     * Sets if the good is imported.
     *
     * @param imported good is imported
     */
    public void setImported(boolean imported) {
        this.imported = imported;
    }
}

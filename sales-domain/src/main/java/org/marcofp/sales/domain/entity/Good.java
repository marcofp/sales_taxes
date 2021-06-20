package org.marcofp.sales.domain.entity;

import java.math.BigDecimal;

/**
 * The type good.
 *
 * @author <a href="mailto:marcofp@gmail.com">Marco Fuentelsaz</a>
 * @since 1.0.0
 */
public class Good {

    /**
     * The good name.
     */
    private String name;

    /**
     * The good price.
     */
    private BigDecimal price;

    /**
     * The good type.
     */
    private GoodType type;

    /**
     * Indicates if the good is imported.
     */
    private boolean imported;

    /**
     * Provides the good name.
     * @return the good name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the good name.
     * @param name the good name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Provides the good price.
     * @return the good price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Sets the good price.
     * @param price the good price
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * Provides the good type.
     * @return the good type
     */
    public GoodType getType() {
        return type;
    }

    /**
     * Sets the type of good.
     * @param type the type
     */
    public void setType(GoodType type) {
        this.type = type;
    }

    /**
     * Indicates whether the good is imported.
     * @return is imported
     */
    public boolean isImported() {
        return imported;
    }

    /**
     * Sets if the good is imported.
     * @param imported good is imported
     */
    public void setImported(boolean imported) {
        this.imported = imported;
    }
}

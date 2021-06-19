package org.marcofp.sales.domain.entity;

/**
 * The type of good.
 *
 * @author <a href="mailto:marcofp@gmail.com">Marco Fuentelsaz</a>
 * @since 1.0.0
 */
public enum GoodType {

    BOOKS("Books", true),
    FOOD("Foods", true),
    MEDICAL("Medical", true),
    OTHERS("Others", false);

    /**
     * The type of good.
     */
    private final String name;

    /**
     * Indicates if the good is tax-free.
     */
    private final boolean taxFree;


    /**
     * Constructor.
     *
     * @param name the good name
     * @param isTaxFree indicates if the good is tax-free
     */
    GoodType(final String name, final boolean isTaxFree) {
        this.name = name;
        this.taxFree = isTaxFree;
    }

    /**
     * Gets the good name.
     *
     * @return the good name
     */
    public String getName() {
        return name;
    }

    /**
     * Indicates if the good is tax-free.
     * @return isTaxFree
     */
    public boolean isTaxFree() {
        return taxFree;
    }
}

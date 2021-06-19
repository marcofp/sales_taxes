package org.marcofp.sales.domain.usecase;


import org.marcofp.sales.domain.entity.Good;
import org.marcofp.sales.domain.entity.GoodType;

/**
 * The interface create good use case.
 *
 * @author <a href="mailto:marcofp@gmail.com">Marco Fuentelsaz</a>
 * @since 1.0.0
 */
public interface CreateGoodUseCase {

    /**
     * Creates a good.
     *
     * @param name the good name
     * @param price the price
     * @param type the type
     * @param imported if the good is imported
     * @return the new good
     */
    Good createGood(final String name, final Double price, final GoodType type, final Boolean imported);

}

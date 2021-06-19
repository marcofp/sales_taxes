package org.marcofp.sales.domain.usecase;

/**
 * The interface Count good use case.
 *
 * @author <a href="mailto:marcofp@gmail.com">Marco Fuentelsaz</a>
 * @since 1.0.0
 */
public interface CountGoodUseCase {

    /**
     * Count the registered goods.
     *
     * @return the total number of goods
     */
    Long countGoods();

}

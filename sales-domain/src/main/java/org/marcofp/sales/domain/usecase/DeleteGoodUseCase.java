package org.marcofp.sales.domain.usecase;


/**
 * The interface delete good use case.
 *
 * @author <a href="mailto:marcofp@gmail.com">Marco Fuentelsaz</a>
 * @since 1.0.0
 */
public interface DeleteGoodUseCase {

    /**
     * Deletes a good.
     *
     * @param id the good id
     * @return true if the good was deleted successfully
     */
    boolean deleteGood(String id);

}

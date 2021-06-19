package org.marcofp.sales.domain.usecase;

import org.marcofp.sales.domain.entity.Good;

/**
 * The interface Modify good use case.
 *
 * @author <a href="mailto:marcofp@gmail.com">Marco Fuentelsaz</a>
 * @since 1.0.0
 */
public interface ModifyGoodUseCase {

    /**
     * Modify good.
     * @param good the good
     * @return true if the good was modified successfully
     */
    boolean modifyGood(Good good);

}

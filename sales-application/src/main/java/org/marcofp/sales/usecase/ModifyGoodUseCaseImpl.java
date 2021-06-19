package org.marcofp.sales.usecase;

import org.marcofp.sales.domain.entity.Good;
import org.marcofp.sales.domain.repository.GoodRepository;
import org.marcofp.sales.domain.usecase.ModifyGoodUseCase;

/**
 * The type modify good use case.
 *
 * @author <a href="mailto:marcofp@gmail.com">Marco Fuentelsaz</a>
 * @since 1.0.0
 */
public class ModifyGoodUseCaseImpl implements ModifyGoodUseCase {


    /**
     * The good repository.
     */

    private final GoodRepository repository;

    /**
     * Instantiates a new Modify good by id use case.
     *
     * @param goodRepository the product repository
     */
    public ModifyGoodUseCaseImpl(final GoodRepository goodRepository) {
        this.repository = goodRepository;
    }

    /**
     * {@inheritDoc}
     */
    public boolean modifyGood(final Good good) {
        return this.repository.modifyGood(good);
    }

}

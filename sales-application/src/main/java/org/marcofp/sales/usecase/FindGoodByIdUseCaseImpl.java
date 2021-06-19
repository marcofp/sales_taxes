package org.marcofp.sales.usecase;


import org.marcofp.sales.domain.entity.Good;
import org.marcofp.sales.domain.repository.GoodRepository;
import org.marcofp.sales.domain.usecase.FindGoodByIdUseCase;

/**
 * The type Find good by id use case.
 *
 * @author <a href="mailto:marcofp@gmail.com">Marco Fuentelsaz</a>
 * @since 1.0.0
 */
public class FindGoodByIdUseCaseImpl implements FindGoodByIdUseCase {

    /**
     * The good repository.
     */

    private final GoodRepository repository;

    /**
     * Instantiates a new Find good by id use case.
     *
     * @param goodRepository the product repository
     */
    public FindGoodByIdUseCaseImpl(final GoodRepository goodRepository) {
        this.repository = goodRepository;
    }

    @Override
    public Good findGoodBydId(final String id) {
        return this.repository.findGood(id);
    }

}

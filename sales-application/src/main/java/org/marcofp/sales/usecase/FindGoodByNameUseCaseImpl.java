package org.marcofp.sales.usecase;


import org.marcofp.sales.domain.entity.Good;
import org.marcofp.sales.domain.repository.GoodRepository;
import org.marcofp.sales.domain.usecase.FindGoodByNameUseCase;

/**
 * The type Find good by id use case.
 *
 * @author <a href="mailto:marcofp@gmail.com">Marco Fuentelsaz</a>
 * @since 1.0.0
 */
public class FindGoodByNameUseCaseImpl implements FindGoodByNameUseCase {

    /**
     * The good repository.
     */

    private final GoodRepository repository;

    /**
     * Instantiates a new Find good by id use case.
     *
     * @param goodRepository the product repository
     */
    public FindGoodByNameUseCaseImpl(final GoodRepository goodRepository) {
        this.repository = goodRepository;
    }

    @Override
    public Good findGoodByName(final String name) {
        return this.repository.findGood(name);
    }

}

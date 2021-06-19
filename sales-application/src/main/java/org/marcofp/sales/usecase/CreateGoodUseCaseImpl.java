package org.marcofp.sales.usecase;

import org.marcofp.sales.domain.entity.Good;
import org.marcofp.sales.domain.entity.GoodType;
import org.marcofp.sales.domain.repository.GoodRepository;
import org.marcofp.sales.domain.usecase.CreateGoodUseCase;

/**
 * The type Create good use case implementation.
 *
 * @author <a href="mailto:marcofp@gmail.com">Marco Fuentelsaz</a>
 * @since 1.0.0
 */
public class CreateGoodUseCaseImpl implements CreateGoodUseCase {


    /**
     * The good repository.
     */
    private final GoodRepository repository;

    /**
     * The constructor.
     *
     * @param repository the good repository
     */
    public CreateGoodUseCaseImpl(final GoodRepository repository) {
        this.repository = repository;
    }

    /**
     * {@inheritDoc}
     */

    public Good createGood(final String name, final Double price, final GoodType type, final Boolean imported) {
        return repository.createGood(name, price, type, imported);
    }

}

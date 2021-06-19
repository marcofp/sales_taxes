package org.marcofp.sales.usecase;

import org.marcofp.sales.domain.repository.GoodRepository;
import org.marcofp.sales.domain.usecase.CountGoodUseCase;

/**
 * The type Count good use case implementation.
 *
 * @author <a href="mailto:marcofp@gmail.com">Marco Fuentelsaz</a>
 * @since 1.0.0
 */
public class CountGoodUseCaseImpl implements CountGoodUseCase {

    /**
     * The good repository.
     */
    private final GoodRepository repository;

    /**
     * The constructor.
     *
     * @param repository the good repository
     */
    public CountGoodUseCaseImpl(final GoodRepository repository) {
        this.repository = repository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long countGoods() {
        return this.repository.count();
    }
}

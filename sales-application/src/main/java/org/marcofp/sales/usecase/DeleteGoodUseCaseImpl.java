package org.marcofp.sales.usecase;


import org.marcofp.sales.domain.repository.GoodRepository;
import org.marcofp.sales.domain.usecase.DeleteGoodUseCase;

/**
 * The type Delete good use case implementation.
 *
 * @author <a href="mailto:marcofp@gmail.com">Marco Fuentelsaz</a>
 * @since 1.0.0
 */
public class DeleteGoodUseCaseImpl implements DeleteGoodUseCase {

    /**
     * The good repository.
     */
    private final GoodRepository repository;

    /**
     * The constructor.
     *
     * @param repository the good repository
     */
    public DeleteGoodUseCaseImpl(final GoodRepository repository) {
        this.repository = repository;
    }

    /**
     * {@inheritDoc}
     */
    public boolean deleteGood(final String id) {
        return repository.deleteGood(id);
    }
}

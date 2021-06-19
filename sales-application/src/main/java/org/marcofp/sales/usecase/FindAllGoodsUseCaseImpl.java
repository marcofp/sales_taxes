package org.marcofp.sales.usecase;

import java.util.List;

import org.marcofp.sales.domain.entity.Good;
import org.marcofp.sales.domain.repository.GoodRepository;
import org.marcofp.sales.domain.usecase.FindAllGoodsUseCase;

/**
 * The type Find all goods use case implementation.
 *
 * @author <a href="mailto:marcofp@gmail.com">Marco Fuentelsaz</a>
 * @since 1.0.0
 */
public class FindAllGoodsUseCaseImpl implements FindAllGoodsUseCase {

    /**
     * The good repository.
     */
    private final GoodRepository repository;


    /**
     * Instantiates a new Find all goods by id use case.
     *
     * @param repository the good repository
     */
    public FindAllGoodsUseCaseImpl(final GoodRepository repository) {
        this.repository = repository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Good> findAllGoods() {
        return this.repository.findAllGoods();
    }

}

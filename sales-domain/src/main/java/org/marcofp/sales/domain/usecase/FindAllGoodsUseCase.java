package org.marcofp.sales.domain.usecase;

import java.util.List;

import org.marcofp.sales.domain.entity.Good;

/**
 * The interface Find all goods use case.
 *
 * @author <a href="mailto:marcofp@gmail.com">Marco Fuentelsaz</a>
 * @since 1.0.0
 */
public interface FindAllGoodsUseCase {

    /**
     * Find all goods.
     *
     * @return the good list
     */
    List<Good> findAllGoods();

}

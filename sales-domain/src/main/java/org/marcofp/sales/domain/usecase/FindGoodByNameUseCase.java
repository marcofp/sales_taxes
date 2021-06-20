package org.marcofp.sales.domain.usecase;

import org.marcofp.sales.domain.entity.Good;

/**
 * The interface Find good by id use case.
 *
 * @author <a href="mailto:marcofp@gmail.com">Marco Fuentelsaz</a>
 * @since 1.0.0
 */
public interface FindGoodByNameUseCase {

    /**
     * Find a good by name.
     * @param name the name
     * @return the good
     */
    Good findGoodByName(String name);

}

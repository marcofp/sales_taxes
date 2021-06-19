package org.marcofp.sales.domain.repository;

import java.util.List;

import org.marcofp.sales.domain.entity.Good;
import org.marcofp.sales.domain.entity.GoodType;

/**
 * The repository for goodies.
 *
 * @author <a href="mailto:marcofp@gmail.com">Marco Fuentelsaz</a>
 * @since 1.0.0
 */
public interface GoodRepository {

    /**
     * Finds goods by ids.
     * @param ids the good ids
     * @return a list of good
     */
    List<Good> findGoods(final List<String> ids);

    /**
     * Provides the whole list of good
     * @return the whole list
     */
    List<Good> findAllGoods();

    /**
     * Deletes a good by id.
     * @param id the id
     * @return true if the good was deleted successfully
     */
    boolean deleteGood(final String id);

    /**
     * Creates a new good.
     * @param name the good name
     * @param price the price
     * @param type the type
     * @param imported if the good is imported
     * @return the new good
     */
    Good createGood(final String name, final Double price, final GoodType type, final Boolean imported);

    /**
     * Modifies a good.
     * @param good the good to modify
     * @return true if the good was modified successfully
     */
    boolean modifyGood(final Good good);

    /**
     * Finds a good by id.
     * @param id the good id
     * @return the good
     */
    Good findGood(String id);

    /**
     * Gets the total number of goods.
     * @return the total number of goods
     */
    Long count();

}

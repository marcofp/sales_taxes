package org.marcofp.sales.mapper;

import org.marcofp.sales.domain.entity.ShoppingBasket;
import org.marcofp.sales.dto.ShoppingBasketDto;

/**
 * Mapper for ShoppingBasketDto.
 *
 * @author <a href="mailto:marcofp@gmail.com">Marco Fuentelsaz</a>
 * @since 1.0.0
 */
public interface ShoppingBasketDtoMapper {

    /**
     * Maps a ShoppingBasketDto to a ShoppingBasket
     *
     * @param src the source data
     * @return the target data
     */
    ShoppingBasket asShoppingBasket(ShoppingBasketDto src);

    /**
     * Maps a ShoppingBasket to a ShoppingBasketDto
     *
     * @param src the source data
     * @return the target data
     */
    ShoppingBasketDto asShoppingBasketDto(ShoppingBasket src);

}

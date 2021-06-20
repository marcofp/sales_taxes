package org.marcofp.sales.mapper;

import java.util.List;

import org.marcofp.sales.domain.entity.ItemBasket;
import org.marcofp.sales.dto.ItemBasketDto;

/**
 * Mapper for ItemBasketDto.
 *
 * @author <a href="mailto:marcofp@gmail.com">Marco Fuentelsaz</a>
 * @since 1.0.0
 */
public interface ItemBasketDtoMapper {

    /**
     * Maps an ItemBasketDto to an ItemBasket
     *
     * @param src the source data
     * @return the target data
     */
    ItemBasket asItemBasket(ItemBasketDto src);

    /**
     * Maps an ItemBasket to an ItemBasketDto
     *
     * @param src the source data
     * @return the target data
     */
    ItemBasketDto asItemBasketDto(ItemBasket src);

    /**
     * Maps a List<@ItemBasket> to an List<@ItemBasketDto>
     *
     * @param src List<@ItemBasket> entity source
     * @return List<@ ItemBasketDto> entity
     */
    List<ItemBasketDto> asItemBasketDtos(List<ItemBasket> src);


    /**
     * Maps a List<{@link ItemBasketDto}> to an List<@{@link ItemBasket}>
     *
     * @param src List<{@link ItemBasketDto} entity source
     * @return List<{@link ItemBasket}> entity
     */
    List<ItemBasket> asItemBaskets(List<ItemBasketDto> src);

}

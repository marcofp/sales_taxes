package org.marcofp.sales.mapper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.marcofp.sales.domain.entity.ItemBasket;
import org.marcofp.sales.dto.ItemBasketDto;

/**
 * Implementation of {@link ItemBasketDtoMapper}.
 *
 * @author <a href="mailto:marcofp@gmail.com">Marco Fuentelsaz</a>
 * @since 1.0.0
 */
public class ItemBasketDtoMapperImpl implements ItemBasketDtoMapper {

    /**
     * The goodDto mapper.
     */
    private final GoodDtoMapper goodDtoMapper;

    /**
     * The constructor.
     *
     * @param goodDtoMapper the mapper
     */
    public ItemBasketDtoMapperImpl(final GoodDtoMapper goodDtoMapper) {
        this.goodDtoMapper = goodDtoMapper;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ItemBasket asItemBasket(ItemBasketDto src) {
        if (src == null) {
            return null;
        }

        ItemBasket itemBasket = new ItemBasket(goodDtoMapper.asGood(src.getGood()), src.getQuantity());
        itemBasket.setFinalPrice(new BigDecimal(src.getFinalPrice()));
        return itemBasket;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ItemBasketDto asItemBasketDto(ItemBasket src) {
        if (src == null) {
            return null;
        }

        ItemBasketDto itemBasketDto = new ItemBasketDto(goodDtoMapper.asGoodDto(src.getGood()), src.getQuantity());
        itemBasketDto.setFinalPrice(src.getFinalPrice().toString());
        return itemBasketDto;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ItemBasketDto> asItemBasketDtos(List<ItemBasket> src) {
        if (src == null) {
            return Collections.emptyList();
        }

        List<ItemBasketDto> list = new ArrayList<>(src.size());
        for (ItemBasket itemBasket : src) {
            list.add(asItemBasketDto(itemBasket));
        }

        return list;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ItemBasket> asItemBaskets(List<ItemBasketDto> src) {
        if (src == null) {
            return Collections.emptyList();
        }

        List<ItemBasket> list = new ArrayList<>(src.size());
        for (ItemBasketDto itemBasket : src) {
            list.add(asItemBasket(itemBasket));
        }

        return list;
    }
}

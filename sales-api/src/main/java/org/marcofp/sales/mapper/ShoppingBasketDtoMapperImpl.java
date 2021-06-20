package org.marcofp.sales.mapper;

import java.math.BigDecimal;

import org.marcofp.sales.domain.entity.ShoppingBasket;
import org.marcofp.sales.dto.ShoppingBasketDto;

/**
 * Implementation of {@link ShoppingBasketDtoMapper}.
 *
 * @author <a href="mailto:marcofp@gmail.com">Marco Fuentelsaz</a>
 * @since 1.0.0
 */
public class ShoppingBasketDtoMapperImpl implements ShoppingBasketDtoMapper {

    /**
     * The itemBasket dto mapper.
     */
    private final ItemBasketDtoMapper itemBasketDtoMapper;

    /**
     * The constructor.
     * @param itemBasketDtoMapper the mapper
     */
    public ShoppingBasketDtoMapperImpl(final ItemBasketDtoMapper itemBasketDtoMapper) {
        this.itemBasketDtoMapper = itemBasketDtoMapper;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ShoppingBasket asShoppingBasket(ShoppingBasketDto src) {
        if (src == null) {
            return null;
        }

        ShoppingBasket shoppingBasket = new ShoppingBasket();
        shoppingBasket.setItems(itemBasketDtoMapper.asItemBaskets(src.getItems()));
        shoppingBasket.setTotalPrice(new BigDecimal(src.getTotalPrice()));
        shoppingBasket.setTotalSalesTaxes(new BigDecimal(src.getTotalSalesTaxes()));
        return shoppingBasket;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ShoppingBasketDto asShoppingBasketDto(ShoppingBasket src) {
        if (src == null) {
            return null;
        }

        ShoppingBasketDto shoppingBasketDto = new ShoppingBasketDto();
        shoppingBasketDto.setItems(itemBasketDtoMapper.asItemBasketDtos(src.getItems()));
        shoppingBasketDto.setTotalPrice(src.getTotalPrice().toString());
        shoppingBasketDto.setTotalSalesTaxes(src.getTotalSalesTaxes().toString());
        return shoppingBasketDto;
    }
}

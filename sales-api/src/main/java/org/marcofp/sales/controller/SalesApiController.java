package org.marcofp.sales.controller;

import java.util.List;

import org.marcofp.sales.domain.entity.Good;
import org.marcofp.sales.domain.entity.ShoppingBasket;
import org.marcofp.sales.domain.usecase.CalculateShoppingBasketUseCase;
import org.marcofp.sales.domain.usecase.FindGoodByNameUseCase;
import org.marcofp.sales.domain.usecase.PrintShoppingBasketUseCase;
import org.marcofp.sales.dto.GoodDto;
import org.marcofp.sales.dto.ItemBasketDto;
import org.marcofp.sales.dto.ShoppingBasketDto;
import org.marcofp.sales.mapper.GoodDtoMapper;
import org.marcofp.sales.mapper.ItemBasketDtoMapper;
import org.marcofp.sales.mapper.ShoppingBasketDtoMapper;
import org.marcofp.sales.service.SalesApi;

/**
 * Controller.
 *
 * @author <a href="mailto:marcofp@gmail.com">Marco Fuentelsaz</a>
 * @since 1.0.0
 */
public class SalesApiController implements SalesApi {

    // Uses cases

    private final CalculateShoppingBasketUseCase calculateShoppingBasketUseCase;

    private final PrintShoppingBasketUseCase printShoppingBasketUseCase;

    private final FindGoodByNameUseCase findGoodByNameUseCase;

    // Mappers

    private final ShoppingBasketDtoMapper shoppingBasketDtoMapper;

    private final ItemBasketDtoMapper itemBasketDtoMapper;

    private final GoodDtoMapper goodDtoMapper;

    /**
     * Constructor.
     *
     * @param calculateShoppingBasketUseCase the calculateShoppingBasketUseCase
     * @param printShoppingBasketUseCase the printShoppingBasketUseCase
     * @param findGoodByNameUseCase findGoodByIdUseCase
     * @param shoppingBasketDtoMapper the shoppingBasketDto mapper
     * @param itemBasketDtoMapper the itemBasketDto mapper
     * @param goodDtoMapper the goodDtoMapper
     */
    public SalesApiController(
        final CalculateShoppingBasketUseCase calculateShoppingBasketUseCase,
        final PrintShoppingBasketUseCase printShoppingBasketUseCase,
        final FindGoodByNameUseCase findGoodByNameUseCase,
        ShoppingBasketDtoMapper shoppingBasketDtoMapper,
        ItemBasketDtoMapper itemBasketDtoMapper, GoodDtoMapper goodDtoMapper) {
        this.calculateShoppingBasketUseCase = calculateShoppingBasketUseCase;
        this.printShoppingBasketUseCase = printShoppingBasketUseCase;
        this.findGoodByNameUseCase = findGoodByNameUseCase;
        this.shoppingBasketDtoMapper = shoppingBasketDtoMapper;
        this.itemBasketDtoMapper = itemBasketDtoMapper;
        this.goodDtoMapper = goodDtoMapper;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ShoppingBasketDto calculateShoppingBasket(final List<ItemBasketDto> items) {
        final ShoppingBasket shoppingBasket = calculateShoppingBasketUseCase
            .calculateShoppingBasket(itemBasketDtoMapper.asItemBaskets(items));
        return shoppingBasketDtoMapper.asShoppingBasketDto(shoppingBasket);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void printShoppingBasket(final ShoppingBasketDto shoppingBasket) {
        final ShoppingBasket shoppingBasketModel = shoppingBasketDtoMapper.asShoppingBasket(shoppingBasket);
        printShoppingBasketUseCase.printShoppingBasket(shoppingBasketModel);
    }

    @Override
    public GoodDto findGoodByName(final String name) {
        final Good goodBydId = findGoodByNameUseCase.findGoodByName(name);
        return goodDtoMapper.asGoodDto(goodBydId);

    }


}

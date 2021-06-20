package org.marcofp.sales.boot.config;

import java.util.List;

import org.marcofp.sales.controller.SalesApiController;
import org.marcofp.sales.domain.repository.GoodRepository;
import org.marcofp.sales.domain.usecase.CalculateShoppingBasketUseCase;
import org.marcofp.sales.domain.usecase.FindGoodByNameUseCase;
import org.marcofp.sales.domain.usecase.PrintShoppingBasketUseCase;
import org.marcofp.sales.infraestructure.repository.mappers.InMemoryGoodMapper;
import org.marcofp.sales.infraestructure.repository.mappers.InMemoryGoodMapperImpl;
import org.marcofp.sales.infraestructure.repository.InMemoryGoodRepository;
import org.marcofp.sales.mapper.GoodDtoMapper;
import org.marcofp.sales.mapper.GoodDtoMapperImpl;
import org.marcofp.sales.mapper.ItemBasketDtoMapper;
import org.marcofp.sales.mapper.ItemBasketDtoMapperImpl;
import org.marcofp.sales.mapper.ShoppingBasketDtoMapper;
import org.marcofp.sales.mapper.ShoppingBasketDtoMapperImpl;
import org.marcofp.sales.service.SalesApi;
import org.marcofp.sales.usecase.CalculateShoppingBasketUseCaseImpl;
import org.marcofp.sales.usecase.FindGoodByNameUseCaseImpl;
import org.marcofp.sales.usecase.PrintShoppingBasketUseCaseImpl;

/**
 * The application configuration implementation.
 *
 * @author <a href="mailto:marcofp@gmail.com">Marco Fuentelsaz</a>
 * @since 1.0.0
 */
public class InMemoryApplicationConfigurationImpl implements ApplicationConfiguration {

    /**
     * The controller.
     */
    private final SalesApi controller;

    /**
     * The constructor.
     */
    public InMemoryApplicationConfigurationImpl(List<List<String>> inMemoryData) {
        InMemoryGoodMapper mapper = new InMemoryGoodMapperImpl();
        final GoodRepository inMemoryGoodRepository = new InMemoryGoodRepository(mapper, inMemoryData);

        final CalculateShoppingBasketUseCase calculateShoppingBasketUseCase = new CalculateShoppingBasketUseCaseImpl();
        final PrintShoppingBasketUseCase printShoppingBasketUseCase = new PrintShoppingBasketUseCaseImpl();
        final FindGoodByNameUseCase findGoodByNameUseCase = new FindGoodByNameUseCaseImpl(inMemoryGoodRepository);
        final GoodDtoMapper goodDtoMapper = new GoodDtoMapperImpl();
        final ItemBasketDtoMapper itemBasketDtoMapper = new ItemBasketDtoMapperImpl(goodDtoMapper);
        final ShoppingBasketDtoMapper shoppingBasketDtoMapper = new ShoppingBasketDtoMapperImpl(itemBasketDtoMapper);
        controller = new SalesApiController(calculateShoppingBasketUseCase, printShoppingBasketUseCase,
            findGoodByNameUseCase, shoppingBasketDtoMapper, itemBasketDtoMapper, goodDtoMapper);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public SalesApi getSalesAPI() {
        return controller;
    }
}

package org.marcofp.sales.usecase;


import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.jupiter.api.Test;
import org.marcofp.sales.domain.entity.Good;
import org.marcofp.sales.domain.entity.GoodType;
import org.marcofp.sales.domain.entity.ItemBasket;
import org.marcofp.sales.domain.entity.ShoppingBasket;
import org.marcofp.sales.domain.usecase.CalculateShoppingBasketUseCase;
import org.marcofp.sales.usecase.builders.GoodTestBuilder;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for {@link CalculateShoppingBasketUseCaseImpl}.
 *
 * @author <a href="mailto:marcofp@gmail.com">Marco Fuentelsaz</a>
 * @since 1.0.0
 */
class CalculateShoppingBasketUseCaseImplTest {

    private static final AtomicInteger ID_GENERATOR = new AtomicInteger(0);

    @Test
    void testCalculateShoppingBasketInput1() {

        // Given
        final Good book = GoodTestBuilder.getInstance()
            .setId(Integer.toString(ID_GENERATOR.getAndIncrement()))
            .setImported(false)
            .setType(GoodType.BOOKS)
            .setName("book")
            .setPrice(new BigDecimal("12.49"))
            .build();

        final Good music = GoodTestBuilder.getInstance()
            .setId(Integer.toString(ID_GENERATOR.getAndIncrement()))
            .setImported(false)
            .setType(GoodType.MUSIC)
            .setName("music CD")
            .setPrice(new BigDecimal("14.99"))
            .build();

        final Good chocolateBar = GoodTestBuilder.getInstance()
            .setId(Integer.toString(ID_GENERATOR.getAndIncrement()))
            .setImported(false)
            .setType(GoodType.FOODS)
            .setName("chocolate bar")
            .setPrice(new BigDecimal("0.85"))
            .build();

        final ItemBasket bookItemBasket = new ItemBasket(book, 1);
        final ItemBasket musicItemBasket = new ItemBasket(music, 1);
        final ItemBasket chocoItemBasket = new ItemBasket(chocolateBar, 1);

        final CalculateShoppingBasketUseCase calculateShoppingBasketUseCase = new CalculateShoppingBasketUseCaseImpl();

        // When
        final ShoppingBasket shoppingBasket = calculateShoppingBasketUseCase
            .calculateShoppingBasket(List.of(bookItemBasket, musicItemBasket, chocoItemBasket));

        // Then
        assertAll(
            () -> assertEquals(3, shoppingBasket.getItems().size()),
            () -> assertEquals(new BigDecimal("12.49"), shoppingBasket.getItems().stream()
                .filter(itemBasket -> itemBasket.getGood().getType() == GoodType.BOOKS).findFirst().get()
                .getFinalPrice()),
            () -> assertEquals(new BigDecimal("16.49"), shoppingBasket.getItems().stream()
                .filter(itemBasket -> itemBasket.getGood().getType() == GoodType.MUSIC).findFirst().get()
                .getFinalPrice()),
            () -> assertEquals(new BigDecimal("0.85"), shoppingBasket.getItems().stream()
                .filter(itemBasket -> itemBasket.getGood().getType() == GoodType.FOODS).findFirst().get()
                .getFinalPrice()),
            () -> assertEquals(new BigDecimal("1.50"), shoppingBasket.getTotalSalesTaxes()),
            () -> assertEquals(new BigDecimal("29.83"), shoppingBasket.getTotalPrice()));

    }

    @Test
    void testCalculateShoppingBasketInput2() {

        // Given
        final Good boxOfChocolates = GoodTestBuilder.getInstance()
            .setId(Integer.toString(ID_GENERATOR.getAndIncrement()))
            .setImported(true)
            .setType(GoodType.FOODS)
            .setName("box of chocolates")
            .setPrice(new BigDecimal("10.00"))
            .build();

        final Good bottleOfPerfume = GoodTestBuilder.getInstance()
            .setId(Integer.toString(ID_GENERATOR.getAndIncrement()))
            .setImported(true)
            .setType(GoodType.COSMETICS_PERFUMES_AND_CLEANING)
            .setName("bottle of perfume")
            .setPrice(new BigDecimal("47.50"))
            .build();

        final ItemBasket bookItemBasket = new ItemBasket(boxOfChocolates, 1);
        final ItemBasket musicItemBasket = new ItemBasket(bottleOfPerfume, 1);

        final CalculateShoppingBasketUseCase calculateShoppingBasketUseCase = new CalculateShoppingBasketUseCaseImpl();

        // When
        final ShoppingBasket shoppingBasket = calculateShoppingBasketUseCase
            .calculateShoppingBasket(List.of(bookItemBasket, musicItemBasket));

        // Then
        assertAll(
            () -> assertEquals(2, shoppingBasket.getItems().size()),
            () -> assertEquals(new BigDecimal("10.50"), shoppingBasket.getItems().stream()
                .filter(itemBasket -> itemBasket.getGood().getType() == GoodType.FOODS).findFirst().get()
                .getFinalPrice()),
            () -> assertEquals(new BigDecimal("54.65"), shoppingBasket.getItems().stream()
                .filter(itemBasket -> itemBasket.getGood().getType() == GoodType.COSMETICS_PERFUMES_AND_CLEANING)
                .findFirst().get()
                .getFinalPrice()),
            () -> assertEquals(new BigDecimal("7.65"), shoppingBasket.getTotalSalesTaxes()),
            () -> assertEquals(new BigDecimal("65.15"), shoppingBasket.getTotalPrice()));

    }

    @Test
    void testCalculateShoppingBasketInput3() {

        // Given
        final Good importedBottleOfPerfume = GoodTestBuilder.getInstance()
            .setId(Integer.toString(ID_GENERATOR.getAndIncrement()))
            .setImported(true)
            .setType(GoodType.COSMETICS_PERFUMES_AND_CLEANING)
            .setName("imported bottle of perfume")
            .setPrice(new BigDecimal("27.99"))
            .build();

        final Good bottleOfPerfume = GoodTestBuilder.getInstance()
            .setId(Integer.toString(ID_GENERATOR.getAndIncrement()))
            .setImported(false)
            .setType(GoodType.COSMETICS_PERFUMES_AND_CLEANING)
            .setName("bottle of perfume")
            .setPrice(new BigDecimal("18.99"))
            .build();

        final Good packetOfHeadachePills = GoodTestBuilder.getInstance()
            .setId(Integer.toString(ID_GENERATOR.getAndIncrement()))
            .setImported(false)
            .setType(GoodType.MEDICAL)
            .setName("packet of headache pills")
            .setPrice(new BigDecimal("9.75"))
            .build();

        final Good boxOfImportedChocolates = GoodTestBuilder.getInstance()
            .setId(Integer.toString(ID_GENERATOR.getAndIncrement()))
            .setImported(true)
            .setType(GoodType.FOODS)
            .setName("box of imported chocolates")
            .setPrice(new BigDecimal("11.25"))
            .build();

        final ItemBasket importedBottleOfPerfumeItemBasket = new ItemBasket(importedBottleOfPerfume, 1);
        final ItemBasket boxOfImportedChocolatesItemBasket = new ItemBasket(boxOfImportedChocolates, 1);
        final ItemBasket packetOfHeadachePillsItemBasket = new ItemBasket(packetOfHeadachePills, 1);
        final ItemBasket bottleOfPerfumeItemBasket = new ItemBasket(bottleOfPerfume, 1);

        final CalculateShoppingBasketUseCase calculateShoppingBasketUseCase = new CalculateShoppingBasketUseCaseImpl();

        // When
        final ShoppingBasket shoppingBasket = calculateShoppingBasketUseCase
            .calculateShoppingBasket(List.of(importedBottleOfPerfumeItemBasket, boxOfImportedChocolatesItemBasket,
                packetOfHeadachePillsItemBasket, bottleOfPerfumeItemBasket));

        // Then
        assertAll(
            () -> assertEquals(4, shoppingBasket.getItems().size()),
            () -> assertEquals(new BigDecimal("32.19"), shoppingBasket.getItems().stream()
                .filter(itemBasket -> itemBasket.getGood().getType() == GoodType.COSMETICS_PERFUMES_AND_CLEANING)
                .filter(itemBasket -> itemBasket.getGood().isImported()).findFirst().get()
                .getFinalPrice()),
            () -> assertEquals(new BigDecimal("20.89"), shoppingBasket.getItems().stream()
                .filter(itemBasket -> itemBasket.getGood().getType() == GoodType.COSMETICS_PERFUMES_AND_CLEANING)
                .filter(itemBasket -> !itemBasket.getGood().isImported()).findFirst().get()
                .getFinalPrice()),
            () -> assertEquals(new BigDecimal("9.75"), shoppingBasket.getItems().stream()
                .filter(itemBasket -> itemBasket.getGood().getType() == GoodType.MEDICAL).findFirst().get()
                .getFinalPrice()),
            () -> assertEquals(new BigDecimal("11.85"), shoppingBasket.getItems().stream()
                .filter(itemBasket -> itemBasket.getGood().getType() == GoodType.FOODS).findFirst().get()
                .getFinalPrice()),
            () -> assertEquals(new BigDecimal("6.70"), shoppingBasket.getTotalSalesTaxes()),
            () -> assertEquals(new BigDecimal("74.68"), shoppingBasket.getTotalPrice()));

    }

}

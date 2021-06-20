package org.marcofp.sales.infraestructure.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.marcofp.sales.domain.entity.Good;
import org.marcofp.sales.domain.entity.GoodType;
import org.marcofp.sales.domain.repository.GoodRepository;
import org.marcofp.sales.infraestructure.repository.mappers.InMemoryGoodMapper;

/**
 * <p>
 * Implementation of {@link GoodRepository} with particular details
 * </p>
 *
 * <p>
 * NOTE: In this naive example, storage will be memory
 * </p>
 *
 * @author <a href="mailto:marcofp@gmail.com">Marco Fuentelsaz</a>
 * @since 1.0.0
 */

public class InMemoryGoodRepository implements GoodRepository {

    public static final String BOOK = "book";
    public static final String MUSIC_CD = "music CD";
    public static final String CHOCOLATE_BAR = "chocolate bar";
    public static final String IMPORTED_BOX_OF_CHOCOLATES = "imported box of chocolates";
    public static final String IMPORTED_BOTTLE_OF_PERFUME = "imported bottle of perfume";
    public static final String BOTTLE_OF_PERFUME = "bottle of perfume";
    public static final String PACKET_OF_HEADACHE_PILLS = "packet of headache pills";
    public static final String BOX_OF_IMPORTED_CHOCOLATES = "box of imported chocolates";

    /**
     * In memory data map.
     */
    private final Map<String, InMemoryGoodEntity> dataMap;

    /**
     * The mapper.
     */
    private final InMemoryGoodMapper mapper;

    /**
     * The constructor.
     *
     * @param mapper the mapper
     * @param initialData the initial data
     */
    public InMemoryGoodRepository(final InMemoryGoodMapper mapper, final List<List<String>> initialData) {
        this.mapper = mapper;
        this.dataMap = new ConcurrentHashMap<>();
        initialize(initialData);
//        InMemoryGoodEntity book = this.generateGood(BOOK, new BigDecimal("12.49"), GoodType.BOOKS, false);
//        this.dataMap.put(BOOK, book);
//        InMemoryGoodEntity musicCD = this.generateGood(MUSIC_CD, new BigDecimal("14.99"), GoodType.MUSIC, false);
//        this.dataMap.put(MUSIC_CD, musicCD);
//        InMemoryGoodEntity chocolateBar = this
//            .generateGood(CHOCOLATE_BAR, new BigDecimal("0.85"), GoodType.FOODS, false);
//        this.dataMap.put(CHOCOLATE_BAR, chocolateBar);
//        InMemoryGoodEntity importedBoxOfChocolates = this
//            .generateGood(IMPORTED_BOX_OF_CHOCOLATES, new BigDecimal("10.00"), GoodType.FOODS, true);
//        this.dataMap.put(IMPORTED_BOX_OF_CHOCOLATES, importedBoxOfChocolates);
//        InMemoryGoodEntity importedBottleOfPerfume = this
//            .generateGood(IMPORTED_BOTTLE_OF_PERFUME, new BigDecimal("47.50"),
//                GoodType.COSMETICS_PERFUMES_AND_CLEANING, true);
//        this.dataMap.put(IMPORTED_BOTTLE_OF_PERFUME, importedBottleOfPerfume);
//        InMemoryGoodEntity bottleOfPerfume = this
//            .generateGood(BOTTLE_OF_PERFUME, new BigDecimal("18.99"), GoodType.COSMETICS_PERFUMES_AND_CLEANING,
//                false);
//        this.dataMap.put(BOTTLE_OF_PERFUME, bottleOfPerfume);
//        InMemoryGoodEntity packetOfHeadachePills = this
//            .generateGood(PACKET_OF_HEADACHE_PILLS, new BigDecimal("9.75"), GoodType.MEDICAL, false);
//        this.dataMap.put(PACKET_OF_HEADACHE_PILLS, packetOfHeadachePills);
//        InMemoryGoodEntity boxOfImportedChocolates = this
//            .generateGood(BOX_OF_IMPORTED_CHOCOLATES, new BigDecimal("11.25"), GoodType.MEDICAL, true);
//        this.dataMap.put(BOX_OF_IMPORTED_CHOCOLATES, boxOfImportedChocolates);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Good> findGoods(List<String> ids) {
        final List<Good> result = new ArrayList<>();
        for (final String id : ids) {
            result.add(this.findGood(id));
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Good> findAllGoods() {
        final List<Good> result = new ArrayList<>();

        for (final Map.Entry<String, InMemoryGoodEntity> entry : this.dataMap.entrySet()) {
            result.add(this.mapper.toDomainEntity(entry.getValue()));
        }

        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean deleteGood(String name) {
        if (name == null) {
            throw new IllegalArgumentException("The provided name is null");
        }
        return this.dataMap.remove(name) != null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Good createGood(final String name, final BigDecimal price, final GoodType type, final Boolean imported) {
        final InMemoryGoodEntity inMemoryGood = new InMemoryGoodEntity(name);
        inMemoryGood.setImported(imported);
        inMemoryGood.setPrice(price);
        inMemoryGood.setType(type);
        this.dataMap.put(name, inMemoryGood);
        return mapper.toDomainEntity(inMemoryGood);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean modifyGood(Good good) {
        if (good == null) {
            throw new IllegalArgumentException("The provided good is null");
        }
        return this.dataMap.put(good.getName(), this.mapper.fromDomainEntity(good)) != null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Good findGood(String name) {
        if (name == null || !dataMap.containsKey(name)) {
            return null;
        }
        return this.mapper.toDomainEntity(this.dataMap.get(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long count() {
        return (long) this.dataMap.size();
    }

    /**
     * Initializes the in memory repository.
     *
     * @param initData The initial data
     */
    private void initialize(List<List<String>> initData) {
        initData.forEach(data -> {
            final String name = data.get(0).trim();
            final BigDecimal price = new BigDecimal(data.get(1).trim());
            final GoodType type = GoodType.valueOf(data.get(2).trim());
            final boolean imported = Boolean.parseBoolean(data.get(3).trim());
            InMemoryGoodEntity entity = this
                .generateGood(name, price,
                    type, imported);
            this.dataMap.put(name, entity);
        });
    }

    private InMemoryGoodEntity generateGood(final String name, final BigDecimal price, final GoodType type,
        final Boolean imported) {
        final InMemoryGoodEntity inMemoryGood = new InMemoryGoodEntity(name);
        inMemoryGood.setImported(imported);
        inMemoryGood.setPrice(price);
        inMemoryGood.setType(type);
        return inMemoryGood;
    }

}

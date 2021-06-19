package org.marcofp.sales.infraestructure.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.marcofp.sales.domain.entity.Good;
import org.marcofp.sales.domain.entity.GoodType;
import org.marcofp.sales.domain.repository.GoodRepository;

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

    /**
     * The key generator.
     */
    private final AtomicInteger keyGenerator;

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
     */
    public InMemoryGoodRepository(final InMemoryGoodMapper mapper) {
        this.mapper = mapper;
        this.keyGenerator = new AtomicInteger(1);
        this.dataMap = new ConcurrentHashMap<>();
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
    public boolean deleteGood(String id) {
        if (id == null) {
            throw new IllegalArgumentException("The provided id is null");
        }
        return this.dataMap.remove(id) != null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Good createGood(final String name, final Double price, final GoodType type, final Boolean imported) {
        final int nextId = this.keyGenerator.getAndIncrement();
        final InMemoryGoodEntity inMemoryGood = new InMemoryGoodEntity(Integer.toString(nextId));
        inMemoryGood.setImported(imported);
        inMemoryGood.setName(name);
        inMemoryGood.setPrice(price);
        inMemoryGood.setType(type);
        this.dataMap.put(inMemoryGood.getId(), inMemoryGood);
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
        return this.dataMap.put(good.getId(), this.mapper.fromDomainEntity(good)) != null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Good findGood(String id) {
        if (id == null) {
            return null;
        }
        return this.mapper.toDomainEntity(this.dataMap.get(id));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long count() {
        return (long) this.dataMap.size();
    }

}

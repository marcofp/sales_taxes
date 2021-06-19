package org.marcofp.sales.infraestructure.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.marcofp.sales.domain.entity.Good;

/**
 * Implements the interface {@link InMemoryGoodMapper}.
 *
 * @author <a href="mailto:marcofp@gmail.com">Marco Fuentelsaz</a>
 * @since 1.0.0
 */
public class InMemoryGoodMapperImpl implements InMemoryGoodMapper {

    @Override
    public Good toDomainEntity(InMemoryGoodEntity inMemoryGoodEntity) {
        Good good = new Good();
        good.setId(inMemoryGoodEntity.getId());
        good.setImported(inMemoryGoodEntity.isImported());
        good.setPrice(inMemoryGoodEntity.getPrice());
        good.setName(inMemoryGoodEntity.getName());
        return good;
    }

    @Override
    public List<Good> toDomainEntities(List<InMemoryGoodEntity> goods) {
        return goods.stream().map(this::toDomainEntity).collect(Collectors.toList());
    }

    @Override
    public InMemoryGoodEntity fromDomainEntity(Good domainGood) {
        InMemoryGoodEntity good = new InMemoryGoodEntity(domainGood.getId());
        good.setImported(domainGood.isImported());
        good.setPrice(domainGood.getPrice());
        good.setName(domainGood.getName());
        return good;
    }
}

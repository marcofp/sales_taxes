package org.marcofp.sales.infraestructure.repository.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.marcofp.sales.domain.entity.Good;
import org.marcofp.sales.infraestructure.repository.InMemoryGoodEntity;

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
        good.setImported(inMemoryGoodEntity.isImported());
        good.setPrice(inMemoryGoodEntity.getPrice());
        good.setName(inMemoryGoodEntity.getName());
        good.setType(inMemoryGoodEntity.getType());
        return good;
    }

    @Override
    public List<Good> toDomainEntities(List<InMemoryGoodEntity> goods) {
        return goods.stream().map(this::toDomainEntity).collect(Collectors.toList());
    }

    @Override
    public InMemoryGoodEntity fromDomainEntity(Good domainGood) {
        InMemoryGoodEntity good = new InMemoryGoodEntity(domainGood.getName());
        good.setImported(domainGood.isImported());
        good.setPrice(domainGood.getPrice());
        return good;
    }
}

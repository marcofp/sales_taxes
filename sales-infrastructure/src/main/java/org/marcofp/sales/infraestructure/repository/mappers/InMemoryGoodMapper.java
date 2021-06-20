package org.marcofp.sales.infraestructure.repository.mappers;

import java.util.List;

import org.marcofp.sales.domain.entity.Good;
import org.marcofp.sales.infraestructure.repository.InMemoryGoodEntity;

/**
 * Mapper for {@link InMemoryGoodEntity}.
 *
 * @author <a href="mailto:marcofp@gmail.com">Marco Fuentelsaz</a>
 * @since 1.0.0
 */
public interface InMemoryGoodMapper {

    /**
     * To domain to entity good.
     *
     * @param good Good in the storage from
     * @return the domain good entity
     */
    Good toDomainEntity(InMemoryGoodEntity good);

    /**
     * To domain to entity good.
     *
     * @param goods Goods in the storage from
     * @return the domain good entity
     */
    List<Good> toDomainEntities(List<InMemoryGoodEntity> goods);

    /**
     * From entity to domain good.
     *
     * @param domainGood Good in the domain from
     * @return the storage good entity
     */
    InMemoryGoodEntity fromDomainEntity(Good domainGood);

}

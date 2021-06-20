package org.marcofp.sales.mapper;

import java.util.List;

import org.marcofp.sales.domain.entity.Good;
import org.marcofp.sales.dto.GoodDto;

/**
 * Mapper for GoodDto.
 *
 * @author <a href="mailto:marcofp@gmail.com">Marco Fuentelsaz</a>
 * @since 1.0.0
 */
public interface GoodDtoMapper {

    /**
     * Maps a GoodDto to a Good
     *
     * @param src the source data
     * @return the target data
     */
    Good asGood(GoodDto src);

    /**
     * Maps a Good to a GoodDto
     *
     * @param src the source data
     * @return the target data
     */
    GoodDto asGoodDto(Good src);

    /**
     * Maps a List<@Good> to an List<@GoodDto>
     * @param src List<@Good> entity source
     * @return List<@GoodDto> entity
     */
    List<GoodDto> asGoodDtos(List<Good> src);

}

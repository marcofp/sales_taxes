package org.marcofp.sales.mapper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.marcofp.sales.domain.entity.Good;
import org.marcofp.sales.domain.entity.GoodType;
import org.marcofp.sales.dto.GoodDto;

/**
 * Implementation of {@link GoodDtoMapper}.
 *
 * @author <a href="mailto:marcofp@gmail.com">Marco Fuentelsaz</a>
 * @since 1.0.0
 */
public class GoodDtoMapperImpl implements GoodDtoMapper {

    @Override
    public Good asGood(GoodDto src) {
        if (src == null) {
            return null;
        }

        Good good = new Good();

        good.setName(src.getName());
        good.setPrice(new BigDecimal(src.getPrice()));
        good.setType(GoodType.valueOf(src.getType()));
        good.setImported(src.isImported());

        return good;
    }

    @Override
    public GoodDto asGoodDto(Good src) {
        if (src == null) {
            return null;
        }

        GoodDto goodDto = new GoodDto();

        goodDto.setImported(src.isImported());
        goodDto.setName(src.getName());
        goodDto.setPrice(src.getPrice().toString());
        goodDto.setType(src.getType().toString());

        return goodDto;
    }

    @Override
    public List<GoodDto> asGoodDtos(List<Good> src) {
        if (src == null) {
            return Collections.emptyList();
        }

        List<GoodDto> list = new ArrayList<>(src.size());
        for (Good good : src) {
            list.add(asGoodDto(good));
        }

        return list;
    }
}

package org.marcofp.sales.usecase.builders;

import java.math.BigDecimal;

import org.marcofp.sales.domain.entity.Good;
import org.marcofp.sales.domain.entity.GoodType;

/**
 * Builder for {@link Good}.
 *
 * @author <a href="mailto:marcofp@gmail.com">Marco Fuentelsaz</a>
 * @since 1.0.0
 */
public class GoodTestBuilder {

    private static final GoodTestBuilder INSTANCE = new GoodTestBuilder();

    private String id;

    private String name;

    private BigDecimal price;

    private GoodType type;

    private boolean imported;

    private GoodTestBuilder() {
    }

    public static GoodTestBuilder getInstance() {
        return INSTANCE;
    }

    public GoodTestBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public GoodTestBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public GoodTestBuilder setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public GoodTestBuilder setType(GoodType type) {
        this.type = type;
        return this;
    }

    public GoodTestBuilder setImported(boolean imported) {
        this.imported = imported;
        return this;
    }

    public Good build() {
        Good good = new Good();
        good.setImported(imported);
        good.setType(type);
        good.setPrice(price);
        good.setName(name);
        return good;
    }
}

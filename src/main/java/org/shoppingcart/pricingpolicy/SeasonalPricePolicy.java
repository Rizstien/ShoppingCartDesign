package org.shoppingcart.pricingpolicy;

import java.math.BigDecimal;

public record SeasonalPricePolicy(Integer discountPercentage) implements PricePolicy{

    @Override
    public BigDecimal calculatePrice(BigDecimal price) {
        price  = price.subtract(price.divide(BigDecimal.valueOf(100)).
                multiply(BigDecimal.valueOf(discountPercentage)));

        return price ;
    }
}

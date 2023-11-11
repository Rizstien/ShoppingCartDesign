package org.shoppingcart.pricingpolicy;

import java.math.BigDecimal;

public sealed interface PricePolicy permits DefaultPricePolicy, SeasonalPricePolicy {
    BigDecimal calculatePrice(BigDecimal price);
}

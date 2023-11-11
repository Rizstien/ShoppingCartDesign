package org.shoppingcart.pricingpolicy;

import org.shoppingcart.product.Product;

import java.math.BigDecimal;

public final class DefaultPricePolicy implements PricePolicy{
    @Override
    public BigDecimal calculatePrice(BigDecimal price) {
        return price;
    }
}

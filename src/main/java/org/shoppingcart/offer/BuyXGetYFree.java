package org.shoppingcart.offer;

import org.shoppingcart.cartitem.CartItem;

import java.math.BigDecimal;
import java.util.List;

public final class BuyXGetYFree implements Offer{
    @Override
    public BigDecimal calculateOfferCost(List<CartItem> cartItems) {
        return null;
    }
}

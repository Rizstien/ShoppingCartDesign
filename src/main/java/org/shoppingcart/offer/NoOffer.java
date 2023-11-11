package org.shoppingcart.offer;

import org.shoppingcart.cartitem.CartItem;

import java.math.BigDecimal;
import java.util.List;

public final class NoOffer implements Offer{


    @Override
    public BigDecimal calculateOfferCost(List<CartItem> cartItems) {
        BigDecimal cost = BigDecimal.ZERO;
        cartItems.forEach(item -> {
            cost.add(item.getCost());
        });
        return cost;
    }
}

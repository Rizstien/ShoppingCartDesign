package org.shoppingcart.offer;

import org.shoppingcart.cartitem.CartItem;

import java.lang.invoke.CallSite;
import java.math.BigDecimal;
import java.util.List;

public sealed interface Offer permits NoOffer, BuyXGetYFree {
    BigDecimal calculateOfferCost(List<CartItem> cartItems);
}

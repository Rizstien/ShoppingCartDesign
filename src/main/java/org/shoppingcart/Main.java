package org.shoppingcart;

import org.shoppingcart.offer.NoOffer;
import org.shoppingcart.pricingpolicy.DefaultPricePolicy;
import org.shoppingcart.pricingpolicy.SeasonalPricePolicy;
import org.shoppingcart.product.Product;
import org.shoppingcart.product.ProductType;
import org.shoppingcart.service.CartService;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        CartService cartService = new CartService();

        Product product = new Product(1, "Fish", ProductType.COUNTABLE, BigDecimal.valueOf(100), false, new SeasonalPricePolicy(5));
        cartService.addToCart(product, BigDecimal.valueOf(3), new NoOffer());

        product = new Product(2, "Milk", ProductType.NON_COUNTABLE, BigDecimal.valueOf(30), false, new DefaultPricePolicy());
        cartService.addToCart(product, BigDecimal.valueOf(1.5), new NoOffer());

        product = new Product(3, "Ghee", ProductType.COUNTABLE, BigDecimal.valueOf(50), false, new SeasonalPricePolicy(10));
        cartService.addToCart(product, BigDecimal.valueOf(5), new NoOffer());

        System.out.println(cartService.checkOut());
    }
}
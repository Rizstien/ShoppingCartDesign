package org.shoppingcart.service;

import org.shoppingcart.cartitem.CartItem;
import org.shoppingcart.offer.Offer;
import org.shoppingcart.product.Product;
import org.shoppingcart.receipt.Receipt;
import org.shoppingcart.user.User;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class CartService {
    private ConcurrentHashMap<Product, CartItem> cartItems = new ConcurrentHashMap<>();

    public void addToCart(Product product, Integer howMuch, Offer offer){
        if(cartItems.size()==0 || !cartItems.containsKey(product)){
            cartItems.put(product, new CartItem(product, howMuch));
        }else if(cartItems.containsKey(product)){
            cartItems.get(product).setQuantity(cartItems.get(product).getQuantity()+1);
        }
    }

    public void removeProduct(Product product){
        if(cartItems.containsKey(product)){
            cartItems.remove(product);
        }
    }

    private BigDecimal totalCost(){
        BigDecimal totalCost = BigDecimal.ZERO;
        for (CartItem item : cartItems.values()) {
            totalCost = totalCost.add(item.getCost());
        }
        return totalCost;
    }

    public String checkOut(){
        return new Receipt(List.copyOf(cartItems.values()), totalCost()).toString();
    }


}

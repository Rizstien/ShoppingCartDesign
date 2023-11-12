package org.shoppingcart.service;

import org.shoppingcart.cartitem.CartItem;
import org.shoppingcart.offer.Offer;
import org.shoppingcart.product.Product;
import org.shoppingcart.product.ProductType;
import org.shoppingcart.receipt.Receipt;
import org.shoppingcart.user.User;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class CartService {
    private ConcurrentHashMap<Product, CartItem> cartItems = new ConcurrentHashMap<>();

    public void addToCart(Product product, BigDecimal howMuch, Offer offer){
        if(cartItems.size()==0 || !cartItems.containsKey(product)){
            cartItems.put(product, new CartItem(product, howMuch));
        }else if(cartItems.containsKey(product)){
            switch(product.getType()){
                case COUNTABLE -> cartItems.get(product).setQuantity(cartItems.get(product).getQuantity().add(howMuch));
                case NON_COUNTABLE -> cartItems.get(product).setWeight(cartItems.get(product).getWeight().add(howMuch));
            }
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

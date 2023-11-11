package org.shoppingcart.cartitem;

import org.shoppingcart.product.Product;

import java.math.BigDecimal;

public class CartItem {
    private Product product;
    private BigDecimal cost;
    private Integer quantity;
    private Integer weight;

    public CartItem(Product product, Integer howMuch) {
        this.product = product;
        switch (product.getType()){
            case COUNTABLE -> this.quantity = howMuch;
            case NON_COUNTABLE -> this.weight = howMuch;
        }
    }


    public Product getProduct() {
        return product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public BigDecimal getCost() {
        switch(getProduct().getType()){
            case COUNTABLE -> cost = getProduct().getPrice().multiply(BigDecimal.valueOf(getQuantity()));
            case NON_COUNTABLE -> cost = getProduct().getPrice().multiply(BigDecimal.valueOf(getWeight()));
        }
        return cost;
    }
}

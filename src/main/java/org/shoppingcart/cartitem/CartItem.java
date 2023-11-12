package org.shoppingcart.cartitem;

import org.shoppingcart.product.Product;

import java.math.BigDecimal;

public class CartItem {
    private Product product;
    private BigDecimal cost;
    private BigDecimal quantity;
    private BigDecimal weight;

    public CartItem(Product product, BigDecimal howMuch) {
        this.product = product;
        switch (product.getType()){
            case COUNTABLE -> this.quantity = howMuch;
            case NON_COUNTABLE -> this.weight = howMuch;
        }
    }


    public Product getProduct() {
        return product;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getCost() {
        switch(getProduct().getType()){
            case COUNTABLE -> cost = getProduct().getPrice().multiply(getQuantity());
            case NON_COUNTABLE -> cost = getProduct().getPrice().multiply(getWeight());
        }
        return cost;
    }
}

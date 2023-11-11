package org.shoppingcart.product;

import org.shoppingcart.pricingpolicy.PricePolicy;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {

    private Integer ID;
    private String name;
    private ProductType type;
    private BigDecimal price;
    private PricePolicy pricePolicy;
    private boolean ageRestricted;

    public Product(Integer ID, String name, ProductType type, BigDecimal price, boolean ageRestricted, PricePolicy pricePolicy) {
        this.ID = ID;
        this.name = name;
        this.type = type;
        this.price = price;
        this.ageRestricted = ageRestricted;
        this.pricePolicy = pricePolicy;
    }

    public Integer getID() {
        return ID;
    }
    public String getName() {
        return name;
    }

    public ProductType getType() {
        return type;
    }

    public BigDecimal getPrice() {
        return pricePolicy.calculatePrice(price);
    }

    public boolean isAgeRestricted() {
        return ageRestricted;
    }

    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if(null==o || this.getClass()!=o.getClass()) return false;
        return Objects.equals(this.getID(),((Product) o).getID());

    }
}

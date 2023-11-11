package org.shoppingcart.receipt;

import org.shoppingcart.cartitem.CartItem;

import java.math.BigDecimal;
import java.util.List;

public class Receipt {

    private List<CartItem> cartItems;
    private BigDecimal totalCost;


    public Receipt(List<CartItem> cartItems, BigDecimal totalCost) {
        this.cartItems = cartItems;
        this.totalCost = totalCost;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("*******************   Thank You for Shopping ************** \n");
        sb.append("Your total Bill is "+totalCost+"\n");
        sb.append("Here is the breakdown of your bill\n");
        cartItems.forEach(item -> {
            sb.append(item.getProduct().getName()).append("    ");
            sb.append("unit Price = ").append(item.getProduct().getPrice());
            sb.append("    ");
            switch (item.getProduct().getType()) {
                case COUNTABLE -> sb.append("Quantity = ").append(item.getQuantity());
                case NON_COUNTABLE -> sb.append("Weight = ").append(item.getWeight());
            }
            sb.append("    ");
            sb.append(item.getCost()).append("\n");
        });

        return sb.toString();
    }
}

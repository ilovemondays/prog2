package com.mymart;
import java.util.ArrayList;

/**
 * Created by Team 13 on 27.03.2017.
 */
public class ShoppingCart {
    private ArrayList<CartItem> cartItemList;

    public ShoppingCart() {
        this.cartItemList = new ArrayList<CartItem>();
    }

    public void addItem(CartItem item) {
        this.cartItemList.add(item);
    }

    public double getTotalCost() {
        double price = 0.0;
        for(CartItem item: cartItemList) {
            price+=item.getCost();
        }
        return price;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(CartItem item : cartItemList) {
            sb.append(item.toString());
        }
        sb.append(String.format("\nSumme: %54.2f", getTotalCost())); // 54 = 60 - 6 von "Summe:"
        return sb.toString();
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(new CartItem("Schokolade", 100, 0.99));
        cart.addItem(new CartItem("Eis", 10, 5.99));
        cart.addItem(new CartItem("Möhren", 4, 0.20));
        System.out.println(cart);
    }
}

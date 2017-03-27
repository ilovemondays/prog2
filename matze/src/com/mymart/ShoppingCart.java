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

    //@todo: machen
    public double getTotalCost() {
        double price = 0.0;
        return price;
    }

    public String toString() {
        String temp = "";
        for(CartItem item : cartItemList) {
            temp += item.toString();
        }
        //@todo Gesamtpreis berechnen und formattiert ausgeben
        return temp + "Gesamtpreis und so";
    }

    //@todo: nur zum testen, müsste sonst noch entfernt werden
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(new CartItem("Schokolade", 10, 0.99));
        cart.addItem(new CartItem("Eis", 1, 5.99));
        cart.addItem(new CartItem("Möhren", 4, 0.20));
        System.out.println(cart);
        System.out.println("Hello"); //nur zu testzwecken
    }
}

package com.mymart;

import java.util.ArrayList;

/**
 * a Shoppingcart, contains a list of CartItems.
 */
public class ShoppingCart {

    private static ArrayList<CartItem> items;

    /**
     * Generate a shopping cart.
     */
    public ShoppingCart() {
        items = new ArrayList<>();
    }

    /**
     * Add an item to the shopping cart.
     * @param item CartItem
     */
    public static void addItem(CartItem item) {
        items.add(item);
    }

    /**
     *
     * @return double Total costs.
     */
    public static double getTotalCost() {
        double sum = 0;

        for(CartItem it : items) {
            sum += it.getCost();
        }

        return sum;
    }

    /**
     *
     * @return String A list of each items attributes (see CartItem) plus the total costs of all this shoppin cart items.
     */
    public String toString() {

        StringBuilder sb = new StringBuilder();
        double sum = 0;

        for(CartItem it : items) {
            sb.append(it.toString()+String.format("%n"));
            sum += it.getCost();
        }

        sb.append(String.format("%n"));
        // vorrausgesetzt, dass die endsumme nicht in den vierstelligen bereich geht..
        sb.append(String.format("Summe:%55.2f%n", sum));

        return sb.toString();

    }
}

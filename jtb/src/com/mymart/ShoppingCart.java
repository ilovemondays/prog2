package com.mymart;

import java.util.ArrayList;

public class ShoppingCart {

    private static ArrayList<CartItem> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    public static void addItem(CartItem item) {
        items.add(item);
    }

    public static double getTotalCost() {
        double sum = 0;

        for(CartItem it : items) {
            sum += it.getCost();
        }

        return sum;
    }

    public String toString() {

        StringBuilder sb = new StringBuilder();

        for(CartItem it : items) {
            sb.append(it.toString()+String.format("%n"));
        }

        return sb.toString();

    }
}

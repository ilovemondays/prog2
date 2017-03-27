package com.mymart;

import java.util.ArrayList;
import java.util.Locale;

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
        double sum = 0;

        for(CartItem it : items) {
            sb.append(it.toString()+String.format("%n"));
            sum += it.getCost();
        }

        sb.append(String.format("%n"));
        // vorrausgesetzt, dass die endsumme nicht in den vierstelligen bereich geht..
        sb.append(String.format(Locale.GERMANY, "%-55s %.2f", "Summe:", sum));

        return sb.toString();

    }
}

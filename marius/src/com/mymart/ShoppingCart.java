package com.mymart;

import java.util.ArrayList;

/**
 * Created by Marius Luding on 01.04.2017.
 */
public class ShoppingCart {
    private ArrayList<CartItem> cartItemArray;

    /**
     * Erstelle dieses Objekt mit einer arraylist als attribut
     */
    public ShoppingCart() {
        this.cartItemArray = new ArrayList<CartItem>();
    }

    /**
     * Fügt ein CartItem dem ShoppingCart hinzu.
     * @param item
     */
    public void addItem(CartItem item) {
        this.cartItemArray.add(item);
    }

    /**
     * gibt die Gesamtsumme vom Shoppingchart wieder
     * @return double
     */
    public double getTotalCost() {
        double price = 0.0;
        for(CartItem item: cartItemArray) {
            price+=item.getCost();
        }
        return price;
    }

    /**
     *  gibt alle Einträge im ShoppingCart aufgelistet als String mit der Gesamtsumme am Ende aus
     * @return string
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(CartItem item : cartItemArray) {
            sb.append(item.toString());
        }
        sb.append(String.format("\nSumme: %54.2f", getTotalCost())); // 54 = 60 - 6 von "Summe:"
        return sb.toString();
    }

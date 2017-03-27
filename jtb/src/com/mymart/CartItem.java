package com.mymart;

import java.util.Formatter;
import java.util.Locale;

public class CartItem {

    private String name;
    private int quantity;
    private double pricePerUnit;

    public CartItem(String name, int quantity, double pricePerUnit) {

        this.name = name;
        setQuantity(quantity);
        this.pricePerUnit = pricePerUnit;
    }

    public double getCost() {
        return quantity*pricePerUnit;
    }

    public void setQuantity(int q) {
        if(q<1)
            throw new IllegalArgumentException("Below 1");
        quantity = q;
    }

    public String toString() {
        return String.format(Locale.GERMANY, "%3d x %30s   %10.2f  %10.2f", quantity, name, pricePerUnit, pricePerUnit*quantity );
    }


}

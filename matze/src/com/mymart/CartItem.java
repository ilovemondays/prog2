package com.mymart;

/**
 * Created by Team 13 on 27.03.2017.
 */
public class CartItem {
    private String name;
    private int quantity;
    private double pricePerUnit;

    public CartItem(String name, int quantity, double pricePerUnit) {
        setQuantity(quantity);
        this.name = name;
        this.pricePerUnit = pricePerUnit;
    }

    public double getCost() {
        return (double) quantity*pricePerUnit;
    }

    public void setQuantity(int quantity) {
        if(quantity >= 1) {
            this.quantity = quantity;
        } else {
            throw new IllegalArgumentException("quantity must be one or more");
        }
    }

    public String toString() {
        //@TODO: muss noch richtig formattiert werden
        return String.format("%1d x %2$-30s   %3$.2f  %4$.2f\n", this.quantity, this.name, this.pricePerUnit, this.getCost());
    }
    //@todo: nur zum testen, müsste sonst noch entfernt werden
    public static void main(String[] args){
        CartItem item = new CartItem("matze", 13, 0.99);
        System.out.println(item);
    }

}

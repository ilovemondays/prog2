package com.mymart;

public class Main {


    public static void main(String[] args) {

        ShoppingCart sc = new ShoppingCart();

        sc.addItem(new CartItem("Hundefutter", 6, 3.20));
        sc.addItem(new CartItem("Kekse", 4, 1.59));
        sc.addItem(new CartItem("Milch", 1, 0.69));
        sc.addItem(new CartItem("Erdbeermarmelade", 3, 2.19));
        System.out.println(sc.toString());

    }
}

package com.mymart;

public class Main {


    public static void main(String[] args) {

        ShoppingCart sc = new ShoppingCart();

        sc.addItem(new CartItem("test", 20, 0.01));
        System.out.println(sc.toString());

    }
}

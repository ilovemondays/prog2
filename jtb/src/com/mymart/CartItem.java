package com.mymart;


/**
 * An item to be added to a shoppingcart
 */
public class CartItem {

    private String name;
    private int quantity;
    private double pricePerUnit;

    /**
     *
     * @param name
     * @param quantity int The amount of ordered items for this article.
     * @param pricePerUnit double Price per unit.
     */
    public CartItem(String name, int quantity, double pricePerUnit) {

        this.name = name;
        setQuantity(quantity);
        this.pricePerUnit = pricePerUnit;
    }

    /**
     *
     * @return double Get the total costs.
     */
    public double getCost() {
        return quantity*pricePerUnit;
    }

    /**
     * Set an amount of items.
     * @param q int Must be higher or equal 1.
     */
    public void setQuantity(int q) {
        if(q<1)
            throw new IllegalArgumentException("Below 1");
        quantity = q;
    }

    /**
     *
     * @return String "Quantity x name   Price per Unit  Total costs"
     */
    public String toString() {
        return String.format("%3d x %-30s   %10.2f  %10.2f", quantity, name, pricePerUnit, pricePerUnit*quantity );
    }


}

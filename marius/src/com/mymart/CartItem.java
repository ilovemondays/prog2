package com.mymart;

/**
 * Created by Marius Luding on 01.04.2017.
 */
public class CartItem {
    private String name;
    private int quantity;
    private double pricePerUnit;

    /**
     * erstellt ein Objekt mit den Parametern:
     * @param name Name des Artikels
     * @param quantity vorhandene Anzahl des Artikels
     * @param pricePerUnit Preis pro Artikel
     */
    public CartItem(String name, int quantity, double pricePerUnit) {
        this.name = name;
        setQuantity(quantity);
        this.pricePerUnit = pricePerUnit;
    }

    /**
     *
     * @return Liefert den Gesamtpreis des Artikels.
     * D. h. bei z. B. vier Dosen Hundefutterzu je 3,20 liefert diese Methode 12,80.
     */
    public double getCost() {
        return (double) quantity*pricePerUnit;
    }

    /**
     *  Setzt die Anzahl auf den gegebenen Wert.
     * @param quantity
     */
    public void setQuantity(int quantity) {
        if(quantity <= 1) {
            throw new IllegalArgumentException("Quantity may not be <1");               //this has to be
        } else {
            this.quantity = quantity;
        }
    }

    /**
     *
     * @return String mit der Ordnung "Anzahl x Name    Einzelpreis  Gesamtpreis Artikel"
     */
    public String toString() {
        return String.format("%3d x %-30s   %10.2f  %10.2f\n", this.quantity, this.name, this.pricePerUnit, this.getCost());
    }
}

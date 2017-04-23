package de.hsh.fakturierung.rechnung;

/**
 * Created by Team 13 on 23.04.17.
 */
public class Main {
    public static void main(String[] args) {
        Rechnung rechnung = new Rechnung(42);
        rechnung.addPos(444, 0.99);
        System.out.println(rechnung.getArtikelnummer(0));
        System.out.println(rechnung.getPreis(0));
        System.out.println(rechnung.getPreis(1));
    }
}

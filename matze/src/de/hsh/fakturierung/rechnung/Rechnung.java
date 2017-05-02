package de.hsh.fakturierung.rechnung;

import java.util.ArrayList;

/**
 * Created by Team 13 on 23.04.17.
 */
class Rechnung {
    private int nummer;
    private ArrayList<Rechnungsposition> positionen = new ArrayList<Rechnungsposition>();;

    /**
     * Contructor
     * @param nummer Rechnnungsnummer
     */
    Rechnung(int nummer) {
        this.nummer = nummer;
    }

    /**
     * Erstellt neue Rechnungsposition und fügt diese der internen Liste hinzu
     * @param artikelnummer Artikelnummer der Position
     * @param preis Preis der Position
     */
    void addPos(int artikelnummer, double preis) {
        positionen.add(new Rechnungsposition(artikelnummer, preis));
    }

    /**
     * getter artikelnummer von position
     * @param pos index in der positionsliste
     * @return Gibt -1 zurück wenn an der Position keine Rechnungsposition existiert
     */
    int getArtikelnummer(int pos) {
        try {
            return positionen.get(pos).getArtikelnummer();
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            return -1;
        }

    }

    /**
     * getter preis von position
     * @param pos index in der positionsliste
     * @return Gibt -1 zurück wenn an der Position keine Rechnungsposition existiert
     */
    double getPreis(int pos) {
        try {
            return positionen.get(pos).getPreis();
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }
}

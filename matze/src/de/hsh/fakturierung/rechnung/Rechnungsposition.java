package de.hsh.fakturierung.rechnung;

/**
 * Created by team 13 on 23.04.17.
 */
public class Rechnungsposition {
    private int artikelnummer;
    private double preis;

    /* package private: Kann aus dem selben Package heraus aufgerufen werden */
    Rechnungsposition(int artikelnummer, double preis) {
        this.artikelnummer = artikelnummer;
        this.preis = preis;
    }

    /* package private: Gibt die Artikelnummer zurück */
    int getArtikelnummer() {
        return artikelnummer;
    }

    /* package private: gibt den preis eines Artikels zurück */
    double getPreis() {
        return preis;
    }
}

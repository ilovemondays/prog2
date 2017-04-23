package de.hsh.fakturierung.rechnung;

/**
 * Created by Marius Luding on 23.04.2017 for group 13
 */
public class Rechnungsposition {
    private int artikelnummer;
    private double preis;

    /**
     *  Legt das Objekt Rechnungsnummer mit
     * @param artikelnummer
     * @param preis
     * an
     */
    Rechnungsposition(int artikelnummer, double preis) {
        this.artikelnummer = artikelnummer;
        this.preis = preis;
    }

    /**
     * Gibt die Artikelnummer des Objekts zurück
     * @return artikelnummer
     */
    int getArtikelnummer(){
        return this.artikelnummer;
    }

    /**
     * Gibt den Preis des Objekts zurück
     * @return preis
     */
    double getPreis(){
        return this.preis;
    }
}
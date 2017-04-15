package de.hsh.fakturierung.rechnung;

/**
 * Created by jannis on 15.04.17.
 */
public class Rechnungsposition {

    private int artikelnummer;
    private double preis;

    /**
     * Constructor
     * @param artikelnummer
     * @param preis
     */
    Rechnungsposition(int artikelnummer, double preis) {
        this.artikelnummer = artikelnummer;
        this.preis = preis;
    }

    /**
     * Erhalte die Artikelnummer
     * @return
     */
    int getArtikelnummer() {
        return artikelnummer;
    }

    /**
     * und dne preis
     * @return
     */
    double getPreis() {
        return preis;
    }
}

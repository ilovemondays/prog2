package de.hsh.fakturierung.rechnung;

import java.util.ArrayList;

/**
 * Created by jannis on 15.04.17.
 */
public class Rechnung {

    private int nummer;
    private ArrayList<Rechnungsposition> positionen;

    /**
     * Constructor
     * @param nummer
     */
    public Rechnung(int nummer) {
        this.nummer = nummer;
        positionen = new ArrayList<>();
    }

    /**
     * Füge eine neue Position hinzu
     * @param artikelnummer
     * @param preis
     */
    public void addPos(int artikelnummer, double preis) {
        positionen.add(new Rechnungsposition(artikelnummer, preis));
    }

    /**
     * Erhalte eine bestimmte Artikelnummer von einer Rechnungsposition
     * @param pos
     * @return
     */
    public int getArtikelnummer(int pos) {
        return positionen.get(pos).getArtikelnummer();
    }

    /**
     * Erhalte einen bestimmten Preis von einer Rechnungsposition
     * @param pos
     * @return
     */
    public double getPreis(int pos) {
        return positionen.get(pos).getPreis();
    }


}

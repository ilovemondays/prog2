package de.hsh.fakturierung.rechnung;

import java.util.ArrayList;

/**
 * Created by Marius Luding on 23.04.2017 for group 13
 */
public class Rechnung {
    private int nummer;
    private ArrayList<Rechnungsposition> rechpositionen;

    /**
     *
     * @param nummer
     */
    public Rechnung(int nummer){
        this.nummer = nummer;
        rechpositionen= new ArrayList<>();
    }

    /**
     * Erhalte den Preis der übergebenen Rechnungsposition
     * @param pos
     * @return Preis
     */
    public double getPreis(int pos){
        return rechpositionen.get(pos).getPreis();
    }

    /**
     * Erhalte die Artikelnummer der übergebenen Rechnungsposition
     * @param pos
     * @return Artikelnummer
     */
    public  int getArtikelnummer(int pos){
        return rechpositionen.get(pos).getArtikelnummer();

    }

    /**
     *  Fügt eine neue Position hinzu
     * @param artikelnummer
     * @param preis
     */
    public  void addPos(int artikelnummer, double preis){
        rechpositionen.add(new Rechnungsposition(artikelnummer, preis));
    }


}

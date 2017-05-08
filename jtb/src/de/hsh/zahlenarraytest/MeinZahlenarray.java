package de.hsh.zahlenarraytest;

import de.hsh.prog.zahlenarrayv02.Zahlenarray;

import java.util.Arrays;

/**
 * Created by jannis on 26.04.17.
 */
public class MeinZahlenarray extends Zahlenarray {
    private Zeitmesser zm;

    /**
     * Constructo0r
     * @param anzahl
     * @param max
     */
    public MeinZahlenarray(int anzahl, int max) {
        super(anzahl, max);
        zm = new Zeitmesser();
        zm.start();
        Arrays.sort(getZahlenArray());
        zm.stop();
    }

    /**
     * erhalte durchschnittliche Abfragezeit von der Methode istEnthalten
     * @return
     */
    public double getDurchschnittlicheAbfragezeit() {


        int n = 20000;

        for (int i = 0; i<n; i++) {
            zm.start();
            istEnthalten(1203);
            zm.stop();
        }

        return zm.getGemesseneGesamtzeit()/(double)(n+1); // +1 = array sort (ist nicht mit graja überprüft worden)
    }

    /**
     * ist die gegebene Zahl im Array enthalten?
     * @param zahl
     * @return
     */
    @Override
    public boolean istEnthalten(int zahl) {
        return Arrays.binarySearch(getZahlenArray(), zahl) >= 0;

    }
}

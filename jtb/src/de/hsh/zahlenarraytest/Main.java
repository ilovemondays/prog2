package de.hsh.zahlenarraytest;

import de.hsh.prog.zahlenarrayv02.ZahlenPruefer;

/**
 * Created by jannis on 26.04.17.
 */
public class Main {
    /**
     * MAIN
     * @param args
     */
    public static void main(String[] args) {

        MeinZahlenarray array= new MeinZahlenarray(10000, 500000);

        int anzahl= ZahlenPruefer.anzahlVerschiedene(array);
        System.out.println("Anzahl: "+anzahl);

        System.out.println("istEnthalten verbraucht durchschnittlich "+1000*array.getDurchschnittlicheAbfragezeit()+" ns");

    }
}

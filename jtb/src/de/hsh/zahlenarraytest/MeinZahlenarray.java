package de.hsh.zahlenarraytest;

import de.hsh.prog.zahlenarrayv02.ZahlenPruefer;
import de.hsh.prog.zahlenarrayv02.Zahlenarray;

import java.util.concurrent.TimeUnit;

/**
 * Created by jannis on 26.04.17.
 */
public class MeinZahlenarray extends Zahlenarray {

    public MeinZahlenarray(int anzahl, int max) {
        super(anzahl, max);
    }

    public long getDurchschnittlicheAbfragezeit() {

        long[] t = new long[1];

        for(int i=0; i<t.length; i++) {

            Zeitmesser zm = new Zeitmesser();
            zm.start();
            ZahlenPruefer.anzahlVerschiedene(this);
            zm.end();
            t[i] = zm.getGemesseneZeit();

        }

        long total = 0;

        for(int i=0; i<t.length; i++) {
            total += t[i];
        }


        return total/t.length;
    }
}

package de.hsh.fakturierung;

import de.hsh.fakturierung.rechnung.Rechnung;

/**
 * Created by jannis on 15.04.17.
 */
public class Main {

    public static void main(String[] args) {

        Rechnung r1 = new Rechnung(3304);
        r1.addPos(420, 66.60);
        r1.addPos(210, 33.30);
        System.out.println(r1.getArtikelnummer(1)+": "+r1.getPreis(1));
        System.out.println(r1.getArtikelnummer(0)+": "+r1.getPreis(0));

    }
}

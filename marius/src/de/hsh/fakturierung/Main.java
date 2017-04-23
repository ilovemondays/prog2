package de.hsh.fakturierung;

import de.hsh.fakturierung.rechnung.Rechnung;

/**
 * Created by Marius Luding on 23.04.2017 for group 13
 */
public class Main {
    public static void Main(String[] args) {
        Rechnung r  = new Rechnung( 1337);
        r.addPos(58008,9.99);
        r.addPos(12321, 127.00);
        System.out.println(r.getPreis(50800));

    }
}

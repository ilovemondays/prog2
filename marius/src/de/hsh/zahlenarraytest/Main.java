package de.hsh.zahlenarraytest;
import de.hsh.prog.zahlenarrayv02.*;
public class Main {
    public static void main(String[] args) {
        MeinZahlenarray array= new MeinZahlenarray(10000, 500000);
        // ↑ Änderung: MeinZahlenarray ↑ statt Zahlenarray
        int anzahl= ZahlenPruefer.anzahlVerschiedene(array);
        System.out.println("Anzahl: "+anzahl);
        // ↓ Änderung: zusätzliche Anweisung:
        System.out.println("istEnthalten verbraucht durchschnittlich "
                +1000*array.getDurchschnittlicheAbfragezeit()+" ns");
    }
}
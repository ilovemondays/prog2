package de.hsh.zahlenarraytest;


import de.hsh.prog.zahlenarrayv02.Zahlenarray;

/**
 * Created by Marius Luding on 03.05.2017 for group 13
 */
public class MeinZahlenarray extends Zahlenarray {

    public MeinZahlenarray(int anzahl, int max) {
        super(anzahl, max);
    }


    private long arrayZeit = 0;

    @Override public boolean istEnthalten(int zahl){
        Zeitmesser z = new Zeitmesser();
        z.start();
        boolean enthalten = super.istEnthalten(zahl);

        z.stopp();
        arrayZeit = z.getGemesseneGesamtzeit();
        return enthalten;
    }



    public long getDurchschnittlicheAbfragezeit(){
       return arrayZeit;
    }
}

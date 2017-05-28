package u24.anonymeKlasse;

/**
 * Created by jannis on 24.05.17.
 */
public class Klingelknopf extends BeobachtetesObjekt {
    private boolean istGedrueckt= false;
    public void knopfDruecken() {
        istGedrueckt= true;
        informiereBeobachter();
    }
    public void knopfLoslassen() {
        istGedrueckt= false;
        informiereBeobachter();
    }
    @Override public String getZustand() {
        if (istGedrueckt) {
            return "gedrueckt";
        } else {
            return "losgelassen";
        }
    }
}
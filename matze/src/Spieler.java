/**
 * Created by team13 on 07.05.2017.
 */
public class Spieler {
    private static int globalCounter = 1;
    private String name;
    private int number;

    /**
     * Erzeugt automatisch ansteigener Nummer. Wirft Fehler nach 11 Spielern.
     * @param name String
     */
    public Spieler(String name) {
        if(globalCounter > 11) {
            throw new IllegalStateException("Mehr als 11 Spieler sind verboten!");
        }
        this.name = name;
        number = globalCounter++;
    }

    /**
     * Gibt Spielername mit Nummer aus
     * @return String
     */
    public String toString() {
        return name+" ("+number+")";
    }
}

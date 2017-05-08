

/**
 * Created by Marius Luding on 07.05.2017 for group 13
 */
public class Spieler {
    private String name;
    private static int nummercounter = 0;
    private int rueckennummer =0;

    /**
     * Creates a player with the given name and a sequential number
     * @param name (name of the player)
     */
    public Spieler(String name) {
        this.name = name;
        nummercounter++;
        if (nummercounter>11) {
            throw new IllegalStateException("Mehr als 11 Spieler sind verboten! ");
        } else {
            this.rueckennummer = nummercounter;
        }
    }

    /**
     * Standard toString utility method
     * @return String containg name and number in the format: name (number)
     */
    public String toString() {
        String s = this.name + " (" + this.rueckennummer + ")";
        return s;
    }


}
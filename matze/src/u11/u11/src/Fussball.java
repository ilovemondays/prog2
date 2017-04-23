/**
 * Created by Team 13 on 23.04.17.
 */
public class Fussball extends Ballspiel {
    @Override
    public String getSpieldauer() {
        return "90 Minuten";
    }

    public String einwurfRegel() {
        return "Handspiel erlaubt";
    }

    public String eckRegel() {
        return "Mindestabstand anderer Spieler 9,15 m";
    }
}

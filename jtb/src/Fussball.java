/**
 * Created by jannis on 15.04.17.
 */
public class Fussball extends Ballspiel {

    @Override
    public int getSpieldauer() { return 90; }
    public String einwurfRegel() { return "Handspiel erlaubt"; }
    public String eckRegel() { return "Mindestabstand anderer Spieler 9,15 m"; }


}

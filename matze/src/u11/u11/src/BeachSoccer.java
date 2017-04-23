/**
 * Created by Team 13 on 23.04.17.
 */
public class BeachSoccer extends Fussball {
    @Override
    public String getSpieldauer() {
        return "36 Minuten ";
    }

    @Override
    public String eckRegel() {
        return "Maximal 5 Sekunden";
    }

    @Override
    public String einwurfRegel() {
        return eckRegel();
    }
}

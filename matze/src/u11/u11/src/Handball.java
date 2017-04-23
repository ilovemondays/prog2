/**
 * Created by Team 13 on 23.04.17.
 */
public class Handball extends Ballspiel {
    @Override
    public String getSpieldauer() {
        return "60 Minuten";
    }

    public int mannschaftsGroesse() {
        return 7;
    }
}

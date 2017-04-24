/**
 * Created by Team 13 on 23.04.17.
 */
public class Jonglieren extends Ballspiel {
    @Override
    public int getMannschaften() {
        return 1;
    }

    @Override
    public int getBaelle() {
        return 5;
    }

    public String lernRegel() {
        return "Üben, üben, üben";
    }

}

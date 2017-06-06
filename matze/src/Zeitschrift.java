/**
 * Created by matze on 04.06.17.
 */
public class Zeitschrift extends Medium {
    private int nummer;

    public Zeitschrift(String titel, int erscheinungsjahr, int nummer) {
        super(titel, erscheinungsjahr);
        setNummer(nummer);
    }

    @Override
    int getLeihFrist() {
        return 7;
    }

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        if (nummer <= 0) return;
        this.nummer = nummer;
    }

    @Override
    public String toString() {
        return super.toString() + " // " + getNummer();
    }
}

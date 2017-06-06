/**
 * Created by matze on 04.06.17.
 */
public class CD extends Medium {
    private String kuenstler;
    private int gesamtspielzeit;

    public CD(String titel, int erscheinungsjahr, String kuenstler, int gesamtspielzeit) {
        super(titel, erscheinungsjahr);
        setKuenstler(kuenstler);
        setGesamtspielzeit(gesamtspielzeit);
    }

    @Override
    int getLeihFrist() {
        return 14;
    }

    public String getKuenstler() {
        return kuenstler;
    }

    public void setKuenstler(String kuenstler) {
        if(kuenstler.equals("") || kuenstler.equals(null)) return;
        this.kuenstler = kuenstler;
    }

    public int getGesamtspielzeit() {
        return gesamtspielzeit;
    }

    public void setGesamtspielzeit(int gesamtspielzeit) {
        this.gesamtspielzeit = gesamtspielzeit;
    }

    @Override
    public String toString() {
        return super.toString() + " // " + getKuenstler() + " // " + getGesamtspielzeit();
    }
}

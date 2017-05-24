package u23;

/**
 * Created by Marius Luding on 24.05.2017 for group 13
 */
public class Zeitschrift extends Medium {
    private int nummer=1;

    Zeitschrift(String titel, int erscheinungsjahr, int nummer){
        this.setTitel(titel);
        this.setNummer(nummer);
        this.setErscheinungsjahr(erscheinungsjahr);
    }

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        if (nummer>=1) {
            this.nummer = nummer;
        }else {
            throw new IllegalArgumentException();
        }
    }


}

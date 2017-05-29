package pseudoanonymPackage.u26;

/**
 * Created by jannis on 24.05.17.
 */
public class Zeitschrift extends Medium {

    private int nummer;

    /**
     * im getting bored with this
     * @param title
     * @param year
     * @param number
     */
    public Zeitschrift(String title, int year, int number) {
        setTitel(title);
        setErscheinungsjahr(year);
        setNummer(number);
    }

    /**
     * getNummer
     * @return
     */
    public int getNummer() {
        return nummer;
    }

    /**
     * setNummer
     * value must be greater or equal than 0
     * @param nummer
     */
    public void setNummer(int nummer) {
        if( nummer < 1 )
            throw new IllegalArgumentException();

        this.nummer = nummer;
    }

    /**
     * toString
     * @return
     */
    @Override
    public String toString() {
        return getTitel()+" ("+getNummer()+"/"+ getErscheinungsjahr()+")";
    }

    /**
     * asd
     * @return
     */
    @Override
    public int getLeihFrist() {
        return 7;
    }
}

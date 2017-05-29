package pseudoanonymPackage.u26;

/**
 * Created by jannis on 24.05.17.
 */
public class CD extends Medium {

    private String kuenstler;
    private int gesamtspielzeit;

    /**
     * constructor
     * @param title
     * @param year
     * @param artist
     * @param playtime
     */
    public CD(String title, int year, String artist, int playtime) {
        setTitel(title);
        setErscheinungsjahr(year);
        setKuenstler(artist);
        setGesamtspielzeit(playtime);
    }

    /**
     * getKuenstler
     * @return
     */
    public String getKuenstler() {
        return kuenstler;
    }

    /**
     * setKuenstler
     * The variable must not be null or empty ("")
     * @param kuenstler
     */
    public void setKuenstler(String kuenstler) {
        if( kuenstler == null || kuenstler.length() == 0 )
            throw new IllegalArgumentException();

        this.kuenstler = kuenstler;
    }

    /**
     * getGesamtspielzeit
     * @return
     */
    public int getGesamtspielzeit() {
        return gesamtspielzeit;
    }

    /**
     * setGesamtspielzeit
     * Value must be greater or equal than 0
     * @param gesamtspielzeit
     */
    public void setGesamtspielzeit(int gesamtspielzeit) {
        if( gesamtspielzeit < 1 )
            throw new IllegalArgumentException();

        this.gesamtspielzeit = gesamtspielzeit;
    }

    /**
     * toString
     * @return
     */
    @Override
    public String toString() {
        return getKuenstler()+": "+getTitel()+" ("+ getErscheinungsjahr()+") "+getGesamtspielzeit()+" Minuten";
    }

    /**
     * asd
     * @return
     */
    @Override
    public int getLeihFrist() {
        return 14;
    }
}

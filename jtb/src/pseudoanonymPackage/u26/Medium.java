package pseudoanonymPackage.u26;

/**
 * Created by jannis on 24.05.17.
 */
public abstract class Medium implements Comparable<Medium> {

    private String titel;
    private int erscheinungsjahr;

    /**
     * get Titel
     * @return
     */
    public String getTitel() {
        return titel;
    }

    /**
     * set Titel.
     * The variable must not be null or empty ("")
     * @param titel
     */
    public void setTitel(String titel) {
        if( titel == null || titel.length() == 0 )
            throw new IllegalArgumentException();

        this.titel = titel;
    }

    /**
     * get published year
     * @return
     */
    public int getErscheinungsjahr() {
        return erscheinungsjahr;
    }

    /**
     * set published year
     * Year must be greater or equal than 0
     * @param erscheinungsjahr
     */
    public void setErscheinungsjahr(int erscheinungsjahr) {
        if( erscheinungsjahr < 0 )
            throw new IllegalArgumentException();

        this.erscheinungsjahr = erscheinungsjahr;
    }

    /**
     * get LeihFrist
     * @return
     */
    public abstract int getLeihFrist();

    /**
     * compare to pseudoanonymPackage.u26.Medium objects
     */
    @Override
    public int compareTo(Medium to) {
        return Integer.compare(this.getErscheinungsjahr(), to.getErscheinungsjahr());
    }
}

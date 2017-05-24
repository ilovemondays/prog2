package pseudoanonymPackage.u23;

/**
 * Created by jannis on 24.05.17.
 */
public class Buch extends Medium {

    private String autor;
    private String verlag;

    /**
     * constructor
     * @param title
     * @param year
     * @param publisher
     * @param author
     */
    public Buch(String title, int year, String publisher, String author) {
        setTitel(title);
        setErscheinungsjahr(year);
        setVerlag(publisher);
        setAutor(author);
    }

    /**
     * getAutor
     * @return
     */
    public String getAutor() {
        return autor;
    }

    /**
     * setAutor
     * The variable must not be null or empty ("")
     * @param autor
     */
    public void setAutor(String autor) {
        if( autor == null || autor.length() == 0 )
            throw new IllegalArgumentException();

        this.autor = autor;
    }

    /**
     * getVerlag
     * @return
     */
    public String getVerlag() {
        return verlag;
    }

    /**
     * setVerlag
     * The variable must not be null or empty ("")
     * @param verlag
     */
    public void setVerlag(String verlag) {
        if( verlag == null || verlag.length() == 0 )
            throw new IllegalArgumentException();

        this.verlag = verlag;
    }

    /**
     * toString
     * @return
     */
    @Override
    public String toString() {
        return getAutor()+": "+getTitel()+" ("+ getErscheinungsjahr()+") "+getVerlag();
    }

    /**
     * asd
     * @return
     */
    @Override
    public int getLeihFrist() {
        return 28;
    }
}

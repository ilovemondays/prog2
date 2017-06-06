/**
 * Created by matze on 04.06.17.
 */
public class Buch extends Medium {
    private String autor;
    private String verlag;

    public Buch(String titel, int jahr, String autor, String verlag) {
        super(titel, jahr);
        setAutor(autor);
        setVerlag(verlag);
    }

    @Override
    int getLeihFrist() {
        return 28;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        if(autor.equals("") || autor.equals(null)) return;
        this.autor = autor;
    }

    public String getVerlag() {
        return verlag;
    }

    public void setVerlag(String verlag) {
        if(verlag.equals("") || verlag.equals(null)) return;
        this.verlag = verlag;
    }

    @Override
    public String toString() {
        return super.toString() + " // " + getAutor() + " // " + getVerlag();
    }
}

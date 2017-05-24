package u23;

/**
 * Created by Marius Luding on 24.05.2017 for group 13
 */
public abstract class Medium {
    abstract int getLeihFrist();

    private String titel=null;
    private int erscheinungsjahr;


    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        if (titel.equals("")||titel==null){
            throw new IllegalArgumentException();
        } else {
            this.titel = titel;
        }
    }

    public int getErscheinungsjahr() {
        return erscheinungsjahr;
    }

    public void setErscheinungsjahr(int erscheinungsjahr) {
        if (erscheinungsjahr<0){
            throw new IllegalStateException();
        } else {
            this.erscheinungsjahr = erscheinungsjahr;
        }
    }
}

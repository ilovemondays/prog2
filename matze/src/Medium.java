/**
 * Created by matze on 04.06.17.
 */
public abstract class Medium implements Comparable {
    private String titel;
    private int erscheinungsjahr;

    abstract int getLeihFrist();

    public Medium(String titel, int erscheinungsjahr) {
        setTitel(titel);
        setErscheinungsjahr(erscheinungsjahr);
    }

    public String getTitel() {
        return titel;
    }
    public void setTitel(String titel) {
        this.titel = titel;
    }
    public int getErscheinungsjahr() {
        return erscheinungsjahr;
    }
    public void setErscheinungsjahr(int jahr) {
        if(jahr < 0) {
            return;
        }
        this.erscheinungsjahr = jahr;
    }

    @Override
    public String toString() {
        return getTitel() + " // " + getErscheinungsjahr();
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Medium) {
            int thisYear = getErscheinungsjahr();
            int otherYear = ((Medium) o).getErscheinungsjahr();
            if( thisYear > otherYear) {
                return 1;
            } else if (thisYear < otherYear){
                return -1;
            }
            return 0;
        }
        return -1;
    }
}

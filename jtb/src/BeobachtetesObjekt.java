/**
 * Created by jannis on 24.05.17.
 */
public abstract class BeobachtetesObjekt {
    public abstract String getZustand();
    private Beobachter beobachter;
    public void setBeobachter(Beobachter beobachter) {
        this.beobachter= beobachter;
    }
    public void informiereBeobachter() {
        if (beobachter != null) {
            beobachter.update(this);
        }
    }
}

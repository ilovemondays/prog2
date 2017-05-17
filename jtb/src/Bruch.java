import java.util.Objects;

/**
 * Created by jannis on 16.05.17.
 */
public class Bruch {

    private int zaehler;
    private int nenner;

    /**
     *
     * @param z Zaehler
     * @param n Nenner
     */
    public Bruch(int z, int n) {
        setNenner(n);
        setZaehler(z);
    }

    /**
     * erhalte zaehler
     * @return
     */
    public int getZaehler() {
        return zaehler;
    }

    /**
     * setze zaehler
     * @param zaehler
     */
    public void setZaehler(int zaehler) {
        this.zaehler = zaehler;
    }

    /**
     * erhalte nenner
     * @return
     */
    public int getNenner() {
        return nenner;
    }

    /**
     * setze nenner. Nenner darf nicht null sein..
     * @param nenner
     */
    public void setNenner(int nenner) {
        if( nenner == 0 )
            throw new IllegalArgumentException();
        this.nenner = nenner;
    }

    /**
     * ueberpruefe ob zwei brueche gleich sind
     * @param b2
     * @return
     */
    @Override
    public boolean equals(Object b2) {

        if(b2 instanceof Bruch ) {
            Bruch check = (Bruch) b2;
            return check.zahl() == zahl();
        }

         return false;
    }

    /**
     * setzte hashcode
     * @return
     */
    @Override
    public int hashCode() {
        int ggT = ggT();
        return Objects.hash(getZaehler()/ggT, getNenner()/ggT);
    }

    /**
     * berechne den bruch
     * @return
     */
    public double zahl() {
        return 1.0*getZaehler()/getNenner();
    }

    /**
     * erhalte den groeßten gemeinsamen teiler vom zaehler und nenner
     * @return
     */
    public int ggT() {
        return euclid(getZaehler(), getNenner());
    }

    /**
     * erhalte ggT mithilfe von diesen euklidischen algorithmus
     * @param a
     * @param b
     * @return
     */
    private int euclid(int a, int b) {
        if( b==0 )
            return a;
        return euclid( b, a % b );
    }


}

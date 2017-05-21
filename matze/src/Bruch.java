/**
 * Created by matze on 21.05.17.
 */
public class Bruch extends Object {
    private int zaehler;
    private int nenner;

    public Bruch(int z, int n) {
        setZaehler(z);
        setNenner(n);
    }

    public int getZaehler() {
        return zaehler;
    }

    public void setZaehler(int zaehler) {
        this.zaehler = zaehler;
    }

    public int getNenner() {
        return nenner;
    }

    public void setNenner(int nenner) {
        if(nenner == 0) {
            throw new IllegalArgumentException();
        }
        this.nenner = nenner;
    }

    public double zahl() {
        return (double) zaehler/nenner;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Bruch) {
            return ((Bruch) obj).zahl() == this.zahl();
        }
        return false;
    }

    // @TODO: Noch nicht wie in der Aufgabe verlangt
    @Override
    public int hashCode() {
        return java.util.Objects.hash(zahl());
    }
}

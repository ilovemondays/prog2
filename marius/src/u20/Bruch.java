
import java.util.Objects;


/**
 * Created by Marius Luding on 19.05.2017 for group 13
 */
public class Bruch {
    private int zaehler;
    private int nenner;

    /**
     * constructor for the object 'Bruch'
     * @param zaehler
     * @param nenner
     */
    public Bruch(int zaehler,int nenner) {
        setZaehler(zaehler);
        setNenner(nenner);
    }

    /**
     *
     * @return gets the zaehler of the fraction
     */
    public int getZaehler() {
        return zaehler;
    }

    /**
     * sets the zaehler of the fraction
     * @param zaehler
     */
    public void setZaehler(int zaehler) {
        this.zaehler = zaehler;
    }

    /**
     *
     * @return Nenner of the fraction.
     */
    public int getNenner() {
        return nenner;
    }

    /**
     *  sets the nenner, may not be '0'
     * @param nenner of the fraction
     */
    public void setNenner(int nenner) {
        if (nenner==0) throw new IllegalArgumentException("Nenner may not be '0'");
        this.nenner = nenner;
    }

    /**
     *
     * @return Zaehler of the fraction
     */
    public double zahl() {
        return ((double)zaehler)/nenner;
    }

    /**
     *
     * @param Bruch object
     * @return true if the two factions have the same factors.
     */
    @Override
    public boolean equals(Object other){
        if (other instanceof Bruch) {
            Bruch temp = (Bruch) other;
            return temp.valueOf() == this.valueOf();
        }
        return false;

    }
    private double valueOf() {
        return (double)getZaehler()/getNenner();
    }

    /**
     * Calculates the hash for the Object. Two fractions that have the same factor return the same hash.
     * @return has of this object
     */

    @Override
    public int hashCode(){
        int gemeinsamerTeiler = gcd(zaehler, nenner);
        return Objects.hash(getZaehler()/gemeinsamerTeiler, getNenner()/gemeinsamerTeiler);


    }

    /**
     * Calculates the greatest common divisor for the two given values
     * @param gcdTempOne
     * @param gcdTempTwo
     * @return
     */
    static int gcd(int gcdTempOne, int gcdTempTwo)
    {
        while(gcdTempOne!=0 && gcdTempTwo!=0)
        {
            int gcdTempThree = gcdTempTwo;
            gcdTempTwo = gcdTempOne%gcdTempTwo;
            gcdTempOne = gcdTempThree;
        }
        return gcdTempOne+gcdTempTwo;
    }


}

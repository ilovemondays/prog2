package de.hsh.prog.factorsenginev02;

import java.util.ArrayList;

/**
 * Created by matthiasdietrich on 10.06.17.
 */
public class FactorsEngineCalculator extends Thread {
    private long z;
    private long i;
    private ArrayList<Long> factors;

    /**
     *
     * @param z
     */
    public FactorsEngineCalculator(long z) {
        this.z = z;
        factors = new ArrayList<Long>();
        setName("TFE_"+z);
    }

    /**
     *
     * @return
     */
    private void calcFactors() {
        for (i = 1; i<=z/2; i++) {
            if(z%i==0) factors.add(i);
            if(Thread.interrupted()) {
                factors = new ArrayList<Long>();
                break;
            }
        }
        factors.add(z);
    }

    /**
     *
     * @return
     */
    public long getI() {
        return i;
    }

    /**
     *
     * @return
     */
    public long[] getFactors() {
        long[] fac = new long[factors.size()-1];
        for (int i = 0; i < factors.size()-1; i++) {
            fac[i] = factors.get(i);
        }
        return fac;
    }

    @Override
    public void run() {
        calcFactors();
    }
}

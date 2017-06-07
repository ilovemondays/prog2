package de.hsh.prog.factorsenginev02;

import java.util.ArrayList;

/**
 * Created by jannis on 04.06.17.
 */
public class CalcThread extends Thread {

    private long number;
    private ArrayList<Long> list;
    private long currentI;

    /**
     * Create a new Thread with a specific number
     * @param number
     */
    public CalcThread(long number) {
        super("TFE_"+number);
        this.number = number;
        list = new ArrayList<>();

    }

    /**
     * Thread run method. Calculates all factors of a given number
     */
    @Override
    public void run() {

        synchronized (list) {

            list.add(1L);

            for (currentI = 2; currentI <= number / 2; currentI++) {
                if(Thread.interrupted()) {
                    return;
                }
                if (number % currentI == 0) {
                    list.add(currentI);
                }
            }

            list.add(number);
        }


    }

    /**
     * Get Thread-specific number
     * @return
     */
    public long getNumber() { return number; }

    /**
     * get current progress
     * @return double between 0 and 1.0
     */
    public double getProgress() {
        return (double) ((float)currentI / (number/2));
    }


    /**
     * get a list of all calculated factors.
     * When calculation process is not finished, it returns a list of all current factors
     * @return
     */
    public long[] getFactors() {

        ArrayList<Long> intermediateResult = list;

        long[] factors = new long[intermediateResult.size()];

        for(int i=0; i<intermediateResult.size(); i++)
            factors[i] = intermediateResult.get(i);

        return factors;
    }
}

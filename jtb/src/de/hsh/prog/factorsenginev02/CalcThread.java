package de.hsh.prog.factorsenginev02;

import java.util.ArrayList;

/**
 * Created by jannis on 04.06.17.
 */
public class CalcThread extends Thread {

    private ArrayList<Long> numbers;
    private long n;
    private long currentIndex;

    public CalcThread(long number) {
        numbers = new ArrayList<>();
        n = number;
        this.setName("TFE_"+number);
        currentIndex = 0;
    }

    @Override
    public void run() {
        for(long i=1; i<n/2; i++, currentIndex++) {
            if( i%n == 0 )
                numbers.add(i);
        }
        numbers.add(n);
    }

    public long getN() { return n; }

    public double getProgress() {
        return currentIndex/(n/2);
    }

    public long[] getFactors() {
        long[] factors = new long[numbers.size()];
        for(int i=0; i<factors.length; i++)
            factors[i] = numbers.get(i);
        return factors;
    }

}

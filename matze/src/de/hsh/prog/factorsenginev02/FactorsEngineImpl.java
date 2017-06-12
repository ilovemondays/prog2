package de.hsh.prog.factorsenginev02;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by matthiasdietrich on 10.06.17.
 */
public class FactorsEngineImpl implements FactorsEngine {
    private HashMap<Long, long[]> calculated = new HashMap<Long, long[]>();
    private HashMap<Long, FactorsEngineCalculator> threads = new HashMap<Long, FactorsEngineCalculator>();


    @Override
    public boolean startJob(long number) {
        if(calculated.containsKey(number) || threads.containsKey(number)) {
            if(calculated.containsKey(number)) {
                System.out.println("Factors of "+number);
                System.out.println("-----------------------------------------------------------");
                System.out.println(Arrays.toString(getFactors(number)));
            }
            return false;
        }
        threads.put(number, new FactorsEngineCalculator(number));
        new Thread(){
            @Override
            public void run() {
                System.out.println("Job started ("+number+")");
                System.out.println("-----------------------------------------------------------");
                processingThread(number);
            }
        }.start();
        return true;
    }

    @Override
    public boolean abortJob(long number) {
        try {
            threads.get(number).interrupt();
        } catch(Exception e) {
            System.out.println("Thread could not bet aborted or it doesnt exist");
        }
        return false;
    }

    @Override
    public void shutdown() {

    }

    @Override
    public long[] getRunningJobs() {
        long[] runningJobs = new long[threads.size()-1];
        int i = 0;
        for (long n : threads.keySet()) {
            runningJobs[i] = n;
            i++;
        }
        return runningJobs;
    }

    @Override
    public Double getProgress(long number) {
        try {
            return (100.00/number * (threads.get(number).getI()*2)) ;
        } catch (Exception e) {
            System.out.println("Get Progress is not available");
            System.out.println("-----------------------------------------------------------");
        }
        return -1.0;
    }

    @Override
    public long[] getFactors(long number) {
        return calculated.get(number);
    }

    @Override
    public long[] getFactorsIntermediateResult(long number) {
        return new long[0];
    }

    public HashMap<Long, FactorsEngineCalculator> getThreads() {
        return threads;
    }

    private void processingThread(long number) {
        threads.get(number).start();
        try {
            threads.get(number).join();
        } catch (InterruptedException e) {
            System.out.println(e.getCause());
        }
        if(threads.get(number).getFactors().length > 0) {
            calculated.put(number, threads.get(number).getFactors());
        }
        threads.remove(number);
    }

    public void listJobs() {
        if(threads.size() == 0) {
            System.out.println("No Jobs Processing");
        }
        for (long n : threads.keySet()) {
            System.out.println(n+": "+getProgress(n));
        }
        System.out.println("-----------------------------------------------------------");
    }
}

package de.hsh.prog.factorsenginev02;

import java.util.ArrayList;

/**
 * Created by jannis on 04.06.17.
 */
public class FactorsEngineImp1 implements FactorsEngine {

    private ArrayList<CalcThread> list;


    public FactorsEngineImp1() {
        list = new ArrayList<>();

    }


    @Override
    public boolean startJob(long number) {

        for(CalcThread t : list) {
            if( t.getN() == number )
                return false;
        }

        list.add(new CalcThread(number));
        list.get(list.size()-1).start();

        return true;
    }

    @Override
    public boolean abortJob(long number) {
        return false;
    }

    @Override
    public void shutdown() {

    }

    @Override
    public long[] getRunningJobs() {
        long[] jobs = new long[list.size()];
        for(int i=0; i<jobs.length; i++) {
            jobs[i] = list.get(i).getN();
        }

        return jobs;
    }

    @Override
    public Double getProgress(long number) {
        for(CalcThread t : list) {
            if(t.getN() == number)
                return t.getProgress();
        }

        return null;
    }

    @Override
    public long[] getFactors(long number) {
        for(CalcThread t : list) {
            if(t.getN() == number)
                return t.getFactors();
        }

        return null;
    }

    @Override
    public long[] getFactorsIntermediateResult(long number) {
        return new long[0];
    }
}

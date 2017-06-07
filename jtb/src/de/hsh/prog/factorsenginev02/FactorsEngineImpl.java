package de.hsh.prog.factorsenginev02;

import java.util.ArrayList;

/**
 * Created by jannis on 04.06.17.
 */
public class FactorsEngineImpl implements FactorsEngine {

    private ArrayList<CalcThread> list;

    /**
     * Constructor
     */
    public FactorsEngineImpl() {
        list = new ArrayList<>();

    }

    /**
     * @see de.hsh.prog.factorsenginev02.FactorsEngine#startJob(long)
     * @param number
     *            the number, for which the factors are requested.
     * @return
     */
    @Override
    public boolean startJob(long number) {
        if( getJob(number) == null ) {

            CalcThread ct = new CalcThread(number);

            list.add(ct);
            ct.start();

            return true;
        }

        return false;
    }

    /**
     * @see de.hsh.prog.factorsenginev02.FactorsEngine#abortJob(long)
     * @param number
     *            identifies the job to abort.
     * @return
     */
    @Override
    public boolean abortJob(long number) {
        CalcThread job = getJob(number);
        boolean b = abortJob(job);
        list.remove(job);
        return b;
    }

    /**
     * abort a job (if it even exists). Main thread will wait until job is finished/terminated
     * @param job
     * @return true if aborted while calculcation was ongoing. false if job does not exist or job is already finished
     */
    private boolean abortJob(CalcThread job) {

        if( job != null ) {

            job.interrupt();
            try {
                job.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return job.getProgress()<1;

        }

        return false;
    }

    /**
     * @see FactorsEngine#shutdown()
     */
    @Override
    public void shutdown() {
        ArrayList<CalcThread> toRemove = new ArrayList<>();

        for(CalcThread ct : list) {
            abortJob(ct);
            if( ct.getProgress() < 1 ) {
                toRemove.add(ct);
            }
        }

        list.removeAll(toRemove);

    }

    /**
     * @see FactorsEngine#getRunningJobs()
     * @return
     */
    @Override
    public long[] getRunningJobs() {


        ArrayList<Long> temp = new ArrayList<>();


        for(int i=0; i<list.size(); i++) {
            if( list.get(i).getProgress() < 1 )
                temp.add( list.get(i).getNumber() );
        }

        long[] nums = new long[temp.size()];
        for(int i=0; i<temp.size(); i++)
            nums[i] = temp.get(i);



        return nums;
    }

    /**
     * @see de.hsh.prog.factorsenginev02.FactorsEngine#getProgress(long)
     * @param number
     *            the number, for which the factors are requested.
     * @return
     */
    @Override
    public Double getProgress(long number) {
        CalcThread job = getJob(number);

        if(job!=null)
            return job.getProgress();
        else
            return null;

    }

    /**
     * @see de.hsh.prog.factorsenginev02.FactorsEngine#getFactors(long)
     * @param number
     *            the number, for which the factors are requested.
     * @return
     */
    @Override
    public long[] getFactors(long number) {

        CalcThread job = getJob(number);

        if(job.getProgress()>=1)
            return job.getFactors();

        return null;
    }

    /**
     * @see de.hsh.prog.factorsenginev02.FactorsEngine#getFactorsIntermediateResult(long)
     * @param number
     *            the number, for which the factors are requested.
     * @return
     */
    @Override
    public long[] getFactorsIntermediateResult(long number) {
        return getJob(number).getFactors();
    }

    /**
     * get a job/thread by number
     * @param number
     * @return null if no job with this number exists
     */
    private CalcThread getJob(long number) {

        for(CalcThread ct : list) {
            if( ct.getNumber() == number )
                return ct;
        }

        return null;

    }
}

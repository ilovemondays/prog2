package de.hsh.zahlenarraytest;

/**
 * Created by jannis on 26.04.17.
 */
public class Zeitmesser {

    private long end;
    private long start;
    private long totalTime;
    private boolean isRunning = false;

    public void start() {
        if( isRunning )
            throw new IllegalStateException();

        isRunning = true;
        start = System.currentTimeMillis();
        //System.out.println("start" + start);
    }

    public void end() {
        if( !isRunning )
            throw new IllegalStateException();

        isRunning = false;
        end = System.currentTimeMillis();
        totalTime = System.currentTimeMillis() - start;
        //System.out.println("end" + end);
    }

    public long getGemesseneZeit() {
        if( isRunning )
            throw new IllegalStateException();

        return totalTime;
    }
}

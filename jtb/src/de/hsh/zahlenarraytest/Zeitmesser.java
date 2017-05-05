package de.hsh.zahlenarraytest;


/**
 * Created by jannis on 26.04.17.
 */
public class Zeitmesser {

    private long nanoStart;
    private long nanoEnd;

    private long end;
    private long start;
    private boolean isRunning = false;

    void start() {
        if( isRunning )
            throw new IllegalStateException();

        isRunning = true;
        nanoStart = System.nanoTime();
        start = System.currentTimeMillis();
        System.out.println("start " + start + " ms");
    }

    void end() {
        if( !isRunning )
            throw new IllegalStateException();

        isRunning = false;
        nanoEnd = System.nanoTime();
        end = System.currentTimeMillis();
        System.out.println("end " + end + " ms");
    }

    long getGemesseneZeit() {
        if( isRunning )
            throw new IllegalStateException();

        System.out.println("in ms: "+ (end-start));
        return nanoEnd-nanoStart;
    }
}

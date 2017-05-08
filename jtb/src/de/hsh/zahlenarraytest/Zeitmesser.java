package de.hsh.zahlenarraytest;


/**
 * Created by jannis on 26.04.17.
 */
public class Zeitmesser {
    private long end;
    private long start;
    private boolean isRunning = false;
    private long gesamtzeit;

    /**
     * Starte timer
     */
    public void start() {
        if( isRunning )
            throw new IllegalStateException();

        isRunning = true;
        start = System.currentTimeMillis();
    }

    /**
     * stoppe timer
     */
    public void stop() {
        if( !isRunning )
            throw new IllegalStateException();

        isRunning = false;
        end = System.currentTimeMillis();
        gesamtzeit += end-start;
    }

    /**
     * erhalte timerzeit
     * @return
     */
        public long getGemesseneGesamtzeit() {
        if( isRunning )
            throw new IllegalStateException();

         return gesamtzeit;
    }
}

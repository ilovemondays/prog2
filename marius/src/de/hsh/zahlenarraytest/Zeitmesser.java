package de.hsh.zahlenarraytest;

/**
 * Created by Marius Luding on 03.05.2017 for group 13
 */
public class Zeitmesser {
    private long endTime = 0 ;
    private long startTime = 0;
    private boolean isRunning = false;
    /**
     * startet eine Zeitmessung. Der Zeitmesser befindet sich anschließend im Zustand "läuft".
     */
    public void start(){
        if (isRunning) {
            throw new IllegalStateException();
        }
        this.startTime = System.currentTimeMillis();
        this.isRunning = true; //zeitmesser "gestartet"
        //System.out.println(this.startTime);
    }
    /**
     * beendet eine Zeitmessung. Der Zeitmesser befindet sich anschließend im Zustand "gestoppt".
     */
    public void stop(){
        if (!isRunning){
            throw new IllegalArgumentException();
        }
        this.endTime = System.currentTimeMillis();
        this.isRunning = false; //zeitmesser "gestoppt"
        //System.out.println(this.endTime);
    }

    /**
     *
     * @return Die zwischen start und stop vergangene Zeit
     */
    public long getGemesseneGesamtzeit(){
        if(isRunning) {
            throw new IllegalArgumentException();
        }
        return endTime-startTime;

    }
}

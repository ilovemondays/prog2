package de.hsh.vehicles;

/**
 * Created by Marius Luding on 19.05.2017 for group 13
 */
public class AnsaldoFiremaT68 implements RailVehicle {
    private int gauge = 1435;
    public void operate(){
        System.out.println("Ansaldo Firema T-68 is operating as a light rail passenger vehicle"); //RingRing

    }

    public int trackGauge(){
        return gauge;
    }


}

package de.hsh.vehicles;

/**
 * Created by jannis on 17.05.17.
 */
public class AnsaldoFiremaT68 implements RailVehicle {
    @Override
    public void operate() {
        System.out.println("Ansaldo Firema T-68 is operating as a light rail passenger vehicle");
    }

    @Override
    public int trackGauge() {
        return 1435;
    }
}

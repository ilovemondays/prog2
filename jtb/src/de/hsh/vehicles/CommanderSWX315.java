package de.hsh.vehicles;

/**
 * Created by jannis on 17.05.17.
 */
public class CommanderSWX315 implements RoadRailVehicle {
    @Override
    public void operate() {
        System.out.println("Commander SWX315 is operating as a railcar mover");
    }

    @Override
    public int trackGauge() {
        return 1435;
    }

    @Override
    public int numberOfWheels() {
        return 4;
    }
}

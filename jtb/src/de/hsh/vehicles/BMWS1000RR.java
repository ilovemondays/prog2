package de.hsh.vehicles;

/**
 * Created by jannis on 17.05.17.
 */
public class BMWS1000RR implements RoadVehicle {
    @Override
    public void operate() {
        System.out.println("BMW S1000RR is operating as a sport bike");
    }

    @Override
    public int numberOfWheels() {
        return 2;
    }
}

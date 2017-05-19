package de.hsh.vehicles;

/**
 * Created by Marius Luding on 19.05.2017 for group 13
 */
public class BMWS1000RR implements RoadVehicle {
    private int numberOfWheels = 2;

    @Override
    public int numberOfWheels() {
        return numberOfWheels;
    }

    @Override
    public void operate() {
       System.out.println("BMW S1000RR is operating as a sport bike"); //wrumm wrumm
    }

}

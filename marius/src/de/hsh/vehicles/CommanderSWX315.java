package de.hsh.vehicles;

/**
 * Created by Marius Luding on 19.05.2017 for group 13
 */
public class CommanderSWX315 implements RoadRailVehicle {
    private int gauge = 1435;
    private int wheels = 4;


    public void operate() {
        System.out.println("Commander SWX315 is operating as a railcar mover"); //RingRingWroomWroom
    }

    public int trackGauge() {
        return gauge;
    }

    public int numberOfWheels(){
        return wheels;
    }


}

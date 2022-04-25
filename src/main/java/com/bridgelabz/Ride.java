package com.bridgelabz;

public class Ride {

    public CategoryRide rideType;
    public double distance;
    public int time;

    public Ride(CategoryRide rideType, double distance, int time) {
        this.distance = distance;
        this.time = time;
        this.rideType = rideType;

    }
}

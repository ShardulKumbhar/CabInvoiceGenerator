package com.bridgelabz;

import java.util.Map;

public class InvoiceGenerator {

    /*
    Constants
     */
    private static final int COST_PER_MIN = 1;
    private static final double COST_PER_KM = 10;
    private static final double MIN_FARE = 5;

    /*
    Method To get Actual Fare
     */
    public static double calculateFare(double distance, int time) {
        double fare = (distance * COST_PER_KM) + (time * COST_PER_MIN);
        return Math.max(fare, MIN_FARE);
    }

    /*
    Method to get Multiple ride total fare
     */
    public InvoiceSummary calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += ride.rideType.calculateCategoryFare(ride.distance, ride.time);
        }
        return new InvoiceSummary(totalFare, rides.length);
    }

    /*
    Method to get list of a user using user id
     */
    public InvoiceSummary calculateFare(String userID, Map<String, Ride[]> rideBook) {
        InvoiceSummary totalFare = calculateFare(rideBook.get(userID));
        return totalFare;
    }
}
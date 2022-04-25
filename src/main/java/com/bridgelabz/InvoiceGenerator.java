package com.bridgelabz;

public class InvoiceGenerator {
    /**
     * Created variables
     */
    private static final int MINIMUM_COST_PER_KILOMETER = 10;
    private static final int COST_PER_TIME = 1;
    private static final int MINIMUM_FARE = 5;

    private RideRepository rideRepository;

    /**
     * @param distance-value taking from user
     * @param time-taking    from user
     * @return- fair by calculating
     */
    public double calculateFare(double distance, int time) {
        double fare = distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_TIME;
        /*
        Checking if min fare less than 5 should give minimum 5 fare
         */
        if (fare < MINIMUM_FARE)
            return MINIMUM_FARE;
        return fare;
    }

    /*
    Method to Calculate Fare for Multiple Rides
     */
    public double calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += calculateFare(ride.distance, ride.time);
        }
        return totalFare;
    }

    /*
    Method to get Invoice Summary 
     */
    public InvoiceSummary getInvoiceSummary(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += this.calculateFare(ride.distance, ride.time);
        }
        return new InvoiceSummary(rides.length, totalFare );
    }

    /**
     * create method to calculate total fare as per distance and time
     *
     * @param -distance -distance of per km cost is 10 rs
     * @param -time     -per minute cost is 1rs
     * @return total fare -total fare to be calulated
     */
    public InvoiceGenerator() {
        this.rideRepository = new RideRepository();
    }
    /**
     * method created add Rides for Given a user id
     *
     * @param userId
     * @param ride
     */
    public void addRides(String userId, Ride[] ride) {
        rideRepository.addRide(userId, ride);
    }

    /*
     * returning in voice summary
     */
    public double getInvoiceSummary(String userId) {
        return this.calculateFare(rideRepository.getRides(userId));

    }
}
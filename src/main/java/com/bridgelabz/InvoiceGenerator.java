package com.bridgelabz;

public class InvoiceGenerator {
    /**
     * Created variables
     */
    private static final int MINIMUM_COST_PER_KILOMETER = 10;
    private static final int COST_PER_TIME = 1;
    private static final int MINIMUM_FARE = 5;

    /**
     * @param distance-value taking from user
     * @param time-taking    from user
     * @return- fair by calculating
     */
    public double calculateFare(double distance, int time) {
        double totalFare = distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_TIME;
        /*
        Checking if min fare less than 5 should give minimum 5 fare
         */
        if (totalFare < MINIMUM_FARE)
            return MINIMUM_FARE;
        return totalFare;
    }
}

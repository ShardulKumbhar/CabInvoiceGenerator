package com.bridgelabz;

public enum CategoryRide implements InvoiceService {
    PREMIUM(15.0, 2, 20.0), REGULAR(10.0, 1, 5.0);

    private final double MIN_FARE;
    private final int rate_Per_Min;
    private final double rate_Per_Km;

    /*
    Created Constructor
     */
    CategoryRide(double rate_Per_Km, int rate_Per_Min, double MIN_FARE) {
        this.rate_Per_Km = rate_Per_Km;
        this.rate_Per_Min = rate_Per_Min;
        this.MIN_FARE = MIN_FARE;
    }

    @Override
    public double calculateCategoryFare(double distance, int time) {
        double fare = (distance * rate_Per_Km) + (time * rate_Per_Min);
        return Math.max(fare, MIN_FARE);
    }
}
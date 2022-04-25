package com.bridgelabz;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InvoiceServiceTest {
    public static InvoiceGenerator invoiceGenerator = new InvoiceGenerator();


    /*
      Step 1 Test case - Calculate fare
     */
    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {

        double distance = 2.0;
        int time = 5;
        /**
         * Calculating the fare
         */
        double fare = invoiceGenerator.calculateFare(distance, time);
        assertEquals(25.0, fare, 0.0);
    }

    /*
    Step 1 Test Case for minimum fare should give 5
    */
    @Test
    public void givenDistanceAndTime_ShouldReturnMinFare() {
        double distance = 0.1;
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance, time);
        assertEquals(5, fare);
    }

    /*
     Step 3 - Enhanced Invoice
     calculating total number of rides
     total fare
     Avrage fare per Ride
      */
    @Test
    public void givenMultipleRide_ShouldReturnInvoiceSummary() {
        Ride[] rides = {
                new Ride(CategoryRide.REGULAR, 2, 5),
                new Ride(CategoryRide.REGULAR, 0.1, 1)
        };
        InvoiceSummary summary = invoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(30, 2);
        assertEquals(expectedInvoiceSummary, summary);
    }

    /*
   multiple rides should return the ride summary
    */
    @Test
    public void givenUserIDAndRides_ShouldReturnInvoiceSummary() {
        Map<String, Ride[]> rideBook = new HashMap<>();
        Ride[] rides = {
                new Ride(CategoryRide.REGULAR, 2.0, 5),
                new Ride(CategoryRide.REGULAR, 0.1, 1)
        };
        Ride[] rides1 = {
                new Ride(CategoryRide.REGULAR, 3.0, 5),
                new Ride(CategoryRide.REGULAR, 0.1, 1)
        };
        rideBook.put("Shardul", rides);
        rideBook.put("Kumbhar", rides1);
        String userID = "Shardul";
        InvoiceSummary summary = invoiceGenerator.calculateFare(userID, rideBook);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(30, 2);
        assertEquals(expectedInvoiceSummary, summary);
    }

    /*
    Test Case - 5 Given UserId And Rides of different categories of ride Should return invoice generator
     */
    @Test
    public void givenNormalAndPremiumRideRate_ShouldReturnTotalFare() {
        Map<String, Ride[]> rideBook = new HashMap<>();
        Ride[] rides = {
                new Ride(CategoryRide.PREMIUM, 2.0, 5),
                new Ride(CategoryRide.REGULAR, 0.1, 1)
        };
        Ride[] rides1 = {
                new Ride(CategoryRide.PREMIUM, 3.0, 5),
                new Ride(CategoryRide.REGULAR, 0.1, 1)
        };
        rideBook.put("Shardul", rides);
        rideBook.put("Kumbhar", rides1);
        String userID = "Kumbhar";
        InvoiceSummary summary = invoiceGenerator.calculateFare(userID, rideBook);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(60, 2);
        assertEquals(expectedInvoiceSummary, summary);
    }
}
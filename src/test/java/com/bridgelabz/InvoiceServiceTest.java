package com.bridgelabz;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InvoiceServiceTest {
    InvoiceGenerator invoiceGenerator;

    /*
      Step 1 Test case - Calculate fare
     */
    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        invoiceGenerator = new InvoiceGenerator();
        double distance = 2.0;
        int time = 5;
        /**
         * Calculating the fare
         */
        double fare = invoiceGenerator.calculateFare(distance, time);
        assertEquals(25.0, fare, 0.0);
    }

    /*
     Step 2 Test Case for minimum fare should give 5
     */
    @Test
    public void givenDistanceAndTime_WhenTotalFareLessThan10_ShouldReturnMinimumFare() {
        invoiceGenerator = new InvoiceGenerator();
        double distance = 0.1;
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance, time);
        assertEquals(5.0, fare, 0.0);
    }
}

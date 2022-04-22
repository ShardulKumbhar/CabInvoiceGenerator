package com.bridgelabz;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InvoiceServiceTest {
    InvoiceGenerator invoiceGenerator;

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        invoiceGenerator = new InvoiceGenerator();
        double distance = 2.0;
        int time = 5;
        /**
         * Calculating the fair
         */
        double fare = invoiceGenerator.calculateFare(distance, time);
        assertEquals(25.0, fare, 0.0);
    }


}

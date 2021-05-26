package com.cabinvoice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InvoiceGeneratorTest {
    /**
     * this method will check the totalFare according to the input.
     */
    @Test
    public void givenDistanceAndTime_ShouldReturnTotalfare() {
        InvoiceGenerator invoiceGenerator=new InvoiceGenerator();
        double distance = 2.0;
        int time = 5;
        double totalFare = invoiceGenerator.calculateTotalFare(distance, time);
        Assertions.assertEquals(25,totalFare,0.0);
    }
    /**
     * this method will check the Minimum Fare according to the input.
     */
    @Test
    public void givenLessDistanceAndTime_ShouldReturnMinimumFare() {
        InvoiceGenerator invoiceGenerator=new InvoiceGenerator();
        double distance = 0.1;
        int time = 1;
        double totalFare = invoiceGenerator.calculateTotalFare(distance, time);
        Assertions.assertEquals(5,totalFare,0.0);
    }
    /**
     * this method will check the invoice Summary with multiple rides.
     */
    @Test
    public void givenDistanceAndTIme_WithMultipleRidesCount_ShouldReturnInvoiceSummary() {
        InvoiceGenerator invoiceGenerator=new InvoiceGenerator();
        Ride[] ride1 = {new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        InvoiceSummary summary = invoiceGenerator.calculateFare(ride1);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        Assertions.assertEquals(expectedInvoiceSummary, summary);
    }
    /**
     * this method will check the Invoice Summary Id according to the input.
     */
    @Test
    public void givenUserId_ShouldReturn_InvoiceSummaryWithId() {
        InvoiceGenerator invoiceGenerator=new InvoiceGenerator();
        InvoiceSummaryWithId[] summary1 = {new InvoiceSummaryWithId(1,30.2,1),
                new InvoiceSummaryWithId(2,53.5, 2)
        };
        int id = 1;
        InvoiceSummaryWithId summary = invoiceGenerator.invoiceList(summary1, id);
        InvoiceSummaryWithId expectedInvoiceSummary = new InvoiceSummaryWithId(1,30.2,1);
        Assertions.assertEquals(expectedInvoiceSummary,summary);
    }
    /**
     * this method will check the totalFare according to the Premium Ride category.
     */
    @Test
    public void givenDistanceAndTime_ForPremiumRide_ShouldReturn_TotalFare() {
        InvoiceGenerator invoiceGenerator=new InvoiceGenerator();
        double distance = 2.0;
        int time = 5;
        double fare = invoiceGenerator.calculateTotalFare(distance, time, InvoiceGenerator.Ride_Type.PREMIUM_RIDE);
        Assertions.assertEquals(40,fare,0.0);
    }
    /**
     * this method will check the totalFare according to the Normal Ride category.
     */
    @Test
    public void givenDistanceAndTime_ForNormalRide_ShouldReturn_TotalFare() {
        InvoiceGenerator invoiceGenerator=new InvoiceGenerator();
        double distance = 2.0;
        int time = 5;
        double fare = invoiceGenerator.calculateTotalFare(distance, time, InvoiceGenerator.Ride_Type.NORMAL_RIDE);
        Assertions.assertEquals(25,fare,0.0);
    }
}

package com.cabinvoice;

public class InvoiceGenerator {
    /**
     * Here i have created Enumerate variables.
     */
    public enum Ride_Type {
        NORMAL_RIDE,PREMIUM_RIDE
    }
    /**
     * Here i have created constants which will be used in this whole program.
     */
    private static final double MINIMUM_COST_PER_KM = 10;
    private static final int COST_PER_TIME = 1;
    private static final double MINIMUM_FARE = 5;
    private static final double MINIMUM_COST_PER_KM_PREMIUM_RIDE = 15;
    private static final int COST_PER_TIME_PREMIUM_RIDE = 2;
    private static final double MINIMUM_FARE_PREMIUM_RIDE = 20;
    /**
     * this method will take the below parameter and return TotalFare.
     * @param distance
     * @param time
     * @return totalFare
     */
    public double calculateTotalFare(double distance, int time) {
        double totalFare = distance * MINIMUM_COST_PER_KM + time * COST_PER_TIME;
        return Math.max(totalFare,MINIMUM_FARE);
    }
    /**
     * This is a method whose return type is a class InvoiceSummary and return the totalFare.
     * @param rides
     * @return creating an object of InvoiceSummary by passing the parameters.
     */
    public InvoiceSummary calculateFare(Ride[] rides) {
        double totalfare = 0;
        for (Ride ride:rides) {
            totalfare += calculateTotalFare(ride.distance, ride.time);
        }
        return new InvoiceSummary(rides.length,totalfare);
    }
    /**
     * This is a method whose return type is a class InvoiceSummaryWithId and return the SummaryId.
     * @param summary
     * @param id
     * @return result(variable of InvoiceSummaryWithId class)
     */
    public InvoiceSummaryWithId invoiceList(InvoiceSummaryWithId[] summary, int id) {
        InvoiceSummaryWithId result = null;
        for (InvoiceSummaryWithId summaryWithId : summary) {
            if (summaryWithId.getId() == id )
                result = summaryWithId;
        }
        return result;
    }
    /**
     * This method will take the given parameters and calculate according to enum types.
     * @param distance
     * @param time
     * @param type
     * @return totalFare
     */
    public double calculateTotalFare(double distance, int time, Ride_Type type) {
        double totalFare = 0;
        switch (type) {
            case NORMAL_RIDE:
                totalFare = Math.max(distance * MINIMUM_COST_PER_KM + time * COST_PER_TIME, MINIMUM_FARE);
                break;
            case PREMIUM_RIDE:
                totalFare = Math.max(distance * MINIMUM_COST_PER_KM_PREMIUM_RIDE + time * COST_PER_TIME_PREMIUM_RIDE, MINIMUM_FARE_PREMIUM_RIDE);
                break;
        }
        return totalFare;
    }
}

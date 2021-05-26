package com.cabinvoice;

public class InvoiceSummaryWithId {
    public final double avgFare;
    public final int rides;
    public final double fare;
    private final int id;
    /**
     * this will initialise rides,fare,id as well as avgFare.
     * @param rides
     * @param fare
     * @param id
     */
    public InvoiceSummaryWithId(int rides, double fare, int id) {
        this.rides = rides;
        this.fare = fare;
        this.avgFare = this.fare/this.rides;
        this.id = id;
    }
    /**
     * this method will take the values from the constructor.
     * @return id
     */
    public int getId() {
        return id;
    }
    /**
     * this is an override method from object class which will take object as a parameter.
     * after that it will compare one object with another object.
     * @param o
     * @return comparision
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceSummaryWithId summary = (InvoiceSummaryWithId) o;
        return Double.compare(summary.avgFare, avgFare) == 0 && rides == summary.rides && Double.compare(summary.fare, fare) == 0 && id == summary.id;
    }
}

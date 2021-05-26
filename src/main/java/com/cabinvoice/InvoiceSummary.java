package com.cabinvoice;

public class InvoiceSummary {
    protected   double averagefare;
    protected  int numOfrides;
    protected  double totalFare;
    /**
     * this constructor will take the given parameters and initialise the values and also initialise the average value.
     * @param numOfrides
     * @param totalFare
     */
    public InvoiceSummary(int numOfrides, double totalFare) {
        this.numOfrides = numOfrides;
        this.totalFare = totalFare;
        this.averagefare = this.totalFare/this.numOfrides;
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
        InvoiceSummary summary = (InvoiceSummary) o;
        return Double.compare(summary.averagefare, averagefare) == 0 && numOfrides == summary.numOfrides && Double.compare(summary.totalFare, totalFare) == 0 ;
    }

}

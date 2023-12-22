package org;

public class Summary {

    private double totalFare;
    private int numOfRides;
    private double avgFare;

    public Summary(int numOfRides, int totalFare, double avgFare) {
        this.numOfRides = numOfRides;
        this.totalFare = totalFare;
        this.avgFare = avgFare;
    }

    public Summary() {
    }

    public void setTotalFare(double calculateMultipleRidesFare) {
        this.totalFare = calculateMultipleRidesFare;
    }

    public void setNumberOfRides(int length) {
        this.numOfRides = length;
    }

    public void setAvgFare() {
        if (this.numOfRides != 0) {
            avgFare = totalFare / numOfRides;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Summary other = (Summary) obj;
        if (Double.doubleToLongBits(totalFare) != Double.doubleToLongBits(other.totalFare))
            return false;
        if (numOfRides != other.numOfRides)
            return false;
        if (Double.doubleToLongBits(avgFare) != Double.doubleToLongBits(other.avgFare))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Summary [totalFare=" + totalFare + ", numOfRides=" + numOfRides + ", avgFare=" + avgFare + "]";
    }

}

package org;

import java.util.HashMap;

public class InvoiceGenerator {

    private static final int COST_PER_UNIT_KILO = 10;
    private static final int COST_PER_MIN = 1;
    private static final double MIN_FARE = 5;

    private static final int PREMIUM_COST_PER_UNIT_KILO = 15;
    private static final int PREMIUM_COST_PER_MIN = 2;
    private static final double PREMIUM_MIN_FARE = 20;

    HashMap<String, Summary> map = new HashMap<String, Summary>();

    public double calculateFare(int distance, int time, String type) {
        double fare = 0;
        if (type.equals("normal")) {
            fare = distance * COST_PER_UNIT_KILO + time * COST_PER_MIN;
            fare = Math.max(fare, MIN_FARE);
        } else {
            fare = distance * PREMIUM_COST_PER_UNIT_KILO + time * PREMIUM_COST_PER_MIN;
            fare = Math.max(fare, PREMIUM_MIN_FARE);
        }
        return fare;
    }

    public double calculateMultipleRidesFare(Ride[] rides) {
        double fare = 0;
        for (Ride ride : rides) {
            fare += calculateFare(ride.getDistance(), ride.getTime(), ride.getType());
        }
        return fare;
    }

    public Summary generateInvoiceSummary(Ride[] rides) {
        Summary summary = new Summary();

        summary.setTotalFare(this.calculateMultipleRidesFare(rides));
        summary.setNumberOfRides(rides.length);
        summary.setAvgFare();

        return summary;
    }

    public void addRides(String userID, Ride[] rides) {
        Summary summary = new Summary();
        summary = generateInvoiceSummary(rides);
        map.put(userID, summary);
    }

    public Summary getInvoiceSummary(String userID) {
        if (!map.containsKey(userID))
            throw new IllegalArgumentException("No invoice found for this User ID");
        return map.get(userID);
    }

}

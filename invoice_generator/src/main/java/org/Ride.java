package org;

public class Ride {
    private int distance;
    private int time;
    String type;

    public int getDistance() {
        return distance;
    }

    public int getTime() {
        return time;
    }

    public Ride(int distance, int time, String type) {
        this.distance = distance;
        this.time = time;
        this.type = type;
    }

    public String getType() {
        return type;
    }

}

// Copyright (c) 2026 Sujan. All rights reserved.

public class Ride {
    private final int rideId;
    private final String pickup;
    private final String drop;
    private final double fare;

    public Ride(int rideId, String pickup, String drop, double fare) {
        if (pickup == null || pickup.trim().isEmpty()) {
            throw new IllegalArgumentException("Pickup location cannot be empty.");
        }
        if (drop == null || drop.trim().isEmpty()) {
            throw new IllegalArgumentException("Drop location cannot be empty.");
        }
        if (fare < 0) {
            throw new IllegalArgumentException("Fare cannot be negative.");
        }

        this.rideId = rideId;
        this.pickup = pickup.trim();
        this.drop = drop.trim();
        this.fare = fare;
    }

    public int getRideId() {
        return rideId;
    }

    public String getPickup() {
        return pickup;
    }

    public String getDrop() {
        return drop;
    }

    public double getFare() {
        return fare;
    }

    public boolean matchesLocation(String location) {
        if (location == null) {
            return false;
        }

        String searchText = location.trim();
        return pickup.equalsIgnoreCase(searchText) || drop.equalsIgnoreCase(searchText);
    }

    @Override
    public String toString() {
        return "Ride ID: " + rideId
                + " | Pickup: " + pickup
                + " | Drop: " + drop
                + " | Fare: Rs." + String.format("%.2f", fare);
    }
}

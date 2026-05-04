// Copyright (c) 2026 Sujan. All rights reserved.

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final RideHistory rideHistory = new RideHistory();

    public static void main(String[] args) {
        int choice;

        do {
            showMenu();
            choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1 -> addRide();
                case 2 -> deleteLastRide();
                case 3 -> displayRides();
                case 4 -> searchRide();
                case 5 -> reverseHistory();
                case 0 -> System.out.println("Thank you for using Ride Booking History System.");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    private static void showMenu() {
        System.out.println();
        System.out.println("===== Ride Booking History System =====");
        System.out.println("1. Add new ride");
        System.out.println("2. Cancel last ride");
        System.out.println("3. View all rides");
        System.out.println("4. Search ride by location");
        System.out.println("5. Reverse ride history");
        System.out.println("0. Exit");
    }

    private static void addRide() {
        int rideId = readInt("Enter ride ID: ");
        String pickup = readText("Enter pickup location: ");
        String drop = readText("Enter drop location: ");
        double fare = readDouble("Enter fare: ");

        rideHistory.addRide(new Ride(rideId, pickup, drop, fare));
        System.out.println("Ride added successfully.");
    }

    private static void deleteLastRide() {
        Ride deletedRide = rideHistory.deleteLastRide();

        if (deletedRide == null) {
            System.out.println("No ride available to cancel.");
        } else {
            System.out.println("Cancelled last ride:");
            System.out.println(deletedRide);
        }
    }

    private static void displayRides() {
        System.out.println();
        System.out.println("Ride History (" + rideHistory.getSize() + " ride(s)):");
        rideHistory.displayRides();
    }

    private static void searchRide() {
        String location = readText("Enter location to search: ");
        System.out.println();
        System.out.println("Search Results:");

        boolean found = rideHistory.searchRide(location);
        if (!found) {
            System.out.println("No rides found for location: " + location);
        }
    }

    private static void reverseHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println("No rides available to reverse.");
            return;
        }

        rideHistory.reverseHistory();
        System.out.println("Ride history reversed successfully.");
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }

    private static double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                double value = Double.parseDouble(scanner.nextLine().trim());
                if (value < 0) {
                    System.out.println("Amount cannot be negative.");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid amount.");
            }
        }
    }

    private static String readText(String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = scanner.nextLine().trim();

            if (!value.isEmpty()) {
                return value;
            }

            System.out.println("This field cannot be empty.");
        }
    }
}

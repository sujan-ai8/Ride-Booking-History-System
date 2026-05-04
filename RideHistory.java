// Copyright (c) 2026 Sujan. All rights reserved.

public class RideHistory {
    private Node head;
    private Node tail;
    private int size;

    public void addRide(Ride ride) {
        if (ride == null) {
            throw new IllegalArgumentException("Ride cannot be null.");
        }

        Node newNode = new Node(ride);

        if (head == null) {
            head = newNode;
            tail = newNode;
            size++;
            return;
        }

        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public Ride deleteLastRide() {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            Ride deletedRide = head.ride;
            head = null;
            tail = null;
            size--;
            return deletedRide;
        }

        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }

        Ride deletedRide = current.next.ride;
        current.next = null;
        tail = current;
        size--;
        return deletedRide;
    }

    public void displayRides() {
        if (head == null) {
            System.out.println("No rides found.");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.println(current.ride);
            current = current.next;
        }
    }

    public boolean searchRide(String location) {
        boolean found = false;
        Node current = head;

        while (current != null) {
            if (current.ride.matchesLocation(location)) {
                System.out.println(current.ride);
                found = true;
            }
            current = current.next;
        }

        return found;
    }

    public void reverseHistory() {
        Node previous = null;
        Node current = head;
        tail = head;

        while (current != null) {
            Node nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }

        head = previous;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int getSize() {
        return size;
    }
}

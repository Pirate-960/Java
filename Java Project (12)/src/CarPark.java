//-----------------------------------------//
// Student Name: Abdelrahman Zahran
// Student ID: 150120998
//-----------------------------------------//
// Purpose of the program:
//  - Implement a CarPark class to manage parking spaces, vehicles, and tickets in a car park.
//-----------------------------------------//
// Imported Libraries
import java.util.Date;

public class CarPark {
    // Instance variables to store car park capacity, arrays for park places and tickets, and hourly price
    private int capacity;
    public ParkPlace[] parkPlaceArray;
    public Ticket[] ticketArray;
    private double hourlyPrice;

    // Constructor to initialize the CarPark object with specified capacity and hourly price
    public CarPark(int capacity, double hourlyPrice) {
        this.capacity = capacity;
        this.hourlyPrice = hourlyPrice;
        this.parkPlaceArray = new ParkPlace[capacity];
        this.ticketArray = new Ticket[capacity];
    }

    // Method to park a vehicle in the car park and generate a ticket
    public Ticket parkVehicle(Vehicle vehicle, Date entryDate) {
        int totalSize = 0;

        // Calculate the total size of vehicles currently in the park
        for (ParkPlace place : parkPlaceArray) {
            if (place != null) {
                totalSize += place.getSize();
            }
        }

        // Check if there is enough space in the car park
        if (totalSize + vehicle.getSize() > capacity) {
            System.out.println("Car park is full!");
            return null;
        }

        // Create a new ParkPlace object with the Vehicle object
        for (int i = 0; i < capacity; ++i) {
            if (parkPlaceArray[i] == null) {
                parkPlaceArray[i] = new ParkPlace(vehicle);
                Ticket ticket = new Ticket(vehicle, entryDate);
                ticketArray[i] = ticket;
                System.out.println("The vehicle with " + vehicle.getPlateNumber() + " plate number is parked.");

                return ticket;
            }
        }
        return null;
    }

    // Method to exit a vehicle from the car park and calculate the parking fee
    public Vehicle exitVehicle(Ticket ticket, Date exitDate) {
        int indexOfParkedVehicle = -1;

        // Find the index of the parked vehicle
        for (int i = 0; i < parkPlaceArray.length; ++i) {
            if (parkPlaceArray[i] != null && parkPlaceArray[i].getVehicle().getPlateNumber().equals(ticket.getVehicle().getPlateNumber())) {
                indexOfParkedVehicle = i;
                break;
            }
        }

        if (indexOfParkedVehicle != -1) {
            if (exitDate != null) {
                ticket.calculatePrice(hourlyPrice, exitDate);
                System.out.println("The price for vehicle with " + ticket.getVehicle().getPlateNumber()
                        + " plate number is: " + ticket.getPrice() + " TLs");

                // Only add the ticket to the array if it's not already there
                if (!containsTicket(ticket)) {
                    ticketArray[indexOfParkedVehicle] = ticket;
                }
            }

            capacity += parkPlaceArray[indexOfParkedVehicle].getSize();
            parkPlaceArray[indexOfParkedVehicle] = null;

            return ticket.getVehicle();
        }

        return null;
    }

    // Helper method to check if a ticket is already in the ticketArray
    private boolean containsTicket(Ticket ticket) {
        for (Ticket t : ticketArray) {
            if (t != null && t.equals(ticket)) {
                return true;
            }
        }
        return false;
    }

    // Method to calculate the total income generated from parking fees
    public double getTotalIncome() {
        double totalIncome = 0;
        for (Ticket ticket : ticketArray) {
            if (ticket != null) {
                if (ticket.getPrice() != 0) {
                    totalIncome += ticket.getPrice();
                }
            }
        }

        return totalIncome;
    }

    // Method to print the information of vehicles currently parked in the car park
    public void printVehicleList() {
        for (ParkPlace place : parkPlaceArray) {
            if (place != null) {
                System.out.print(place.getVehicle().getVehicleInfo());
            }
        }
    }

    // Method to print the information of issued tickets
    public void printTickets() {
        for (Ticket ticket : ticketArray) {
            if (ticket != null) {
                System.out.print(ticket.getTicketInfo());
            }
        }
    }
}
//-----------------------------------------//

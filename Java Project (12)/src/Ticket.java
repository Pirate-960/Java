//-----------------------------------------//
// Student Name: Abdelrahman Zahran
// Student ID: 150120998
//-----------------------------------------//
// Purpose of the program:
//  - Define a Ticket class to represent parking tickets with information about vehicles, entry and exit dates, and pricing.
//-----------------------------------------//
// Imported Libraries
import java.util.Date;

public class Ticket {
    // Instance variables to store information about the vehicle, entry and exit dates, total price, and a counter for the number of tickets
    private Vehicle vehicle;
    private Date entryDate;
    private Date exitDate;
    private double totalPrice;
    public static int numberOfTickets;

    // Constructor to create a Ticket object with a specified vehicle and entry date
    public Ticket(Vehicle vehicle, Date entryDate) {
        this.vehicle = vehicle;
        this.entryDate = entryDate;
        numberOfTickets++;
    }

    // Method to calculate the parking price based on hourly rate and exit date
    public double calculatePrice(double hourlyPrice, Date exitDate) {
        double parkingCost = 0;
        double numberOfHours = 0;
        this.exitDate = exitDate;

        if (exitDate != null && entryDate != null) {
            // Calculate the difference in milliseconds between exit and entry dates
            long diffInMilliseconds = exitDate.getTime() - entryDate.getTime();
            // Convert the difference to hours and round up to the nearest hour
            numberOfHours = Math.ceil(diffInMilliseconds / (60.0 * 60.0 * 1000.0));
            // Ensure non-negative hours
            if (numberOfHours < 0) {
                numberOfHours = 0;
            }
            // Calculate the parking cost based on vehicle size, hourly rate, and hours parked
            parkingCost = vehicle.getSize() * hourlyPrice * numberOfHours;
        }

        // Set the total price
        totalPrice = parkingCost;

        return totalPrice;
    }

    // Method to retrieve formatted ticket information
    public String getTicketInfo() {
        StringBuilder info = new StringBuilder();

        // Check if the exit date is available
        if (exitDate != null) {
            // Calculate the hours parked
            long hours = (exitDate.getTime() - entryDate.getTime()) / (60 * 60 * 1000);
            // Append ticket information with exit details and fee
            info.append(
                    "Ticket Info\n" +
                            "Plate Number : " + vehicle.getPlateNumber() + "\n" +
                            "Entry : " + entryDate + "\n" +
                            "Exit  : " + exitDate + "\n" +
                            "Hour  : " + hours + "\n" +
                            "Fee   : " + totalPrice + " TLs\n"
            );
        } else {
            // Append ticket information with only entry details
            info.append(
                    "Ticket Info\n" +
                            "Plate Number : " + vehicle.getPlateNumber() + "\n" +
                            "Entry : " + entryDate + "\n"
            );
        }

        return info.toString();
    }

    // Getter method to retrieve the associated vehicle
    public Vehicle getVehicle() {
        return vehicle;
    }

    // Getter method to retrieve the total price
    public double getPrice() {
        // Check if the exit date is available
        if (exitDate != null) {
            return totalPrice;
        } else {
            return 0;
        }
    }
}
//-----------------------------------------//

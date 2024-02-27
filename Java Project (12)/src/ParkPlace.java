//-----------------------------------------//
// Student Name: Abdelrahman Zahran
// Student ID: 150120998
//-----------------------------------------//
// Purpose of the program:
//  - Define a ParkPlace class to represent a parking place for a vehicle.
//-----------------------------------------//
// Imported Libraries

public class ParkPlace {
    // Instance variables to store the size of the park place and the associated vehicle
    private int size;
    private Vehicle vehicle;

    // Constructor to initialize the ParkPlace object with a specified vehicle
    public ParkPlace(Vehicle vehicle) {
        // Set the size of the park place based on the size of the associated vehicle
        this.size = vehicle.getSize();
        // Set the associated vehicle
        this.vehicle = vehicle;
    }

    // Getter method to retrieve the size of the park place
    public int getSize() {
        return size;
    }

    // Getter method to retrieve the associated vehicle
    public Vehicle getVehicle() {
        return vehicle;
    }
}
//-----------------------------------------//

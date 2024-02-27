//-----------------------------------------//
// Student Name: Abdelrahman Zahran
// Student ID: 150120998
//-----------------------------------------//
// Purpose of the program:
//  - Define a Vehicle class to represent vehicles with plate numbers and sizes.
//-----------------------------------------//
// Imported Libraries

public class Vehicle {
    // Instance variables to store plate number and size of the vehicle
    private String plateNumber;
    private int size;

    // Constructor to initialize the Vehicle object with plate number and size
    public Vehicle(String plateNumber, int size) {
        this.plateNumber = plateNumber;
        this.size = size;
    }

    // Getter method to retrieve the plate number
    public String getPlateNumber() {
        return plateNumber;
    }

    // Getter method to retrieve the size of the vehicle
    public int getSize() {
        return size;
    }

    // Method to get a formatted string containing vehicle information
    public String getVehicleInfo() {
        StringBuilder info = new StringBuilder();
        
        info.append(
                "Vehicle Info\n" + 
                "Plate Number : " + plateNumber + "\n" +
                "Size : " + size + "\n"
                );
        
        return info.toString();
    }
}
//-----------------------------------------//

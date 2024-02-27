//-----------------------------------------//
// Student Name: Abdelrahman Zahran
// Student ID: 150120998
//-----------------------------------------//
// Purpose of the program:
//  - The program simulates a car park system with vehicles, parking spaces, and tickets, tracking entries, exits, and total income.
//-----------------------------------------//
// Imported Libraries
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        // a. Create a new CarPark object with the capacity of 10 and the hourly price of 5 TLs.
        CarPark carPark = new CarPark(10, 5.0);

        // b. Create 5 vehicles with different license plate numbers and sizes.
        Vehicle vehicle1 = new Vehicle("34KG3916", 4);
        Vehicle vehicle2 = new Vehicle("34GV8993", 2);
        Vehicle vehicle3 = new Vehicle("34AN4876", 1);
        Vehicle vehicle4 = new Vehicle("50FF444", 2);
        Vehicle vehicle5 = new Vehicle("XXYYZZZ", 4);

        // c. Vehicles try to enter the car park with one-hour delays.
        Date entryDate1 = new Date(); // Current time
        Date entryDate2 = new Date(entryDate1.getTime() + 3600000); // 1 hour later
        Date entryDate3 = new Date(entryDate2.getTime() + 3600000); // 2 hours later
        Date entryDate4 = new Date(entryDate3.getTime() + 3600000); // 3 hours later
        Date entryDate5 = new Date(entryDate4.getTime() + 3600000); // 4 hours later

        // d. Assume that the car park is filled with the first four vehicles.
        carPark.parkVehicle(vehicle1, entryDate1);
        carPark.parkVehicle(vehicle2, entryDate2);
        carPark.parkVehicle(vehicle3, entryDate3);
        carPark.parkVehicle(vehicle4, entryDate4);

        // Attempt to park the fifth vehicle (car park is full)
        carPark.parkVehicle(vehicle5, entryDate5);

        // e. Print the content of the vehicle list at that time.
        // System.out.println("After initial entries:");
        carPark.printVehicleList();

        // f. After a while, all vehicles exit from the car park after 5 hours.
        Date exitDate1 = new Date(entryDate1.getTime() + 18000000); // 5 hours later
        Date exitDate2 = new Date(entryDate2.getTime() + 18000000); // 5 hours later
        Date exitDate3 = new Date(entryDate3.getTime() + 18000000); // 5 hours later
        Date exitDate4 = new Date(entryDate4.getTime() + 18000000); // 5 hours later
        Date exitDate5 = new Date(entryDate5.getTime() + 18000000); // 5 hours later

        carPark.exitVehicle(carPark.ticketArray[0], exitDate1);
        carPark.exitVehicle(carPark.ticketArray[1], exitDate2);
        
        // e. Print the content of the vehicle list at that time.
        // System.out.println("After some exits:");
        carPark.printVehicleList();
        
        carPark.exitVehicle(carPark.ticketArray[2], exitDate3);
        carPark.exitVehicle(carPark.ticketArray[3], exitDate4);
        carPark.exitVehicle(carPark.ticketArray[4], exitDate5);

        // g. Print the content of the vehicle list after all exits.
        // System.out.println("After all exits:");
        carPark.printVehicleList();

        // h. Print the total income earned until now.
        System.out.println("Total Income: " + carPark.getTotalIncome());

        // i. Print the total number of tickets processed until now.
        System.out.println("Total number of vehicles: " + Ticket.numberOfTickets);

        // j. Print the details of each ticket.
        carPark.printTickets();
    }
}
//-----------------------------------------//

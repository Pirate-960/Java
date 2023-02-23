package homework123;
import java.util.Scanner;
// Scanner is in the java.util package
public class HW1_O150120998_P1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Student Name: Abdelrahman Zahran
		// Student Number: O150120998
		// Problem(1): A program that calculates the cost of a driving trip.
		
		// Create a Scanner object(System.in) -> to take input from the user(The standard input device).
		Scanner input = new Scanner(System.in);
		
		//(System.out.print) -> the standard output device.
		
		// Prompt the user to Enter the driving distance:
		System.out.print("Enter the driving distance of the trip :" + " ");
		// Declare a double variable (theDrivingDistance) 
		double theDrivingDistance = input.nextDouble();
		
		// Prompt the user to Enter miles per gallon:
		System.out.print("Enter miles per gallon :" + " ");
		// Declare a double variable (milesPerGallon)
		double milesPerGallon = input.nextDouble();  
		
		// Prompt the user to Enter price per gallon:
		System.out.print("Enter price per gallon :" + " ");
		// Declare a double variable (pricePerGallon)
		double pricePerGallon = input.nextDouble(); 
		
		// Compute The cost of driving = (The driving distance * Price per gallon )/ Miles per gallon
		//Declare a double variable (theCostOfDriving)
		double theCostOfDriving = ( theDrivingDistance * pricePerGallon ) / milesPerGallon ;
		
		// Display the result of the cost of the driving distance for the trip.
		// Type Casting the result (The cost of driving ) casting double -> integer.
		// from double data type into integer data type (Narrowing - Explicit Casting).
		System.out.println("The cost of driving is :" + " " + "$" + (int)( theCostOfDriving * 100) / 100.0);
		
		// This program uses End-of-line style. 
	}

}

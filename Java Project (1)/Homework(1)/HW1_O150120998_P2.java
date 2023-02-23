package homework123;
import java.util.Scanner;
// Scanner is in the java.util package
public class HW1_O150120998_P2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Student Name: Abdelrahman Zahran
		// Student Number: O150120998
		// Problem(2): A program that converts number of days into a date.
		//This program has a logic error when displaying months on the console. 
		
		// Create a Scanner object(System.in) -> to take input from the user(The standard input device)
		Scanner input = new Scanner(System.in);
		
		//(System.out.print) -> the standard output device.
		
		// Prompt the user to Enter Number of days:
		System.out.print("Enter Number of days:" + " ");
		// Declare an integer variable (numberOfDays)
		int numberOfDays = input.nextInt(); 
		
		// Computing number of years
		// Declare an integer variable (numberOfYears)
		int numberOfYears = numberOfDays / 365 ; 
		
		// Computing number of months out of the remain number of days after computing number of years.
		// Declare an integer variable (numberOfMonths)
		int numberOfMonths = ( numberOfDays % 365 ) / 31 ; 
		
		// Computing number of the remain number of days after computing number of months and number of years.
		// Declare an integer variable (numberOfRemainingDays)
		int numberOfRemainingDays = ((numberOfDays % 365) % 31); 
		
		// Display the result
		System.out.print("Year: " + numberOfYears + ",");
		System.out.print(" Month: " + numberOfMonths + ",");
		System.out.print(" Day: " + numberOfRemainingDays + ",");
		
		// This program uses End-of-line style. 
	}

}

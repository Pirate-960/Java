//-----------------------------------------//
// Student Name: Abdelrahman Zahran
// Student ID: 150120998
//-----------------------------------------//
// Purpose of the program:
//  - Computation of the number of bits in the binary representation of N.
//  - If the input is negative, it prints "Illegal input."
//  - If the input is 0, the program ends.
//-----------------------------------------//
// Imported Libraries
import java.util.Scanner;
//-----------------------------------------//
public class Pro1_150120998 {

	public static void main(String[] args) {
		// Create a Scanner object for user input
		Scanner input = new Scanner(System.in);
		
		// Continuously prompt the user for input until terminated
		while (true) {
			System.out.print("Enter an integer number: ");
			// Read the user input as an integer
			int integer = input.nextInt();
			
			// Check if the input is 0 to terminate the program
			if (integer == 0) {
				System.out.println("Program ends. Bye");
				break;
			// Handle the case where the input is negative
			} else if (integer < 0) {
				System.out.println("The number of bits: Illegal input");
			} else {
				// Count the number of bits using a while loop
				int count = 0;
				// Continue dividing the integer by 2 until it is less than 1
				while (integer >= 1) {
					integer = integer / 2;
					// Increment the count for each division
					count ++;
				}
				// Print the result
				System.out.println("The number of bits: " + count);
			}
			
		}
		
	}

}
//-----------------------------------------//
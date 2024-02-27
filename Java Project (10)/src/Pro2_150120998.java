//-----------------------------------------//
// Student Name: Abdelrahman Zahran
// Student ID: 150120998
//-----------------------------------------//
// Purpose of the program:
//  - A program that computes a number series which starts with 0, 1, and 2, and each
//  - successive number is the summation of the sine, cosine, and tangent values of previous
//  - three numbers.
//-----------------------------------------//
// Imported Libraries
import java.util.Scanner;
//-----------------------------------------//
public class Pro2_150120998 {

	public static void main(String[] args) {
		// Create a Scanner object for user input
		Scanner input = new Scanner(System.in);
		
		// Prompt the user to enter the length of the series
		System.out.print("Enter the length of the series: ");
		int seriesLength = input.nextInt();
		
		// Initialize the first three numbers in the series
		double num_1 = 0;
		double num_2 = 1;
		double num_3 = 2;
		
		// Display the initial three numbers in the series
		System.out.print(num_1 + " " + num_2 + " " + num_3 + " ");
		
		// Initialize the variable for the next number in the series
		double next_Number = 0;
		
		// Loop to calculate and display the series
		for (int i = 4; i <= seriesLength; ++i) {
			// Calculate the next number in the series based on the formula
			next_Number = Math.sin(num_1) + Math.cos(num_2) + Math.tan(num_3);
			
			// Update the values for the three numbers in the series
			num_1 = num_2;
			num_2 = num_3;
			num_3 = next_Number;
			
			// Check if it's the last iteration to adjust formatting
			if (i == seriesLength) {
				// Display the rounded result without a trailing space
				System.out.print(Math.round(next_Number * 100.0) / 100.0);
			} else {
				// Display the rounded result with a trailing space
				System.out.print(Math.round(next_Number * 100.0) / 100.0 + " ");
			}			
		}
	}
}
//-----------------------------------------//
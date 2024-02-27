//-----------------------------------------//
// Student Name: Abdelrahman Zahran
// Student ID: 150120998
//-----------------------------------------//
// Purpose of the program:
//  - Print an specific pattern using a mix of numbers and characters.
//-----------------------------------------//
// Imported Libraries
import java.util.Scanner;
//-----------------------------------------//
public class Pro3_150120998 {

    public static void main(String[] args) {
    	// Variable to store user's choice to continue or not
    	String yesOrNo = "Y";
    	// Create a Scanner object to read input from the user
    	Scanner input = new Scanner(System.in);
    	
    	// Display welcome message
    	System.out.println("Welcome to the Num-Char printer program:");
    	System.out.println("===================================");
		
    	// Prompt the user to enter the size of the pattern
    	System.out.print("Enter the size: ");
		int size = input.nextInt();
		
		// Outer loop to handle the entire program execution
    	do {
    		// Check if the entered size is greater than 0
    		if (size > 0) {
    			// Loop to print the top half of the pattern
    			for (int i = 1; i <= size; ++i) {
    				// Loop to print spaces before the numbers
    				for (int j = 1; j <= size - i; ++j) {
    					System.out.print("  ");
    				}
    				// Loop to print ascending numbers
    				for (int k = 1; k <= i; ++k) {
    					System.out.print(k + " ");
    				}
    				// Loop to print descending characters ('A' and above)
    				for (char l = (char)('A' + i - 2); l >= 'A'; --l) {
    					System.out.print(l + " ");
    				}
    				// Move to the next line after printing each line
    				System.out.println();
    			}
    			
    			// Loop to print the bottom half of the pattern
    			for (int i = size - 1; i >= 1; --i) {
    				// Loop to print spaces before the numbers
    				for (int j = 1; j <= size - i; ++j) {
    					System.out.print("  ");
    				}
    				// Loop to print ascending numbers
    				for (int k = 1; k <= i; ++k) {
    					System.out.print(k + " ");
    				}
    				// Loop to print descending characters ('A' and above)
    				for (char l = (char) ('A' + i - 2); l >= 'A'; --l) {
    					System.out.print(l + " ");
    				}
    				// Move to the next line after printing each line
    				System.out.println();
    			}
    			
    			// Prompt the user to continue or exit the program
    			System.out.print("Would you like to continue? (Y or N): ");
    			yesOrNo = input.next();
    			
    			// Check user's choice to continue or exit
    			if (yesOrNo.equals("Y")) {
    				// If 'Y', prompt the user to enter a new size
    				System.out.print("Enter the size: ");
    				size = input.nextInt();
    			} else if (yesOrNo.equals("N")) {
    				// If 'N', display program termination message and break out of the loop
    				System.out.print("Program ends. Bye :)");
    				break;
    			} else {
    				// In case input not 'Y' or 'N'
    				System.out.println("Invalid Input!");
    				continue;
    			}
    		// If the entered size is negative, prompt the user to enter a valid size
    		} else if (size < 0) {
    			
    			System.out.print("Invalid size. Enter the size again: ");
    			size = input.nextInt();
    		}
    	// Continue the loop as long as the user chooses 'Y'	
    	} while(yesOrNo.equals("Y"));
    }
}
//-----------------------------------------//
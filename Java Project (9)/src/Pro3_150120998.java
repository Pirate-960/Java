//-----------------------------------------//
// Student Name: Abdelrahman Zahran
// Student ID: 150120998
//-----------------------------------------//
// Purpose of the program:
//  - A simple calculator takes two numbers and an operator as input 
//  - Uses a switch-case statement to perform the corresponding mathematical operation.
//-----------------------------------------//
// Imported Libraries
import java.util.Scanner;
//-----------------------------------------//
public class Pro3_150120998 {

	public static void main(String[] args) {
		// Create a Scanner object to take input from the user
		Scanner Input = new Scanner(System.in);
		
		// Prompt the user to enter the first number.
		System.out.print("Enter the first number: ");
		double first_Number = Input.nextDouble();
		
		// Prompt the user to enter the operator.
		System.out.print("Enter the operator (+, -, *, /): ");
		String operator = Input.next();
		
		// Prompt the user to enter the second number.
		System.out.print("Enter the second number: ");
		double second_Number = Input.nextDouble();
		
		// Declare a variable of double type to store the result value
		double Result = 0;
		
		// Using switch-case statements to perform mathematical operations.
		switch (operator) {
		// Addition
			case "+":
				Result = first_Number + second_Number;
				// Print Result Value
				// Type Casting the result --- casting double -> integer.
				// from double data type into integer data type (Narrowing - Explicit Casting).
				System.out.print("Result: " + ((int)(Result * 100.0)) / 100.0);
				break;
		// Subtraction		
			case "-":
				Result = first_Number - second_Number;
				// Print Result Value
				// Type Casting the result --- casting double -> integer.
				// from double data type into integer data type (Narrowing - Explicit Casting).
				System.out.print("Result: " + ((int)(Result * 100.0)) / 100.0);
				break;
		// Multiplication
			case "*":
				Result = first_Number * second_Number;
				// Print Result Value
				// Type Casting the result --- casting double -> integer.
				// from double data type into integer data type (Narrowing - Explicit Casting).
				System.out.print("Result: " + ((int)(Result * 100.0)) / 100.0);
				break;
		// Division
			case "/":
				if (second_Number != 0) {
					Result = first_Number / second_Number;
					// Print Result Value
					// Type Casting the result --- casting double -> integer.
					// from double data type into integer data type (Narrowing - Explicit Casting).
					System.out.print("Result: " + ((int)(Result * 100.0)) / 100.0);
				} else {
					System.out.print("Error: Division by zero is not allowed.");
					// System.exit(1);
				}
				break;
		// Invalid Operator 		
			default:
				System.out.print("Invalid operator. Please enter +, -, *, or /.");
				break;
		}
		
		// Print Result Value
		// System.out.print("Result: " + ((int)(Result * 100.0)) / 100.0);
	}
	
}
//-----------------------------------------//
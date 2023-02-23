package homework123;
import java.util.Scanner;
// Scanner is in the java.util package
public class HW1_O150120998_P3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Student Name: Abdelrahman Zahran
		// Student Number: O150120998
		// Problem(3): A program that calculates the compound monthly interest.
		
		// Create a Scanner object(System.in) -> to take input from the user(The standard input device)
		Scanner input = new Scanner(System.in);
		
		//(System.out.print) -> the standard output device.
		
		// Prompt the user to Enter the initial principal in TL/USD (P),
		System.out.print("Enter the initial principal in TL/USD (P):" + " ");
		// Declare a double variable (initialPrincipal)
		double initialPrincipal = input.nextDouble(); 
		
		// Prompt the user to Enter the annual interest rate percentage (R),
		System.out.print("Enter the annual interest rate percentage (R):" + " ");
		// Declare a double variable (annualInterestRatePercentage)
		double annualInterestRatePercentage = input.nextDouble();
		
		// Prompt the user to Enter the number of time periods in months (T),
		System.out.print("Enter the number of time periods in months (T):"+ " ");
		// Declare a double variable (numberOfTimePeriodsInMonths)
		double numberOfTimePeriodsInMonths = input.nextDouble();
		
		// Compute the monthly interest rate percentage (R/12)
		// Declare a double variable (monthlyInterestRatePercentage)
		double monthlyInterestRatePercentage = annualInterestRatePercentage / 12 ;
		
		// Compute the final balance amount in TL/USD
		// Declare a double variable (finalBalanceAmount)
		double finalBalanceAmount = initialPrincipal * 
				Math.pow( 1 + annualInterestRatePercentage / 1200 , numberOfTimePeriodsInMonths);
				
		// Compute the total compound interest amount in TL/USD
		// Declare a double variable (totalCompoundInterestAmount)
		double totalCompoundInterestAmount = finalBalanceAmount - initialPrincipal ;
		
		// Display the result
		// Type Casting the result (The cost of driving ) casting double -> integer.
		// from double data type into integer data type (Narrowing - Explicit Casting).
		System.out.println("The initial principal amount:" + " " +
		        (int)( initialPrincipal * 100) / 100.0 );
		System.out.println("The monthly interest rate percentage:" + " " + 
		        (int)(monthlyInterestRatePercentage * 100 ) / 100.0 );
		System.out.println("The total compound interest amount in TL/USD:" + " " + 
				(int)(totalCompoundInterestAmount * 100) / 100.0);
		System.out.println("The final balance amount in TL/USD:" + " " + 
				(int)(finalBalanceAmount * 100) / 100.0);
		
		// This program uses End-of-line style. 
	}

}

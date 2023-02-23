import java.util.Scanner;
//Scanner is in the java.util package
public class HW4_Q1_150120998 {

	//---------------------------------------------------------------------------------//
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Student Name: Abdelrahman Zahran.
		// Student Number: 150120998.
		//Problem(1):
		/** A program that calculates the invoice of each flat in an apartment building. 
		 * Assume that there are N flats in a building and apartment heating is the central system. 
		 * 30% of bill will be shared equally among the flats, the rest 70% will be shared according to the consumption of each flat.
		 */
		
		// Create a Scanner object(System.in) -> to take input from the user(The standard input device).
		Scanner input = new Scanner(System.in);
		
		// Prompt the user to enter the number of flats.
		int userInput = input.nextInt();
		double [] flats = new double [userInput];
		
		// Printing the number of flats + amount of consumption of each flat + total bill to console.
		System.out.print(userInput);
		// Prompt the user to enter the consumption for each flat in sequence as a form of an array.
		for (int n = 0; n < userInput; ++n) {
			flats[n] = input.nextDouble();
			System.out.print(" " + flats[n]);
		}
		
		// Prompt the user to enter the Total bill of the consumption.
		double totalBill = input.nextDouble();
		System.out.println(" " +totalBill);
		
		// Invoking the calculateTheInvoice method to calculate the bill for each flat.
		double[] bills = calculateTheInvoice(flats, totalBill);
		// Invoking the printBills Method to print the results on the console.
		printBills(bills);
		}
	//---------------------------------------------------------------------------------//
	/** calculateTheInvoice Method to calculate the bill for each flat */
	public static double[] calculateTheInvoice(double[] flats, double totalBill) {
		int numberOfFlats = flats.length;
		double[] billsOfFlats = new double[numberOfFlats];
		
		// Calculating 30% of the bill of each flat.
		double percent30 = totalBill * 0.3;
		double sharedPartOfBillOf30 = percent30 / numberOfFlats;
							
		// Calculating 70% of the total bill.
		double percent70 = totalBill * 0.7;
		
		// Calculating the total consumption of the flats.
		double consumptionOfFlats = 0;
		for (int y = 0; y < numberOfFlats; ++y) {
			consumptionOfFlats += flats[y]; 
		}
		
		// Calculating 70% of the bill of each flat.
		double sharedPartOfBillOf70 = percent70 / consumptionOfFlats;
		
		// Calculating The bill of each flat.
		for (int x = 0; x < numberOfFlats; ++x) {
			billsOfFlats[x] = sharedPartOfBillOf30 + flats[x] * sharedPartOfBillOf70;
		}				 
		// Obtaining the value of the bill of each flat.		
		return billsOfFlats;		
		}

	//---------------------------------------------------------------------------------//
	/** printBills Method to print the result to the console when invoked by the main method.*/
	public static void printBills(double[] bills) {
		// Printing the array bills.
		for(int j = 0; j < bills.length; ++j) {
			System.out.println("Flat #" + (j+1) +": " + (int)(bills[j] * 100) / 100.0);
		}
	}
	//---------------------------------------------------------------------------------//
}
//This program uses End-of-line style.
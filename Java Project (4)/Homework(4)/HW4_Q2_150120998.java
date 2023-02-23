import java.util.Scanner;
//Scanner is in the java.util package
public class HW4_Q2_150120998 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Student Name: Abdelrahman Zahran.
		// Student Number: 150120998.
		//Problem(2):
		/** A program that will determine whether or not it is valid per the Luhn formula. 
		 * The Luhn algorithm is a simple checksum formula used to validate a variety of identification numbers(credit card numbers). 
		 * The task is to check if a given string is valid.
		 * */
		// Create a Scanner object(System.in) -> to take input from the user(The standard input device).
		Scanner input = new Scanner(System.in);
		System.out.print("Enter LUHN number: ");
		
		// Prompt the user to enter some values to a variabvle of type String.
		String number = input.next();
		
		try {
		if (!validateNumber(number)) {
            System.out.println("Number is Invalid");
            }
		else {
			System.out.println("Number is Valid");
			}
		}
		catch (NumberFormatException e) {
			System.out.println("Invalid Input !");
		}
		
	}
	public static boolean validateNumber(String number) {
		// Using one dimensional array to split the numbers
		String digits[] = number.split("\\s+");
		String num = "";
		
		for (String digit : digits) {
			num += digit;
			Integer.parseInt(digit);
	}
		String DNumber = "", LNumber = "";
        int sumOfNumbers = 0; 
        int value = 0;
        boolean test = false;
        for (int i = num.length() - 1; i >= 0; i--) {
        	//
            if (test) {
            	// Calculating the DNumber.
                DNumber = num.charAt(i) + DNumber;
                value = 2 * (num.charAt(i) - '0');
                
                //
                if (value > 9) 
                	value -= 9;
                LNumber = value + LNumber;
            } 
         // Calculating the LNumber.
            else {
            	DNumber = "_" + DNumber;
                LNumber = num.charAt(i) + LNumber;
                value = (num.charAt(i) - '0');
            }
            sumOfNumbers += value;
            test = !test;
        }
        // Print the calculation to the console.
        System.out.println("DNumber: "+DNumber);
        System.out.println("LNumber: "+LNumber);
        
        // Returns the value of the sum.
        return sumOfNumbers%10==0;
	}
}
//This program uses End-of-line style.

import java.util.Scanner;
//Scanner is in the java.util package
public class HW2_150120998_P1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Student Name: Abdelrahman Zahran
		// Student Number: 150120998
		// Problem (1): A program that checks ISBN-10. An ISBN-10 (International Standard Book Number) consists of 10 digits for identifying books.
		
		// Create a Scanner object(System.in) -> to take input from the user(The standard input device).
		Scanner input = new Scanner(System.in);
		
		// (System.out.print) -> the standard output device.
		
		// Prompt the user to Enter the first 9 digits of an ISBN as integer :
		System.out.print("Enter the first 9 digits of an ISBN as integer:" + " ");
		// Declare an integer variable (numbersFromOneToNine) of the ISBN-10
		int numbersFromOneToNine = input.nextInt();
		
		// Declare an integer variable (A)
		int A = ( numbersFromOneToNine % 1000000000 ) / 100000000 ;
		// Declare an integer variable (B)
		int B = ( numbersFromOneToNine % 100000000 ) / 10000000 ;
		// Declare an integer variable (C)
		int C = ( numbersFromOneToNine % 10000000 ) / 1000000 ;
		// Declare an integer variable (D)
		int D = ( numbersFromOneToNine % 1000000 ) / 100000 ;
		// Declare an integer variable (E)
		int E = ( numbersFromOneToNine % 100000 ) / 10000 ;
		// Declare an integer variable (F)
		int F = ( numbersFromOneToNine % 10000 ) / 1000 ;
		// Declare an integer variable (K)
		int K = ( numbersFromOneToNine % 1000 ) / 100 ;
		// Declare an integer variable (L)
		int L = ( numbersFromOneToNine % 100 ) / 10 ;
		// Declare an integer variable (M)
		int M = numbersFromOneToNine % 10;
		// Declare an integer variable (Z) 
		int Z = (( A *  1 ) + ( B * 2 ) + ( C * 3 ) + ( D * 4 ) + ( E * 5 ) + ( F * 6 ) + ( K * 7 ) + ( L * 8 ) + ( M * 9 )) % 11 ;
		
		// Display the result
		if( Z == 10)
			System.out.print("The ISBN-10 number is:" + " " + A + B + C + D + E + F + K + L + M + "X");
		else
			System.out.print("The ISBN-10 number is:" + " " + A + B + C + D + E + F + K + L + M + Z );
		
		// This program uses End-of-line style.
	}

}

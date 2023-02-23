
import java.util.Scanner;
//Scanner is in the java.util package
public class HW2_150120998_P2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Student Name: Abdelrahman Zahran
		// Student Number: 150120998
		// Problem (2): A program that expresses Zeller’s congruence which is an algorithm developed by Christian Zeller to calculate the day of the week.
		
		// Create a Scanner object(System.in) -> to take input from the user(The standard input device).
		Scanner input = new Scanner(System.in);
		
		// (System.out.print) -> the standard output device.
		
		// Prompt the user to Enter the year of the day.
		System.out.print("Enter year (e.g. 2012): ");
		// Declare an integer variable (yearOfTheDay)
		int yearOfTheDay = input.nextInt();
		
		// Prompt the user to Enter the month of the day.
		System.out.print("Enter month (e.g. 1-12): ");
		// Declare an integer variable (monthOfTheDay)
		int monthOfTheDay = input.nextInt();
		
		// Prompt the user to Enter the day of the month.
		System.out.print("Enter the day of the month (e.g. 1-31): ");
		// Declare an integer variable (dayOfTheMonth)
		int dayOfTheMonth = input.nextInt();
		
		// Declare an integer variable (centuryOfTheDay)
		int centuryOfTheDay = yearOfTheDay / 100 ;
		
		// Convert the user input from 1 to 13 and 2 to 14 for the month and change the year to the previous year.
		if( monthOfTheDay == 1 ){
			monthOfTheDay = 13 ;
		yearOfTheDay = yearOfTheDay - 1 ;
		}
		if(monthOfTheDay == 2 ){
			monthOfTheDay = 14 ;
		yearOfTheDay = yearOfTheDay - 1 ;
		}
		
		// Declare an integer variable (dayOfTheWeek) 
		int dayOfTheWeek = (dayOfTheMonth + ((26 * ( monthOfTheDay + 1 )) / 10 ) + ( yearOfTheDay % 100 ) + (( yearOfTheDay % 100 ) / 4) 
				+ ( centuryOfTheDay / 4 ) + ( 5 * centuryOfTheDay)) % 7 ;
		
		// Display the result using switch statement. 
		switch( dayOfTheWeek ){
		case 0 :
			System.out.print("Day of the week is: Saturday");
			break;
		case 1 :
			System.out.print("Day of the week is: Sunday");
			break;
		case 2 :
			System.out.print("Day of the week is: Monday");
			break;
		case 3 :
			System.out.print("Day of the week is: Tuesday");
			break;
		case 4 :
			System.out.print("Day of the week is: Wednesday");
			break;
		case 5 :
			System.out.print("Day of the week is: Thursday");
			break;
		case 6 :
			System.out.print("Day of the week is: Friday");
		}
		// This program uses End-of-line style.

	}

}


import java.util.Scanner;
//Scanner is in the java.util package
public class HW2_150120998_P3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Student Name: Abdelrahman Zahran
		// Student Number: 150120998
		// Problem (3): A program that calculates personal income tax based on the given tax rates reported by The Turkish Revenue Administration in the last 4 years.
		
		// Create a Scanner object(System.in) -> to take input from the user(The standard input device).
		Scanner input = new Scanner(System.in);
				
		// (System.out.print) -> the standard output device.
				
		// Prompt the user to Enter the year which the tax is calculated in it.
		// Declare a double variable (yearTax)
		double yearTax = input.nextInt();
		
		// Prompt the user to Enter the amount of income through a specific year.
		// Declare a double variable (amountOfIncome)
		double amountOfIncome = input.nextDouble();
		
		// Specifying years of income to calculate tax for it.
		if(yearTax < 2017 || yearTax > 2020) {
			System.out.println("Undefined year value");
			System.exit((int)yearTax);}
		else {
		
		// Determining the case of the income out of 4 years.
		if(amountOfIncome <= 0) {
			System.out.println("Income must be > 0");
			System.exit((int)yearTax);}
		else {
			System.out.println("Income: " + amountOfIncome);
		
		// Declare a double variable (tax)
		double tax = 0;
		
		// Computing the tax for income in year 2017
		if(yearTax == 2017 ){
				if(amountOfIncome < 13000 )
					tax = amountOfIncome * 0.15 ;
				else if(amountOfIncome < 30000)
					tax = 1950 + (amountOfIncome - 13000) * 0.20 ;
				else if(amountOfIncome < 110000)
					tax = 5350 + (amountOfIncome - 30000) * 0.27 ;
				else if(amountOfIncome >= 110000)
					tax = 26950 + (amountOfIncome - 110000) * 0.35 ;
				}
		
		// Computing the tax for income in year 2018
		if(yearTax == 2018 ){
				if(amountOfIncome < 14800)
					tax = amountOfIncome * 0.15 ;
				else if(amountOfIncome < 34000)
					tax = 2220 + (amountOfIncome - 14800) * 0.20 ;
				else if(amountOfIncome < 120000)
					tax = 6060 + (amountOfIncome - 34000) * 0.27 ;
				else if(amountOfIncome >= 120000)
					tax = 29280 + (amountOfIncome - 120000) * 0.35 ;
				}
		
		// Computing the tax for income in year 2019
		if(yearTax == 2019 ){
					if(amountOfIncome < 18000)
					tax = amountOfIncome * 0.15 ;
				else if(amountOfIncome < 40000)
					tax =  2700 + (amountOfIncome - 18000) * 0.20 ;
				else if(amountOfIncome < 148000)
					tax =  7100 + (amountOfIncome - 40000) * 0.27 ;
				else if(amountOfIncome < 500000)
					tax = 36260 + (amountOfIncome - 148000) * 0.35 ;
				else if(amountOfIncome >= 500000)
					tax = 159460 + (amountOfIncome - 500000) * 0.40 ;
		}
		
		// Computing the tax for income in year 2020
		if(yearTax == 2020 ){
			if(amountOfIncome < 22000 )
				tax = amountOfIncome * 0.15 ;
			else if(amountOfIncome < 49000)
				tax = 3300 + (amountOfIncome - 22000) * 0.20 ;
			else if(amountOfIncome < 180000)
				tax = 8700 + (amountOfIncome - 49000 ) * 0.27 ;
			else if(amountOfIncome < 600000)
				tax = 44070 + (amountOfIncome - 180000) * 0.35 ;
			else if(amountOfIncome >= 600000)
				tax = 191070 + (amountOfIncome - 600000) * 0.40 ;	
		}
		
		// Display the result 
		System.out.println("Tax amount: " + (int)(tax * 100) / 100.0);
		
		// Declare a double variable (amountOfIncomeAfterTax)
		// Type Casting the result (amountOfIncomeAfterTax) casting double -> integer.
		// from double data type into integer data type (Narrowing - Explicit Casting).
		double amountOfIncomeAfterTax = amountOfIncome - tax ;
		System.out.println("Income after Tax: " + (int)( amountOfIncomeAfterTax * 100 ) /100.0);
		
		// Declare a double variable (realTaxRate)
		// Type Casting the result (realTaxRate) casting double -> integer.
		// from double data type into integer data type (Narrowing - Explicit Casting).
		double realTaxRate = (tax / amountOfIncome) * 100 ;
		System.out.println("Real tax rate: " + (int)( realTaxRate * 100 ) / 100.0 + "%");
		
		// This program uses End-of-line style.
		}
		}	
		
	}

}

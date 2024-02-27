//-----------------------------------------//
// Student Name: Abdelrahman Zahran
// Student ID: 150120998
//-----------------------------------------//
// Purpose of the program: 
//  - Output the equation of the perpendicular bisector of the line segment between two points.
//-----------------------------------------//
// Imported Libraries
import java.util.Scanner;
//-----------------------------------------//
public class Pro2_150120998 {

	public static void main(String[] args) {
		// Create a Scanner object to take input from the user
		Scanner Input = new Scanner(System.in);
		
		// Input coordinates of two points
		// Prompt the user to enter the first point
		System.out.print("Enter the value of x1: ");
		double X1 = Input.nextDouble();
		
		System.out.print("Enter the value of y1: ");
		double Y1 = Input.nextDouble();
		
		// Prompt the user to enter the second point
		System.out.print("Enter the value of x2: ");
		double X2 = Input.nextDouble();
		
		System.out.print("Enter the value of y2: ");
		double Y2 = Input.nextDouble();
		
		// Calculate the slope of the line segment
		double Slope_Of_Line = (Y2 - Y1) / (X2 - X1);
		
		// Calculate the coordinates of the midpoint
		double Midpoint_X = (X1 + X2) / 2;
		double Midpoint_Y = (Y1 + Y2) / 2;
		
		// Calculate the slope of the perpendicular bisector
		double Slope_Of_Perpendicular_Bisector = -1 / Slope_Of_Line;
		
		// Calculate the y-intercept of the perpendicular bisector
		double Y_Intercept = Midpoint_Y - Slope_Of_Perpendicular_Bisector * Midpoint_X;
		
		// Print the output and the equation of the perpendicular bisector of the line segment between two points.
		// Type Casting the result --- casting double -> integer.
		// from double data type into integer data type (Narrowing - Explicit Casting).
		System.out.print("The equation of the perpendicular bisector of the line segment between (" 
		+ X1 + "," + Y1 + ") and (" + X2 + "," + Y2 
		+ ") is y = " + ((int)(Slope_Of_Perpendicular_Bisector * 100.0)) /100.0  
		+ "x + " + ((int)(Y_Intercept * 100.0)) / 100.0);
	}

}
//-----------------------------------------//
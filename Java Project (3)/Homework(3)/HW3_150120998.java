import java.util.Scanner;
//Scanner is in the java.util package
public class HW3_150120998 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Student Name: Abdelrahman Zahran.
		// Student Number: 150120998.
		//Problem(1): This program allows the user to obtain the graph of five geometric shapes on the coordinates system (10x10) -> (1)Line. (2)Triangle. (3)Rectangle. (4)Parabola. (5)Circle.  
		
		// Create a Scanner object(System.in) -> to take input from the user(The standard input device).
		Scanner input = new Scanner(System.in);

		//-----------------------------------------------------------------------------------------------------//
		// Statements given to user to the user to let him choose a case out of these six cases.
		System.out.println("Which shape would you like to draw?");
		System.out.println("1. Line");
		System.out.println("2. Triangle");
		System.out.println("3. Rectangle");
		System.out.println("4. Parabola");
		System.out.println("5. Circle");
		System.out.println("6.Exit");
		
		// Prompt the user to enter a case out of the mentioned 6 cases before.
		int userInput = input.nextInt();
		System.out.println();
		
		// Using the while loop To keep asking the user to enter any case out of the mentioned 6 cases -> (To get its graph).
		while ( userInput != 6 ) {
		//-----------------------------------------------------------------------------------------------------//
			
		// Case(1): User input = 1 -> Line case.
		if (userInput == 1) {
			// Prompt the user to enter the coefficients of the line (using integer values).
			System.out.println("Line formula is y = ax + b");
			System.out.print("Please enter the coefficients a and b: ");
			// Coefficients of the line(int).
			int coefficientOfLine1 = input.nextInt(); //a
			int coefficientOfLine2 = input.nextInt(); //b
			
			// Empty line.
			System.out.println();
			// Graphing the plane (Coordinates system) and the line using loops.
			for(int y = 10; y >= -11; y--) {
				for(int x = -10; x <= 11; x++) {
					// Graphing the x-axis + (x of the line).
					if( y == 0 ) {
						if ((coefficientOfLine1 * x + coefficientOfLine2) == 0) // linear equation.
							System.out.print("*");
						else if (x == 0)
							System.out.print("|");
						else if (x == 11)
							System.out.print("x");
						else
							System.out.print("-");
					}
					// Graphing the y-axis + (y of the line).
					else if ((coefficientOfLine1 * x + coefficientOfLine2) == y) // linear equation.
						System.out.print("*");
					else if (x == 0) {
						if (y == 10)
							System.out.print("y");
						else
							System.out.print("|");
					}
					else 
						System.out.print(" ");
					}
		System.out.println("");
		}
		}
		
		//-----------------------------------------------------------------------------------------------------//
		
		// Case(2): User input = 2 -> Triangle case.
		if (userInput == 2) {
			// Prompt the user to enter the coordinates of the points for three vertices (integer values).
			System.out.println("For triangle, we need the coordinates of the points for three vertices.");
			System.out.print("Please enter the coordinates of 3 vertices a, b, c, d, e, f: ");
			// Prompt the user to enter the coordinates of the point (1)
			double triangleVertex1X = input.nextDouble(); // a
			double triangleVertex1Y = input.nextDouble(); // b
			// Prompt the user to enter the coordinates of the point (2)
			double triangleVertex2X = input.nextDouble(); //c
			double triangleVertex2Y = input.nextDouble(); //d
			// Prompt the user to enter the coordinates of the point (3)
			double triangleVertex3X = input.nextDouble(); //e
			double triangleVertex3Y = input.nextDouble(); //f
			
			// Empty line.
			System.out.println();
			
			// Graphing the plane (Coordinates system) and the triangle using loops and invoking the math ceil method to get real numbers out of the double values entered by the user. 
			for (int y = 10; y >= -11; y--) {
	    		for (int x = -10; x <= 11; x++) {
	    			if (x == 0) {
	    				// Graphing the y-axis + (y of the line) + calculating the slopes of the vertex between its 2 points in y-direction. 
	    				if (y - triangleVertex1Y == Math.ceil((triangleVertex2Y - triangleVertex1Y) / (triangleVertex2X - triangleVertex1X) * (0 - triangleVertex1X)) 
	    						&& y < triangleVertex2Y 
	    						&& y > triangleVertex1Y 
	    						&& x < triangleVertex2X 
	    						&& x > triangleVertex1X)
	    					System.out.print("*");
	    				else if (y - triangleVertex2Y == Math.ceil((triangleVertex2Y - triangleVertex3Y) / (triangleVertex2X - triangleVertex3X) * (0 - triangleVertex2X)) 
	    						&& y < triangleVertex2Y
	    						&& y >= triangleVertex3Y 
	    						&& x <= triangleVertex3X 
	    						&& x >= triangleVertex2X)
	    					System.out.print("*");
	    				else if (y - triangleVertex1Y == Math.ceil((triangleVertex1Y - triangleVertex3Y) / (triangleVertex1X - triangleVertex3X) * (0 - triangleVertex1X)) 
	    						&& x <= triangleVertex3X 
	    						&& x >= triangleVertex1X)
	    					System.out.print("*");
	    				else if (y == triangleVertex2Y)
	    					System.out.print("*");
	    				else if (y == 10)
	    					System.out.print("y");
	    				else
	    					System.out.print("|");
	    			}
	    			// Graphing the x-axis + (x of the line) + calculating the slopes of the vertex between its 2 points in x-direction.
	    			else if (y == 0) {
	    				// Slope between point 2 and 1.
	    				if ((0 - triangleVertex1Y) == Math.ceil((triangleVertex2Y - triangleVertex1Y) / (triangleVertex2X - triangleVertex1X) * (x - triangleVertex1X)) 
	    						&& y < triangleVertex2Y 
	    						&& y >= triangleVertex1Y 
	    						&& x <= triangleVertex2X
	    						&& x >= triangleVertex1X)
	    					System.out.print("*");
	    				// Slope between point 2 and 3.
	    				else if ((0 - triangleVertex2Y) == Math.ceil((triangleVertex2Y - triangleVertex3Y) / (triangleVertex2X - triangleVertex3X) * (x - triangleVertex2X))
	    						&& y < triangleVertex2Y 
	    						&& y >= triangleVertex3Y 
	    						&& x <= triangleVertex3X 
	    						&& x >= triangleVertex2X)
	    					System.out.print("*");
	    				// Slope between point 1 and 3.
	    				else if ((0 - triangleVertex1Y) == Math.ceil((triangleVertex1Y - triangleVertex3Y) / (triangleVertex1X - triangleVertex3X) * (x - triangleVertex1X)) 
	    						&& x <= triangleVertex3X 
	    						&& x >= triangleVertex1X)
	    					System.out.print("*");
	    				else if (x == 0)
	    					System.out.print("|");
	    				else if (x == 11)
	    					System.out.print("x");
	    				else
	    					System.out.print("-");
	    			}
	    			// Connecting the points of the triangle on the graph by completing the vertexes from point to another in a pattern.
	    			else if ((y - triangleVertex1Y) == Math.ceil((triangleVertex2Y - triangleVertex1Y) / (triangleVertex2X - triangleVertex1X) * (x - triangleVertex1X)) 
	    					&& y < triangleVertex2Y 
	    					&& y >= triangleVertex1Y 
	    					&& x <= triangleVertex2X 
	    					&& x >= triangleVertex1X)
						System.out.print("*");
	    			else if ((y - triangleVertex2Y) == Math.ceil((triangleVertex2Y - triangleVertex3Y) / (triangleVertex2X - triangleVertex3X) * (x - triangleVertex2X)) 
							&& y < triangleVertex2Y 
							&& y >= triangleVertex3Y 
							&& x <= triangleVertex3X 
							&& x >= triangleVertex2X)
						System.out.print("*");
					else if ((y - triangleVertex1Y) == Math.ceil((triangleVertex1Y - triangleVertex3Y) / (triangleVertex1X - triangleVertex3X) * (x - triangleVertex1X)) 
							&& x <= triangleVertex3X 
							&& x >= triangleVertex1X)
						System.out.print("*");
	    			else
	    				System.out.print(" ");
	    		}
	    		System.out.println();
	    	}
			
		}
		
		//-----------------------------------------------------------------------------------------------------//
		
		// Case(3): User input -> Rectangle case.
		if (userInput == 3) {
			// Prompt the user to enter the coordinates of the points for three vertices (integer values).
			System.out.println("For rectangle, we need the coordinates of the points for three vertices.");
			System.out.print("Please enter the coordinates of 3 vertices a, b, c, d, e, f: ");
			// Prompt the user to enter the coordinates of point (1)
			int rectangleVertex1X = input.nextInt(); //a
			int rectangleVertex1Y = input.nextInt(); //b
			// Prompt the user to enter the coordinates of point (2)
			int rectangleVertex2X = input.nextInt(); //c
			int rectangleVertex2Y = input.nextInt(); //d
			// Prompt the user to enter the coordinates of point (3)
			int rectangleVertex3X = input.nextInt(); //e
			int rectangleVertex3Y = input.nextInt(); //f
			
			// Obtaining the x coordinate from the other points.
			// Obtaining the y coordinate from the other points.
			int rectangleVertex4X = rectangleVertex3X * -1;
			int rectangleVertex4Y = rectangleVertex3Y;
			
			// The cases that achieve graphing the rectangle using 3 points. 
			if (rectangleVertex1X == rectangleVertex3X && rectangleVertex1Y == rectangleVertex2Y) {
				rectangleVertex4X = rectangleVertex2X;
				rectangleVertex4Y = rectangleVertex3Y;
			}
			else if (rectangleVertex2X == rectangleVertex3X && rectangleVertex1Y == rectangleVertex2Y) {
				rectangleVertex4X = rectangleVertex1X;
				rectangleVertex4Y = rectangleVertex3Y;
			}
			else if (rectangleVertex1X == rectangleVertex2X && rectangleVertex1Y == rectangleVertex3Y) {
				rectangleVertex4X = rectangleVertex3X;
				rectangleVertex4Y = rectangleVertex2Y;
			}
			else if (rectangleVertex3X == rectangleVertex1X && rectangleVertex3Y == rectangleVertex2Y) {
				rectangleVertex4X = rectangleVertex2X;
				rectangleVertex4Y = rectangleVertex1Y;
			}
			else if (rectangleVertex3X == rectangleVertex2X && rectangleVertex3Y == rectangleVertex1X) {
				rectangleVertex4X = rectangleVertex1X;
				rectangleVertex4Y = rectangleVertex2Y;
			}
			else if (rectangleVertex1X == rectangleVertex2X && rectangleVertex2Y == rectangleVertex3Y) {
				rectangleVertex4X = rectangleVertex3X;
				rectangleVertex4Y = rectangleVertex1Y;
			}
			else if(rectangleVertex1X == rectangleVertex2X * -1 && rectangleVertex1Y == rectangleVertex2Y) {
				rectangleVertex4X = rectangleVertex3X * -1;
				rectangleVertex4Y = rectangleVertex3Y;
			}
			else if((rectangleVertex1X != (rectangleVertex2X * -1)) 
					|| (rectangleVertex3X != (rectangleVertex4X * -1)) 
					|| (rectangleVertex1Y != rectangleVertex2Y) 
					|| (rectangleVertex3Y != rectangleVertex4Y)) {
			// Checking that the coordinates given by the user can construct a rectangle or not.
			// In case the coordinates of the points can't construct a rectangle.
			System.out.println("These coordinates of the points can't construct the shape of an rectangle correctly.");
			System.exit(0);
			}
			
			// In case the coordinates of the points can construct a rectangle.
			
			// Empty line.
			System.out.println();
			
			// Graphing the plane (Coordinates system) and the rectangle using loops + limiting the rectangle shape using the coordinates of the points.			
			System.out.printf("%11s",'y');			
			for (int y = 10 ; y > -11 ; y--) {		
				System.out.println();		
				for (int x = -10 ; x < 11 ; x++) {	
					// Graphing the x-axis + (x of the rectangle) & Graphing the y-axis + (y of the rectangle).	
					if (((rectangleVertex1Y == y && rectangleVertex2Y == y) && (rectangleVertex1X <= x && rectangleVertex2X >= x)) 
							|| ((rectangleVertex3Y == y && rectangleVertex4Y == y) && (rectangleVertex3X <= x && rectangleVertex4X >= x)) 
							|| ((rectangleVertex1X == x && rectangleVertex3X == x) && (rectangleVertex3Y <= y && rectangleVertex1Y >= y)) 
							|| ((rectangleVertex2X == x && rectangleVertex4X == x) && (rectangleVertex4Y <= y && rectangleVertex2Y >= y)) ){	
						System.out.print("*");
						}
					else if(x == 0)
						System.out.print("|");
					else if(y == 0) {								
						System.out.print("-");
						if(y == 0 && x == 10)
							System.out.print("x");							
					}			
					else
						System.out.print(" ");
					}
				}
			System.out.println();
			}
		
		//-----------------------------------------------------------------------------------------------------//
		
		// Case(4): User input -> Parapola case.
		if (userInput == 4) {
			// Prompt the user to enter the coefficients of the parabola for the equation (2th degree) + (using integer values).
			System.out.println("Parabola formula is y = ax^2 + bx + c");
			System.out.print("Please enter the coefficients a, b and c: ");
			// Prompt the user to enter the coefficients of the parabola for the equation (2th degree).
			int coefficientOfParabola1 = input.nextInt();
			int coefficientOfParabola2 = input.nextInt();
			int coefficientOfParabola3 = input.nextInt();
			
			// Empty line.
			System.out.println();
			
			// Graphing the plane (Coordinates system) and the Parapola of a second degree equation using loops.
			for(int i = 10; i >= -11; i--) {
				for(int j = -10; j <= 11; j++) {
					// Graphing the x-axis + (x of the Parapola).
					if( i == 0) {
						if (( coefficientOfParabola1 * Math.pow(j,2) + coefficientOfParabola2 * j + coefficientOfParabola3 ) == 0) // Parapola equation of (2th degree).
							System.out.print("*");
						else if ( j == 0)
							System.out.print("|");
						else if ( j == 11)
							System.out.print("x");
						else
							System.out.print("-");
					}
					// Graphing the y-axis + (y of the Parabola).
					else if (( coefficientOfParabola1 * Math.pow(j,2) + coefficientOfParabola2 * j + coefficientOfParabola3 ) == i) // Parapola equation of (2th degree).
						System.out.print("*");
					else if ( j == 0) {
						if ( i == 10)
							System.out.print("y");
						else
							System.out.print("|");
					}
					else
						System.out.print(" ");
					}
		System.out.println("");
		}
		}
		
		//-----------------------------------------------------------------------------------------------------//
		
		// Case(5): User input -> Circle case.
		if (userInput == 5) {
			// Prompt the user to enter the coordinates of the center (a,b) and the radius + (using integer values).
			System.out.println("Circle formula is (x-a)^2 + (y-b)^2 = r^2");
			System.out.print("Please enter the coordinates of the center (a,b) and the radius: ");
			// Prompt the user to enter the coordinates of the center (a,b).
			int circleCenterX = input.nextInt();
			int circleCenterY = input.nextInt();
			// Prompt the user to enter the radius of the circle.
			int radiusOfCircle = input.nextInt();
			
			// Empty line.
			System.out.println();
			
			// Graphing the plane (Coordinates system) and the circle of center point (a,b) and the length of radius using the general equation of the circle.
			for(int m = 10; m >= -11; m--) {
				for(int n = -10; n <= 11; n++) {
					// Graphing the x-axis + (x of the circle).
					if (m == 0) {
						if (Math.pow((n - circleCenterX) , 2) + Math.pow((m - circleCenterY) , 2) == Math.pow(radiusOfCircle , 2)) // General equation of circle.
							System.out.print("*");
						else if (n == 0)
							System.out.print("|");
						else if (n == 11)
							System.out.print("x");
						else
							System.out.print("-");
						}
					// Graphing the y-axis + (y of the circle).
					else if (Math.pow((n - circleCenterX) , 2) + Math.pow((m - circleCenterY) , 2) == Math.pow(radiusOfCircle , 2)) // General equation of circle.
						System.out.print("*");
					else if (n == 0) {
						if (m == 10)
							System.out.print("y");
						else
							System.out.print("|");
					}
					else
						System.out.print(" ");
					}
		System.out.println("");
		}
		}
		
		//-----------------------------------------------------------------------------------------------------//
		
		// Case(6): User input -> None case.
		else if (userInput == 6) {
			// Using break to exit the loop.
			System.exit(0);
			break;
		}
		//-----------------------------------------------------------------------------------------------------//
		
		// Empty line.
		System.out.println();
		// Statements given to user to the user to let him choose a case out of these six cases.				
		System.out.println("Which shape would you like to draw?");				
		System.out.println("1. Line");		
		System.out.println("2. Triangle");		
		System.out.println("3. Rectangle");		
		System.out.println("4. Parabola");		
		System.out.println("5. Circle");		
		System.out.println("6.Exit");
				
		
		// Prompt the user to enter a case out of the mentioned 6 cases before.
		userInput = input.nextInt();
		System.out.println();		
		//-----------------------------------------------------------------------------------------------------//
		}				
	}	
}

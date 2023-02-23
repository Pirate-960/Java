import java.util.Scanner;
//Scanner is in the java.util package
public class HW4_Q3_150120998 {
/** Main Method*/
	//---------------------------------------------------------------------------------//
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Student Name: Abdelrahman Zahran.
		// Student Number: 150120998.
		//Problem(3):
		/** A program that takes an input letter and outputs it in a diamond shape. 
		 * Given a letter, it prints a diamond starting with 'A', 
		 * with the supplied letter at the widest point. 
		 * */
		// Create a Scanner object(System.in) -> to take input from the user(The standard input device).
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a letter: ");
		// Prompt the user to enter the letter.
		String chLetters = input.nextLine();
		
		// Eliminating the invalid inputs.
		if (!((chLetters != null) && chLetters.length() == 1 && (!chLetters.equals("")) && (chLetters.matches("^[a-zA-Z]*$")))) {
			System.out.println("Invalid Input !");
			System.exit(0);
		}
		
		// Closing the input.
		input.close();
		
		// Invoking constructDiamond Method to get the value of the chars array in order to construct the diamond.
		char[][] diamondShape = constructDiamond(chLetters.toUpperCase().charAt(0));
		
		// Invoking the printDiamond Method to print the diamond shape on the console.
		printDiamond(diamondShape);
	}
	//---------------------------------------------------------------------------------//
	/** constructDiamond Method to determine and construct the shape of the diamond using the letters entered by the user.*/
	public static char[][] constructDiamond(char letter) {
		// Declaring a variable with type char.
		int ch = letter;
		int indexOfChar = ch - 65;
		int row = (2 * indexOfChar) + 1;
		int col = row;
		char alphabetOfLetters = 65;
		
		// Using 2-dimensional arrays to construct the shape of the diamond.
		char [][] diamondConstruction = new char [row][col];
		
		//
		int countOfDimensions = 0;
		boolean test = false;
		
		// Computing the rows of the diamond shape.
		for (int k = 0; k < row ; ++k) {
			if (indexOfChar == 0)
				countOfDimensions = 0;
			else if (countOfDimensions < indexOfChar && test == false)
				countOfDimensions = k;
			else {
				countOfDimensions--;
				test = true;
			}
			
			// Computing the columns of the diamond shape.
			for (int z = 0; z < col ; ++z) {
				if ( z == indexOfChar - countOfDimensions || z == indexOfChar + countOfDimensions) {
					// Drawing the vertices of the diamonds using letters.
					diamondConstruction[k][z] = alphabetOfLetters;
				}
				else {
					// Printing the left area (has no characters) with points to fill in the shape and the area around it.
					diamondConstruction[k][z] ='.';
				}
			}
			if (k >= indexOfChar) {
				alphabetOfLetters--;
			}
			else {
				alphabetOfLetters++;
			}
		}
		
		// Returns the value of the construction when the method is invoked.
		return diamondConstruction;
	}
	//---------------------------------------------------------------------------------//
	/** printDiamond Method prints the shape of the diamond to the console when invoked.*/
	public static void printDiamond(char [][] diamond) {
		// Printing the shape of the diamond when the method is invoked.
		for (int n = 0; n < diamond[0].length; ++n) {
			for (int m = 0; m < diamond.length; ++m) {
				System.out.print(diamond[n][m]);
			}
			System.out.println();
		}
	}
	//---------------------------------------------------------------------------------//
}

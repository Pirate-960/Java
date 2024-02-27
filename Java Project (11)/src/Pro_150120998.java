//-----------------------------------------//
// Student Name: Abdelrahman Zahran
// Student ID: 150120998
//-----------------------------------------//
// Purpose of the program: 
//  - String Analyzer Program:
/** Functionalities:
 * Count number of chars
 * Print the words in a sentence
 * Delete substring
 * Replace substring
 * Sort characters
 * Hash code of a string
 * */
//-----------------------------------------//
import java.util.Scanner;

public class Pro_150120998 {

    public static void main(String[] args) {
        // Scanner objects for user input
        Scanner input = new Scanner(System.in);
        Scanner input_1 = new Scanner(System.in);
        Scanner input_2 = new Scanner(System.in);
        Scanner input_3 = new Scanner(System.in);
        Scanner input_4 = new Scanner(System.in);
        Scanner input_5 = new Scanner(System.in);
        Scanner input_6 = new Scanner(System.in);

        // String variables for user inputs
        String userInput = "";
        String stringInput_1;
        String stringInput_2;
        String stringInput_3;
        String stringInput_4;
        String stringInput_5;
        String stringInput_6;
        String subString;
        String subString_1;
        String subString_2;
        char charInput;
        int type;
        int bValue;

        // Main program loop
        while (!((userInput.equals("exit")) || (userInput.equals("quit")))) {
        	
        	System.out.println();
            System.out.println("Welcome to our String Analyzer Program.");
            System.out.println("     1. Count number of chars");
            System.out.println("     2. Print the words in a sentence");
            System.out.println("     3. Delete substring");
            System.out.println("     4. Replace substring");
            System.out.println("     5. Sort characters");
            System.out.println("     6. Hash code of a string");
            System.out.print("Please enter your menu choice: ");

            userInput = input.nextLine();

            // Switch statement to handle user input choices
            switch (userInput) {
                case "1":
                    // Option 1: Count number of chars
                    System.out.print("Enter an input string: ");
                    stringInput_1 = input_1.nextLine();
                    System.out.print("Enter an input char: ");
                    charInput = input_1.next().charAt(0);
                    int result = numOfChars(stringInput_1, charInput);
                    System.out.printf("The number of %c in %s is %d.\n", charInput, stringInput_1, result);
                    break;

                case "2":
                    // Option 2: Print the words in a sentence
                    System.out.print("Enter an input string: ");
                    stringInput_2 = input_2.nextLine();
                    System.out.println("The output is:");
                    printWords(stringInput_2);
                    break;

                case "3":
                    // Option 3: Delete substring
                    System.out.print("Enter an input string: ");
                    stringInput_3 = input_3.nextLine();
                    System.out.print("Enter a substring: ");
                    subString = input_3.nextLine();
                    System.out.print("Enter a type: ");
                    type = input_3.nextInt();
                    input_3.nextLine();
                    System.out.println(delete(stringInput_3, subString, type));
                    break;

                case "4":
                    // Option 4: Replace substring
                    System.out.print("Enter an input string: ");
                    stringInput_4 = input_4.nextLine();
                    System.out.print("Enter the first substring: ");
                    subString_1 = input_4.nextLine();
                    System.out.print("Enter the second substring: ");
                    subString_2 = input_4.nextLine();
                    System.out.println(replace(stringInput_4, subString_1, subString_2));
                    break;

                case "5":
                    // Option 5: Sort characters
                    System.out.print("Enter an input string: ");
                    stringInput_5 = input_5.nextLine();
                    System.out.print("Enter a type: ");
                    type = input_5.nextInt();
                    input_5.nextLine();
                    System.out.println(sortChars(stringInput_5, type));
                    break;

                case "6":
                    // Option 6: Hash code of a string
                    System.out.print("Enter an input string: ");
                    stringInput_6 = input_6.nextLine();
                    System.out.print("Enter a value for b: ");
                    bValue = input_6.nextInt();
                    input_6.nextLine();
                    int hashFunction = hashCode(stringInput_6, bValue);
                    System.out.printf("The hash code for %s is %d.\n", stringInput_6, hashFunction);
                    break;

                case "exit":
                case "quit":
                    // Exit the program
                    System.out.println("Program ends. Bye :)");
                    break;

                default:
                    // Invalid input
                    System.out.println("Invalid Input.");
                    break;
            }
        }

        // Closing scanners to prevent resource leaks
        input.close();
        input_1.close();
        input_2.close();
        input_3.close();
        input_4.close();
        input_5.close();
        input_6.close();
    }
	
	// Option (1) -> An input string and an input character
	// -- returns the number of occurrences of the character in the input string
	public static int numOfChars(String str, char ch) {
	    int numberOfOccurrences = 0;

	    // Iterate through each character in the string
	    for (int i = 0; i < str.length(); ++i) {
	        // Check if the current character is equal to the specified character
	        if (str.charAt(i) == ch) {
	            // Increment the count of occurrences
	            ++numberOfOccurrences;
	        }
	    }

	    // Return the total number of occurrences
	    return numberOfOccurrences;
	}
	
	// Option (2) -> An input sentence as a string
	// -- prints the words inside it.
	public static void printWords(String str) {
	    int length = str.length();
	    String punctuation = ",.!?_-() ";
	    String word = "";
	    char ch;

	    // Iterate through each character in the string
	    for (int i = 0; i < length; ++i) {
	        ch = str.charAt(i);

	        // Check if the current character is a punctuation character
	        if (punctuation.indexOf(ch) == -1) {
	            // If not a punctuation character, append it to the current word
	            word += ch;
	        } else {
	            // If a punctuation character is encountered
	            if (!word.isEmpty()) {
	                // Print the current word if it is not empty
	                System.out.println(word);
	                // Reset the word for the next iteration
	                word = "";
	            }
	        }
	    }

	    // Print the last word if it is not empty
	    if (!word.isEmpty()) {
	        System.out.println(word);
	    }
	}
	
	// Option (3) -> finds a substring in a given string 
	// -- and delete it’s first occurrence if the type argument is 0
	// -- or delete it’s all occurrences if the type argument is 1.
	// -- return the updated string.
	public static String delete(String str, String subStr, int type) {
	    int index = 0;
	    int nextIndex = 0;
	    String strAfterDeletion;
	    if (type == 0) {
	        // Type 0: Delete the first occurrence of the substring
	        index = str.indexOf(subStr);
	        if (index != -1) {
	            strAfterDeletion = str.substring(0, index) + str.substring(index + subStr.length());
	            return strAfterDeletion;
	        }
	    } else if (type == 1) {
	        // Type 1: Delete all occurrences of the substring
	        strAfterDeletion = "";
	        index = 0;
	        while (index < str.length()) {
	            nextIndex = str.indexOf(subStr, index);
	            if (nextIndex == -1) {
	                // No more occurrences of subStr, append the remaining portion of the string
	                strAfterDeletion += str.substring(index);
	                break;
	            }
	            // Append the portion of the string before the occurrence of subStr
	            strAfterDeletion += str.substring(index, nextIndex);

	            // Move the index to the end of the occurrence of subStr
	            index = nextIndex + subStr.length();
	        }
	        return strAfterDeletion;
	    }

	    // Handle unexpected type
	    System.out.println("Unexpected Error: Invalid Type!");
	    return str;
	}
	
	// Option (4) -> finds a substring (subStr1) in the given string (str) 
	// -- replaces it’s all occurrences with the given substring as the third argument (subStr2).
	public static String replace(String str, String subStr1, String subStr2) {
		int index = 0;
		int nextIndex = 0;
		String result = "";
		
		while (index < str.length()) {
			nextIndex = str.indexOf(subStr1, index);
			
			if (nextIndex == -1) {
                // No more occurrences of subStr1, append the remaining portion of the string
				result += str.substring(index);
				break;
			}
            // Append the portion of the string before the occurrence of subStr1
            result += str.substring(index, nextIndex);

            // Append subStr2 instead of subStr1
            result += subStr2;

            // Move the index to the end of the occurrence of subStr1
            index = nextIndex + subStr1.length();
		}
		return result;
	}
	
	// Option (5) -> sorts the characters given in a string according to the sorting method provided by type argument.
	// -Type 0: sort the characters of the string in order of ASCII value from low to high and return the new string.
	// -Type (1): sort the characters of the string in this order: the lower-case letters, the upper-case letters, 
	// -- the digits and the other characters (these groups should internally be stored in order of ASCII value from low to high).
	// Return the sorted String.
	public static String sortChars(String str, int type) {
		String orderedString = "";
		int length = str.length();
		char[] inputStr = new char[length];
		char temp;
		
		for (int i = 0; i < length; ++i) {
			inputStr[i] = str.charAt(i);
		}
		
		if (type == 0) {
			for (int i = 0; i < length - 1; ++i) {
				for (int j = 0; j < length - i - 1; ++j) {
					if (inputStr[j] > inputStr[j + 1]) {
						// Swap
						temp = inputStr[j];
						inputStr[j] = inputStr[j + 1];
						inputStr[j + 1] = temp;
					}
				}
			}			
		} else if (type == 1) {
            // Sort characters with custom order: lowercase, uppercase, digits, others
			for (int i = 0; i < length; ++i) {
				for (int j = 0; j < length - i - 1; ++j) {
					if (customCompare(inputStr[j], inputStr[j + 1]) > 0) {
						// Swap
						temp = inputStr[j];
						inputStr[j] = inputStr[j + 1];
						inputStr[j + 1] = temp;
					}
				}
			}		
		}
		// orderedString = new String(inputStr);
		for (int i = 0; i < inputStr.length; ++i) {
			orderedString += inputStr[i];
		}
		return orderedString;	
	}
	
	// Custom comparison method for characters based on type:
	// Type 1: lowercase < uppercase < digits < others
	// - a The first character to compare
	// - b The second character to compare
	// -- return Negative value 
	// -- if 'a' is considered smaller than 'b', positive value if 'a' is considered larger than 'b',
	// -- and 0 if 'a' and 'b' are considered equal in the custom comparison.
	public static int customCompare(char a, char b) {
	    // Custom comparison logic for type 1
	    // lowercase < uppercase < digits < others
	    if (a >= 'a' && a <= 'z') {
	        // 'a' is lowercase
	        if (b >= 'a' && b <= 'z') {
	            // both characters are lowercase
	            return a - b;
	        } else {
	            // 'a' is lowercase, and 'b' is not lowercase
	            return -1;
	        }
	    } else if (a >= 'A' && a <= 'Z') {
	        // 'a' is uppercase
	        if (b >= 'A' && b <= 'Z') {
	            // both characters are uppercase
	            return a - b;
	        } else if (b >= 'a' && b <= 'z') {
	            // 'a' is uppercase, and 'b' is lowercase
	            return 1;
	        } else {
	            // 'a' is uppercase, and 'b' is neither lowercase nor uppercase
	            return -1;
	        }
	    } else if (a >= '0' && a <= '9') {
	        // 'a' is a digit
	        if (b >= '0' && b <= '9') {
	            // both characters are digits
	            return a - b;
	        } else if ((b >= 'a' && b <= 'z') || (b >= 'A' && b <= 'Z')) {
	            // 'a' is a digit, and 'b' is either lowercase or uppercase
	            return -1;
	        } else {
	            // 'a' is a digit, and 'b' is neither a digit nor a letter
	            return 1;
	        }
	    } else {
	        // 'a' is neither lowercase, uppercase, nor a digit
	        if ((b >= 'a' && b <= 'z') || (b >= 'A' && b <= 'Z') || (b >= '0' && b <= '9')) {
	            // 'a' is neither a digit nor a letter, and 'b' is either lowercase, uppercase, or a digit
	            return 1;
	        } else {
	            // 'a' and 'b' are both characters that are neither lowercase, uppercase, nor digits
	            return a - b;
	        }
	    }
	}

	// Option (6) -> finds and returns a hash code of a given string based on an integer value.
	public static int hashCode(String str, int b) {
	    int result = 0;
	    int length = str.length();

	    // Iterate through each character of the string
	    for (int i = 0; i < length; ++i) {
	        // Calculate the contribution of the current character to the hash code
	        // using the formula: char * b^(length - 1 - i)
	        result += (str.charAt(i)) * (Math.pow(b, (length - 1 - i)));
	    }

	    return result;
	}
}
//-----------------------------------------//
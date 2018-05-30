package org.wecancodeit.virtual_pet_shelter;

import java.util.Scanner;
import java.util.regex.Pattern;

public class QuestionAsker {
	
	Scanner input;
	
	public QuestionAsker(Scanner input) {
		this.input = input;
	}
	
	/* 
	 * yesOrNo evaluates a yes or no answer allowing multiple yes/no answer responses
	 * so that it is not case sensitive. Returns true or false. If the user enters
	 * an invalid string response, they will be prompted to respond again.
	 * 
	 */ 
	
	boolean yesOrNo(String question) {
		System.out.println(question);
		while (true) {
			String response = input.nextLine();
			switch (response.toLowerCase()) {
				case "y":	
				case "yes":
					return true;
				case "n":
				case "no": 
					return false;
				default:
					System.out.println("Sorry, I didn't catch that?");
			}
		}
	}
	
	/* 
	 * verifyString is used to verify the answer to a question is a string so that if
	 * a user enters "123" instead of an expected text string, the user will be 
	 * prompted to try again.
	 * 
	 * a program exit is included so that if the user enters "Quit", the program
	 * will terminate.
	 * 
	 */
	
	String verifyString(String question) {
		System.out.println(question);

		while (true) {
			String response = input.nextLine();
			boolean noNumbers = Pattern.matches("[a-zA-Z]+", response);
			if (response.toLowerCase().equals("quit"))  {
				System.exit(0);
			}
			if (noNumbers) {
				return response;
			}
			System.out.println("Please enter valid text, not a number. Thank you.");
		}
	}
	
	/* 
	 * returnInt is used to verify the answer to a question is an int so that if
	 * a user enters one instead of 1, for example, the user will be
	 * prompted to try again.
	 * 
	 * an option, negativeOK, allows you to determine if negative integer values are
	 * acceptable.
	 * 
	 * a program exit is included so that if the user enters "Quit", the program
	 * will terminate.
	 * 
	 */
	
	int returnInt(String question, Boolean negativesOK) {
		System.out.println(question);
		boolean isInteger;
		if (!negativesOK) {
			while (true) {
				String response = input.nextLine();
				if (response.toLowerCase().equals("quit"))  {
					System.exit(0);
				}
				// If String != "quit" then make sure it is a valid string
				isInteger = isInteger(response);
				if (isInteger) {
					int responseInt = Integer.parseInt(response);
					if (responseInt > 0) {
						return responseInt;
					}
					System.out.println("Please enter a realistic (positive) number!");	
				} else {
					System.out.println("Please enter a valid integer or type 'Quit' to end the progam.");
				}
			}
		}
		while (true) {
			String response = input.nextLine();
			if (response.toLowerCase().equals("quit")) {
				System.exit(0);
			}
			isInteger = isInteger(response);
			if (isInteger) {
				int responseInt = Integer.parseInt(response);
				return responseInt;
			}
			System.out.println("Please enter a valid integer or type 'Quit' to end the progam.");
		}
	}
	
	/*
	 * isInteger is used to determine if a string is a valid integer when parsed.
	 * 
	 */
	
	public static boolean isInteger(String s) {
	    // reference https://learn-java-by-example.com/java/check-java-string-integer/  
		boolean isValidInteger = false;
	      try
	      {
	         Integer.parseInt(s);
	 
	         // s is a valid integer
	 
	         isValidInteger = true;
	      }
	      catch (NumberFormatException ex)
	      {
	         // s is not an integer
	      }
	 
	      return isValidInteger;
	}
}

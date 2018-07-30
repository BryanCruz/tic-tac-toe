package tictactoe.frontend;

import java.util.Scanner;
import java.util.InputMismatchException;
import tictactoe.exceptions.UserInputException;

public abstract class UserInput{
	private static Scanner input = new Scanner(System.in);

	// read n integer inputs in a line
	public static int[] readInt(int n) throws UserInputException{
		int[] numbersRead = new int[n];
		try{
			for(int i = 0; i < n; i++){
				numbersRead[i] = input.nextInt();
			}
		}
		catch(InputMismatchException e){
			throw new UserInputException("Only numbers are allowed here");
		}
		finally{
			input.nextLine();
		}
		return numbersRead;
	}

	// read a integer in a line
	public static int readInt() throws UserInputException{
		int[] numberRead = UserInput.readInt(1);
		return numberRead[0];
	}

	public static int readIntOption(int minOption, int maxOption, String optionName){
		int option = -1;
		while(option < 0){
			try {
				option = UserInput.readInt();

				if (option < minOption || option > maxOption){
					throw new UserInputException("That option is not inside the valid range", optionName);
				}
			}
			catch (UserInputException e) {
				option = -1;
				System.out.print(e.getMessage());
			}
		}
		return option;
	}

	public static int readIntOption(int minOption, int maxOption){
		return UserInput.readIntOption(minOption, maxOption, "option");
	}


	public static String readString(){
		String read = input.nextLine();
		return read;
	}
}
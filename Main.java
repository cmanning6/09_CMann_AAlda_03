/**
 * 	Abraham Aldana
 *	Chad Manning
 *	CMPS 3390 - HW03
 *	RotateArray.java
 */

import java.util.*;

public class Main
{
	static Scanner scanner = new Scanner(System.in);
	static int[][] array;

	public static void generateArray() {
		System.out.print("Enter size for array : ");
		int size = scanner.nextInt();
		if (size > 10) size = 10; //keep it small
		if (size < 0) size = 0;

		array = new int[size][size]; fillArray();
		clearScreen(); System.out.printf("%dx%d array created\n", size, size);
	}

	public static void fillArray() {
		Random random = new Random();

		for (int i = 0; i < array.length; i++)
		    for (int j = 0; j < array.length; j++)
			array[i][j] = random.nextInt(900) + 100;
		}

	public static void rotateArray() {
		int numRotations = 0;
		boolean cont = true;

		while (cont) {
			for(int r = 0, r2 = array.length-1, c = 0, c2 = array[0].length-1;  ;) {
				// Makes new thread for each circle 
		   		new Thread(new RotateArray( true/*( r  % 2) == 0*/, array ,r, r2 , c,
		   					 c2)).start();

	 	    	r = r + 1; r2 = r2 - 1; c = c + 1; c2 = c2 - 1;
		    	if(r >= r2 || c >= c2) break; 
			}
			printArray();
			try{ Thread.sleep(1000); }  catch(Exception eCol) {}
			cont = promptContinue(++numRotations); if (numRotations > 10 && cont) numRotations = 0;
		}
		clearScreen();
	}

	public static boolean promptContinue(int numRotations) {
		boolean ret = true;

		if (numRotations > 9) {
			try {
				System.out.print("Press ENTER for 10 more rotations or Q/q to quit : ");
                if (scanner.nextLine().charAt(0) == 'q' || 
                	scanner.nextLine().charAt(0) == 'Q')
                	ret = false;
            } catch (IndexOutOfBoundsException e) {}
        }
        return ret;
	}

	public static void printArray() {
		clearScreen();
		for (int i = 0; i < array.length ; ++i) {
   			for (int j = 0; j < array.length; ++j) {
   				System.out.printf("%3d ", array[i][j]);
   			}
   			System.out.println();
		} 
		System.out.println();

	}

	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		try {
		    Runtime.getRuntime().exec("clear");
		} catch(Exception e) {}
	}

	/*
	 *Prints the command menu
	 */
	public static void printMenu()
	{
		System.out.print("======================== CS 3390 Assignment 1 ===============\n" +
						"G/g:   Ask for a N, and generate N X N array of integers and\n" +
						"        fill the array with random integers 3 digits or say\n" +
						"        between 100 and 999. \n" +
						"\n" +
						"S/s/ : Display the array in N columns and N rows.\n" +
						"        ascending order.\n" +
						"\n" +
						"V/v/ : Rotate each of rechtagles circle one position.\n" +
						"\n" +
						"--------------------------------------------------\n" +
						"H/h/?: Display this menu.\n" +
						"E/e  : Exit\n" +
						"==============================================================\n");
	}

	public static char commandMenu() {
		System.out.print("Enter H/h/?, or command : ");
		char c = scanner.next().charAt(0);
		clearScreen();

		switch (c) {
			case 'g':
			case 'G':
				generateArray();
			break;
			case 's':
			case 'S':
				printArray();
				break;
			case 'v':
			case 'V':
				rotateArray();
				break;
			case 'e':
			case 'E':
				break;
			case 'h' :
			case 'H' :
			case '?' :
				printMenu();
				break;
			default:
				System.out.println("Unknown command.");
				break;
		}

		return c;
	}

//===========================================================
//							MAIN
//===========================================================
	public static void main(String[] args) 
	{
			char c = 'c';

			while (c != 'e') {
				c = commandMenu();
			}

			scanner.close();
			System.out.println("Have a good day!");

	}

}

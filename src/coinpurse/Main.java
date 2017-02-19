package coinpurse;

import java.util.Arrays;

/**
 * A main class to create objects and connect objects together. The user
 * interface needs a reference to purse.
 * 
 * @author Thitiwat Thongbor
 */
public class Main {

	/** Default capacity value for purse dialog */
	private static int CAPACITY = 10;

	/**
	 * Configure and start the application.
	 * 
	 * @param args
	 *            not used
	 */
	public static void main(String[] args) {

		// 1. create a Purse with capacity
		Purse purse = new Purse(CAPACITY);
		// 2. create a ConsoleDialog with a reference to the Purse object
		ConsoleDialog consoleDialog = new ConsoleDialog(purse);
		// 3. run the ConsoleDialog
		consoleDialog.run();

	}
}

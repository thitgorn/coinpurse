package coinpurse;

import coinpurse.gui.PurseObserver;
import coinpurse.strategy.GreedyWithdraw;
import coinpurse.strategy.RecursiveWithdraw;

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

		// 1. crete money factory
		MoneyFactory.getInstance();
		// 2. create a Purse with capacity
		Purse purse = new Purse(CAPACITY);
		purse.setWithdrawStrategy(new RecursiveWithdraw());
//		purse.addObserver(new PurseObserver());
		
		// 3. create a ConsoleDialog with a reference to the Purse object
		ConsoleDialog consoleDialog = new ConsoleDialog(purse);
		// 4. run the ConsoleDialog
		consoleDialog.run();

	}
}

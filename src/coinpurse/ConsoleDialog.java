package coinpurse;

import java.util.Arrays;
import java.util.Scanner;

/**
 * User Interface for the Coin Purse. This class provides simple interactive
 * dialog for inserting and removing money to/from the purse, and displaying the
 * balance.
 * 
 * @author Thitiwat Thongbor
 */
public class ConsoleDialog {
	// default currency for this dialog
	public static final String CURRENCY = "Baht";
	// use a single java.util.Scanner object for reading all input
	private static Scanner console = new Scanner(System.in);
	// the purse dialog
	private Purse purse;

	/**
	 * Initialize a new Purse dialog.
	 * 
	 * @param purse
	 *            is the Purse to interact with.
	 */
	public ConsoleDialog(Purse purse) {
		this.purse = purse;
	}

	/** run the user interface */
	public void run() {
		String choice = "";
		while (true) {
			System.out.printf("Purse contains %.2f %s\n", purse.getBalance(), CURRENCY);
			if (purse.isFull())
				System.out.println("Purse is FULL.");
			// print a list of choices
			System.out.print("\nPlease enter d (deposit), w (withdraw), ? (inquiry), or q (quit): ");
			choice = console.nextLine().trim().toLowerCase();

			if (choice.equals("d"))
				depositDialog();
			else if (choice.equals("w"))
				withdrawDialog();
			else if (choice.equals("?"))
				System.out.println(purse.toString());
			else if (choice.equals("q"))
				break; // leave the loop
			else
				System.out.println("\"" + choice + "\" is not a valid choice.");
		}
		// confirm that we are quitting
		System.out.println("Goodbye. The purse still has " + purse.getBalance() + " " + CURRENCY);
	}

	/**
	 * Ask the user how much to deposit into purse, then deposit them.
	 * if the value adding is more than 20 , it will automaticly change into banknote.
	 * Show result of success or failure.
	 */
	public void depositDialog() {
		System.out.print("Enter value of coin(s) / banknote(s) to deposit on one line [eg: 5 10 20]: ");
		String inline = console.nextLine();
		// parse input line into numbers
		Scanner scanline = new Scanner(inline);
		while (scanline.hasNextDouble()) {
			double value = scanline.nextDouble();
			Valuable money;
			if (value >= 20) {
				money = new BankNote(value);
			} else {
				money = new Coin(value);
			}
			System.out.printf("Deposit %s... ", money.toString());
			boolean ok = purse.insert(money);
			System.out.println((ok ? "ok" : "FAILED"));
		}
		if (scanline.hasNext())
			System.out.println("Invalid input: " + scanline.next());
	}

	/**
	 * Ask how much money (Baht) to withdraw and then do it. After withdraw,
	 * show the values we withdrew with the list of money.
	 */
	public void withdrawDialog() {
		System.out.print("How much to withdraw? ");
		if (console.hasNextDouble()) {
			double amount = console.nextDouble();
			Valuable[] money = purse.withdraw(amount);
			if (money == null)
				System.out.printf("Sorry, couldn't withdraw %g %s\n", amount, CURRENCY);
			else {
				System.out.print("You withdrew:");
				for (int k = 0; k < money.length; k++) {
					System.out.print(" " + money[k].toString());
				}
				System.out.println();
			}
		} else
			System.out.printf("Invalid amount.");
		// discard remainder of the input line so we don't read it again
		console.nextLine();
	}

}

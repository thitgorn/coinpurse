package coinpurse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A coin purse contains coins. You can insert coins, withdraw money, check the
 * balance, and check if the purse is full. When you withdraw money, the coin
 * purse decides which coins to remove.
 * 
 * @author Thitiwat Thongbor
 */
public class Purse {

	/** Collection of objects in the purse. */
	List<Coin> money;
	/**
	 * Capacity is maximum number of coins the purse can hold. Capacity is set
	 * when the purse is created and cannot be changed.
	 */
	private final int capacity;

	/**
	 * Create a purse with a specified capacity.
	 * 
	 * @param capacity
	 *            is maximum number of coins you can put in purse.
	 */
	public Purse(int capacity) {
		this.capacity = capacity;
		money = new ArrayList<Coin>();
	}

	/**
	 * Count and return the number of coins in the purse. This is the number of
	 * coins, not their value.
	 * 
	 * @return the number of coins in the purse
	 */
	public int count() {
		return money.size();
	}

	/**
	 * Get the total value of all items in the purse.
	 * 
	 * @return the total value of items in the purse.
	 */
	public double getBalance() {
		double balance = 0.0;
		for (Coin coin : money)
			balance += coin.getValue();
		return balance;
	}

	/**
	 * Return the capacity of the coin purse.
	 * 
	 * @return the capacity
	 */
	public int getCapacity() {
		return this.capacity;
	}

	/**
	 * Test whether the purse is full. The purse is full if number of items in
	 * purse equals or greater than the purse capacity.
	 * 
	 * @return true if purse is full.
	 */
	public boolean isFull() {
		if (money.size() >= this.capacity)
			return true;
		return false;
	}

	/**
	 * Insert a coin into the purse. The coin is only inserted if the purse has
	 * space for it and the coin has positive value. No worthless coins!
	 * 
	 * @param coin
	 *            is a Coin object to insert into purse
	 * @return true if coin inserted, false if can't insert
	 */
	public boolean insert(Coin coin) {
		// if the purse is already full then can't insert anything.
		if (this.isFull()) {
			return false;
		}
		if (coin.getValue() <= 0) {
			return false;
		}
		money.add(coin);
		return true;
	}

	/**
	 * Withdraw the requested amount of money. Return an array of Coins
	 * withdrawn from purse, or return null if cannot withdraw the amount
	 * requested.
	 * 
	 * @param amount
	 *            is the amount to withdraw
	 * @return array of Coin objects for money withdrawn, or null if cannot
	 *         withdraw requested amount.
	 */
	public Coin[] withdraw(double amount) {
		Collections.sort(money);
		if (amount <= 0)// don't allow to withdraw amount < 0
			return null;
		List<Coin> coins = new ArrayList<Coin>();

		for (int i = money.size() - 1; i >= 0; i--) { // Greedy algorithm
			if (amount >= money.get(i).getValue()) {
				coins.add(money.get(i));
				amount -= money.get(i).getValue();
				money.remove(i);
			}
		}

		if (amount > 0) {
			money.addAll(coins);
			return null;
		}

		Coin[] coin = new Coin[coins.size()];
		// Use list.toArray( array[] ) to copy a list into an array.
		// toArray returns a reference to the array itself.
		return coins.toArray(coin);
	}

	/**
	 * toString returns a string description of the purse contents. It can
	 * 
	 * @return coin that is left in the purse..
	 */
	public String toString() {
		return this.money.size() + " coins with value " + this.getBalance();
	}

}

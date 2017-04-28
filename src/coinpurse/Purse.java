package coinpurse;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import coinpurse.strategy.WithdrawStrategy;

/**
 * A purse contains coins , banknotes. You can insert coins, withdraw money,
 * check the balance, and check if the purse is full. When you withdraw money,
 * the coin purse decides which coins, banknotes to remove.
 * 
 * @author Thitiwat Thongbor
 * @version 25.02.2017
 */
public class Purse extends Observable {

	/** Collection of objects in the purse. */
	protected List<Valuable> money;
	/**
	 * Capacity is maximum number of coins the purse can hold. Capacity is set
	 * when the purse is created and cannot be changed.
	 */
	private final int capacity;
	private WithdrawStrategy strategy;

	/**
	 * Create a purse with a specified capacity.
	 * 
	 * @param capacity
	 *            is maximum number of coins you can put in purse.
	 */
	public Purse(int capacity) {
		this.capacity = capacity;
		money = new ArrayList<Valuable>();
	}

	/**
	 * Count and return the number of coins and banknotes in the purse. This is
	 * the number of coins and banknotes, not their value.
	 * 
	 * @return the number of objects in the purse
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
		for (Valuable coin : money)
			balance += coin.getValue();
		return balance;
	}

	/**
	 * Return the capacity of the purse.
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
	 * Insert a money into the purse. The money is only inserted if the purse
	 * has space for it and the money has positive value. It will automatically
	 * sort by value.
	 * 
	 * @param v
	 *            is a valuable object to insert into purse
	 * @return true if object inserted, false if can't insert
	 */
	public boolean insert(Valuable v) {
		boolean returnType = true;
		// if the purse is already full then can't insert anything.
		if (this.isFull()) {
			return false;
		}
		if (v.getValue() <= 0) {
			return false;
		}
		money.add(v);
		setChanged();
		notifyObservers();
		return returnType;
	}

	/**
	 * Withdraw the requested amount of money. Return an array of money
	 * withdrawn from purse, or return null if cannot withdraw the amount
	 * requested.
	 * 
	 * @param amount
	 *            is the amount to withdraw
	 * @return array of objects for money withdrawn, or null if cannot withdraw
	 *         requested amount.
	 */
	public Valuable[] withdraw(double amount) {
		if (amount > getBalance()) {
			return null;
		}

		if (amount <= 0)// don't allow to withdraw amount < 0
			return null;
		List<Valuable> coins = strategy.withdraw(amount, money);
		if (coins == null) {
			return null;
		}

		for (int i = 0; i < coins.size(); i++) {
			if (money.contains(coins.get(i))) {
				int index = money.indexOf(coins.get(i));
				money.remove(index);
			}
		}
		Valuable[] coin = new Valuable[coins.size()];
		// Use list.toArray( array[] ) to copy a list into an array.
		// toArray returns a reference to the array itself.
		setChanged();
		notifyObservers();
		return coins.toArray(coin);
	}

	/**
	 * toString returns a string description of the purse contents. It can
	 * 
	 * @return coin and banknote that is left in the purse..
	 */
	public String toString() {
		return this.money.size() + " coins , banknotes with value " + this.getBalance();
	}

	public void setWithdrawStrategy(WithdrawStrategy strategy) {
		this.strategy = strategy;
	}

}

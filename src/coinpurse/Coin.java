package coinpurse;

/**
 * a coin with a monetary value and currency
 * 
 * @author Thitiwat Thongbor
 */
public class Coin implements Comparable<Coin> {
	/** Default currency when there is no currency in constructor. */
	public static final String DEFAULT_CURRENCY = "Baht";
	/** Value of the coin. */
	private final double value;
	/** The currency, of course. */
	private final String currency;

	/**
	 * A coin with given value using the default currency.
	 * 
	 * @param value
	 *            of this coin.
	 */
	public Coin(double value) {
		this.value = value;
		this.currency = DEFAULT_CURRENCY;
	}

	/**
	 * A coin with given value and currency.
	 * 
	 * @param value
	 *            of this coin.
	 * @param currency
	 *            of this coin.
	 */
	public Coin(double value, String currency) {
		this.value = value;
		this.currency = currency;
	}

	/**
	 * get the coin value.
	 * 
	 * @return coin value.
	 */
	public double getValue() {
		return this.value;
	}

	/**
	 * get the coin currency.
	 * 
	 * @return coin currency.
	 */
	public String getCurrency() {
		return this.currency;
	}

	/**
	 * return that Coin is the same value or not.
	 * 
	 * @param obj
	 *            is the coin that want to check.
	 * @return true if same , false is not same.
	 */
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj.getClass() != this.getClass())
			return false;
		Coin object = (Coin) obj;
		if (object.value == this.value)
			return true;
		return false;
	}

	/**
	 * compare the value of the coin.
	 * 
	 * @param o
	 *            is the coin that want to compare the value.
	 * @return -1 if o less than value , 0 if it's same , 1 if o more than
	 *         value.
	 */
	@Override
	public int compareTo(Coin o) {
		if (o == null)
			return -1;
		return (int) Math.signum(this.value - o.value);
	}

	/**
	 * Coin string for monitoring.
	 * 
	 * @return value with currency.
	 */
	public String toString() {
		return this.value + " " + this.currency;
	}
}

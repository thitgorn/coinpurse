package coinpurse;

/**
 * a coin with a monetary value and currency
 * 
 * @author Thitiwat Thongbor
 */
public class Coin implements Comparable<Coin> {
	public static final String DEFAULT_CURRENCY = "Baht";
	/** Value of the coin. */
	private final double value;
	/** The currency, of course. */
	private final String currency;

	/**
	 * A coin with given value using the default currency.
	 * 
	 * @param value
	 */
	public Coin(double value) {
		this.value = value;
		this.currency = DEFAULT_CURRENCY;
	}

	/**
	 * A coin with given value and currency.
	 * 
	 * @param value
	 * @param currency
	 */
	public Coin(double value, String currency) {
		this.value = value;
		this.currency = currency;
	}

	public double getValue() {
		return this.value;
	}

	public String getCurrency() {
		return this.currency;
	}

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

	@Override
	public int compareTo(Coin o) {
		if (o == null)
			return -1;
		return (int) Math.signum(this.value - o.value);
	}

	public String toString() {
		return this.value + " " + this.currency;
	}
}

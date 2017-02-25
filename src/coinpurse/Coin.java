package coinpurse;

/**
 * a coin with a monetary value and currency
 * 
 * @author Thitiwat Thongbor
 * @version 24.02.2017
 */
public class Coin extends AbstractValuable {

	/**
	 * A coin with given value using the default currency.
	 * 
	 * @param value
	 *            of this coin.
	 */
	public Coin(double value) {
		this(value, DEFAULT_CURRENCY);
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
		super(value, currency);
	}

	/**
	 * Coin string for monitoring.
	 * 
	 * @return value with currency.
	 */
	public String toString() {
		return this.value + "-" + this.currency + " Coin";
	}
}

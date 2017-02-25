package coinpurse;

/**
 * 
 * A BankNote with a monetary value and currency
 * 
 * @author Thitiwat Thongbor
 * @version 25.02.2017
 *
 */
public class BankNote extends AbstractValuable {
	/** The serial Number. */
	private final long serialNumber;

	/**
	 * A banknote with given value using the default currency.
	 * 
	 * @param value
	 *            of this banknote.
	 * @param serialNumber
	 *            if the banknote.
	 */
	public BankNote(double value, long serialNumber) {
		this(value, DEFAULT_CURRENCY, serialNumber);
	}

	/**
	 * A banknote with given value and currency.
	 * 
	 * @param value
	 *            of this banknote.
	 * @param currency
	 *            of this banknote.
	 */
	public BankNote(double value, String currency, long serialNumber) {
		super(value, currency);
		this.serialNumber = serialNumber;
	}

	/**
	 * get serial number.
	 * 
	 * @return serial number.
	 */
	public long getSerial() {
		return this.serialNumber;
	}

	/**
	 * return BankNote String.
	 * 
	 * @return the value of banknote with serial number.
	 */
	public String toString() {
		return this.value + "-" + this.currency + " note [" + this.serialNumber + "]";
	}
}

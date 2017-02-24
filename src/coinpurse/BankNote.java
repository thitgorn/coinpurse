package coinpurse;

/**
 * 
 * A BankNote with a monetary value and currency
 * 
 * @author Thitiwat Thongbor
 *
 */
public class BankNote extends AbstractValuable {
	/** The next Serial Number. */
	private static long nextSerialNumber = 1_000_000;
	/** The serial Number. */
	private final long serialNumber;

	/**
	 * A banknote with given value using the default currency.
	 * 
	 * @param value
	 *            of this banknote.
	 */
	public BankNote(double value) {
		this(value, DEFAULT_CURRENCY);
	}

	/**
	 * A banknote with given value and currency.
	 * 
	 * @param value
	 *            of this banknote.
	 * @param currency
	 *            of this banknote.
	 */
	public BankNote(double value, String currency) {
		super(value, currency);
		this.serialNumber = nextSerialNumber;
		nextSerialNumber += 1;
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
		return this.value + " " + this.currency + " note [" + this.serialNumber + "]";
	}
}

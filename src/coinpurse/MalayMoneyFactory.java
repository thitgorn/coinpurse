package coinpurse;

/**
 * Factory responsible with creating malaysia ringgit money. Decide what kind of
 * money. coin or banknote.
 * 
 * @author Thitiwat Thongbor
 * @version 25.02.2017
 *
 */
public class MalayMoneyFactory extends MoneyFactory {

	/** The next Serial Number. */
	private static long serialNumber = 1_000_000;

	// default currency of malay money.
	private final String DEFAULT_CURRENCY = "Ringgit";

	/**
	 * creating money in currency Ringgit.
	 * 
	 * @param value
	 *            of the money.
	 */
	@Override
	public Valuable createMoney(double value) throws IllegalArgumentException {
		if (isCoin(value)) {
			return new Coin(value, DEFAULT_CURRENCY);
		} else if (isBankNote(value)) {
			long serialNumber = assignSerialNumber();
			return new BankNote(value, DEFAULT_CURRENCY, serialNumber);
		}
		throw new IllegalArgumentException("Incorrect Malay value");
	}

	/**
	 * make banknotes are not the same serialnumber.
	 * 
	 * @return Its own serialnumber.
	 */
	private long assignSerialNumber() {
		serialNumber += 1;
		return serialNumber;
	}

	/**
	 * checking this is banknote or not.
	 * 
	 * @param value
	 *            of the money.
	 * @return true if it's banknote.
	 */
	private boolean isBankNote(double value) {
		// All value of malay banknote.
		double[] bank = { 1.0, 2.0, 5.0, 10.0, 20.0, 50.0, 100.0 };

		// check if value matches banknote.
		for (int i = 0; i < bank.length; i++) {
			if (bank[i] == value)
				return true;
		}
		return false;
	}

	/**
	 * checking this is coin or not.
	 * 
	 * @param value
	 *            of the money.
	 * @return true if it's coin.
	 */
	private boolean isCoin(double value) {
		// All value of malay coin.
		double[] coin = { 0.05, 0.10, 0.20, 0.50 };

		// check if value matches coin.
		for (int i = 0; i < coin.length; i++) {
			if (coin[i] == value)
				return true;
		}
		return false;
	}

}

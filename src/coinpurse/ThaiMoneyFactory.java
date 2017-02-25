package coinpurse;

/**
 * 
 * Thai money factory , deciding making coin or banknote in Thailand.
 * 
 * @author Thitiwat Thongbor
 * @version 25.02.2017
 *
 */
public class ThaiMoneyFactory extends MoneyFactory {

	/** The next Serial Number. */
	private static long serialNumber = 1_000_000;

	/**
	 * decide creating coin or banknote.
	 */
	@Override
	public Valuable createMoney(double value) throws IllegalArgumentException {
		if (isCoin(value)) {
			return new Coin(value);
		} else if (isBankNote(value)) {
			long serialNumber = assignSerialNumber();
			return new BankNote(value, serialNumber);
		}
		throw new IllegalArgumentException("Incorrect Thai Baht value.");
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
	 * check is the banknote?
	 * 
	 * @param value
	 *            of the money
	 * @return true if yes , of course.
	 */
	private boolean isBankNote(double value) {
		// value of banknote in Thailand.
		double[] bank = { 20.0, 50.0, 100.0, 500.0, 1000.0 };

		// check if value matches with banknote.
		for (int i = 0; i < bank.length; i++) {
			if (bank[i] == value)
				return true;
		}
		return false;
	}

	/**
	 * check is the coin?
	 * 
	 * @param value
	 *            of the money
	 * @return true if yes
	 */
	private boolean isCoin(double value) {
		// value of coin in Thailand.
		double[] coin = { 0.25, 0.50, 1.0, 2.0, 5.0, 10.0 };

		// check if value matches with coin.
		for (int i = 0; i < coin.length; i++) {
			if (coin[i] == value)
				return true;
		}
		return false;
	}
}

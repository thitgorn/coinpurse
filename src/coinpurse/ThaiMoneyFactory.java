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

	/**
	 * decide creating coin or banknote.
	 */
	@Override
	public Valuable createMoney(double value) throws IllegalArgumentException {
		if (isCoin(value)) {
			return new Coin(value);
		} else if (isBankNote(value)) {
			return new BankNote(value);
		}
		throw new IllegalArgumentException("Incorrect Thai Baht value.");
	}

	/**
	 * check is the banknote?
	 * @param value of the money
	 * @return true if yes , of course.
	 */
	private boolean isBankNote(double value) {
		if (value == 20 || value == 50 || value == 100 || value == 500 || value == 1000) {
			return true;
		}
		return false;
	}

	/**
	 * check is the coin?
	 * @param value of the money
	 * @return true if yes
	 */
	private boolean isCoin(double value) {
		if (value == 0.25 || value == 0.50 || value == 1 || value == 2 || value == 5 || value == 10) {
			return true;
		}
		return false;
	}
}

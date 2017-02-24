package coinpurse;

/**
 * Factory responsible with creating malaysia ringgit money. Decide what kind of
 * money. coin or banknote.
 * 
 * @author Thitiwat Thongbor
 * @version 24.02.2017
 *
 */
public class MalayMoneyFactory extends MoneyFactory {

	/**
	 * creating money in currency Ringgit.
	 * 
	 * @param value
	 *            of the money.
	 */
	@Override
	public Valuable createMoney(double value) throws IllegalArgumentException {
		if (isCoin(value)) {
			return new Coin(value, " Sen");
		} else if (isBankNote(value)) {
			return new BankNote(value, " Ringgit");
		}
		throw new IllegalArgumentException("Incorrect Malay value");
	}

	/**
	 * checking this is banknote or not.
	 * 
	 * @param value
	 *            of the money.
	 * @return true if it's banknote.
	 */
	private boolean isBankNote(double value) {
		if (value == 1 || value == 2 || value == 5 || value == 10 || value == 20 || value == 50 || value == 100) {
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
		if (value == 0.05 || value == 0.10 || value == 0.20 || value == 0.50) {
			return true;
		}
		return false;
	}

}

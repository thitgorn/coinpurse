package coinpurse;

/**
 * 
 * @author Thitiwat Thongbor
 *
 */
public class ThaiMoneyFactory extends MoneyFactory {

	@Override
	public Valuable createMoney(double value) throws IllegalArgumentException {
		if (isCoin(value)) {
			return new Coin(value);
		} else if (isBankNote(value)) {
			return new BankNote(value);
		}
		throw new IllegalArgumentException("Incorrect Thai Baht value.");
	}

	private boolean isBankNote(double value) {
		if (value == 20 || value == 50 || value == 100 || value == 500 || value == 1000) {
			return true;
		}
		return false;
	}

	private boolean isCoin(double value) {
		if (value == 0.25 || value == 0.50 || value == 1 || value == 2 || value == 5 || value == 10) {
			return true;
		}
		return false;
	}
}

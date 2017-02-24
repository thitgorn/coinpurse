package coinpurse;

public class MalayMoneyFactory extends MoneyFactory {

	@Override
	public Valuable createMoney(double value) throws IllegalArgumentException {
		if (isCoin(value)) {
			return new Coin(value, " Sen");
		} else if (isBankNote(value)) {
			return new BankNote(value, " Ringgit");
		}
		throw new IllegalArgumentException("Incorrect Malay value");
	}

	private boolean isBankNote(double value) {
		if (value == 1 || value == 2 || value == 5 || value == 10 || value == 20 || value == 50 || value == 100) {
			return true;
		}
		return false;
	}

	private boolean isCoin(double value) {
		if (value == 0.05 || value == 0.10 || value == 0.20 || value == 0.50) {
			return true;
		}
		return false;
	}

}

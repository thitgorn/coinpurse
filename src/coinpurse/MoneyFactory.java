package coinpurse;

/**
 * 
 * @author Thitiwat Thongbor
 *
 */
public abstract class MoneyFactory {

	private static MoneyFactory factory;
	private final static String DEFAULT_COUNTRY = "Thailand";
	private static String currency;

	// No one can access this it's called "Singleton"
	protected MoneyFactory() {

	}

	// return moneyFactory if it is never created , create new one.
	static MoneyFactory getInstance() {
		if (factory == null) {
			setMoneyFactory(DEFAULT_COUNTRY);
		}
		return factory;
	}

	static void setMoneyFactory(String country) {
		if (country.equalsIgnoreCase("Thailand")) {
			factory = new ThaiMoneyFactory();
			currency = "Baht";
		} else if (country.equalsIgnoreCase("Malaysia")) {
			factory = new MalayMoneyFactory();
			currency = "Ringgit";
		} else {
			throw new IllegalArgumentException("INVALID COUNTRY");
		}
	}

	protected static String getCurrency() {
		return MoneyFactory.currency;
	}

	public abstract Valuable createMoney(double value) throws IllegalArgumentException;

	Valuable createMoney(String value) throws IllegalArgumentException {
		return this.createMoney(Double.parseDouble(value)); // convert String to
															// Double.
	}
}

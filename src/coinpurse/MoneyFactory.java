package coinpurse;

import java.util.ResourceBundle;

/**
 * 
 * @author Thitiwat Thongbor
 *
 */
public abstract class MoneyFactory {

	private static MoneyFactory factory;
	private static String currency;
	private static ResourceBundle bundle = ResourceBundle.getBundle("purse");

	// No one can access this it's called "Singleton"
	protected MoneyFactory() {

	}

	// return moneyFactory if it is never created , create new one.
	static MoneyFactory getInstance() {
		String Country = bundle.getString("Country");
		if (factory == null) {
			setMoneyCurrency(Country);
			try {
				factory = (MoneyFactory) Class.forName(Country).newInstance();
			} catch (ClassNotFoundException cce) {
				// the object could not be cast to type MoneyFacroty
				System.out.println(factory + " is not type MoneyFactory");
			} catch (Exception ex) {
				// any other exception means we could not create an object
				System.out.println("Error creating MoneyFactoyu " + ex.getMessage());
			}
			if (factory == null)
				System.exit(1);
		}
		return factory;
	}

	private static void setMoneyCurrency(String country) {
		if (country.equals("coinpurse.ThaiMoneyFactory")) {
			currency = "Baht";
		} else if (country.equals("coinpurse.MalayMoneyFactory")) {
			currency = "Ringgit";
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

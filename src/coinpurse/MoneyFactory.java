package coinpurse;

import java.util.ResourceBundle;

/**
 * 
 * Class responsible for creating money.
 * 
 * @author Thitiwat Thongbor
 * @version 25.02.2017
 *
 */
public abstract class MoneyFactory {

	// declare the attributes.
	private static MoneyFactory factory;
	private static String currency;
	private static ResourceBundle bundle = ResourceBundle.getBundle("purse");

	// No one can access this it's called "Singleton"
	protected MoneyFactory() {

	}

	// return moneyFactory if it is never created , create new one.
	// Singleton
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

	/**
	 * Helping method to set the ConsoleDialog class currency. Now. it's only
	 * has Thai and Malay.
	 * 
	 * @param country
	 */
	private static void setMoneyCurrency(String country) {
		if (country.equals("coinpurse.ThaiMoneyFactory")) {
			currency = "Baht";
		} else if (country.equals("coinpurse.MalayMoneyFactory")) {
			currency = "Ringgit";
		}
	}

	/**
	 * Get current currency.
	 * 
	 * @return currency
	 */
	protected static String getCurrency() {
		return MoneyFactory.currency;
	}

	/**
	 * Abstract class that subclass need to implement. use this to create money
	 * , decide that is coin or banknote.
	 * 
	 * @param value
	 *            of the money , valuable.
	 * @return valuable , eg , coin , banknote.
	 * @throws IllegalArgumentException
	 *             if there is not match with object in that country.
	 */
	public abstract Valuable createMoney(double value) throws IllegalArgumentException;

	/**
	 * this method helping the factory to allow creating the money via, String.
	 * 
	 * @param value
	 *            is money , valuable in string
	 * @return createMoney in Double
	 * @throws IllegalArgumentException
	 *             if there is not match with object in that country.
	 */
	public Valuable createMoney(String value) throws IllegalArgumentException {
		return this.createMoney(Double.parseDouble(value)); // convert String to
															// Double.
	}
}

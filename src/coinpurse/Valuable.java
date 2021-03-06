package coinpurse;

/**
 * 
 * An interface for objects having a monetary value and currency.
 * 
 * @author Thitiwat Thongbor
 * @version 25.02.2017
 *
 */
public interface Valuable extends Comparable<Valuable> {
	/**
	 * Get the monetary value of this object, in its own currency.
	 * 
	 * @return the value of this object
	 */
	public double getValue();

	/**
	 * Get the currency of this object.
	 * 
	 * @return the currency of this object.
	 */
	public String getCurrency();
}

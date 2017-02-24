package coinpurse;

public abstract class AbstractValuable implements Valuable {
	/** Default currency when there is no currency in constructor. */
	protected static final String DEFAULT_CURRENCY = "Baht";
	/** Value of the coin. */
	protected final double value;
	/** The currency, of course. */
	protected final String currency;

	public AbstractValuable(double value, String currency) {
		this.value = value;
		this.currency = currency;
	}

	/**
	 * get the value.
	 * 
	 * @return value.
	 */
	public double getValue() {
		return this.value;
	}

	/**
	 * get the currency.
	 * 
	 * @return currency.
	 */
	public String getCurrency() {
		return this.currency;
	}

	/**
	 * return the same value or not.
	 * 
	 * @param obj
	 *            is the valuable object.
	 * @return true if same , false is not same.
	 */
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj.getClass() != this.getClass())
			return false;
		Valuable object = (Valuable) obj;
		if (object.getValue() == this.value)
			return true;
		return false;
	}

	/**
	 * compare the value.
	 * 
	 * @param o
	 *            is the valuable object.
	 * @return -1 if o less than value , 0 if it's same , 1 if o more than
	 *         value.
	 */
	@Override
	public int compareTo(Valuable o) {
		if (o == null)
			return -1;
		return (int) Math.signum(this.getValue() - o.getValue());
	}

}
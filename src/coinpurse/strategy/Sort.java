package coinpurse.strategy;

import java.util.Comparator;

import coinpurse.Valuable;

public class Sort implements Comparator<Valuable> {

	@Override
	public int compare(Valuable o1, Valuable o2) {
		return (int) Math.signum(o2.getValue() - o1.getValue());
	}

}

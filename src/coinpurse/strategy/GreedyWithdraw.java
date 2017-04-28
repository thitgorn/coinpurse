package coinpurse.strategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import coinpurse.Valuable;

public class GreedyWithdraw implements WithdrawStrategy, Comparator<Valuable> {

	@Override
	public List<Valuable> withdraw(double amount, List<Valuable> money) {

		Collections.sort(money, this);
		List<Valuable> coins = new ArrayList<>();
		for (int i = 0; i < money.size(); i++) { // Greedy algorithm
			if (amount >= money.get(i).getValue()) {
				coins.add(money.get(i));
				amount -= money.get(i).getValue();
				money.remove(i);
				i--;
			}
		}
		if (amount > 0) {
			while (coins.size() > 0) {
				money.add(coins.get(0));
				coins.remove(coins.get(0));
			}
			return null;
		}
		return coins;
	}

	@Override
	public int compare(Valuable o1, Valuable o2) {
		return (int) Math.signum((o2.getValue() - o1.getValue()));
	}

}

package coinpurse.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import coinpurse.Valuable;

/**
 * 
 * @author Thitiwat Thongbor
 *
 */
public class GreedyWithdraw implements WithdrawStrategy{

	@Override
	public List<Valuable> withdraw(double amount, List<Valuable> money) {

		List<Valuable> money_clone = new ArrayList<>();
		money_clone.addAll(money);

		Collections.sort(money_clone, new Sort());
		List<Valuable> coins = new ArrayList<>();
		for (int i = 0; i < money_clone.size(); i++) { // Greedy algorithm
			double value = money_clone.get(i).getValue();
			if (amount >= value) {
				coins.add(money_clone.get(i));
				amount -= value;
			}
		}
		if (amount > 0) {
			return null;
		}
		return coins;
	}

}

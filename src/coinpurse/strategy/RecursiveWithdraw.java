package coinpurse.strategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import coinpurse.Valuable;

/**
 * 
 * @author Thitiwat Thongbor
 *
 */
public class RecursiveWithdraw implements WithdrawStrategy {

	@Override
	public List<Valuable> withdraw(double amount, List<Valuable> money) {
		List<Valuable> clone_money = new ArrayList<>();
		clone_money.addAll(money);
		Collections.sort(clone_money, new Sort());
		Collections.reverse(clone_money);
		return recursive(amount, clone_money);
	}

	private List<Valuable> recursive(double amount, List<Valuable> money) {
		if (amount == 0) {
			return new ArrayList<>();
		}
		if (money.isEmpty()) {
			return null;
		}
		Valuable first = money.get(0);
		List<Valuable> result;
		List<Valuable> view = money.subList(1, money.size());
		if (amount - first.getValue() < 0) {
			return null;
		}

		result = recursive(amount - first.getValue(), view);
		if (result != null) {
			result.add(first);
			return result;
		}
		result = recursive(amount, view);
		if (result != null) {
			return result;
		}

		return null;
	}
}

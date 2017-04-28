package coinpurse.strategy;

import java.util.ArrayList;
import java.util.Arrays;
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
		System.out.println(Arrays.toString(clone_money.toArray()));
		return recursive(amount, clone_money);
	}

	private List<Valuable> recursive(double amount, List<Valuable> money) {
		List<Valuable> answer = null;
//		Valuable first = money.get(0);
//		if (amount - first.getValue() == 0) {
//			answer = new ArrayList<>();
//			answer.add(first);
//			return answer;
//		}
//		if (amount - first.getValue() < 0) {
//			return null;
//		}
//		if (money.size() == 1) {
//			return null;
//		}
//		if (recursive(amount - first.getValue(), money.subList(1, money.size())) != null) {
//			answer = new ArrayList<>();
//			answer.addAll(recursive(amount - first.getValue(), money.subList(1, money.size())));
//			answer.add(first);
//			return answer;
//		}
//		else if (recursive(amount, money.subList(1, money.size())) != null) {
//			answer = new ArrayList<>();
//			answer.addAll(recursive(amount, money.subList(1, money.size())));
//			answer.add(first);
//			return answer;
//		}
		return answer;
	}
}

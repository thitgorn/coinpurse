package coinpurse;

import org.junit.*;
import static org.junit.Assert.*;

import coinpurse.strategy.GreedyWithdraw;

public class PurseTest {
	private final int CAPACITY = 5;
	private Purse purse;
	private MoneyFactory factory = MoneyFactory.getInstance();

	@Before
	public void setUp() {
		purse = new Purse(CAPACITY);
		purse.setWithdrawStrategy(new GreedyWithdraw());
	}

	@Test
	public void TestNormalWithdraw() {
		Valuable[] money = { factory.createMoney(20) };
		purse.insert(money[0]);
		assertArrayEquals(money, purse.withdraw(20));

		Valuable[] money1 = { factory.createMoney(20), factory.createMoney(10) };
		purse.insert(money1[0]);
		purse.insert(money1[1]);
		assertArrayEquals(money1, purse.withdraw(30));

		purse.insert(money1[1]);
		purse.insert(money1[0]);
		assertArrayEquals(money1, purse.withdraw(30));

		Valuable[] money2 = { factory.createMoney(1), factory.createMoney(5), factory.createMoney(10) };
		purse.insert(money2[1]);
		purse.insert(money2[2]);
		purse.insert(money2[0]);
		Valuable[] equal = { money2[1], money2[0] };
		assertArrayEquals(equal, purse.withdraw(6));
	}

	@Test
	public void TestpossibleWithdraw() {
		Valuable[] money2 = { factory.createMoney(5), factory.createMoney(2), factory.createMoney(2),
				factory.createMoney(2) };
		purse.insert(money2[0]);
		purse.insert(money2[1]);
		purse.insert(money2[2]);
		purse.insert(money2[3]);
		Valuable[] expect = { money2[1], money2[2], money2[3] };
		assertArrayEquals(expect, purse.withdraw(6));
	}

	@Test
	public void testImpossibleWithdraw() {
		assertNull(purse.withdraw(0));
		assertNull(purse.withdraw(-1));
		assertNull(purse.withdraw(10)); // nothing in purse
		Valuable[] money = { factory.createMoney(5), factory.createMoney(2), factory.createMoney(2),
				factory.createMoney(2) };
		for(Valuable coin : money){
			purse.insert(coin);
		}
		assertNull(purse.withdraw(100));
	}

}

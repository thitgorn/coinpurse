package coinpurse.gui;

import java.util.Observable;
import java.util.Observer;

import coinpurse.Purse;

public class PurseObserver implements Observer {
	private PurseBalance purseBalance;
	private PurseStatus purseStatus;

	public PurseObserver() {
		purseBalance = new PurseBalance();
		purseBalance.run();
		purseStatus = new PurseStatus();
		purseStatus.run();
	}

	@Override
	public void update(Observable subject, Object info) {
		if (subject instanceof Purse) {
			Purse purse = (Purse) subject;
			double balance = purse.getBalance();
			purseBalance.setMassage(balance);
			purseStatus.setMassage(purse.count() , purse.getCapacity());
		}
	}

}

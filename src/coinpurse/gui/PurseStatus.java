package coinpurse.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class PurseStatus extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField massage;
	private JProgressBar progressBar;

	public PurseStatus() {
		this.setTitle("Purse Status");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initComponent();
		this.setLocation(0, 100);
	}

	private void initComponent() {
		massage = new JTextField("EMPTY", 20);
		massage.setEditable(false);
		progressBar = new JProgressBar(0, 10);

		this.add(massage, BorderLayout.NORTH);
		this.add(progressBar, BorderLayout.SOUTH);

		pack();
	}

	public void run() {
		this.setVisible(true);
	}

	public void setMassage(int change, int capacity) {
		progressBar.setMaximum(capacity);
		progressBar.setValue(change);
		if(progressBar.getValue()==0){
			massage.setText("EMPTY");
		} else if(progressBar.getValue()==capacity){
			massage.setText("FULL");
		} else {
			massage.setText("Purse Contain " + progressBar.getValue() + "/" + capacity);
		}
	}
}

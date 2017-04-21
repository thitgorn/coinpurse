package coinpurse.gui;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class PurseBalance extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField massage;

	public PurseBalance() {
		initComponent();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void initComponent() {
		this.setTitle("Purse Balance");
		massage = new JTextField("0 Baht", 20);
		massage.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 15));
		massage.setEditable(false);
		this.add(massage);
		pack();
	}

	public void run() {
		this.setVisible(true);
	}

	public void setMassage(double balance) {
		this.massage.setText(balance + " baht");
	}
}

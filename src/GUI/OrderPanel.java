package GUI;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.JButton;

public class OrderPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public OrderPanel(String ref, String date, double total) {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setLayout(null);

		JLabel lblref = new JLabel("");
		lblref.setFont(new Font("Times", Font.BOLD, 15));
		lblref.setText(ref);
		lblref.setBounds(18, 17, 100, 23);
		add(lblref);

		JLabel labelDate = new JLabel("");
		labelDate.setFont(new Font("Times", Font.PLAIN, 15));
		labelDate.setText(date);
		labelDate.setBounds(127, 17, 100, 23);
		add(labelDate);

		JLabel lblprice = new JLabel("");

		lblprice.setFont(new Font("Times", Font.PLAIN, 15));
		lblprice.setText(String.valueOf(total) + "€");
		lblprice.setBounds(243, 17, 100, 23);
		add(lblprice);

		JButton btnNewButton = new JButton("Datos");
		btnNewButton.setFont(new Font("Times", Font.PLAIN, 15));
		btnNewButton.setBounds(308, 16, 117, 29);
		add(btnNewButton);

	}

}

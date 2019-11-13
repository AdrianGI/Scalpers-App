package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Data.Cart;
import Data.DB;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class CartWindow extends JFrame {

	private JPanel contentPane;
	private double total;
	static JLabel labelprice;

	/**
	 * Create the frame.
	 */
	public CartWindow(String email) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 50, 650, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel pArriba = new JPanel();
		pArriba.setBackground(Color.WHITE);
		contentPane.add(pArriba, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("CARRITO");
		lblNewLabel.setFont(new Font("Times", Font.BOLD, 16));
		pArriba.add(lblNewLabel);

		JPanel pAbajo = new JPanel();
		pAbajo.setBackground(Color.WHITE);
		contentPane.add(pAbajo, BorderLayout.SOUTH);
		pAbajo.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnNewButton = new JButton("Volver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CartWindow.this.setVisible(false);
				HomeWindow hw = new HomeWindow(email);
				hw.setVisible(true);
			}
		});
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setFont(new Font("Times", Font.PLAIN, 13));
		pAbajo.add(btnNewButton);

		JPanel pCentral = new JPanel();
		pCentral.setBackground(Color.WHITE);

		pCentral.setLayout(new GridLayout(0, 1, 0, 0));
		ArrayList<Cart> cart = DB.GetCart();
		for (Cart c : cart) {

			String route = DB.GetCartRute(c.getRef(), c.getSize(), c.getColour());
			CartPanel pc = new CartPanel(route, c.getUds(), c.getRef(), c.getColour(), c.getSize());
			total = total + (c.getUds() * (DB.GetPrice(c.getRef())));

			pCentral.add(pc);

		}

		JButton btnFinalizarCompra = new JButton("Tramitar Compra");
		btnFinalizarCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DirMethodWindow dm = new DirMethodWindow(email);
				dm.setVisible(true);
				CartWindow.this.setVisible(false);
			}
		});
		btnFinalizarCompra.setHorizontalAlignment(SwingConstants.LEFT);
		btnFinalizarCompra.setFont(new Font("Times", Font.PLAIN, 13));
		pAbajo.add(btnFinalizarCompra);

		JLabel lblTotal = new JLabel("TOTAL");
		lblTotal.setFont(new Font("Times", Font.BOLD, 13));
		pAbajo.add(lblTotal);

		JScrollPane scroll = new JScrollPane(pCentral);
		contentPane.add(scroll, BorderLayout.CENTER);
		setVisible(true);

		labelprice = new JLabel(total + "€");
		labelprice.setFont(new Font("Times", Font.PLAIN, 13));
		pAbajo.add(labelprice);

	}

}

package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Data.Cart;
import Data.DB;

public class PurchaseWindow extends JFrame {

	private JPanel contentPane;
	private double total;
	static JLabel labelprice;

	/**
	 * Create the frame.
	 */
	public PurchaseWindow(String email, int dirid) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 50, 650, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel pArriba = new JPanel();
		pArriba.setBackground(Color.WHITE);
		contentPane.add(pArriba, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("PASO 3 :Resumen de compra");
		lblNewLabel.setFont(new Font("Times", Font.PLAIN, 19));
		pArriba.add(lblNewLabel);

		JPanel pAbajo = new JPanel();
		pAbajo.setBackground(Color.WHITE);
		contentPane.add(pAbajo, BorderLayout.SOUTH);
		pAbajo.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PurchaseWindow.this.setVisible(false);
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
		ArrayList<Cart> cart = DB.GetCart(email);
		for (Cart c : cart) {

			String route = DB.GetCartRute(c.getRef(), c.getSize(), c.getColour());
			CartPanel pc = new CartPanel(route, c.getUds(), c.getRef(), c.getColour(), c.getSize(), true);
			total = total + (c.getUds() * (DB.GetPrice(c.getRef())));

			pCentral.add(pc);

		}

		JButton btnFinalizarCompra = new JButton("Pedir y Pagar");
		btnFinalizarCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(email);
				LocalDate date = java.time.LocalDate.now();
				String datenow = date.toString();
				String ref = randomAlphaNumeric(5);
				DB.newPurchase(DB.maxIdPurchase() + 1, dirid, ref, email, datenow, total);
				DB.DeleteAllCart(email);
				JOptionPane.showMessageDialog(null, "Pedido realizado,puede revisar su pedido en su perfil");
				PurchaseWindow.this.setVisible(false);
				HomeWindow hw = new HomeWindow(email);
				hw.setVisible(true);
				
				
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

	private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public static String randomAlphaNumeric(int count) {
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
	}
}

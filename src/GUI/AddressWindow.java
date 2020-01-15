package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Data.Address;
import Data.Cart;
import Data.DB;
import jdk.nashorn.api.tree.NewTree;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class AddressWindow extends JFrame {
	private JScrollPane scroll;
	private JPanel contentPane;
	private JPanel PanelCentre;
	static JFrame w;
	
	public static void closeWindow() {
		w.dispose();
	}
	/**
	 * 
	 * 
	 * /** Create the frame.
	 */
	public AddressWindow(String email, boolean purchase) {
		w = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 50, 450, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		try {
			DB.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		JPanel panelUp = new JPanel();
		panelUp.setBackground(Color.WHITE);
		contentPane.add(panelUp, BorderLayout.NORTH);
		panelUp.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel("MIS DIRECCIONES");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times", Font.PLAIN, 16));
		panelUp.add(lblNewLabel);

		JButton btnreturn = new JButton("Volver");
		btnreturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (purchase == false) {
					AddressWindow.this.setVisible(false);
					MenuProfileWindow mw = new MenuProfileWindow(email);
					mw.setVisible(true);
				} else {

					DirMethodWindow dm = new DirMethodWindow(email);
					dm.setVisible(true);
					AddressWindow.this.setVisible(false);

				}

			}
		});
		panelUp.add(btnreturn, BorderLayout.EAST);
		btnreturn.setHorizontalAlignment(SwingConstants.LEFT);
		btnreturn.setFont(new Font("Times", Font.PLAIN, 13));

		JPanel panelDown = new JPanel();
		panelDown.setBackground(Color.WHITE);
		contentPane.add(panelDown, BorderLayout.SOUTH);
		panelDown.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel panelCenter = new JPanel();
		panelCenter.setBackground(Color.WHITE);
		contentPane.add(panelCenter, BorderLayout.CENTER);
		panelCenter.setLayout(new GridLayout(0, 1, 0, 0));

		ArrayList<Address> add = DB.GetDir(email);
		for (Address c : add) {

			AddressPanel ap = new AddressPanel(c.getId(), email, purchase);

			panelCenter.add(ap);

		}
		JScrollPane scroll = new JScrollPane(panelCenter);
		contentPane.add(scroll, BorderLayout.CENTER);
		setVisible(true);

		JButton btnNewButton = new JButton("Añadir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				AddressWindow.this.setVisible(false);
				boolean payment = false;
				AddAddressWindow aaw = new AddAddressWindow(email, payment);
				aaw.setVisible(true);
			}
		});

		if (purchase == true) {

			btnNewButton.setVisible(false);
		}

		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setFont(new Font("Times", Font.PLAIN, 13));
		panelDown.add(btnNewButton);

	}

}

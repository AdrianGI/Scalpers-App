package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddressWindow frame = new AddressWindow("adriangi98@opendeusto.es");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddressWindow(String email) {
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
				AddressWindow.this.setVisible(false);
				MenuProfileWindow mw = new MenuProfileWindow(email);
				mw.setVisible(true);

			}
		});
		panelUp.add(btnreturn, BorderLayout.EAST);
		btnreturn.setHorizontalAlignment(SwingConstants.LEFT);
		btnreturn.setFont(new Font("Times", Font.PLAIN, 13));

		ArrayList<Integer> Address = null;

		Address = DB.GetAddress(email);

		for (int i = 0; i < Address.size(); i++) {

			int id = Address.get(i);

			PanelCentre = new AddressPanel(id);
			PanelCentre.setBackground(Color.WHITE);
			contentPane.add(PanelCentre, BorderLayout.CENTER);

			PanelCentre.setLayout(new GridLayout(0, 5, 0, 0));
			scroll = new JScrollPane(PanelCentre);
		}

		contentPane.add(scroll, BorderLayout.CENTER);
		contentPane.updateUI();

		JPanel panelDown = new JPanel();
		panelDown.setBackground(Color.WHITE);
		contentPane.add(panelDown, BorderLayout.SOUTH);
		panelDown.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnNewButton = new JButton("Añadir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddressWindow.this.setVisible(false);
				AddAddressWindow aaw = new AddAddressWindow(email);
				aaw.setVisible(true);
			}
		});

		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setFont(new Font("Times", Font.PLAIN, 13));
		panelDown.add(btnNewButton);

		JButton btnDelet = new JButton("Borrar");
		btnDelet.setFont(new Font("Times", Font.PLAIN, 13));
		panelDown.add(btnDelet);
	}

}
package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import Data.DB;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProfileWindow extends JFrame {

	private JPanel contentPane;

	public ProfileWindow(String email) {
		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 50, 700, 500);

		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelOrders = new JPanel();
		panelOrders.setBackground(Color.WHITE);
		panelOrders.setBounds(0, 57, 229, 421);
		contentPane.add(panelOrders);
		panelOrders.setLayout(null);

		JLabel lblMyOrders = new JLabel("MIS PEDIDOS ");
		lblMyOrders.setBounds(68, 6, 93, 15);
		lblMyOrders.setFont(new Font("Times", Font.PLAIN, 14));
		panelOrders.add(lblMyOrders);

		JPanel panelProfile = new JPanel();
		panelProfile.setBackground(Color.WHITE);
		panelProfile.setBounds(0, 5, 700, 50);
		contentPane.add(panelProfile);
		panelProfile.setLayout(null);

		JLabel lblMyAccount = new JLabel("MI CUENTA");
		lblMyAccount.setBounds(275, 2, 124, 34);
		lblMyAccount.setFont(new Font("Times", Font.BOLD, 20));
		panelProfile.add(lblMyAccount);

		JButton btnReturn = new JButton("Volver");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				HomeWindow ew = new HomeWindow(email);
				ew.setVisible(true);
				ProfileWindow.this.setVisible(false);
			}
		});
		btnReturn.setBorder(null);
		btnReturn.setBounds(636, 7, 58, 29);
		btnReturn.setFont(new Font("Times", Font.BOLD, 13));
		panelProfile.add(btnReturn);

		JPanel panelData = new JPanel();
		panelData.setLayout(null);
		panelData.setBackground(Color.WHITE);
		panelData.setBounds(230, 57, 239, 421);
		contentPane.add(panelData);

		JLabel lblMisData = new JLabel("MIS DATOS PERSONALES");
		lblMisData.setFont(new Font("Times", Font.PLAIN, 14));
		lblMisData.setBounds(26, 6, 179, 15);
		panelData.add(lblMisData);

		JPanel panelDirections = new JPanel();
		panelDirections.setLayout(null);
		panelDirections.setBackground(Color.WHITE);
		panelDirections.setBounds(471, 57, 229, 421);
		contentPane.add(panelDirections);

		JLabel lblDirections = new JLabel("MIS DIRECCIONES");
		lblDirections.setFont(new Font("Times", Font.PLAIN, 14));
		lblDirections.setBounds(50, 6, 128, 15);
		panelDirections.add(lblDirections);

		Border line = BorderFactory.createLineBorder(Color.BLACK, 2);
		panelOrders.setBorder(line);
		panelDirections.setBorder(line);
		panelData.setBorder(line);

		String name = DB.GetName(email);

		if (name.charAt(0) >= 'a' && name.charAt(0) <= 'z') {

			char letra = Character.toUpperCase(name.charAt(0));
			name = letra + name.substring(1);
		}

		String surname = DB.GetSur(email);
		if (surname.charAt(0) >= 'a' && surname.charAt(0) <= 'z') {

			char letra = Character.toUpperCase(surname.charAt(0));
			surname = letra + surname.substring(1);
		}

		JLabel lblName = new JLabel(name + "" + surname);
		lblName.setFont(new Font("Times", Font.PLAIN, 13));
		lblName.setBounds(26, 59, 195, 24);
		panelData.add(lblName);

		JLabel lblEmail = new JLabel(email);
		lblEmail.setFont(new Font("Times", Font.PLAIN, 13));
		lblEmail.setBounds(26, 106, 195, 24);
		panelData.add(lblEmail);

		JLabel lblDate = new JLabel(DB.GetDate(email) + "");
		lblDate.setFont(new Font("Times", Font.PLAIN, 13));
		lblDate.setBounds(26, 152, 195, 24);
		panelData.add(lblDate);

		JLabel labelPC = new JLabel(DB.GetPc(email));
		labelPC.setFont(new Font("Times", Font.PLAIN, 13));
		labelPC.setBounds(26, 199, 195, 24);
		panelData.add(labelPC);

		JLabel labelPhone = new JLabel(DB.GetPhone(email));
		labelPhone.setFont(new Font("Times", Font.PLAIN, 13));
		labelPhone.setBounds(26, 248, 195, 24);
		panelData.add(labelPhone);

		JButton btnEdit = new JButton("EDITAR MIS DATOS");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				EditDataWindow ew = new EditDataWindow(email);
				ew.setVisible(true);
				ProfileWindow.this.setVisible(false);

			}
		});
		btnEdit.setFont(new Font("Times", Font.PLAIN, 13));
		btnEdit.setBounds(20, 331, 201, 39);
		panelData.add(btnEdit);

	}
}

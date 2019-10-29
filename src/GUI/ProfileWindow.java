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
		setBounds(450, 50, 500, 350);

		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelProfile = new JPanel();
		panelProfile.setBackground(Color.WHITE);
		panelProfile.setBounds(0, 5, 500, 50);
		contentPane.add(panelProfile);
		panelProfile.setLayout(null);

		JButton btnReturn = new JButton("Volver");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				MenuProfileWindow mp = new MenuProfileWindow(email);
				mp.setVisible(true);

				ProfileWindow.this.setVisible(false);
			}
		});
		btnReturn.setBorder(null);
		btnReturn.setBounds(436, 15, 58, 29);
		btnReturn.setFont(new Font("Times", Font.BOLD, 13));
		panelProfile.add(btnReturn);

		JLabel lblMisData = new JLabel("MIS DATOS PERSONALES");
		lblMisData.setBounds(147, 21, 201, 15);
		panelProfile.add(lblMisData);
		lblMisData.setFont(new Font("Times", Font.PLAIN, 16));

		JPanel panelData = new JPanel();
		panelData.setLayout(null);
		panelData.setBackground(Color.WHITE);
		panelData.setBounds(0, 57, 500, 284);
		contentPane.add(panelData);

		Border line = BorderFactory.createLineBorder(Color.BLACK, 2);
		panelData.setBorder(null);

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

		JLabel lblName = new JLabel(name + " " + surname);
		lblName.setFont(new Font("Times", Font.PLAIN, 13));
		lblName.setBounds(222, 16, 195, 24);
		panelData.add(lblName);

		JLabel lblEmail = new JLabel(email);
		lblEmail.setFont(new Font("Times", Font.PLAIN, 13));
		lblEmail.setBounds(222, 56, 195, 24);
		panelData.add(lblEmail);

		JLabel lblDate = new JLabel(DB.GetDate(email) + "");
		lblDate.setFont(new Font("Times", Font.PLAIN, 13));
		lblDate.setBounds(222, 92, 195, 24);
		panelData.add(lblDate);

		JLabel labelPC = new JLabel(DB.GetPc(email));
		labelPC.setFont(new Font("Times", Font.PLAIN, 13));
		labelPC.setBounds(222, 128, 195, 24);
		panelData.add(labelPC);

		JLabel labelPhone = new JLabel(DB.GetPhone(email));
		labelPhone.setFont(new Font("Times", Font.PLAIN, 13));
		labelPhone.setBounds(222, 162, 195, 24);
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
		btnEdit.setBounds(132, 229, 201, 39);
		panelData.add(btnEdit);

		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setFont(new Font("Times", Font.PLAIN, 13));
		lblNewLabel.setBounds(75, 20, 61, 16);
		panelData.add(lblNewLabel);

		JLabel Email = new JLabel("Email:");
		Email.setFont(new Font("Times", Font.PLAIN, 13));
		Email.setBounds(75, 60, 61, 16);
		panelData.add(Email);

		JLabel Date = new JLabel("Fecha de Nacimiento:");
		Date.setFont(new Font("Times", Font.PLAIN, 13));
		Date.setBounds(75, 96, 124, 16);
		panelData.add(Date);

		JLabel lblCdigoPostal = new JLabel("Código Postal:");
		lblCdigoPostal.setFont(new Font("Times", Font.PLAIN, 13));
		lblCdigoPostal.setBounds(75, 132, 104, 16);
		panelData.add(lblCdigoPostal);

		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setFont(new Font("Times", Font.PLAIN, 13));
		lblTelefono.setBounds(75, 166, 61, 16);
		panelData.add(lblTelefono);

	}
}

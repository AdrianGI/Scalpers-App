package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Data.DB;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class DeleteUserWindow extends JFrame {

	private JPanel contentPane;
	private JTextField textUser;

	/**
	 * Create the frame.
	 */
	public DeleteUserWindow() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 50, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textUser = new JTextField();
		textUser.setFont(new Font("Times", Font.PLAIN, 13));
		textUser.setBounds(12, 140, 419, 26);
		contentPane.add(textUser);
		textUser.setColumns(10);

		JLabel lblNewLabel = new JLabel("Introduzca el Email del usuario que desea eliminar");
		lblNewLabel.setFont(new Font("Times", Font.PLAIN, 20));
		lblNewLabel.setBounds(12, 47, 438, 26);
		contentPane.add(lblNewLabel);

		try {
			DB.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JButton btnDelete = new JButton("Eliminar");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DB.DeleteUser(textUser.getText());
				textUser.setText(null);
				JOptionPane.showMessageDialog(null, "Usuario Eliminado");

			}
		});
		btnDelete.setBorder(null);
		btnDelete.setFont(new Font("Times", Font.BOLD, 14));
		btnDelete.setBounds(278, 227, 117, 29);
		contentPane.add(btnDelete);

		JButton btnReturn = new JButton("Volver");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteUserWindow.this.setVisible(false);
				AdminWindow aw = new AdminWindow();
				aw.setVisible(true);

			}
		});
		btnReturn.setBorder(null);
		btnReturn.setFont(new Font("Times", Font.BOLD, 14));
		btnReturn.setBounds(58, 226, 117, 29);
		contentPane.add(btnReturn);
	}
}

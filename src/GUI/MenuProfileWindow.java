package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuProfileWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public MenuProfileWindow(String email) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 50, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblMyAccount = new JLabel("MI CUENTA");
		lblMyAccount.setFont(new Font("Times", Font.BOLD, 20));
		lblMyAccount.setBounds(152, 19, 120, 29);
		contentPane.add(lblMyAccount);

		JButton btnprofile = new JButton("Mis Datos Personales ");
		btnprofile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuProfileWindow.this.setVisible(false);
				ProfileWindow pw = new ProfileWindow(email);
				pw.setVisible(true);

			}
		});

		btnprofile.setFont(new Font("Times", Font.PLAIN, 15));
		btnprofile.setBounds(131, 81, 170, 29);
		contentPane.add(btnprofile);

		JButton btnDir = new JButton("Mis Direcciones ");
		btnDir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuProfileWindow.this.setVisible(false);
				AddressWindow aw = new AddressWindow(email);
				aw.setVisible(true);
			}
		});

		btnDir.setFont(new Font("Times", Font.PLAIN, 15));
		btnDir.setBounds(131, 136, 170, 29);
		contentPane.add(btnDir);

		JButton btnMisPedidos = new JButton("Mis Pedidos");

		btnMisPedidos.setFont(new Font("Times", Font.PLAIN, 15));
		btnMisPedidos.setBounds(131, 193, 170, 29);
		contentPane.add(btnMisPedidos);

		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon("photos/profile.png"));
		lblNewLabel.setBounds(372, 6, 54, 42);
		contentPane.add(lblNewLabel);

		JButton btnNewButton = new JButton("Volver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuProfileWindow.this.setVisible(false);
				HomeWindow hw = new HomeWindow(email);
				hw.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Times", Font.PLAIN, 15));
		btnNewButton.setBounds(327, 243, 117, 29);
		contentPane.add(btnNewButton);
	}

}

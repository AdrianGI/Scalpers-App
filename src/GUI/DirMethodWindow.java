package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DirMethodWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public DirMethodWindow(String email) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 50, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("TRAMITAR PEDIDO");
		lblNewLabel.setFont(new Font("Times", Font.PLAIN, 24));
		lblNewLabel.setBounds(110, 21, 231, 23);
		contentPane.add(lblNewLabel);

		JLabel lblDirecciones = new JLabel("PASO 1: Dirección de envío");
		lblDirecciones.setFont(new Font("Times", Font.PLAIN, 20));
		lblDirecciones.setBounds(110, 85, 231, 23);
		contentPane.add(lblDirecciones);

		JButton btnNewButton = new JButton("Añadir dirección de envío");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean payment = true;
				AddAddressWindow a = new AddAddressWindow(email, payment);
				a.setVisible(true);
				DirMethodWindow.this.setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Times", Font.PLAIN, 13));
		btnNewButton.setBounds(110, 148, 231, 29);
		contentPane.add(btnNewButton);

		JButton btnSleccionarDireccinDe = new JButton("Seleccionar dirección de envío");
		btnSleccionarDireccinDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				AddressWindow aw = new AddressWindow(email, true);
				aw.setVisible(true);
				DirMethodWindow.this.setVisible(false);
			}
		});
		btnSleccionarDireccinDe.setFont(new Font("Times", Font.PLAIN, 13));
		btnSleccionarDireccinDe.setBounds(110, 189, 231, 29);
		contentPane.add(btnSleccionarDireccinDe);

		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DirMethodWindow.this.setVisible(false);
				HomeWindow hw = new HomeWindow(email);
				hw.setVisible(true);

			}
		});
		btnVolver.setFont(new Font("Times", Font.PLAIN, 13));
		btnVolver.setBounds(6, 243, 117, 29);
		contentPane.add(btnVolver);
	}
}

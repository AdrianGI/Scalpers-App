package GUI;


import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



public class AdminWindow extends JFrame {

	private JPanel contentPane;



	/**
	 * Create the frame.
	 */
	public AdminWindow() {
		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 50, 600, 400);

		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnDeleteUsers = new JButton(new ImageIcon("photos/deleteuser.png"));
		btnDeleteUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminWindow.this.setVisible(false);
				DeleteUserWindow dw = new DeleteUserWindow ();
				dw.setVisible(true);
			}
		});
		btnDeleteUsers.setBorder(null);
		btnDeleteUsers.setToolTipText("Añadir Usuarios");
		btnDeleteUsers.setBounds(338, 4, 34, 34);
		contentPane.add(btnDeleteUsers);

		JButton btnView = new JButton(new ImageIcon("photos/view.png"));
		btnView.setBorder(null);
		btnView.setToolTipText("Ver");
		btnView.setBounds(460, 3, 34, 35);
		contentPane.add(btnView);

		JButton btndeleteProducts = new JButton(new ImageIcon("photos/deleteproduct.png"));
		btndeleteProducts.setBorder(null);
		btndeleteProducts.setToolTipText("Eliminar Productos");
		btndeleteProducts.setBounds(125, 4, 34, 34);
		contentPane.add(btndeleteProducts);

		JButton btnAddusers = new JButton(new ImageIcon("photos/adduser.png"));
		btnAddusers.setToolTipText("Añadir Usuarios");
		btnAddusers.setBorder(null);
		btnAddusers.setBounds(238, 4, 34, 34);
		contentPane.add(btnAddusers);

		JLabel lblmen = new JLabel(new ImageIcon("photos/scalpers.jpg"));
		lblmen.setBounds(0, 134, 594, 238);
		contentPane.add(lblmen);

		JButton btnexit = new JButton(new ImageIcon("photos/exit.png"));
		btnexit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				LoginWindow lw = new LoginWindow();
				lw.setVisible(true);
				AdminWindow.this.setVisible(false);

			}
		});
		btnexit.setBorder(null);
		btnexit.setToolTipText("Salir");
		btnexit.setBounds(560, 5, 34, 34);
		contentPane.add(btnexit);

		JLabel lblNewLabel = new JLabel("Bienvenido,");
		lblNewLabel.setFont(new Font("Times", Font.PLAIN, 18));
		lblNewLabel.setBounds(193, 95, 117, 27);
		contentPane.add(lblNewLabel);

	

		JLabel lblAdministrador = new JLabel("Administrador");
		lblAdministrador.setFont(new Font("Times", Font.BOLD, 18));
		lblAdministrador.setBounds(285, 95, 129, 27);
		contentPane.add(lblAdministrador);

		JButton btnenter = new JButton(new ImageIcon("photos/addproduct.png"));

		btnenter.setBorder(null);
		
		btnenter.setToolTipText("Añadir Productos");
		btnenter.setBounds(16, 5, 41, 34);
		contentPane.add(btnenter);

	}
}

package GUI;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Data.DB;
import File.FileManagement;

import javax.swing.Icon;

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
				DeleteUserWindow dw = new DeleteUserWindow();
				dw.setVisible(true);
			}
		});
		btnDeleteUsers.setBorder(null);
		btnDeleteUsers.setToolTipText("Añadir Usuarios");
		btnDeleteUsers.setBounds(145, 4, 34, 34);
		contentPane.add(btnDeleteUsers);

		JButton btnView = new JButton(new ImageIcon("photos/view.png"));
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileManagement.Ranking(DB.getAllemails());
				AdminWindow.this.setVisible(false);
				RankWindow rw = new RankWindow();
				rw.setVisible(true);
			}
		});
		btnView.setBorder(null);
		btnView.setToolTipText("Ver");
		btnView.setBounds(426, 4, 34, 35);
		contentPane.add(btnView);

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

		JButton btnProducts = new JButton(new ImageIcon("photos/edit.png"));
		btnProducts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				AdminWindow.this.setVisible(false);
				String ref = JOptionPane.showInputDialog("Introduce la referencia del producto: ");
				if (ref == null) {
					AdminWindow a = new AdminWindow();
					a.setVisible(true);

				}
				ManageProductWindow mg = new ManageProductWindow(ref);
				mg.setVisible(true);
			}
		});

		btnProducts.setBorder(null);

		btnProducts.setToolTipText("Añadir Productos");
		btnProducts.setBounds(26, 4, 41, 34);
		contentPane.add(btnProducts);

		JButton btnAdd = new JButton(new ImageIcon("photos/addproduct.png"));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddProductWindow ap = new AddProductWindow();
				ap.setVisible(true);
				AdminWindow.this.setVisible(false);
			}
		});
		btnAdd.setToolTipText("Añadir Usuarios");
		btnAdd.setBorder(null);
		btnAdd.setBounds(276, 4, 34, 34);
		contentPane.add(btnAdd);

	}
}

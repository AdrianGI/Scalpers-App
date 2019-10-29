package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Data.DB;
import Data.User;

import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.Font;
import javax.swing.Icon;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class HomeWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 * 
	 * @param email
	 */
	public HomeWindow(String email) {

		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 50, 600, 400);

		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnprofile = new JButton(new ImageIcon("photos/profile.png"));
		btnprofile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				MenuProfileWindow mp = new MenuProfileWindow(email);
				mp.setVisible(true);
				HomeWindow.this.setVisible(false);
			}
		});
		btnprofile.setToolTipText("Perfil");
		btnprofile.setBounds(350, 4, 34, 34);
		contentPane.add(btnprofile);

		JButton btncart = new JButton(new ImageIcon("photos/cart.png"));
		btncart.setToolTipText("Carrito");
		btncart.setBounds(460, 3, 34, 35);
		contentPane.add(btncart);

		JButton btnsearch = new JButton(new ImageIcon("photos/search.png"));
		btnsearch.setToolTipText("Buscar");
		btnsearch.setBounds(125, 4, 34, 34);
		contentPane.add(btnsearch);

		JButton btnstores = new JButton(new ImageIcon("photos/stores.png"));
		btnstores.setToolTipText("Tiendas");
		btnstores.setBorder(null);
		btnstores.setBounds(238, 4, 34, 34);
		contentPane.add(btnstores);

		JLabel lblmen = new JLabel(new ImageIcon("photos/scalpers.jpg"));
		lblmen.setBounds(0, 134, 594, 238);
		contentPane.add(lblmen);

		JButton btnexit = new JButton(new ImageIcon("photos/exit.png"));
		btnexit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File file = new File("usuarios.ini");
				file.delete();
				LoginWindow lw = new LoginWindow();
				lw.setVisible(true);
				HomeWindow.this.setVisible(false);

			}
		});
		btnexit.setBorder(null);
		btnexit.setToolTipText("Salir");
		btnexit.setBounds(560, 5, 34, 34);
		contentPane.add(btnexit);

		JLabel lblNewLabel = new JLabel("Bienvenido/a,");
		lblNewLabel.setFont(new Font("Times", Font.PLAIN, 18));
		lblNewLabel.setBounds(215, 95, 117, 27);
		contentPane.add(lblNewLabel);

		String nombre = DB.Username(email);
		if (nombre.charAt(0) >= 'a' && nombre.charAt(0) <= 'z') {

			char letra = Character.toUpperCase(nombre.charAt(0));
			nombre = letra + nombre.substring(1);
		}
		try {
			DB.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {

				Main.Main.setProperties(email);

			}

		});

		JLabel label = new JLabel(nombre);
		label.setFont(new Font("Times", Font.BOLD, 18));
		label.setBounds(321, 95, 100, 27);
		contentPane.add(label);

		JButton btnenter = new JButton(new ImageIcon("photos/enter.png"));

		btnenter.setBorder(null);
		btnenter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomeWindow.this.setVisible(false);
				ProductsWindow a = new ProductsWindow(email);
				a.setVisible(true);
			}
		});
		btnenter.setToolTipText("Buscar");
		btnenter.setBounds(6, 4, 41, 34);
		contentPane.add(btnenter);

	}
}

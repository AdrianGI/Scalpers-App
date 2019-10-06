package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.Font;
import javax.swing.Icon;

public class HomeWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeWindow frame = new HomeWindow();
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
	public HomeWindow() {
		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 50, 600, 400);

		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JMenuBar menuBarH = new JMenuBar();
		menuBarH.setBorderPainted(false);
		menuBarH.setFont(new Font("Times", Font.BOLD, 13));
		menuBarH.setBackground(Color.WHITE);
		menuBarH.setBounds(12, 5, 76, 27);
		contentPane.add(menuBarH);

		JMenu menuh = new JMenu("HOMBRE");
		menuBarH.add(menuh);

		JMenuItem h1 = new JMenuItem("Camisas");
		h1.setBackground(Color.WHITE);
		h1.setFont(new Font("Times", Font.PLAIN, 13));
		JMenuItem h2 = new JMenuItem("Camisetas");
		h2.setBackground(Color.WHITE);
		h2.setFont(new Font("Times", Font.PLAIN, 13));
		JMenuItem h3 = new JMenuItem("Polos");
		h3.setFont(new Font("Times", Font.PLAIN, 13));
		h3.setBackground(Color.WHITE);
		JMenuItem h4 = new JMenuItem("Sudaderas");
		h4.setFont(new Font("Times", Font.PLAIN, 13));
		h4.setBackground(Color.WHITE);
		JMenuItem h5 = new JMenuItem("Pulseras");
		h5.setFont(new Font("Times", Font.PLAIN, 13));
		h5.setBackground(Color.WHITE);
		JMenuItem h6 = new JMenuItem("Gorras");
		h6.setFont(new Font("Times", Font.PLAIN, 13));
		h6.setBackground(Color.WHITE);

		menuh.add(h1);
		menuh.add(h2);
		menuh.add(h3);
		menuh.add(h4);
		menuh.add(h5);
		menuh.add(h6);

		JMenuBar menuBarM = new JMenuBar();
		menuBarM.setBorderPainted(false);
		menuBarM.setFont(new Font("Times", Font.BOLD, 14));
		menuBarM.setBackground(Color.WHITE);
		menuBarM.setBounds(100, 5, 61, 27);
		contentPane.add(menuBarM);

		JMenu menum = new JMenu("MUJER");

		menuBarM.add(menum);
		menum.setBackground(Color.WHITE);
		JMenuItem m1 = new JMenuItem("Camisas");
		m1.setBackground(Color.WHITE);
		m1.setFont(new Font("Times", Font.PLAIN, 13));
		JMenuItem m2 = new JMenuItem("Camisetas");
		m2.setBackground(Color.WHITE);
		m2.setFont(new Font("Times", Font.PLAIN, 13));
		JMenuItem m3 = new JMenuItem("Vestidos");
		m3.setFont(new Font("Times", Font.PLAIN, 13));
		m3.setBackground(Color.WHITE);
		JMenuItem m4 = new JMenuItem("Sudaderas");
		m4.setFont(new Font("Times", Font.PLAIN, 13));
		m4.setBackground(Color.WHITE);
		JMenuItem m5 = new JMenuItem("Bisutería");
		m5.setFont(new Font("Times", Font.PLAIN, 13));
		m5.setBackground(Color.WHITE);
		JMenuItem m6 = new JMenuItem("Gafas");
		m6.setFont(new Font("Times", Font.PLAIN, 13));
		m6.setBackground(Color.WHITE);

		menum.add(m1);
		menum.add(m2);
		menum.add(m3);
		menum.add(m4);
		menum.add(m5);
		menum.add(m6);

		JButton btnprofile = new JButton(new ImageIcon("photos/profile.png"));
		btnprofile.setToolTipText("Perfil");
		btnprofile.setBounds(447, 6, 34, 34);
		contentPane.add(btnprofile);

		JButton btncart = new JButton(new ImageIcon("photos/cart.png"));
		btncart.setToolTipText("Carrito");
		btncart.setBounds(506, 4, 34, 35);
		contentPane.add(btncart);

		JButton btnsearch = new JButton(new ImageIcon("photos/search.png"));
		btnsearch.setToolTipText("Buscar");
		btnsearch.setBounds(326, 5, 34, 34); 
		contentPane.add(btnsearch);

		JButton btnstores = new JButton(new ImageIcon("photos/stores.png"));
		btnstores.setToolTipText("Tiendas");
		btnstores.setBorder(null);
		btnstores.setBounds(387, 5, 34, 34); 
		contentPane.add(btnstores);

		JLabel lblmen = new JLabel(new ImageIcon("photos/scalpers.jpg"));
		lblmen.setBounds(0, 47, 594, 331);
		contentPane.add(lblmen);
		
		JButton btnexit = new JButton(new ImageIcon("photos/exit.png"));
		btnexit.setBorder(null);
		btnexit.setToolTipText("Salir");
		btnexit.setBounds(560, 5, 34, 34);
		contentPane.add(btnexit);

	}
}

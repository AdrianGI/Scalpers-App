package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Data.DB;
import Data.Order;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OrdersWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DB.getConnection();
					OrdersWindow frame = new OrdersWindow("adriangi98@opendeusto.es");
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
	public OrdersWindow(String email ) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 50, 500, 360);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Referencia del Pedido");
		lblNewLabel.setFont(new Font("Times", Font.PLAIN, 18));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		panel.add(lblNewLabel_1);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setFont(new Font("Times", Font.PLAIN, 18));
		panel.add(lblFecha);
		
		JLabel lblPrecioTotal = new JLabel("Precio Total");
		lblPrecioTotal.setFont(new Font("Times", Font.PLAIN, 18));
		panel.add(lblPrecioTotal);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrdersWindow.this.setVisible(false);
				MenuProfileWindow mp = new MenuProfileWindow(email);
				mp.setVisible(true);
			}
		});
		btnVolver.setFont(new Font("Times", Font.PLAIN, 13));
		panel_1.add(btnVolver);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		contentPane.add(panel_3, BorderLayout.CENTER);
		
		
		
		
		ArrayList<Order> order = DB.GetOrder(email);
		for (Order c : order) {

		
			OrderPanel op = new OrderPanel(c.getRef(),c.getDate(),c.getTotal());
			
			panel_3.add(op);

		}

		JScrollPane scroll = new JScrollPane(panel_3);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));
		contentPane.add(scroll, BorderLayout.CENTER);
		setVisible(true);
		
		

	}

		
		
		
		
	}

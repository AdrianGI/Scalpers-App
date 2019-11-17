package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Data.DB;

import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Icon;

public class ProductWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the applicati
	 * 
	 * /** Create the frame.
	 */

	public ProductWindow(String route, JFrame v, String email) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 50, 500, 480);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);

		ImageIcon im = new ImageIcon(route);
		Image image = im.getImage();
		Image newimg = image.getScaledInstance(200, 250, java.awt.Image.SCALE_SMOOTH);
		im = new ImageIcon(newimg);
		contentPane.setLayout(null);
		JLabel lblPhoto = new JLabel(im);
		lblPhoto.setBounds(265, 89, 198, 209);
		


		getContentPane().add(lblPhoto);

		JLabel title = new JLabel(DB.getProductTittle(route));
		title.setBounds(16, 54, 419, 14);
		title.setFont(new Font("Times", Font.BOLD, 13));
		

		getContentPane().add(title);

		JLabel price = new JLabel("€" + String.valueOf(DB.getProductPrice(route)));
		price.setBounds(16, 210, 129, 14);
		price.setFont(new Font("Times", Font.PLAIN, 13));
		
		getContentPane().add(price);

		JLabel ref = new JLabel("Ref " + DB.GetImageRef(route));
		ref.setBounds(16, 98, 147, 14);
		ref.setFont(new Font("Times", Font.PLAIN, 13));
		
		getContentPane().add(ref);

		JTextArea description = new JTextArea(DB.getProductDescription(route), 2, 1);
		description.setBounds(16, 140, 129, 58);
		// JScrollPane scrollDescripcion = new
		// JScrollPane(descripcion,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		description.setFont(new Font("Times", Font.PLAIN, 13));
		
		getContentPane().add(description);
		

		String SelectedColour = DB.GetColourUnique(route);

		ArrayList<String> colours = DB.getProductColour(route);
		String colores[] = new String[colours.size()];

		for (int i = 0; i < colours.size(); i++) {

			colores[i] = colours.get(i);
		}

		
		
		JComboBox<String> cbColours = new JComboBox<String>(colores);
		cbColours.setSelectedItem(SelectedColour);
		cbColours.setBounds(16, 250, 129, 30);
		
		add(cbColours);

		ArrayList<String> sizes = DB.getProductSizes(route, String.valueOf(cbColours.getSelectedItem()));

		String size[] = new String[sizes.size()];

		for (int i = 0; i < sizes.size(); i++) {

			size[i] = sizes.get(i);
		}

		JComboBox<String> cbsize = new JComboBox<String>(size);
		cbsize.setBounds(16, 300, 129, 30);
		
		add(cbsize);


		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(38, 377, 81, 29);
		btnVolver.setBackground(Color.WHITE);
		btnVolver.setFont(new Font("Times", Font.PLAIN, 13));
		
		getContentPane().add(btnVolver);
		btnVolver.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ProductWindow.this.setVisible(false);
				v.setVisible(true);
			}
		});


		JButton btnAdd = new JButton("AÑADIR A LA CESTA");
		btnAdd.setBounds(295, 363, 169, 29);
		btnAdd.setBackground(Color.WHITE);
		btnAdd.addActionListener(new ActionListener() {

			
			ArrayList<String> c = new ArrayList<String>();

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

				if (DB.GetStock(ref.getText().substring(4), String.valueOf(cbsize.getSelectedItem()),
						String.valueOf(cbColours.getSelectedItem())) > 0) {

					int id = DB.maxIdCart();
					DB.addCart(id++, email, title.getText(), String.valueOf(cbColours.getSelectedItem()),
							String.valueOf(cbsize.getSelectedItem()), 1, ref.getText().substring(3),
							DB.getProductPrice(route), route);
					String SelectedColour = String.valueOf(cbColours.getSelectedItem());
					c = DB.getProductColour(route);
					cbColours.removeAllItems();
					for (int i = 0; i < c.size(); i++)
						cbColours.addItem(c.get(i));

					c = DB.getProductSizes(route, SelectedColour);
					cbsize.removeAllItems();
					for (int i = 0; i < c.size(); i++)
						cbsize.addItem(c.get(i));

					JOptionPane.showMessageDialog(null, "Producto añadido a la cesta");
				} else {
					JOptionPane.showMessageDialog(null, "Stock Insuficiente ");

				}

			}
		
		});
		btnAdd.setFont(new Font("Times", Font.PLAIN, 13));
		
		getContentPane().add(btnAdd);

		setVisible(true);

	}
}

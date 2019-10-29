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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ProductWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the applicati
	 * 
	 * /** Create the frame.
	 */

	public ProductWindow(String route, JFrame v) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 50, 650, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		GridBagLayout gbl_contentPane = new GridBagLayout();

		gbl_contentPane.columnWidths = new int[] { 20 };
		gbl_contentPane.rowHeights = new int[] { 10 };

		contentPane.setLayout(gbl_contentPane);

		ImageIcon im = new ImageIcon(route);
		JLabel lblPhoto = new JLabel(im);
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridwidth = 20;
		constraints.gridheight = 10;
		constraints.gridx = 0; // En qué columna empieza
		constraints.gridy = 1; // En qué fila empieza
		constraints.gridwidth = 9; // Cuántas columnas ocupa
		constraints.gridheight = 8; // Cuántas filas ocupa
		constraints.fill = GridBagConstraints.BOTH;
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.weighty = 15;

		add(lblPhoto, constraints);

		JLabel title = new JLabel(DB.getProductTittle(route));
		title.setFont(new Font("Times", Font.BOLD, 13));
		constraints.gridx = 13; // En qué columna empieza
		constraints.gridy = 2; // En qué fila empieza
		constraints.gridwidth = 6; // Cuántas columnas ocupa
		constraints.gridheight = 1; // Cuántas filas ocupa

		add(title, constraints);

		JLabel price = new JLabel("€" + String.valueOf(DB.getProductPrice(route)));
		price.setFont(new Font("Times", Font.PLAIN, 13));
		constraints.gridx = 13; // En qué columna empieza
		constraints.gridy = 3; // En qué fila empieza
		constraints.gridwidth = 3; // Cuántas columnas ocupa
		constraints.gridheight = 1; // Cuántas filas ocupa
		add(price, constraints);

		JLabel ref = new JLabel("Ref" + DB.GetImageRef(route));
		ref.setFont(new Font("Times", Font.PLAIN, 13));
		constraints.gridx = 13; // En qué columna empieza
		constraints.gridy = 4; // En qué fila empieza
		constraints.gridwidth = 6; // Cuántas columnas ocupa
		constraints.gridheight = 1; // Cuántas filas ocupa
		add(ref, constraints);

		JTextArea description = new JTextArea(DB.getProductDescription(route), 2, 1);
		// JScrollPane scrollDescripcion = new
		// JScrollPane(descripcion,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		description.setFont(new Font("Times", Font.PLAIN, 13));
		constraints.gridx = 13;
		constraints.gridy = 5;
		constraints.gridwidth = 7;
		constraints.gridheight = 3;
		constraints.weighty = 1.0;
		constraints.fill = GridBagConstraints.BOTH;
		add(description, constraints);
		constraints.fill = GridBagConstraints.NONE;

		String SelectedColour = DB.GetColourUnique(route);

		ArrayList<String> colours = DB.getProductColour(route);
		String colores[] = new String[colours.size()];

		for (int i = 0; i < colours.size(); i++) {

			colores[i] = colours.get(i);
		}

		JComboBox<String> cbColours = new JComboBox<String>(colores);
		cbColours.setSelectedItem(SelectedColour);
		constraints.gridx = 13;
		constraints.gridy = 8;
		constraints.gridwidth = 3;
		constraints.gridheight = 1;
		add(cbColours, constraints);

		ArrayList<String> sizes = DB.getProductSizes(route, String.valueOf(cbColours.getSelectedItem()));

		String size[] = new String[sizes.size()];

		for (int i = 0; i < sizes.size(); i++) {

			size[i] = sizes.get(i);
		}

		JComboBox<String> cbsize = new JComboBox<String>(size);
		constraints.gridx = 17;
		constraints.gridy = 8;
		constraints.gridwidth = 3;
		constraints.gridheight = 1;
		add(cbsize, constraints);

		cbColours.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				ArrayList<String> sizes = DB.getProductSizes(route, String.valueOf(cbColours.getSelectedItem()));
				cbsize.removeAllItems();
				for (int i = 0; i < sizes.size(); i++) {
					cbsize.addItem(sizes.get(i));
				}

			}
		});

		JButton btnVolver = new JButton("Volver");
		btnVolver.setBackground(Color.WHITE);
		btnVolver.setFont(new Font("Times", Font.PLAIN, 13));
		constraints.gridx = 6;
		constraints.gridy = 11;
		constraints.gridwidth = 5;
		constraints.gridheight = 1;
		add(btnVolver, constraints);
		btnVolver.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ProductWindow.this.setVisible(false);
				v.setVisible(true);
			}
		});

		JButton btnAdd = new JButton("AÑADIR A LA CESTA");
		btnAdd.setBackground(Color.WHITE);
		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				DB.addCart(title.getText(), String.valueOf(cbColours.getSelectedItem()),
						String.valueOf(cbsize.getSelectedItem()), 1, ref.getText().substring(3),
						DB.getProductPrice(route));
				String SelectedColour = String.valueOf(cbColours.getSelectedItem());
				ArrayList<String> c = DB.getProductColour(route);
				cbColours.removeAllItems();

				for (int i = 0; i < c.size(); i++)
					cbColours.addItem(c.get(i));

				c = DB.getProductSizes(route, SelectedColour);
				cbsize.removeAllItems();
				for (int i = 0; i < c.size(); i++)
					cbsize.addItem(c.get(i));

				JOptionPane.showMessageDialog(null, "Producto añadido a la cesta");
			}
		});
		btnAdd.setFont(new Font("Times", Font.PLAIN, 13));
		constraints.gridx = 13;
		constraints.gridy = 11;
		constraints.gridwidth = 6;
		constraints.gridheight = 1;
		add(btnAdd, constraints);

		setVisible(true);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
}

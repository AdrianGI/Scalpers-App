package GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Data.DB;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CartPanel extends JPanel {
	private JTextField txtPrecio;
	private int boughtuds;
	private int def;

	/**
	 * Create the panel.
	 */
	public CartPanel(String route, int uds, String ref, String colour, String size, boolean purchase) {

		def = uds;

		setLayout(new BorderLayout(0, 0));

		JPanel up = new JPanel();
		up.setBackground(Color.WHITE);
		add(up, BorderLayout.NORTH);

		JPanel down = new JPanel();
		down.setBackground(Color.WHITE);
		add(down, BorderLayout.SOUTH);

		JPanel pcentre = new JPanel();
		pcentre.setBackground(Color.WHITE);
		add(pcentre, BorderLayout.CENTER);
		pcentre.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel pPhoto = new JPanel();
		pPhoto.setBackground(Color.WHITE);
		pcentre.add(pPhoto);

		ImageIcon im = new ImageIcon(route);
		Image image = im.getImage();
		Image newimg = image.getScaledInstance(200, 250, java.awt.Image.SCALE_SMOOTH);
		im = new ImageIcon(newimg);
		JLabel lblPhoto = new JLabel(im);
		pPhoto.add(lblPhoto);

		JPanel ProductDetails = new JPanel();
		ProductDetails.setBackground(Color.WHITE);
		pcentre.add(ProductDetails);
		ProductDetails.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Times", Font.BOLD, 14));
		lblNewLabel.setText(DB.getProductTittle(route));
		lblNewLabel.setBounds(6, 33, 219, 16);
		ProductDetails.add(lblNewLabel);

		JLabel lblNewLabelColour = new JLabel("");
		lblNewLabelColour.setFont(new Font("Times", Font.PLAIN, 13));
		lblNewLabelColour.setText(colour);
		lblNewLabelColour.setBounds(72, 74, 61, 16);
		ProductDetails.add(lblNewLabelColour);

		JLabel labelSize = new JLabel("");
		labelSize.setFont(new Font("Times", Font.PLAIN, 13));
		labelSize.setText(size);
		labelSize.setBounds(72, 113, 61, 16);
		ProductDetails.add(labelSize);

		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("Times", Font.PLAIN, 13));
		spinner.setBackground(Color.WHITE);
		spinner.setBounds(28, 154, 34, 26);
		spinner.setValue(new Integer(DB.Getuds(ref, colour, size)));

		ProductDetails.add(spinner);

		JLabel labelPrice = new JLabel("");
		labelPrice.setFont(new Font("Times", Font.PLAIN, 13));
		labelPrice.setBounds(27, 199, 61, 16);
		labelPrice.setText(String.valueOf(DB.GetPrice(ref) * uds + "€"));
		ProductDetails.add(labelPrice);

		JLabel lblTalla = new JLabel("Talla:");
		lblTalla.setFont(new Font("Times", Font.PLAIN, 13));
		lblTalla.setBounds(12, 74, 61, 16);
		ProductDetails.add(lblTalla);

		JLabel lblColor = new JLabel("Color:");
		lblColor.setFont(new Font("Times", Font.PLAIN, 13));
		lblColor.setBounds(12, 113, 61, 16);
		ProductDetails.add(lblColor);

		spinner.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub

				int value = ((Integer) spinner.getValue()).intValue();

				int unidadesRestantes = DB.GetStock(ref, size, colour);

				if (unidadesRestantes >= value) {

					if (value > 0) {

						if (value > def) {
							def = value;
							DB.UpdateCart(ref, colour, size, def);
							DB.PlusStockCart(ref, colour, size);

							labelPrice.setText(String.valueOf(DB.GetPrice(ref) * def + "€"));
							labelPrice.updateUI();
							String t = CartWindow.labelprice.getText();
							double total = Double.parseDouble(t.substring(0, t.length() - 1)) + DB.GetPrice(ref);
							CartWindow.labelprice.setText(total + "€");
							CartWindow.labelprice.updateUI();

							DB.UpdateStock(ref, colour, size, (DB.GetStock(ref, size, colour) - 1));
						} else {

							if (value < def && value != 1) {
								def = value;
								DB.UpdateCart(ref, colour, size, def);
								DB.MinusStockCart(ref, colour, size);
								labelPrice.setText(String.valueOf(DB.GetPrice(ref) * def + "€"));
								labelPrice.updateUI();
								String t = CartWindow.labelprice.getText();
								double total = Double.parseDouble(t.substring(0, t.length() - 1)) - DB.GetPrice(ref);
								CartWindow.labelprice.setText(total + "€");
								CartWindow.labelprice.updateUI();
								DB.UpdateStock(ref, colour, size, (DB.GetStock(ref, size, colour) + 1));

							} else {
								if (value < def && value == 1) {
									def = value;
									DB.UpdateCart(ref, colour, size, def);
									DB.MinusStockCart(ref, colour, size);
									labelPrice.setText(String.valueOf(DB.GetPrice(ref) + "€"));
									labelPrice.updateUI();
									String t = CartWindow.labelprice.getText();
									double total = Double.parseDouble(t.substring(0, t.length() - 1))
											- DB.GetPrice(ref);
									CartWindow.labelprice.setText(total + "€");
									CartWindow.labelprice.updateUI();
									DB.UpdateStock(ref, colour, size, (DB.GetStock(ref, size, colour) + 1));

								}
							}

						}

					} else {

						JOptionPane.showMessageDialog(null, "Producto Eliminado");
						DB.DeleteCart(ref, colour, size);
						def = value;

						labelPrice.setText(String.valueOf(DB.GetPrice(ref) + "€"));
						labelPrice.updateUI();
						String t = CartWindow.labelprice.getText();
						double total = Double.parseDouble(t.substring(0, t.length() - 1)) - DB.GetPrice(ref);
						CartWindow.labelprice.setText(total + "€");
						CartWindow.labelprice.updateUI();
						DB.UpdateStock(ref, colour, size, (DB.GetStock(ref, size, colour) - 1));
					}
				} else {
					JOptionPane.showMessageDialog(null, "No hay unidades suficientes");
				}

			}

		});

		JButton btnDelete = new JButton("Eliminar");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// actualizar stock
				DB.DeleteCart(ref, colour, size);
				String t = CartWindow.labelprice.getText();
				double total = Double.parseDouble(t.substring(0, t.length() - 1)) - DB.GetPrice(ref) * def;
				CartWindow.labelprice.setText(total + "€");
				CartWindow.labelprice.updateUI();
				JOptionPane.showMessageDialog(null, "Producto eliminado de la cesta");
				pcentre.updateUI();
				pcentre.revalidate();
				pcentre.repaint();
				CartPanel.this.removeAll();
				CartPanel.this.updateUI();
				pcentre.setBackground(Color.WHITE);
				DB.UpdateStock(ref, colour, size, (DB.GetStock(ref, size, colour) + def));

			}
		});
		btnDelete.setFont(new Font("Times", Font.PLAIN, 13));
		btnDelete.setBounds(102, 233, 117, 29);
		ProductDetails.add(btnDelete);

		if (purchase == true) {

			spinner.setEnabled(false);

			btnDelete.setVisible(false);

		} else {
			spinner.setEnabled(true);

		}

	}
}

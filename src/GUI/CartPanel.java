package GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;

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

public class CartPanel extends JPanel {
	private JTextField txtPrecio;
	private int boughtuds;
	/**
	 * Create the panel.
	 */
	public CartPanel(String route,int uds,String ref,String colour,String size) {

		
		boughtuds=uds;
		
		
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
		lblNewLabelColour.setBounds(28, 76, 61, 16);
		ProductDetails.add(lblNewLabelColour);
		
		JLabel labelSize = new JLabel("");
		labelSize.setFont(new Font("Times", Font.PLAIN, 13));
		labelSize.setText(size);
		labelSize.setBounds(135, 76, 61, 16);
		ProductDetails.add(labelSize);
		
		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("Times", Font.PLAIN, 13));
		spinner.setBackground(Color.WHITE);
		spinner.setBounds(28, 137, 34, 26);
		spinner.setValue(new Integer(DB.Getuds(ref, colour, size)));
		
		
		
		ProductDetails.add(spinner);
		
		
		JLabel labelPrice = new JLabel("");
		labelPrice.setFont(new Font("Times", Font.PLAIN, 13));
		labelPrice.setBounds(28, 192, 61, 16);
		labelPrice.setText(String.valueOf(DB.GetPrice(ref)*uds+ "€"));
		ProductDetails.add(labelPrice);
		
		JButton btnDelete = new JButton("Eliminar");
		btnDelete.setFont(new Font("Times", Font.PLAIN, 13));
		btnDelete.setBounds(108, 245, 117, 29);
		ProductDetails.add(btnDelete);
		
		
		spinner.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
				int value = ((Integer)spinner.getValue()).intValue();
				int unidadesRestantes = DB.GetStock(ref, size, colour);
				if(unidadesRestantes >= value) {
					DB.UpdateCart(ref, colour, size, value);
					labelPrice.setText(String.valueOf(DB.GetPrice(ref)*value+ "€"));
					
					
				}else {
					JOptionPane.showMessageDialog(null, "No hay unidades suficientes");
				}
			}
		});
	}
}

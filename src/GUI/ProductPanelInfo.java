package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import Data.DB;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;

public class ProductPanelInfo extends JPanel {

	private String route;

	public String getRoute() {
		return route;
	}

	/**
	 * Create the panel.
	 */
	private static final long serialVersionUID = 1L;
	public ProductPanelInfo(String route) {

		this.route = route;
		setBackground(Color.WHITE);
	
		setLayout(new GridBagLayout());
		ImageIcon im = new ImageIcon(route);
		im.setDescription(route);
		JLabel lblfoto = new JLabel(im);
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 4;  //En qué columna empieza
		constraints.gridy = 0;  //En qué fila empieza
		constraints.gridwidth = 5; //Cuántas columnas ocupa
		constraints.gridheight = 4; //Cuántas filas ocupa

		add(lblfoto,constraints);
		
		JLabel lblTitle = new JLabel(DB.getProductTittle(route));
		constraints.gridx = 6;  //En qué columna empieza
		constraints.gridy = 6;  //En qué fila empieza
		constraints.gridwidth = 3; //Cuántas columnas ocupa
		constraints.gridheight = 1; //Cuántas filas ocupa
		add(lblTitle,constraints);
		
		JLabel price = new JLabel("€" + String.valueOf(DB.getProductPrice(route)));
		constraints.gridx = 6;  //En qué columna empieza
		constraints.gridy = 7;  //En qué fila empieza
		constraints.gridwidth = 3; //Cuántas columnas ocupa
		constraints.gridheight = 1; //Cuántas filas ocupa
		add(price,constraints);
		
		
		JLabel lblColours = new JLabel("+" + String.valueOf(DB.getProductColours(route) + "COLORES"));
		constraints.gridx = 6;  //En qué columna empieza
		constraints.gridy = 8;  //En qué fila empieza
		constraints.gridwidth = 3; //Cuántas columnas ocupa
		constraints.gridheight = 1; //Cuántas filas ocupa
		add(lblColours,constraints);
		
	}

}

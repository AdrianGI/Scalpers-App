package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import Data.DB;

import java.awt.Font;

public class ProductPanelInfo extends JPanel {

	private String route;

	public String getRoute() {
		return route;
	}

	/**
	 * Create the panel.
	 */
	public ProductPanelInfo(String route) {

		this.route = route;
		setLayout(new BorderLayout(0, 0));

		JPanel panelCentro = new JPanel();
		add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(2, 1, 0, 0));

		JPanel PanelPhoto = new JPanel();
		panelCentro.add(PanelPhoto);

		ImageIcon im = new ImageIcon(route);
		im.setDescription(route);
		JLabel lblPhoto = new JLabel(im);
		PanelPhoto.add(lblPhoto);

		JPanel PanelInfo = new JPanel();
		panelCentro.add(PanelInfo);
		PanelInfo.setLayout(new GridLayout(3, 1, 0, 0));

		JPanel TittlePanel = new JPanel();
		PanelInfo.add(TittlePanel);

		try {
			DB.getConnection();

			JLabel lblTitle = new JLabel(DB.getProductTittle(route));
			lblTitle.setFont(new Font("Times", Font.PLAIN, 13));
			lblTitle.setBackground(Color.WHITE);
			TittlePanel.add(lblTitle);

			JPanel PricePanel = new JPanel();
			PanelInfo.add(PricePanel);

			JLabel price = new JLabel("€" + String.valueOf(DB.getProductPrice(route)));
			price.setFont(new Font("Times", Font.PLAIN, 13));
			PricePanel.add(price);

			JPanel ColoursPanel = new JPanel();
			PanelInfo.add(ColoursPanel);

			JLabel lblColours = new JLabel("+" + String.valueOf(DB.getProductColours(route) + "COLORES"));
			lblColours.setFont(new Font("Times", Font.PLAIN, 13));
			PricePanel.add(lblColours);
			setVisible(true);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Border line = BorderFactory.createLineBorder(Color.BLACK, 1);
		setBorder(line);

	}

}

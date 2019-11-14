package GUI;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelInformation extends JPanel {

	/**
	 * Create the panel.
	 */
	private static final long serialVersionUID = 1L;

	public PanelInformation() {

		
		ImageIcon im = new ImageIcon("Photos/shop.jpg");
		Image image = im.getImage();
		Image newimg = image.getScaledInstance(1415, 700, java.awt.Image.SCALE_SMOOTH);
		im = new ImageIcon(newimg);
		JLabel lblPhoto = new JLabel(im);
		add(lblPhoto);
		setVisible(true);
	}

}

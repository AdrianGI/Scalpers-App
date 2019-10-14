package GUI;

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
		JLabel lblFoto = new JLabel(im);
		add(lblFoto);
		setVisible(true);
	}

}

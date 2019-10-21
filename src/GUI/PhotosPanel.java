package GUI;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import Data.DB;
import java.awt.Color;

public class PhotosPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	private static final long serialVersionUID = 1L;

	private void LoadPhotos(String gender, String type, String colour) {
		// TODO Auto-generated method stub

		ArrayList<String> routes = null;
		System.out.println(gender + " " + type + "  " + colour);
		if (gender.equals("") && type.equals("") && colour.equals("")) {
			routes = DB.GetAllRoutes();
			System.out.println("Tamaño del array " + routes.size());
		} else if (colour.equals("")) {
			routes = DB.GetImageRoute(gender, type);

		} else {
			routes = DB.GetImageRoute2(gender, type, colour);

		}
		for (int i = 0; i < routes.size(); i++) {

			String route = routes.get(i);
			ProductPanelInfo p = new ProductPanelInfo(route);
			add(p);
		}
	}

	public PhotosPanel(String gender, String type, String colour) {
		setBackground(Color.WHITE);

		setLayout(new GridLayout(0, 2, 0, 0));
		LoadPhotos(gender, type, colour);
		setVisible(true);
	}

}

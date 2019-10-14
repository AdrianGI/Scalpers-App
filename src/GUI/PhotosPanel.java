package GUI;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import Data.DB;

public class PhotosPanel extends JPanel {

	/**
	 * Create the panel.
	 */

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
			// routes = BD.obtenerRutasFotos2(genero, tipo,color);

		}
		for (int i = 0; i < routes.size(); i++) {

			String route = routes.get(i);
			ProductPanelInfo p = new ProductPanelInfo(route);
			add(p);
		}
	}

	public PhotosPanel(String gender, String type, String colour) {

		setLayout(new GridLayout(0, 3, 0, 0));
		LoadPhotos(gender, type, colour);
		setVisible(true);
	}

}

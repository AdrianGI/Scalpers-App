package Main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import Data.DB;
import Data.User;
import GUI.HomeWindow;
import GUI.LoginWindow;

public class Main {

	static User user;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			try {
				DB.getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			loadProperties();
			HomeWindow Hw = new HomeWindow(user.getEmail());
			Hw.setVisible(true);

		} catch (IOException e) {

			LoginWindow Lw = new LoginWindow();
			Lw.setVisible(true);

		}
	}

	private static Properties properties;

	/**
	 * Carga del fichero properties el usuario y contrasenya que estaban registrados
	 * cuando se cerro la aplicacion por ultima vez
	 * 
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws InvalidPropertiesFormatException
	 * 
	 */
	private static void loadProperties() throws InvalidPropertiesFormatException, FileNotFoundException, IOException {
		properties = new Properties();

		String email;

		properties.load(new FileInputStream("usuarios.ini"));
		// properties.remove(new FileInputStream("usuarios.ini"));

		email = properties.getProperty("email");

		user = new User("", "", email, "", 0, 0, "", "");

	}

	/**
	 * Guarda en fichero el usuario y la contrasenya
	 */

	public static void setProperties(String email) {

		properties = new Properties();

		properties.setProperty("email", email);

		try {

			properties.store(new FileOutputStream("usuarios.ini"), "");

		} catch (Exception e) {

		}

	}

}

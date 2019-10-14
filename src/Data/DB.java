package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class DB {

	private static final String URL = "ec2-174-129-18-42.compute-1.amazonaws.com:5432/dd0pf60umh31g7";
	private static final String USERNAME = "mnphxfqyhaliwl";
	private static final String PASSWORD = "636667c3650a2a57cd771f76f51d023b2011bb470bef2efcf192dd4156bc17c8";
	private static Connection conn;

	/**
	 * Metodo que establece conexion con la base de datos
	 * 
	 * @throws SQLException
	 */

	public static void getConnection() throws SQLException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException ex) {
			System.out.println("Where is your PostgreSQL JDBC Driver? " + "Include in your library path!");
		}
		conn = DriverManager.getConnection("jdbc:postgresql://" + URL + "?sslmode=require", USERNAME, PASSWORD);

	}

	/**
	 * Sign up method, insert into the database the data
	 * 
	 * @param user
	 */

	public static void newUser(String name, String surname, String password, String email, String date, String cp,
			String phone, String gender) {
		String sql = "INSERT INTO users VALUES('" + name + "','" + surname + "','" + password + "','" + email + "','"
				+ date + "','" + cp + "','" + phone + "','" + gender + "')";

		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Devuelve información sobre la existencia del usuario en la bd
	 * 
	 * @param nick
	 * @param clave
	 * @return 0: Si el nick es incorrecto 1: Si el nick es correcto pero la clave
	 *         no 2: Si el nick y la clave son correctos
	 * 
	 */

	public static int findUser(String email, String password) {
		int result = 0;
		String query = "SELECT * FROM users WHERE email='" + email + "'";

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			if (rs.next()) {
				String cl = rs.getString("password");

				if (cl.equals(password)) {
					result = 2;
				} else {
					result = 1;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	public static String Username(String email) {

		String name = "";
		String query = "SELECT name FROM users WHERE email ='" + email + "'";

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			if (rs.next()) {

				name = rs.getString("name");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		return name;
	}

	public static String ForgetPass(String email) {
		String pass = "";
		String query = "SELECT password FROM users WHERE email ='" + email + "'";

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			if (rs.next()) {
				pass = rs.getString("password");
			} else {

				JOptionPane.showMessageDialog(null, "El email no es correcto", "ERROR", JOptionPane.ERROR_MESSAGE);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		return pass;
	}

	public static ArrayList<String> GetImageRoute(String gender, String type) {
		ArrayList<String> routes = new ArrayList<String>();
		String query = "SELECT route FROM productsinfo WHERE type='" + type + "' AND gender='" + gender + "'";

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				String r = rs.getString("route");
				routes.add(r);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return routes;

	}

	public static ArrayList<String> GetAllRoutes() {
		ArrayList<String> routes = new ArrayList<String>();
		String sql = "SELECT route FROM productsinfo";

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				String r = rs.getString("route");
				routes.add(r);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return routes;

		// TODO Auto-generated method stub

	}

	public static float getProductPrice(String route) {
		String sql = "SELECT ref FROM productsinfo WHERE route='" + route + "'";

		float price = 0;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			Statement stm2 = conn.createStatement();
			if (rs.next()) {
				stm2.executeQuery("SELECT price FROM products WHERE route='" + rs.getString("ref") + "'");

			}
			rs.close();
			stm2.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return price;
	}

	public static String getProductTittle(String route) {
		String sql = "SELECT price FROM productsinfo WHERE ruta='" + route + "'";

		String size = "";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				size = rs.getString("size");
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return size;
	}

	public static String getProductColours(String route) {
		String sql = "SELECT price FROM producto WHERE ruta='" + route + "'";

		String colour = "";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				colour = rs.getString("colour");
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return colour;
	}

}

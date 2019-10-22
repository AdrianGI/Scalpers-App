package Data;

import java.sql.Connection;
import java.sql.Date;
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
	
	public static void DeleteUser(String email) {
		String sql = "DELETE from users WHERE email='" + email+ "'"; 

		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public static void UpdateUser(String name, String surname, String password, String email, String date, String cp,
			String phone, String gender) {

		String sql = "UPDATE users set VALUES('" + name + "','" + surname + "','" + password + "','" + email + "','"
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
			rs.close();
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
			rs.close();
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
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		return pass;
	}

	public static ArrayList<String> GetImageRoute(String gender, String type) {
		ArrayList<String> routes = new ArrayList<String>();
		String query = "SELECT DISTINCT route FROM productsinfo WHERE type='" + type + "' AND gender='" + gender + "'";

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

	public static ArrayList<String> GetImageRoute2(String gender, String type, String colour) {
		ArrayList<String> routes = new ArrayList<String>();
		String query = "SELECT DISTINCT route FROM productsinfo WHERE type='" + type + "' AND gender='" + gender
				+ "' AND colour='" + colour + "'";

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
		String sql = "SELECT DISTINCT route FROM productsinfo";

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
		String ref = "";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			if (rs.next()) {

				ref = rs.getString("ref");
			}
			String sql2 = "SELECT price FROM products WHERE ref='" + ref + "'";

			try {
				Statement stmt2 = conn.createStatement();
				ResultSet rs2 = stmt2.executeQuery(sql2);

				if (rs2.next()) {

					price = rs2.getFloat("price");
				}

				rs.close();
				rs2.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return price;
	}

	public static String getProductTittle(String route) {

		String sql = "SELECT ref FROM productsinfo WHERE route='" + route + "'";

		String title = "";
		String ref = "";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			if (rs.next()) {

				ref = rs.getString("ref");
			}
			String sql2 = "SELECT title FROM products WHERE ref='" + ref + "'";

			try {
				Statement stmt2 = conn.createStatement();
				ResultSet rs2 = stmt2.executeQuery(sql2);

				if (rs2.next()) {

					title = rs2.getString("title");
				}

				rs.close();
				rs2.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return title;
	}

	public static int getProductColours(String route) {

		String sql = "SELECT ref FROM productsinfo WHERE route='" + route + "'";

		int colour = 0;
		String ref = "";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			if (rs.next()) {

				ref = rs.getString("ref");
			}
			String sql2 = "SELECT colours FROM products WHERE ref='" + ref + "'";

			try {
				Statement stmt2 = conn.createStatement();
				ResultSet rs2 = stmt2.executeQuery(sql2);

				if (rs2.next()) {

					colour = rs2.getInt("colours");
				}

				rs.close();
				rs2.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return colour;
	}

	public static String GetName(String email) {
		String r = "";
		String query = "SELECT name FROM users WHERE email='" + email + "'";

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			if (rs.next()) {
				r = rs.getString("name");

			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return r;

	}

	public static String GetSur(String email) {
		String r = "";
		String query = "SELECT surname FROM users WHERE email='" + email + "'";

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			if (rs.next()) {
				r = rs.getString("surname");

			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return r;
	}
	
		public static String GetPass(String email) {
			String r = "";
			String query = "SELECT password FROM users WHERE email='" + email + "'";

			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(query);

				if (rs.next()) {
					r = rs.getString("password");

				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return r;
		
	}

	public static String GetGender(String email) {
		String r = "";
		String query = "SELECT gender FROM users WHERE email='" + email + "'";

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			if (rs.next()) {
				r = rs.getString("gender");

			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return r;

	}

	public static Date GetDate(String email) {
		Date r = null;
		String query = "SELECT date FROM users WHERE email='" + email + "'";

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			if (rs.next()) {
				r = rs.getDate("date");

			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return r;

	}

	public static String GetPc(String email) {
		String r = "";
		String query = "SELECT pc FROM users WHERE email='" + email + "'";

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			if (rs.next()) {
				r = rs.getString("pc");

			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return r;

	}

	public static String GetPhone(String email) {
		String r = "";
		String query = "SELECT phone FROM users WHERE email='" + email + "'";

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			if (rs.next()) {
				r = rs.getString("phone");

			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return r;

	}

	public static String GetImageRef(String route) {
		String r = "";
		String query = "SELECT ref FROM productsinfo WHERE route='" + route + "'";

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			if (rs.next()) {
				r = rs.getString("ref");

			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return r;

	}

	public static String GetColourUnique(String route) {
		String r = "";
		String query = "SELECT DISTINCT colour FROM productsinfo WHERE route='" + route + "'";

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			if (rs.next()) {
				r = rs.getString("colour");

			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return r;

	}

	public static String getProductDescription(String route) {

		String sql = "SELECT ref FROM productsinfo WHERE route='" + route + "'";

		String desc = "";
		String ref = "";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			if (rs.next()) {

				ref = rs.getString("ref");
			}
			String sql2 = "SELECT description FROM products WHERE ref='" + ref + "'";

			try {
				Statement stmt2 = conn.createStatement();
				ResultSet rs2 = stmt2.executeQuery(sql2);

				if (rs2.next()) {

					desc = rs2.getString("description");
				}

				rs.close();
				rs2.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return desc;
	}

	public static ArrayList<String> getProductSizes(String route, String colour) {

		ArrayList<String> sizes = new ArrayList<String>();

		String sql = "SELECT ref FROM productsinfo WHERE route='" + route + "' AND colour='" + colour + "'";

		String ref = "";
		String size = "";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			if (rs.next()) {

				ref = rs.getString("ref");
			}

			String sql2 = "SELECT DISTINCT  size FROM productsinfo WHERE ref='" + ref + "'";

			try {

				Statement stmt2 = conn.createStatement();
				ResultSet rs2 = stmt2.executeQuery(sql2);

				while (rs2.next()) {

					size = rs2.getString("size");
					sizes.add(size);
				}

				rs.close();
				rs2.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return sizes;
	}

	public static ArrayList<String> getProductColour(String route) {

		ArrayList<String> colours = new ArrayList<String>();
		String sql = "SELECT ref FROM productsinfo WHERE route='" + route + "'";

		String ref = "";
		String colour = "";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			if (rs.next()) {

				ref = rs.getString("ref");
			}
			String sql2 = "SELECT DISTINCT colour FROM productsinfo WHERE ref='" + ref + "'";

			try {

				Statement stmt2 = conn.createStatement();
				ResultSet rs2 = stmt2.executeQuery(sql2);

				while (rs2.next()) {

					colour = rs2.getString("colour");
					colours.add(colour);
				}

				rs.close();
				rs2.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return colours;
	}

	public static void addCart(String title, String colour, String size, int uds, String ref, float price) {

		try {
			Statement stmt = conn.createStatement();

			System.out.println(title);
			String sql2 = "SELECT title FROM cart WHERE title =" + title;

			ResultSet rs = stmt.executeQuery(sql2);

			if (rs.next()) {
				String sql = "UPDATE cart SET uds = unidades + 1 WHERE title = " + title;
				stmt.executeUpdate(sql);

			} else {

				String sql1 = "INSERT INTO cart VALUES('" + title + "','" + colour + "','" + size + "','" + uds + "','"
						+ ref + "'," + price + "')";
				stmt.executeUpdate(sql1);
			}

			String sql = "UPDATE productsinfo SET stock = stock - 1 WHERE ref = " + ref + "AND colour=" + colour
					+ "AND size=" + size;
			stmt.executeUpdate(sql);

			rs.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

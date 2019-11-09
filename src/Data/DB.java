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

	public static void newAddress(String email, String name, String surname, String enterprise, String address,
			String pc, String phone, String country, String province, String city, int id) {
		
		String sql = "INSERT INTO address VALUES('" + email + "','" + name + "','" + surname + "','"
				+ enterprise + "','" + address + "','" + city + "','" + country + "','" + pc + "','" + phone + "','"
				+ province + "'," + id + ")";

		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	
	public static void DeleteUser(String email) {
		String sql = "DELETE from users WHERE email='" + email + "'";

		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void DeleteProduct(String ref,String colour, String size) {
		String sql = "DELETE from productsinfo  WHERE ref='" + ref + "' AND size='" + size + "' AND COLOUR ='" + colour + "'";
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

		String sql = "UPDATE users set name='" + name + "', surname='" + surname + "', password='" + password + "' "
				+ ", date='" + date + "', 	pc=" + Integer.parseInt(cp) + ", phone=" + Integer.parseInt(phone)
				+ " , gender='" + gender + "' WHERE email='" + email + "'";

		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void UpdatePrice(String ref, double price) {

		String sql = "UPDATE products set price=" + price + " WHERE ref='" + ref + "'";

		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void UpdateStock(String ref, String colour, String size, int stock) {

		String sql = "UPDATE productsinfo set stock=" + stock + " WHERE ref='" + ref + "' AND size='" + size
				+ "' AND colour='" + colour + "'";

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

	public static ArrayList<Integer> GetAddress(String email) {
		ArrayList<Integer> ids = new ArrayList<Integer>();
		String query = "SELECT id FROM address WHERE email='" + email + "'";

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				int r = rs.getInt("id");
				ids.add(r);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ids;

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
	
	
	public static int Getuds(String ref, String colour, String size) {
		int uds=0;
		String query = "SELECT uds FROM cart WHERE ref='" + ref + "' AND colour='" + colour
				+ "' AND size='" + size + "'";

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			if (rs.next()) {
				uds=rs.getInt("uds");
				;
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return uds;

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
	

	public static int maxId() {
		int r = 0;
		String query = "SELECT MAX(id) from address";

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			if (rs.next()) {
				r = rs.getInt("id");

			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return r;

	}
	public static int maxIdP() {
		int r = 0;
		String query = "SELECT MAX(id) from productsinfo";

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			if (rs.next()) {
				r = rs.getInt("id");

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

	public static double GetPrice(String ref) {
		double r = 0;
		String query = "SELECT price FROM products WHERE ref='" + ref + "'";

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			if (rs.next()) {
				r = rs.getInt("price");

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

	public static String Getname(int id) {
		String r = "";
		String query = "SELECT name FROM address WHERE id='" + id + "'";

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

	public static String Getsurname(int id) {
		String r = "";
		String query = "SELECT surname FROM address WHERE id='" + id + "'";

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

	public static String GetEnterprise(int id) {
		String r = "";
		String query = "SELECT enterprise FROM address WHERE id='" + id + "'";

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			if (rs.next()) {
				r = rs.getString("enterprise");

			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return r;

	}

	public static int GetPhone(int id) {
		int r = 0;
		String query = "SELECT phone FROM address WHERE id='" + id + "'";

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			if (rs.next()) {
				r = rs.getInt("phone");

			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return r;

	}

	public static int GetPC(int id) {
		int r = 0;
		String query = "SELECT pc FROM address WHERE id='" + id + "'";

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			if (rs.next()) {
				r = rs.getInt("pc");

			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return r;

	}

	public static String GetAddress(int id) {
		String r = "";
		String query = "SELECT address FROM address WHERE id='" + id + "'";

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			if (rs.next()) {
				r = rs.getString("address");

			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return r;

	}

	public static String GetCity(int id) {
		String r = "";
		String query = "SELECT city FROM address WHERE id='" + id + "'";

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			if (rs.next()) {
				r = rs.getString("city");

			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return r;

	}

	public static String GetProvince(int id) {
		String r = "";
		String query = "SELECT province FROM address WHERE id='" + id + "'";

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			if (rs.next()) {
				r = rs.getString("province");

			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return r;

	}

	public static String GetCountry(int id) {
		String r = "";
		String query = "SELECT country FROM address WHERE id='" + id + "'";

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			if (rs.next()) {
				r = rs.getString("country");

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

	public static ArrayList<String> getProductCol(String ref) {

		ArrayList<String> colours = new ArrayList<String>();

		String colour = "";

		String sql2 = "SELECT DISTINCT colour FROM productsinfo WHERE ref='" + ref + "'";

		try {

			Statement stmt2 = conn.createStatement();
			ResultSet rs2 = stmt2.executeQuery(sql2);

			while (rs2.next()) {

				colour = rs2.getString("colour");
				colours.add(colour);
			}

			rs2.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return colours;
	}

	public static ArrayList<String> getProSizes(String ref) {

		ArrayList<String> sizes = new ArrayList<String>();

		String colour = "";

		String sql2 = "SELECT DISTINCT size FROM productsinfo WHERE ref='" + ref + "'";

		try {

			Statement stmt2 = conn.createStatement();
			ResultSet rs2 = stmt2.executeQuery(sql2);

			while (rs2.next()) {

				colour = rs2.getString("size");
				sizes.add(colour);
			}

			rs2.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return sizes;
	}

	public static int GetStock(String ref, String size, String colour) {

		int stock = 0;

		String sql = "SELECT stock FROM productsinfo WHERE ref='" + ref + "' AND size='" + size + "' AND colour='"
				+ colour + "'";

		try {

			Statement stmt2 = conn.createStatement();
			ResultSet rs2 = stmt2.executeQuery(sql);

			if (rs2.next()) {

				stock = rs2.getInt("stock");

			}

			rs2.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return stock;

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

	public static void addCart( String title, String colour, String size, int uds, String ref, float price,String route) {

		try {
			Statement stmt = conn.createStatement();

			System.out.println(title);
			String sql2 = "SELECT ref FROM cart WHERE title ='" + title + "'  AND colour='" + colour+"' AND size='" + size + "'";

			ResultSet rs = stmt.executeQuery(sql2);

			if (rs.next()) {
				String sql = "UPDATE cart SET uds = uds + 1 WHERE title = '" + title + "' AND colour='" + colour+"' AND size='" + size + "'";
				stmt.executeUpdate(sql);

			}  else {

				String sql1 = "INSERT INTO cart VALUES('" + title + "','" + colour + "','" + size + "'," + uds + ",'"
						+ ref + "'," + price + ", '"+ route+"')";
				stmt.executeUpdate(sql1);
			}

			String sql = "UPDATE productsinfo SET stock = stock - 1 WHERE ref = '" + ref + "' AND colour='" + colour
					+ "' AND size='" + size + "'";
			stmt.executeUpdate(sql);

			rs.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void UpdateCart(String ref, String colour, String size, int uds) {
		
		try {
			Statement stmt = conn.createStatement();
			
			String sql = "UPDATE cart SET uds = "+ uds+" WHERE ref = '" + ref + "' AND colour='" + colour
					+ "' AND size='" + size + "'";
			stmt.executeUpdate(sql);

			stmt.close();
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void addProduct(String ref, String title, String description, int colours, double price,String col) {

		try {
			Statement stmt = conn.createStatement();

			
			ArrayList<String > coloura = new ArrayList<String>();
				
			String sql2 = "SELECT DISTINCT colour FROM productsinfo WHERE ref ='" + ref + "'";

			ResultSet rs = stmt.executeQuery(sql2);

			while (rs.next()) {
				
			
				coloura.add(rs.getString("colour"));
				System.out.println(coloura);
				
				for ( int i=0; i<coloura.size();i++) {
					
				if (!coloura.get(i).equals(col)) {
					
				
				String sql = "UPDATE products SET colours = colours + 1 WHERE ref = '" + ref + "'";
				stmt.executeUpdate(sql);
				

				
				} else {

				String sql1 = "INSERT INTO products VALUES('" + ref + "','" + title + "','" + description + "'," + colours + "," + price + ")";
				stmt.executeUpdate(sql1);
			}

				}
			}

			rs.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void addProductsInfo(int id,String ref, String size, String colour, String route, int stock,String gender ,String type) {

		try {
			
			Statement stmt = conn.createStatement();

			
			

				String sql1 = "INSERT INTO productsinfo VALUES(" + id + "','" + ref + "','" + size + "','" + colour + "'," + route + "," + stock + ",'" + gender + "','" + type + "')";
				stmt.executeUpdate(sql1);
		

				stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public static ArrayList<Cart> GetCart() {
		ArrayList<Cart> cart = new ArrayList<Cart>();
		String sql = "SELECT * FROM cart";

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				String title = rs.getString("title");
				String colour= rs.getString("colour");
				String size= rs.getString("size");
				int uds= rs.getInt("uds");
				String ref= rs.getString("ref");
				double price=Double.parseDouble(String.valueOf(rs.getInt("uds")));
				String route= rs.getString("route");
				cart.add(new Cart(title, colour, size, uds, ref,price,route));
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cart;

	}
	
	public static String GetCartRute(String ref, String size, String colour) {
		String routes = "";
		String query = "SELECT route FROM cart WHERE ref='" + ref + "' AND size='" + size
				+ "' AND colour='" + colour + "'";

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				routes = rs.getString("route");
				
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return routes;

	}

	
}

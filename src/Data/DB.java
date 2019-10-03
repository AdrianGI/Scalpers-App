package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

}

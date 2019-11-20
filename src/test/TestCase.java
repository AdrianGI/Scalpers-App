package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import Data.DB;
import Data.User;

class TestCase {

	public void setUp() throws Exception {
		/*
		 * Como vamos a testear una clase que sÛlo tiene mÈtodos static, no hace falta
		 * inicializar nada
		 */

	}

	@Test
	void testconsultarExisteUsuario() {

		try {
			DB.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		User user1 = new User("adrian", "garrido", "adriangi98@opendeusto.es", "contra", 626585630, 48902, "Masculino",
				"27-11-98");
		User user2 = new User("adrian", "garrido", "adriangi98@opendeusto.es", "con", 626585630, 48902, "Masculino",
				"27-11-98");
		User user3 = new User("adrian", "garrido", "adriangi@opendeusto.es", "contra", 626585630, 48902, "Masculino",
				"27-11-98");

		assertTrue("Usuario esta en la BD", DB.findUser(user1.getEmail(), user1.getPassword()) == 2);
		assertTrue("Usuario esta en la BD, pero contraseña incorrecta ",
				DB.findUser(user2.getEmail(), user2.getPassword()) == 1);
		assertTrue("Usuario no esta en la BD", DB.findUser(user3.getEmail(), user3.getPassword()) == 0);

	}

}

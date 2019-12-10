package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;

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

	@Test
	void testConsulraRef() {

		try {
			DB.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		ArrayList<String> refs = new ArrayList<String>();
		refs.add("22222");
		refs.add("22930");
		refs.add("23240");
		refs.add("22223");
		refs.add("22224");
		refs.add("22229");
		refs.add("23072");
		refs.add("23344");
		refs.add("21280");
		refs.add("21281");
		
		
		for ( int i =0; i<refs.size();i++) {
			
			
			assertTrue(DB.CheckRef(refs.get(i)));
		
		}
}

	@Test
	void testConsularRutas() {

		try {
			DB.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String route1="products/T-Shirts/22206_BLUE.png";
		String route2="products/T-Shirts/22203_BURDEOS.png";
		String route3="products/Sweatshirts/22222_WHITE.png";
		String route4= "products/T-Shirts/23344_WHITE.png";
		String route5 = "products/Sweatshirts/21358_BLACK.png";
		
		assertEquals(route1, DB.GetRoute("22206", "Azul"));
		assertEquals(route2, DB.GetRoute("22203", "Burdeos"));
		assertEquals(route3, DB.GetRoute("22222", "Blanco"));
		assertEquals(route4, DB.GetRoute("23344", "Blanco"));
		assertEquals(route5, DB.GetRoute("21358", "Negro"));
		
		
				
		
		}
}
	
	


package File;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import Data.DB;

public class FileManagement {

	public static void Ranking(ArrayList<String> lista) {

		System.out.println("ENTRA A CREAR EL FICHERO");
		int i = 0;
		int con = 1;

		try {

			ArrayList<String> ranking = lista;
			PrintWriter pw = null;
			File f = new File("Ranking.txt");
			pw = new PrintWriter(f);
			while (i < ranking.size()) {

					pw.println(con + "." + "  " + "Email: " + "" + ranking.get(i) + "     " + "Gastos: "
							+ DB.GetuserPurchasesTotal(ranking.get(i)) + " €");
					i++;
					con++;

				}
				pw.flush();
				pw.close();

			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

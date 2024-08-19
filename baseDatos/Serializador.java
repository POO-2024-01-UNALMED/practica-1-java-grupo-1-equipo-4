package baseDatos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import gestorAplicación.procesoAdopcion.*;
import gestorAplicación.servicioAdicional.*;
import gestorAplicación.uiMain.Main;

public class Serializador {

	private static void serializar(ArrayList<? extends Object> lista, String nombre) {

		File archivo = new File("");

		try {
			File path = new File(archivo.getAbsolutePath() + "/src/baseDatos/temp/" + nombre + ".txt");

			FileOutputStream fop = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fop);

			oos.writeObject(lista);

			oos.close();
			fop.close();

		}catch(FileNotFoundException e) {

			System.out.println("No se encuentra el archivo ingresado");

		}catch(IOException e) {

			System.out.println("Error en el flujo de inicializacion");

		}
			//--------
			//----------
			//--------
	}

	public static void serializarListas() {
		
		serializar(Main.sedes, "Sedes");
		//serializar(CentroAdopcion.getAdopciones(), "Adopciones");
		serializar(CentroAdopcion.getClientes(), "Clientes");
		//serializar(CentroAdopcion.getCitas(), "Citas");
		
		
		serializar(Funeraria.getTumbas(), "Tumbas");
		


	}
}
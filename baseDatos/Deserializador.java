package baseDatos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import gestorAplicación.procesoAdopcion.*;
import gestorAplicación.servicioAdicional.*;
import gestorAplicación.uiMain.Main;

import java.io.*;
import java.util.List;

public class Deserializador {

	private static <T> void deserializar(ArrayList<T> lista, String nombre) {


		FileInputStream fis;
		ObjectInputStream ois;

		try {
			File path = new File("src/baseDatos/temp/" + nombre + ".txt");


			fis = new FileInputStream(path);
			ois = new ObjectInputStream(fis);

			lista.addAll((ArrayList<T>) ois.readObject());

			ois.close();
			fis.close();

		}catch(FileNotFoundException e) {

			e.printStackTrace();

		}catch(IOException e) {

			e.printStackTrace();

		}catch(ClassNotFoundException e) {

			e.printStackTrace();

		}
	}

	public static void deserializarListas() {
		
		CentroAdopcion ca = new CentroAdopcion();
        deserializar(ca.getAdopciones(), "Adopciones");
        
        Empleado p = new Empleado();
        deserializar(p.getCupo(), "Agenda");
        
		deserializar(Main.sedes, "Sedes");
		deserializar(CentroAdopcion.getClientes(), "Clientes");
		//deserializar(Funeraria.getTumbas(), "Tumbas");

	}
}
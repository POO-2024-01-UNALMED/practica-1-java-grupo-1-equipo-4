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
		
		//metodos estaticos
		
		deserializar(Main.sedes, "Sedes");
		deserializar(CentroAdopcion.getClientes(), "Clientes");
		deserializar(Funeraria.getTumbas(), "Tumbas");
		deserializar(Funeraria.getCenizas(), "Cenizas");
		deserializar(Socializar.getClientes(), "Clientes_Socializar");
		deserializar(Tienda.getProductos(), "Productos");
		deserializar(Tienda.getEmpleados(), "Empleados_Tienda");
				
				
				
		//metodos no estaticos
				
		CentroAdopcion ca = new CentroAdopcion();
		deserializar(ca.getAdopciones(), "Adopciones");
		deserializar(ca.getEmpleados(), "Empleados");
		deserializar(ca.getAnimales(), "Animales");
		deserializar(ca.getCitas(), "Citas");
		        
		Empleado em = new Empleado();
		deserializar(em.getCupo(), "Agenda");
				
		Muerto m = new Muerto();
		deserializar(m.getFlores(), "Flores");

	}
}
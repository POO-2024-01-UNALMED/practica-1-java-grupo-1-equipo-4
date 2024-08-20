package baseDatos;

import java.util.ArrayList;
import java.io.*;
import java.util.List;

import gestorAplicacion.administracion.*;
import gestorAplicacion.componentes.*;
import gestorAplicacion.uiMain.Main;

public class Deserializador {

	private static <T> void deserializar(List<T> lista, String nombre) {

		File archivo = new File("");
		FileInputStream fis;
		ObjectInputStream ois;
		
		if (lista == null) {
	        lista = new ArrayList<>();
	    }

		try {
			File path = new File(archivo.getAbsolutePath()+"/baseDatos/temp/" + nombre + ".txt");


			fis = new FileInputStream(path);
			ois = new ObjectInputStream(fis);

			lista.addAll((List<T>) ois.readObject());

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
		deserializar(Tienda.getProductos(), "Productos");
		deserializar(Tienda.getEmpleados(), "Empleados_Tienda");
				
		//metodos no estaticos
				
//		CentroAdopcion ca = new CentroAdopcion();
//		deserializar(ca.getAdopciones(), "Adopciones");
//		CentroAdopcion ca2 = new CentroAdopcion();
//		deserializar(ca2.getEmpleados(), "Empleados");
//		CentroAdopcion ca3 = new CentroAdopcion();
//		deserializar(ca3.getAnimales(), "Animales");
//		CentroAdopcion ca4 = new CentroAdopcion();
//		deserializar(ca4.getCitas(), "Citas");
		        
//		Empleado em = new Empleado();
//		deserializar(em.getCupo(), "Agenda");
				
		Muerto m = new Muerto();
		deserializar(m.getFlores(), "Flores");
		
//		Socializar s = new Socializar();
//		deserializar(s.getClientes(), "Clientes_Socializar");

	}
}
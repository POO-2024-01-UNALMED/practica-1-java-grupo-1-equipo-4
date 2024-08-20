package src.baseDatos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import src.gestorAplicacion.administracion.CentroAdopcion;
import src.gestorAplicacion.administracion.Funeraria;
import src.gestorAplicacion.administracion.Tienda;
import src.gestorAplicacion.componentes.Muerto;
import src.gestorAplicacion.uiMain.Main;

public class Deserializador {

	private static <T> void deserializar(List<T> lista, String nombre) {

		File archivo = new File("");
		FileInputStream fis;
		ObjectInputStream ois;
		
		if (lista == null) {
	        lista = new ArrayList<>();
	    }

		try {
			File path = new File(archivo.getAbsolutePath()+"/src/baseDatos/temp/" + nombre + ".txt");


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
				
		Muerto m = new Muerto();
		deserializar(m.getFlores(), "Flores");
		

	}
}
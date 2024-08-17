package baseDatos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import gestorAplicación.procesoAdopcion.CentroAdopcion;
import gestorAplicación.servicioAdicional.*;

public class Deserializador {
	
	private static <T> void deserializar(ArrayList<T> lista, String nombre) {
		
		File archivo = new File("");
		
		try {
			File path = new File(archivo.getAbsolutePath() + "/src/baseDatos/temp/" + nombre + ".txt");
			
			FileInputStream fis = new FileInputStream(path);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
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
		deserializar(CentroAdopcion.getAdopciones(), "Adopciones");
		deserializar(CentroAdopcion.getEmpleados(), "Empleados");
		//faltan los demás objetos a deserializar
	}
}

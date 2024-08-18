package baseDatos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import gestorAplicación.procesoAdopcion.*;
import gestorAplicación.servicioAdicional.*;

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
		//objetos de gestorAplicacion.procesoAdopcion
		Serializador.serializar(CentroAdopcion.getAdopciones(), "Adopciones");
		Serializador.serializar(CentroAdopcion.getEmpleados(), "Empleados");
			//faltan más de centroAdopcion
		
		//objetos de gestorAplicacion.servicioAdicional
			
			//clases con listas para serializar:
				//cita, funeraria, socializar, tienda
				// no muy seguro: horario en empleado, flores en muerto, citas en servicio
		
		
	}
}

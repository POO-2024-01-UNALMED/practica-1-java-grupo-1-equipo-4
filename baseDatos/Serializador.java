package baseDatos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

import gestorAplicacion.administracion.*;
import gestorAplicacion.componentes.*;
import gestorAplicacion.uiMain.Main;

public class Serializador {

	private static void serializar(List<? extends Object> lista, String nombre) {

		File archivo = new File("");

		try {
			File path = new File(archivo.getAbsolutePath() + "/baseDatos/temp/" + nombre + ".txt");

			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(lista);

			oos.close();
			fos.close();

		}catch(FileNotFoundException e) {

			System.out.println("No se encuentra el archivo ingresado");

		}catch(IOException e) {

			System.out.println("Error en el flujo de inicializacion");

		}
	}

	public static void serializarListas() {
		
		//metodos estaticos
		
		serializar(Main.sedes, "Sedes");
		serializar(CentroAdopcion.getClientes(), "Clientes");
		serializar(Funeraria.getTumbas(), "Tumbas");
		serializar(Funeraria.getCenizas(), "Cenizas");
		serializar(Tienda.getProductos(), "Productos");
		serializar(Tienda.getEmpleados(), "Empleados_Tienda");

		//metodos no estaticos
		
        Muerto m = new Muerto();
        serializar(m.getFlores(), "Flores");
        

	}
}
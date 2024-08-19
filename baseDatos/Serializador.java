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

	private static void serializar(List<? extends Object> lista, String nombre) {

		File archivo = new File("");

		try {
			File path = new File(archivo.getAbsolutePath() + "/baseDatos/temp/" + nombre + ".txt");

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
	}

	public static void serializarListas() {
		
		//metodos estaticos
		
		serializar(Main.sedes, "Sedes");
		serializar(CentroAdopcion.getClientes(), "Clientes");
		serializar(Funeraria.getTumbas(), "Tumbas");
		serializar(Funeraria.getCenizas(), "Cenizas");
		serializar(Socializar.getClientes(), "Clientes_Socializar");
		serializar(Tienda.getProductos(), "Productos");
		serializar(Tienda.getEmpleados(), "Empleados_Tienda");

		//metodos no estaticos
		
		CentroAdopcion ca = new CentroAdopcion();
        serializar(ca.getAdopciones(), "Adopciones");
        CentroAdopcion ca2 = new CentroAdopcion();
        serializar(ca2.getEmpleados(), "Empleados");
        CentroAdopcion ca3 = new CentroAdopcion();
        serializar(ca3.getAnimales(), "Animales");
        CentroAdopcion ca4 = new CentroAdopcion();
        serializar(ca4.getCitas(), "Citas");
        
        Empleado em = new Empleado();
        serializar(em.getCupo(), "Agenda");
		
        Muerto m = new Muerto();
        serializar(m.getFlores(), "Flores");

	}
}
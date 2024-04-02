package gestorAplicación.uiMain;


import gestorAplicación.procesoAdopcion.*;
import gestorAplicación.servicioAdicional.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	//ARRAYLIST DONDE SE VAN A GUARDAR LAS SEDES
	public static Scanner entrada = new Scanner(System.in);
	public static ArrayList<CentroAdopcion> sedes = new ArrayList<CentroAdopcion>();
	
	static {
	
		
		//CREACION DE SEDES
		sedes.add(new CentroAdopcion("SEDE 1",25, CentroAdopcion.tipoServicio.GUARDERIA));
		sedes.add(new CentroAdopcion("SEDE 2",20, CentroAdopcion.tipoServicio.VETERINARIA));
		sedes.add(new CentroAdopcion("SEDE 3",20, CentroAdopcion.tipoServicio.PELUQUERIA));
	}
	

	public static void main(String[] args) {
		System.out.print("Ingrese su nombre: ");
		String nombre = nextString();
		
		System.out.println(nombre);
		
	}
	
	
	//ENTRADAS DE DATOS POR TIPO
	static byte readByte() {
		return entrada.nextByte();
	}
	
	static int readInt( ) {
		return entrada.nextInt();
	}
	
	static String nextString() {
		return entrada.nextLine();
	}
	
	static long nextLong() {
		return entrada.nextLong();
	}
	
	static double nextDouble() {
		return entrada.nextDouble();
	}

}



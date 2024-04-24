package gestorAplicación.uiMain;
import java.util.Scanner;
import gestorAplicación.procesoAdopcion.*;
import gestorAplicación.servicioAdicional.*;

public class MainTienda {

	public static void main(String[] args) {	
	
		//METODOS ESCRITOS POR OKY
		static byte readByte() {
			return entrada.nextByte();
		}
		
		static int readInt() {
			return entrada.nextInt();
		}
		
		static String readString() {	
			String string =entrada.nextLine();
			return string;
		}
		
		static long readLong() {
			return entrada.nextLong();
		}
		
		static double nextDouble() {
			return entrada.nextDouble();
		}
		
		static void println(Object obj) {
			System.out.println(obj);
		}
		
		static void print(Object obj) {
			System.out.print(obj);
		}
	
		
		
		
		
		
	CentroAdopcion sede1 = new CentroAdopcion("SEDE 1",25, CentroAdopcion.tipoServicio.GUARDERIA);

	//CREAMOS UN ANIMAL PARA UN CENTRO
	Animal gato1 = new Animal("Reina","Gato",3, "Hembra", Animal.EstadoSalud.SANO);
	
	sede1.agregarAnimal(gato1);
	
	//PERSONA PARA CREAR UNA ADOPCION
	Cliente Oky = new Cliente("Oky Ruiz", 17, 777, 666, "La costa");
	
	Adopcion adopcion1 = new Adopcion(gato1, Oky);
	
	//AGREGAMOS ADOPCION
	sede1.agregarAdopcion(adopcion1);

	//CREAMOS UN EMPLEADO PARA QUE ATIENDA LA TIENDA
	Empleado empliado = new Empleado("Albert", 22, 555, 1323, "West Elm", Empleado.Rol.TENDERO, null);
	Tienda t1 = new Tienda(empliado, sede1);
	
	//OPERACION DE LA TIENDA
	
	
	
	
	System.out.println(t1.inventario());
	
	
	}	
}

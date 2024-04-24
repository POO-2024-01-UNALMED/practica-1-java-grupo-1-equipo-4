package gestorAplicación.uiMain;
import java.util.Scanner;
import gestorAplicación.procesoAdopcion.*;
import gestorAplicación.servicioAdicional.*;

public class MainTienda {

	public static Scanner entrada = new Scanner(System.in);
	
	public static void main(String[] args) {	
		
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

	boolean bucle = true;
	
	System.out.println("Bienvenido a la tienda"+"\n");
	
	while (bucle==true) {
		
		System.out.println("Productos disponibles: \n");
		System.out.println(t1.inventario());
		System.out.println("\n"+"La lista se le mostró en orden, indique el número del producto que escogió: ");
		int indice = entrada.nextInt();
		
		System.out.println("Indique cuantas unidades quiere del producto: ");
		int unidades = entrada.nextInt();
		
		
		if (unidades==1) {
			t1.compra(indice);
			System.out.println("Ingrese su cédula para registrar la compra por favor: ");
			long cedula = entrada.nextLong();
			boolean esCliente = CentroAdopcion.esCliente(cedula);
			if (esCliente) {
				System.out.println("\nLa compra tiene un 10% de descuento\n");
			}
			
		}else {
			t1.compra(indice, unidades);
			System.out.println("Ingrese su cédula para registrar la compra por favor: ");
			long cedula = entrada.nextLong();
			boolean esCliente = CentroAdopcion.esCliente(cedula);
			if (esCliente) {
				System.out.println("La compra tiene un 10% de descuento\n");
			}
		}
		
		entrada.nextLine();
		
		System.out.println("Se ha realizado su compra, muchas gracias\n");
		System.out.println("¿Desea comprar algo más? (responda con si/no)");
		String respuesta = entrada.nextLine();
		
		
		if (respuesta.equals("si") || respuesta.equals("SI")) {
			continue;
		}
		else {
			System.out.println("Vuelva pronto :)");
			break;
		}
	}
	}	
}

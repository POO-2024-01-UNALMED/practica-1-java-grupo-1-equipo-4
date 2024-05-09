package gestorAplicación.uiMain;
import java.util.Scanner;
import gestorAplicación.procesoAdopcion.*;
import gestorAplicación.servicioAdicional.*;
import java.util.InputMismatchException;

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
	
	while (true) { 
	
		System.out.println("¿Qué deseas hacer?"+"\n");
		System.out.println("1. Comprar un producto");
		System.out.println("2. Registrar un voluntario");
		System.out.println("3. Salir\n");
		System.out.println("Ingrese el número de la opción que desea");
		
		int menu = 0;
		while (menu==0) {
			try {
				menu = entrada.nextInt();
				if (menu>0 && menu<=3) {
					break;
				}
				else {
					System.out.println("Ingrese un número válido por favor");
					menu = 0;
					continue;
				}
			}
			catch(InputMismatchException e) {
				System.out.println("Por favor ingrese un número entre uno y tres!!!");
			}
			finally {
					entrada.nextLine();//SALTO DE LINEA
				}
		}
		
	if (menu==1) {			
		while (bucle==true) {
			System.out.println("\n¿Cómo desea que se le muestren los productos?");
			System.out.println("1. Mostrar todo");
			System.out.println("2. Filtrar por tipo");
				
			int menuTienda = 0;
			while (menuTienda==0) {
				try {
					menuTienda = entrada.nextInt();
					if (menuTienda>0 && menuTienda<=2) {
						break;
					}
					else {
						System.out.println("Ingrese un número válido por favor");
						menuTienda = 0;
						continue;
					}
				}
				catch(InputMismatchException e) {
					System.out.println("Por favor ingrese el numero uno o dos!!");
				}
				finally {
					entrada.nextLine();//SALTO DE LINEA
				}
			}
			
			if (menuTienda==1) {	
				System.out.println("\nProductos disponibles:");
				System.out.println(t1.inventario());
			}
			else {
				System.out.println("¿Por qué tipo de animal te gustaría ver? (Perros, gatos, aves o hamsters)");
				while (true) {
					try {
						String tipo = entrada.nextLine();
						tipo.toLowerCase();
						if (tipo.equals("perros")) {
							System.out.println("\nProductos disponibles:\n");
							System.out.println(t1.filtrar("perros"));
							break;
						}
						else if (tipo.equals("gatos")) {
							System.out.println("\nProductos disponibles:\n");
							System.out.println(t1.filtrar("gatos"));
							break;
						}
						else if (tipo.equals("aves")) {
							System.out.println("\nProductos disponibles:\n");
							System.out.println(t1.filtrar("aves"));
							break;
						}	
						else if (tipo.equals("hamsters")) {
							System.out.println("\nProductos disponibles:\n");
							System.out.println(t1.filtrar("hamsters"));
							break;
						}
						else {
							System.out.println("Por favor, ingrese el tipo del animal en minúsculas (Perros, gatos, aves o hamsters)");
							continue;
						}
					}
					catch(InputMismatchException e) {
						System.out.println("Por favor, coloque un tipo valido de animal");
					}
				}
			}
			boolean control = true;
			while (control) {
				try {
						System.out.println("Coloque el índice del producto que va a comprar: ");
						int indice = entrada.nextInt();
		
						System.out.println("Indique cuantas unidades quiere del producto: ");
						int unidades = entrada.nextInt();
						
						if (unidades==1) {
							System.out.println("Ingrese su cédula para registrar la compra por favor: ");
							long cedula = entrada.nextLong();
							boolean esCliente = CentroAdopcion.esCliente(cedula);
							if (esCliente) {
								System.out.println("\nLa compra tiene un 10% de descuento\n");
							}
							System.out.println(t1.compra(indice));
						}
						else {
							t1.compra(indice, unidades);
							System.out.println("Ingrese su cédula para registrar la compra por favor: ");
							long cedula = entrada.nextLong();
							boolean esCliente = CentroAdopcion.esCliente(cedula);
							if (esCliente) {
								System.out.println("La compra tiene un 10% de descuento\n");
							}
						}
						
						control = false;
					
				}
				catch(InputMismatchException e) {
					System.out.println("Por favor, ingrese un número y no otra cosa\n");
				}
				finally {
					entrada.nextLine();
				}
			}
			
		
				System.out.println("Se ha realizado su compra, muchas gracias\n");
				System.out.println("¿Desea comprar algo más? (responda con si/no)");
				String respuesta = entrada.nextLine();
		
		
				if (respuesta.equals("si") || respuesta.equals("SI")) {
					continue;
				}
				else {
					System.out.println("Vuelva pronto :)\n");
					break;
				}
			}//BUCLE COMPRAR
	}//CONDICINAL MENU
	else if (menu==2){
		System.out.println("\nFormulario para pertenecer a los voluntarios: \n");
		System.out.println("Trabajo en progreso\n");
	}
	else {
		break;
	}
	}//BUCLE INICIAL
  }//MAIN	
}

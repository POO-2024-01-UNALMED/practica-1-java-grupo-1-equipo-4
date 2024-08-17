package gestorAplicación.uiMain;
import gestorAplicación.procesoAdopcion.CentroAdopcion;
import gestorAplicación.servicioAdicional.Funeraria;
import java.util.ArrayList;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Funcionalidad_4 {
	
	public static Scanner entrada = new Scanner(System.in);
	
	// MAIN //
	public static void main(String[] args) {
		
		//TODO: QUE LOS CENTROS DE ADOPCION TENGAN DIRECCIONES, ASÍ ES MAS FACIL QUE EL USUARIO ESCOJA 
		//TODO: QUE EXISTAN SOLO TRES CENTROS DE ADOPCIÓN, NO TRES POR CADA FUNCIONALIDAD
		
		CentroAdopcion centro1 = new CentroAdopcion("Huellitas", 15, CentroAdopcion.tipoServicio.PELUQUERIA);
		CentroAdopcion centro2 = new CentroAdopcion("TierrAgro", 20, CentroAdopcion.tipoServicio.VETERINARIA);
		CentroAdopcion centro3 = new CentroAdopcion("Fundacion A cuatro patas", 25, CentroAdopcion.tipoServicio.GUARDERIA);
		
		//TODO: RECORDAR COLOCAR EN CENTRO ADOPCIÓN UN ATRIBUTO FUNERARIA (COMO PARA RELACCIONARLOS)
		
		Funeraria fune1 = new Funeraria(centro1);
		Funeraria fune2 = new Funeraria(centro2);
		Funeraria fune3 = new Funeraria(centro3);
		
		ArrayList<Funeraria> funerarias = new ArrayList<> ();
		
		funerarias.add(fune1);
		funerarias.add(fune2);
		funerarias.add(fune3);
		
		//-------------------------------------------------------------------------------------------------------
		// PROCESO FUNERARIA 
		
		System.out.println("Bienvenido al servicio de Funeraria"+"\n");
		
		while (true) { 
		
			System.out.println("Por favor, seleccione el centro de adopción más cercano: "+"\n");
			System.out.println("1. "+fune1.getCentro().getNombre()+".");
			System.out.println("2. "+fune2.getCentro().getNombre()+".");
			System.out.println("3. "+fune3.getCentro().getNombre()+".");
			System.out.println("4. Salir.\n");
			System.out.println("Ingrese el número de la opción que desea: ");
			
			int menu = 0;
			while (menu==0) { // COMPROBANDO SI EL NÚMERO ES VALIDO
				try {
					menu = entrada.nextInt(); //RECIBIENDO ENTRADA
					if (menu>0 && menu<=4) {
						break;
					}
					else {
						System.out.println("Ingrese un número válido por favor");
						menu = 0;
						continue;
					}
				}
				
				catch(InputMismatchException e) {
					System.out.println("Por favor ingrese un número entre uno y cuatro!!!");
				}
				finally {
						entrada.nextLine();//SALTO DE LINEA
					}		
				}//BUCLE CONTROL
			
				if (menu==4) {
					System.out.println("Hasta luego, esperamos que no tenga que volver pronto.");
					break;
				}
				else {
					while (true) {
						System.out.println("¿Qué desea hacer?\n");
						System.out.println("1. Cremación.");
						System.out.println("2. Entierro.");
						System.out.println("3. Visitar cementerio");
						System.out.println("4. Salir.\n");
						
						int menu2 = 0;
						while (menu2==0) { // COMPROBANDO SI EL NÚMERO ES VALIDO
							try {
								menu2 = entrada.nextInt(); //RECIBIENDO ENTRADA
								if (menu2>0 && menu2<=4) {
									break;
								}
								else {
									System.out.println("Ingrese un número válido por favor");
									menu2 = 0;
									continue;
								}
							}
							
							catch(InputMismatchException e) {
								System.out.println("Por favor ingrese un número entre uno y cuatro!!!");
							}
							finally {
									entrada.nextLine();//SALTO DE LINEA
								}
							}// BUCLE CONTROL
						
							if (menu2==4) {
								System.out.println(" ");
								break;
							}
							else if(menu2==1) {
								//CREMACIÓN---------------------------------------------------------------------------------------
								
								System.out.println("Verificando si la funeraria de "+funerarias.get(menu).getNombre()+" tiene espacio.\n");
								
								if(funerarias.get(menu).espacioCenizas()==true) {
									
									System.out.println("Si hay espacio disponible.");
									System.out.println("Escoja entre las siguientes opciones: \n");
									break;
								}
								else {
									System.out.println("No hay espacio disponible, por favor seleccione otro centro.");
									break;
								}
							}//ELSE CASO CREMACIÓN
							
							else if (menu2==3) {
								System.out.println("\n Visitando cementerio.....");
								System.out.println("Sientes un frió en el aire....");
								System.out.println("Por tu bien, es mejor que no mires atrás.\n");
								break;
							}//ELSE CASO VISITA CEMENTERIO 
							
								
				}// BUCLE SELECCION DE QUE HACER
			}//ELSE CASO DONDE NO ESCOGIÓ SALIR
		} //BUCLE SELECCIÓN CENTRO
	}// MAIN 
}// CLASE


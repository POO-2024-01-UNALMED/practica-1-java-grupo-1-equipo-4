package gestorAplicación.uiMain;
import gestorAplicación.servicioAdicional.*;
import java.util.ArrayList;
import gestorAplicación.procesoAdopcion.*;
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
					menu-=1;
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
								
								System.out.println("Verificando si la funeraria de "+funerarias.get(menu).getNombre()+" tiene espacio...\n");
								
								if(funerarias.get(menu).espacioCenizas()==true) {
									
									System.out.println("¡Si hay espacio disponible!\n");
									System.out.println("Escoja entre las siguientes opciones: \n");
									System.out.println("1. Comprar Osario.");
									System.out.println("2. Alquilar Osario.");
									System.out.println("3. Salir.\n");
									
									int menu3 = 0;
									while (menu3==0) { // COMPROBANDO SI EL NÚMERO ES VALIDO
										try {
											menu3 = entrada.nextInt(); //RECIBIENDO ENTRADA
											if (menu3>0 && menu3<=3) {
												break;
											}
											else {
												System.out.println("Ingrese un número válido por favor");
												menu2 = 0;
												continue;
											}
										}
										catch(InputMismatchException e) {
											System.out.println("Por favor ingrese un número entre uno y tres!!!");
										}
										finally {
												entrada.nextLine();//SALTO DE LINEA
											}
										}// BUCLE CONTROL
									
									if (menu3==1 || menu3==2) {
										String tiempo = "de por vida"; 
										int  alquiler = 0;
										// OBJETO DE TIPO MUERTO
										Muerto cenizas = new Muerto();
										
										if (menu3==2) {
											System.out.println("\nConsigne el número de años que va a alquilar el osario:");
											System.out.println("(Ejemplo: 3, 4, etc..)");
										
											while(alquiler==0) {
												try {
													alquiler = entrada.nextInt();
												}
												catch(InputMismatchException e){
													System.out.println("Ingrese únicamente un número");
												}finally {
													entrada.nextLine();
												}
												System.out.print("\n");
											}
										}// SE CONSIGUE EL TIEMPO DEL ALQUILER
										
										//DATOS DUEÑO
										boolean control33 = true;
										while(control33==true)
										try {
											System.out.println("Por favor, ingrese sus datos para realizar la compra:\n ");
											System.out.print("Nombre : ");
											String name = entrada.nextLine();
											System.out.print("Dirección : ");
											String direc = entrada.nextLine();
											System.out.print("Edad : ");
											int edad = entrada.nextInt();
											System.out.print("Cédula : ");
											long cedu = entrada.nextLong();
											System.out.print("Número : ");
											long numero = entrada.nextLong();
											System.out.print("\n");
											// CREAMOS EL OBJETO DE TIPO CLIENTE
											Cliente cliente = new Cliente(name, edad, cedu, numero, direc);
											// SE LE AÑADE EL DUEÑO A LAS CENIZAS
											cenizas.setDueño(cliente);
											control33 = false;
										}
										catch(InputMismatchException e) {
											System.out.println("Error con algún dato.\n");
										}finally {
											entrada.nextLine();
										}
										
										if (menu3==2) {
											System.out.println("A su dirección se le enviará la factura, y se le estará contactando por telefono.");
											System.out.println("Total a pagar por los "+alquiler+" años son: "+alquiler*200000+" $.\n");
											cenizas.setTiempo(alquiler+" años");
										}
										else {
											System.out.println("A su dirección se le enviará la factura, y se le estará contactando por telefono.");
											System.out.println("Total a pagar por el osario "+tiempo+" es igual a: 2000000 $\n");
											cenizas.setTiempo(tiempo);
										}
										

										//DATOS MASCOTA
										boolean control43 = true;
										while(control43==true)
										try {
											System.out.println("Digitación de los datos de la mácota:\n");
											System.out.print("Nombre : ");
											String namePet = entrada.nextLine();
											System.out.print("Tipo : ");
											String tipo = entrada.nextLine();
											System.out.print("Edad : ");
											int edad = entrada.nextInt();
											entrada.nextLine();
											System.out.print("Sexo : ");
											String sex = entrada.nextLine();
											System.out.print("Fecha de fallecimiento (dia/mes/año): ");
											String fecha = entrada.nextLine();
											System.out.print("\n");
											// CREAMOS EL OBJETO DE TIPO CLIENTE
											Animal animal = new Animal(namePet, tipo, edad, sex);
											// AÑADIMOS EL ANIMAL A MUERTO, Y LA FECHA
											cenizas.setAnimal(animal);
											cenizas.setFecha(fecha);
											control43 = false;
										}
										catch(InputMismatchException e) {
											System.out.println("Error con algún dato.\n");
										}
										
										System.out.println("Para finalizar, escribe el mensaje para el Osario: ");
										String mensaje = entrada.nextLine();
										//SE REGISTRA EL MENSAJE 
										cenizas.setMensaje(mensaje);
										//FINALIZA EL PROCESO DE REGISTRO
										System.out.println("Se ha realizado el proceso de registro.\n");
										//SE AGREGAN LAS CENIZAS A LA FUNERARIA 
										funerarias.get(menu).añadirCenizas(cenizas);
										
										//----------- EMPIEZA AUTOMATICAMENTE LA PRIMERA VISITA A LOS OSARIOS -----------------------
										System.out.println("Comienza la visita a las cenizas:\n");
										System.out.println(funerarias.get(menu).visita("Cenizas"));
										
										System.out.println("¿Deseas colocarle flores a algún osario (si/no)?: ");
										
										while(true) {
										
											String si_no = entrada.nextLine();// SI / NO ------------------------- FLORES-----------------
											if (si_no.equals("no")||si_no.equals("NO")) {
												System.out.println("\nUna muerte bella, honra toda vida...\n");
												break;
											}
											else if(si_no.equals("si")||si_no.equals("SI")) {
												System.out.print("Ingresa el nombre de la flor que te gustaría poner: ");
												String flor = entrada.nextLine();
												
												System.out.print("¿A cuál osario? (digite el número de osario): ");
												
												int control53 = 0;
												while (control53==0) {
													try {
														control53 = entrada.nextInt();
														if (control53>0 && control53<=Funeraria.cenizas.size()) {
															break;
														}
														else {
															System.out.println("Ingrese un número válido por favor");
															control53 = 0;
															continue;
														}
													}
													catch(InputMismatchException e) {
														System.out.println("Por favor ingrese solo números.");
													}
													finally {
															entrada.nextLine();//SALTO DE LINEA
														}
												}
												
												System.out.println("\n"+funerarias.get(menu).florCenizas(control53, flor)+"\n");
												
												
												break;
											}
											else {
												System.out.println("Escoja una opción válida (si/no)");
												continue;
											}
										}
										
										
									}
									
									break;
								}
								else {
									System.out.println("No hay espacio disponible, por favor seleccione otro centro.");
									break;
								}
							}//ELSE CASO CREMACIÓN
							
							else if(menu2==2) {
								// ENTIERRO ----------------------------------------------------------------------------------------
								
								System.out.println("Verificando si la funeraria de "+funerarias.get(menu).getNombre()+" tiene espacio...\n");
								
								if(funerarias.get(menu).espacioTumbas()==true) {
									
									System.out.println("¡Si hay espacio disponible!\n");
									System.out.println("Escoja entre las siguientes opciones: \n");
									System.out.println("1. Comprar Terreno.");
									System.out.println("2. Alquilar Terreno.");
									System.out.println("3. Salir.\n");
									
									int menu3 = 0;
									while (menu3==0) { // COMPROBANDO SI EL NÚMERO ES VALIDO
										try {
											menu3 = entrada.nextInt(); //RECIBIENDO ENTRADA
											if (menu3>0 && menu3<=3) {
												break;
											}
											else {
												System.out.println("Ingrese un número válido por favor");
												menu2 = 0;
												continue;
											}
										}
										catch(InputMismatchException e) {
											System.out.println("Por favor ingrese un número entre uno y tres!!!");
										}
										finally {
												entrada.nextLine();//SALTO DE LINEA
											}
										}// BUCLE CONTROL
									
									if (menu3==1 || menu3==2) {
										String tiempo = "de por vida"; 
										int  alquiler = 0;
										// OBJETO DE TIPO MUERTO
										Muerto tumba = new Muerto();
										
										if (menu3==2) {
											System.out.println("\nConsigne el número de años que va a alquilar el terreno:");
											System.out.println("(Ejemplo: 3, 4, etc..)");
										
											while(alquiler==0) {
												try {
													alquiler = entrada.nextInt();
												}
												catch(InputMismatchException e){
													System.out.println("Ingrese únicamente un número");
												}finally {
													entrada.nextLine();
												}
												System.out.print("\n");
											}
										}// SE CONSIGUE EL TIEMPO DEL ALQUILER
										
										//DATOS DUEÑO
										boolean control33 = true;
										while(control33==true)
										try {
											System.out.println("Por favor, ingrese sus datos para realizar la compra:\n ");
											System.out.print("Nombre : ");
											String name = entrada.nextLine();
											System.out.print("Dirección : ");
											String direc = entrada.nextLine();
											System.out.print("Edad : ");
											int edad = entrada.nextInt();
											System.out.print("Cédula : ");
											long cedu = entrada.nextLong();
											System.out.print("Número : ");
											long numero = entrada.nextLong();
											System.out.print("\n");
											// CREAMOS EL OBJETO DE TIPO CLIENTE
											Cliente cliente = new Cliente(name, edad, cedu, numero, direc);
											// SE LE AÑADE EL DUEÑO A LAS CENIZAS
											tumba.setDueño(cliente);
											control33 = false;
										}
										catch(InputMismatchException e) {
											System.out.println("Error con algún dato.\n");
										}finally {
											entrada.nextLine();
										}
										
										if (menu3==2) {
											System.out.println("A su dirección se le enviará la factura, y se le estará contactando por telefono.");
											System.out.println("Total a pagar por los "+alquiler+" años son: "+alquiler*500000+" $.\n");
											tumba.setTiempo(alquiler+" años");
										}
										else {
											System.out.println("A su dirección se le enviará la factura, y se le estará contactando por telefono.");
											System.out.println("Total a pagar por el terreno "+tiempo+" es igual a: 4000000 $\n");
											tumba.setTiempo(tiempo);
										}
										

										//DATOS MASCOTA
										boolean control43 = true;
										while(control43==true)
										try {
											System.out.println("Digitación de los datos de la mácota:\n");
											System.out.print("Nombre : ");
											String namePet = entrada.nextLine();
											System.out.print("Tipo : ");
											String tipo = entrada.nextLine();
											System.out.print("Edad : ");
											int edad = entrada.nextInt();
											entrada.nextLine();
											System.out.print("Sexo : ");
											String sex = entrada.nextLine();
											System.out.print("Fecha de fallecimiento (dia/mes/año): ");
											String fecha = entrada.nextLine();
											System.out.print("\n");
											// CREAMOS EL OBJETO DE TIPO CLIENTE
											Animal animal = new Animal(namePet, tipo, edad, sex);
											// AÑADIMOS EL ANIMAL A MUERTO, Y LA FECHA
											tumba.setAnimal(animal);
											tumba.setFecha(fecha);
											control43 = false;
										}
										catch(InputMismatchException e) {
											System.out.println("Error con algún dato.\n");
										}
										
										System.out.println("Para finalizar, escribe el mensaje para la tumba: ");
										String mensaje = entrada.nextLine();
										//SE REGISTRA EL MENSAJE 
										tumba.setMensaje(mensaje);
										//FINALIZA EL PROCESO DE REGISTRO
										System.out.println("Se ha realizado el proceso de registro.\n");
										//SE AGREGAN LAS CENIZAS A LA FUNERARIA 
										funerarias.get(menu).añadirTumba(tumba);
										
										//----------- EMPIEZA AUTOMATICAMENTE LA PRIMERA VISITA AL CEMENTERIO-----------------------
										System.out.println("Comienza la visita a las tumbas:\n");
										System.out.println(funerarias.get(menu).visita("tumbas"));
										
										System.out.println("¿Deseas colocarle flores a alguna tumba (si/no)?: ");
										
										while(true) {
										
											String si_no = entrada.nextLine();// SI / NO ------------------------- FLORES-----------------
											if (si_no.equals("no")||si_no.equals("NO")) {
												System.out.println("\nUna muerte bella, honra toda vida...\n");
												break;
											}
											else if(si_no.equals("si")||si_no.equals("SI")) {
												System.out.print("Ingresa el nombre de la flor que te gustaría poner: ");
												String flor = entrada.nextLine();
												
												System.out.print("¿A cuál tumba? (digite el número de la tumba): ");
												
												int control53 = 0;
												while (control53==0) {
													try {
														control53 = entrada.nextInt();
														if (control53>0 && control53<=Funeraria.tumbas.size()) {
															break;
														}
														else {
															System.out.println("Ingrese un número válido por favor");
															control53 = 0;
															continue;
														}
													}
													catch(InputMismatchException e) {
														System.out.println("Por favor ingrese solo números.");
													}
													finally {
															entrada.nextLine();//SALTO DE LINEA
														}
												}
												
												System.out.println("\n"+funerarias.get(menu).florTumbas(control53, flor)+"\n");
												
												
												break;
											}
											else {
												System.out.println("Escoja una opción válida (si/no)");
												continue;
											}
										}	
									}
									break;
								}
								else {
									System.out.println("No hay espacio disponible, por favor seleccione otro centro.");
									break;
								}
								
							}//ELSE CASO ENTIERRO
							
							else if (menu2==3) {
								// VISITA--------------------------------------------------------------------------------------------
								System.out.println("\n ¿Qué te gustaría visitar?\n");
								System.out.println("1. Los osarios.");
								System.out.println("2. Las tumbas.");
								System.out.println("3. Salir.\n");
								System.out.println("Ingrese el número de la opción que desea");
								
								int menu5 = 0;
								while (menu5==0) {
									try {
										menu5 = entrada.nextInt();
										if (menu5>0 && menu5<=3) {
											break;
										}
										else {
											System.out.println("Ingrese un número válido por favor");
											menu5 = 0;
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
								
								if (menu5==1) {
									// VISITA OSARIOS ---------------------------------------------------------------------------------
									System.out.println("Comienza la visita a las cenizas:\n");
									System.out.println(funerarias.get(menu).visita("Cenizas"));
									
									System.out.println("¿Deseas colocarle flores a algún osario (si/no)?: ");
									
									while(true) {
									
										String si_no = entrada.nextLine();// SI / NO ------------------------- FLORES-----------------
										if (si_no.equals("no")||si_no.equals("NO")) {
											System.out.println("\nUna muerte bella, honra toda vida...\n");
											break;
										}
										else if(si_no.equals("si")||si_no.equals("SI")) {
											System.out.print("Ingresa el nombre de la flor que te gustaría poner: ");
											String flor = entrada.nextLine();
											
											System.out.print("¿A cuál osario? (digite el número de osario): ");
											
											int control53 = 0;
											while (control53==0) {
												try {
													control53 = entrada.nextInt();
													if (control53>0 && control53<=Funeraria.cenizas.size()) {
														break;
													}
													else {
														System.out.println("Ingrese un número válido por favor");
														control53 = 0;
														continue;
													}
												}
												catch(InputMismatchException e) {
													System.out.println("Por favor ingrese solo números.");
												}
												finally {
														entrada.nextLine();//SALTO DE LINEA
													}
											}
											
											System.out.println("\n"+funerarias.get(menu).florCenizas(control53, flor)+"\n");
											
											
											break;
										}
										else {
											System.out.println("Escoja una opción válida (si/no)");
											continue;
										}
									}
								}
								else if (menu5==2) {
									// VISITA CEMENTERIO -------------------------------------------------------------------------------
									System.out.println("Comienza la visita a las tumbas:\n");
									System.out.println(funerarias.get(menu).visita("tumbas"));
									
									System.out.println("¿Deseas colocarle flores a alguna tumba (si/no)?: ");
									
									while(true) {
									
										String si_no = entrada.nextLine();// SI / NO ------------------------- FLORES-----------------
										if (si_no.equals("no")||si_no.equals("NO")) {
											System.out.println("\nUna muerte bella, honra toda vida...\n");
											break;
										}
										else if(si_no.equals("si")||si_no.equals("SI")) {
											System.out.print("Ingresa el nombre de la flor que te gustaría poner: ");
											String flor = entrada.nextLine();
											
											System.out.print("¿A cuál tumba? (digite el número de la tumba): ");
											
											int control53 = 0;
											while (control53==0) {
												try {
													control53 = entrada.nextInt();
													if (control53>0 && control53<=Funeraria.tumbas.size()) {
														break;
													}
													else {
														System.out.println("Ingrese un número válido por favor");
														control53 = 0;
														continue;
													}
												}
												catch(InputMismatchException e) {
													System.out.println("Por favor ingrese solo números.");
												}
												finally {
														entrada.nextLine();//SALTO DE LINEA
													}
											}
											
											System.out.println("\n"+funerarias.get(menu).florTumbas(control53, flor)+"\n");
											
											
											break;
										}
										else {
											System.out.println("Escoja una opción válida (si/no)");
											continue;
										}
									}	
								}
								break;
							}//ELSE CASO VISITA CEMENTERIO 
							
				}// BUCLE SELECCION DE QUE HACER
			}//ELSE CASO DONDE NO ESCOGIÓ SALIR
		} //BUCLE SELECCIÓN CENTRO
	}// MAIN 
}// CLASE


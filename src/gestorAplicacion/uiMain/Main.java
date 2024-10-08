package src.gestorAplicacion.uiMain;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import src.baseDatos.Deserializador;
import src.baseDatos.Serializador;
import src.gestorAplicacion.administracion.Adopcion;
import src.gestorAplicacion.administracion.CentroAdopcion;
import src.gestorAplicacion.administracion.Cita;
import src.gestorAplicacion.administracion.Funeraria;
import src.gestorAplicacion.administracion.Tienda;
import src.gestorAplicacion.componentes.Animal;
import src.gestorAplicacion.componentes.Cliente;
import src.gestorAplicacion.componentes.Cupo;
import src.gestorAplicacion.componentes.Empleado;
import src.gestorAplicacion.componentes.Muerto;

public class Main {
	
	//ARRAYLIST DONDE SE VAN A GUARDAR LAS SEDES
	public static Scanner entrada = new Scanner(System.in);
	public static ArrayList<CentroAdopcion> sedes = new ArrayList<CentroAdopcion>();
	
	//CREANDO LOS APUNTADORES DE SEDE 
	static CentroAdopcion sede1;
	static CentroAdopcion sede2;
	static CentroAdopcion sede3;
		
	public static void main(String[] args) {
		
		Deserializador.deserializarListas();
				
		while (true) {

				println("\n¡Bienvenido a AdoptaLove!\n¿Qué quieres hacer hoy?\n");
				println("1. Adoptar una mascota");
				println("2. Agendar un servicio para tu mascota");
				println("3. Comprar en la tienda para mascotas");
				println("4. Ingresar a servicios funerarios");
				println("5. Salir del programa");
				
				int menu = 0;
				while (menu==0) {
					try {
						print("\nElige una opcion: ");
						menu = readInt();
						if (menu>0 && menu<=5) {
							break;
						}
						else {
							println("Ingrese un número válido por favor");
							menu = 0;
							continue;
						}
					}
					catch(InputMismatchException e) {
						System.out.println("Por favor ingrese un número entre uno y seis!!!");
					}
					finally {
							entrada.nextLine();//SALTO DE LINEA
						}
				}
				
				switch (menu) {
					case 1: adoptarAnimal(); break;
					case 2: agendar_servicio(); break;
					case 3: tienda(); break;
					case 4: funeraria(); break;
					case 5: salirDelSistema(); break;
				}
				
		}
				
	}//MAIN	
			
	
		
	//MÉTODOS NECESARIOS	
	//ENTRADAS DE DATOS POR TIPO
	static byte readByte() {
		return entrada.nextByte();
	}
	
	static int readInt() {
		return entrada.nextInt();
	}
	
	static String readString() {	
		String string = entrada.nextLine();
		return string;
	}
	
	static long readLong() {
		return entrada.nextLong();
	}
	
	static boolean readBoolean() {
		boolean x=entrada.nextBoolean();
		return x;
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
	
   
	//MÉTODO ESTÁTICO FUNCIONALIDAD ADOPTAR ANIMAL
	static void adoptarAnimal() {
		
		println("\n¡Gracias por tu interés en adoptar un animal! Estamos emocionados de ayudarte a encontrar a tu nuevo amigo.\n"
				+ "Para comenzar el proceso de adopción, por favor, proporciona la siguiente información.\n");
		
		//DATOS PERSONALES DEL USUARIO
		String nombre;
		int edad = 0;
		long cedula = 0 ;
		long telefono = 0;
		String direccion;
		
		print("Ingrese su nombre: " );
		nombre = readString();
		
		while(edad <= 0) {		
		    try {
				print("Ingrese su edad: ");
				edad = readInt();
				if (edad <= 0) {
					println("Proporcione una respuesta válida.\n");
					edad=0;
				}
		    }catch(RuntimeException e) {
		    	println("Proporcione una respuesta válida.\n");
		    }finally {
		    	readString();//CONSUMIR SALTO DE LÍNEA.
		    	}
		}
		
		if (edad < 18) { //SI EL INTERESADO ES MENOR DE EDAD, ENTONCES NO PODRÁ REALIZAR LA ADOPCIÓN

			println("\nLamentamos informarle que debido a su condición de menor de edad, no puede realizar la adopción de una mascota. "
					+ "\nEste requisito es parte de nuestros protocolos y políticas de adopción.");
		}
		else {	
			while(cedula==0 || telefono==0) {
				try {
					while(cedula<=0) {	
						if (cedula <= 0) {
							print("Ingrese su número de CC: ");
							cedula = readLong();
							if (cedula<=0) {
								println("Proporcione una respuesta válida.\n");
								cedula=0;
							}
						}
					}
					
					while(telefono<=0) {
						if (telefono<=0) {
							print("Ingrese su número de teléfono: ");
							telefono = readLong();
							if (telefono<=0) {
								println("Proporcione una respuesta válida.\n");
								telefono=0;
							}
						}
					}
			}catch(RuntimeException e) {
				println("Proporcione una respuesta válida.\n");
				}finally {
					readString(); //CONSUMIR SALTO DE LÍNEA
				}
			}
			
			print("Ingrese su dirección: ");
			direccion = readString();
			
			//ENCUESTA
			 println("\nLa presente encuesta representa un instrumento necesario para verificar si usted cumple con los requisitos \npreestablecidos por AdoptaLove para ser admitido en calidad de adoptante.\n");
		        print("Por favor, responda a las preguntas en una escala de 1 a 5, siendo 1 la calificación más baja y 5 la más alta.");
		        
			int puntajeEncuesta = 0; //PUNTAJE QUE EL USUARIO OBTENGA
				
			for (int i=1; i<=7; i++) {
				int respuesta = 0;	
				
				do {
				println(Adopcion.preguntasEncuesta(i));
				
				//do {
					try {
						print("Ingrese su respuesta en el rango [1-5]: ");
						respuesta= readInt();
						
						if(respuesta<1 || respuesta>5) {
							println("Proporcione una respuesta válida.");
							respuesta = 0;				
						}
						else {
							if(i!=3) {
								puntajeEncuesta+=respuesta;
							}
							else {
								puntajeEncuesta-=respuesta; //LA PREGUNTA 3, BAJA PUNTOS MIENTRAS LA RESPUESTA
								                            //SEA MÁS ALTA.
							}
						}
					}
					catch(RuntimeException e) {
						println("Proporcione una respuesta válida.");
						readString(); //CONSUMIR EL SALTO DE LINEA		
					}
					
				}while(respuesta<1 || respuesta>5);
			}
			
			if (puntajeEncuesta<18) {
				println("\nEstimado " + nombre + ", lamentablemente no cumple con los requisitos necesarios para ser adoptante en AdoptaLove, \npor lo que no podemos continuar con el proceso de adopción.");
			}
			else {
				println("\nEstimado " + nombre + ", usted reúne los criterios para ser adoptante en AdoptaLove, por lo que continuaremos con el proceso de adopción.");
				
				ArrayList<Animal> mascotas_adoptadas= new ArrayList<>();//ARRAY QUE GUARDA LAS MASCOTAS
				                                                        //SELECCIONADAS.
				
				//ESCOGER LA SEDE 
				String bucle_sede = "si";
				CentroAdopcion SEDE = null;
				
				do { //COMIENZA EL BUCLE	
				    int opcion_sede=0;
				   
				    println("Seleccione en cual sede quiere realizar la adopción.");
				    println("1. SEDE BELLO\n2. SEDE ITAGÜI\n3. SEDE MEDELLÍN");
				   
				    do {    	
				    	try {
					    print("Ingrese su elección dentro del rango [1-3]: ");
					    opcion_sede= readInt();
					   
					    if (opcion_sede<1 || opcion_sede>3) {
					    	println("Proporcione una respuesta válida.\n");
					    	}
					    }catch(RuntimeException e) {
					    	println("Proporcione una respuesta válida.\n");
					    	
					    }finally {
						   readString(); //CONSUMIR SALTO DE LÍNEA
						   }
				    	
				    }while(opcion_sede<1 || opcion_sede>3); 
				   
				    SEDE = sedes.get(opcion_sede -1); //SEDE SELECCIONADA PARA REALIZAR LA ADOPCIÓN.
				    
		     	    //COMPROBAR SI LA SEDE SELECCIONADA TIENE ANIMALES DISPONIBLES PARA ADOPCIÓN
				    if (SEDE.tieneMascotas()!= true) {
				    	
				    	//SI NO HAY MASCOTAS DISPONIBLES, SE LE DA LA POSIBILIDAD DE ESCOGER OTRA SEDE
				    	println("\nLo sentimos, en estos momentos esta sede no cuenta con mascotas disponibles para adopción.");
				    	
				    	println("¿Desea intentar realizar la adopción en otra de nuestras sedes?");
				    	do {
				    		print("Responda si / no: ");
				    	    bucle_sede= readString();
				    	    
				    	    if (bucle_sede.equalsIgnoreCase("si")!=true && bucle_sede.equalsIgnoreCase("no")!=true) {
				    	    	println("Proporcione una respuesta válida.\n");
				    	    }
				    	}while (bucle_sede.equalsIgnoreCase("si")!=true && bucle_sede.equalsIgnoreCase("no")!=true);
			
	    		    					    	
				    }	
				    
				    else {
				    	
				    	//SI HAY MASCOTAS DISPONIBLES, SE LE BRINDAN DOS OPCIONES DE VISUALIZACIÓN
				    	println("\n¿Desea ver todas las mascotas disponibles o filtrar por una especie en especifico?");	   
						int opcion=0; //OPCIÓN DE VISUALIZACIÓN
						Animal mascota_seleccionada = null; //MASCOTA SELECCIONADA PARA ADOPCIÓN
						     
						println("1. Ver todos las mascotas disponibles.\n2. Filtrar por tipo.");     			
						do { 
							try {
								print("Ingrese una opción dentro del rango [1-2]: ");
							    opcion = readInt();
							   
							    if (opcion!=1 && opcion!=2) {
								   println("Proporcione una respuesta válida.");
							   }
						   }catch(RuntimeException e) {
							   println("Proporcione una respuesta válida.");
						   }finally {
							   readString();//CONSUMIR SALTO DE LÍNEA
							   }
						}while(opcion!=1 && opcion!=2);				
						
						switch(opcion) {
						
						//CASO 1. VISUALIZAR TODAS LAS MASCOTAS DISPONIBLES
						case 1:
							
							//OBTENER TODOS LOS ANIMALES QUE ESTÉN DISPONIBLES:
							ArrayList <Animal> animalesDisponibles = SEDE.animalesDisponibles();
							
							println("\nPor favor, seleccione el número de la mascota que desea adoptar o la opción " + (animalesDisponibles.size()+1) + " para cancelar.");
							
							int i=1;
							for (Animal mascota: animalesDisponibles) {
								println(i + ". " + mascota);
								i++;
							}
							println(i + ". Cancelar adopción."); //OPCIÓN PARA CANCELAR LA ADOPCIÓN POR SI 
							                                     //NO LE LLAMÓ LA ATENCIÓN ALGUNO DE LOS DISPONIBLES.
							
							// SELECCIONAR LA MASCOTA DE SU PREFERENCIA
							int num_mascota=0;
							   do {
								   try {
								   print("\nIngrese su elección: ");
								   num_mascota = readInt();
								  
								   if (num_mascota<=0 || (num_mascota> animalesDisponibles.size() + 1)) {
									   println("Proporcione una respuesta válida.");
									   }
								   }catch(RuntimeException e) {
									   println("Proporcione una respuesta válida.");
								   }finally {
									   readString();
								   }
							   }while(num_mascota<=0 || num_mascota > (animalesDisponibles.size()+1));
							   
							   //SI LA PERSONA ELIGIÓ CANCELAR:
							   if (num_mascota==(animalesDisponibles.size()+1)) {
								   
								   bucle_sede="no"; //TERMINAR EL BUCLE
								   println("Se ha cancelado la adopción.");
							   }
							   else {
								   mascota_seleccionada = animalesDisponibles.get(num_mascota-1); //MASCOTA SELECCIONADA
							       SEDE.borrarAnimal(mascota_seleccionada); //QUITAR LA MASCOTA DE DISPONIBLES
							       
							       mascotas_adoptadas.add(mascota_seleccionada);//AGREGAR AL ARRAYLIST DE MASCOTA ADOPTADAS
							       
							       bucle_sede="_si";
							       }
							   break;
							   
						case 2:
							
							//FILTRAR EL TIPO DE LA MASCOTA.
							ArrayList<Animal> mascotas_filtroTipo; //ARRAY QUE GUARDA LAS MASCOTAS QUE COINCIDAN CON LA ESPECIE
							println("\nLos tipos de mascotas que se manejan en AdoptaLove son: ");
							   
							String[]tipos_animales = {"Perro", "Gato", "Canario", "Conejo", "Hámster"};
							
							int indice=1;
							   
							for (String tipo: tipos_animales) {
								println(indice + ". " + tipo + "s" );
								indice++;				   
							}
							   
							int especie=0;			   
							do {
								try {
							    print("Ingrese una opción dentro del rango [1-5]: ");   
							    especie = readInt();
							   
							    if(especie<1 || especie>5) {
							    	println("Proporcione una respuesta válida.");
							    	} 
							    } catch(RuntimeException e) {
									  println("Proporcione una respuesta válida.");
									  
							    }finally {
									   readString();
									   }
								} while(especie<1 || especie>5);
							
							
							    //VERIFICAR SI HAY MASCOTAS DE ESE TIPO
							    mascotas_filtroTipo = SEDE.animalesDisponibles(tipos_animales[especie -1]);
							    
							    if (mascotas_filtroTipo.size()==0) {
							    	
							  	    //SI NO HAY MASCOTAS DISPONIBLES SE LE DA LA POSIBILIDAD DE ESCOGER EN OTRA SEDE
								    println("\nLo sentimos, en este momento en la sede no se encuentran mascotas de ese tipo disponibles para adopción.");
								    
								    //DAR LA POSIBILIDAD DE BUSCAR EN OTRA SEDE
							    	do {
							    		println("¿Desea ver las mascotas en otras de nuestras sedes?");
							    		print("Responda si / no: ");
							    	    bucle_sede= readString();
							    	    
							    	    if (bucle_sede.equalsIgnoreCase("si")!=true && bucle_sede.equalsIgnoreCase("no")!=true) {
							    	    	println("Proporcione una respuesta válida.\n");
							    	    }
							    	}while (bucle_sede.equalsIgnoreCase("si")!=true && bucle_sede.equalsIgnoreCase("no")!=true);
							   }	   
							   else {
								   
								   //SI HAY MASCOTAS DISPONIBLES, ENTONCES SERÁN MOSTRADAS AL USUARIO
								   int j=1;
								   int numeromascota=0;
								   println("\nPor favor, seleccione el número de la mascota que desea adoptar o la opción " + (mascotas_filtroTipo.size()+1) + " para cancelar.");
								   
								   for (Animal seleccion: mascotas_filtroTipo) {
									   println(j + ". " + seleccion);
									   j++;
								   }
								   println(j + ". Cancelar"); //OPCIÓN PARA CANCELAR LA ADOPCIÓN
								   
								   do {
									   try {
				               print("\nIngrese su elección: ");
								   
								    numeromascota = readInt();
								  if(numeromascota<=0 || (numeromascota > mascotas_filtroTipo.size()+1)) {
									  
									  println("Proporcione una respuesta válida.\n");
								  }
									   }catch(RuntimeException e) {
										   println("Proporcione una respuesta váñida.\n");
									   }finally {
										   readString();
									   }
								   }while (numeromascota<=0 || numeromascota > (mascotas_filtroTipo.size()+1));
								   
								   if (numeromascota== mascotas_filtroTipo.size()+1) {
									   bucle_sede="no"; //TERMINAR EL BUCLE
									   println("\nSe ha cancelado la adopción.");
								   }
								   else {
									   mascota_seleccionada = mascotas_filtroTipo.get(numeromascota - 1); //MASCOTA SELECCIONADA
								       SEDE.borrarAnimal(mascota_seleccionada); //QUITAR MASCOTA DE DISPONIBLES
								   
								       mascotas_adoptadas.add(mascota_seleccionada); //AGREGAR AL ARRAYlIST DE MASCOTAS ADOPTADAS
								       bucle_sede="_si";
								       }
							   }	
							    
							    break;
						}
										    
				    }
				    
				    if ( bucle_sede.equalsIgnoreCase("_si")== true && (mascotas_adoptadas.size()>0 && mascotas_adoptadas.size()<3))  {			    	
				    	do {
				    		println("¿Desea realizar otra adopción?");
				    		print("Responda si / no: ");
				    	    bucle_sede= readString();
				    	    
				    	    if (bucle_sede.equalsIgnoreCase("si")!=true && bucle_sede.equalsIgnoreCase("no")!=true) {
				    	    	println("Proporcione una respuesta válida.\n");
				    	    }
				    	 }while (bucle_sede.equalsIgnoreCase("si")!=true && bucle_sede.equalsIgnoreCase("no")!=true);
				    	
				    }
				    else {
				    	if (mascotas_adoptadas.size()>=3) {
				    		println("\nAdoptaLove establece un límite de tres adopciones consecutivas por parte de un mismo adoptante.\n"
				    		+ "Si desea adoptar uno o varios animales adicionales, deberá iniciar un nuevo proceso de adopción desde el principio.");
				    	
				    	    bucle_sede= "no"; //SALIR DEL CICLO
				    	    }
				    }
					   
				}while (bucle_sede.equalsIgnoreCase("si")); //TERMINAR EL BUCLE
				
				
				if (mascotas_adoptadas.size()==0) {
					//SI NO ADOPTÓ NINGUNA MASCOTA, ENTONCES SE IMPRIME:
					println("\nLamentamos que no haya podido concretar la adopción. Ha sido un placer atenderle, Sr./Sra. " + nombre + ". ¡Esperamos su regreso!");
				}
				else {
					//CREACIÓN DEL OBJETO
					Cliente nuevo_cliente = new Cliente(nombre,edad,cedula,telefono,direccion);	
					
					ArrayList <Adopcion> adopciones_realizadas = SEDE.registrar_adopciones(mascotas_adoptadas, nuevo_cliente); //TERCERA INTERACCIÓN
					
					if (adopciones_realizadas.size()>1) {
						println("\nDETALLES ADOPCIONES: ");
					}
					else {
						println("\nDETALLES ADOPCIÓN: ");		
					}
				
					for (Adopcion adopcion : adopciones_realizadas) {						
						println(adopcion);
						println("-----------------------\n");	
					}
					
					if (adopciones_realizadas.size()>1) {
						print("Sr./Sra. " + nombre + " por realizar las " + adopciones_realizadas.size() + " adopciones, ");
					}
					else {
						print("Sr./Sra. " + nombre + " por realizar la adopción, ");		
					}
					
					println(""
							+ "usted ha ganado " + (adopciones_realizadas.size()*5) + " puntos que serán agregados a su saldo "
							+ "de puntos.\nEstos puntos son canjeables para obtener descuentos en nuestros servicios y productos de nuestras tiendas."
							+ "\nEn este momento tiene un total de " + CentroAdopcion.isCliente(nuevo_cliente).getPuntos() + " puntos.");
					
					println("\nHa sido un placer atenderle, Sr./Sra. " + nombre + ". ¡Hasta pronto!");
									
				}			   			   			   
			}				
		}	
	}

	
	static void agendar_servicio(){
		
		ArrayList<Cita> citas_agendadas= new ArrayList<>();
		
		println("\n¡Gracias por elegirnos para cuidar de tu peludito!\nPor favor, sigue las instrucciones a continuación para que podamos atenderlo de la mejor manera.🐾");
	
		//SELECCIÓN DE SEDE Y SERVICIO
		boolean repetir = false;
		boolean mismoUsuario=false;
		
		Cliente cliente= null;
		do {
		int servicio=0;
		println("\nLe recordamos que cada sede de AdoptaLove ofrece un servicio diferente para las mascotas, seleccione según sea su necesidad. \n¿Qué servicio desea agendar?");
        println("\n1. SEDE BELLO - Servicio: Guarderia \n2. SEDE ITAGÜI - Servicio: Veterinaria \n3. SEDE MEDELLÍN - Servicio: Peluquería\n");
        do {
            print("Ingrese su elección dentro del rango [1-3]: ");
            try {
            	servicio = readInt();
            	if (servicio < 1 || servicio > 3) {
                println("Proporcione una respuesta válida.\n");
                }
            } catch (InputMismatchException e) {
            	println("Proporcione una respuesta válida.\n");
            }finally {
            	readString();
            	}
            } while (servicio < 1 || servicio > 3);
        
        
        //COMPROBAR PARA LA ESPECIE DE LA MASCOTA DEL CLIENTE SE OFRECE EL SERVICO QUE QUIERE
        boolean confirmacion=false;
        switch(servicio) {
     
         case 1:
        	println("\nLa disponibilidad de un cupo en el servicio de guardería tiene una duración de dos horas, con un costo de $10,000 pesos");
        	
        	println("El servicio de guardería de mascotas se encuentra principalmente disponible para perros y gatos.\n");
        	
        	String respuesta1;
	    	do {
	    		println("¿Su mascota pertenece a alguna de estas especies?");
	    		print("Responda si / no: ");
	    	    respuesta1= readString();
	    	    
	    	    if (respuesta1.equalsIgnoreCase("si")!=true && respuesta1.equalsIgnoreCase("no")!=true) {
	    	    	println("Proporcione una respuesta válida.\n");
	    	    }
	    	 }while (respuesta1.equalsIgnoreCase("si")!=true && respuesta1.equalsIgnoreCase("no")!=true);
	    	
	    	if (respuesta1.equalsIgnoreCase("si")==true) {
	    		confirmacion = true;
	    	}
	    	break;
	    	
        case 2:
        	println("\nUna consulta veterinaria tiene una duración de dos horas, con un costo de $20,000 pesos.");
        	
        	println("El servicio de veterinaria se encuentra disponible para perros, gatos, conejos y hámsters.\n");
        	
        	String respuesta2;
	    	do {
	    		println("¿Su mascota pertenece a alguna de estas especies?");
	    		print("Responda si / no: ");
	    	    respuesta2= readString();
	    	    
	    	    if (respuesta2.equalsIgnoreCase("si")!=true && respuesta2.equalsIgnoreCase("no")!=true) {
	    	    	println("Proporcione una respuesta válida.\n");
	    	    }
	    	 }while (respuesta2.equalsIgnoreCase("si")!=true && respuesta2.equalsIgnoreCase("no")!=true);
	    	
	    	if (respuesta2.equalsIgnoreCase("si")==true) {
	    		confirmacion = true;
	    	}
	    	break;
	    	
        case 3:
            println("\nLa disponibilidad de un cupo en el servicio de peluquería tiene una duración de dos horas, con un costo de $15,000 pesos.");
        	
        	println("El servicio de peluquería de mascotas se encuentra principalmente disponible para perros y gatos.\n");
        	
        	
        	String respuesta3;
        	
	    	do {
	    		println("¿Su mascota pertenece a alguna de estas especies?");
	    		print("Responda si / no: ");
	    	    respuesta3= readString();
	    	    
	    	    if (respuesta3.equalsIgnoreCase("si")!=true && respuesta3.equalsIgnoreCase("no")!=true) {
	    	    	println("Proporcione una respuesta válida.\n");
	    	    }
	    	 }while (respuesta3.equalsIgnoreCase("si")!=true && respuesta3.equalsIgnoreCase("no")!=true);
	    	
	    	if (respuesta3.equalsIgnoreCase("si")==true) {
	    		confirmacion = true;
	    	}
	    	break;
        	
        }
        //SI EL SERVICIO NO ESTÁ OFERTADO PARA LA ESPECIE, ENTONCES EL PROCESO NO PODRÁ CONTINUAR Y SE DARÁ POR FINALIZADO.
        if(confirmacion==false) {
        	
        	println("\nNos disculpamos, pero el servicio que desea no está disponible para su tipo de mascota. Agradecemos su comprensión.\n");
        	repetir = false;
        }
        else {
        	
        	//SI ES EL SERVICIO SI ESTÁ OFERTADO PARA LA ESPECIE 
        	
        	CentroAdopcion SEDE = sedes.get(servicio - 1); //SEDE SELECCIONADA
        	ArrayList <Empleado> empleados_disponibles = SEDE.tieneEmpleados(); //EMPLEADOS CON DISPONIBILIDAD EN LA SEDE
        	
        	//SI NO HAY EMPLEADOS CON DISPONIBILIDAD, EL PROCESO NO PODRÁ CONTINUAR Y SE DARÁ POR FINALIZADO.
        	if (empleados_disponibles.size()==0) {
        		
        		println("\nActualmente, debido a la falta de disponibilidad de citas, no es posible continuar con el proceso de agendamiento");
        		repetir = false;
        	}
        	//SI HAY EMPLEADOS CON DISPONIBILIDAD, ENTONCES EL USUARIO LOS PODRÁ VISUALIZAR
        	else {
        		switch(servicio) {
        		
        		case 1:
        			println("\nContamos con los siguientes cuidadores de mascotas, seleccione el de su preferencia:");
        	    	break;
        	    	
        		case 2:
        			println("\nContamos con los siguientes veterinarios, seleccione el de su preferencia:");
        	    	break;
        	    	
        		case 3:
        			println("\nContamos con los siguientes peluqueros de mascotas, seleccione el de su preferencia:");
        	    	break;	
        		}
        		
                int i = 1;
                
                for(Empleado emp : empleados_disponibles) {
                        println(i +" - "+ emp);
                        i++;
                }
                
                //SELECCIONAR AL EMPLEADO
                int num_empleado = 0;
        	 	do {
            		print("\nIngrese su elección dentro del rango [1-" + empleados_disponibles.size() + "]: " );
            		try {
            			num_empleado= readInt();
            			
            			if (num_empleado<1 || num_empleado > empleados_disponibles.size()) {
            				println("Proporcione una respuesta válida.");
            			}
            			
            		}catch(InputMismatchException e) {
            			println("Proporcione una respuesta válida.");
            		}finally {
            			readString();
            		}
            	}while(num_empleado<1 || num_empleado > empleados_disponibles.size());
        	 	
        	 	Empleado empleado_seleccionado = empleados_disponibles.get(num_empleado - 1);//EMPLEADO SELECCIONADO
        	 	println("Empleado seleccionado: " + empleado_seleccionado);//QUITAR
        	 	
        	 	
        	 	//SELECCIONAR EL DIA (LUNES, MARTES,MIERCOLES..) EN EL QUE SE QUIERE EL SERVICIO
        		println("\nSeleccione el día en el que desea el servicio.");
        		String[] diasSemana = {"lunes", "martes", "miércoles", "jueves", "viernes", "sábado"};
        	    int num_dia=0;
        	    for (int j = 0; j <diasSemana.length; j++) {
        	    	println((j + 1) + ". " + diasSemana[j]);
        	    	}
        	    
        	    do {
        	    	try {
        	    		print("Ingrese su elección dentro del rango [1-6]: ");
        	    		num_dia = readInt();
        	    		if (num_dia<1 || num_dia>6) {
        	    			println("Proporcione una respuesta válida.\n");
        	    			
        	    			}
        	    		}catch(InputMismatchException e) {
        	    			println("Proporcione una respuesta válida.\n");
        	    			readString();
        	    			}
        	    	}while(num_dia<1 || num_dia>6);
        	    
        	    //CUPOS QUE TIENE EL EMPLEADO PARA EL DIA SELECCIONADO
        	    ArrayList <Cupo> cupos_disponibles = empleado_seleccionado.cupos_disponibles(num_dia);
        	    
        	    //SI EL EMPLEADO NO TIENE CUPOS PARA ESE DÍA, ENTONCES EL PROCESO NO PODRÁ CONTINIAR.
        	    if (cupos_disponibles.size()==0) {
        	    	println("Lamentablemente, el empleado seleccionado no tiene disponibilidad para el día que se eligió.");
        	    	repetir = false;
        	    }
        	    else {
        	    	//SI EL EMPLEADO TIENE CUPOS PARA EL DIA SELECCIONADO, ENTONCES SE LE MOSTRARÁN AL CLIENTE
        	    	println("\nPor favor, seleccione la franja horaria que mejor se adapte a su necesidad. Si ninguna opción es adecuada,"
        	    			+ "\npuedes seleccionar la opción " + (cupos_disponibles.size()+1) +" para cancelar.\n");
        	    	
        	    	println("Cupos disponibles para el " + diasSemana[num_dia -1] + " " + cupos_disponibles.get(0).fechaFormateada() + ": "); 
        	    	int o = 1;
        	    	for (Cupo cupo: cupos_disponibles) {
        	    		
        	    		println( o + ". " + cupo);
        	    		
        	    		o++;
        	    	}
        	    	println((cupos_disponibles.size()+1) + ". Cancelar");
        	    	
        	    	//SELECCIONAR EL CUPO DE PREFERENCIA, O CANCELAR
        	    	int num_cupo=0;
        	    	do {
        	    		try {
        	    			print("Ingrese su elección en el rango en el rango [1 -" + (cupos_disponibles.size()+1) +"]: ");
        	    		    num_cupo = readInt();
        	    		
        	    		    if (num_cupo<1 || num_cupo>(cupos_disponibles.size()+1)) {
        	    		    	println("Proporcione una respuesta válida");
        	    		    }
        	    		    
        	         }catch(InputMismatchException e) {
        	        	 println("Proporcione una respuesta válida.");
        	    	}
        	    		finally {
        	    			readString(); //CONSUMIR SALTO DE LÍNEA
        	    		}
        	    		
        	    }while(num_cupo<1 || num_cupo>(cupos_disponibles.size()+1));
        	    	
        	    	//SI EL USUARIO DECIDE CANCELAR EL PROCESO DE AGENDAMIENTO DE CITA, ENTONCES EL PROCESO FINALIZARÁ.
        	    	if (num_cupo==(cupos_disponibles.size()+1)) {
        	    		
        	    		println("Se ha cancelado el agendamiento de la cita.");
        	    		
        	    	}
        	    	else {	
        	    		//DE LO CONTRARIO, SI SELECCIONA UNI, ENTONCES SE PROCEDE A REOCGER LOS DATOS DEL CLIENTE 
        	    		//Y LA MASCOTA.
        	    		Cupo cupo_seleccionado = cupos_disponibles.get(num_cupo-1);
        	    	    
        	    	    if (mismoUsuario!=true) {
        	    	    
        	    	    cliente = datos_cliente(); //DATOS DEL CLIENTE
        	    	    
        	    	    cliente = CentroAdopcion.isCliente(cliente); //COMPROBAR SI EL CLIENTE YA ESTÁ REGISTRADO
        	    	    readString();
        	    	    }
        	    	    
        	    	    Animal mascota = datos_mascota(servicio); //DATOS DE LA MASCOTA.
        	    	    
        	    	    //CREAR EL OBJETO DE TIPO CITA
        	    	    Cita nueva_cita = new Cita(cliente,mascota,empleado_seleccionado,cupo_seleccionado,servicio);
        	    	    
        	    	    citas_agendadas.add(nueva_cita);//AGREGAR LA CITA AL ARRAY DE CITAS QUE EL USUARIO ESTÁ AGENDANDO
        	    	    
        	    	    
        	    	    println("\n¡Cita agendada exitosamente!");
        	    	    
        	    	    
        	    	    println("\n¿Desea agendar otra cita?");
        	    	    String respues;
        	    	    readString(); //CONSUMIR SALTO DE LÍNEA
        		    	do {
        		    		print("Responda si / no: ");
        		    	    respues= readString();
        		    	    
        		    	    if (respues.equalsIgnoreCase("si")!=true && respues.equalsIgnoreCase("no")!=true) {
        		    	    	println("Proporcione una respuesta válida.\n");
        		    	    	
        		    	    }
        		    	 }while (respues.equalsIgnoreCase("si")!=true && respues.equalsIgnoreCase("no")!=true);
        		    	
        		    	if (respues.equalsIgnoreCase("si")==true) {
        		    		
        		    		repetir=true;
        		    		mismoUsuario = true;
        		    	}
        		    	else {
        		    		repetir = false;
        		    		mismoUsuario = false;
        		    	}     	    	    	    
        	    	}   	    	    	
        	    }    
        	}
		}
	}while(repetir);
		
		if (citas_agendadas.size()!=0) {
			
			boolean respuest = false;
			
			if (cliente.getPuntos()>15) {
				println("\nSr./Sra. " + cliente.getNombre() + " en estos momentos cuanta con " + cliente.getPuntos() + "\n"
						+ "¿Desea hacer uso de 15 puntos para obtener un descuento del 10%?");
				String entrada;
		    	do {
		    		print("Responda si / no: ");
		    	    entrada= readString();
		    	    
		    	    if (entrada.equalsIgnoreCase("si")!=true && entrada.equalsIgnoreCase("no")!=true) {
		    	    	println("Proporcione una respuesta válida.\n");
		    	    	
		    	    }
		    	 }while (entrada.equalsIgnoreCase("si")!=true && entrada.equalsIgnoreCase("no")!=true);
		    	
		    	if (entrada.equalsIgnoreCase("si")==true ) {
		    		respuest=true;
		    		
					for (Cita cita: citas_agendadas) {
						
						cita.aplicarDescuento();
						cliente.disminuir_puntos(15);			
					}
		    	}    				
			}
			
			println("\nDETALLES CITAS:");
			
			for (Cita cita:citas_agendadas) {
				
				println(cita);
				
				println("-----------------\n");
			}
	
		}	
	}
	
	
	public static Cliente datos_cliente() {
		
		println("\nAntes de continuar, le informamos que para hacer uso del servicio la persona encargada de la mascota debe ser mayor de edad.\n");
		
		String nombre;
		int edad=0;
		long cedula=0;
		
		println("Proporcione la siguiente información. ");
		print("Ingrese su nombre: ");
		nombre = readString();
		while(edad<=0) {
		    try {
				print("Ingrese su edad: ");
				edad = readInt();
				if (edad<=0) {
					println("Proporcione una respuesta válida.\n");
				}
		    }catch(RuntimeException e) {
		    	println("Proporcione una respuesta válida.\n");
		    }finally {
		    	readString();//CONSUMIR SALTO DE LÍNEA.
		    	}
		}
		
		if (edad<18) {
			println("El interesado en hacer uso del servicio es menor de edad.\n");
			do {
				println("Proporcione los datos de un adulto responsable: ");
				print("Ingrese su nombre: ");	
				nombre = readString(); 
				
			    try {
			    	print("Ingrese su edad: ");
				    edad= readInt();
				
				    if (edad<=0) {
				    	println("Proporcione una edad válida.\n");
				        }
				    
					if(edad>0 && edad<18) {
						println("La edad ingresada no corresponde a la de un adulto.\n");
		             }
					
				      } catch(RuntimeException e) {
				    	   println("Proporcione una respuesta válida.\n");
				   }finally {
						readString(); //CONSUMIR SALTO DE LÍNEA.
					}
			}while(edad<18);
		}
		
		while(cedula<=0) {
			try {
			print("Ingrese su número de identificación: ");
			cedula = readLong();
			if (cedula<=0) {
				println("Proporcione una respuesta válida.\n");
				cedula=0;
				}
			}catch (InputMismatchException e) {
				println("Proporcione una respuesta válida.\n");
				readString();
			}			
		}	
		
		Cliente cliente= new Cliente(nombre,edad,cedula);
		
		return cliente;
	}
	
	
	public static Animal datos_mascota(int servicio) {
		//readString();//CONSUMIR SALTO DE LÍNEA
		
		String nombre = null;
		int edad = 0;
		String especie = null;
		String sexo = null;
		
		println("\nProporcione la siguiente información sobre su mascota.");
		
		print("Ingrese el nombre: ");
		nombre= readString();
		
		do {
			try {
				print("Ingrese la edad (meses): ");
			    edad= readInt();
			
			    if (edad<=0) {
			    	println("Proporcione una  respuesta válida.\n");
			    	}
			    }catch(InputMismatchException e) {
			    	println("proporcione una respuesta válida.\n");
			    	readString();
			    	}		
		}while(edad<=0);
		
		int eleccion=0;
		int opciones=0;
		
		println("\nSeleccione la especie de su mascota.");
		if (servicio==1 || servicio==3) {
			opciones=2;
			println("1. Perro \n2. Gato");
		}
		
		if (servicio==2) {
			opciones=4;
			println("1. Perro \n2. Gato\n3. Conejo \n4. Hámster");
		}

		do {		
			try {
				print("Ingrese su elección dentro del rango [1-"+ opciones +"]: ");
		        eleccion=readInt();
		        
		        if (eleccion<1 || eleccion > opciones) {
		        	println("Opción fuera de rango.\n");
		        }
		        }catch(InputMismatchException e) {
		        	println("Se ha ingresado un tipo de dato incorrecto.\n");
		        	readString();
		        	}
			}while(eleccion<1 || eleccion>opciones);
		
		switch(eleccion) {
		
		case 1:
			especie="Perro";
			break;
		case 2:
			especie= "Gato";
			break;
		case 3:
			especie ="Conejo";
			break;
		case 4:
			especie="Hámster";
			break;		
		}
		
		println("\nSeleccione el género de su mascota: ");
		println("1. Macho\n2. Hembra");
		eleccion=0;
		
		do {		
			try {
				print("Ingrese su elección dentro del rango [1-2]: ");
		        eleccion=readInt();
		        
		        if (eleccion<1 || eleccion >2) {
		        	println("Proporcione una respuesta válida.\n");
		        }
		        }catch(InputMismatchException e) {
		        	println("Proporcione una respuesta válida.\n");
		        	readString();//CONSUMIR SALTO DE LÍNEA
		        	}
			}while(eleccion<1 || eleccion>2);
		
		switch(eleccion) {
		
		case 1:
			sexo="Macho";
			break;
		case 2:
			sexo="Hembra";
			break;
		}
		
		Animal mascota = new Animal(nombre,especie, edad,sexo);
		
		return mascota;	
	}
	
	
	public static void funeraria() {
		
		 Funeraria fune1 = new Funeraria(sede1);
		 Funeraria fune2 = new Funeraria(sede2);
		 Funeraria fune3 = new Funeraria(sede3);
		 ArrayList<Funeraria> funerarias = new ArrayList<> ();
		 
		funerarias.add(fune1);
		funerarias.add(fune2);
		funerarias.add(fune3);
		//-------------------------------------------------------------------------------------------------------
		// PROCESO FUNERARIA 
		
		println("Bienvenido al servicio de Funeraria"+"\n");
		
		//PRIMER CICLO PARA MANTENER AL USUARIO DENTRO DE LA FUNCIONALIDAD, HASTA QUE NO ESCOJA LA OPCIÓN 4
		while (true) { 
		
			println("Por favor, seleccione el centro de adopción más cercano: "+"\n");
			println("1. SEDE BELLO.");
			println("2. SEDE MEDELLIN.");
			println("3. SEDE ITAGÜI.");
			println("4. Salir.\n");
			print("Ingrese el número de la opción que desea: ");
			
			//MENU, ES LA VARIABLE QUE VA A RECIBIR LA ENTRADA
			int menu = 0;
			while (menu==0) { // SI ES 0, ES PORQUE NO SE HA MODIFICADO DE FORMA VÁLIDA
				try {
					menu = readInt(); //RECIBIENDO ENTRADA
					
					if (menu>0 && menu<=4) { //LIMITANDO LOS VALORES QUE PUEDE TOMAR
						break; // CASO EN EL QUE EL USUARIO INGRESÓ BIEN 
					}
					else {
						print("Ingrese un número válido por favor: ");
						menu = 0;
						continue;
					}
				}
				
				catch(InputMismatchException e) {
					println("Por favor ingrese un número entre 1 y 4");
				}
				finally {
						entrada.nextLine();//SALTO DE LINEA
					}		
				}//CIERRE DEL BUCLE CONTROL
			
				//------------------------- COMIENZAN LAS DECISIONES DEPENDIENDO DEL MENÚ -------------------------------------------------------------------------
			
				if (menu==4) {// CASO DE QUE QUIERA SALIR DE LA FUNCIONALIDAD 
					println("Gracias por tu visita. Si en algún momento necesitas algo más, no dudes en regresar.");
					break;
				}
				else {
					menu-=1; // SE LE RESTA AL MENÚ INICIAL, PORQUE ESTE VA A SER UN ÍNDICE EN LA LISTA DE FUNERARIAS 
					
					while (true) { // SE INICIA OTRO MENÚ PIDIENDOLE AL USUARIO LO QUE QUIERE HACER 
						println("\n¿Qué desea hacer?");
						println("1. Cremación.");
						println("2. Entierro.");
						println("3. Visitar cementerio");
						println("4. Salir.\n");
						
						int menu2 = 0; //MENU2, VARIABLE QUE VA A COMBIAR PARA RECIBIR EL MENÚ 
						
						while (menu2==0) { // SI ES 0, ES PORQUE TODAVÍA NO SE HA CAMBIADO CORRECTAMENTE
							
							try {
								print("Escoja entre las opciones dadas [1-4]: ");
								menu2 = readInt(); //RECIBIENDO ENTRADA
								if (menu2>0 && menu2<=4) { // SE LIMITAN LOS VALORES DE LA ENTRADA
									break; //SOLO SI SE CUMPLE ÉSTO, ROMPE EL CICLO 
								}
								else {
									println("Ingrese un número válido por favor");
									menu2 = 0;
									continue;
								}
							}
							
							catch(InputMismatchException e) {
								println("Por favor ingrese un número entre 1 y 4");
							}
							finally {
									entrada.nextLine();//SALTO DE LINEA
								}
							}// BUCLE CONTROL
						
							
							if (menu2==4) { // SI ESCOGIÓ SALIR DE ESE MENÚ 
								println(" ");// SALTO DE LINEA
								break;
							}
							
							else if(menu2==1) { 
								//CREMACIÓN---------------------------------------------------------------------------------------
								
								println("Verificando si la funeraria de la sede escogida tiene espacio...\n");
								
								//EN LA LISTA DE NUESTRAS FUNERARIAS, CON EL GET MENÚ SE GARANTIZA QUE EL PROCESO LO HAGA LA SEDE ESCOGIDA AL PRINCIPIO 
								if(funerarias.get(menu).espacioCenizas()==true) { // SE REVISA QUE SI HAYA ESPACIO EN LA LISTA
									
									//SI SI HUBO ESPACIO, SE LE PERMITE CONTINUAR CON EL SIGUIENTE MENÚ 
									println("¡Si hay espacio disponible!\n"); 
									println("Escoja entre las siguientes opciones:");
									println("1. Comprar Osario.");
									println("2. Alquilar Osario.");
									println("3. Salir.\n");
									
									int menu3 = 0; // MENU3, VARIABLE QUE CAMBIA AHORA PARA RESIBIR LA ENTRADA
									while (menu3==0) { // MIENTRAS NO SE HAYA CAMBIADO CORRECTAMENTE
										try {
											print("Escoja entre las opciones dadas [1-3]: ");
											menu3 = readInt(); //RECIBIENDO ENTRADA
											if (menu3>0 && menu3<=3) { //LIMITANDO LOS VALORES 
												break; // SALIENDO DEL CICLO PORQUE MENÚ CAMBIÓ BIEN 
											}
											else {
												println("Ingrese un número válido por favor");
												menu2 = 0;
												continue;
											}
										}
										catch(InputMismatchException e) {
											println("Por favor ingrese un número entre 1 y 3");
										}
										finally {
												entrada.nextLine();//SALTO DE LINEA
											}
										}//CIERRE BUCLE CONTROL
									
									//SI ESCOGIÓ ALQUILAR O COMPRAR
									if (menu3==1 || menu3==2) {
										
										String tiempo = "de por vida"; //ATRIBUTO QUE IRÁ EN CASO DE QUE HAYA ESCOGIDO COMPRAR 
										int  alquiler = 0; // ATRIBUTO QUE SE MULTIPLICARÁ PARA SACAR PRECIO, Y QUE SE ANEXARÁ PARA EL ATRIBUTO TIEMPO
										
										//SE CREA DE UNA VEZ EL OBJETO DE TIPO MUERTO, PARA HACER EL REGISTRO
										Muerto cenizas = new Muerto();
										
										if (menu3==2) { //SI PIDIÓ ALQUILAR EL OSARIO 
											println("\nConsigne el número de años que va a alquilar el osario:");
											println("(Ejemplo: 3, 4, etc..)");
											
											//CONTROL VARIABLE ALQUILER
											while(alquiler==0) {
												try {
													print("Ingresa tu respuesta: ");
													alquiler = readInt();
												}
												catch(InputMismatchException e){
													println("Ingrese únicamente un número");
												}finally {
													entrada.nextLine();
												}
												print("\n");
											}
										}// SE CONSIGUE EL TIEMPO DEL ALQUILER
										
										// REGISTRO DE CLIENTE PARA INCLUIRLO EN EL OBJETO MUERTO
										boolean control33 = true;
										while(control33==true) //BUCLE DE CONTROL PARA LOS DATOS 
										try {
											println("Por favor, ingrese sus datos para realizar la compra: ");
											print("Nombre : ");
											String name = readString();
											print("Dirección : ");
											String direc = readString();
											print("Edad : ");
											int edad = readInt();
											print("Cédula : ");
											long cedu = readLong();
											print("Número de celular : ");
											long numero = readLong();
											print("\n");
											
											// CREAMOS EL OBJETO DE TIPO CLIENTE
											Cliente cliente = new Cliente(name, edad, cedu, numero, direc);
											
											// SE LE AÑADE EL CLIENTE A LAS CENIZAS
											cenizas.setDueño(cliente);
											control33 = false; // TERMINA EL CONTROL 
										}
										catch(InputMismatchException e) {
											println("Error con algún dato.\n");
										}finally {
											entrada.nextLine();
										}
										
										if (menu3==2) {// SE ENSEÑA LA FACTURA DEL TOTAL A PAGAR, QUE EN ESTE CASO EL PRECIO SE CALCULA SEGÚN LOS AÑOS DE ALQUILER
											println("A su dirección se le enviará la factura, y se le estará contactando por telefono.");
											println("Total a pagar por los "+alquiler+" años son: "+alquiler*200000+" $.\n");
											cenizas.setTiempo(alquiler+" años");
										}
										else {// CASO DE COMPRA PERMANENTE, YA EXISTE UNA TARIFA FIJA 
											println("A su dirección se le enviará la factura, y se le estará contactando por telefono.");
											println("Total a pagar por el osario "+tiempo+" es igual a: 2000000 $\n");
											cenizas.setTiempo(tiempo);
										}
										

										//SE RECOGEN LOS DATOS MASCOTA, PARA AÑADIRLE AL OBJETO DE TIPO MUERTO
										boolean control43 = true;
										while(control43==true)
										try {
											println("Ingrese los datos de la mascota: ");
											print("Nombre que tenía: ");
											String namePet = readString();
											print("Tipo de animal: ");
											String tipo = readString();
											print("Edad con la que murió: ");
											int edad = readInt();
											entrada.nextLine();
											print("Sexo : ");
											String sex = readString();
											print("Fecha de fallecimiento (dia/mes/año): ");
											String fecha = readString();
											print("\n");
											
											// CREAMOS EL OBJETO DE TIPO ANIMAL
											Animal animal = new Animal(namePet, tipo, edad, sex);
											// AÑADIMOS EL ANIMAL A MUERTO, Y LA FECHA DE FALLECIMIENTO
											cenizas.setAnimal(animal);
											cenizas.setFecha(fecha);
											control43 = false;
										}
										catch(InputMismatchException e) {
											println("Error con algún dato.\n");
										}
										
										// SE LE PIDE PARA FINALIZAR, EL MENSAJE QUE SE VA A ENSEÑAR EN SU OSARIO
										print("Para finalizar, escribe el mensaje para el Osario: ");
										String mensaje = readString();
										//SE REGISTRA EL MENSAJE 
										cenizas.setMensaje(mensaje);
										//FINALIZA EL PROCESO DE REGISTRO
										println("\nSe ha realizado el proceso de registro.\n");
										//SE AGREGAN LAS CENIZAS A LA FUNERARIA 
										funerarias.get(menu).añadirCenizas(cenizas);
										
										//----------- EMPIEZA AUTOMATICAMENTE LA PRIMERA VISITA A LOS OSARIOS -----------------------
										println("Visitando a tu ser querido...\n");
										// LA FUNERARIA ENCARGADO LLAMA A SU MÉTODO VISITA PARA COMENZAR EL RECORRIDO
										println(funerarias.get(menu).visita("Cenizas"));
										
										print("¿Deseas obsequiar flores a algún osario (si/no)?: ");
										
										while(true) {//CONTROL DE COLOCAR FLORES 
										
											String si_no = readString();// SI / NO ------------------------- FLORES-----------------
											if (si_no.equals("no")||si_no.equals("NO")) {
												println("\nUna muerte bella, honra toda vida...\n");
												break; //CASO EN EL QUE SOLO SE QUIERA IR 
											}
											else if(si_no.equals("si")||si_no.equals("SI")) {
												//CASO EN EL QUE QUIERA DEJAR FLORES 
												print("\nIngresa el tipo de flores que te gustaría ofrendar: ");
												String flor = readString();
												// EL PROGRAMA DEJA QUE SE LEA EL STRING 
												
												print("¿Cuál osario escoges? digita su número: ");
												//EMPIEZA EL CONTROL DEL ÍNDICE, PARA COMPROBAR QUE NO SE PASE DEL RANGO 
												int control53 = 0;
												while (control53==0) {
													try {
														control53 = readInt();
														if (control53>0 && control53<=Funeraria.cenizas.size()) {
															break;//CASO EN QUE EL ÍNDICE SALIÓ BIEN 
														}
														else {
															println("Ingrese un número válido por favor");
															control53 = 0;
															continue;
														}
													}
													catch(InputMismatchException e) {
														println("Por favor ingrese solo números.");
													}
													finally {
															entrada.nextLine();//SALTO DE LINEA
														}
												}
												
												// YA PARA FINALIZAR, LA FUNERARIA ENCARGADA MANDA A PONER LA FLOR, EN LA POSICIÓN INDICADA
												println("\n"+funerarias.get(menu).florCenizas(control53, flor)+"\n");
												
												//TERMINA EL CICLO 
												break;
											}
											else {
												println("Digite una opción válida (si/no)");
												continue;
											}
										}
										
										
									}
									
									break;
								}
								else { // CASO EN EL QUE NO FUE POSIBLE ENCONTRAR ESPACIO EN EL CEMENTERIO.
									println("No hay espacio disponible, por favor seleccione otro centro.");
									break;
								}
							}//CIERRE DEL ELSE CASO CREMACIÓN
							
							else if(menu2==2) {
								// ENTIERRO ----------------------------------------------------------------------------------------
								//NO SE EXPLICARÁ ESTO, PORQUE ES MUY SIMILAR AL PROCESO DE CENIZAS
								
								println("Verificando si la funeraria de la sede escogida tiene espacio...\n");
								
								if(funerarias.get(menu).espacioTumbas()==true) {
									
									println("¡Si hay espacio disponible!");
									println("Escoja entre las siguientes opciones: \n");
									println("1. Comprar Terreno.");
									println("2. Alquilar Terreno.");
									println("3. Salir.\n");
									
									int menu3 = 0;
									while (menu3==0) { // COMPROBANDO SI EL NÚMERO ES VALIDO
										try {
											menu3 = readInt(); //RECIBIENDO ENTRADA
											if (menu3>0 && menu3<=3) {
												break;
											}
											else {
												println("Ingrese un número válido por favor");
												menu2 = 0;
												continue;
											}
										}
										catch(InputMismatchException e) {
											println("Por favor ingrese un número entre 1 y 3");
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
											println("\nDigite el número de años a alquilar el terreno:");
											println("(Ejemplo: 3, 4, etc..)");
										
											while(alquiler==0) {
												try {
													alquiler = readInt();
												}
												catch(InputMismatchException e){
													println("Ingrese únicamente un número");
												}finally {
													entrada.nextLine();
												}
												print("\n");
											}
										}// SE CONSIGUE EL TIEMPO DEL ALQUILER
										
										//DATOS DUEÑO
										boolean control33 = true;
										while(control33==true)
										try {
											println("Por favor, ingrese sus datos para realizar la compra:\n ");
											print("Nombre : ");
											String name = readString();
											print("Dirección : ");
											String direc = readString();
											print("Edad : ");
											int edad = readInt();
											print("Cédula : ");
											long cedu = readLong();
											print("Número de celular : ");
											long numero = readLong();
											print("\n");
											// CREAMOS EL OBJETO DE TIPO CLIENTE
											Cliente cliente = new Cliente(name, edad, cedu, numero, direc);
											// SE LE AÑADE EL DUEÑO A LAS CENIZAS
											tumba.setDueño(cliente);
											control33 = false;
										}
										catch(InputMismatchException e) {
											println("Error con algún dato.\n");
										}finally {
											entrada.nextLine();
										}
										
										if (menu3==2) {
											println("A su dirección se le enviará la factura, y se le estará contactando por telefono.");
											println("Total a pagar por los "+alquiler+" años son: "+alquiler*500000+" $.\n");
											tumba.setTiempo(alquiler+" años");
										}
										else {
											println("A su dirección se le enviará la factura, y se le estará contactando por telefono.");
											println("Total a pagar por el terreno "+tiempo+" es igual a: 4000000 $\n");
											tumba.setTiempo(tiempo);
										}
										

										//DATOS MASCOTA
										boolean control43 = true;
										while(control43==true)
										try {
											println("Ingrese los datos de la mascota:");
											print("Nombre : ");
											String namePet = readString();
											print("Tipo : ");
											String tipo = readString();
											print("Edad : ");
											int edad = entrada.nextInt();
											entrada.nextLine();
											print("Sexo : ");
											String sex = readString();
											print("Fecha de fallecimiento (dia/mes/año): ");
											String fecha = readString();
											print("\n");
											// CREAMOS EL OBJETO DE TIPO CLIENTE
											Animal animal = new Animal(namePet, tipo, edad, sex);
											// AÑADIMOS EL ANIMAL A MUERTO, Y LA FECHA
											tumba.setAnimal(animal);
											tumba.setFecha(fecha);
											control43 = false;
										}
										catch(InputMismatchException e) {
											println("Error con algún dato.\n");
										}
										
										print("Para finalizar, escribe el mensaje para la tumba: ");
										String mensaje = readString();
										//SE REGISTRA EL MENSAJE 
										tumba.setMensaje(mensaje);
										//FINALIZA EL PROCESO DE REGISTRO
										println("Se ha realizado el proceso de registro.\n");
										//SE AGREGAN LAS CENIZAS A LA FUNERARIA 
										funerarias.get(menu).añadirTumba(tumba);
										
										//----------- EMPIEZA AUTOMATICAMENTE LA PRIMERA VISITA AL CEMENTERIO-----------------------
										println("Visitando a tu ser querido...\n");
										println(funerarias.get(menu).visita("tumbas"));
										
										print("¿Deseas obsequiar flores a algúna tumba (si/no)?: ");
										
										while(true) {
										
											String si_no = readString();// SI / NO ------------------------- FLORES-----------------
											if (si_no.equals("no")||si_no.equals("NO")) {
												println("\nUna muerte bella, honra toda vida...\n");
												break;
											}
											else if(si_no.equals("si")||si_no.equals("SI")) {
												print("\nIngresa el tipo de flores que te gustaría ofrendar: ");
												String flor = readString();
												
												print("¿Cuál tumba escoges? digita su número: ");
												
												int control53 = 0;
												while (control53==0) {
													try {
														control53 = readInt();
														if (control53>0 && control53<=Funeraria.tumbas.size()) {
															break;
														}
														else {
															println("Ingrese un número válido por favor");
															control53 = 0;
															continue;
														}
													}
													catch(InputMismatchException e) {
														println("Por favor ingrese solo números.");
													}
													finally {
															entrada.nextLine();//SALTO DE LINEA
														}
												}
												
												println("\n"+funerarias.get(menu).florTumbas(control53, flor)+"\n");
												
												
												break;
											}
											else {
												println("Escoja una opción válida (si/no)");
												continue;
											}
										}	
									}
									break;
								}
								else {
									println("No hay espacio disponible, por favor seleccione otro centro.");
									break;
								}
								
							}//CIERRE DEL ELSE CASO ENTIERRO
							
							else if (menu2==3) {// CASO DE VISITA CEMENTERIO
								
								// VISITA--------------------------------------------------------------------------------------------
								println("\n¿Qué te gustaría visitar?");
								println("1. Los osarios.");
								println("2. Las tumbas.");
								println("3. Salir.\n");
								print("Ingrese el número de la opción que desea: ");
								
								//CONTROL DE RESPUESTA 
								int menu5 = 0; // MENU5 VARIABLE QUE CAMBIA PARA RECIBIR LA ENTRADA 
								while (menu5==0) {
									try {
										menu5 = readInt(); //PIDIENDO ENTRADA 
										if (menu5>0 && menu5<=3) {
											break;//CASO EN QUE LA ENTRADA ESTÁ BIEN 
										}
										else {
											println("Ingrese un número válido por favor");
											menu5 = 0;
											continue;
										}
									}
									catch(InputMismatchException e) {
										println("Por favor ingrese un número entre 1 y 3");
									}
									finally {
											entrada.nextLine();//SALTO DE LINEA
										}
								}
								
								if (menu5==1) {
									// VISITA OSARIOS ---------------------------------------------------------------------------------
									println("Visitando los osarios...\n");
									println(funerarias.get(menu).visita("Cenizas"));
									
									print("¿Deseas obsequiar flores a algún osario (si/no)?: ");
									
									while(true) {
									
										String si_no = readString();// SI / NO ------------------------- FLORES-----------------
										if (si_no.equals("no")||si_no.equals("NO")) {
											println("\nUna muerte bella, honra toda vida...\n");
											break;
										}
										else if(si_no.equals("si")||si_no.equals("SI")) {
											print("\nIngresa el tipo de flores que te gustaría ofrendar: ");
											String flor = readString();
											
											print("¿Cuál osario escoges? digita su número: ");
											
											int control53 = 0;
											while (control53==0) {
												try {
													control53 = readInt();
													if (control53>0 && control53<=Funeraria.cenizas.size()) {
														break;
													}
													else {
														println("Ingrese un número válido por favor");
														control53 = 0;
														continue;
													}
												}
												catch(InputMismatchException e) {
													println("Por favor ingrese solo números.");
												}
												finally {
														entrada.nextLine();//SALTO DE LINEA
													}
											}
											
											println("\n"+funerarias.get(menu).florCenizas(control53, flor)+"\n");
											
											
											break;
										}
										else {
											println("Escoja una opción válida (si/no)");
											continue;
										}
									}
								}
								else if (menu5==2) {
									// VISITA CEMENTERIO -------------------------------------------------------------------------------
									println("Visitando las tumbas...\n");
									println(funerarias.get(menu).visita("tumbas"));
									
									print("¿Deseas obsequiar flores a algúna tumba (si/no)?: ");
									
									while(true) {
									
										String si_no = readString();// SI / NO ------------------------- FLORES-----------------
										if (si_no.equals("no")||si_no.equals("NO")) {
											println("\nUna muerte bella, honra toda vida...\n");
											break;
										}
										else if(si_no.equals("si")||si_no.equals("SI")) {
											print("\nIngresa el tipo de flores que te gustaría ofrendar: ");
											String flor = readString();
											
											print("¿Cuál tumba escoges? digita su número: ");
											
											int control53 = 0;
											while (control53==0) {
												try {
													control53 = readInt();
													if (control53>0 && control53<=Funeraria.tumbas.size()) {
														break;
													}
													else {
														println("Ingrese un número válido por favor");
														control53 = 0;
														continue;
													}
												}
												catch(InputMismatchException e) {
													println("Por favor ingrese solo números.");
												}
												finally {
														entrada.nextLine();//SALTO DE LINEA
													}
											}
											
											println("\n"+funerarias.get(menu).florTumbas(control53, flor)+"\n");
											
											
											break;
										}
										else {
											println("Escoja una opción válida (si/no)");
											continue;
										}
									}	
								}
								break;
							}//ELSE CASO VISITA CEMENTERIO 
							
				}// BUCLE SELECCION DE QUE HACER
			}//ELSE CASO DONDE NO ESCOGIÓ SALIR
		} //BUCLE SELECCIÓN CENTRO	
	}//FINAL DEL MÉTODO
	
	
	public static void tienda() {
		

		
		//CREAMOS UN EMPLEADO PARA QUE ATIENDA LA TIENDA
		Empleado empliado = new Empleado("Albert", 22, 555, 1323, "West Elm", Empleado.Rol.TENDERO);
		
		// CREACIÓN DE TIENDA
		//t1 = new Tienda(empliado, sede1);
		Tienda t1 = new Tienda(empliado,sede1);
		
		// BUCLE QUE MANTIENE LA OPERACION DE LA TIENDA, DE ROMPERSE, SE TERMINA LA FUNCIONALIDAD
		
		boolean bucle = true; // VARIABLE PARA EL SEGUNDO MENÚ
		
		println("\n¡Bienvenido a la tienda de mascotas!"+"\n Aquí encontrarás los mejores productos para el cuidado y la diversión de tu compañero peludo."+"\n");
		
		while (true) { 
		
			println("¿Qué deseas hacer?");
			println("1. Ir de compras");
			println("2. Salir\n");
			println("Ingrese el número de la opción que desea [1-2]: ");
			
			int menu = 0; // ENTERO QUE EL USUARIO VA A INGREASAR, PARA ESCOGER OPCION 
			while (menu==0) { //MIENTRAS EL ENTERO SEA CERO (PARA CONTROLAR QUE EL USUARIO LE DÉ UN VALOR)
				try {//CONTROL DE ERRORES 
					menu = readInt(); //SE LEE EL ENTERO 
					if (menu>0 && menu<=2) { //SI ESTÁ ENTRE 1 Y 2 TERMINA 
						break;
					}
					else {
						println("Ingrese un número válido por favor");
						menu = 0;
						continue;
					}
				}
				catch(InputMismatchException e) {
					println("Por favor ingrese un número entre 1 y 2");
				}
				finally {
						entrada.nextLine();//SALTO DE LINEA
					}
			}
			
		if (menu==1) {	// OPCION 1 DEL PRIMER MENÚ, ADQUIRIR PRODCUTO.		
			while (bucle==true) { //UTILIZAMOS LA VARIABLE BUCLE INICIADA ANTES DEL PRIMER WHILE
				
				println("\n¿Cómo desea que se le muestren los productos?");
				println("1. Mostrar todo");
				println("2. Filtrar por tipo\n");
				print("Ingrese el número de la opción que desea [1-2]: ");
					
				int menuTienda = 0; // VOLVEMOS A RECIBIR UNA ENTRADA, ESTA VEZ PARA DECIDIR COMO FILTRAR LOS PRODUCTOS
				while (menuTienda==0) {
					try {
						menuTienda = readInt();
						if (menuTienda>0 && menuTienda<=2) { // SE CONTROLA QUE ESTÉ DENTRO DEL RANGO 
							break;
						}
						else {
							println("Ingrese un número válido por favor");
							menuTienda = 0;
							continue;
						}
					}
					catch(InputMismatchException e) {
						println("Por favor ingrese el numero 1 o 2");
					}
					finally {
						entrada.nextLine();//SALTO DE LINEA
					}
				}
				
				if (menuTienda==1) { //EN CASO DE QUE SE QUIERA VISUALIZAR TODOO	
					println("\nProductos disponibles:");
					println(t1.inventario()); // SE LLAMA AL MÉTODO INVENTARIO DE TIENDA, PARA QUE DEVULVA TODOS LOS PRODUCTOS SIN MÁS
				}
				else { // DE LO CONTRARIO, SE LE VOLVERÁ A PEDIR UNA ENTRADA PARA QUE INDIQUE POR QUE TIPO DE ANIMAL QUIERE VER 
					print("\n¿Por qué tipo de animal te gustaría ver? [Perros, gatos, aves, hamsters o conejos]: ");
					while (true) { //BUCLE PARA CONTROLAR ÉSTE NUEVO MENÚ
						try {
							String tipo = readString(); // SE LEE EL STRING 
							tipo.toLowerCase(); // SE PONE EL TEXTO EN MINÚSCULAS
							
							//LUEGO LO COMPARAMOS EN ESTE GRUPO DE CONDICIONALES SIMPLES 
							
							if (tipo.equals("perros") || tipo.equals("perro")) { 
								println("\nProductos disponibles:\n");
								println(t1.filtrar("perros")); //DEPENDIENDO DEL TIPO QUE INGRESÓ EL USUARIO, SE FILTRA DE UNA FORMA U OTRA
								break;
							}
							else if (tipo.equals("gatos") || tipo.equals("gato")) {
								println("\nProductos disponibles:\n");
								println(t1.filtrar("gatos")); //DEPENDIENDO DEL TIPO QUE INGRESÓ EL USUARIO, SE FILTRA DE UNA FORMA U OTRA 
								break;
							}
							else if (tipo.equals("aves") || tipo.equals("ave")) {
								println("\nProductos disponibles:\n");
								println(t1.filtrar("aves"));//DEPENDIENDO DEL TIPO QUE INGRESÓ EL USUARIO, SE FILTRA DE UNA FORMA U OTRA
								break;
							}	
							else if (tipo.equals("hamsters") || tipo.equals("hamster")) {
								println("\nProductos disponibles:\n");
								println(t1.filtrar("hamsters"));//DEPENDIENDO DEL TIPO QUE INGRESÓ EL USUARIO, SE FILTRA DE UNA FORMA U OTRA
								break;
							}
							else if (tipo.equals("conejos") || tipo.equals("conejo")) {
								println("\nProductos disponibles:\n");
								println(t1.filtrar("conejos"));//DEPENDIENDO DEL TIPO QUE INGRESÓ EL USUARIO, SE FILTRA DE UNA FORMA U OTRA
								break;
							}
							else {
								println("Por favor, ingrese el tipo del animal en minúsculas [Perros, gatos, aves o hamsters]");
								continue;
							}
						}
						catch(InputMismatchException e) {
							println("Por favor, coloque un tipo valido de animal");
						}
					}
				}
				
				// UNA VEZ QUE AL USUARIO SE LE IMPRIMIÓ LOS PRODUCTOS, VENIMOS ACÁ A CONTROLAR LA COMPRA
				
				boolean control = true;
				while (control) {
					try {
							print("Digite el índice del producto a comprar: ");
							int indice = readInt(); //INDICE PARA LOCALIZAR EL PRODUCTO QUE QUIERE EL USUARIO 
			
							print("Indique cuantas unidades necesita del producto: ");
							int unidades = readInt(); //CANTIDAD DE UNIDADES QUE EL USUARIO VA A COMPRAR
							
							//  REGISTRO DEL USUARIO PARA REALIZAR LA COMPRA-------------------------------------
							
							if (unidades==1) { //SI SOLO VA A COMPRAR UNA UNIDAD
								println("\nSus datos serán tomados para registrar la compra.");
								print("Ingrese su cédula: ");
								long cedula = entrada.nextLong();
								print("Ingrese su edad: ");
								int edad = entrada.nextInt();
								print("Ingrese su nombre: ");
								entrada.nextLine();
								String nombre = readString();
								
								//SE REGISTA EL USUARIO, CREANDO UN OBJETO DEL TIPO CLIENTE Y PASANDOLO AL MÉTODO COMPRA DE TIENDA 
								Cliente cliente = new Cliente(nombre, edad, cedula);
								println("\n"+t1.compra(indice, cliente)); 
								//ESTE FILTRO DE: UNIDADES == 1, ES PORQUE EL MÉTODO COMPRA QUE RECIBE DOS PARÁMETROS RETORNA ALGO MÁS ADECUADO PARA ESTE CASO 
							}
							else { // CUANDO EL USUARIO VA A COMPRAR MÁS DE UNA UNIDAD 
								println("\nSus datos serán tomados para registrar la compra.");
								print("Ingrese su cédula: ");
								long cedula = entrada.nextLong();
								print("Ingrese su edad: ");
								int edad = entrada.nextInt();
								print("Ingrese su nombre: ");
								entrada.nextLine();
								String nombre = readString();
								
								//SE REGISTA EL USUARIO, CREANDO UN OBJETO DEL TIPO CLIENTE Y PASANDOLO AL MÉTODO COMPRA DE TIENDA
								// SE LE AGREGA TAMBIEN, LA CANTIDAD DE UNIDADES AL MÉTODO COMPRA 
								Cliente cliente = new Cliente(nombre, edad, cedula);
								println("\n"+t1.compra(indice, unidades, cliente));
							}
							
							// --------------------------------------------------------------------------------
							
							control = false; //SI SE COMPLETÓ EL BLOQUE TRY, SE CAMBIA EL ESTADO A FALSO PARA ROMPER EL CICLO 
						
					}
					catch(InputMismatchException e) {
						println("Por favor lea e ingrese correctamente los datos\n");
					}
					
				}
				
				// SE LE PIDE SI DESEA VOLVER A REINICIAR EL CICLO DESDE EL MENÚ DE COMPRA 
				print("\n¿Desea volver al catálogo? [si/no]: ");
				String respuesta = " ";
				while (true) {//CONTROL CON UN WHILE SOLAMENTE, HASTA QUE NO RECIBA UNA RESPUESTA VÁLIDA.
					respuesta = entrada.nextLine();
					respuesta.toLowerCase();
					if (respuesta.equals("si")||respuesta.equals("no")) {
						break; 
					}else {
						println("Por favor, ingrese una respuesta válida [si/no]");
						continue;
					}
				}
					if (respuesta.equals("si")) {
						continue; //VOLVER A INICIAR CICLO DE COMPRA
					}
					else {
						println("Esperamos verlo por aquí pronto.\n");
						break; // SALIR DE LA TIENDA 
					}
				}//BUCLE COMPRAR
		}//CONDICINAL MENU INGRESAR TIENDA
		else {
			break;//OPCION 2 SALIR
		}
		}//BUCLE INICIAL
	}//FINAL MÉTODO TIENDA
	
	private static void salirDelSistema() {

		
		println("¡Vuelva pronto!");
		
		Serializador.serializarListas();
		
		System.exit(0);
	}
}
	

package gestorAplicación.uiMain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import gestorAplicación.procesoAdopcion.Adopcion;
import gestorAplicación.procesoAdopcion.Animal;
import gestorAplicación.procesoAdopcion.CentroAdopcion;
import gestorAplicación.procesoAdopcion.Cliente;
import gestorAplicación.procesoAdopcion.Persona;
import gestorAplicación.servicioAdicional.Empleado;
import gestorAplicación.servicioAdicional.Empleado.Rol;

public class Main {
	
	//ARRAYLIST DONDE SE VAN A GUARDAR LAS SEDES
	public static Scanner entrada = new Scanner(System.in);
	public static ArrayList<CentroAdopcion> sedes = new ArrayList<CentroAdopcion>();
	public static Map<String, List<String>>[] horario = new Map[15];
	
	static {
		//CREACION DE SEDES
		CentroAdopcion sede1 = new CentroAdopcion("SEDE 1",25, CentroAdopcion.tipoServicio.GUARDERIA);
		sedes.add(sede1);
		CentroAdopcion sede2 = new CentroAdopcion("SEDE 2",20, CentroAdopcion.tipoServicio.VETERINARIA);
		sedes.add(sede2);
		CentroAdopcion sede3 = new CentroAdopcion("SEDE 3",20, CentroAdopcion.tipoServicio.PELUQUERIA);
		sedes.add(sede3);
		
		
		//AGREGAR ANIMALES A CADA SEDE
		//SEDE1
//		sede1.agregarAnimal(new Animal("Capitán","Canario",2, "Macho", Animal.EstadoSalud.SANO));
//		sede1.agregarAnimal(new Animal("Nala","Canario",3, "Hembra", Animal.EstadoSalud.ENFERMO));
//		sede1.agregarAnimal(new Animal("Rocky","Conejo",2, "Macho", Animal.EstadoSalud.SANO));
//		sede1.agregarAnimal(new Animal("Sky","Conejo",3,"Hembra",Animal.EstadoSalud.SANO));
//		sede1.agregarAnimal(new Animal("Reina","Gato",3, "Hembra", Animal.EstadoSalud.ENTRATAMIENTO));
//		sede1.agregarAnimal(new Animal("Rey","Gato",3, "Macho", Animal.EstadoSalud.ENFERMO));
//		sede1.agregarAnimal(new Animal("Rolly","Hámster",1, "Hembra", Animal.EstadoSalud.SANO));
//		sede1.agregarAnimal(new Animal("Zuma","Hámster",2,"Macho",Animal.EstadoSalud.ENFERMO));
//		sede1.agregarAnimal(new Animal("Tobi","Perro",5, "Macho", Animal.EstadoSalud.SANO));
//		sede1.agregarAnimal(new Animal("Dino","Perro",4, "Macho", Animal.EstadoSalud.ENTRATAMIENTO));
		
		//SEDE2	
		//sede2.agregarAnimal(new Animal("Bolt","Perro",7, "Macho", Animal.EstadoSalud.SANO));
		//sede2.agregarAnimal(new Animal("Frodo","Perro",5, "Macho", Animal.EstadoSalud.SANO));
		sede2.agregarAnimal(new Animal("Golfo","Conejo",3, "Macho", Animal.EstadoSalud.ENFERMO));
		sede2.agregarAnimal(new Animal("Luna","Conejo",3, "Hembra", Animal.EstadoSalud.ENTRATAMIENTO));
		sede2.agregarAnimal(new Animal("Frapee","Canario",2, "Hembra", Animal.EstadoSalud.ENTRATAMIENTO));
		sede2.agregarAnimal(new Animal("Max","Canario",3, "Macho", Animal.EstadoSalud.SANO));
		sede2.agregarAnimal(new Animal("Luna","Gato",6, "Hembra", Animal.EstadoSalud.ENFERMO));
		sede2.agregarAnimal(new Animal("Everest","Gato",4, "Hembra", Animal.EstadoSalud.SANO));
		sede2.agregarAnimal(new Animal("Junior","Hámster",2, "Macho", Animal.EstadoSalud.SANO)); 
		sede2.agregarAnimal(new Animal("Puppy","Hámster",3, "Hembra", Animal.EstadoSalud.ENTRATAMIENTO)); 
		
		
		//SEDE3
		sede3.agregarAnimal(new Animal("Thor","Perro",6, "Macho", Animal.EstadoSalud.SANO));
		sede3.agregarAnimal(new Animal("Teo","Perro",7, "Macho", Animal.EstadoSalud.SANO));
		sede3.agregarAnimal(new Animal("Mia","Gato",4, "Hembra", Animal.EstadoSalud.ENTRATAMIENTO));
		sede3.agregarAnimal(new Animal("Lola","Gato",6, "Hembra", Animal.EstadoSalud.ENFERMO));
		sede3.agregarAnimal(new Animal("Sony","Conejo",3, "Macho", Animal.EstadoSalud.SANO));
		sede3.agregarAnimal(new Animal("River","Conejo",4, "Macho", Animal.EstadoSalud.SANO));
		sede3.agregarAnimal(new Animal("Kira","Canario",3, "Hembra", Animal.EstadoSalud.ENTRATAMIENTO));
		sede3.agregarAnimal(new Animal("Furry","Canario",4, "Macho", Animal.EstadoSalud.ENFERMO));
		sede3.agregarAnimal(new Animal("Princea","Hámster",2, "Hembra", Animal.EstadoSalud.ENTRATAMIENTO));
		
		Cliente cliente1= new Cliente("Oky",18, 1072253440,3106762877L, "Medellín");
		
		cliente1.agregar_puntos(20);
		
		CentroAdopcion.clientes_AdoptaLove.add(cliente1);
		
		//AGREGAR EMPLEADOS A CADA SEDE
		//SEDE 1 (GUARDERÍA)
	/*	sede1.agregarEmpleado(new Empleado("Juan Zapata", 25, 21491118, 313775896, "Carrera 30", Empleado.Rol.CUIDADOR, horario));
		sede1.agregarEmpleado(new Empleado("Julieta Vanegas", 21, 58941118, 310789651, "Calle 96", Empleado.Rol.CUIDADOR, horario));
		sede1.agregarEmpleado(new Empleado("Andres Garcia", 34, 10278056, 300845962, "Calle 80", Empleado.Rol.CUIDADOR, horario));
		sede1.agregarEmpleado(new Empleado("Ana Restrepo", 28, 47889566, 315986487, "Carrera Septima", Empleado.Rol.CUIDADOR, horario));
		sede1.agregarEmpleado(new Empleado("Wilson Jimenez", 36, 70925845, 313153964, "Carrera 72a", Empleado.Rol.CUIDADOR, horario));
		sede1.agregarEmpleado(new Empleado("Mateo Munera", 25, 56892347, 311567832, "Carrera 68", Empleado.Rol.CUIDADOR, horario));
						
		//SEDE 2 (VETERINARIA)
		sede2.agregarEmpleado(new Empleado("Carlos Rivera", 23, 12307004, 328748995, "Carrera 30", Empleado.Rol.VETERINARIO, horario));
		sede2.agregarEmpleado(new Empleado("Marta Puerta", 28, 66973892, 304236021, "Calle 90", Empleado.Rol.VETERINARIO, horario));
		sede2.agregarEmpleado(new Empleado("Karen Diaz", 32, 11277768, 314943886, "Calle 86", Empleado.Rol.VETERINARIO, horario));
		sede2.agregarEmpleado(new Empleado("Mario Martinez", 30, 79698181, 300564603, "Carrera 67b", Empleado.Rol.VETERINARIO, horario));
						
		//SEDE 3 (PELUQUERÍA)
		sede3.agregarEmpleado(new Empleado("Natalia Fernandez", 26, 70233557, 318529646, "Calle 63", Empleado.Rol.PELUQUERO, horario));
		sede3.agregarEmpleado(new Empleado("Jose Bueno", 39, 50270440, 306537090, "Calle 50", Empleado.Rol.PELUQUERO, horario));
		sede3.agregarEmpleado(new Empleado("Diana Henao", 28, 69620661, 330175882, "Carrera Sexta", Empleado.Rol.PELUQUERO, horario));
		sede3.agregarEmpleado(new Empleado("Julian Taborda", 36, 37664642, 332773881, "Carrera 72c", Empleado.Rol.PELUQUERO, horario));
		sede3.agregarEmpleado(new Empleado("Andrea Higuita", 21, 55000283, 332697785, "Carrera 61", Empleado.Rol.PELUQUERO, horario));*/
	}
	
	
	
	public static void main(String[] args) {
		
		//adoptarMascota();	
		//agendarServicio();
		adoptarAnimal();
		
	}
	
	
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
	
	static double nextDouble() {
		return entrada.nextDouble();
	}
	
	static void println(Object obj) {
		System.out.println(obj);
	}
	
	static void print(Object obj) {
		System.out.print(obj);
	}
	

	   
	   //MÉTODOS PARA LA SELECCION DE LA MASCOTA  
	   public static int escogerSede() {
		   int sede=0;
		   int respuesta=0;
		   println("Seleccione en cual sede quiere realizar la adopción.");
		   println("1. SEDE 1");
		   println("2. SEDE 2");
		   println("3. SEDE 3");
		   
		   do {
			   try {
			   print("Ingrese su elección dentro del rango [1-3]: ");
			   respuesta = readInt();
			   sede = respuesta - 1;
			   
			   if (respuesta<1 || respuesta>3) {
				   println("Opción fuera de rango.");
			   }
			   }catch(RuntimeException e) {
				   println("Se ha ingresado un tipo de dato incorrecto.");
			   }finally {
				   readString();
			   }
			  
		   }while(respuesta<1 || respuesta>3);   
		   return sede;
	   }   

		   
	//MÉTODO ESTÁTICO FUNCIONALIDAD ADOPTAR ANIMAL

	
	static void adoptarAnimal() {
		
		println("\n¡Gracias por tu interés en adoptar un animal! 🐾 Estamos emocionados de ayudarte a encontrar a tu nuevo amigo.\n"
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
					println("Proporcione una respuesta válida.");
					edad=0;
				}
		    }catch(RuntimeException e) {
		    	println("Proporcione una respuesta válida.");
		    }finally {
		    	readString();//CONSUMIR SALTO DE LÍNEA.
		    	}
		}
		
		if (edad < 18) { //SI EL INTERESADO ES MENOR DE EDAD, ENTONCES NO PODRÁ REALIZAR LA ADOPCIÓN

			println("Lamentamos informarle que, debido a su condición de menor de edad, no puede realizar la adopción de una mascota. "
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
								println("Proporcione una respuesta válida.");
								cedula=0;
							}
						}
					}
					
					while(telefono<=0) {
						if (telefono<=0) {
							print("Ingrese su número de teléfono: ");
							telefono = readLong();
							if (telefono<=0) {
								println("Proporcione una respuesta válida.");
								telefono=0;
							}
						}
					}
			}catch(RuntimeException e) {
				println("Proporcione una respuesta válida.");
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
				    println("1. SEDE 1\n2. SEDE 2\n3. SEDE 3 ");
				   
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
			
				    	println("");//SALTO DE LÍNEA, SOLO POR ESTÉTICA.	    		    					    	
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
								   println("\nSe ha cancelado la adopción.");
							   }
							   else {
								   mascota_seleccionada = animalesDisponibles.get(num_mascota-1); //MASCOTA SELECCIONADA
							       SEDE.borrarAnimal(mascota_seleccionada); //QUITAR LA MASCOTA DE DISPONIBLES
							       
							       mascotas_adoptadas.add(mascota_seleccionada);//AGREGAR AL ARRAYLIST DE MASCOTA ADOPTADAS
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
								       break;
								       }
							   }			
						}
										    
				    }
				    
				    if ( bucle_sede.equalsIgnoreCase("si")== true && (mascotas_adoptadas.size()>0 && mascotas_adoptadas.size()<3))  {			    	
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
					println("Lamentamos que no haya podido concretar la adopción. Ha sido un placer atenderle, Sr./Sra. " + nombre + ". ¡Esperamos su regreso!");
				}
				else {
					//CREACIÓN DEL OBJETO
					Cliente nuevo_cliente = new Cliente(nombre,edad,cedula,telefono,direccion);	
					
					ArrayList <Adopcion> adopciones_realizadas = SEDE.registrar_adopciones(mascotas_adoptadas, nuevo_cliente); //TERCERA INTERACCIÓN
					
					println("Tiene un total de " + CentroAdopcion.isCliente(nuevo_cliente).getPuntos());
					
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
	
//------------------------------------------------------------INICIO AGENDAR SERVICIO---------------------------------------------------------------------------------------------------------------------------------
	
			public static void agendarServicio() {
				
				for (int i = 0; i < 15; i++) {
				    horario[i] = new HashMap<>();

				    horario[i].put("Lunes", Arrays.asList("8:00 AM", "9:00 AM", "10:00 AM", "11:00 AM", "12:00 M", "2:00 PM", "3:00 PM", "4:00 PM", "5:00 PM", "6:00 PM"));
				    horario[i].put("Martes", Arrays.asList("8:00 AM", "9:00 AM", "10:00 AM", "11:00 AM", "12:00 M", "2:00 PM", "3:00 PM", "4:00 PM", "5:00 PM", "6:00 PM"));
				    horario[i].put("Miércoles", Arrays.asList("8:00 AM", "9:00 AM", "10:00 AM", "11:00 AM", "12:00 M", "2:00 PM", "3:00 PM", "4:00 PM", "5:00 PM", "6:00 PM"));
				    horario[i].put("Jueves", Arrays.asList("8:00 AM", "9:00 AM", "10:00 AM", "11:00 AM", "12:00 M", "2:00 PM", "3:00 PM", "4:00 PM", "5:00 PM", "6:00 PM"));
				    horario[i].put("Viernes", Arrays.asList("8:00 AM", "9:00 AM", "10:00 AM", "11:00 AM", "12:00 M", "2:00 PM", "3:00 PM", "4:00 PM", "5:00 PM", "6:00 PM"));
				    horario[i].put("Sábado", Arrays.asList("8:00 AM", "9:00 AM", "10:00 AM", "11:00 AM", "12:00 M", "2:00 PM", "3:00 PM", "4:00 PM", "5:00 PM", "6:00 PM"));
				    horario[i].put("Domingo", Arrays.asList("8:00 AM", "9:00 AM", "10:00 AM", "11:00 AM", "12:00 M", "2:00 PM", "3:00 PM", "4:00 PM", "5:00 PM", "6:00 PM"));
				}
				
				int opcion = 0;
				int indicador = 0;
				int seleccion = 0;
				int diaSemana = 0;
				int hora = 0;
				boolean seguirAgendando = true;
				
				
				while (seguirAgendando) {
				    try {
				        println("\nRecuerde que cada sede ofrece un servicio diferente y las citas se agendan semanalmente. \n¿Qué servicio desea agendar?");
				        
				        do {
				            println("\n1. Guardería (Sede 1) \n2. Veterinaria (Sede 2) \n3. Peluquería (Sede 3) \n4. Generar factura y salir");
				            print("\nElija una opción dentro del rango [1-5]: ");
				            opcion = readInt();
				            entrada.nextLine();
				            indicador = opcion - 1;

				            if (opcion < 1 || opcion > 5) {
				                println("\nIngrese una opcion valida");
				            }
				        } while (opcion < 1 || opcion > 5);
				       
				        
				    } catch (InputMismatchException e) {
				        println("Error: Ingrese un valor numérico válido.");
				        entrada.nextLine();
				    }

					//----------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------CASO 1------------------------------------------------------------------------------------------------------------------------------------------
					switch(opcion) {
					case 1:
						
					    println("\nVa a agendar en el servicio de guardería. \nValor por hora: $10.000 \nValor día completo: $80.000");
					    println("\nTenga en cuenta que, si ocurre un error por el tipo de dato ingresado durante el agendamiento, será redireccionado al inicio del proceso de agendamiento, perdiendo el avance hecho.");
					    String continuar = "si";
					    do {
				            try {
				                boolean seleccionValida = false;
				                while (!seleccionValida) {
				                    println("\nLos cuidadores disponibles para agendar son: \n");
				                    int i = 1;
				                    for(Empleado cuidador : sedes.get(indicador).getEmpleados()) {
				                        if (cuidador.getProfesion() == Rol.CUIDADOR) {
				                            println(i +". "+ cuidador);
				                            i++;
				                        }
				                    }

				                    print("\nIngrese el número del cuidador que desea seleccionar: ");
				                    seleccion = readInt();
				                    int indiceSede = 0;
				                    for (int e = 0; e < sedes.size(); e++) {
				                        if (sedes.get(e) == sedes.get(indicador)) {
				                            indiceSede = e;
				                            break;
				                        }
				                    }

				                    if (seleccion >= 1 && seleccion <= 6 && seleccion <= sedes.get(indiceSede).getEmpleados().size()) {
				                        Empleado cuidadorSeleccionado = sedes.get(indiceSede).getEmpleados().get(seleccion - 1);
				                        println("\nCuidador seleccionado: " + cuidadorSeleccionado + "\n");
				                        String[] diasSemana = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};

				                        for (int a = 0; a < diasSemana.length; a++) {
				                            println((a + 1) + ". " + diasSemana[a]);
				                        }

				                        boolean seleccionValidaDia = false;
				                        while (!seleccionValidaDia) {
				                            print("\nEscriba la opción que contenga el día de la semana en el que quiere agendar: ");
				                            diaSemana = readInt();
				                            if (diaSemana >= 1 && diaSemana <= 7) {
				                                seleccionValidaDia = true;
				                                println("\nHorario disponible para el " + diasSemana[diaSemana - 1] +" de " + cuidadorSeleccionado.getNombre()  + ":" + "\n");
				                                List<String> horasDisponibles = horario[seleccion - 1].get(diasSemana[diaSemana - 1]);
				                                for (int o = 0; o < horasDisponibles.size(); o++) {
				                                    println((o + 1) + ". " + horasDisponibles.get(o));
				                                }

				                                boolean seleccionValidaHora = false;
				                                while (!seleccionValidaHora) {
				                                    println("\nPara agendar en guardería, siga estas instrucciones: \n*Si va a agendar una sola hora, escriba solo el número que acompaña la hora a agendar. "
				                                            + "\n*Si va a agendar dos o más horas, escriba los números que acompañan las horas que necesita, separándolos con una coma. Ej: 1,2,3 "
				                                            + "\n*Si va a agendar el día completo, escriba 'todo'. Tenga en cuenta que deben estar disponibles todas las horas del día. \n");

				                                    print("\nIngrese el/los número/s según su intención al agendar: ");
				                                    entrada.nextLine();
				                                    String horas = readString();

				                                    if (!horas.matches("(10|[1-9])(,(10|[1-9]))*|todo")) {
				                                        throw new IllegalArgumentException("Respuesta inválida. Por favor, siga las instrucciones indicadas.");
				                                    }

				                                    boolean noHayDisponibilidad = true;
				                                    for (int u = 0; u < horasDisponibles.size(); u++) {
				                                        if (!horasDisponibles.get(u).equals("Ocupada")) {
				                                            noHayDisponibilidad = false;
				                                            break;
				                                        }
				                                    }

				                                    if (noHayDisponibilidad) {
				                                        println("\nLo sentimos, no hay disponibilidad este día.");
				                                        break;
				                                    }

				                                    if (horas.equalsIgnoreCase("todo")) {
				                                        boolean todasDisponibles = true;
				                                        for (String horaDisponible : horasDisponibles) {
				                                            if (horaDisponible.equals("Ocupada")) {
				                                                todasDisponibles = false;
				                                            }
				                                        }

				                                        if (todasDisponibles) {
				                                            seleccionValidaHora = true;
				                                            seleccionValida = true;
				                                            for (int b = 0; b < horasDisponibles.size(); b++) {
				                                                horasDisponibles.set(b, "Ocupada");
				                                            }

				                                            println("\n¡Día completo agendado exitosamente!");

				                                        } else {
				                                            println("\nLo sentimos, no todas las horas del día están disponibles.");
				                                            break;
				                                        }

				                                    } else {
				                                        String[] selecciones = horas.split(",");
				                                        List<Integer> horasSeleccionadas = new ArrayList<>();
				                                        for (String seleccionado : selecciones) {
				                                            if (!seleccionado.trim().isEmpty()) {
				                                                horasSeleccionadas.add(Integer.parseInt(seleccionado.trim()) - 1);
				                                            }
				                                        }

				                                        println("\nHoras seleccionadas:");
				                                        for (int horaIndex : horasSeleccionadas) {
				                                            if (horaIndex >= 0 && horaIndex < horasDisponibles.size()) {
				                                                if (horasDisponibles.get(horaIndex).equals("Ocupada")) {
				                                                    println(horasDisponibles.get(horaIndex) + " - Lo sentimos, no hay disponibilidad en esta hora.");
				                                                    break;
				                                                } else {
				                                                    println(horasDisponibles.get(horaIndex) + " - ¡Cita agendada exitosamente!");
				                                                    horasDisponibles.set(horaIndex, "Ocupada");
				                                                    seleccionValidaHora = true;
				                                                    seleccionValida = true;
				                                                }
				                                            } else {
				                                                println("\nSelección inválida. Por favor, selecciona un número válido.");
				                                            }
				                                        }
				                                    }
				                                }
				                            } else {
				                                println("\nSelección inválida. Por favor, selecciona un número válido.");
				                            }
				                        }

				                        while (continuar != "si" || continuar != "no") {
					                        print("\n¿Desea volver a agendar en guardería? Responda (si/no): ");
					                        continuar = entrada.nextLine();
					                        if (continuar.equalsIgnoreCase("si")) {
					                            break;
					                        } if (continuar.equalsIgnoreCase("no")) {
					                            print("\nSerá redirigido al menú de servicios.\n");
					                            break;
					                        }else {
					                        	println("\nSelección inválida. Por favor, selecciona un número válido.");
					                        }
				                        }
				                        
				                    } else {
				                        println("\nRespuesta inválida. Por favor, escribe si o no.");
				                    }
				                }
				            } catch (InputMismatchException e) {
				                println("Error: Ingrese un valor numérico válido.");
				                entrada.nextLine(); 
				            } catch (IllegalArgumentException e) {
				                println("Error: " + e.getMessage());
				            }
				        } while (continuar.equalsIgnoreCase("si"));
					    
					    break;

					
//-------------------------------------------------CASO 2-----------------------------------------------------------------------------------------------------------------------------------------------------------
						case 2:
						
							println("\nVa a agendar en el servicio de veterinaria. \nValor de la cita: $------");
							String continuar2 = "si";
							do {
							    boolean seleccionValida = false;
							    while (!seleccionValida) {
							        println("\nSeleccione el numero del veterinario para ver su disponibilidad y agendar. \n");
							        int i = 7;
							        for (Empleado veterinario : sedes.get(indicador).getEmpleados()) {
							            if (veterinario.getProfesion() == Rol.VETERINARIO) {
							                println(i + ". " + veterinario);
							                i++;
							            }
							        }

							        print("\nIngrese el número del veterinario que desea seleccionar: ");
							        try {
							            seleccion = readInt();
							            int indiceSede = 0;
							            for (int e = 0; e < sedes.size(); e++) {
							                if (sedes.get(e) == sedes.get(indicador)) {
							                    indiceSede = e;
							                    break;
							                }
							            }

							            if (seleccion >= 7 && seleccion <= 10 && seleccion >= sedes.get(indiceSede).getEmpleados().size()) {
							                Empleado veterinarioSeleccionado = sedes.get(indiceSede).getEmpleados().get(seleccion - 7);
							                println("\nVeterinario seleccionado: " + veterinarioSeleccionado + "\n");
							                String[] diasSemana = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};

							                for (int a = 0; a < diasSemana.length; a++) {
							                    println((a + 1) + ". " + diasSemana[a]);
							                }

							                boolean seleccionValidaDia = false;
							                while (!seleccionValidaDia) {
							                    print("\nEscriba la opción que contenga el día de la semana en el que quiere agendar: ");
							                    try {
							                        diaSemana = readInt();
							                        entrada.nextLine();
							                        if (diaSemana >= 1 && diaSemana <= 7) {
							                            seleccionValidaDia = true;
							                            println("\nHorario disponible para el " + diasSemana[diaSemana - 1] + " de " + veterinarioSeleccionado.getNombre() + ":\n");
							                            List<String> horasDisponibles = horario[seleccion - 1].get(diasSemana[diaSemana - 1]);
							                            for (int o = 0; o < horasDisponibles.size(); o++) {
											    			   println((o + 1) + ". " + horasDisponibles.get(o));  
											    		}

							                            boolean noHayDisponibilidad = true;
							                            for (int u = 0; u < horasDisponibles.size(); u++) {
							                                if (!horasDisponibles.get(u).equals("Ocupada")) {
							                                    noHayDisponibilidad = false;
							                                    break;
							                                }
							                            }

							                            if (noHayDisponibilidad) {
							                                println("\nLo sentimos, no hay disponibilidad este día.");
							                            }

							                            boolean seleccionValidaHora = false;
							                            while (!seleccionValidaHora) {
							                                print("\nIngrese el número que acompaña la hora de su elección: ");
							                                try {
							                                    hora = readInt();
							                                    entrada.nextLine(); 
							                                    if (hora >= 1 && hora <= 10) {
							                                        seleccionValidaHora = true;
							                                        println("\nHoras seleccionadas:");
							                                        if (horasDisponibles.get(hora - 1).equals("Ocupada")) {
							                                            println(horasDisponibles.get(hora - 1) + " - Lo sentimos, no hay disponibilidad en esta hora.");
							                                        } else {
							                                            println(horasDisponibles.get(hora - 1) + " - ¡Cita agendada exitosamente!");
							                                            horasDisponibles.set(hora - 1, "Ocupada");
							                                            seleccionValida = true;
							                                        }
							                                    } else {
							                                        println("\nSelección inválida. Por favor, selecciona un número válido.");
							                                    }
							                                } catch (InputMismatchException e) {
							                                    println("\nError: Ingrese un valor numérico válido para la hora.");
							                                    entrada.nextLine(); 
							                                }
							                            }

							                        } else {
							                            println("\nSelección inválida. Por favor, selecciona un número válido.");
							                        }
							                    } catch (InputMismatchException e) {
							                        println("\nError: Ingrese un valor numérico válido para el día.");
							                        entrada.nextLine();
							                    }
							                }

							                while (continuar2 != "si" || continuar2 != "no") {
						                        print("\n¿Desea volver a agendar en guardería? Responda (si/no): ");
						                        continuar2 = entrada.nextLine();
						                        if (continuar2.equalsIgnoreCase("si")) {
						                            break;
						                        } if (continuar2.equalsIgnoreCase("no")) {
						                            print("\nSerá redirigido al menú de servicios.\n");
						                            break;
						                        }else {
						                        	println("\nSelección inválida. Por favor, escribe si o no.");
						                        }
					                        }

							            } else {
							                println("\nSelección inválida. Por favor, selecciona un número válido.");
							            }
							        } catch (InputMismatchException e) {
							            println("\nError: Ingrese un valor numérico válido para la selección del veterinario.");
							            entrada.nextLine();
							        }
							    }

							} while (continuar2.equalsIgnoreCase("si"));

							break;

					
//----------------------------------------------------CASO 3---------------------------------------------------------------------------------------------------------------------------------------------------
						case 3:
							
							println("\nVa a agendar en el servicio de peluquería. \nValor de la cita: $------");
							String continuar3 = "si";
							do {
							    boolean seleccionValida = false;
							    while (!seleccionValida) {
							        println("\nSeleccione el numero del peluquero para ver su disponibilidad y agendar. \n");
							        int i = 11;
							        for (Empleado peluquero : sedes.get(indicador).getEmpleados()) {
							            if (peluquero.getProfesion() == Rol.PELUQUERO) {
							                println(i + ". " + peluquero);
							                i++;
							            }
							        }

							        print("\nIngrese el número del peluquero que desea seleccionar: ");
							        try {
							            seleccion = readInt();
							            int indiceSede = 0;
							            for (int e = 0; e < sedes.size(); e++) {
							                if (sedes.get(e) == sedes.get(indicador)) {
							                    indiceSede = e;
							                    break;
							                }
							            }

							            if (seleccion >= 11 && seleccion <= 15 && seleccion >= sedes.get(indiceSede).getEmpleados().size()) {
							                Empleado peluqueroSeleccionado = sedes.get(indiceSede).getEmpleados().get(seleccion - 11);
							                println("\nPeluquero seleccionado: " + peluqueroSeleccionado + "\n");
							                String[] diasSemana = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};

							                for (int a = 0; a < diasSemana.length; a++) {
							                    println((a + 1) + ". " + diasSemana[a]);
							                }

							                boolean seleccionValidaDia = false;
							                while (!seleccionValidaDia) {
							                    print("\nEscriba la opción que contenga el día de la semana en el que quiere agendar: ");
							                    try {
							                        diaSemana = readInt();
							                        entrada.nextLine();
							                        if (diaSemana >= 1 && diaSemana <= 7) {
							                            seleccionValidaDia = true;
							                            println("\nHorario disponible para el " + diasSemana[diaSemana - 1] + " de " + peluqueroSeleccionado.getNombre() + ":\n");
							                            List<String> horasDisponibles = horario[seleccion - 1].get(diasSemana[diaSemana - 1]);
							                            for (int o = 0; o < horasDisponibles.size(); o++) {
											    			   println((o + 1) + ". " + horasDisponibles.get(o));  
											    		}

							                            boolean noHayDisponibilidad = true;
							                            for (int u = 0; u < horasDisponibles.size(); u++) {
							                                if (!horasDisponibles.get(u).equals("Ocupada")) {
							                                    noHayDisponibilidad = false;
							                                    break;
							                                }
							                            }

							                            if (noHayDisponibilidad) {
							                                println("\nLo sentimos, no hay disponibilidad este día.");
							                            }

							                            boolean seleccionValidaHora = false;
							                            while (!seleccionValidaHora) {
							                                print("\nIngrese el número que acompaña la hora de su elección: ");
							                                try {
							                                    hora = readInt();
							                                    entrada.nextLine();
							                                    if (hora >= 1 && hora <= 10) {
							                                        seleccionValidaHora = true;
							                                        println("\nHoras seleccionadas:");
							                                        if (horasDisponibles.get(hora - 1).equals("Ocupada")) {
							                                            println(horasDisponibles.get(hora - 1) + " - Lo sentimos, no hay disponibilidad en esta hora.");
							                                        } else {
							                                            println(horasDisponibles.get(hora - 1) + " - ¡Cita agendada exitosamente!");
							                                            horasDisponibles.set(hora - 1, "Ocupada");
							                                            seleccionValida = true;
							                                        }
							                                    } else {
							                                        println("\nSelección inválida. Por favor, selecciona un número válido.");
							                                    }
							                                } catch (InputMismatchException e) {
							                                    println("\nError: Ingrese un valor numérico válido para la hora.");
							                                    entrada.nextLine();
							                                }
							                            }

							                        } else {
							                            println("\nSelección inválida. Por favor, selecciona un número válido.");
							                        }
							                    } catch (InputMismatchException e) {
							                        println("\nError: Ingrese un valor numérico válido para el día.");
							                        entrada.nextLine();
							                    }
							                }

							                while (continuar3 != "si" || continuar3 != "no") {
						                        print("\n¿Desea volver a agendar en guardería? Responda (si/no): ");
						                        continuar3 = entrada.nextLine();
						                        if (continuar3.equalsIgnoreCase("si")) {
						                            break;
						                        } if (continuar3.equalsIgnoreCase("no")) {
						                            print("\nSerá redirigido al menú de servicios.\n");
						                            break;
						                        }else {
						                        	println("\nSelección inválida. Por favor, escribe si o no.");
						                        }
					                        }

							            } else {
							                println("\nSelección inválida. Por favor, selecciona un número válido.");
							            }
							        } catch (InputMismatchException e) {
							            println("\nError: Ingrese un valor numérico válido para la selección del peluquero.");
							            entrada.nextLine();
							        }
							    }

							} while (continuar3.equalsIgnoreCase("si"));

							break;


//----------------------------------------------------CASO 4-----------------------------------------------------------------------------------------------------------------------------------------------
						case 4:
							print("\nFIN DE LA FUNCIONALIDAD. luego agrego esto ;)\n");
							seguirAgendando = false;
							
							break;
							
							
//-----------------------------------------DEFAULT (Si opción no valida para el switch)--------------------------------------------------------------------------------------------------------------------         
				        default:
				            println("\nOpción inválida.");
				            break;
					}
				}
			}
			
			
//----------------------------------------------FIN AGENDAR SERVICIO-----------------------------------------------------------------------------------------------------------------------------------------		
}

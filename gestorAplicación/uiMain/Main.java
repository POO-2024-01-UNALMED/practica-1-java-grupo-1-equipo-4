package gestorAplicación.uiMain;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import gestorAplicación.procesoAdopcion.Adopcion;
import gestorAplicación.procesoAdopcion.Animal;
import gestorAplicación.procesoAdopcion.CentroAdopcion;
import gestorAplicación.procesoAdopcion.Cliente;
import gestorAplicación.servicioAdicional.Cita;
import gestorAplicación.servicioAdicional.Cupo;
import gestorAplicación.servicioAdicional.Empleado;

public class Main {
	
	//ARRAYLIST DONDE SE VAN A GUARDAR LAS SEDES
	public static Scanner entrada = new Scanner(System.in);
	public static ArrayList<CentroAdopcion> sedes = new ArrayList<CentroAdopcion>();
	
	static {
		//CREACION DE SEDES
		CentroAdopcion sede1 = new CentroAdopcion("SEDE 1",25, CentroAdopcion.tipoServicio.GUARDERIA);
		sedes.add(sede1);
		CentroAdopcion sede2 = new CentroAdopcion("SEDE 2",20, CentroAdopcion.tipoServicio.VETERINARIA);
		sedes.add(sede2);
		CentroAdopcion sede3 = new CentroAdopcion("SEDE 3",20, CentroAdopcion.tipoServicio.PELUQUERIA);
		sedes.add(sede3);
		
		
		//AGREGAR ANIMALES A CADA SEDE -------------------------
		//SEDE1
		sede1.agregarAnimal(new Animal("Capitán","Canario",2, "Macho", Animal.EstadoSalud.SANO));
		sede1.agregarAnimal(new Animal("Nala","Canario",3, "Hembra", Animal.EstadoSalud.ENFERMO));
		sede1.agregarAnimal(new Animal("Rocky","Conejo",2, "Macho", Animal.EstadoSalud.SANO));
		sede1.agregarAnimal(new Animal("Sky","Conejo",3,"Hembra",Animal.EstadoSalud.SANO));
		sede1.agregarAnimal(new Animal("Reina","Gato",3, "Hembra", Animal.EstadoSalud.ENTRATAMIENTO));
		sede1.agregarAnimal(new Animal("Rey","Gato",3, "Macho", Animal.EstadoSalud.ENFERMO));
		sede1.agregarAnimal(new Animal("Rolly","Hámster",1, "Hembra", Animal.EstadoSalud.SANO));
		sede1.agregarAnimal(new Animal("Zuma","Hámster",2,"Macho",Animal.EstadoSalud.ENFERMO));
    	sede1.agregarAnimal(new Animal("Tobi","Perro",5, "Macho", Animal.EstadoSalud.SANO));
		sede1.agregarAnimal(new Animal("Dino","Perro",4, "Macho", Animal.EstadoSalud.ENTRATAMIENTO));
		
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
			
		
		//AGREGAR EMPLEADOS A CADA SEDE ----------------------------
		//SEDE 1 (GUARDERÍA)
		sede1.agregarEmpleado(new Empleado("Juan Zapata", 25, 21491118, 313775896, "Carrera 30", Empleado.Rol.CUIDADOR));
		sede1.agregarEmpleado(new Empleado("Julieta Vanegas", 21, 58941118, 310789651, "Calle 96", Empleado.Rol.CUIDADOR));
		sede1.agregarEmpleado(new Empleado("Andres Garcia", 34, 10278056, 300845962, "Calle 80", Empleado.Rol.CUIDADOR));
		sede1.agregarEmpleado(new Empleado("Ana Restrepo", 28, 47889566, 315986487, "Carrera Septima", Empleado.Rol.CUIDADOR));
		sede1.agregarEmpleado(new Empleado("Wilson Jimenez", 36, 70925845, 313153964, "Carrera 72a", Empleado.Rol.CUIDADOR));
		sede1.agregarEmpleado(new Empleado("Mateo Munera", 25, 56892347, 311567832, "Carrera 68", Empleado.Rol.CUIDADOR));
						
		//SEDE 2 (VETERINARIA)
		sede2.agregarEmpleado(new Empleado("Carlos Rivera", 23, 12307004, 328748995, "Carrera 30", Empleado.Rol.VETERINARIO));
		sede2.agregarEmpleado(new Empleado("Marta Puerta", 28, 66973892, 304236021, "Calle 90", Empleado.Rol.VETERINARIO));
		sede2.agregarEmpleado(new Empleado("Karen Diaz", 32, 11277768, 314943886, "Calle 86", Empleado.Rol.VETERINARIO));
		sede2.agregarEmpleado(new Empleado("Mario Martinez", 30, 79698181, 300564603, "Carrera 67b", Empleado.Rol.VETERINARIO));
						
		//SEDE 3 (PELUQUERÍA)
		sede3.agregarEmpleado(new Empleado("Natalia Fernandez", 26, 70233557, 318529646, "Calle 63", Empleado.Rol.PELUQUERO));
		sede3.agregarEmpleado(new Empleado("Jose Bueno", 39, 50270440, 306537090, "Calle 50", Empleado.Rol.PELUQUERO));
		sede3.agregarEmpleado(new Empleado("Diana Henao", 28, 69620661, 330175882, "Carrera Sexta", Empleado.Rol.PELUQUERO));
		sede3.agregarEmpleado(new Empleado("Julian Taborda", 36, 37664642, 332773881, "Carrera 72c", Empleado.Rol.PELUQUERO));
		sede3.agregarEmpleado(new Empleado("Andrea Higuita", 21, 55000283, 332697785, "Carrera 61", Empleado.Rol.PELUQUERO));
		
		
		Cliente cliente1= new Cliente("Oky",18, 1072253440,3106762877L, "Medellín");
		
		cliente1.agregar_puntos(20);
		
		CentroAdopcion.clientes_AdoptaLove.add(cliente1);
	}
		
	public static void main(String[] args) {
		  agendar_servicio();
		 //adoptarAnimal();
		
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
	
	
	
	static void agendar_servicio(){
		
		ArrayList<Cita> citas_agendadas= new ArrayList<>();
		
		println("mensaje de bienvenida");
		println("\nLe recordamos que cada sede de AdoptaLove ofrece un servicio diferente para las mascotas, seleccione según sea su necesidad. \n¿Qué servicio desea agendar?");
		
		//SELECCIÓN DE SEDE Y SERVICIO
		boolean repetir = false;
		do {
		int servicio=0;
        println("\n1. SEDE 1 - Servicio: Guarderia \n2. SEDE 2 - Servicio: Veterinaria \n3. SEDE 3 - Servicio: Peluquería\n");
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
	    		println("¿Desea realizar otra adopción?");
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
        			println("\nContamos con los siguientes cuidadores de mascotas, seleccione el de su preferencia:\n");
        	    	break;
        	    	
        		case 2:
        			println("\nContamos con los siguientes veterinarios, seleccione el de su preferencia:\n");
        	    	break;
        	    	
        		case 3:
        			println("\nContamos con los siguientes peluqueros de mascotas, seleccione el de su preferencia:\n");
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
            		print("Ingrese su elección dentro del rango [1-" + empleados_disponibles.size() + "]: " );
            		try {
            			num_empleado= readInt();
            			
            			if (num_empleado<1 || num_empleado > empleados_disponibles.size()) {
            				println("Proporcione una respuesta válida.\n");
            			}
            			
            		}catch(InputMismatchException e) {
            			println("Proporcione una respuesta válida.\n");
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
        	    
        	    println("Numero del dia: " + num_dia);//QUITAR
        	    
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
        	    			print("Ingrese su elección en el rango en el rango [1 -" + (cupos_disponibles.size()+1) +"]:");
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
        	    		
        	    		println("Se ha cancelado la cita");
        	    		
        	    	}
        	    	else {	
        	    		//DE LO CONTRARIO, SI SELECCIONA UNI, ENTONCES SE PROCEDE A REOCGER LOS DATOS DEL CLIENTE 
        	    		//Y LA MASCOTA.
        	    		Cupo cupo_seleccionado = cupos_disponibles.get(num_cupo-1);
        	    	    println(cupo_seleccionado);
        	    	    
        	    	    Cliente cliente = datos_cliente(); //DATOS DEL CLIENTE
        	    	    
        	    	    cliente = CentroAdopcion.isCliente(cliente); //COMPROBAR SI EL CLIENTE YA ESTÁ REGISTRADO
        	    	    
        	    	    Animal mascota = datos_mascota(servicio); //DATOS DE LA MASCOTA.
        	    	    
        	    	    Cita nueva_cita = new Cita(cliente,mascota,empleado_seleccionado,cupo_seleccionado,servicio);
        	    	    
        	    	    citas_agendadas.add(nueva_cita);
        	    	    
        	    	    
        	    	    println("¡Cita agendada exitosamente!");
        	    	    
        	    	    
        	    	    println("\n¿Desea agendar cita otra cita");
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
        		    	}
        		    	else {
        		    		repetir=false;
        		    	}
        	    	    	    
        	    	}
        	    	    	    	
        	    }
        	             
        	}
   	
		}
	}while(repetir);
	}
	
	
	public static Cliente datos_cliente() {
		
		println("\nAntes de continuar, le informamos que para hacer uso del servicio la persona encargada de la mascota debe ser mayor de edad.\n");
		
		String nombre;
		int edad=0;
		long cedula=0;
		
		println("Proporcione la siguiente información: ");
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
		readString();//CONSUMIR SALTO DE LÍNEA
		
		String nombre = null;
		int edad = 0;
		String especie = null;
		String sexo = null;
		
		println("\nProporcione la siguiente información sobre su mascota:");
		
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
}
	

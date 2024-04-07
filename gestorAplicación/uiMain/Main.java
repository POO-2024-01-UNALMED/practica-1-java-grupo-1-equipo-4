package gestorAplicación.uiMain;

import java.util.ArrayList;
import java.util.Scanner;

import gestorAplicación.procesoAdopcion.Adopcion;
import gestorAplicación.procesoAdopcion.Animal;
import gestorAplicación.procesoAdopcion.CentroAdopcion;
import gestorAplicación.procesoAdopcion.Cliente;

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
		
		
		//AGREGAR ANIMALES A CADA SEDE:
		
		//SEDE1
		sede1.agregarAnimal(new Animal("Tobi","Perro",2, "Macho", Animal.EstadoSalud.SANO));
		sede1.agregarAnimal(new Animal("Reina","Gato",3, "Hembra", Animal.EstadoSalud.ENTRATAMIENTO));
		sede1.agregarAnimal(new Animal("Rocky","Conejo",1, "Macho", Animal.EstadoSalud.SANO));
		sede1.agregarAnimal(new Animal("Nala","Loro",2, "Hembra", Animal.EstadoSalud.ENTRATAMIENTO));
		sede1.agregarAnimal(new Animal("Dino","Perro",1, "Macho", Animal.EstadoSalud.SANO));
		sede1.agregarAnimal(new Animal("Reina","Gato",3,"Hembra",Animal.EstadoSalud.ENTRATAMIENTO));
		
		//SEDE2	
		sede2.agregarAnimal(new Animal("Golfo","Conejo",2, "Macho", Animal.EstadoSalud.SANO));
		sede2.agregarAnimal(new Animal("Frapee","Loro",2, "Hembra", Animal.EstadoSalud.ENTRATAMIENTO));
		sede2.agregarAnimal(new Animal("Bolt","Perro",2, "Macho", Animal.EstadoSalud.SANO));
		sede2.agregarAnimal(new Animal("Frodo","Perro",2, "Macho", Animal.EstadoSalud.SANO));
		sede2.agregarAnimal(new Animal("Luna","Gato",2, "Hembra", Animal.EstadoSalud.ENTRATAMIENTO));
		
		//SEDE3
		sede3.agregarAnimal(new Animal("Thor","Perro",2, "Macho", Animal.EstadoSalud.SANO));
		sede3.agregarAnimal(new Animal("Teo","Perro",2, "Macho", Animal.EstadoSalud.SANO));
		sede3.agregarAnimal(new Animal("Mia","Gato",2, "Hembra", Animal.EstadoSalud.ENTRATAMIENTO));
		sede3.agregarAnimal(new Animal("Sony","Conejo",2, "Macho", Animal.EstadoSalud.SANO));
		sede3.agregarAnimal(new Animal("Kira","Loro",2, "Hembra", Animal.EstadoSalud.ENTRATAMIENTO));
	}
	
	
	public static void main(String[] args) {
		
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
		return entrada.next();
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
	
	
	//MÉTODOS PARA EL FUNCIONAMIENTO DE LA ENCUESTA
	
	public static boolean validacionEncuestas() {
		Scanner respuestas = new Scanner(System.in);

        int puntaje = hacerEncuesta(respuestas);

        if (Adopcion.encuesta(puntaje)) {

        	return true;
        	
        } else {
            return false;
        }
		
	}
	
	public static int hacerEncuesta(Scanner scanner) {
		    println("\nLa siguiente encuesta es un requisito para verificar que cumple con los requisistos para ser un adoptante en AdoptaLove.");
	        println("Responda a las preguntas con una calificación en el rango [1-5], donde 1 significa muy poco y 5 significa mucho.");
	        int puntaje = 0;

	        puntaje += validacionRespuesta(scanner, "1. ¿Tiene experiencia en el cuidado de mascotas?: ");
	        puntaje += validacionRespuesta(scanner, "2. ¿Cuánto tiempo puede dedicar diariamente a la atención y el cuidado de la mascota?: ");
	        puntaje += validacionRespuesta(scanner, "3. ¿Con qué frecuencia planea viajar en los próximos meses?: ");
	        puntaje += validacionRespuesta(scanner, "4. ¿Tiene un espacio adecuado en su hogar para la mascota, tanto en interiores como en exteriores?: ");
	        puntaje += validacionRespuesta(scanner, "5. ¿Qué tan cómodo/a se siente al tener una mascota en su hogar?: ");
	        puntaje += validacionRespuesta(scanner, "6. ¿Ha considerado los requisitos específicos de la raza/tipo de mascota en términos de ejercicio, socialización y cuidados?: ");
	        puntaje += validacionRespuesta(scanner, "7. ¿Está dispuesto a someter a la mascota a chequeos veterinarios regulares?: ");
	        puntaje += validacionRespuesta(scanner, "8. ¿Está dispuesto a recibir visitas por parte de AdoptaLove para enterarnos del estado de la mascota?: ");
	        

	        return puntaje;
	    }
	    
	   public static int validacionRespuesta(Scanner scanner, String pregunta) {
	        int respuesta;
	        do {
	            System.out.print(pregunta);
	            while (!scanner.hasNextInt()) {
	                System.out.print("Por favor, ingrese un número en el rango [1-5]: ");
	                scanner.next();
	            }
	            respuesta = scanner.nextInt();
	            if (respuesta < 1 || respuesta > 5) {
	                System.out.println("Por favor, ingrese un númeoro en el rango [1-5]:  ");
	            }
	        } while (respuesta < 1 || respuesta > 5);
	        
	        return respuesta;
	    }
	   
	   
	   //MÉTODOS PARA LA SELECCION DEL ANIMAL
	   
	   public static int escogerSede() {
		   int sede;
		   int respuesta;
		   println("Seleccione en cual sede quiere realizar la adopción.");
		   println("1. SEDE 1");
		   println("2. SEDE 2");
		   println("3. SEDE 3");
		   
		   do {
			   print("Ingrese su elección en el rango [1-3]: ");
			   respuesta = readInt();
			   sede = respuesta - 1;
			   
			   if (respuesta<1 || respuesta>3) {
				   println("\nEl numero ingresado está fuera del rango.");
			   }
			  
		   }while(respuesta<1 || respuesta>3);
		   
		   
		   return sede;
	   }
	   
	   public static Animal escogerMascota(int sede) {
		   
		   println("\n¿Desea ver todos las mascotas disponibles o filtrar por un tipo en especifico?");
		   
		     int opcion;
		     Animal mascota = null;
		     
		     
		     //BUCLE QUE CONTROLA QUE SE PULSE UNA DE LAS OPCIONES CORREcTAS
		   do {   
			   println("1. Ver todos las mascotas disponibles.\n2. Filtrar por tipo.");
			   print("Elija una opción dentro del rango [1-2]: ");
			   opcion = readInt();
			   
			   if (opcion!=1 && opcion!=2) {
				   println("\nOpción incorrecta.");
			   }
		   }while(opcion!=1 && opcion!=2);
		   
		   //OPCIONES DE VISUALIZACIÓN
		   switch(opcion) {
		   
		   //VISUALIZAR TODOS LOS ANIMALES DE LA SEDE QUE SE ESCOGIÓ
		   case 1:
		
			   if (Main.sedes.get(sede).consultarAnimales().size()==0) {
				   println("Lo siento, no hay mascotas disponibles para adopción.");
			   }
			   
			   
			   else {
				   int mascotaseleccionada;
				   int i=1;
				   println("\nLas mascotas disponibles para adopción son:\n");
			   for(Animal seleccion : sedes.get(sede).consultarAnimales()) {
				   println("Macota " + i +": "+ seleccion);
				   i++;
			   }
			   do {
				   print("\nIngrese el número de la mascota que quiere adoptar: ");
				    mascotaseleccionada = readInt();
				  
				  if (mascotaseleccionada<0 || mascotaseleccionada> sedes.get(sede).consultarAnimales().size()) {
					  println("El número seleccionado está fuera del rango.");
				  }
			   }while(mascotaseleccionada<=0 || mascotaseleccionada> sedes.get(sede).consultarAnimales().size());
			   
			   mascota = Main.sedes.get(sede).consultarAnimales().get(mascotaseleccionada - 1);
				  Main.sedes.get(sede).borrarAnimal(mascota);
				  
			   }
				   break;
				   
			//VISUALIZAR   
		   case 2:
			   
			   ArrayList<Animal> filtroTipo = new ArrayList<>();
			   print("\nIngrese el tipo de animal por el que quiere filtrar: ");
			   String filtro = readString();
			   int j = 1;
			    
			   for(Animal iterador: Main.sedes.get(sede).consultarAnimales()) {
				   
				   if (iterador.getTipo().equalsIgnoreCase(filtro)) {
					   filtroTipo.add(iterador);  
				   }
			   }
			   
			   if (filtroTipo.size()==0) {
				   println("\nLo sentimos,en este momento no hay mascotas disponibles de ese tipo para adoptar.");
			   }
			   
			   else {
				   int mascotaseleccionada;
				   println("\nLas mascotas que se encuentran disponibles son:\n");
				   
				   for (Animal seleccion: filtroTipo) {
					   println("Mascota " + j + ": " + seleccion);
					   j++;
				   }
				   do {
               print("\nIngrese el número de la mascota que quiere adoptar: ");
				   
				    mascotaseleccionada = readInt();
				  if(mascotaseleccionada<0 || mascotaseleccionada > filtroTipo.size()) {
					  println("\"El número seleccionado está fuera del rango.");
				  }
				   }while (mascotaseleccionada<0 || mascotaseleccionada > filtroTipo.size());		
				   
				   mascota = filtroTipo.get(mascotaseleccionada - 1);
					  sedes.get(sede).borrarAnimal(mascota);
			   }	   
		   }	   
		   return mascota;	   
	   }
	
		
	//MÉTODO ESTÁTICO FUNCIONALIDAD ADOPTAR ANIMAL

	
	public static void adoptarAnimal() {
		
		//INGRESAR LOS DATOS DEL CLIENTE
		println("Proporcione los siguientes datos del interesado en adoptar: ");
		print("Ingrese su nombre: ");
		String nombre = readString();
		
		print("Ingrese su edad: ");
		int edad = readInt();
		
		if (edad<18) {
			println("\nEl interasado en adoptar es menor de edad.");
			do {
			println("Proporcione los datos de un adulto responsable: ");
			print("Ingrese su nombre: ");	
			nombre = readString();
			
			print("Ingrese su edad: ");
			edad= readInt();
			
			if(edad<18) {
				println("\nLa edad ingresada no corresponde a la de un adulto.");
			
			}} while(edad<18);
			
			}
		
		print("Ingrese su número de identificación: ");
		long cedula = readLong();
		print("Ingrese su número de teléfono:  ");
		long  telefono = readLong();
		print("Ingrese su dirección: ");
		String direccion = readString();
		
		if (Main.validacionEncuestas()) {
			println("\nSeñor/a " + nombre + " cumple con los requisitos para ser un adoptante en AdoptaLove, podemos continuar con el proceso." );
			
			ArrayList <Animal> adoptados = new ArrayList<>();
			
			String continuar = null;
			int sede;
			
			do {
			sede = escogerSede();
			Animal mascota = escogerMascota(sede);
			
			if (mascota == null) {
				println("\n¿Desea intentar una nueva adopción?: ");
				print("Responda si/no: ");
				
				continuar = readString();
			}
			else {
				adoptados.add(mascota);
				print("\n¡Felicitaciones señor/a "+ nombre + " ahora tendrá la compañia de " + mascota.getNombre()+ "!\n");		
				println("\n¿Desea realizar otra adopción? : ");
				print("Responda si/no: ");
				continuar = readString();
				
			}
			
			}while(continuar.equalsIgnoreCase("si"));
			
			//CREACIÓN DEL OBJETO ADOPCIÓN
			//SE AGREGA TANTO AL ARRAYLIST DE ADOPCIONES DE LA SEDE COMO AL ARRAYLIST DE ADOPCIONES GENERALES
			
			// 1. CREAMOS AL CLIENTE
			Cliente nuevocliente = new Cliente(nombre,edad,cedula,telefono,direccion);	
			for(Animal mascotaadoptada: adoptados) {
				
				if (mascotaadoptada!=null) {
				Adopcion nuevaadopcion = new Adopcion(mascotaadoptada,nuevocliente);		
				sedes.get(sede).agregarAdopcion(nuevaadopcion);
				}
			}
			
			if (adoptados.size()!=0) {	
				
				if(adoptados.size()>1) {				
					int ultimo = adoptados.size();		
					String nombres= "";			
					ArrayList <Animal> nombresmascotas = adoptados;	
					String nombreultimo = nombresmascotas.get(ultimo-1).getNombre();
					String nombreprimero = nombresmascotas.get(0).getNombre();
					nombresmascotas.remove(ultimo-1);
					nombresmascotas.remove(0);
					
					
					for (Animal nombremascota: nombresmascotas) {
						if (nombremascota != null) {
						nombres += "," + nombremascota.getNombre();
						}
					}		
					nombres+= nombreprimero;
					nombres+= " y " + nombreultimo;		
					println("\nFue un gusto para AdoptaLove atenderlo señor/a " + nombre + ", ahora " + nombres +" son nuevos integrantes en su familia!");
				}
				
				else {
					println("\nFue un gusto para AdoptaLove atenderlo señor/a " + nombre + ", ahora " + adoptados.get(0).getNombre() + " es un nuevo integrante en su familia!");
				}
			
			}
			else {
				println("\nEs una pena que no haya podido realizar una adopción :(\nfue un gusto atenderlo señor/a" + nombre + ", ¡vuelva pronto! ");
			}			
		}
		
		else {
			println("\nSeñor/a " + nombre + " no cumple con los requisitos para pser un adoptante en AdoptaLove, no podemos continuar con el proceso.");
		}			
	}
		
}





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
		
		adoptarMascota();
			
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
	
	public static boolean validacionEncuesta() {
		Scanner respuestas = new Scanner(System.in);
        int puntaje = hacerEncuesta(respuestas);

        if (Adopcion.encuesta(puntaje)) {
        	return true;
        	
        } else {
            return false;
        }
		
	}

	public static int hacerEncuesta(Scanner scanner) {
		    println("\nLa siguiente encuesta es un requisito para verificar que cumple con los criterios para ser un adoptante en AdoptaLove.");
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
	            print(pregunta);
	            while (!scanner.hasNextInt()) {
	                print("Por favor, ingrese un número en el rango [1-5]: ");
	                scanner.next();
	            }
	            respuesta = scanner.nextInt();
	            if (respuesta < 1 || respuesta > 5) {
	                println("Por favor, ingrese un número en el rango [1-5]:  ");
	            }
	        } while (respuesta < 1 || respuesta > 5);
	        
	        return respuesta;
	    }
	   
	   
	   
	   //MÉTODOS PARA LA SELECCION DE LA MASCOTA
	   
	   public static int escogerSede() {
		   int sede;
		   int respuesta;
		   println("Seleccione en cual sede quiere realizar la adopción.");
		   println("1. SEDE 1");
		   println("2. SEDE 2");
		   println("3. SEDE 3");
		   
		   do {
			   print("Ingrese su elección dentro del rango [1-3]: ");
			   respuesta = readInt();
			   sede = respuesta - 1;
			   
			   if (respuesta<1 || respuesta>3) {
				   println("Opción incorrecta.\n");
			   }
			  
		   }while(respuesta<1 || respuesta>3);
		   
		   
		   return sede;
	   }
	   
	   public static Animal escogerMascota(int sede) {
		   
		   println("¿Desea ver todos las mascotas disponibles o filtrar por una especie en especifico?");	   
		     int opcion;
		     Animal mascota = null; //MASCOTA SELECCIONADA PARA ADOPCIÓN
		     
		     
		     //BUCLE QUE CONTROLA QUE SE PULSE UNA DE LAS OPCIONES CORRECTAS
		   do {   
			   println("1. Ver todos las mascotas disponibles.\n2. Filtrar por especie.");
			   print("Ingrese una opción dentro del rango [1-2]: ");
			   opcion = readInt();
			   
			   if (opcion!=1 && opcion!=2) {
				   println("\nOpción incorrecta.");
			   }
		   }while(opcion!=1 && opcion!=2);
		   
		   //OPCIONES DE VISUALIZACIÓN
		   switch(opcion) {
		   
		   //VISUALIZAR TODOS LOS ANIMALES DE LA SEDE QUE SE ESCOGIÓ
		   case 1: 
			   
			   //INFORMAR SI NO HAY MASCOTAS DISPONIBLES
			   if (Main.sedes.get(sede).consultarAnimales().size()==0) {
				   println("Lo sentimos, en esta sede no hay mascotas disponibles para adopción.");
			   }	
			   
			   //MOSTRAR AL USUARIO TODAS LAS MASCOTAS
			   else {
				   int mascotaseleccionada;
				   int i=1;
				   
				   println("\nLas mascotas disponibles para adopción son:\n");
			   for(Animal seleccion : sedes.get(sede).consultarAnimales()) {
				   println("Mascota " + i +" - "+ seleccion);
				   i++;
			   }
			   // SELECCIONAR LA MASCOTA DE SU PREFERENCIA
			   do {
				   print("\nIngrese el número de la mascota que quiere adoptar: ");
				    mascotaseleccionada = readInt();
				  
				  if (mascotaseleccionada<=0 || mascotaseleccionada> sedes.get(sede).consultarAnimales().size()) {
					  println("El número seleccionado está fuera del rango.");
				  }
			   }while(mascotaseleccionada<=0 || mascotaseleccionada> sedes.get(sede).consultarAnimales().size());
			   
			   mascota = Main.sedes.get(sede).consultarAnimales().get(mascotaseleccionada - 1);
				  Main.sedes.get(sede).borrarAnimal(mascota);
				  
			   }
				   break;
				   
			//VISUALIZAR LAS MASCOTAS FILTRADAS POR ESPECIE
		   case 2:   
			   
			   //INFORMAR SI NO HAY MASCOTAS DISPONIBLES
			   if (Main.sedes.get(sede).consultarAnimales().size()==0) {
				   println("Lo sentimos, en esta sede no hay mascotas disponibles para adopción.");
			   }	
			   else {
			   ArrayList<Animal> filtroTipo; //ARRAY QUE GUARDA LAS MASCOTAS QUE COINCIDAN CON LA ESPECIE
			   println("\nLas especies que manejamos son: ");
			   println("1. Perros");
			   println("2. Gatos");
			   println("3. Loros");
			   println("4. Conejos");
			   println("5. Hámsters");	   
			   int especie;
			   String filtro = null;
			   
			   do {
			   print("Ingrese una opción dentro del rango [1 - 5]: ");   
			   especie = readInt();
			   
			   if(especie<1 || especie>5) {
				   println("Opción incorrecta\n");
			   }   
			   } while(especie<1 || especie>5);
			   
			  filtroTipo = sedes.get(sede).filtrarEspecie(especie);
			   
			   if (filtroTipo.size()==0) {
				   println("\nLo sentimos,en este momento no hay mascotas de esa especie para adoptar.");
			   }
			   
			   else {
				   int j=1;
				   int mascotaseleccionada;
				   println("\nLas mascotas que se encuentran disponibles son:");
				   
				   for (Animal seleccion: filtroTipo) {
					   println("Mascota " + j + ": " + seleccion);
					   j++;
				   }
				   do {
               print("\nIngrese el número de la mascota que quiere adoptar: ");
				   
				    mascotaseleccionada = readInt();
				  if(mascotaseleccionada<=0 || mascotaseleccionada > filtroTipo.size()) {
					  println("El número seleccionado está fuera del rango.");
				  }
				   }while (mascotaseleccionada<=0 || mascotaseleccionada > filtroTipo.size());		
				   
				   mascota = filtroTipo.get(mascotaseleccionada - 1);
					  sedes.get(sede).borrarAnimal(mascota);
			   }	   
			   }
		   }	   
		   return mascota;	   
	   }
	
	
	   
	   
	//MÉTODO ESTÁTICO FUNCIONALIDAD ADOPTAR ANIMAL
	public static void adoptarMascota() {
		
		//INGRESAR LOS DATOS DEL CLIENTE
		println("Proporcione los siguientes datos de la persona interesada en adoptar  ");
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
				println("La edad ingresada no corresponde a la de un adulto.\n");
			
			}} while(edad<18);
				}
		
		print("Ingrese su número de identificación: ");
		long cedula = readLong();
		print("Ingrese su número de teléfono:  ");
		long  telefono = readLong();
		print("Ingrese su dirección: ");
		String direccion = readString();
		
		if (Main.validacionEncuesta()) {
			println("\nSeñor/a " + nombre + " cumple con los requisitos para ser un adoptante en AdoptaLove, podemos continuar con el proceso." );		
			ArrayList <Animal> mascotasadoptadas= new ArrayList<>(); //ARRAY QUE GUARDA LAS MASCOTAS QUE ADOPTA LA PERSONA
			String continuar = null;
			int sede;
			
			do {
			sede = escogerSede();
			Animal mascota = escogerMascota(sede);
			
			if (mascota == null) {
				println("\n¿Desea intentar una nueva adopción? ");
				print("Responda si/no: ");
				
				continuar = readString();
			}
			else {
				mascotasadoptadas.add(mascota);
				print("\n¡Felicitaciones señor/a "+ nombre + " ahora tendrá la compañia de " + mascota.getNombre()+ "!\n");		

				
				if (mascotasadoptadas.size()==3) {
					continuar="no";
					println("Señor/a "+ nombre + " tenemos un límite de 3 adopciones juntas, puede volver en otro momento si desea realizar otra.");
				}
				else {
					println("\n¿Desea realizar otra adopción? : ");
				print("Responda si/no: ");
				continuar = readString();
				}
				
			}
			
			}while(continuar.equalsIgnoreCase("si"));
			
			//CREACIÓN DEL OBJETO ADOPCIÓN
			//SE AGREGA TANTO AL ARRAYLIST DE ADOPCIONES DE LA SEDE COMO AL ARRAYLIST DE ADOPCIONES GENERALES
			
			// 1. CREAMOS AL CLIENTE
			Cliente nuevocliente = new Cliente(nombre,edad,cedula,telefono,direccion);	
			for(Animal mascotaadoptada: mascotasadoptadas) {
				
				if (mascotaadoptada!=null) {
				Adopcion nuevaadopcion = new Adopcion(mascotaadoptada,nuevocliente);		
				sedes.get(sede).agregarAdopcion(nuevaadopcion);
				}
			}
			
			if (mascotasadoptadas.size()!=0) {	
				
				if(mascotasadoptadas.size()>1) {				
					int ultimo = mascotasadoptadas.size();		
					String nombres= "";			
					ArrayList <Animal> nombresmascotas = mascotasadoptadas;	
					String nombreultimo = nombresmascotas.get(ultimo-1).getNombre();
					String nombreprimero = nombresmascotas.get(0).getNombre();
					nombresmascotas.remove(ultimo-1);
					nombresmascotas.remove(0);
					
					nombres+= nombreprimero;
					
					for (Animal nombremascota: nombresmascotas) {
						if (nombremascota != null) {
						nombres += ", " + nombremascota.getNombre();
						}
					}		
					nombres+= " y " + nombreultimo;		
					println("\nFue un gusto para AdoptaLove atenderlo señor/a " + nombre + ", ahora " + nombres +" son nuevos integrantes en su familia!");
				}
				
				else {
					println("\nFue un gusto para AdoptaLove atenderlo señor/a " + nombre + ", ahora " + mascotasadoptadas.get(0).getNombre() + " es un nuevo integrante en su familia!");
				}
			
			}
			else {
				println("\nEs una pena que no haya podido realizar una adopción :(\nfue un gusto atenderlo señor/a " + nombre + ", ¡vuelva pronto! ");
			}			
		}
		
		else {
			println("\nSeñor/a " + nombre + " no cumple con los requisitos para ser un adoptante en AdoptaLove, no podemos continuar con el proceso.");
		}			
	}
		
}





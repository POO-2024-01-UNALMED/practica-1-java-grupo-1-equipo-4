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
		sede1.agregarAnimal(new Animal("Nala","loro",2, "Hembra", Animal.EstadoSalud.ENTRATAMIENTO));
		sede1.agregarAnimal(new Animal("Dino","Perro",1, "Macho", Animal.EstadoSalud.SANO));
		sede1.agregarAnimal(new Animal("Reina","Gato",3,"Hembra",Animal.EstadoSalud.ENTRATAMIENTO));
		
		//SEDE2	
		sede2.agregarAnimal(new Animal("Golfo","Conejo",2, "Macho", Animal.EstadoSalud.SANO));
		sede2.agregarAnimal(new Animal("Frapee","loro",2, "Hembra", Animal.EstadoSalud.ENTRATAMIENTO));
		sede2.agregarAnimal(new Animal("Bolt","Perro",2, "Macho", Animal.EstadoSalud.SANO));
		sede2.agregarAnimal(new Animal("Frodo","Perro",2, "Macho", Animal.EstadoSalud.SANO));
		sede2.agregarAnimal(new Animal("Luna","Gato",2, "Hembra", Animal.EstadoSalud.ENTRATAMIENTO));
		
		//SEDE3
		sede3.agregarAnimal(new Animal("Thor","Perro",2, "Macho", Animal.EstadoSalud.SANO));
		sede3.agregarAnimal(new Animal("Teo","Perro",2, "Macho", Animal.EstadoSalud.SANO));
		sede3.agregarAnimal(new Animal("Mia","Gato",2, "Hembra", Animal.EstadoSalud.ENTRATAMIENTO));
		sede3.agregarAnimal(new Animal("Sony","Conejo",2, "Macho", Animal.EstadoSalud.SANO));
		sede3.agregarAnimal(new Animal("Kira","loro",2, "Hembra", Animal.EstadoSalud.ENTRATAMIENTO));
	
		
	
	}
	
	
	public static void main(String[] args) {
		
	     Scanner respuestas = new Scanner(System.in);

	        int puntaje = hacerEncuesta(respuestas);

	        if (Adopcion.encuesta(puntaje)) {

	        	System.out.println("¡Felicidades! Usted es un candidato confiable para adoptar una mascota en AdoptaLove.");
	        	
	        } else {
	            System.out.println("Lo sentimos, no cumple con los requisitos mínimos para adoptar una mascota.");
	        }
		
		//adoptarAnimal();
		
	}
	
	
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
	
	
	public static int hacerEncuesta(Scanner scanner) {
		    println("La siguiente encuesta es un requisito para verificar que cumple con los requisistos para ser un adoptante en AdoptaLove.");
	        println("Responda a las preguntas con una calificación en el rango [1-5], donde 1 es muy poco y 5 mucho.");
	        int puntaje = 0;

	        puntaje += validacionRespuesta(scanner, "1. ¿Tiene experiencia en el cuidado de mascotas?: ");
	        puntaje += validacionRespuesta(scanner, "2. ¿Cuánto tiempo puede dedicar diariamente a la atención y el cuidado de la mascota?: ");
	        puntaje += validacionRespuesta(scanner, "3. ¿Con qué frecuencia planea viajar en los próximos meses?: ");
	        puntaje += validacionRespuesta(scanner, "4. ¿Tiene un espacio adecuado en su hogar para la mascota, tanto en interiores como en exteriores?: ");
	        puntaje += validacionRespuesta(scanner, "5. ¿Qué tan cómodo/a se siente al tener una mascota en su hogar?: ");
	        puntaje += validacionRespuesta(scanner, "6. ¿Ha considerado los requisitos específicos de la raza o tipo de mascota en términos de ejercicio, socialización y cuidados?: ");
	        puntaje += validacionRespuesta(scanner, "7. ¿Está dispuesto a someter a la mascota a chequeos veterinarios regulares?: ");
	        puntaje += validacionRespuesta(scanner, "8. ¿Está dispuesto a recibir visitas por parte de AdoptaLove para enterarnos del estado de la mascota?: ");
	        

	        return puntaje;
	    }
	    
	   public static int validacionRespuesta(Scanner scanner, String pregunta) {
	        int respuesta;
	        do {
	            System.out.print(pregunta);
	            while (!scanner.hasNextInt()) {
	                System.out.println("Por favor, ingrese un número válido del 1 al 5.");
	                scanner.next();
	            }
	            respuesta = scanner.nextInt();
	            if (respuesta < 1 || respuesta > 5) {
	                System.out.println("Por favor, ingrese un número válido del 1 al 5.");
	            }
	        } while (respuesta < 1 || respuesta > 5);
	        
	        return respuesta;
	    }
	
	
	
	

	
	static void adoptarAnimal() {
		
		//INGRESAR LOS DATOS DEL CLIENTE
		println("Proporcione los siguientes datos del interesado en adoptar: ");
		print("Ingrese su nombre: ");
		String nombre = readString();
		
		print("Ingrese su edad: ");
		int edad = readInt();
		
		if (edad<18) {
			
			println("El interasado en adoptar es menor de edad.");
			println("Proporcione los datos del responsable: ");
			print("Ingrese su nombre: ");	
			nombre = readString();
			
			print("Ingrese su edad: ");
			edad= readInt();
			}
		
		print("Ingrese su número de identificación: ");
		long cedula = readLong();
		print("Ingrese su número de teléfono:  ");
		long  telefono = readLong();
		print("Ingrese su dirección: ");
		String direccion = readString();
		
		Cliente adoptante= new Cliente(nombre,edad,cedula,telefono,direccion);
			
		}
		
}





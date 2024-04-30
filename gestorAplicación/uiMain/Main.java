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
	public static ArrayList <CentroAdopcion> sedesEmpleados = new ArrayList<CentroAdopcion>();
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
		sede1.agregarAnimal(new Animal("Tobi","Perro",2, "Macho", Animal.EstadoSalud.SANO));
		sede1.agregarAnimal(new Animal("Reina","Gato",3, "Hembra", Animal.EstadoSalud.ENTRATAMIENTO));
		sede1.agregarAnimal(new Animal("Rocky","Conejo",1, "Macho", Animal.EstadoSalud.SANO));
		sede1.agregarAnimal(new Animal("Nala","Loro",2, "Hembra", Animal.EstadoSalud.ENTRATAMIENTO));
		sede1.agregarAnimal(new Animal("Dino","Perro",1, "Macho", Animal.EstadoSalud.SANO));
		sede1.agregarAnimal(new Animal("Reina","Gato",3,"Hembra",Animal.EstadoSalud.ENTRATAMIENTO));
		
		//SEDE2	
		sede2.agregarAnimal(new Animal("Golfo","Conejo",2, "Macho", Animal.EstadoSalud.SANO));
		sede2.agregarAnimal(new Animal("Frapee","Loro",1, "Hembra", Animal.EstadoSalud.ENTRATAMIENTO));
		sede2.agregarAnimal(new Animal("Bolt","Perro",2, "Macho", Animal.EstadoSalud.SANO));
		sede2.agregarAnimal(new Animal("Frodo","Perro",2, "Macho", Animal.EstadoSalud.SANO));
		sede2.agregarAnimal(new Animal("Luna","Gato",1, "Hembra", Animal.EstadoSalud.ENTRATAMIENTO));
		
		//SEDE3
		sede3.agregarAnimal(new Animal("Thor","Perro",2, "Macho", Animal.EstadoSalud.SANO));
		sede3.agregarAnimal(new Animal("Teo","Perro",1, "Macho", Animal.EstadoSalud.SANO));
		sede3.agregarAnimal(new Animal("Mia","Gato",2, "Hembra", Animal.EstadoSalud.ENTRATAMIENTO));
		sede3.agregarAnimal(new Animal("Sony","Conejo",1, "Macho", Animal.EstadoSalud.SANO));
		sede3.agregarAnimal(new Animal("Kira","Loro",2, "Hembra", Animal.EstadoSalud.ENTRATAMIENTO));
	}
	
	static {
		//CREACION UBICACION EMPLEADOS
		CentroAdopcion empleadosSede1 = new CentroAdopcion("SEDE 1", CentroAdopcion.tipoServicio.GUARDERIA);
		sedesEmpleados.add(empleadosSede1);
		CentroAdopcion empleadosSede2 = new CentroAdopcion("SEDE 2", CentroAdopcion.tipoServicio.VETERINARIA);
		sedesEmpleados.add(empleadosSede2);
		CentroAdopcion empleadosSede3 = new CentroAdopcion("SEDE 3", CentroAdopcion.tipoServicio.PELUQUERIA);
		sedesEmpleados.add(empleadosSede3);
		
		//AGREGAR EMPLEADOS A CADA SEDE
		
		//SEDE 1
		empleadosSede1.agregarEmpleado(new Empleado("Juan Zapata", 25, 21491118, 313775896, "Carrera 30", Empleado.Rol.CUIDADOR, horario));
		empleadosSede1.agregarEmpleado(new Empleado("Julieta Vanegas", 21, 58941118, 310789651, "Calle 96", Empleado.Rol.CUIDADOR, horario));
		empleadosSede1.agregarEmpleado(new Empleado("Andres Garcia", 34, 10278056, 300845962, "Calle 80", Empleado.Rol.CUIDADOR, horario));
		empleadosSede1.agregarEmpleado(new Empleado("Ana Restrepo", 28, 47889566, 315986487, "Carrera Septima", Empleado.Rol.CUIDADOR, horario));
		empleadosSede1.agregarEmpleado(new Empleado("Wilson Jimenez", 36, 70925845, 313153964, "Carrera 72a", Empleado.Rol.CUIDADOR, horario));
		empleadosSede1.agregarEmpleado(new Empleado("Mateo Munera", 25, 56892347, 311567832, "Carrera 68", Empleado.Rol.CUIDADOR, horario));
				
		//SEDE 2
		empleadosSede2.agregarEmpleado(new Empleado("Carlos Rivera", 23, 12307004, 328748995, "Carrera 30", Empleado.Rol.VETERINARIO, horario));
		empleadosSede2.agregarEmpleado(new Empleado("Marta Puerta", 28, 66973892, 304236021, "Calle 90", Empleado.Rol.VETERINARIO, horario));
		empleadosSede2.agregarEmpleado(new Empleado("Karen Diaz", 32, 11277768, 314943886, "Calle 86", Empleado.Rol.VETERINARIO, horario));
		empleadosSede2.agregarEmpleado(new Empleado("Mario Martinez", 30, 79698181, 300564603, "Carrera 67b", Empleado.Rol.VETERINARIO, horario));
				
		//SEDE 3
		empleadosSede3.agregarEmpleado(new Empleado("Natalia Fernandez", 26, 70233557, 318529646, "Calle 63", Empleado.Rol.PELUQUERO, horario));
		empleadosSede3.agregarEmpleado(new Empleado("Jose Bueno", 39, 50270440, 306537090, "Calle 50", Empleado.Rol.PELUQUERO, horario));
		empleadosSede3.agregarEmpleado(new Empleado("Diana Henao", 28, 69620661, 330175882, "Carrera Sexta", Empleado.Rol.PELUQUERO, horario));
		empleadosSede3.agregarEmpleado(new Empleado("Julian Taborda", 36, 37664642, 332773881, "Carrera 72c", Empleado.Rol.PELUQUERO, horario));
		empleadosSede3.agregarEmpleado(new Empleado("Andrea Higuita", 21, 55000283, 332697785, "Carrera 61", Empleado.Rol.PELUQUERO, horario));
		
	}
	
	
	public static void main(String[] args) {
		
		adoptarMascota();	
		agendarServicio();
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
		String string =entrada.nextLine();
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
	        puntaje += validacionRespuesta(scanner, "6. ¿Ha considerado los requisitos específicos de la raza/tipo de mascota en términos de ejercicio,socialización y cuidados?: ");
	        puntaje += validacionRespuesta(scanner, "7. ¿Está dispuesto a someter a la mascota a chequeos veterinarios regulares?: ");
	        puntaje += validacionRespuesta(scanner, "8. ¿Está dispuesto a recibir visitas por parte de AdoptaLove para enterarnos del estado de la mascota?: ");
	        return puntaje;
	    }
	    
	   public static int validacionRespuesta(Scanner scanner, String pregunta) {
	        int respuesta;
	        do {
	            print(pregunta);
	            while (!scanner.hasNextInt()) {
	                print("Por favor, ingrese una respuesta válida en el rango [1-5]: ");
	                scanner.next();
	            }
	            respuesta = scanner.nextInt();
	            while (respuesta < 1 || respuesta > 5) {
	                print("Proporcione una respuesta dentro del rango [1-5]: ");
	                respuesta = scanner.nextInt();
	            }
	        } while (respuesta < 1 || respuesta > 5);
	        
	        return respuesta;
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
				   println("Tipo de dato incorrecto, proporcione una respuesta válida.");
			   }finally {
				   readString();
			   }
			  
		   }while(respuesta<1 || respuesta>3);   
		   return sede;
	   }   
	   public static Animal escogerMascota(int sede) {
		   
		   println("\n¿Desea ver todos las mascotas disponibles o filtrar por una especie en especifico?");	   
		     int opcion=0; //OPCIÓN DE VISUALIZACIÓN
		     Animal mascota = null; //MASCOTA SELECCIONADA PARA ADOPCIÓN
		     
		     println("1. Ver todos las mascotas disponibles.\n2. Filtrar por especie.");     
		     //BUCLE QUE CONTROLA QUE SE PULSE UNA DE LAS OPCIONES CORRECTAS
		   do { 
			   try {
			   print("Ingrese una opción dentro del rango [1-2]: ");
			   opcion = readInt();
			   
			   if (opcion!=1 && opcion!=2) {
				   println("Opción fuera de rango.");
			   }
		   }catch(RuntimeException e) {
			   println("Tipo de dato incorrecto, proporcione una respuesta válida.");
		   }finally {
			   readString();
		   }
		   }while(opcion!=1 && opcion!=2);
		   
		   //OPCIONES DE VISUALIZACIÓN
		   switch(opcion) {
		   
		   //VISUALIZAR TODOS LOS ANIMALES DE LA SEDE QUE SE ESCOGIÓ
		   case 1: 
			   
			   //INFORMAR SI NO HAY MASCOTAS DISPONIBLES
			   if (Main.sedes.get(sede).consultarAnimales().size()==0) {
				   println("Lo sentimos, en estos momentos esta sede no cuenta con mascotas disponibles para adopción.");
			   }				   
			   //MOSTRAR AL USUARIO TODAS LAS MASCOTAS
			   else {
				   int numeromascota=0;
				   int i=1; //ENUMERACIÓN DE MASCOTAS
				   
				   println("\nLas mascotas disponibles para adopción son:\n");
			       for(Animal seleccion : sedes.get(sede).consultarAnimales()) {
				   println("Mascota " + i +" - "+ seleccion);
				   i++;
			   }
			   // SELECCIONAR LA MASCOTA DE SU PREFERENCIA
			   do {
				   try {
				   print("\nIngrese el número de la mascota que quiere adoptar: ");
				    numeromascota = readInt();
				  
				  if (numeromascota<=0 || numeromascota> sedes.get(sede).consultarAnimales().size()) {
					  println("El número seleccionado está fuera del rango.");
				  }
				   }catch(RuntimeException e) {
					   println("Tipo de dato incorrecto, proporcione una respuesta válida.");
				   }finally {
					   readString();
				   }
			   }while(numeromascota<=0 || numeromascota> sedes.get(sede).consultarAnimales().size());
			   
			   mascota = Main.sedes.get(sede).consultarAnimales().get(numeromascota - 1); //GUARDAR MASCOTA SELECCIONADA
			   Main.sedes.get(sede).borrarAnimal(mascota); //BORRAR LA MASCOTA DE LOS DISPONIBLES
				  
			   }
				   break;			   
			//VISUALIZAR LAS MASCOTAS FILTRADAS POR ESPECIE
		   case 2:   
			   //INFORMAR SI NO HAY MASCOTAS DISPONIBLES
			   if (Main.sedes.get(sede).consultarAnimales().size()==0) {
				   println("Lo sentimos, en estos momentos esta sede no cuenta con mascotas disponibles para adopción.");
			   }	
			   else {
			   ArrayList<Animal> filtroTipo; //ARRAY QUE GUARDA LAS MASCOTAS QUE COINCIDAN CON LA ESPECIE
			   println("\nLas especies que manejamos son: ");
			   println("1. Perros");
			   println("2. Gatos");
			   println("3. Loros");
			   println("4. Conejos");
			   println("5. Hámsters");	   
			   int especie=0;
			   
			   do {
				   try {
			   print("Ingrese una opción dentro del rango [1-5]: ");   
			   especie = readInt();
			   
			   if(especie<1 || especie>5) {
				   println("Opción fuera del rango.");
			   } 
				   } catch(RuntimeException e) {
					  println("Tipo de dato incorrecto, proporcione una respuesta válida.");
				   }finally {
					   readString();
				   }
			   } while(especie<1 || especie>5);
			   
			  filtroTipo = sedes.get(sede).filtrarEspecie(especie);
			   
			   if (filtroTipo.size()==0) {
				   println("\nLo sentimos,en este momento no hay mascotas de esa especie para adoptar.");
			   }	   
			   else {
				   int j=1;
				   int numeromascota=0;
				   println("\nLas mascotas que se encuentran disponibles son:");
				   
				   for (Animal seleccion: filtroTipo) {
					   println("Mascota " + j + ": " + seleccion);
					   j++;
				   }
				   do {
					   try {
               print("\nIngrese el número de la mascota que quiere adoptar: ");
				   
				    numeromascota = readInt();
				  if(numeromascota<=0 || numeromascota> filtroTipo.size()) {
					  println("El número seleccionado está fuera del rango.");
				  }
					   }catch(RuntimeException e) {
						   println("Tipo de dato incorrecto, proporcione una respuesta válida.");
					   }finally {
						   readString();
					   }
				   }while (numeromascota<=0 || numeromascota > filtroTipo.size());		
				   
				   mascota = filtroTipo.get(numeromascota - 1);
				   sedes.get(sede).borrarAnimal(mascota);
			   }	   

			   }
		  }	   
		   return mascota;	   
	   }
		   
	//MÉTODO ESTÁTICO FUNCIONALIDAD ADOPTAR ANIMAL
	public static void adoptarMascota() {	
		//INGRESAR LOS DATOS DEL CLIENTE
		
		println("Proporcione los siguientes datos de la persona interesada en adoptar: ");
		print("Ingrese su nombre: ");
		String nombre = readString();
		int edad =0;
		while(edad ==0) {		
		    try {
				print("Ingrese su edad: ");
				edad = readInt();
				if (edad<=0) {
					println("El edad no puede ser una cantidad negativa ni nula.");
					edad=0;
				}
		    }catch(RuntimeException e) {
		    	println("Tipo de dato incorrecto, proporcione un valor válido.");
		    }finally {
		    	readString();//CONSUMIR SALTO DE LÍNEA.
		    	}
		}
		if (edad<18) {
			println("El interesado en adoptar es menor de edad.\n");
			do {
				println("Proporcione los datos de un adulto responsable: ");
				print("Ingrese su nombre: ");	
				nombre = readString(); 
				
				while(edad<18) {
					try {
				print("Ingrese su edad: ");
				edad= readInt();
				
				if (edad<=0) {
					println("La edad no puede ser una cantidad negativa ni nula.");
				}
				if (edad<18 && edad>0) {
					break;
				}
					} catch(RuntimeException e) {
						println("Tipo de dato incorrecto, proporcione un valor válido.");
					}finally {
						readString(); //CONSUMIR SALTO DE LÍNEA.
					}
				}
				if(edad<18 && edad>0) {
					println("La edad ingresada no corresponde a la de un adulto.\n");
	             }
			}while(edad<18);
		}
		long cedula=0;
		long telefono=0;
		while(cedula==0 || telefono==0) {
			try {
				while(cedula==0) {
					if (cedula == 0) {
						print("Ingrese su número de identificación: ");
						cedula = readLong();
						if (cedula<=0) {
							println("Proporcione un número de identificación válido.");
							cedula=0;
						}
					}
				}
				while(telefono==0) {
					if (telefono==0) {
						print("Ingrese su número de teléfono:  ");
						telefono = readLong();
						if (telefono<=0) {
							println("Proporcione un número de teléfono válido.");
							telefono=0;
						}
					}
				}
		}catch(RuntimeException e) {
			println("Tipo de dato incorrecto, proporcione un valor válido.");
			}finally {
				readString();
			}
		}
		print("Ingrese su dirección: ");
		String direccion = readString();
		
		if (Main.validacionEncuesta()) {
			println("\nSeñor/a " + nombre + " cumple con los requisitos para ser un adoptante en AdoptaLove, podemos continuar con el proceso." );		
			ArrayList <Animal> mascotasadoptadas= new ArrayList<>(); //ARRAY QUE GUARDA LAS MASCOTAS QUE ADOPTA LA PERSONA
			String continuar;
			int sede; //SEDE EN LA CUAL VA A ADOPTAR
			do {
			continuar="ok";
			sede = escogerSede();
			Animal mascota = escogerMascota(sede);
			
			if (mascota == null) {
				println("\n¿Desea intentar una nueva adopción? ");
				print("Responda si/no: ");	
				continuar = readString();
			}
			else {
				mascotasadoptadas.add(mascota);
				print("\n¡Felicidades señor/a "+ nombre + " ahora tendrá la compañia de " + mascota.getNombre()+ "!\n");		
				
				if (mascotasadoptadas.size()==3) {
					continuar="no";
					println("En AdoptaLove tenemos un límite de 3 adopciones juntas, puede volver en otro momento si desea realizar otra adopción.");
				}
				else {			
				println("\n¿Desea realizar otra adopción? : ");
				while(continuar.equalsIgnoreCase("si")==false && continuar.equalsIgnoreCase("no")==false) {
				print("Responda si/no: ");
				continuar = readString();
				}
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
	
	//------------------------------------INICIO AGENDAR SERVICIO-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
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
					//-------------------CASO 1------------------------------------------------------------------------------------------------------------------------------------------
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
				                    for(Empleado cuidador : sedesEmpleados.get(indicador).getEmpleados()) {
				                        if (cuidador.getProfesion() == Rol.CUIDADOR) {
				                            println(i +". "+ cuidador);
				                            i++;
				                        }
				                    }

				                    print("\nIngrese el número del cuidador que desea seleccionar: ");
				                    seleccion = readInt();
				                    int indiceSede = 0;
				                    for (int e = 0; e < sedesEmpleados.size(); e++) {
				                        if (sedesEmpleados.get(e) == sedesEmpleados.get(indicador)) {
				                            indiceSede = e;
				                            break;
				                        }
				                    }

				                    if (seleccion >= 1 && seleccion <= 6 && seleccion <= sedesEmpleados.get(indiceSede).getEmpleados().size()) {
				                        Empleado cuidadorSeleccionado = sedesEmpleados.get(indiceSede).getEmpleados().get(seleccion - 1);
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

				                        print("\n¿Desea volver a agendar en guardería? Responda (si/no): ");
				                        continuar = entrada.nextLine();
				                        if (continuar.equalsIgnoreCase("si")) {
				                            continue;
				                        } else {
				                            print("\nSerá redirigido al menú de servicios.\n");
				                        }
				                        break;
				                    } else {
				                        println("\nSelección inválida. Por favor, selecciona un número válido.");
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

					
				//--------------------------------CASO 2---------------------------------------------------------------------------------------------------------------------------
						case 2:
						
							println("\nVa a agendar en el servicio de veterinaria. \nValor de la cita: $------");
							String continuar2 = "si";
							do {
							    boolean seleccionValida = false;
							    while (!seleccionValida) {
							        println("\nSeleccione el numero del veterinario para ver su disponibilidad y agendar. \n");
							        int i = 7;
							        for (Empleado veterinario : sedesEmpleados.get(indicador).getEmpleados()) {
							            if (veterinario.getProfesion() == Rol.VETERINARIO) {
							                println(i + ". " + veterinario);
							                i++;
							            }
							        }

							        print("\nIngrese el número del veterinario que desea seleccionar: ");
							        try {
							            seleccion = readInt();
							            int indiceSede = 0;
							            for (int e = 0; e < sedesEmpleados.size(); e++) {
							                if (sedesEmpleados.get(e) == sedesEmpleados.get(indicador)) {
							                    indiceSede = e;
							                    break;
							                }
							            }

							            if (seleccion >= 7 && seleccion <= 10 && seleccion <= sedesEmpleados.get(indiceSede).getEmpleados().size()) {
							                Empleado veterinarioSeleccionado = sedesEmpleados.get(indiceSede).getEmpleados().get(seleccion - 1);
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

							                print("\n¿Desea volver a agendar en veterinaria? Responda (si/no(u otro caracter)): ");
							                continuar2 = entrada.nextLine();
							                if (continuar2.equalsIgnoreCase("si")) {
							                    continue;
							                } else {
							                    print("\nSerá redireccionado al menú de servicios.\n");
							                }
							                break;

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

					
				//-----------------------------CASO 3-----------------------------------------------------------------------------------------------------------------------------------
						case 3:
							
							println("\nVa a agendar en el servicio de peluquería. \nValor de la cita: $------");
							String continuar3 = "si";
							do {
							    boolean seleccionValida = false;
							    while (!seleccionValida) {
							        println("\nSeleccione el numero del peluquero para ver su disponibilidad y agendar. \n");
							        int i = 11;
							        for (Empleado peluquero : sedesEmpleados.get(indicador).getEmpleados()) {
							            if (peluquero.getProfesion() == Rol.VETERINARIO) {
							                println(i + ". " + peluquero);
							                i++;
							            }
							        }

							        print("\nIngrese el número del peluquero que desea seleccionar: ");
							        try {
							            seleccion = readInt();
							            int indiceSede = 0;
							            for (int e = 0; e < sedesEmpleados.size(); e++) {
							                if (sedesEmpleados.get(e) == sedesEmpleados.get(indicador)) {
							                    indiceSede = e;
							                    break;
							                }
							            }

							            if (seleccion >= 11 && seleccion <= 15 && seleccion <= sedesEmpleados.get(indiceSede).getEmpleados().size()) {
							                Empleado peluqueroSeleccionado = sedesEmpleados.get(indiceSede).getEmpleados().get(seleccion - 1);
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

							                print("\n¿Desea volver a agendar en veterinaria? Responda (si/no(u otro caracter)): ");
							                continuar3 = entrada.nextLine();
							                if (continuar3.equalsIgnoreCase("si")) {
							                    continue;
							                } else {
							                    print("\nSerá redireccionado al menú de servicios.\n");
							                }
							                break;

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


				//-----------------------------CASO 4----------------------------------------------------------------------------------------------------------------------------------
						case 4:
							print("\nFIN DE LA FUNCIONALIDAD. luego agrego esto ;)\n");
							seguirAgendando = false;
							
							break;
							
			    //-----------------------------DEFAULT (Si opción no valida para el switch)-----------------------------------------------------------------------------------------------------------------------------------         
				        default:
				            println("\nOpción inválida.");
				            break;
					}
				}
			}
	//-----------------------------FIN AGENDAR SERVICIO-----------------------------------------------------------------------------------------------------------------------------------
			
}





package gestorAplicación.uiMain;

import java.util.ArrayList;


import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import gestorAplicación.procesoAdopcion.*;
import gestorAplicación.procesoAdopcion.Animal.EstadoSalud;
import gestorAplicación.servicioAdicional.*;
//import gestorAplicación.servicioAdicional.Empleado.Rol;


public class Funcionalidad_2 {
	
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
		
		
		//AGREGAR EMPLEADOS A CADA SEDE
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
		
		
		//PROBAR CON UN CLIENTE YA REGISTRADO
		Cliente cliente = new Cliente("Oky",23,12345, 310676,"Guayabo");
		cliente.agregar_puntos(30);
		CentroAdopcion.clientes_AdoptaLove.add(cliente);
	}
	public static void main(String[] args) {
		
		agendarServicio();
		

	}
	
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
	
	
 //---------------------------------------------------------------------------------------------------
	
	public static void agendarServicio() {
		
		ArrayList<Cita> [] citas_seleccionadas; //SE GUARDA EN UN ARRAY LAS CITAS QUE SE ELIJAN EN UN DIA DETERMINADO
		
		String mismoUsuario="no";
		ArrayList<Servicio> servicios= new ArrayList<Servicio>();
		int servicio = escogerServicio();  //ELECCIÓN DEL SERVICIO Y SEDE.
	      
	   switch (servicio+1) {
	   	   
	    case 1:	
	    	
	    	servicios= new ArrayList<Servicio>();   	
	    	println("\nUn cupo en el servicio de guardería tiene un rango de dos horas; su valor es de $ 10.000 pesos.");
	    	
	    	//INGRESO DE DATOS DEL CLIENTE
			Cliente cliente= datos_cliente();	 
			readString();
	    	
	    	String servicioCero="no"; //PARA COMENZAR UN AGENDAMIENTO DE SERVICIO DESDE CERO
	    	
	    	do {
	    		citas_seleccionadas = new ArrayList[6];
	    		  		
	        	//INGRESO DE DATOS DE LA MASCOTA
		    	Animal mascota= datos_mascota(servicio);
		    	
		    	//SELECCIONAR CUIDADOR
	    		
	    		int num_empleado= escogerEmpleado(servicio);
	    		
	    		Empleado eleccionEmpleado =sedes.get(servicio).getEmpleados().get(num_empleado); 
	    	    println("Cuidador seleccionado: " + eleccionEmpleado.getNombre());
	    	
	    	    
	    	    String mismoCuidador="NO"; //PARA ESCOGER HORARIO CON EL MISMO CUIDADOR
	    	    ArrayList <Cita> citaseleccion;
	    	
	      	    do {
	      	    	citaseleccion = new ArrayList<>();
	      	    	
	      	    	//SELECCIONAR DIA DEL SERVICIO
		 		    String[] diasSemana = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"};
		            int num_dia=escogerDia();
	      	    	    
	    	        String eleccionDia = diasSemana[num_dia];
	    	        println("Dia seleccionado: "+ eleccionDia);
	    	    
	    	        //--------------
	    	    
	    	        String mismoDia="no"; //PARA SELECCIONAR CITAS EN EL MISMO DIA
	    	        do { 
	    	        	
	    	        	if (eleccionEmpleado.cuposDisponibles(eleccionDia)) {
	    	    	
	    	    	    println("\nSeleccione el horario en el que desea el servicio.");
	    	    	    println("Cupos para el día " + eleccionDia + ":");
	    	    	    int i =1;
	    	    	    int cupos=0;
	    	    	    ArrayList<Cita> citasDisponibles= new ArrayList<Cita>(); //ARRAY QUE GUARDA LAS CITAS DISPONIBLES
	    	    	                                                            //EN EL DIA SELECCIONADO
	    	    	           
	    	    	    
	    	    	    //MOSTRAR LAS CITAS DISPONIBLES DEL DIA SELECCIONADO.
	    	    	    for (Cita cita : eleccionEmpleado.obtenerCitas(eleccionDia)) {
	    	    	    	if (cita.getDisponibilidad()==true) {
	    	    	    		citasDisponibles.add(cita);
	    	    			    println(i +". De " + cita.getHoraInicio() + " a " + cita.getHoraFin() );
	    	    			    cupos++;
	    	    			    i++;
	    	    			    }
	    	    	    	else {
	    	    				println(cita.getHoraInicio() + " a " + cita.getHoraFin() + " - Ocupado");
	    	    				}
	    	    	    	}	    	    	
	    	    	
	    	    	    //SELECCIONAR CITA
	    	    	    int num_cita= escogerNum_Cita(cupos,mismoUsuario, eleccionEmpleado, eleccionDia);
	    	    	    
	    	    	    if(num_cita== (cupos+1)) {
	    	    	    	for(Cita cita: eleccionEmpleado.obtenerCitas(eleccionDia)) {
	    	    	    		citaseleccion.add(cita);
	            			    cita.setDisponibilidad(false);
	            			    }
	    	    	    	
	    	    	    	citas_seleccionadas[num_dia]= citaseleccion;
	            		
	            		    println("Ha agentado el día "+ eleccionDia + " completo.");
	            		    mismoDia="no"; //SALIR DEL BUBLE DEL MISMO DÍA.
	            		    entrada.nextLine();
	            		    println("¿Desea agendar otra cita en un día diferente para la misma mascota?: ");
	            		    String respuesta="ok";             
	            		    
	            		    do {
	            		    	
	            		    	print("Responda si/no: ");
     	                	    respuesta = readString();
     	                	    
     	                	    if (respuesta.equalsIgnoreCase("si")==false && respuesta.equalsIgnoreCase("no")==false) {
     	                	    	println("Proporcione una respuesta válida");
     	                	    }
     	                	    
     	                	    
	            		    }while(respuesta.equalsIgnoreCase("si")==false && respuesta.equalsIgnoreCase("no")==false);
	            		    
	            		    if (respuesta.equalsIgnoreCase("si")) {
	            		    	mismoCuidador="si";
 	                		    mismoUsuario="si";
 	                		    
	            		       } 
	            		    else {
	            		    	mismoCuidador="no";
 	                		    mismoUsuario="no";
 	                		
 	                		    String respuest;
	            			    println("¿Desea agendar una cita para una mascota diferente? ");  
	            			
	     	                    do {
	     	                    	print("Responda si/no: ");
	     	                	    respuest= readString();
	     	                	    
	     	                	    if (respuest.equalsIgnoreCase("si")==false && respuest.equalsIgnoreCase("no")==false) {
	     	                	    	println("Proporcione una respuesta válida");
	     	                	    }
	     	                	    
	     	                	    if (respuest.equalsIgnoreCase("si")) {
	     	                	    	servicioCero="si";
	     	                	    	}
	     	                	    else {
	     	                	    	servicioCero="no";
	     	                	    	}	     	    
	     	                	    }while(respuest.equalsIgnoreCase("si")==false && respuest.equalsIgnoreCase("no")==false);
	     	                    }
	            		    }
	    	    	    else {
	    	    	    	
	    	    	    	if(num_cita==0) {
	    	    	    		
	    	    	    		mismoDia="no"; //SALIR DEL BLOQUE DEL MISMO DIA.
	            			    String respuesta;
	            			    println("¿Desea intentar agendar cita en un día diferente? ");  
	            			    readString();
	            			    
	            			    do {
	            			    	print("Responda si/no: ");
	            			    	respuesta = readString();
	            			    	
	            			    	if (respuesta.equalsIgnoreCase("si")==false && respuesta.equalsIgnoreCase("no")==false) {
	            			    		println("Proporcione una respuesta válida");
	            			    	}

	            			    	}while(respuesta.equalsIgnoreCase("si")==false && respuesta.equalsIgnoreCase("no")==false);
	            			    
            			    	if (respuesta.equalsIgnoreCase("si")) {
            			    		mismoCuidador="si"; //PARA QUE VUELVA A ELIGIR UN DÍA.
     	                		    mismoUsuario="si";
     	                		    }
            			    	
            			    	else {
            			    		mismoCuidador="no";
     	                		    servicioCero="no";
     	                		    mismoUsuario="no";
     	                		    }
	            			    
	    	    	    	}else {		
	    	    	    		
	    	    	    		if (citas_seleccionadas[num_dia]==null) {          				
            				    citas_seleccionadas[num_dia]=new ArrayList<>();
            				    
	    	    	    		}
	    	    	    		
	    	    	    		citasDisponibles.get(num_cita-1).setDisponibilidad(false);
	            			    citas_seleccionadas[num_dia].add(citasDisponibles.get(num_cita-1));
	            			
	            		        println("¿Desea hacer uso de otro cupo en el mismo día?");
	            		        readString();
  	                            String respuesta;
  	                            
  	                            do { 	                            	
  	                            	print("Responda si/no: ");
  	                            	respuesta=readString();
  	                            	
  	                            	if (respuesta.equalsIgnoreCase("si")==false && respuesta.equalsIgnoreCase("no")==false) {
  	                            		println("Ingrese una respuesta válida");
  	                            	}
  	                            	
  	                            }while(respuesta.equalsIgnoreCase("si")==false && respuesta.equalsIgnoreCase("no")==false);
  	                            
  	                            if (respuesta.equalsIgnoreCase("si")) {
  	                            mismoDia="si";
  	                            mismoUsuario="si";
  	                            
  	                            }
  	                            
  	                            else {
  	                            	mismoDia="no";
  	                        	    println("¿Desea agendar otra cita en un día diferente para la misma mascota?");
  	  	                            String respuest;
  	  	                            
  	  	                            do {	  	                            	
  	  	                            	print("Responda si/no: ");
  	                        	        respuest=readString();	
  	                        	        
  	                        	        if(respuest.equalsIgnoreCase("si")==false && respuest.equalsIgnoreCase("no")==false) {
  	                        	        	println("Ingrese una respuesta válida");
  	                        	        }
  	                        	    }while(respuest.equalsIgnoreCase("si")==false && respuest.equalsIgnoreCase("no")==false);
  	  	                            
  	  	                            if (respuest.equalsIgnoreCase("si")) {
  	  	                            	mismoCuidador="si";
  	  	                                mismoUsuario="si";
  	  	                                
  	  	                            }else {
  	  	                        	    mismoCuidador="no";
  	  	                        	    mismoUsuario="no";
  	  	                        	
  	  	       	  	                    String respuesta_;
  	  	       	  	                    println("¿Desea agendar una cita para una mascota diferente? ");  
  	  	       	  	                
  	  	       	  	                    do {
  	  	       	  	                	   print("Responda si/no: ");
  	  	     	                	       respuesta_= readString();
  	  	     	                	       
  	   	                            	if (respuesta_.equalsIgnoreCase("si")==false && respuesta_.equalsIgnoreCase("no")==false) {
  	  	                            		println("Ingrese una respuesta válida");
  	  	                            	}
  	  	     	                	       
//  	  	     	                	       if (respuesta_.equalsIgnoreCase("si")) {
//  	  	     	                	    	   servicioCero="si";
//  	  	     	                	    	   }
//  	  	     	                	       else {
//  	  	     	                	    	   servicioCero="no";
//  	  	     	                	       }
  	  	     	                	    	   }while(respuesta_.equalsIgnoreCase("si")==false && respuesta_.equalsIgnoreCase("no")==false);
  	  	       	  	                    
	  	     	                	       if (respuesta_.equalsIgnoreCase("si")) {
  	  	     	                	    	   servicioCero="si";
  	  	     	                	    	   }
  	  	     	                	       else {
  	  	     	                	    	   servicioCero="no";
  	  	     	                	       }
  	  	       	  	                    }
  	                            }
  	                      }
	    	    	    	}
	    	    	    }
	    	        	
	    	    else {
	    	    	println("\nNo hay cupos disponibles para el día " + eleccionDia + ".");
	    	    	mismoDia="no"; //SALIR DE BUCLE DEL MISMO DÍA.
	    	    	
	                println("¿Desea agendar cita en un día diferente?: ");
	                readString();
	                String respuesta;
	                do {
	                	print("Responda si/no: ");
	                   respuesta = readString();
	                   
	                   if (respuesta.equalsIgnoreCase("si")==false && respuesta.equalsIgnoreCase("no")==false) {
	                	   println("Ingrese una respuesta válida");
	                   }
	                   
	                }while(respuesta.equalsIgnoreCase("si")==false && respuesta.equalsIgnoreCase("no")==false);
	                
	                if (respuesta.equalsIgnoreCase("si")) {
	                	mismoCuidador="si"; //PARA QUE VUELVA A ELEGIR EL DIA

	                	}
	                else {
	                	mismoCuidador="no"; //SALIR DEL BUCLE DEL MISMO CUIDADOR
	                	servicioCero="no";
	                }
	             }
	    	    
	    	  }while(mismoDia.equalsIgnoreCase("si")==true);
	    	    
	    	}while(mismoCuidador.equalsIgnoreCase("si")==true);
	      	
	      	
	      	//COMPROBAR SI SIQUIERA AGENDÓ UNA CITA
	      	boolean hayElementosNoNulos = false;
	      	
	      	for (ArrayList<Cita> lista : citas_seleccionadas) {
	      	    if (lista != null) {
	      	        hayElementosNoNulos = true;
	      	        break;
	      	    }
	      	}
	      	
	      	//-------------
	      	
	      	if(hayElementosNoNulos) {
		     		
	      		//CREAR EL SERVICIO
	      		Servicio nuevo_servicio = new Servicio(mascota,cliente,eleccionEmpleado,"Guardería",citas_seleccionadas); 
	      		servicios.add(nuevo_servicio);
	      	}
	      	
	          }while(servicioCero.equalsIgnoreCase("si")==true);
	      	    	
	      	break;
	      	
	    case 2:
	    	
	    	servicios= new ArrayList<Servicio>();
	    	  
	    	println("\nUna cita para el servicio de veterinaria tiene un valor de $20.000 pesos");
	    	
	    	//INGRESO DE DATOS DEL CLIENTE
			Cliente cliente_2= datos_cliente();	 
			readString();
			
			String servicioCero_2="no";
			
			do {
				citas_seleccionadas = new ArrayList[6];
				
				//INGRESO DE DATOS DE LA MASCOTA
	    	    Animal mascota_2 = datos_mascota(servicio);
	    	
	    	    //ELECCION DEL EMPLEADO
	    	    int numEmpleado_2= escogerEmpleado(servicio);
    		
    		    Empleado eleccion_Empleado_2=sedes.get(servicio).getEmpleados().get(numEmpleado_2); //VETERINARIO SELECCIONADO.
    	        println("Veterinario seleccionado: " + eleccion_Empleado_2.getNombre());
    	    

	    	    String mismoVeterinario="ok"; 
	    	
	    	    do {	    	
	    	    	
	    	    	//ELECCIÓN DEL DIA DEL SERVICIO ----------
		 		    String[] diasSemana_2= {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"};
		            int num_dia_2=escogerDia();
	      	    	    
	    	        String eleccionDia = diasSemana_2[num_dia_2]; //DIA SELECCIONADO
	    	        println("Dia seleccionado: "+ eleccionDia);
	    	        
	    	        //------------------------
	    	    
	    	        //SELECCIÓN DEL HORARIO
	    	    	
	    	    	if (eleccion_Empleado_2.cuposDisponibles(eleccionDia)) {
	    	    		println("\nSeleccione el horario en el que desea el servicio de veterinaria.");
		    	    	println("Citas para el día " + eleccionDia + ":");
		    	    	int i =1;
		    	    	int cupos=0;
		    	    	ArrayList<Cita> citasDisponibles= new ArrayList<Cita>(); //ARREGLO DONDE SE GUARDAN
		    	    	                                                         //LAS CITAS DISPONIBLES	    	    		    	    	
		    	    	//MOSTRAR LAS CITAS DISPONIBLES DEL DIA SELECCIONADO.
		    	    	for (Cita cita : eleccion_Empleado_2.obtenerCitas(eleccionDia)) {
		    	    		if (cita.getDisponibilidad()==true) {
		    	    			citasDisponibles.add(cita);
		    	    			println(i +". De " + cita.getHoraInicio() + " a " + cita.getHoraFin() );
		    	    			cupos++;
		    	    			i++;
		    	    			}else {
		    	    				println(cita.getHoraInicio() + " a " + cita.getHoraFin() + " - Ocupado");
		    	    				}
		    	    		}
		    	    	
		    	    	int num_cita = promtCupos(cupos);
		    	    	
		    	    //-------------------------
		    	    	
		    	    	if(num_cita==0) {
		     
		                String respuesta;
		            	println("¿Desea intentar agendar cita en un día diferente?");
		     	        entrada.nextLine(); 
		     	        
		     	        do {
		     	        	print("Responda si/no: ");
		     	            respuesta = readString();
		     	            
		     	            if (respuesta.equalsIgnoreCase("si")==false && respuesta.equalsIgnoreCase("no")==false) {
		     	            	println("Proporcione una respuesta válida.");
		     	            }
		     	                	
		     	            if (respuesta.equalsIgnoreCase("si")) {
		     	            	mismoVeterinario="si"; //PARA QUE VUELVA A ELIGIR UN DÍA.
		     	                }
		     	            else {
		     	            	mismoVeterinario="no";
		     	            	mismoUsuario="no";
		     	            	servicioCero_2="no";
		     	            	
		     	            	}
		     	            }while(respuesta.equalsIgnoreCase("si")==false && respuesta.equalsIgnoreCase("no")==false);
		     	        
		     	        
		     	        }else {
		     	        	
	            			if (citas_seleccionadas[num_dia_2]==null) {          				
	            				citas_seleccionadas[num_dia_2]=new ArrayList<>();
	            			}

		            		citasDisponibles.get(num_cita-1).setDisponibilidad(false);
		            		citas_seleccionadas[num_dia_2].add(citasDisponibles.get(num_cita-1));
		            			
		            		
		            		mismoVeterinario="no";
	  	                    println("¿Desea agendar otra cita para otra mascota?");
	  	                    readString();
	  	  	                String respuest;
	  	  	                
	  	  	                do {
	  	  	                	print("Responda si/no: ");
	  	  	                    respuest= readString();
	  	  	                    
	  	  	                    if (respuest.equalsIgnoreCase("si")==false && respuest.equalsIgnoreCase("no")==false) {
	  	  	                    	println("Proporcione una respuesta válida");
	  	  	                    }
	  	  	                  }while(respuest.equalsIgnoreCase("si")==false && respuest.equalsIgnoreCase("no")==false);
	  	  	                
	  	  	                if (respuest.equalsIgnoreCase("si")) {
	  	  	                	servicioCero_2="si";
	  	  	                	}
	  	  	                else {
	  	  	                	servicioCero_2="no";
	  	  	                	}
	  	  	                }
		    	    	}
	    	    	else {
	    	    		println("\nNo hay cupos disponibles para el día " + eleccionDia + ".");
		    	    	
		                print("¿Desea agendar cita en un día diferente?");
		                readString();
		                String respuesta;
		                do {
		                print("Responda si/no: ");
		                respuesta = readString();
		                
		                if (respuesta.equalsIgnoreCase("si")==false && respuesta.equalsIgnoreCase("no")==false) {
		                	println("Proporcione una respuesta válida");
		                }
		                }while(respuesta.equalsIgnoreCase("si")==false && respuesta.equalsIgnoreCase("no")==false);
		                
		                if (respuesta.equalsIgnoreCase("si")) {
		                	mismoVeterinario="si"; //PARA QUE VUELVA A ELEGIR EL DIA
		                	}
		                else {
		                	mismoVeterinario="no"; //SALIR DEL BUCLE DEL MISMO CUIDADOR
		                }
		             }
	    	    	
	    	    	}while(mismoVeterinario.equalsIgnoreCase("si")); 
	    	    
		      	boolean hayElementosNoNulos = false;
		      	
		      	for (ArrayList<Cita> lista : citas_seleccionadas) {
		      	    if (lista != null) {
		      	        hayElementosNoNulos = true;
		      	        break;
		      	    }
		      	}
		      	
		      	//---------
		      	
		      	if(hayElementosNoNulos) {
			     		
		      		//CREAR EL SERVICIO
		      		Servicio nuevo_servicio = new Servicio(mascota_2,cliente_2,eleccion_Empleado_2,"Veterinaria",citas_seleccionadas); 
		      		servicios.add(nuevo_servicio);
	
		      	    	    
			}

	    	          	    
	      	   }while(servicioCero_2.equalsIgnoreCase("si"));
			
    	    break;
    	    
	    case 3:
	    	
	    	servicios= new ArrayList<Servicio>();
	    	
		    	
		    	println("\nPara el servicio de peluquería se manejan los siguientes precios:\nValor por corte: 15.000 pesos."); 
		    	
		    	//INGRESO DE DATOS DEL CLIENTE
				Cliente cliente_3= datos_cliente();	 
				readString();
				
				String servicioCero_3="no";
				
				do {
					
					citas_seleccionadas = new ArrayList[6];
					
					//INGRESO DE DATOS DE LA MASCOTA
		    	    Animal mascota_3 = datos_mascota(servicio);
				
		    	    int num_Empleado_3= escogerEmpleado(servicio);
	    		
	    		    Empleado eleccion_empleado_3 =sedes.get(servicio).getEmpleados().get(num_Empleado_3); //PELUQUERO SELECCIONADO.
	    	        println("Peluquero seleccionado: " + eleccion_empleado_3.getNombre());
	    	    
	      	        //ELECCIÓN DEL DIA DEL SERVICIO
		    	    String mismoPeluquero="ok"; 
		    	    
		    	    do {
		    	    	
		    	    	String[] diasSemana_3 = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"};
			            int num_dia_3=escogerDia();
		      	    	    
		    	        String eleccionDia_3= diasSemana_3[num_dia_3]; //DIA SELECCIONADO
		    	        println("Dia seleccionado: "+ eleccionDia_3);
		    	    

		    	    	
		    	        if (eleccion_empleado_3.cuposDisponibles(eleccionDia_3)) {
		    	        	println("\nSeleccione el horario en el que desea el servicio de veterinaria.");
			    	        println("Citas para el día " + eleccionDia_3 + ":");
			    	        int i =1;
			    	        int cupos=0;
			    	        ArrayList<Cita> citasDisponibles= new ArrayList<Cita>(); //ARREGLO DONDE SE GUARDAN
			    	    	                                                         //LAS CITAS DISPONIBLES
			    	        
			    	        //MOSTRAR LAS CITAS DISPONIBLES DEL DIA SELECCIONADO.
			    	   	    for (Cita cita : eleccion_empleado_3.obtenerCitas(eleccionDia_3)) {
			    	   	    	
			    	   	    	if (cita.getDisponibilidad()==true) {
			    	    		citasDisponibles.add(cita);
			    	    		println(i +". De " + cita.getHoraInicio() + " a " + cita.getHoraFin() );
			    	    		cupos++;
			    	    		i++;
			    	    		
			    	   	    	}else {
			    	   	    		println(cita.getHoraInicio() + " a " + cita.getHoraFin() + " - Ocupado");
			    	   	    	}
			    	   	    }
			    	    	
			    	    	int num_cita= promtCupos(cupos);
			    	    	
			            	if(num_cita==0) {
			            	
			            		String respuesta;
			            		println("¿Desea intentar agendar cita en un día diferente?");
			     	            entrada.nextLine();  
			     	            
			     	            do {
			     	                print("Responda si/no: ");
			     	                respuesta = readString();
			     	                	
			     	                if (respuesta.equalsIgnoreCase("si")) {
			     	                	mismoPeluquero="si"; //PARA QUE VUELVA A ELIGIR UN DÍA.
			     	                	mismoUsuario="si";
			     	                }
			     	                else {
			     	                	mismoPeluquero="no";
			     	                	servicioCero_3="no";
			     	                	}
			     	                }while(respuesta.equalsIgnoreCase("si")==false && respuesta.equalsIgnoreCase("no")==false);
		            			
			            		}else {
			            			
			            			if (citas_seleccionadas[num_dia_3]==null) {          				
			            				citas_seleccionadas[num_dia_3]=new ArrayList<>();
			            			}

				            		citasDisponibles.get(num_cita-1).setDisponibilidad(false);
				            		citas_seleccionadas[num_dia_3].add(citasDisponibles.get(num_cita-1));
			          			    
			            		    mismoPeluquero="no";
			          
		  	                        println("¿Desea agendar otra cita para una mascota diferente?");
		  	                        readString();
		  	  	                    String respuest;
		  	  	                     do {
		  	  	                        print("Responda si/no: ");
		  	  	                        respuest=readString();
		  	  	                     }while(respuest.equalsIgnoreCase("si")==false && respuest.equalsIgnoreCase("no")==false);
		  	  	                        
		  	  	                        if (respuest.equalsIgnoreCase("si")) {	
		  	  	                        	servicioCero_3="si";   
		  	  	                        	mismoUsuario="si";
		  	  	                        }else {
		  	  	                        	servicioCero_3="no";
		  	  	                        	mismoUsuario="no";
		  	  	                        	}              	  	                  
			            		}
			            	
			          }
			    	    else {
			    	    	println("\nNo hay cupos disponibles para el día " + eleccionDia_3 + ".");

			    	    	
			                println("¿Desea agendar cita en un día diferente?");
			                readString();
			                String respuesta;
			                do {
			                	print("Responda si/no: ");
			                 respuesta = readString();
			                }while(respuesta.equalsIgnoreCase("si")==false && respuesta.equalsIgnoreCase("no")==false);
			                
			                if (respuesta.equalsIgnoreCase("si")) {
			                	mismoPeluquero="si"; //PARA QUE VUELVA A ELEGIR EL DIA			                	
			                	}
			                else {
			                	mismoPeluquero="no"; //SALIR DEL BUCLE DEL MISMO CUIDADOR
			                }
			             }		  
		    		
		    	}while(mismoPeluquero.equalsIgnoreCase("si"));
		    	    
			      	boolean hayElementosNoNulos = false;
			      	
			      	for (ArrayList<Cita> lista : citas_seleccionadas) {
			      	    if (lista != null) {
			      	        hayElementosNoNulos = true;
			      	        break;
			      	    }
			      	}
			      	
			      	//---------
			      	
			      	if(hayElementosNoNulos) {
			      		int i=1;
				      	for (ArrayList<Cita> lista : citas_seleccionadas) {
				      	    if (lista != null) {
				      	    	println(i);
				      	        for (Cita cita: lista) {
				      	        	println(cita);
				      	        }
				      	    }
				      	    i++;
				      	}
				     		
			      		//CREAR EL SERVICIO
			      		Servicio nuevo_servicio = new Servicio(mascota_3,cliente_3,eleccion_empleado_3,"Peluquería",citas_seleccionadas); 
			      		servicios.add(nuevo_servicio);
			      		
			      		println(nuevo_servicio.getCliente());
			      	    	    
				}
		    	
				}while(servicioCero_3.equalsIgnoreCase("si"));
				
	    	    break;
	    	    
	    	    	
	    }
	   
	   //VERIFICAR SI SE AGENDÓ SIGUIERA UN SERVICIO
	   
	   
//        if (servicios.size()!=0) {
		   	   
		   //VERIFICAR SI EL USUARIO YA EXISTE
//		   Cliente cliente_existe = CentroAdopcion.isCliente(servicios.get(0).getCliente().getCedula());   
//		                                                                                       
//		   if (cliente_existe!=null) {
//			   
//			   //SI EXISTE ENTONCES SE ACTUALIZAN SUS DATOS
//			   cliente_existe.setEdad(servicios.get(0).getCliente().getEdad()); //ACTUALIZAR LA EDAD
//			   
//			   for (Servicio citas_servicios: servicios) {			   
//				   citas_servicios.setCliente(cliente_existe);	
//			   }  
//		   }
//		   
//		   //ANEXAR PUNTOS AL CLIENTE POR CADA CITA
//		   for (Servicio citas_servicios: servicios) {			   
//			   citas_servicios.anexo_puntos();  //ANEXAR PUNTOS POR CADA CITA
//		   }
//		   
//		   println("Le recordamos que por cada cita agendada usted recibe 5 puntos, que luego los podrá utilizar para descuentos.");
//		   println("- +100 puntos = 30% de descuento\n- +60 puntos = 20% de descuento\n- +30 puntos = 10% de descuento\n");
//		   
//		   println("En estos momentos usted cuenta con " + servicios.get(0).getCliente().getPuntos() + " puntos.");
//		   
//		   int puntos_disponibles=0;
//		   		   
//		  if(servicios.get(0).getCliente().getPuntos()>=30){
//			  println("¿Desea utilzar los puntos que tiene disponibles?");
//              String res;
//              
//              do {
//              	print("Responda si/no: ");
//               res= readString();
//
//               if (res.equalsIgnoreCase("si")==false && res.equalsIgnoreCase("no")==false) {
//            	   println("Proporcione una respuesta válida"); 
//               }
//              }while(res.equalsIgnoreCase("si")==false && res.equalsIgnoreCase("no")==false);
//              
//              if (res.equalsIgnoreCase("si")) {
//              	puntos_disponibles=1;	                	
//              	}
//		  }
//		  
//		  //CALCULAR EL COSTO POR CADA SERVICIO
//		  
//		  double valor_total=0;
//		  double descuento=0;
//		  double valor_pagar=0;
//		  
//		   for (Servicio servicio_individual: servicios) {	
//			   
//			   servicio_individual.setCosto(servicio_individual.monto_pagar(servicio)); //COSTO DEL SERVICIO
//			   
//			   valor_total+= servicio_individual.monto_pagar(servicio); //ACUMULAR EN ESTA VARIABLE
//			   
//		   }
//		 
//		   
//		   if (puntos_disponibles==1) {
//			   
//			   descuento= Servicio.descuento(valor_total,servicios.get(0).getCliente()); //DESCUENTO POR PUNTOS
//			   
//		   }
//		   
//		   valor_pagar=(valor_total- descuento); //COSTO CON DESCUENTOS
//		   
//		   imprimir_factura(servicios,valor_total,descuento,valor_pagar);
//		   	  	   	   
//		   
//		}
//	   else {
//		   println("\nNo se agendó ninguta cita, sin embargo, esperamos que haya sido una experiencia agradable con AdoptaLove, ¡vuelva pronto!");
//	   } 
	}
	
	
	public static void imprimir_factura(ArrayList<Servicio> servicios, double valor_total, double descuento, double valor_pagar) {
		
		int i=1;
		println("\n---------- FACTURA-------------");
		for (Servicio servicio_mascota: servicios) {
			println("\n     AGENDA "+ i );
			println("Nombre_Mascota: " + servicio_mascota.getAnimal().getNombre());
			println("Nombre_usuario: " + servicio_mascota.getCliente().getNombre());
			println(("Nombre_Empleado: "+ servicio_mascota.getEmpleado().getNombre()));
			println("Servicio: " + servicio_mascota.getTipoServicio());
			println("      CITAS");
			mostrar_citas(servicio_mascota.citas());
			println("---------------\nCosto: " + servicio_mascota.getCosto() );
			
			i++;

		}
		println("\nValor total: $"+ valor_total);
		println("Descuento por puntos: $"+ descuento);
		println("Valor a cancelar: $"+ valor_pagar + "\n----------------------");
	}
	
	public static void mostrar_citas(ArrayList<Cita>[] citas_seleccionadas) {
		
		int i=1;
		for (ArrayList<Cita> citas_dia: citas_seleccionadas) {
			if (citas_dia!=null) {
				
			switch(i){
				case 1:
					println("LUNES");
					break;
				case 2:
					println("MARTES");
					break;
				case 3:
					println("MIERCOLES");
					break;
				case 4:
					println("JUEVES");
					break;
				case 5:
					println("VIERBES");
					break;
				case 6:
					println("SABADO");
					break;			
			}
			
			for (Cita cita: citas_dia) {
				println(cita);
			}
			
		}
			i++;
		}
	}
    
	
	
	//----------------------------
	public static void mostrarEmpleados(int sede) {
        int i = 1;
        for(Empleado cuidador : sedes.get(sede).getEmpleados()) {
                println(i +" - "+ cuidador);
                i++;
        }
	}
	
	//----------------------------
	
	public static int escogerServicio() {
		int opcion=0; 	
        println("\nLe recordamos que cada sede de AdoptaLove ofrece un servicio diferente para las mascotas, seleccione según sea su necesidad. \n¿Qué servicio desea agendar?");
        println("\n1. SEDE 1 - Servicio: Guarderia \n2. SEDE 2 - Servicio: Veterinaria \n3. SEDE 3 - Servicio: Peluquería\n");
        do {
            print("Ingrese su elección dentro del rango [1-3]: ");
            try {
            	opcion = readInt();
            	if (opcion < 1 || opcion > 3) {
                println("Opción fuera de rango.");
                }
            } catch (InputMismatchException e) {
            	println("Se ha ingresado un tipo de dato incorrecto.");
            }finally {
            	readString();
            	}
            } while (opcion < 1 || opcion > 3);
        
        return opcion - 1;
	}
	
	//------------------------------
	
	public static int escogerEmpleado(int servicio) {
		
		ArrayList<Empleado> listaEmpleados = sedes.get(servicio).getEmpleados(); 
		int num_empleado=0;
		
		switch(servicio) {
		
		case 0:
			println("\nContamos con los siguientes cuidadores de mascotas, seleccione el de su preferencia:\n");
	    	break;
	    	
		case 1:
			println("\nContamos con los siguientes veterinarios, seleccione el de su preferencia:\n");
	    	break;
	    	
		case 2:
			println("\nContamos con los siguientes peluqueros de mascotas, seleccione el de su preferencia:\n");
	    	break;	
		}
		
	 	do {
    		print("Ingrese su elección dentro del rango [1-"+listaEmpleados.size() + "]: " );
    		try {
    			num_empleado= readInt();
    			
    			if (num_empleado<1 || num_empleado>listaEmpleados.size()) {
    				println("Opción fuera de rango.\n");
    			}
    			
    		}catch(InputMismatchException e) {
    			println("Se ha ingresado un tipo de dato incorrecto.\n");
    		}finally {
    			readString();
    		}
    	}while(num_empleado<1 || num_empleado>listaEmpleados.size());
	 	
	 	return num_empleado - 1;
	}
	
	//----------------------------
	
	public static int escogerDia() {
		
		println("\nSeleccione el día en el que desea el servicio.");
		String[] diasSemana = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"};
	    int num_dia=0;
	    for (int i = 0; i <diasSemana.length; i++) {
	    	println((i + 1) + ". " + diasSemana[i]);
	    	}
	    
	    do {
	    	try {
	    		print("Ingrese su elección dentro del rango [1-6]: ");
	    		num_dia = readInt();
	    		if (num_dia<1 || num_dia>6) {
	    			println("Opción fuera de rango.\n");
	    			
	    			}
	    		}catch(InputMismatchException e) {
	    			println("Se ha ingresado un tipo de dato incorrecto.\n");
	    			readString();
	    			}
	    	}while(num_dia<1 || num_dia>6);
	    
	    return num_dia-1;
	}
	
	//--------------------------------------------
	
	public static int promtCupos_Completos(int cupos) {
		int num_cita= -1;
		println((cupos +1)+". Agendar día completo.");
		println("0. No agendar este dia");
		do {
			try {
				print("\nIngrese su elección dentro del rango [0-" + (cupos+1)+"]: " );
		        num_cita=readInt();
		        
		        if (num_cita<0|| num_cita>(cupos +1)) {
		        	println("Opción fuera de rango.");
		        }
		        }catch(InputMismatchException e) {
		        	println("Se ha ingresado un tipo de dato incorrecto.");
		        	readString();
		        	}
			}while(num_cita<0 || num_cita> (cupos +1));
		
		return num_cita;	
	}
	
	//--------------------------------------
	
	public static int promtCupos (int cupos) {
		
		int num_cita=-1;
		println("0. No agendar este día.");
		do {
			try {
				print("\nIngrese su elección dentro del rango [0-" +cupos +"]: ");
		        num_cita=readInt();
		        
		        if (num_cita<0 || num_cita>cupos) {
		        	println("Opción fuera de rango.");
		        }
		        }catch(InputMismatchException e) {
		        	println("Se ha ingresado un tipo de dato incorrecto.");
		        	}
			}while(num_cita<0 || num_cita>cupos);
		
		return num_cita;
	}
	
	public static int escogerNum_Cita (int cupos, String mismoUsuario, Empleado empleado,String eleccionDia) {
		
		int num_cita=-1;
		
		if (cupos== empleado.obtenerCitas(eleccionDia).size()) {			
			num_cita= promtCupos_Completos(cupos);		
		}
		else {
			if (mismoUsuario.equalsIgnoreCase("si")) {
				num_cita= promtCupos_Completos(cupos);
			}
			else {
				num_cita= promtCupos(cupos);
			}
		}
		
		return num_cita;
	}
	
	public static Animal datos_mascota(int servicio) {
		
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
	
	//--------------------
	public static Cliente datos_cliente() {
		
		println("Antes de continuar, le informamos que para hacer uso del servicio la persona encargada de la mascota debe ser mayor de edad.\n");
		
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
	
	
}

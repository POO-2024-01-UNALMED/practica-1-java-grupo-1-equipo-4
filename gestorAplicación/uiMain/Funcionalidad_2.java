package gestorAplicación.uiMain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import gestorAplicación.procesoAdopcion.*;

import gestorAplicación.servicioAdicional.*;
import gestorAplicación.servicioAdicional.Empleado.Rol;


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
		
		Map <String,ArrayList<Cita>> citasseleccionadas=new HashMap<>();//SE GUARDA EL DIA Y EN UN ARRAY LAS CITAS QUE SE ELIJAN EN ESE DÍA.
		String mismoUsuario="no";
		
		int servicio = escogerServicio();  //ELECCIÓN DEL SERVICIO Y SEDE.
	        
	   switch (servicio+1) {
	   
	   //CASO GUARDERÍA.
	    case 1:
	    	// citasseleccionadas = new HashMap<>(); //SE GUARDA EL DIA Y EN UN ARRAY LAS CITAS QUE SE ELIJAN EN ESE DÍA.	
	    	 
	    	//ELECCIÓN DEL EMPLEADO
	    	println("\nPara el servicio de guarderia se manejan los siguientes precios:\nValor por cupo: 10.000 pesos\nValor por día completo: 50.000 pesos"); 
	    	
	    	String servicioCero="ok";
	    	
	    //	do {
	    		int num_empleado= escogerEmpleado(servicio);
	    		
	    		Empleado eleccionEmpleado =sedes.get(servicio).getEmpleados().get(num_empleado); //CUIDADOR SELECCIONADO.
	    	    println("Cuidador seleccionado: " + eleccionEmpleado.getNombre());
	    	
	    	//---------------------
	    	
	    	//ELECCIÓN DEL DIA DEL SERVICIO
	    	String mismoCuidador="ok"; 
	    	ArrayList <Cita> citaseleccion;
	    	
	      	do {
	      		 citaseleccion = new ArrayList<>();
		 		 String[] diasSemana = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"};
		         int num_dia=escogerDia();
	      	    	    
	    	    String eleccionDia = diasSemana[num_dia]; //DIA SELECCIONADO
	    	    println("Dia seleccionado: "+ eleccionDia);
	    	    
	    	    //SELECCIÓN DEL HORARIO
	    	    String mismoDia="ok";
	    	    do {    
	    	    if (eleccionEmpleado.cuposDisponibles(eleccionDia)) {
	    	    	
	    	    	println("\nSeleccione el horario en el que desea el servicio.");
	    	    	println("Cupos para el día " + eleccionDia + ":");
	    	    	int i =1;
	    	    	int cupos=0;
	    	    	ArrayList<Cita> citasDisponibles= new ArrayList<Cita>(); //ARREGLO DONDE SE GUARDAN
	    	    	                                                         //LAS CITAS DISPONIBLES	    	    		    	    	
	    	    	//MOSTRAR LAS CITAS DISPONIBLES DEL DIA SELECCIONADO.
	    	    	for (Cita cita : eleccionEmpleado.obtenerCitas(eleccionDia)) {
	    	    		if (cita.getDisponibilidad()==true) {
	    	    			citasDisponibles.add(cita);
	    	    			println(i +". De " + cita.getHoraInicio() + " a " + cita.getHoraFin() );
	    	    			cupos++;
	    	    			i++;
	    	    			}else {
	    	    				println(cita.getHoraInicio() + " a " + cita.getHoraFin() + " - Ocupado");
	    	    				}
	    	    		}	    	    	
	    	    	//----------------------------
	    	    	
	    	    	//ELECCIÓN DEL HORARIO
	    	    	int num_cita= escogerNum_Cita(cupos,mismoUsuario, eleccionEmpleado, eleccionDia);
	    	    	
	            	
	            	if(num_cita== (cupos+1)) {
	            		for(Cita cita: eleccionEmpleado.obtenerCitas(eleccionDia)) {
	            			citaseleccion.add(cita);
	            			cita.setDisponibilidad(false);
	            		}
	            		citasseleccionadas.put(eleccionDia, citaseleccion); //AGREGAR TODAS LA CITAS A SELECCIONADAS
	            		println("Ha agentado el día "+ eleccionDia + " completo.");
	            		mismoDia="no"; //SALIR DEL BUBLE DEL MISMO DÍA.
	            		entrada.nextLine();
	            		println("¿Desea agendar otra cita en un día diferente?: ");
	            		String respuesta="ok";             
     	                do {
     	                	print("Responda si/no: ");
     	                	respuesta = readString();
     	                	
     	                	if (respuesta.equalsIgnoreCase("si")) {
     	                		mismoCuidador="si";
     	                		mismoUsuario="si";
     	                	}
     	                	else {
     	                		mismoCuidador="no";
     	                		servicioCero="no";
     	                	}
     	                }while(respuesta.equalsIgnoreCase("si")==false && respuesta.equalsIgnoreCase("no")==false);
     	                                
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
	     	                	
	     	                	if (respuesta.equalsIgnoreCase("si")) {
	     	                		mismoCuidador="si"; //PARA QUE VUELVA A ELIGIR UN DÍA.
	     	                		mismoUsuario="si";
	     	                	}
	     	                	else {
	     	                		mismoCuidador="no";
	     	                		servicioCero="no";
	     	                		
	     	                	}
	     	                }while(respuesta.equalsIgnoreCase("si")==false && respuesta.equalsIgnoreCase("no")==false);

	            			
	            		}else {		
	            			String dia_ya_seleccionado="no";      
	            			for (String dia: citasseleccionadas.keySet()) {
	            				if (dia.equalsIgnoreCase(eleccionDia)) {
	            					dia_ya_seleccionado="si";
	            				}            				
	            			}
	            			
	            			if(dia_ya_seleccionado.equalsIgnoreCase("si")) {
	            				
	            				ArrayList <Cita> citas_yaseleccionadas = citasseleccionadas.get(eleccionDia);            				
	            				citas_yaseleccionadas.add(citasDisponibles.get(num_cita-1));
	            				citasseleccionadas.put(eleccionDia, citas_yaseleccionadas);	
	            				citasDisponibles.get(num_cita-1).setDisponibilidad(false);
	            			}
	            			
	            			else {
	          		
	            			citaseleccion.add(citasDisponibles.get(num_cita-1));
	            		    citasseleccionadas.put(eleccionDia, citaseleccion);
	            		    citasDisponibles.get(num_cita-1).setDisponibilidad(false);
	            			}
	            			
	            		    println("¿Desea agendar otra cita en la misma fecha?");
	            		    readString();
  	                        String respuesta;
  	                        do {
  	                        	print("Responda si/no: ");
  	                        	respuesta=readString();
  	                        }while(respuesta.equalsIgnoreCase("si")==false && respuesta.equalsIgnoreCase("no")==false);
  	                        
  	                        if (respuesta.equalsIgnoreCase("si")) {
  	                          mismoDia="si";
  	                          mismoUsuario="si";
  	                	    }
  	                        else {
  	                        	mismoDia="no";
  	                        	println("¿Desea agendar otra cita en un día diferente?");
  	  	                        String respuest;
  	  	                    do {
  	                        	print("Responda si/no: ");
  	                        	respuest=readString();	                        	
  	                        }while(respuest.equalsIgnoreCase("si")==false && respuest.equalsIgnoreCase("no")==false);
  	  	                                           
  	  	                        if (respuest.equalsIgnoreCase("si")) {
  	  	                          mismoCuidador="si";
  	  	                          mismoUsuario="si";
  	  	                        }else {
  	  	                        	mismoCuidador="no";
  	  	                        	servicioCero="no";
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
	                }while(respuesta.equalsIgnoreCase("si")==false && respuesta.equalsIgnoreCase("no")==false);
	                
	                if (respuesta.equalsIgnoreCase("si")) {
	                	mismoCuidador="si"; //PARA QUE VUELVA A ELEGIR EL DIA
	                	}
	                else {
	                	mismoCuidador="no"; //SALIR DEL BUCLE DEL MISMO CUIDADOR
	                }
	             }
	    	    
	    	  }while(mismoDia.equalsIgnoreCase("si")==true);
	    	    
	    	}while(mismoCuidador.equalsIgnoreCase("si")==true);
	      	      	
	         //  }while(servicioCero.equalsIgnoreCase("si")==true);
	    	
	      	break;
	      	
	    case 2:
	    	 
	    	//ELECCIÓN DEL EMPLEADO
	    	println("\nPara el servicio de veterinaria se manejan los siguientes precios:\nValor por cita: 20.000 pesos."); 
	    	int numEmpleado= escogerEmpleado(servicio);
    		
    		Empleado eleccion_Empleado=sedes.get(servicio).getEmpleados().get(numEmpleado); //VETERINARIO SELECCIONADO.
    	    println("Veterinario seleccionado: " + eleccion_Empleado.getNombre());
    	    
    	    //-------------------------------
    	    
    	  //ELECCIÓN DEL DIA DEL SERVICIO
	    	String mismoVeterinario="ok"; 
	    	ArrayList <Cita> citaseleccion_2;
	    	
	    	do {	
	    		citaseleccion_2 = new ArrayList<>();
		 		String[] diasSemana = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"};
		        int num_dia=escogerDia();
	      	    	    
	    	    String eleccionDia = diasSemana[num_dia]; //DIA SELECCIONADO
	    	    println("Dia seleccionado: "+ eleccionDia);
	    	    
	    	    //SELECCIÓN DEL HORARIO
	    	    String mismoDia="ok";	    	    
	    	    do {
	    	    	
	    	    	if (eleccion_Empleado.cuposDisponibles(eleccionDia)) {
	    	    		println("\nSeleccione el horario en el que desea el servicio de veterinaria.");
		    	    	println("Citas para el día " + eleccionDia + ":");
		    	    	int i =1;
		    	    	int cupos=0;
		    	    	ArrayList<Cita> citasDisponibles= new ArrayList<Cita>(); //ARREGLO DONDE SE GUARDAN
		    	    	                                                         //LAS CITAS DISPONIBLES	    	    		    	    	
		    	    	//MOSTRAR LAS CITAS DISPONIBLES DEL DIA SELECCIONADO.
		    	    	for (Cita cita : eleccion_Empleado.obtenerCitas(eleccionDia)) {
		    	    		if (cita.getDisponibilidad()==true) {
		    	    			citasDisponibles.add(cita);
		    	    			println(i +". De " + cita.getHoraInicio() + " a " + cita.getHoraFin() );
		    	    			cupos++;
		    	    			i++;
		    	    			}else {
		    	    				println(cita.getHoraInicio() + " a " + cita.getHoraFin() + " - Ocupado");
		    	    				}
		    	    		}
		    	    	
		    	    	int num_cita= escogerNum_Cita(cupos,mismoUsuario, eleccion_Empleado, eleccionDia);
		    	    	
		            	if(num_cita== (cupos+1)) {
		            		for(Cita cita: eleccion_Empleado.obtenerCitas(eleccionDia)) {
		            			citaseleccion_2.add(cita);
		            			cita.setDisponibilidad(false);
		            		}
		            		citasseleccionadas.put(eleccionDia, citaseleccion_2); //AGREGAR TODAS LA CITAS A SELECCIONADAS
		            		println("Ha agentado el día "+ eleccionDia + " completo.");
		            		mismoDia="no"; //SALIR DEL BUBLE DEL MISMO DÍA.
		            	
		            		println("¿Desea agendar otra cita en un día diferente?");
		            		entrada.nextLine();
		            		String respuesta="ok";             
	     	                do {
	     	                	print("Responda si/no: ");
	     	                	respuesta = readString();
	     	                	
	     	                	if (respuesta.equalsIgnoreCase("si")) {
	     	                		mismoVeterinario="si";
	     	                		mismoUsuario="si";
	     	                	}
	     	                	else {
	     	                		mismoVeterinario="no";
	     	                		servicioCero="no";
	     	                	}
	     	                }while(respuesta.equalsIgnoreCase("si")==false && respuesta.equalsIgnoreCase("no")==false);
	     	                                
	     	            }
		            	else {
		            		if(num_cita==0) {
		            			mismoDia="no"; //SALIR DEL BLOQUE DEL MISMO DIA.
		            			String respuesta;
		            			println("¿Desea intentar agendar cita en un día diferente?..");
		     	                entrada.nextLine();            
		     	               do {
		     	                	print("Responda si/no: ");
		     	                	respuesta = readString();
		     	                	
		     	                	if (respuesta.equalsIgnoreCase("si")) {
		     	                		mismoVeterinario="si"; //PARA QUE VUELVA A ELIGIR UN DÍA.
		     	                		mismoUsuario="si";
		     	                	}
		     	                	else {
		     	                		mismoVeterinario="no";
		     	               	                		
		     	                	}
		     	                }while(respuesta.equalsIgnoreCase("si")==false && respuesta.equalsIgnoreCase("no")==false);

		            			
		            		}else {		
		            			String dia_ya_seleccionado="no";
		      
		            			for (String dia: citasseleccionadas.keySet()) {
		            				if (dia.equalsIgnoreCase(eleccionDia)) {
		            					dia_ya_seleccionado="si";
		            				}            				
		            			}
		            			
		            			if(dia_ya_seleccionado.equalsIgnoreCase("si")) {
		            				
		            				ArrayList <Cita> citas_yaseleccionadas = citasseleccionadas.get(eleccionDia);            				
		            				citas_yaseleccionadas.add(citasDisponibles.get(num_cita-1));
		            				citasseleccionadas.put(eleccionDia, citas_yaseleccionadas);	
		            				citasDisponibles.get(num_cita-1).setDisponibilidad(false);
		            			}
		            			
		            			else {
		          		
		            			citaseleccion_2.add(citasDisponibles.get(num_cita-1));
		            		    citasseleccionadas.put(eleccionDia, citaseleccion_2);
		            		    citasDisponibles.get(num_cita-1).setDisponibilidad(false);
		            			}
		            			
		            		    println("¿Desea agendar otra cita en la misma fecha?");
		            	     	entrada.nextLine();
	  	                        String respuesta;
	  	                        do {
	  	                        	print("Responda si/no: ");
	  	                        	respuesta = readString();
	  	                        }while(respuesta.equalsIgnoreCase("si")==false && respuesta.equalsIgnoreCase("no")==false);
	  	                        
	  	                        if (respuesta.equalsIgnoreCase("si")) {
	  	                          mismoDia="si";
	  	                          mismoUsuario="si";
	  	                	    }
	  	                        else {
	  	                        	mismoDia="no";
	  	                        	println("¿Desea intentar agendar otra cita en un día diferente?");
	  	  	                        String respuest;
	  	  	                        do {
	  	  	                        	print("Responda si/no: ");
	  	  	                        	respuest= readString();
	  	  	                        }while(respuesta.equalsIgnoreCase("si")==false && respuesta.equalsIgnoreCase("no")==false);
	  	  	                        
	  	  	                        if (respuest.equalsIgnoreCase("si")) {
	  	  	                          mismoVeterinario="si";
	  	  	                          mismoUsuario="si";
	  	  	                        }else {
	  	  	                        	mismoVeterinario="no";
	  	  	                        
	  	  	                        }               
	  	  	                   }
	  	                  }
		              }
		            	
		          }
		    	    else {
		    	    	println("\nNo hay cupos disponibles para el día " + eleccionDia + ".");
		    	    	mismoDia="no"; //SALIR DE BUCLE DEL MISMO DÍA.
		    	    	
		                print("¿Desea agendar cita en un día diferente?:");
		                readString();
		                String respuesta;
		                do {
		                print("Responda si/no: ");
		                respuesta = readString();
		                }while(respuesta.equalsIgnoreCase("si")==false && respuesta.equalsIgnoreCase("no")==false);
		                
		                if (respuesta.equalsIgnoreCase("si")) {
		                	mismoVeterinario="si"; //PARA QUE VUELVA A ELEGIR EL DIA
		                	}
		                else {
		                	mismoVeterinario="no"; //SALIR DEL BUCLE DEL MISMO CUIDADOR
		                }
		             }
	    	    		 	    	
	    	    }while(mismoDia.equalsIgnoreCase("si"));
	    		
	    	}while(mismoVeterinario.equalsIgnoreCase("si"));   	    
    	    break;
    	    
	    case 3:
		    	//ELECCIÓN DEL EMPLEADO
		    	println("\nPara el servicio de peluquería se manejan los siguientes precios:\nValor por corte: 15.000 pesos."); 
		    	int num_Empleado= escogerEmpleado(servicio);
	    		
	    		Empleado eleccion_empleado=sedes.get(servicio).getEmpleados().get(num_Empleado); //PELUQUERO SELECCIONADO.
	    	    println("Peluquero seleccionado: " + eleccion_empleado.getNombre());
	    	    
	      	  //ELECCIÓN DEL DIA DEL SERVICIO
		    	String mismoPeluquero="ok"; 
		    	ArrayList <Cita> citaseleccion_3;
		    	
		    	do {	
		    		citaseleccion_3 = new ArrayList<>();
			 		String[] diasSemana = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"};
			        int num_dia=escogerDia();
		      	    	    
		    	    String eleccionDia = diasSemana[num_dia]; //DIA SELECCIONADO
		    	    println("Dia seleccionado: "+ eleccionDia);
		    	    
		    	    //SELECCIÓN DEL HORARIO
		    	    String mismoDia="ok";	    	    
		    	    do {
		    	    	
		    	    	if (eleccion_empleado.cuposDisponibles(eleccionDia)) {
		    	    		println("\nSeleccione el horario en el que desea el servicio de veterinaria.");
			    	    	println("Citas para el día " + eleccionDia + ":");
			    	    	int i =1;
			    	    	int cupos=0;
			    	    	ArrayList<Cita> citasDisponibles= new ArrayList<Cita>(); //ARREGLO DONDE SE GUARDAN
			    	    	                                                         //LAS CITAS DISPONIBLES	    	    		    	    	
			    	    	//MOSTRAR LAS CITAS DISPONIBLES DEL DIA SELECCIONADO.
			    	    	for (Cita cita : eleccion_empleado.obtenerCitas(eleccionDia)) {
			    	    		if (cita.getDisponibilidad()==true) {
			    	    			citasDisponibles.add(cita);
			    	    			println(i +". De " + cita.getHoraInicio() + " a " + cita.getHoraFin() );
			    	    			cupos++;
			    	    			i++;
			    	    			}else {
			    	    				println(cita.getHoraInicio() + " a " + cita.getHoraFin() + " - Ocupado");
			    	    				}
			    	    		}
			    	    	
			    	    	int num_cita= escogerNum_Cita(cupos,mismoUsuario, eleccion_empleado, eleccionDia);
			    	    	
			            	if(num_cita== (cupos+1)) {
			            		for(Cita cita: eleccion_empleado.obtenerCitas(eleccionDia)) {
			            			citaseleccion_3.add(cita);
			            			cita.setDisponibilidad(false);
			            		}
			            		citasseleccionadas.put(eleccionDia, citaseleccion_3); //AGREGAR TODAS LA CITAS A SELECCIONADAS
			            		println("Ha agentado el día "+ eleccionDia + " completo.");
			            		mismoDia="no"; //SALIR DEL BUBLE DEL MISMO DÍA.
			            		entrada.nextLine();
			            		println("¿Desea agendar otra cita en un día diferente?: ");
			            		String respuesta="ok";             
		     	                do {
		     	                	print("Responda si/no: ");
		     	                	respuesta = readString();
		     	                	
		     	                	if (respuesta.equalsIgnoreCase("si")) {
		     	                		mismoPeluquero="si";
		     	                		mismoUsuario="si";
		     	                	}
		     	                	else {
		     	                		mismoPeluquero="no";
		     	                		servicioCero="no";
		     	                	}
		     	                }while(respuesta.equalsIgnoreCase("si")==false && respuesta.equalsIgnoreCase("no")==false);
		     	                                
		     	            }
			            	else {
			            		if(num_cita==0) {
			            			mismoDia="no"; //SALIR DEL BLOQUE DEL MISMO DIA.
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
			     	                		servicioCero="no";
			     	                		
			     	                	}
			     	                }while(respuesta.equalsIgnoreCase("si")==false && respuesta.equalsIgnoreCase("no")==false);

			            			
			            		}else {		
			            			String dia_ya_seleccionado="no";
			      
			            			for (String dia: citasseleccionadas.keySet()) {
			            				if (dia.equalsIgnoreCase(eleccionDia)) {
			            					dia_ya_seleccionado="si";
			            				}            				
			            			}
			            			
			            			if(dia_ya_seleccionado.equalsIgnoreCase("si")) {
			            				
			            				ArrayList <Cita> citas_yaseleccionadas = citasseleccionadas.get(eleccionDia);            				
			            				citas_yaseleccionadas.add(citasDisponibles.get(num_cita-1));
			            				citasseleccionadas.put(eleccionDia, citas_yaseleccionadas);	
			            				citasDisponibles.get(num_cita-1).setDisponibilidad(false);
			            			}
			            			
			            			else {
			          		
			            			citaseleccion_3.add(citasDisponibles.get(num_cita-1));
			            		    citasseleccionadas.put(eleccionDia, citaseleccion_3);
			            		    citasDisponibles.get(num_cita-1).setDisponibilidad(false);
			            			}
			            			
			            		    println("¿Desea agendar otra cita en la misma fecha?");		
			            		    readString();
		  	                        String respuesta;
		  	                        do {
		  	                        	 print("Responda si/no: "); 
		  	                        	 respuesta=readString();
		  	                         }while(respuesta.equalsIgnoreCase("si")==false && respuesta.equalsIgnoreCase("no")==false);
		  	                        
		  	                        if (respuesta.equalsIgnoreCase("si")) {
		  	                          mismoDia="si";
		  	                          mismoUsuario="si";
		  	                	    }
		  	                        else {
		  	                        	mismoDia="no";
		  	                        	println("¿Desea intentar agendar otra cita en un día diferente?");
		  	  	                        String respuest;
		  	  	                        do {
		  	  	                        	print("Responda si/no: ");
		  	  	                        	respuest=readString();
		  	  	                        }while(respuest.equalsIgnoreCase("si")==false && respuest.equalsIgnoreCase("no")==false);
		  	  	                        
		  	  	                        if (respuest.equalsIgnoreCase("si")) {
		  	  	                          mismoPeluquero="si";
		  	  	                          mismoUsuario="si";
		  	  	                        }else {
		  	  	                        	mismoPeluquero="no";
		  	  	                        
		  	  	                        }               
		  	  	                   }
		  	                  }
			              }
			            	
			          }
			    	    else {
			    	    	println("\nNo hay cupos disponibles para el día " + eleccionDia + ".");
			    	    	mismoDia="no"; //SALIR DE BUCLE DEL MISMO DÍA.
			    	    	
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
		    	    		 	    	
		    	    }while(mismoDia.equalsIgnoreCase("si"));
		    		
		    	}while(mismoPeluquero.equalsIgnoreCase("si"));
	    	    
	    	    break;
	    	    	
	    }
	  
   	int cuantas=0;
   	println("\n------------------- Citas agendadas -------------------- ");
     	for (String dia: citasseleccionadas.keySet()) {
     		if (dia!= null){
     			cuantas++;
     			println("\n" + dia);
     			for (Cita cita: citasseleccionadas.get(dia)) { //PROBANDO
     			println(cita);
     			}
     		}
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
			println("\nContamos con los siguientes cuidadores de mascotas:\n");
	    	mostrarEmpleados(servicio);    //MÉTODO PARA MOSTRAR LOS EMPLEADOS
	    	println("\nproporcione el número del cuidador que desea seleccionar.");
	    	break;
	    	
		case 1:
			println("\nContamos con los siguientes veterinarios:\n");
	    	mostrarEmpleados(servicio);    //MÉTODO PARA MOSTRAR LOS EMPLEADOS
	    	println("\nproporcione el número del veterinario que desea seleccionar.");
	    	break;
	    	
		case 2:
			println("\nContamos con los siguientes peluqueros de mascotas:\n");
	    	mostrarEmpleados(servicio);    //MÉTODO PARA MOSTRAR LOS EMPLEADOS
	    	println("\nproporcione el número del peluquero que desea seleccionar.");
	    	break;	
		}
		
	 	do {
    		print("Ingrese su elección dentro del rango [1-"+listaEmpleados.size() + "]: " );
    		try {
    			num_empleado= readInt();
    			
    			if (num_empleado<1 || num_empleado>listaEmpleados.size()) {
    				println("Opción fuera de rango.");
    			}
    			
    		}catch(InputMismatchException e) {
    			println("Se ha ingresado un tipo de dato incorrecto.");
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
	    			println("Opción fuera de rango.");
	    			}
	    		}catch(InputMismatchException e) {
	    			println("Se ha ingresado un tipo de dato incorrecto.");
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
	
	
}

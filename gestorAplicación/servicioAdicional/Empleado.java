package gestorAplicación.servicioAdicional;

import gestorAplicación.procesoAdopcion.Adopcion;
import  gestorAplicación.procesoAdopcion.Persona;


import gestorAplicación.servicioAdicional.Empleado.Rol;
import gestorAplicación.servicioAdicional.Cita;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Empleado extends Persona implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	//ATRIBUTOS
    private Rol profesion; 
    
    public static enum Rol {
        VETERINARIO,PELUQUERO,CUIDADOR,TENDERO;
    }
    
    ArrayList<ArrayList<Cupo>> agenda_dias = new ArrayList<>();
    
    //CONSTRUCTOR
    
    
    public Empleado( String nombre,int edad, long cedula,long telefono, String direccion,Rol profesion) {
    	super (nombre,edad,cedula,telefono,direccion);
        this.profesion = profesion;
        
        if (profesion!= Rol.TENDERO) { //EL TENDERO NO OFRCE CITAS.
        	this.llenar_agenda();
        }
        	
        
    }
    
    
    //MÉTODOS
    
    


	public Empleado() {
		// TODO Auto-generated constructor stub
	}


	private void llenar_agenda() {
    	
    	//CANTIDAD DE CICLOS, DEPENDIENDO EL DIA.
    	int [] ciclos = {6,5,4,3,2,1};
    	
    	LocalDate fechaActual = LocalDate.now();
    	
    	int dia_semana = fechaActual.getDayOfWeek().getValue();//NUMERO DEL DIA DE LA SEMANA.
    	
    	//LLENAR LOS DÍAS RESTANTES DE LA SEMANA:
    	
        //CUANDO ES DOMINGO, SE HABILITAN LOS CUPOS DEL LUNES SIGUIENTE HASTA EL SÁBADO.
    	if (dia_semana==7) {
    		
    		fechaActual = fechaActual.plusDays(1); //PARA OMITIR EL DOMINGO
    		
    		int j=0; 		
    		while(j < 6) {
    			
    			ArrayList<Cupo> cupos_dia= new ArrayList<>();
    			
	    		cupos_dia.add(new Cupo(fechaActual, "8:00","10:00", true));
	    		cupos_dia.add(new Cupo(fechaActual, "10:00","12:00", true));
	    		cupos_dia.add(new Cupo(fechaActual, "14:00","16:00", true));
	    		cupos_dia.add(new Cupo(fechaActual, "16:00","18:00", true));
	    		
	    		j++;
	    		
	    		this.agenda_dias.add(cupos_dia);
	    		fechaActual = fechaActual.plusDays(1);//PASAR AL SIGUIENTE DÍA.
    		}	
    	}
    	else {
    		
    	//CUANDO ES UN DÍA DEFERENTE AL DOMINGO, SE HABILITAN LOS CUPOS DE LOS DIAS RESTANTES DE LA SEMANA:
    	int i=0;
    	while ( i < ciclos[dia_semana-1]) {
    		
    		ArrayList<Cupo> cupos_dia= new ArrayList<>();
	
    		cupos_dia.add(new Cupo(fechaActual, "8:00","10:00", true));
    		cupos_dia.add(new Cupo(fechaActual, "10:00","12:00", true));
    		cupos_dia.add(new Cupo(fechaActual, "14:00","16:00", true));
    		cupos_dia.add(new Cupo(fechaActual, "16:00","18:00", true));
    		
    		i++;
    		
    		this.agenda_dias.add(cupos_dia);
    		
    		fechaActual = fechaActual.plusDays(1);//PASAR AL SIGUIENTE DÍA.
    		//DEJA LA FECHA HASTA EL DOMINGO
    	}
    	
    	//-----------------------------------------------
    	
    	//LLENAR LOS DIAS QUE FALTARON, ES DECIR LOS ANTERIORES, PERO PARA LA SIGUIENTE SEMANA LA OTRA SEMANA
    	
    	if (dia_semana != 1 && dia_semana!=7) { //COMO EL DOMINGO Y EL LUNES HABILITAN TODOS LOS DÍAS DE LA SEMANA
    		                                    //ENTONCES NO ES NECESARIO QUE ESTÉN AQUÍ.
    		
    		fechaActual = fechaActual.plusDays(1); //OMITIR EL DOMINGO
    		
    		int j=0;  		
    		while(j < (dia_semana-1)){
    			
	    		ArrayList<Cupo> cupos_dia= new ArrayList<>();
    			
	    		cupos_dia.add(new Cupo(fechaActual, "8:00","10:00", true));
	    		cupos_dia.add(new Cupo(fechaActual, "10:00","12:00", true));
	    		cupos_dia.add(new Cupo(fechaActual, "14:00","16:00", true));
	    		cupos_dia.add(new Cupo(fechaActual, "16:00","18:00", true));
	    		
	    		j++;
	    		
	    		this.agenda_dias.add(cupos_dia);	
	    		fechaActual = fechaActual.plusDays(1);//PASAR AL SIGUIENTE DÍA.			
	    		
    		}
    	}
    }
}
    
    
    public void actualizar_Agenda() {
    	
    	//ACTUALIZAMOS HORARIO
    		
    	//RECORREMOS EL ARRAY LIST, QUE CONTIENE ARRAYLIST DE CUPOS POR DIA.
    	for(ArrayList <Cupo> Array_dia : this.agenda_dias) {
    		
    		LocalDate fecha_Actual = LocalDate.now(); //LA FECHA DE ACTUALIZACIÓN
    		
    		//COMPROBAR SI LA FECHA DE LOS CUPOS ES ANTERIOR A LA ACTUAL
    		if (Array_dia.get(0).getDia().isBefore(fecha_Actual)) {
    			
    			//SI LA FECHA EFECTIVAMENTE ES ANTERIOR A LA ACTUAL:
    			
    			//SI EL DIA ("LUNES", "MARTES"...) COINCIDE CON LA ACTUAL, ENTONCES SE HABILITAN LOS CUPOS PARA HOY.
    			if (fecha_Actual.getDayOfWeek().getValue() == Array_dia.get(0).getDia().getDayOfWeek().getValue()) {
    				
					Array_dia.clear();//LIMPIAR EL ARRAYLIST DE ESE DÍA.
					
					//LLENARLO CON NUEVOS CUPOS.
		    		Array_dia.add(new Cupo(fecha_Actual, "8:00","10:00", true));
		    		Array_dia.add(new Cupo(fecha_Actual, "10:00","12:00", true));
		    		Array_dia.add(new Cupo(fecha_Actual, "14:00","16:00", true));
		    		Array_dia.add(new Cupo(fecha_Actual, "16:00","18:00", true));	
		    		
    			}
    			
    			else {
    				
    				 fecha_Actual = LocalDate.now();
    							 
    				 int num_dia=Array_dia.get(0).getDia().getDayOfWeek().getValue();
    				
    				 boolean continuar = true;	
    			
    			    while(continuar) {
    			    	
    			    	//SI EL DIA ("LUNES", "MARTES"..) NO COINCIDE CON EL ACTUAL, ENTONCES BUSCAMOS CON EL QUE 
    				   //COINCIDA EN LOS DIAS PRÓXIMOS.
    			    		
    				      fecha_Actual = fecha_Actual.plusDays(1); //AUMENTAMOS AL DIA SIGUIENTE
    				       				
     				     if (fecha_Actual.getDayOfWeek().getValue() == num_dia)  {	    				    	
    				    	
    				       Array_dia.clear();//LIMPIAR EL ARRAYLIST DE ESE DÍA.
    					
    					   //LENARLO EL DÍA POR DELANTE
    		    		   Array_dia.add(new Cupo(fecha_Actual, "8:00","10:00", true));
    		    		   Array_dia.add(new Cupo(fecha_Actual, "10:00","12:00", true));
    		    		   Array_dia.add(new Cupo(fecha_Actual, "14:00","16:00", true));
    		    		   Array_dia.add(new Cupo(fecha_Actual, "16:00","18:00", true));
    		    		
    		    		   continuar = false;
    			        }
     				}
    			}
    		}
    	}
    }
    
    
    ///COMPROBAR SI TIENE CUPOS DISPONIBLES
    public boolean tieneCupos() {

    	Boolean booleano = false;
    	this.actualizar_Agenda();
    	
    	for(ArrayList <Cupo> cupos_por_dia: this.agenda_dias) {
    		
    		for(Cupo cupo: cupos_por_dia) {
    			
    			if (cupo.isDisponible()==true) {
    				booleano=true;
    				break;
    			}
    		}
    	}
    	return booleano;
    }
    
    public ArrayList<Cupo> cupos_disponibles(int i){
    	
    	ArrayList<Cupo> cupos_disponibles= new ArrayList<>();
    	
    	for(ArrayList <Cupo> Array_dia : this.agenda_dias) {
    		
    		if (Array_dia.get(0).getDia().getDayOfWeek().getValue()==i) {
    			
    			for(Cupo cupo: Array_dia) {
    				
    				if(cupo.isDisponible()) {
    				cupos_disponibles.add(cupo);
    				}
    			}	
    			break;
    		}
    	}
    	
    	return cupos_disponibles;
    }
    
    
    
    
    
    
 

        public Rol getProfesion(){
            return profesion;
        }
        
        public ArrayList<ArrayList<Cupo>> getCupo(){
    		return agenda_dias;
    	}

           

      
        
        

    @Override
  //  public String toString()
    //{
    //    return "Nombre: "+ getNombre() + ", Cedula: "+ getCedula() + ", Profesión: "+ getProfesion();
    //}
    public String toString() {
    	return "Nombre: "+ getNombre() + ", Edad: " + getEdad() + " años.";
    }
    
    

  


    
}


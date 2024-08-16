package gestorAplicación.servicioAdicional;

import  gestorAplicación.procesoAdopcion.Persona;
import gestorAplicación.servicioAdicional.Empleado.Rol;
import gestorAplicación.servicioAdicional.Cita;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
public class Empleado extends Persona {
	
    private Rol profesion;
  //  private Map<String, List<String>>[] horario = new Map[15];//
    private Map<String, List<Cita>>horario;
    
    public static enum Rol {
        VETERINARIO,PELUQUERO,CUIDADOR,TENDERO;

    }
      ArrayList<String> [] horarioo;

        public Rol getProfesion(){
            return profesion;
        }
    //FALTA ARRAYLIST HORARIOS 

    /*CONSTRUCTOR
        public Empleado( String nombre,int edad, long cedula,long telefono, String direccion,Rol profesion, Map<String, List<String>>[] horario)
        {
         super (nombre,edad,cedula,telefono,direccion);
            this.profesion = profesion;
            this.horario = horario;
        }*/
        
        public Empleado( String nombre,int edad, long cedula,long telefono, String direccion,Rol profesion) {
        	super (nombre,edad,cedula,telefono,direccion);
            this.profesion = profesion;
            this.horario = new HashMap<>();
            llenarHorario();
        }
           
        private void llenarHorario() {
            String[] diasSemana = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"};
            
            if (this.profesion == Empleado.Rol.CUIDADOR) {
            	for (String dia : diasSemana) {
                horario.put(dia, new ArrayList<>());
                horario.get(dia).add(new Cita("8:00", "10:00"));
                horario.get(dia).add(new Cita("10:00", "12:00"));
                horario.get(dia).add(new Cita("14:00", "16:00"));
                horario.get(dia).add(new Cita("16:00", "18:00"));
                }
            }
            else {
            	for (String dia : diasSemana) {
                    horario.put(dia, new ArrayList<>());
                    horario.get(dia).add(new Cita("8:00", "9:00"));
                    horario.get(dia).add(new Cita("9:00", "10:00"));
                    horario.get(dia).add(new Cita("10:00", "11:00"));
                    horario.get(dia).add(new Cita("11:00", "12:00"));
                    horario.get(dia).add(new Cita("14:00", "15:00"));
                    horario.get(dia).add(new Cita("15:00", "16:00"));
                    horario.get(dia).add(new Cita("16:00", "17:00"));
            	}
            }
        }
        
        public List<Cita> obtenerCitas(String dia) {
            return horario.getOrDefault(dia, new ArrayList<>());
        }
        
        public boolean cuposDisponibles(String dia) {
        	 for (Cita cita : this.obtenerCitas(dia)) {
	            	if (cita.getDisponibilidad()==true) {
	            		return true;
	            	}
              }
        	 return false;
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


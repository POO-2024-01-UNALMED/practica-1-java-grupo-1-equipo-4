package gestorAplicación.servicioAdicional;

import  gestorAplicación.procesoAdopcion.Persona;
import gestorAplicación.servicioAdicional.Empleado.Rol;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Empleado extends Persona {
	
    private Rol profesion;
    private Map<String, List<String>>[] horario = new Map[15];
    
    public static enum Rol {
        VETERINARIO("Veterinario"), 
        PELUQUERO("Peluquero"), 
        CUIDADOR("Cuidador"), 
        TENDERO("Tendero");

        private String rol;

        Rol(String rol)
        {
            this.rol = rol;
        }

        @Override
        public String toString()
        {
            return rol;
        }
    }

        public Rol getProfesion(){
            return profesion;
        }
    //FALTA ARRAYLIST HORARIOS 

    //CONSTRUCTOR
        public Empleado( String nombre,int edad, long cedula,long telefono, String direccion,Rol profesion, Map<String, List<String>>[] horario)
        {
         super (nombre,edad,cedula,telefono,direccion);
            this.profesion = profesion;
            this.horario = horario;
            

        }

    @Override
    public String toString()
    {
        return "Nombre: "+ getNombre() + ", Cedula: "+ getCedula() + ", Profesión: "+ getProfesion();
    }

  


    
}


package gestorAplicación.servicioAdicional;

import  gestorAplicación.procesoAdopcion.Persona;

import java.util.ArrayList;

public class Empleado extends Persona {
	
    private static ArrayList <Empleado> empleado = new ArrayList<>();
    private Rol profesion;
    private ArrayList <Cita> horario;
    
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
    //FALTA ARRAYLIST HORARIOS Y ARREGLAR EL ENUM ROL DE PROFESION(CONVIENE ENUM O SWITCH?)

    //CONSTRUCTOR
    public Empleado( String nombre,int edad, long cedula,long telefono, String direccion,Rol profesion, ArrayList <Cita> horario)
    {
     super (nombre,edad,cedula,telefono,direccion);
        this.profesion = profesion;
        this.horario = horario;


    }

    @Override
    public String toString()
    {
        return "Empleado [Nombre: "+ getNombre() + ", Cedula: "+ getCedula() + ", Profesión: "+ this.profesion + "]";
    }

  


    
}


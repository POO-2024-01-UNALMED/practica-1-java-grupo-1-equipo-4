package gestorAplicación.servicioAdicional;

import java.util.ArrayList;

public class Empleado 
{
    //private static ArrayList <Empleado> empleado;
    private String nombre;
    private long cedula;
    private String profesion;
    private ArrayList <Cita> horario;
    //FALTA ARRAYLIST HORARIOS Y ARREGLAR EL ENUM ROL DE PROFESION(CONVIENE ENUM O SWITCH?)

    //CONSTRUCTOR
    public Empleado(String nombre, long cedula, String profesion)
    {
        this.nombre = nombre;
        this.cedula = cedula;
        this.profesion = profesion;


    }

    @Override
    public String toString()
    {
        return "Empleado [Nombre: "+ this.nombre + ", Cedula: "+ this.cedula + ", Profesión: "+ this.profesion + "]";
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getNombre()
    {
        return this.nombre;
    }

    public void setCedula(long cedula)
    {
        this.cedula = cedula;
    }

    public long getCedula()
    {
        return this.cedula;
    }

    public void setProfesion(String profesion)
    {
        this.profesion = profesion;
    }

    public String getprofesion()
    {
        return this.profesion;
    }

    
}


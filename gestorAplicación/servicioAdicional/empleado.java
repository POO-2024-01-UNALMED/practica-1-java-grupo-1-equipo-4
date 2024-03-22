package gestorAplicación.servicioAdicional;

import java.util.ArrayList;

public class Empleado 
{
    private String nombre;
    private long cedula;
    private Rol profesion;
    private ArrayList <Cita> horario;

    //CONSTRUCTOR
    public Empleado(String nombre, long cedula, Rol profesion, ArrayList<Cita> horario)
    {
    }

    //toString
    public String toString()
    {
    }

    //SET Y GET
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
}

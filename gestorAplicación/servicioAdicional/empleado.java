package gestorAplicación.servicioAdicional;

import java.util.ArrayList;

public class Empleado 
{
    //private static ArrayList <Empleado> empleado;
    private String nombre;
    private int cedula;
    private String profesion;
    private ArrayList <Cita> horario;
    //CONTADOR NUMERO DE EMPLEADOS
    private int cEmpleados = 0;

    //CONSTRUCTOR
    public Empleado(String nombre, int cedula)
    {
        this.nombre = nombre;
        this.cedula = cedula;


    }

    //toString
    
    //{
    //}

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

    public int getCedula()
    {
        return this.cedula;
    }

    public String getProfesion()
    {
        return this.profesion;
    }
}


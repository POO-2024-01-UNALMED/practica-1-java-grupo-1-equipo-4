package gestorAplicación.servicioAdicional;

import java.util.ArrayList;
import java.util.Scanner;

public class Empleado 
{
    private static ArrayList <Empleado> empleado;
    private String nombre;
    private long cedula;
    private Rol profesion;
    private ArrayList <Cita> horario;
    //CONTADOR NUMERO DE EMPLEADOS
    private int cEmpleados = 0;

    //CONSTRUCTOR
    public Empleado(String nombre, long cedula, Rol profesion, ArrayList<Cita> horario)
    {
        //Scaner SI o NO crear empleado
        Scanner scanner = new Scanner(System.in);
        System.out.print("¿Desea agregar un nuevo empleado? ");
        String r = scanner.nextLine();
        scanner.close();

        System.out.println(r);

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

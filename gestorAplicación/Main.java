package gestorAplicación;

import gestorAplicación.servicioAdicional.*;
import gestorAplicación.procesoAdopcion.*;

public class Main 
{
    public static void main(String[] args){

        //PRUEBA DE CODIGO EMPLEADO

        Empleado empleado1 = new Empleado("Juan", 10, "Veterinario");
        System.out.println(empleado1.getNombre() + empleado1.getCedula() + empleado1.getprofesion());
    }  
}

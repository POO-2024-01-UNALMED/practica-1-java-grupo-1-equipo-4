package gestorAplicación;

import gestorAplicación.servicioAdicional.*;
import gestorAplicación.procesoAdopcion.*;
import java.util.Scanner;

public class Main 
{
    public static void main(String[] args){

        //PRUEBA DE CODIGO EMPLEADO A
        Empleado empleado1 = new Empleado("Juan", 10, "Veterinario");
        System.out.println(empleado1.getNombre() + empleado1.getCedula() + empleado1.getprofesion());

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese su nombre: ");
        String nombre = scanner.next();

        System.out.println("Ingrese su cedula: ");
        int cedula = scanner.nextInt();

        System.out.println("Ingrese su profesión: ");
        String profesion = scanner.next();
        scanner.close();

       Empleado empleado2 = new Empleado(nombre, cedula, profesion);
       System.out.println(empleado2.getNombre() + " " + empleado2.getCedula() + " " + empleado2.getprofesion());


    }  
}

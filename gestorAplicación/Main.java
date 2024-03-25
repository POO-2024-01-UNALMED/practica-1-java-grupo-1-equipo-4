package gestorAplicación;

import gestorAplicación.servicioAdicional.*;
import gestorAplicación.procesoAdopcion.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main 
{
    public static void main(String[] args){

        //PRUEBA DE CODIGO EMPLEADO A FUNCIONA
        /*Empleado empleado1 = new Empleado("Juan", 10, "Veterinario");
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
       System.out.println(empleado2.getNombre() + " " + empleado2.getCedula() + " " + empleado2.getprofesion());*/
       
       //PRUEBA CLASE EMPLEADO B FUNCIONA
       /*String respuesta = "None";
       int e = 0;
       Scanner scanner = new Scanner(System.in);
       while (!respuesta.equals("NO")) 
       {
        System.out.println("¿Desea agregar un nuevo empleado? ");
        respuesta = scanner.next();
       }
       scanner.close();*/

       //PRUEBA CLASE EMPLEADO C FUNCIONA
       String respuesta = "None";
       int e = 1;
       // prueba con una tienda 
       Tienda tienda1 = new Tienda(); 


       Scanner scanner = new Scanner(System.in);
       while (!respuesta.equals("NO")) 
       {
        
    

        //CONSTRUCTOR NUEVO EMPLEADO
        System.out.println("Ingrese su nombre: ");
        String nombre = scanner.next();

        System.out.println("Ingrese su cedula: ");
        int cedula = scanner.nextInt();

        System.out.println("Ingrese su profesión: ");
        String profesion = scanner.next();


        Empleado empleado0 = new Empleado(nombre, cedula, profesion);

        System.out.println(empleado0.getNombre() + " " + empleado0.getCedula() + " " + empleado0.getprofesion());
        
        //Agregar empleado a tienda
        tienda1.agregarEmpleado(empleado0);

        // CONDICIONAL CICLO
        System.out.println("¿Desea agregar un nuevo empleado? ");
        respuesta = scanner.next();
        
       }

       //NOTA: TODAVIA FALTA HACER CODIGO PARA QUE EL NUMBRE DE LOS OBJETOS SE VAYAN CAMBIANDO
       //AUTOMATICAMENTE Y QUE LOS NUEVOS OBJETOS SE VAYAN AGREGANDO A LA LISTA DE EMPLEADOS.
       tienda1.empleadosTienda();
       Producto p1 = new Producto("Shampoo", 80000, "Perros", 30);
       tienda1.agregarProducto(p1);
       tienda1.inventario();
       tienda1.empleadosTienda();
       tienda1.agregarVoluntario();
       tienda1.agregarVoluntario();
       
       /* si se cierra el scanner antes, no permite la lectura de más datos por consola
       lo mismo dentro del método agregarVoluntario, no se puede CERRAR EL SCANNER porque cuando 
       volvemos a llamar a agregar voluntario, se nos cierra el scanner y no podemos ingresar nada más*/

       scanner.close(); 
    }  
}

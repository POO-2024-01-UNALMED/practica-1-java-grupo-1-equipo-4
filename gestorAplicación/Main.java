package gestorAplicación;

import gestorAplicación.servicioAdicional.*;
import gestorAplicación.procesoAdopcion.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main 
{
    public static void main(String[] args){

        //MENU
        System.out.println("Bienvenido usuario!");

        Scanner scanner = new Scanner(System.in);

        System.out.println("¿Que deseas hacer el día de hoy?");
        String funcionalidad = scanner.next();


        switch(funcionalidad)
        {
            case AGENDAR_SERVICIO:

        }

        //----------------------------------------------------------------
       //PRUEBA CLASE EMPLEADO C FUNCIONA
       String respuesta = "None";
       
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

        //DOS FORMAS DE IMPRIMIR EMPLEADO, POR MEDIO DEL TOSTRING DE LA CLASE
        //O REFERENCIANDO CADA ATRIBUTO DEL OBJETO

        System.out.println(empleado0);
        //System.out.println(empleado0.getNombre() + " " + empleado0.getCedula() + " " + empleado0.getprofesion());
        

        // CONDICIONAL CICLO
        System.out.println("¿Desea agregar un nuevo empleado? ");
        respuesta = scanner.next();
        
       }

       //NOTA: TODAVIA FALTA HACER CODIGO PARA QUE EL NUMBRE DE LOS OBJETOS SE VAYAN CAMBIANDO
       //AUTOMATICAMENTE Y QUE LOS NUEVOS OBJETOS SE VAYAN AGREGANDO A LA LISTA DE EMPLEADOS.
       
       //------------------------------------------------------------------

       //PRUEBAS TIENDA
       respuesta = "None";
       // prueba con una tienda 
       Tienda tienda1 = new Tienda(); 


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

        System.out.println(empleado0);
        //System.out.println(empleado0.getNombre() + " " + empleado0.getCedula() + " " + empleado0.getprofesion());
        
       // Agregar empleado a tienda
        tienda1.agregarEmpleado(empleado0);

        // CONDICIONAL CICLO
        System.out.println("¿Desea agregar un nuevo empleado? ");
        respuesta = scanner.next();
        
       }

    
       tienda1.empleadosTienda();
       Producto p1 = new Producto("Shampoo", 80000, "Perros", 30);
       tienda1.agregarProducto(p1);
       tienda1.inventario();
       tienda1.empleadosTienda();
       
       
       scanner.close();


    }  
}

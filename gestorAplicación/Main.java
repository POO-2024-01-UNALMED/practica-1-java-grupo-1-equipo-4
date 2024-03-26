package gestorAplicación;

import gestorAplicación.servicioAdicional.*;
import gestorAplicación.procesoAdopcion.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main 
{
    public static void main(String[] args)
    {
         
        //MENU FUNCIONA. AGREGAR SUBMENUS Y LOS MENUS DE REGISTRO ANIMAL, PERSONA, EMPLEADO.
        System.out.println("Bienvenido usuario!");
        System.out.println("¿Que deseas hacer el día de hoy?");

        for(Funcionalidad funcionalidad : Funcionalidad.values())
        {
            System.out.println(funcionalidad.ordinal() + ". " + funcionalidad);
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el número de la funcionalidad a la que desea acceder:");
        int fNum = scanner.nextInt();

        switch(Funcionalidad.values()[fNum])
        {
            case AGENDAR_SERVICIO:
            System.out.println("Has seleccionado"+ " " + Funcionalidad.values()[fNum] + ".");
            break;

            case SISTEMA_FINANZAS:
            System.out.println("Has seleccionado"+ " " + Funcionalidad.values()[fNum] + ".");
            break;

            case ADOPTAR_ANIMAL:
            System.out.println("Has seleccionado"+ " " + Funcionalidad.values()[fNum] + ".");
            break;

            case TIENDA_DE_MASCOTAS:
            System.out.println("Has seleccionado"+ " " + Funcionalidad.values()[fNum] + ".");
            break;

            case ONG:
            System.out.println("Has seleccionado"+ " " + Funcionalidad.values()[fNum] + ".");
            break;

            default:
            System.out.println("Número invalido.");

        }
        scanner.close();
     
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
        

        // CONDICIONAL CICLO
        System.out.println("¿Desea agregar un nuevo empleado? ");
        respuesta = scanner.next();
        
       }

       
       
       scanner.close();
       
    
    System.out.println("¿Que deseas hacer el día de hoy?");

        for(Funcionalidad funcionalidad : Funcionalidad.values())
        {
            System.out.println(funcionalidad.ordinal() + ". " + funcionalidad);
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el número de la funcionalidad a la que desea acceder:");
        int fNum = scanner.nextInt();

        switch(Funcionalidad.values()[fNum])
        {
            case AGENDAR_SERVICIO:
            System.out.println("Has seleccionado"+ " " + Funcionalidad.values()[fNum] + ".");
            break;

            case SISTEMA_FINANZAS:
            System.out.println("Has seleccionado"+ " " + Funcionalidad.values()[fNum] + ".");
            break;

            case ADOPTAR_ANIMAL:
            System.out.println("Has seleccionado"+ " " + Funcionalidad.values()[fNum] + ".");
            break;

            case TIENDA_DE_MASCOTAS:
            System.out.println("Has seleccionado"+ " " + Funcionalidad.values()[fNum] + ".");
            break;

            case ONG:
            System.out.println("Has seleccionado"+ " " + Funcionalidad.values()[fNum] + ".");
            break;

            default:
            System.out.println("Número invalido.");

        }
        scanner.close(); 
    
    //------------------------------------------------------------

    //SELECCION SERVICIO FUNCIONA

    System.out.println("Lista de servicios que ofrecemos: ");

        for(TipoServicio servic : TipoServicio.values())
        {
            System.out.println(servic.ordinal() + ". " + servic);
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el número del servicio que desea seleccionar:");
        int sNum = scanner.nextInt();

        switch(TipoServicio.values()[sNum])
        {
            case VETERINARIA:
            System.out.println("Has seleccionado"+ " " + TipoServicio.values()[sNum] + ".");
            break;

            case PELUQUERIA:
            System.out.println("Has seleccionado"+ " " + TipoServicio.values()[sNum] + ".");
            break;

            case GUARDERIA:
            System.out.println("Has seleccionado"+ " " + TipoServicio.values()[sNum] + ".");
            break;

            default:
            System.out.println("Número invalido.");

        }
        scanner.close();
    }  
}


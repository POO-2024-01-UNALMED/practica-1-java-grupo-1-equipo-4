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
      
    
    //------------------------------------------------------------
    
    //ENCUESTA PARA VERIFICAR SI EL ADOPTANTE CUMPLE LOS REQUISITOS (ADOPCION)
    
        Scanner scanner = new Scanner(System.in);

        int puntaje = hacerEncuesta(scanner);

        if (Adopcion.encuesta(puntaje)) {

        	System.out.println("¡Felicidades! Usted es un candidato confiable para adoptar una mascota en AdoptaLove.");
        	
        } else {
            System.out.println("Lo sentimos, no cumple con los requisitos mínimos para adoptar una mascota.");
        }
    }

   public static int hacerEncuesta(Scanner scanner) {
        System.out.println("Por favor responda las siguientes siete preguntas con un número del 1 al 5: (Segun corresponda)");
        int puntaje = 0;

        puntaje += validacionRespuesta(scanner, "1) ¿Tiene experiencia en el cuidado de mascotas? (1: Ninguna experiencia, 5: Mucha experiencia)");
        puntaje += validacionRespuesta(scanner, "2) ¿Cuánto tiempo puede dedicar diariamente a la atención y el cuidado de la mascota? (1: Menos de una hora, 5: Mas de tres horas)");
        puntaje += validacionRespuesta(scanner, "3) ¿Está dispuesto a someter a la mascota a chequeos veterinarios regulares y proporcionarle atención médica cuando sea necesario? (1: No estoy seguro, 5: Sí, estoy comprometido)");
        puntaje += validacionRespuesta(scanner, "4) ¿Tiene un espacio adecuado en su hogar para la mascota, tanto en interiores como en exteriores? (1: Espacio limitado o inadecuado, 5: Espacio amplio y adecuado)");
        puntaje += validacionRespuesta(scanner, "5) ¿Está dispuesto/a a comprometerse a cuidar de la mascota durante toda su vida, incluso si surgen cambios en su situación personal o residencial? (1: No estoy seguro a largo plazo, 5: Estoy comprometido a cuidarla toda su vida)");
        puntaje += validacionRespuesta(scanner, "6) ¿Ha considerado los requisitos específicos de la raza o tipo de mascota que está interesado en adoptar en términos de ejercicio, socialización y cuidados especiales? (1: No he investigado sobre ello, 5: He investigado y comprendo lo que implica cuidar esta raza o tipo de mascota)");
        puntaje += validacionRespuesta(scanner, "7) ¿Está dispuesto a recibir visitas por parte de AdoptaLove para enterarnos y verificar el estado de la mascota? (1: No estoy dispuesto, 5: Sí)");

        return puntaje;
    }
    
    public static int validacionRespuesta(Scanner scanner, String pregunta) {
        int respuesta;
        do {
            System.out.println(pregunta);
            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, ingrese un número válido del 1 al 5.");
                scanner.next();
            }
            respuesta = scanner.nextInt();
            if (respuesta < 1 || respuesta > 5) {
                System.out.println("Por favor, ingrese un número válido del 1 al 5.");
            }
        } while (respuesta < 1 || respuesta > 5);
        
        return respuesta;
    }

    //------------------------------------------------------------------------------
    
    
}


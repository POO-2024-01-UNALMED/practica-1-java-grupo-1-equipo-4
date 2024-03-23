package gestorAplicación.servicioAdicional;
import gestorAplicación.procesoAdopcion.Persona;
import java.util.ArrayList;


public class Tienda {
        //Atributos//
        private ArrayList<Producto> productos = new ArrayList<> ();
        private ArrayList<Empleado> empleados = new ArrayList<> ();
        private ArrayList<Persona> voluntarios = new ArrayList<> ();
        
        //constructores//
        public Tienda(Empleado empleado){
            this.empleados.add(empleado); //Tienda con un empleado 
        }

        public Tienda(){
            //tienda sin empleados
        }


        //métodos//
        public void agregarEmpleado(Empleado empleado){
            this.empleados.add(empleado);
        }
        public void empleadosTienda(){ //muestra todos los empleados de la tienda 
            for (int i = 0; i<empleados.size(); i++){
                System.out.println(empleados.get(i));
            }
        }

        public void agregarProducto(Producto producto){ //se agrega un producto si hay un empleado que lo agregue
            if(empleados!=null){
                String nombre = empleados.get(0).getNombre();
                System.out.println(nombre+" agregó: "+producto.getNombre());
                productos.add(producto);
            }
            else{
                System.out.println("No hay empleado para agregar producto");
            }
        }

        public void inventario(){ //inventario se hace si hay un empleado
            if(empleados!=null){
                String nombre = empleados.get(0).getNombre();
                System.out.println(nombre+" hizo inventario y encontró: ");
                for (int i = 0; i<productos.size(); i++){
                    System.out.println(productos.get(i));
                }
            }
            else{
                System.out.println("No hay empleado para hacer inventario");
            }
        }

        public void agregarVoluntario(){
            System.out.println("Encuesta para unirse a los voluntarios: \n");
            int contador = 0; // se va sumando el puntaje en la variable contador 
   
            // preguntas para agragar voluntarios 
            System.out.println("1- ¿Eres mayor de 18 años?");
            String respuesta1 = System.console().readLine();
            if(respuesta1.equals("SI")){
                contador+=1;
            } 

            System.out.println("2- ¿Dispones de más de 8 horas libres en la semana?");
            String respuesta2 = System.console().readLine();
            if(respuesta2.equals("SI")){
                contador+=1;
            } 
                // trabajo en progreso // work in progress



            //una vez finalizado el formulario de voluntario, si obtuvo un puntaje especifico, se crea una persona 
            // y se añade a la lista de voluntarios
            if (contador>1){
                System.out.println("Comienza el registro: ");

                System.out.println("Ingresa tu nombre: ");
                String nombre = System.console().readLine();

                System.out.println("Ingresa tu edad: ");
                int edad = Integer.parseInt(System.console().readLine());

                System.out.println("Ingresa tu cédula: ");
                long cedula = Long.parseLong(System.console().readLine());

                System.out.println("Ingresa tu dirección: ");
                String direccion = System.console().readLine();

                System.out.println("Ingresa tu teléfono: ");
                long tel = Long.parseLong(System.console().readLine());

                //creamos persona y añadimos a la lista de voluntarios 
                Persona voluntario = new Persona(nombre, edad, cedula, direccion, tel);
                voluntarios.add(voluntario);
            }
            else{
                System.out.println("No has cumplido con los requisitos para pertenecer a los voluntarios");
            }
        }



    }




package gestorAplicación.servicioAdicional;
import gestorAplicación.procesoAdopcion.Persona;
import java.util.ArrayList;

public class Tienda {
        //Atributos 
        private ArrayList<Producto> productos = new ArrayList<> ();
        private ArrayList<Empleado> empleados = new ArrayList<> ();
        private ArrayList<Persona> voluntario = new ArrayList<> ();
        
        //constructor 
        public Tienda(Empleado empleado){
            this.empleados.add(empleado); //Tienda con un empleado 
        }

        public Tienda(){
            //tienda sin empleados
        }


        //métodos 
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
                productos.add(producto);
            }
            else{
                System.out.println("No hay empleado para agregar producto");
            }
        }

        public void inventario(){ //inventario se hace si hay un empleado
            if(empleados!=null){
                for (int i = 0; i<productos.size(); i++){
                    System.out.println(productos.get(i));
                }
            }
            else{
                System.out.println("No hay empleado para hacer inventario");
            }
        }


}

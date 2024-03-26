package gestorAplicación.servicioAdicional;
import gestorAplicación.procesoAdopcion.Persona;
import gestorAplicación.procesoAdopcion.CentroAdopcion;
import java.util.ArrayList;

public class Tienda {
        //Atributos//
        private ArrayList<Producto> productos = new ArrayList<> ();
        private ArrayList<Empleado> empleados = new ArrayList<> ();
        private ArrayList<Persona> voluntarios = new ArrayList<> ();
        private CentroAdopcion centroAdopcion;
        
        //constructores//
        public Tienda(Empleado empleado, CentroAdopcion centroAdopcion){
            this.empleados.add(empleado); //Tienda con un empleado 
            this.centroAdopcion = centroAdopcion;
        }

        public Tienda(CentroAdopcion centroAdopcion){
            this.centroAdopcion = centroAdopcion;
            //tienda definida solo con su centro de adopcion
        }

        //setter y getter//
        public void setCentroAdopcion(CentroAdopcion centroAdopcion){
            this.centroAdopcion = centroAdopcion;
        }
        public CentroAdopcion getCentroAdopcion(){
            return this.centroAdopcion;
        }

        //métodos//
        public void agregarEmpleado(Empleado empleado){
            this.empleados.add(empleado);
        }
        public ArrayList<Empleado> empleadosTienda(){ //muestra todos los empleados de la tienda 
            return empleados;
        }

        public void agregarProducto(Producto producto){ 
            if(empleados!=null){     //se agrega un producto si hay un empleado que lo agregue
                productos.add(producto);
            }
        }

        public ArrayList<Producto> inventario(){ //inventario se hace si hay un empleado
            if(empleados!=null){
                return productos;
            }
            else {
                return null;
            }
        }

        public void agregarVoluntario(Persona voluntario){
            voluntarios.add(voluntario);
        }

        public ArrayList<Persona> mostrarVoluntarios(){
            return voluntarios;
        }



    }




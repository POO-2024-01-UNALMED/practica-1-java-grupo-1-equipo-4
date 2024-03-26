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

        public Tienda(Empleado empleado){
            this.empleados.add(empleado);
            //tienda definida solo con su centro de adopcion
        }

        public Tienda(){
            //constructor vacío
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

        public String compra(int indice){
            if (empleados!=null){
                indice -= 1;
                int cantidad = productos.get(indice).getCantidadUnidades();

                if (cantidad!=0){// si la cantidad unidades es diferente de 0, hace la compra
                    cantidad-=1;
                    productos.get(indice).setCantidadUnidades(cantidad); 
                    return "Se compró una unidad de: "+productos.get(indice).getNombre();
                }
                else{
                    return "No hay unidades suficientes.";
                }
            }else{
                return "No hay un empleado para atenderlo.";
            }
        }

        public String compra(int indice, int unidades){
            if (empleados!=null){
                indice -= 1;
                int cantidad = productos.get(indice).getCantidadUnidades();

                if (cantidad!=0 && cantidad>=unidades){// si la cantidad unidades es diferente de 0 
                    // y mayor o igual a las unidades que se van a comprar
                    cantidad-=unidades;
                    productos.get(indice).setCantidadUnidades(cantidad); 
                    return "Se compró "+unidades+" unidades de: "+productos.get(indice).getNombre();
                }
                else{
                    return "No hay unidades suficientes.";
                }
            }else{
                return "No hay un empleado para atenderlo.";
            }
        }


        public String toString(){
            return "Tienda con empleados: "+empleadosTienda();
        }
    }




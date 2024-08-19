package gestorAplicación.servicioAdicional;
import gestorAplicación.procesoAdopcion.CentroAdopcion;
import gestorAplicación.procesoAdopcion.Cliente;

import java.io.Serializable;
import java.util.ArrayList;

public class Tienda implements Serializable{

		private static final long serialVersionUID = 1L;
		// ATRIBUTOS 
		//LISTAS STATIC PARA LA SERIALIZACION 
        public static ArrayList<Producto> productos = new ArrayList<> ();
        public static ArrayList<Empleado> empleados = new ArrayList<> ();
        private CentroAdopcion centroAdopcion;
        
        //constructores//
        public Tienda(Empleado empleado, CentroAdopcion centroAdopcion){
            Tienda.empleados.add(empleado); //Tienda con un empleado 
            this.centroAdopcion = centroAdopcion;
            
            //PRODUCTOS INICIALES CON LOS QUE EMPIEZA LA TIENDA
//            this.agregarProducto(new Producto("Pack juguetes", 14000,"perros", 15));
//            this.agregarProducto(new Producto("Huesos", 6000,"perros", 20));
//            this.agregarProducto(new Producto("Correas", 25000, 10));
//            this.agregarProducto(new Producto("Pack juguetes", 18000,"gatos", 10));
//            this.agregarProducto(new Producto("Rascadores", 40000,"gatos", 5));
//            this.agregarProducto(new Producto("Comederos de acero", 20000, 25));
//            this.agregarProducto(new Producto("Comederos con formas", 30000, 10));
//            this.agregarProducto(new Producto("Shampoo", 60000,"perros", 20));
//            this.agregarProducto(new Producto("Shampoo", 65000,"gatos", 20));
//            this.agregarProducto(new Producto("Pienso generico", 30000,"Perros", 30));
//            this.agregarProducto(new Producto("Pienso generico", 35000,"gatos", 20));
//            this.agregarProducto(new Producto("Alpiste", 12000,"aves", 20));
//            this.agregarProducto(new Producto("Jaula", 50000,"aves", 6)); 
//            this.agregarProducto(new Producto("Casa de madera", 100000,"aves", 2)); 
//            this.agregarProducto(new Producto("Semillas y cereales", 15000,"hamsters", 20));
//            this.agregarProducto(new Producto("Jaula", 30000,"hamsters", 10));   
//            this.agregarProducto(new Producto("Ruedas", 22000,"hamsters", 10)); 
//            this.agregarProducto(new Producto("Heno", 23000,"conejos", 20));
//            this.agregarProducto(new Producto("Corral metálico", 30000,"conejos", 10));    
            
        }

        public Tienda(Empleado empleado){
            Tienda.empleados.add(empleado);
            //tienda definida solo con su centro de adopcion
            
            //PRODUCTOS INICIALES CON LOS QUE EMPIEZA LA TIENDA
//            this.agregarProducto(new Producto("Pack juguetes", 14000,"perros", 15));
//            this.agregarProducto(new Producto("Huesos", 6000,"perros", 20));
//            this.agregarProducto(new Producto("Correas", 25000, 10));
//            this.agregarProducto(new Producto("Pack juguetes", 18000,"gatos", 10));
//            this.agregarProducto(new Producto("Rascadores", 40000,"gatos", 5));
//            this.agregarProducto(new Producto("Comederos de acero", 20000, 25));
//            this.agregarProducto(new Producto("Comederos con formas", 30000, 10));
//            this.agregarProducto(new Producto("Shampoo", 60000,"perros", 20));
//            this.agregarProducto(new Producto("Shampoo", 65000,"gatos", 20));
//            this.agregarProducto(new Producto("Pienso generico", 30000,"perros", 30));
//            this.agregarProducto(new Producto("Pienso generico", 35000,"gatos", 20));
//            this.agregarProducto(new Producto("Alpiste", 12000,"aves", 20));
//            this.agregarProducto(new Producto("Jaula", 50000,"aves", 6)); 
//            this.agregarProducto(new Producto("Casa de madera", 100000,"aves", 2)); 
//            this.agregarProducto(new Producto("Semillas y cereales", 15000,"hamsters", 20));
//            this.agregarProducto(new Producto("Jaula", 30000,"hamsters", 10));   
//            this.agregarProducto(new Producto("Ruedas", 22000,"hamsters", 10)); 
//            this.agregarProducto(new Producto("Heno", 23000,"conejos", 20));
//            this.agregarProducto(new Producto("Corral metálico", 30000,"conejos", 10));    
            
        }

        public Tienda(){
            //constructor vacío
        	
            //PRODUCTOS INICIALES CON LOS QUE EMPIEZA LA TIENDA
//            this.agregarProducto(new Producto("Pack juguetes", 14000,"perros", 15));
//            this.agregarProducto(new Producto("Huesos", 6000,"perros", 20));
//            this.agregarProducto(new Producto("Correas", 25000, 10));
//            this.agregarProducto(new Producto("Pack juguetes", 18000,"gatos", 10));
//            this.agregarProducto(new Producto("Rascadores", 40000,"gatos", 5));
//            this.agregarProducto(new Producto("Comederos de acero", 20000, 25));
//            this.agregarProducto(new Producto("Comederos con formas", 30000, 10));
//            this.agregarProducto(new Producto("Shampoo", 60000,"perros", 20));
//            this.agregarProducto(new Producto("Shampoo", 65000,"gatos", 20));
//            this.agregarProducto(new Producto("Pienso generico", 30000,"perros", 30));
//            this.agregarProducto(new Producto("Pienso generico", 35000,"gatos", 20)); 
//            this.agregarProducto(new Producto("Alpiste", 12000,"aves", 20));
//            this.agregarProducto(new Producto("Jaula", 50000,"aves", 6)); 
//            this.agregarProducto(new Producto("Casa de madera", 100000,"aves", 2)); 
//            this.agregarProducto(new Producto("Semillas y cereales", 15000,"hamsters", 20));
//            this.agregarProducto(new Producto("Jaula", 30000,"hamsters", 10));   
//            this.agregarProducto(new Producto("Ruedas", 22000,"hamsters", 10));   
//            this.agregarProducto(new Producto("Heno", 23000,"conejos", 20));
//            this.agregarProducto(new Producto("Corral metálico", 60000,"conejos", 10));    
            
        }

        //setter y getter//
        public void setCentroAdopcion(CentroAdopcion centroAdopcion){
            this.centroAdopcion = centroAdopcion;
        }
        public CentroAdopcion getCentroAdopcion(){
            return this.centroAdopcion;
        }
        
        public static ArrayList<Producto> getProductos(){
        	return productos;
        }
        
        public static ArrayList<Empleado> getEmpleados(){
        	return empleados;
        }
        
        
        public void setProductos(ArrayList<Producto> productos) {
        	Tienda.productos = productos;
        }
        
        public void setEmpleados(ArrayList<Empleado> empleados) {
        	Tienda.empleados = empleados;
        }

        //métodos//
        public void agregarEmpleado(Empleado empleado){
            Tienda.empleados.add(empleado);
        }
        public ArrayList<Empleado> empleadosTienda(){ //muestra todos los empleados de la tienda 
            return empleados;
        }

        public void agregarProducto(Producto producto){ 
            if(empleados!=null){     //se agrega un producto si hay un empleado que lo agregue
                productos.add(producto);
            }
        }

        public String inventario(){ //inventario se hace si hay un empleado
            if(empleados!=null){
            	String resultado = "";
            	int indice = 1;
            	for (int i = 0; i<productos.size();i++) {
            		resultado += indice+"."+productos.get(i).toString();
            		indice = indice+1;
            	}
                return resultado;
            }
            else {
                return "No hay empleado para atender la tienda";
            }
        }
        
        public String filtrar(String tipo){ //FILTRAR
            if(empleados!=null){
            	String resultado = "";
            	int indice = 0;
            	for (int i = 0; i<productos.size();i++) {
              		indice = indice+1;
            		if (productos.get(i).getTipoAnimal().equals(tipo) || productos.get(i).getTipoAnimal().equals("Uso general")) {
            			resultado += indice+"."+productos.get(i).toString();
            		}
            	}
                return resultado;
            }
            else {
                return "No hay empleado para atender la tienda";
            }
        }


        public String compra(int indice){
            if (empleados!=null){
                indice -= 1;
                int cantidad = productos.get(indice).getCantidadUnidades();

                if (cantidad!=0){// si la cantidad unidades es diferente de 0, hace la compra
                    cantidad-=1;
                    productos.get(indice).setCantidadUnidades(cantidad);
                    String nombre = productos.get(indice).getNombre();
                    String tipo =  productos.get(indice).getTipoAnimal();
                    if (productos.get(indice).getCantidadUnidades()==0) {
                    	productos.remove(indice);
                    }
                    return "Se compró una unidad de: "+nombre+" para "+tipo;
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
                if (indice>=productos.size() || indice<0) {
                	return "No pudimos realizar la compra, el índice es incorrecto.";
                }
                int cantidad = productos.get(indice).getCantidadUnidades();

                if (cantidad!=0 && cantidad>=unidades){// si la cantidad unidades es diferente de 0 
                    // y mayor o igual a las unidades que se van a comprar
                    cantidad-=unidades;
                    productos.get(indice).setCantidadUnidades(cantidad);
                    String nombre = productos.get(indice).getNombre();
                    String tipo = productos.get(indice).getTipoAnimal(); 
                    if (productos.get(indice).getCantidadUnidades()==0) {
                    	productos.remove(indice);
                    }
                    return "Has comprado "+unidades+" unidades de: "+nombre+" para "+tipo;
                }
                else{
                    return "No pudimos realizar la compra, no hay unidades suficientes.";
                }
            }else{
                return "No hay un empleado para atenderlo.";
            }
        }
        
        //TODO: MÉTODOS DE PRUEBA-------------------------------------------------------------------------------------------- 
        
        public String compra(int indice, int unidades, Cliente cliente){
            if (empleados!=null){
                indice -= 1; //CONVERTIMOS EL NÚMERO A INDICE
                
                if (indice>=productos.size() || indice<0) { //COMPROBAMOS SI EL INDICE ES CORRECTO 
                	return "No pudimos realizar la compra, el índice es incorrecto.";
                }
                int cantidad = productos.get(indice).getCantidadUnidades();

                if (cantidad!=0 && cantidad>=unidades){//SI LA CANTIDAD INGRESADA ESTÁ DENTRO DEL RANGO
                	
                    cantidad-=unidades;
                    productos.get(indice).setCantidadUnidades(cantidad);
                    String nombre = productos.get(indice).getNombre();
                    String tipo = productos.get(indice).getTipoAnimal(); 
                    if (productos.get(indice).getCantidadUnidades()==0) {
                    	productos.remove(indice);
                    	
                    }
                    
                    cliente = CentroAdopcion.isCliente(cliente); // SE COMPRUEBA SI EL CLIENTE EXISTE 
                    float precio = productos.get(indice).getPrecio();
                    int puntos = cliente.getPuntos(); //SE TOMAN LOS PUNTOS 
                    
                    if (puntos>=15) {
                    	cliente.disminuir_puntos(puntos);
                    	 return "-------------------------------------------\n"+"Has comprado "+unidades+" unidades de: "+nombre+" para "+tipo+"\n"+"Total a pagar: "+precio*unidades*0.1+" $"+"\n"+"Han sido utilizados 15 puntos para un 10% de descuento\n"+"Puntos restantes: "+cliente.getPuntos()+"\n-------------------------------------------";
                    }else {
                    	return "-------------------------------------------\n"+"Has comprado "+unidades+" unidades de: "+nombre+" para "+tipo+"\n"+"Total a pagar: "+precio*unidades+" $"+"\n"+"No ha sido posible usar puntos para descuento\n"+"-------------------------------------------";
                    }
                }
                else{
                    return "No se pudo realizar la compra, no hay unidades suficientes del producto solicitado.";
                }
            }else{
                return "No hay un empleado para atender en estos momentos.";
            }
        }
        
        //-----------------------------------------------------------------------------------------------------------------------------
        
        public static boolean isCliente(long cedula) {
        	boolean respuesta = false;
        	for (int i = 0; i < CentroAdopcion.getClientes().size(); i ++) {
        		if (CentroAdopcion.getClientes().get(i).getCedula()==cedula) {
        			respuesta = true; 
        		}
        	}
    		return respuesta;
        }


        public String toString(){
            return "Tienda con empleados: "+empleadosTienda();
        }
    }




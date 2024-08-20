package src.gestorAplicacion.administracion;
import java.io.Serializable;
import java.util.ArrayList;

import src.gestorAplicacion.componentes.Cliente;
import src.gestorAplicacion.componentes.Empleado;
import src.gestorAplicacion.componentes.Producto;

public class Tienda implements Serializable{
	
	//DANIEL ALBERTO ZAPATA CASTAÑO
	//OKY RUIZ DE LA ROSA
	//SALOMÉ MURILLO GAVIRIA
	//NICOLAS DAVID ZAMBRANO MURCIA
	
	//DESCRIPCIÓN DE LA CLASE:
	//Gestiona el inventario de productos disponibles para la venta, permitiendo a los clientes realizar compras.


		private static final long serialVersionUID = 1L;
		// ATRIBUTOS 
		//LISTAS STATIC PARA LA SERIALIZACION 
        public static ArrayList<Producto> productos = new ArrayList<> ();
        public static ArrayList<Empleado> empleados = new ArrayList<> ();
        private CentroAdopcion centroAdopcion;
        
        //CONSTRUCTORES//
        public Tienda(Empleado empleado, CentroAdopcion centroAdopcion){
            Tienda.empleados.add(empleado); //TIENDA CON UN EMPLEADO
            this.centroAdopcion = centroAdopcion; 
                     
        }

        public Tienda(Empleado empleado){
            Tienda.empleados.add(empleado);
            //tienda definida solo con su centro de adopcion;     
            
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
        public ArrayList<Empleado> empleadosTienda(){ //DEVUELVE EL ARRAY DE EMPLEADOS  
            return empleados;
        }

        public void agregarProducto(Producto producto){ 
            if(empleados!=null){     // SI HAY UN EMPLEADO, SE AGREGA EL PRODUCTO DEL PARÁMETRO
                productos.add(producto);
            }
        }

        public String inventario(){ //INVENTARIO 
            if(empleados!=null){// SI HAY UN EMPLEADO SE HACE INVENTARIO 
            	String resultado = ""; //STRING DONDE SE VA A GUARDAR EL TEXTO 
            	int indice = 1; // INDICE QUE SE VA A MOSTRAR ENCIMA DEL PRODUCTO 
            	
            	for (int i = 0; i<productos.size();i++) {
            		resultado += indice+"."+productos.get(i).toString(); // RECORREMOS LA LISTA, CONCATENANDO EL INDICE CON EL PROTUCTO EN STRING
            		indice = indice+1;
            	}
                return resultado; // SE DEVULVE EL RESULTADO
            }
            else {
                return "No hay empleado para atender la tienda";
            }
        }
        
        public String filtrar(String tipo){ //FILTRAR
            if(empleados!=null){ // SI HAY POR LO MENOS UN EMPLEADO EN LA TIENDA, SE HACE EL FILTRADO DE PRODUCTOS 
            	String resultado = ""; //SE CREA UN STRING DONDE SE VA A ALMACENAR LOS PRODUCTOS CON UN ÍNDICE
            	int indice = 0;
            	for (int i = 0; i<productos.size();i++) { // SE RECORRE LA LISTA 
              		indice = indice+1; //ÍNDICE QUE SE MUESTRA POR UNCIMA DEL PRODUCTO 
            		if (productos.get(i).getTipoAnimal().equals(tipo) || productos.get(i).getTipoAnimal().equals("Uso general")) { // SI LOS PRODUCTOS SON DE USO GENERAL, O DEL TIPO DEL ANIMAL INGRESADO
            			resultado += indice+"."+productos.get(i).toString(); // SE ANEXAN LOS PRODUCTOS AL STRING QUE SE VA A RETORNAR
            		}
            	}
                return resultado;
            }
            else {
                return "No hay empleado para atender la tienda";
            }
        }

        // MÉTODOS DE COMPRA-------------------------------------------------------------------------------------------- 
        public String compra(int indice, Cliente cliente){
        	
            if (empleados!=null){ // SE COMPRUEBA SI HAY UN EMPLEADO PARA LA OPERACION DE LA TIENDA 
            	
                indice -= 1;//CONVERTIMOS EL NÚMERO A INDICE DE LISTA
                
                if (indice>=productos.size() || indice<0) { //COMPROBAMOS SI EL INDICE ES CORRECTO 
                	return "No pudimos realizar la compra, el índice no es válido.";
                }
                
                int cantidad = productos.get(indice).getCantidadUnidades(); // SE TOMA LA CANTIDAD DEL PRODUCTO

                if (cantidad!=0){// SI LA CANTIDAD ES DIFERENTE DE 0 SE HACE LA COMPRA
                    cantidad-=1;
                    productos.get(indice).setCantidadUnidades(cantidad); // SE TRAE EL PRODUCTO DE LA LISTA DE PRODUCTOS 
                    String nombre = productos.get(indice).getNombre();
                    String tipo =  productos.get(indice).getTipoAnimal();
                
                    if (productos.get(indice).getCantidadUnidades()==0) {
                    	productos.remove(indice); // SI LAS UNIDADES QUEDAN EN CERO, SE ELIMINA EL PRODUCTO DE LA LISTA 
                    }
                    
                    cliente = CentroAdopcion.isCliente(cliente); // SE COMPRUEBA SI EL CLIENTE EXISTE 
                    float precio = productos.get(indice).getPrecio(); // SE GUARDA EL PRECIO PARA LA FUTURA FACTURA 
                    int puntos = cliente.getPuntos(); //SE TOMAN LOS PUNTOS DEL CLIENTE
                    
                    if (puntos>=15) {// SI TIENE MÁS DE 15 PUNTOS ACOMULADOS, SE LE HACE UN DESCUENTO AUTOMÁTICAMENTE
                    	cliente.disminuir_puntos(puntos); // SE LE QUITAN LOS 15 PUNTOS 
                    	precio -= precio*0.1; // SE MODIFICA EL PRECIO ORIGINAL 
                    	// EN EL RETURN DEVOLVEMOS LO IMPORTADO 
                    	 return "-------------------------------------------\n"+"Has comprado una unidad de: "+nombre+" para "+tipo+"\n"+"Total a pagar: "+precio+" $"+"\n"+"Han sido utilizados 15 puntos para un 10% de descuento\n"+"Puntos restantes: "+cliente.getPuntos()+"\n-------------------------------------------";
                    }else {
                    	return "-------------------------------------------\n"+"Has comprado una unidad de: "+nombre+" para "+tipo+"\n"+"Total a pagar: "+precio+" $"+"\n"+"No cuentas con los suficientes puntos como para un descuento\n"+"-------------------------------------------";
                    }
                }
                else{
                    return "No hay unidades suficientes.";
                }
            }else{
                return "No hay un empleado para atenderlo.";
            }
        }
        
        
        public String compra(int indice, int unidades, Cliente cliente){
        	
            if (empleados!=null){ // SE COMPRUEBA SI HAY UN EMPLEADO PARA LA OPERACION DE LA TIENDA  
            	
                indice -= 1; //CONVERTIMOS EL NÚMERO A INDICE
                
                if (indice>=productos.size() || indice<0) { //COMPROBAMOS SI EL INDICE ES CORRECTO 
                	return "No pudimos realizar la compra, el índice es incorrecto.";
                }
                int cantidad = productos.get(indice).getCantidadUnidades(); //GUARDAMOS LA CANTIDAD DE UNIDADES DEL PRODUCTO A COMPRAR

                if (cantidad!=0 && cantidad>=unidades){//SI LA CANTIDAD INGRESADA ESTÁ DENTRO DEL RANGO INICIA LA OPERACION DE LA TIENDA 
                	
                    cantidad-=unidades; // SE RESTA LAS UNIDADES QUE SE COMPRARON 
                    productos.get(indice).setCantidadUnidades(cantidad); // SE CAMBIA LAS UNIDADES RESTANTES EN EL PRODUCTO
                    String nombre = productos.get(indice).getNombre();
                    String tipo = productos.get(indice).getTipoAnimal(); 
                    if (productos.get(indice).getCantidadUnidades()==0) {
                    	productos.remove(indice);// SI LA CANTIDAD LLEGA A 0, SE ELIMINA EL PRODUCTO  
                    	
                    }
                    
                    cliente = CentroAdopcion.isCliente(cliente); // SE COMPRUEBA SI EL CLIENTE EXISTE 
                    float precio = productos.get(indice).getPrecio(); // SE GUARDA EL PRECIO PARA GENERAR DESPUES FACTURA 
                    int puntos = cliente.getPuntos(); //SE TOMAN LOS PUNTOS 
                    
                    if (puntos>=15) { // SI TIENE MÁS DE 15 PUNTOS ACOMULADOS, SE LE HACE UN DESCUENTO AUTOMÁTICAMENTE
                    	cliente.disminuir_puntos(puntos); // SE RESTAN LOS 15 PUNTOS QUE SE USARON COMO DESCUENTO
                    	precio -= precio*unidades*0.1; // SE CALCULA EL PRECIO CON EL 10% DE DESCUENTO
                    	 return "-------------------------------------------\n"+"Has comprado "+unidades+" unidades de: "+nombre+" para "+tipo+"\n"+"Total a pagar: "+precio+" $"+"\n"+"Han sido utilizados 15 puntos para un 10% de descuento\n"+"Puntos restantes: "+cliente.getPuntos()+"\n-------------------------------------------";
                    }else {// DEVUELVE SOLAMENTE PRECIO PORQUE NO TIENE LOS PUNTOS SUFUCIENTES
                    	return "-------------------------------------------\n"+"Has comprado "+unidades+" unidades de: "+nombre+" para "+tipo+"\n"+"Total a pagar: "+precio*unidades+" $"+"\n"+"No cuentas con los suficientes puntos como para un descuento\n"+"-------------------------------------------";
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


        public String toString(){
            return "Tienda con empleados: "+empleadosTienda();
        }
    }




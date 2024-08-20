package gestorAplicacion.componentes;

import java.io.Serializable;

public class Producto implements Serializable{
	
	//DANIEL ALBERTO ZAPATA CASTAÑO
	//OKY RUIZ DE LA ROSA
	//SALOMÉ MURILLO GAVIRIA
	//NICOLAS DAVID ZAMBRANO MURCIA

	private static final long serialVersionUID = 1L;
	//Atributos 
    private String nombre;
    private float precio;
    private String tipoAnimal; //tipo de animal al que vá dirigido el producto 
    private int cantidadUnidades; 

    /*filtrar por tipo de producto comida, vesrir etc.*/

    //constructor 
    public Producto(String nombre, float precio, String tipoAnimal, int cantidadUnidades){
        this.nombre = nombre;
        this.precio = precio;
        this.tipoAnimal = tipoAnimal;
        this.cantidadUnidades = cantidadUnidades;
    }
    
    public Producto(String nombre, float precio,  int cantidadUnidades){
        this.nombre = nombre;
        this.precio = precio;
        this.tipoAnimal = "Uso general";
        this.cantidadUnidades = cantidadUnidades;
    }



    //Métodos setter and getter 
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getNombre(){
        return this.nombre;
    }

    public void setPrecio(float precio){
        this.precio = precio;
    }
    public float getPrecio(){
        return this.precio;
    }

    public void setTipoAnimal(String tipo){
        this.tipoAnimal = tipo;
    }
    public String getTipoAnimal(){
        return this.tipoAnimal;
    }

    public void setCantidadUnidades(int cantidad){
        this.cantidadUnidades = cantidad;
    }
    public int getCantidadUnidades(){
        return this.cantidadUnidades;
    }

    //método to String
    public String toString(){
        return "\nProducto: "+getNombre()+"\n"+"Precio: "+getPrecio()+"\n"+"Dirigido a: "+getTipoAnimal()+"\n"+ "Cantidad unidades: "+getCantidadUnidades()+"\n";        
    }
    

}

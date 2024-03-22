package gestorAplicación.servicioAdicional;

public class Producto {
    //Atributos 
    private String nombre;
    private float precio;
    private String tipoAnimal; //tipo de animal al que vá dirigido el producto 
    private int cantidadUnidades; 

    //constructor 
    public Producto(String nombre, float precio, String tipoAnimal, int cantidadUnidades){
        this.nombre = nombre;
        this.precio = precio;
        this.tipoAnimal = tipoAnimal;
        this.cantidadUnidades = cantidadUnidades;
    }

    //Si no se especifica el tipoAnimal al que va dirigido el producto, se toma como:
    public Producto(String nombre, float precio, int cantidadUnidades){
        this(nombre, precio, "Uso general", cantidadUnidades);
    }

    //constructor vacío (just for fun)
    public Producto(){}

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
        return "Producto: "+getNombre()+"\n"+"Precio: "+getPrecio()+"\n"+"Dirijido a: "+getTipoAnimal()+"\n"+ "Cantidad unidades: "+getCantidadUnidades();        
    }
    

}

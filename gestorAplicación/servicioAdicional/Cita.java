package gestorAplicación.servicioAdicional;
import java.time.LocalDate;
import gestorAplicación.procesoAdopcion.Animal;
import gestorAplicación.procesoAdopcion.Cliente;

public class Cita{
    private Cliente cliente;
    private Animal animal;
    private LocalDate fecha;
    private String estado; 
    private Empleado empleado;
    private Cupo cupo;
    private double costo;
    
    
    public Cita(Cliente cliente, Animal animal, LocalDate fecha) {
    	this.cliente=cliente;
    	this.animal=animal;
    	this.fecha=fecha;
    	this.estado="pendiente";
    	}
    
    public Cita(Cliente cliente, Animal animal,Empleado empleado, Cupo cupo, int servicio ) {
    	
    	this.cliente=cliente;
    	this.animal=animal;
    	this.empleado=empleado;
    	
    	cupo.setDisponible(false);//PARA MARCAR QUE EL CUPO YA NO ESTARÁ DISPONIBLE 	
    	this.cupo=cupo;
    	
    	if (servicio==1) {
    		this.costo= 10000;//COSTO DE UNA CITA DE GUARDERÍA
    		this.cliente.agregar_puntos(3); //POR CITA DE GUARDERIA GANA 3 PUNTOS
    	}
    	
        if (servicio==2) {
        	this.costo=20000; //COSTO DE UNA CITA DE VETERINARIA
        	this.cliente.agregar_puntos(5);//POR CITA DE VETERINARIA GANA 5 PUNTOS
    		}
        
        if (servicio==3) {
        	this.costo=15000; //COSTO DE UNA CITA DE PELUQUERÍA
        	this.cliente.agregar_puntos(4);//POR CITA DE PELUQUERIA GANA 4 PUNTOS
        }
    		
    	
    	
    }
    
	public Cliente getCliente() {
        return cliente;
    }

    public Animal getAnimal() {
        return animal;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}



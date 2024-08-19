package gestorAplicación.servicioAdicional;
import java.time.LocalDate;
import gestorAplicación.procesoAdopcion.Animal;
import gestorAplicación.procesoAdopcion.Cliente;

public class Cita{
	public enum EstadoCita{
		PENDIENTE,RECHAZADA,ACEPTADA,APLAZADA
	}
    private Cliente cliente1;
    private Animal animal;
    private Cliente cliente2;
    private Animal animal2;
    private LocalDate fecha;
    private EstadoCita Estado;
    private String estado;
    private Cupo cupo;
    private Empleado empleado;
    private Cliente cliente;
    private double costo;
    
    
    public Cita(Cliente cliente1, Cliente cliente2, Animal animal, Animal animal2, LocalDate fecha) {
    	this.cliente1=cliente1;
    	this.cliente2=cliente2;
    	this.animal=animal;
    	this.animal2=animal2;
    	this.fecha=fecha;
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
        return cliente1;
    }
	
	public Cliente getCliente2(){
		return cliente2;
	}

    public Animal getAnimal() {
        return animal;
    }
    
    public Animal getAnimal2() {
        return animal2;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public EstadoCita getEstado() {
        return Estado;
    }

    public void setEstado(EstadoCita estado) {
        this.Estado = estado;
    }
    
    public void setFecha(LocalDate fecha) {
    	this.fecha=fecha;
    }
}



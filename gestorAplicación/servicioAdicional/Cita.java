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
    private EstadoCita estado;
    
    public Cita(Cliente cliente1, Cliente cliente2, Animal animal, Animal animal2, LocalDate fecha) {
    	this.cliente1=cliente1;
    	this.cliente2=cliente2;
    	this.animal=animal;
    	this.animal2=animal2;
    	this.fecha=fecha;
    	this.estado=EstadoCita.PENDIENTE;
    	}
    //empleado,cupo,costo//
    
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
        return estado;
    }

    public void setEstado(EstadoCita estado) {
        this.estado = estado;
    }
    
    public void setFecha(LocalDate fecha) {
    	this.fecha=fecha;
    }
}



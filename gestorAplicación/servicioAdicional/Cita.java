package gestorAplicación.servicioAdicional;
import java.time.LocalDate;
import gestorAplicación.procesoAdopcion.Animal;
import gestorAplicación.procesoAdopcion.Cliente;

public class Cita{
    private Cliente cliente;
    private Animal animal;
    private LocalDate fecha;
    private String estado; 
    
    public Cita(Cliente cliente, Animal animal, LocalDate fecha) {
    	this.cliente=cliente;
    	this.animal=animal;
    	this.fecha=fecha;
    	this.estado="pendiente";
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



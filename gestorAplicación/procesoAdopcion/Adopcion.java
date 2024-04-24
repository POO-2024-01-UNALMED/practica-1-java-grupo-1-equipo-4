package gestorAplicación.procesoAdopcion;

import java.time.LocalDate;

public class Adopcion {
    
	private Animal animal;
	private Cliente cliente;
	private LocalDate fechaAdopcion;
	
	//CONSTRUCTOR
	
	public Adopcion(Animal animal, Cliente cliente) {
		LocalDate fechaActual = LocalDate.now();
		this.animal = animal;
		this.cliente = cliente;
		this.fechaAdopcion = fechaActual;
	}
	
	//MÉTODOS SETTER Y GETTER
	
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	
	public Animal getAnimal() {
		return animal;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente= cliente;
	}
	
	public Persona getCliente() {
		return cliente;
	}
	
	public LocalDate getFechaAdopcion() {
		return fechaAdopcion;
	}
	
	public void setFechaAdopcion(LocalDate fecha) {
		this.fechaAdopcion=fecha;
	}
	
	//OTROS MÉTODOS

	public static boolean encuesta(int puntaje) {
		return puntaje > 20;
	}
	
	
	public String toString() {
		return "Mascota - " + getAnimal() + "\nAdoptante -  " + getCliente() + "Fecha de adopcion - " + getFechaAdopcion();
	}
}

package gestorAplicación.procesoAdopcion;

import java.time.LocalDate;

public class Adopcion {
    
	private Animal animal;
	private Persona persona;
	private LocalDate fechaAdopcion;
	
	//constructor
	
	public Adopcion(Animal animal, Persona persona) {
		this.animal = animal;
		this.persona = persona;
	}
	
	//setter y getter
	
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	
	public Animal getAnimal() {
		return animal;
	}
	
	public void setAdoptante(Persona persona) {
		this.persona = persona;
	}
	
	public Persona getAdoptante() {
		return persona;
	}
	
	public LocalDate getFechaAdopcion() {
		return fechaAdopcion;
	}
	
	//toString
	
	public String toString() {
		return "Mascota: " + getAnimal() + "\nAdoptante: " + getAdoptante() + "\nFecha de adopcion: " + getFechaAdopcion();
	}
	
	//FALTA ENCUESTA
}

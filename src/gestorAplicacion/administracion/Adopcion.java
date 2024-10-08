package src.gestorAplicacion.administracion;

import java.io.Serializable;
import java.time.LocalDate;

import src.gestorAplicacion.componentes.Animal;
import src.gestorAplicacion.componentes.Cliente;

//DANIEL ALBERTO ZAPATA CASTAÑO
//OKY RUIZ DE LA ROSA
//SALOMÉ MURILLO GAVIRIA
//NICOLAS DAVID ZAMBRANO MURCIA

//DESCRIPCIÓN DE LA CLASE:
// Registra información sobre el proceso de adopción, incluyendo el animal adoptado, el adoptante y la fecha de adopción.

public class Adopcion implements Serializable {
    
	private static final long serialVersionUID = 1L;
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
	
	//MÉTODO DE CLASE
	public static String preguntasEncuesta(int pregunta) {
		
		switch(pregunta) {
		
		case 1:
			return "\n1. ¿Tiene experiencia en el cuidado de mascotas?";
			
		case 2:
			return "\n2. ¿Cuánto tiempo puede dedicar diariamente a la atención y el cuidado de la mascota?";
			
		case 3:
			return "\n3. ¿Con qué frecuencia planea viajar en los próximos meses?";
		
		case 4:
			return "\n4. ¿Tiene un espacio adecuado en su hogar para la mascota, tanto en interiores como en exteriores?";
			
		case 5:
			return "\n5. ¿Ha considerado los requisitos específicos de ejercicio y cuidados para la raza/tipo de mascota?";
		
		case 6:
			return "\n6. ¿Está dispuesto a someter a la mascota a chequeos veterinarios regulares?";
		
		case 7:
			return "\n7. ¿Está dispuesto a recibir visitas por parte de AdoptaLove para enterarnos del estado de la mascota?";
			
		default:
			return " ";
		}
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
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public LocalDate getFechaAdopcion() {
		return fechaAdopcion;
	}
	
	public void setFechaAdopcion(LocalDate fecha) {
		this.fechaAdopcion=fecha;
	}
	

		
	public String toString() {
		return "- Adoptante: " + getCliente().getNombre() +
				"\n- CC: " + getCliente().getCedula()+
				"\n- Mascota: " + getAnimal().getNombre()+
				"\n- Tipo: " + getAnimal().getEspecie()
				+ "\n- Fecha: " + getFechaAdopcion();
	}
	
	

}

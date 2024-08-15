package gestorAplicación.servicioAdicional;
import gestorAplicación.procesoAdopcion.*;

public class Muerto {
	
	private Animal animal;
	private String fecha;
	private String mensaje;
	private Cliente dueño;
	private String tiempo;
	private String tipo;
	private String[] flores = new String[5];
	
	public Muerto (Animal animal, String fecha, String mensaje, Cliente dueño, String tiempo, String tipo) {
		this.animal = animal;
		this.dueño = dueño;
		this.fecha = fecha;
		this.mensaje = mensaje;
		this.tiempo = tiempo;
		this.tipo = tipo;
		flores[0] = "No hay flores"; 
	}
	
	//SETTER AND GETTER //
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	public Animal getAnimal() {
		return this.animal;
	}
	
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getFecha() {
		return this.fecha;
	}
	
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getMensaje() {
		return this.mensaje;
	}
	
	public void setDueño(Cliente cliente) {
		this.dueño = cliente;
	}
	public Cliente getDueño() {
		return this.dueño;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getTipo() {
		return this.tipo;
	}
	
	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}
	public String getTiempo() {
		return this.tiempo;
	}
	
	
	
	// MÉTODO toString //
	public String toString() {
		return animal.getNombre()+"\n"+fecha+"\n"+mensaje;
	}
	
	// MÉTODOS //
	public String ponerFlor(String flor) {
		if (flores[0].equals("No hay flores")) {
			flores[0] = flor;
		}
		else if(flores.length==1) {
			flores[1] = flor;
		}
		else {
			flores[flores.length-1] = flor;
		}
		
		return "Se ha mandado un jardinero a colocar la flor: "+flor+".";
	}
	
	
	
	
	
	
	
	
	

}







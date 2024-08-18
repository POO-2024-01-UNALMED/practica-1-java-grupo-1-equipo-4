package gestorAplicación.servicioAdicional;
import java.util.ArrayList;
import gestorAplicación.procesoAdopcion.*;

public class Muerto {
	
	private Animal animal;
	private String fecha;
	private String mensaje;
	private Cliente dueño;
	private String tiempo;
	private String tipo;
    private ArrayList<String> flores = new ArrayList<> ();
    
    // CONSTRUCTOR //
    public Muerto() {
		flores.add("No hay flores");
    }
    
	public Muerto (Animal animal, String fecha, String mensaje, Cliente dueño, String tiempo, String tipo) {
		this.animal = animal;
		this.dueño = dueño;
		this.fecha = fecha;
		this.mensaje = mensaje;
		this.tiempo = tiempo;
		this.tipo = tipo;
		flores.add("No hay flores");
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
	
	
	// MÉTODOS //
	public String ponerFlor(String flor) {
		if (flores.get(0).equals("No hay flores")) {
			flores.clear();
			flores.add(flor);
			return "Se ha mandado un jardinero a colocar la flor: "+flor+".";
		}
		else if(flores.size()<=5) {
			flores.add(flor);
			return "Se ha mandado un jardinero a colocar la flor: "+flor+".";
		}
		else {
			return "Hay un límite de 5 flores.";
		}	
	}
	
	public String mostrarFlores() {
		if (flores.get(0).equals("No hay flores")) {
			return flores.get(0);
		}
		else {
			String acomulador = "Flores que hay puestas: ";
		
			for(int i = 0; i>flores.size();i++) {	
				acomulador += flores.get(i)+", ";
			}
			acomulador+=".";
			return acomulador;
		}
	}
	
	
	// MÉTODO toString //
	public String toString() {
		return animal.getNombre()+"\n"+fecha+"\n"+mensaje+"\n"+this.mostrarFlores();
	}
	
}







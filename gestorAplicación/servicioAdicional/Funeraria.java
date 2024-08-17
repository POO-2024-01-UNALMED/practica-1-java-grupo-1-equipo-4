package gestorAplicación.servicioAdicional;
import gestorAplicación.procesoAdopcion.*;
import java.util.ArrayList;

public class Funeraria {
	
	private CentroAdopcion centro;
	private ArrayList<Muerto> tumbas = new ArrayList<> ();
	private ArrayList<Muerto> cenizas = new ArrayList<> ();
	
	//CONSTRUCTORES//
	public Funeraria () {
		//CONSTRUCTOR VACÍO
	}
	public Funeraria (CentroAdopcion centro) {
		this.centro = centro;
	}
	
	// SET AND GET DE CENTRO ADOPCION //
	public void setCentro(CentroAdopcion centro) {
		this.centro = centro;
	}
	public CentroAdopcion getCentro() {
		return this.centro;
	}
	
	public String getNombre() {
		return centro.getNombre();
	}
	
	// MÉTODOS //
	
	//ESPACIOS
	public boolean espacioCenizas() {
		if (cenizas.size()<=25) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean espacioTumbas() {
		if (tumbas.size()<=15) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//AÑADIR TUMBA/CENIZAS
	public void añadirTumba(Animal animal, String fecha, String mensaje, Cliente dueño, String tiempo) {
		/*SE AÑADE LA TUMBA AL CEMENTERIO (LA LISTA DE TUMBAS)*/
		tumbas.add(new Muerto (animal, fecha,  mensaje,  dueño,  tiempo, "Tumba"));
	}
	
	public void añadirCenizas(Animal animal, String fecha, String mensaje, Cliente dueño, String tiempo) {
		/*SE AÑADEN LAS CENIZAS AL OSARIO (LA LISTA DE TUMBAS)*/
		cenizas.add(new Muerto (animal, fecha,  mensaje,  dueño,  tiempo, "Cenizas"));
	}
	
	
	
	
	
}

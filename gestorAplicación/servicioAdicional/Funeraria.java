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
		tumbas.add(new Muerto (animal, fecha,  mensaje,  dueño,  tiempo, "Tumba"));
	}
	
	public void añadirCenizas(Animal animal, String fecha, String mensaje, Cliente dueño, String tiempo) {
		cenizas.add(new Muerto (animal, fecha,  mensaje,  dueño,  tiempo, "Cenizas"));
	}
	
	
	
	
	
	
	
}

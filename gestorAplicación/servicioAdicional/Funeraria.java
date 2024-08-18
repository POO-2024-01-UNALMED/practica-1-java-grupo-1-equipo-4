package gestorAplicación.servicioAdicional;
import gestorAplicación.procesoAdopcion.*;
import java.util.ArrayList;

public class Funeraria {
	
	// ARRAYLIST LISTOS PARA LA SERIALIZACIÓN
	private CentroAdopcion centro;
	public static ArrayList<Muerto> tumbas = new ArrayList<> ();
	public static ArrayList<Muerto> cenizas = new ArrayList<> ();
	
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
	
	public void añadirTumba(Muerto tumba) {
		tumba.setTipo("Tumba");
		tumbas.add(tumba);
	}
	
	public void añadirCenizas(Animal animal, String fecha, String mensaje, Cliente dueño, String tiempo) {
		/*SE AÑADEN LAS CENIZAS AL OSARIO (LA LISTA DE TUMBAS)*/
		cenizas.add(new Muerto (animal, fecha,  mensaje,  dueño,  tiempo, "Cenizas"));
	}
	
	public void añadirCenizas(Muerto ceniza) {
		ceniza.setTipo("Cenizas");
		cenizas.add(ceniza);
	}
	
    public String visita(String tipo){ //FILTRAR
    	String resultado = "";

    	if (tipo.equals("tumbas")) {
        	int indice = 0;
        	for (int i = 0; i<tumbas.size();i++) {
        		indice = indice+1;
        		resultado += indice+". "+tumbas.get(i).toString()+"\n";
        	}
    	}
    	else {
         	int indice = 0;
        	for (int i = 0; i<cenizas.size();i++) {
        		indice = indice+1;
        		resultado += indice+". "+cenizas.get(i).toString()+"\n";
        	}
    	}
            return resultado; 
    }
    
    public String florCenizas(int indice, String flor){
            indice -= 1;
            return cenizas.get(indice).ponerFlor(flor);
    }    
    
    public String florTumbas(int indice, String flor) {   
    	indice -= 1;
    	return tumbas.get(indice).ponerFlor(flor);
       
    }
    
}

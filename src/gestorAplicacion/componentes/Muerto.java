package src.gestorAplicacion.componentes;

import java.io.Serializable;
import java.util.ArrayList;

public class Muerto implements Serializable{
	
	//DANIEL ALBERTO ZAPATA CASTAÑO
	//OKY RUIZ DE LA ROSA
	//SALOMÉ MURILLO GAVIRIA
	//NICOLAS DAVID ZAMBRANO MURCIA
	
	//DESCRIPCIÓN DE LA CLASE:
	//Representa a los animales que han fallecido, almacenando información sobre el dueño, fecha de fallecimiento y mensajes de recuerdo.
	
	private static final long serialVersionUID = 1L;
	private Animal animal;
	private String fecha;
	private String mensaje;
	private Cliente dueño;
	private String tiempo; // TIEMPO DE ALQUILER O SI ES PROPIO, SALDRÁ COMO PERMANENTE
	private String tipo; // SI ES OSARIO O TUMBA 
    private ArrayList<String> flores = new ArrayList<> (); // LISTA DE FLORES (SON STRINGS)
    
    // CONSTRUCTOR //
    public Muerto() {
		flores.add("No hay flores aquí."); //EMPIEZAN SIN FLORES
    }
    
	public Muerto (Animal animal, String fecha, String mensaje, Cliente dueño, String tiempo, String tipo) {
		this.animal = animal;
		this.dueño = dueño;
		this.fecha = fecha;
		this.mensaje = mensaje;
		this.tiempo = tiempo;
		this.tipo = tipo;
		flores.add("No hay flores aquí."); // EMPIEZAN SIN FLORES
	}
	
	//SETTER AND GETTER //
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	public Animal getAnimal() {
		return this.animal;
	}
	
	public ArrayList<String> getFlores() {
		return flores;
	}
	
	public void setFlores(ArrayList<String> flores) {
		this.flores = flores;
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
		
		if (flores.get(0).equals("No hay flores aquí.")) { //VERIFICA SI VA A SER LA PRIMERA FLOR QUE SE COLOQUE
			
			flores.clear(); // ELIMINA LO DE "NO HAY FLORES AQUÍ" PARA REEMPLAZARLO CON LA FLOR INGRESADA EN EL PARÁMETRO
			flores.add(flor);
			return "Pronto, un jardinero pondrá las flores: "+flor+"."; // RETORNO 
		}
		else if(flores.size()<=5) { // SI YA TENÍA FLORES DE ANTES, SE REVISA QUE NO TENGA EL MAXIMO DE 5
			flores.add(flor); // SE AÑADE LA FLOR SIN MÁS 
			return "Pronto, un jardinero pondrá las flores: "+flor+".";
		}
		else {// SI NO CUMPLE EL MAXIMO DE 5 FLORES
			return "Hay un límite de 5 tipos de flores.";
		}	
	}
	
	public String mostrarFlores() { 
		
		if (flores.get(0).equals("No hay flores aquí.")) { //SE PREGUNTA SI EL PRIMER ELEMENTO, ES "NO HAY FLORES AQUÍ"
			return flores.get(0); // ESTE CONTROL ES NECESARIO PARA PODER AJUSTAR EL RETORNO EN CASO DE QUE HAYAN FLORES
		}
		else if(flores.size()==1) { // SI SOLO HAY UNA, SE IMPRIME SIN MÁS
			return "Hay: "+flores.get(0);
		}
		else { // SI HAY MÁS DE UNA, SE CREA EL ACOMULADOR PARA RECORRER LA LISTA Y CONCATENAR 
			String acomulador = "Flores que hay: ";
		
			for(int i = 0; i<flores.size();i++) {	
				acomulador += flores.get(i)+" "; // SE AÑADEN LAS FLORES AL ACOMULADOR 
			}
			return acomulador;// SE RETORNA EL ACOMULADOR CON LAS FLORES
		}
	}
	
	
	// MÉTODO toString //
	public String toString() {
		return animal.getNombre()+"\n"+fecha+"\n"+mensaje+"\n"+this.mostrarFlores()+"\n";
	}
	
}







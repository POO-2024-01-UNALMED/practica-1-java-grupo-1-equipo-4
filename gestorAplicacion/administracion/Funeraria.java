package gestorAplicacion.administracion;
import java.io.Serializable;
import java.util.ArrayList;

import gestorAplicacion.componentes.Animal;
import gestorAplicacion.componentes.Cliente;
import gestorAplicacion.componentes.Muerto;

public class Funeraria implements Serializable{
	
	//DANIEL ALBERTO ZAPATA CASTAÑO
	//OKY RUIZ DE LA ROSA
	//SALOMÉ MURILLO GAVIRIA
	//NICOLAS DAVID ZAMBRANO MURCIA
	
	//DESCRIPCIÓN DE LA CLASE:
	//Proporcionar servicios de cremación y entierro para mascotas fallecidas, gestionando la memoria de los animales.
	
	private static final long serialVersionUID = 1L;
	// ARRAYLIST LISTOS PARA LA SERIALIZACIÓN
	private CentroAdopcion centro;
	public static ArrayList<Muerto> tumbas = new ArrayList<> ();
	public static ArrayList<Muerto> cenizas = new ArrayList<> ();
	
	//CONSTRUCTOR//

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
	
	public static ArrayList<Muerto> getTumbas(){
    	return tumbas;
    }
    
    public static ArrayList<Muerto> getCenizas(){
    	return cenizas;
    }
    
	
	//ESPACIOS
	public boolean espacioCenizas() { //REVISA SI EN LA LISTA DE CENIZAS HAY ESPACIO PARA COLOCAR MÁS
		if (cenizas.size()<=25) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean espacioTumbas() { //REVISA SI EN LA LISTA DE TUMBAS HAY ESPACIO PARA COLOCAR MÁS
		if (tumbas.size()<=15) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//AÑADIR TUMBA/CENIZAS
	public void añadirTumba(Muerto tumba) { //RESIVE UN OBJETO DE TIPO MUERTO, AL CUAL LE ESTABLECE EL TIPO COMO "TUMBA" Y LO AÑADE A SU RESPECTIVA LISTA 
		tumba.setTipo("Tumba");
		tumbas.add(tumba);
	}
	
	public void añadirCenizas(Muerto ceniza) { //RESIVE UN OBJETO DE TIPO MUERTO, AL CUAL LE ESTABLECE EL TIPO COMO "CENIZAS" Y LO AÑADE A SU RESPECTIVA LISTA 
		ceniza.setTipo("Cenizas");
		cenizas.add(ceniza);
	}
	
    public String visita(String tipo){ // RECIBE UN TIPO PARA ESCOGER LA LISTA A RECORRER
    	
    	String resultado = ""; // ACOMULADOR QUE VA A GUARDAR LOS INDICES Y OBJETOS MUERTE EN STRING 

    	if (tipo.equals("tumbas")) { //SI EL TIPO ES IGUAL A "TUMBAS" SE RECORRE LA LISTA DE TUMBAS Y SE CONCATENAN LOS OBJETOS MUERTO PARA SU RETORNO 
        	int indice = 0;
        	for (int i = 0; i<tumbas.size();i++) {
        		indice = indice+1;
        		resultado += indice+". "+tumbas.get(i).toString()+"\n";
        	}
    	}
    	else {//COMO NO HAY NINGÚN OTRO TIPO DE MUERTO, SE RECORRE LA LISTA DE CENIZAS Y SE CONCATENAN LOS OBJETOS MUERTO PARA SU RETORNO 
         	int indice = 0;
        	for (int i = 0; i<cenizas.size();i++) {
        		indice = indice+1;
        		resultado += indice+". "+cenizas.get(i).toString()+"\n";
        	}
    	}
            return resultado; 
    }
    
    public String florCenizas(int indice, String flor){ //MÉTODO PARA AGREGAR UNA FLOR (EN CASO DE QUE TOQUE RECORRER LA LISTA DE CENIZAS)
            indice -= 1; // SE LE RESTA AL ÍNDICE, PORQUE EN LOS RETORNOS, SIEMPRE SE EMPIEZA DESDE 1
            
            return cenizas.get(indice).ponerFlor(flor); //SE LLAMA AL OBJETO MUERTO, Y A SU VEZ, SE LLAMA AL MÉTODO PONERFLOR(), DE ÉSTE.
    }    
    
    public String florTumbas(int indice, String flor) { //MÉTODO PARA AGREGAR UNA FLOR (EN CASO DE QUE TOQUE RECORRER LA LISTA DE TUMBAS) 
    	indice -= 1; // SE LE RESTA AL ÍNDICE, PORQUE EN LOS RETORNOS, SIEMPRE SE EMPIEZA DESDE 1
    	
    	return tumbas.get(indice).ponerFlor(flor);//SE LLAMA AL OBJETO MUERTO, Y A SU VEZ, SE LLAMA AL MÉTODO PONERFLOR(), DE ÉSTE.
       
    }
    
}

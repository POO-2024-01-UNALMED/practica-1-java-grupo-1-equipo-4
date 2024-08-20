package gestorAplicacion.administracion;
import java.io.Serializable;
import java.util.ArrayList;

import gestorAplicacion.componentes.Muerto;

public class Funeraria implements Serializable{
	
	//DANIEL ALBERTO ZAPATA CASTAÑO
	//OKY RUIZ DE LA ROSA
	//SALOMÉ MURILLO GAVIRIA
	//NICOLAS DAVID ZAMBRANO MURCIA
	
	private static final long serialVersionUID = 1L;
	// ARRAYLIST LISTOS PARA LA SERIALIZACIÓN
	private CentroAdopcion centro;
	public static ArrayList<Muerto> tumbas = new ArrayList<> ();
	public static ArrayList<Muerto> cenizas = new ArrayList<> ();
	
	//TUMBAS PUESTAS BY DEFAULT 
//	static {
//		//CLIENTES BY DEFAULT
//		Cliente c1 = new Cliente("Miguel Cortés", 19, 1020349);
//		Cliente c2 = new Cliente("Julian Sanchéz", 18, 234933);
//		Cliente c3 = new Cliente("Catalina Salazar", 18, 666);
//		Cliente c4 = new Cliente("Nico Murcia", 19, 3335632);
//		Cliente c5 = new Cliente("Richard Pérez", 19, 339393);
//		
//		//ANIMALES BY DEFAULT
//		Animal b1 = new Animal("Rocky", "Perro", 8, "Macho");
//		Animal b2 = new Animal("Zimba", "Gato",13, "Macho");
//		Animal b3 = new Animal("Coco", "Pato", 15, "Hembra");
//		Animal b4 = new Animal("Lucero", "Vaca", 9 , "Macho");
//		Animal b5 = new Animal("Milo", "Hamster", 16, "Hembra");
//		
//		//MUERTOS BY DEFAULT
//		Muerto a1 = new Muerto(b1, "18/08/2022", "Eres nuestro ángel de cuatro patas, siempre en nuestros corazones.", c1, "Permanente", "tumba");
//		Muerto a2 = new Muerto(b2, "23/1/2023", "Tu lealtad y amor nunca serán olvidados.", c2, "4 años", "tumba");
//		Muerto a3 = new Muerto(b3, "7/05/2022", "Eternamente en nuestros pensamientos.", c3, "Permanente", "Osario");
//		Muerto a4 = new Muerto(b4, "21/07/2021", "Fuiste la vaca más bonita de mi rancho.", c4, "7 años", "tumba");
//		Muerto a5 = new Muerto(b5, "18/08/2024", "Te queremos y te extrañamos.", c5, "6 años", "Osario");
//		
//		//FLORES BY DEFAULT
//		a4.ponerFlor("Girasoles");
//		a3.ponerFlor("Margaritas");
//		a1.ponerFlor("Rosas");
//		a1.ponerFlor("Lirios");
//		a2.ponerFlor("Claveles");
//		a2.ponerFlor("Hortensias");
//		
//		//TUMBAS Y CENIZAS BY DEFUALT
//		Funeraria.cenizas.add(a5);
//		Funeraria.tumbas.add(a4);
//		Funeraria.tumbas.add(a2);
//		Funeraria.cenizas.add(a3);
//		Funeraria.tumbas.add(a1);
//	}
	
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

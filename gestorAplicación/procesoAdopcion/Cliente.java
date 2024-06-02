package gestorAplicación.procesoAdopcion;

public class Cliente extends Persona{
	
	//ATRIBUTOS	
	int puntos;
	
	//CONSTRUCTOR
	
	public Cliente(String nombre,int edad, long cedula,long telefono, String direccion) {
		
		super(nombre,edad,cedula,telefono,direccion);
	}
	
	public Cliente(String nombre, int edad, long cedula) {
		super(nombre, edad, cedula);
	}
	
	//-----------
	
	//MÉTODOS SETTER Y GETTER
	
	public void agregar_puntos(int puntos) {
		this.puntos+=puntos;
	}
	
	public void disminuir_puntos(int puntos) {
		this.puntos-=puntos;
	}
	
	public int getPuntos() {
		return this.puntos;
	}
	
	
	

	public String toString() {
		
		return "Nombre: " + getNombre() + ", Edad: "+ getEdad()+ ", Cedula: " + getCedula() +", Telefono: " 
				+ getTelefono() + ", Direccion "+ getDireccion() + "\n";	
	}
	
}

package gestorAplicación.procesoAdopcion;

public class Cliente extends Persona{
	
	//ATRIBUTOS	
	private int puntos;
	private boolean participar;
	
	//CONSTRUCTOR
	
	public Cliente(String nombre,int edad, long cedula,long telefono, String direccion ) {
		
		super(nombre,edad,cedula,telefono,direccion);
	}
	
	public Cliente(String nombre, int edad, long cedula) {
		super(nombre, edad, cedula);
	}
	
	public Cliente(String nombre,int edad,long telefono, boolean participar) {
		super(nombre,edad,telefono);
		this.participar=participar;
	}
	
	//-----------nk++
	
	//MÉTODOS SETTER Y GETTER
	
	public void actualizar_datos(int edad, long telefono, String direccion) {
		this.setEdad(edad);
		this.setTelefono(telefono);
		this.setDireccion(direccion);
		
	}
	
	public void agregar_puntos(int puntos) {
		this.puntos+=puntos;
	}
	
	public void disminuir_puntos(int puntos) {
		this.puntos-=puntos;
	}
	
	public int getPuntos() {
		return this.puntos;
	}
	
	public boolean isParticipar() {
		return participar;
	}
	

	public String toString() {
		
		return "Nombre: " + getNombre() + ", Edad: "+ getEdad()+ ", Cedula: " + getCedula() +", Telefono: " 
				+ getTelefono() + ", Direccion "+ getDireccion() + "\n";	
	}
	
}

package gestorAplicación.procesoAdopcion;

public class Persona {
	
	private String nombre;
	private int edad;
	private long cedula;
	private String direccion;
	private long telefono;

	
	//CONSTRUCTOR
	public Persona(String nombre,int edad, long cedula, String direccion, long telefono) {
		this.nombre= nombre;
		this.edad= edad;
		this.cedula= cedula;
		this.telefono= telefono;
		this.direccion= direccion;
	}
	
	//MÉTODOS SETTER Y GETTER
	
	public void setNombre(String nombre) {
		this.nombre= nombre;
	}
	public String getNombre() {
		return nombre;
	}
	
	public void setEdad(int edad) {
		this.edad= edad;
	}
	public int getEdad() {
		return edad;
	}
	
	public void setCedula(long cedula) {
		this.cedula= cedula;
	}
	public long getCedula() {
		return cedula;
	}
	
	public void setDireccion(String direccion) {
		this.direccion= direccion;
	}
	public String getDireccion() {
		return direccion;
	}
	
	public void setTelefono(long telefono) {
		this.telefono= telefono;
	}
	
	public long getTelefono() {
		return telefono;
	}
	
	//MÉTODO TO STRING
	
	public String toString() {
		return "Nombre: " + getNombre() + "\nEdad: "+ getEdad()+ "\nCedula: " + getCedula() +"\nTelefono: " 
				+ getTelefono() + "\nDireccion "+ getDireccion() + "\n";
	}

}



package gestorAplicacion.servicioAdicional;

import java.io.Serializable;

public class Cliente extends Persona implements Serializable{
	
<<<<<<< Updated upstream
	//DANIEL ALBERTO ZAPATA CASTAÑO
	//OKY RUIZ DE LA ROSA
	//SALOMÉ MURILLO GAVIRIA
	//NICOLAS DAVID ZAMBRANO MURCIA
	

=======
>>>>>>> Stashed changes
	private static final long serialVersionUID = 1L;
	//ATRIBUTOS	
	private int puntos;
	private Animal mascota;
	
	//CONSTRUCTOR
	
	public Cliente(String nombre,int edad, long cedula,long telefono, String direccion ) {
		
		super(nombre,edad,cedula,telefono,direccion);
	}
	
	public Cliente(String nombre, int edad, long cedula) {
		super(nombre, edad, cedula);
	}
	
	//-------------
	
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
	
	
	public void setMascota(Animal mascota){
		this.mascota=mascota;
	}
	
	public Animal getMascota() { 
		return mascota;
	}
	
	public String toString() {
		
		return "Nombre: " + getNombre() + ", Edad: "+ getEdad()+ ", Cedula: " + getCedula() +", Telefono: " 
				+ getTelefono() + ", Direccion "+ getDireccion() + "\n";	
	}
	
}

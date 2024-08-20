package src.gestorAplicacion.componentes;

import java.io.Serializable;

//DANIEL ALBERTO ZAPATA CASTAÑO
//OKY RUIZ DE LA ROSA
//SALOMÉ MURILLO GAVIRIA
//NICOLAS DAVID ZAMBRANO MURCIA

//DESCRIPCIÓN DE LA CLASE:
//Representa a las personas relacionadas con el centro de adopción, ya sean clientes o empleados. Almacena información personal básica.

public abstract class Persona implements Serializable{

	private static final long serialVersionUID = 1L;
	protected String nombre;
	protected int edad;
	protected long cedula;
	protected long telefono;
	protected String direccion;

	
	//CONSTRUCTOR
	public Persona(String nombre,int edad, long cedula,long telefono, String direccion) {
		this.nombre= nombre;
		this.edad= edad;
		this.cedula= cedula;
		this.telefono= telefono;
		this.direccion= direccion;
	}
	
	public Persona(String nombre,int edad, long cedula) {
		this.nombre= nombre;
		this.edad= edad;
		this.cedula= cedula;
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
		return "Nombre: " + getNombre() + "\nEdad: "+ getEdad()+ "\nCédula: " + getCedula() +"\nTelefono: " 
				+ getTelefono() + "\nDirección "+ getDireccion() + "\n";
	}
	


}



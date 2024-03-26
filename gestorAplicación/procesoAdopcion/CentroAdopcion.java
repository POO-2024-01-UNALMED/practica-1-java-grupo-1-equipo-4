package gestorAplicación.procesoAdopcion;
import java.util.ArrayList;

import gestorAplicación.servicioAdicional.Tienda;

public class CentroAdopcion {
	
	private static CentroAdopcion [] sedes = new CentroAdopcion[3];
	private ArrayList <Animal> animalesDisponibles = new ArrayList<>();
	private ArrayList <Adopcion> adopciones = new ArrayList<>();
	private String nombre;
	private int espaciosDisponibles = 0;
	private tipoServicio servicio;
	private Tienda tienda;
	public static enum tipoServicio{
		VETERINARIA, GUARDERIA, PELUQUERIA
	}
	
	
	public CentroAdopcion(String nombre, int espacios, tipoServicio servicio, Tienda tienda) {
		this.nombre= nombre;
		this.espaciosDisponibles= espacios;
		this.servicio= servicio;
		this.tienda= tienda;
	}
	
	public CentroAdopcion(String nombre, int espacios, tipoServicio servicio) {
		this(nombre, espacios,servicio, null );
	}
	
	
	//METODOS SETTER Y GETTER
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre= nombre;
	}
	
	public int getEspacios() {
		return espaciosDisponibles;
	}
	public void setEspacios(int espacios) {
		espaciosDisponibles= espacios;
	}
	
	public void  setServicio(tipoServicio servicio) {
		this.servicio= servicio;
	}
	public tipoServicio getServicio() {
		return servicio;
	}
	
	public Tienda getTienda() {
		return tienda;
	}
	
	//OTROS MÉTODOS
	public void agregarAnimal(Animal animal) {
		animalesDisponibles.add(animal);
		espaciosDisponibles--;
	}
	public void borrarAnimal(Animal animal) {
		int posicion= animalesDisponibles.indexOf(animal);
		animalesDisponibles.remove(posicion);
		espaciosDisponibles++;
	}
	
	public void agregarAdopcion(Adopcion adopcion) {
		adopciones.add(adopcion);
	}
	
	public ArrayList <Animal> consultarAnimales() {
		return animalesDisponibles;
		
	}
	
	
	public String toString() {
		return "Nombre:" + getNombre() + ", Espacios Disponibles: " + getEspacios();
		
	}

}

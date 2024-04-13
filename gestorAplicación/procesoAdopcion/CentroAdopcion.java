package gestorAplicación.procesoAdopcion;
import java.util.ArrayList;
import gestorAplicación.servicioAdicional.Empleado;
import gestorAplicación.servicioAdicional.Tienda;

public class CentroAdopcion {
	
	public static enum tipoServicio{
		VETERINARIA, GUARDERIA, PELUQUERIA
	}
	public static ArrayList<Adopcion> adopcionesGenerales= new ArrayList<Adopcion>();	
	private ArrayList <Empleado> empleados = new ArrayList<Empleado>();
	private ArrayList <Animal> animalesDisponibles = new ArrayList<Animal>();
	private ArrayList <Adopcion> adopciones = new ArrayList<Adopcion>();
	private String nombre;
	private int espaciosDisponibles = 0;
	private tipoServicio servicio;
	private Tienda tienda;

	
	
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
	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}
	
	public ArrayList<Adopcion> getAdopciones(){
		return adopciones;
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
		CentroAdopcion.adopcionesGenerales.add(adopcion);
	}
	
	public ArrayList <Animal> consultarAnimales() {
		return animalesDisponibles;
		
	}
	
	
	public String toString() {
		if (tienda!= null) {	
		return "Nombre: " + getNombre() + ", Espacios Disponibles: " + getEspacios() + ", Servicio: " + getServicio() + ", tienda: si ";
		}
		else {
			return "Nombre: " + getNombre() + ", Espacios Disponibles: " + getEspacios() + ", Servicio: " + getServicio() + ", tienda: no";
		}
		
	}

}

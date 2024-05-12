package gestorAplicación.procesoAdopcion;
import java.util.ArrayList;

import gestorAplicación.procesoAdopcion.CentroAdopcion.tipoServicio;
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
	
	public CentroAdopcion(String nombre, tipoServicio servicio) {
		this(nombre, 0, servicio, null);
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
	
	public ArrayList<Empleado> getEmpleados(){
		return empleados;
	}
	
	
	//OTROS MÉTODOS
	
	public static boolean esCliente(long cedula){
		
		boolean valor = false; 
		
		for (int i = 0; i<adopcionesGenerales.size(); i++) {
			
			Adopcion adopcion = adopcionesGenerales.get(i);
			Persona cliente = adopcion.getCliente();
			
			if (cliente.getCedula()==cedula) {
				valor = true; //SE COMPRUEBA LA CÉDULA SÍ PERTENECE A UN CLIENTE
				break;
			}else {
				continue;
			}
		} 
		return valor;
	}
	
	public void agregarEmpleado(Empleado empleado) {
		empleados.add(empleado);
	}
	
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
	
	public ArrayList<Animal> filtrarEspecie(int num){
		ArrayList <Animal> disponibles = new ArrayList <Animal>();
		
		switch (num) {
		case 1:
			for (Animal perro : animalesDisponibles) {
				if (perro.getEspecie().equalsIgnoreCase("Perro")) {
					disponibles.add(perro);
				}		
			}
			break;
		case 2:
			for (Animal gato : animalesDisponibles) {
				if (gato.getEspecie().equalsIgnoreCase("Gato")) {
					disponibles.add(gato);
				}
			}
			break;
		case 3:
			for (Animal Canario : animalesDisponibles) {
				if (Canario.getEspecie().equalsIgnoreCase("Canario")) {
					disponibles.add(Canario);
				}
			}
			break;
		case 4:
			for (Animal conejo : animalesDisponibles) {
				if (conejo.getEspecie().equalsIgnoreCase("Conejo")) {
					disponibles.add(conejo);
				}
			}
			break;
		case 5:
			for (Animal Hamster : animalesDisponibles) {
				if (Hamster.getEspecie().equalsIgnoreCase("Hámster")) {
					disponibles.add(Hamster);
				}
			}
			break;		
		}
		
		return disponibles;
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

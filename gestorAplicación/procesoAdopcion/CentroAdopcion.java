package gestorAplicación.procesoAdopcion;
import java.util.ArrayList;

<<<<<<< Updated upstream
import gestorAplicación.procesoAdopcion.CentroAdopcion.tipoServicio;
import gestorAplicación.servicioAdicional.Empleado;
=======
>>>>>>> Stashed changes
import gestorAplicación.servicioAdicional.Tienda;

public class CentroAdopcion {
	
<<<<<<< Updated upstream
	public static enum tipoServicio{
		VETERINARIA, GUARDERIA, PELUQUERIA
	}
	public static ArrayList<Adopcion> adopcionesGenerales= new ArrayList<Adopcion>();	
	private ArrayList <Empleado> empleados = new ArrayList<Empleado>();
	private ArrayList <Animal> animalesDisponibles = new ArrayList<Animal>();
	private ArrayList <Adopcion> adopciones = new ArrayList<Adopcion>();
=======
	//private static CentroAdopcion [] sedes = new CentroAdopcion[3];
	private ArrayList <Animal> animalesDisponibles = new ArrayList<>();
	private ArrayList <Adopcion> adopciones = new ArrayList<>();
>>>>>>> Stashed changes
	private String nombre;
	private int espaciosDisponibles = 0;
	private tipoServicio servicio;
	private Tienda tienda;
<<<<<<< Updated upstream
=======
	public static enum tipoServicio{
		VETERINARIA, GUARDERIA, PELUQUERIA
	}
	
>>>>>>> Stashed changes
	
	public CentroAdopcion(String nombre, int espacios, tipoServicio servicio, Tienda tienda) {
		this.nombre= nombre;
		this.espaciosDisponibles= espacios;
		this.servicio= servicio;
		this.tienda= tienda;
	}
	
	public CentroAdopcion(String nombre, int espacios, tipoServicio servicio) {
		this(nombre, espacios,servicio, null );
	}
	
<<<<<<< Updated upstream
	public CentroAdopcion(String nombre, tipoServicio servicio) {
		this(nombre, 0, servicio, null);
	}

	//METODOS SETTER Y GETTER
	
=======
	
	//METODOS SETTER Y GETTER
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
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
	
=======
	
	//OTROS MÉTODOS
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
		CentroAdopcion.adopcionesGenerales.add(adopcion);
=======
>>>>>>> Stashed changes
	}
	
	public ArrayList <Animal> consultarAnimales() {
		return animalesDisponibles;
		
	}
	
<<<<<<< Updated upstream
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
=======
	
	public String toString() {
		return "Nombre:" + getNombre() + ", Espacios Disponibles: " + getEspacios();
		
	}
	
	
	
	
>>>>>>> Stashed changes

}

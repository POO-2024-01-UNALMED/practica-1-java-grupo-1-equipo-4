package gestorAplicación.procesoAdopcion;
import java.util.ArrayList;
import gestorAplicación.servicioAdicional.Empleado;
import gestorAplicación.servicioAdicional.Tienda;

public class CentroAdopcion {
	
	public static enum tipoServicio{
		VETERINARIA, GUARDERIA, PELUQUERIA
	}
	public static ArrayList<Adopcion > adopcionesGenerales= new ArrayList<Adopcion>();	
	private ArrayList < Empleado > empleados = new ArrayList<Empleado>();
	private ArrayList < Animal > animales= new ArrayList<Animal>();
	private ArrayList <Adopcion> adopciones = new ArrayList<Adopcion>();
	public static ArrayList <Cliente> clientes_AdoptaLove= new ArrayList<Cliente>();

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
	
	public boolean tieneMascotas() {
		boolean boleano = false;
		
		for (Animal mascota : this.animales ) {	
			if (mascota.getEstadoSalud()!= Animal.EstadoSalud.ENFERMO) {
				boleano = true;
				break;		
			}
		}
		return boleano;
	}
	
	public ArrayList <Animal> animalesDisponibles() {
		
		ArrayList <Animal> disponibles= new ArrayList<>();
		
		for (Animal mascota: this.animales) {	
			if (mascota.getEstadoSalud()!= Animal.EstadoSalud.ENFERMO) {
				disponibles.add(mascota);
			}
		}		
		return disponibles;
		
	}
	
	public ArrayList<Animal> filtrarEspecie(int num){
		ArrayList <Animal> disponibles = new ArrayList <Animal>();
		
		switch (num) {
		case 1:
			for (Animal perro : animales) {
				if (perro.getEspecie().equalsIgnoreCase("Perro")) {			
					if (perro.getEstadoSalud()!= Animal.EstadoSalud.ENFERMO) {
						disponibles.add(perro);
					}
				}		
			}
			break;
		case 2:
			for (Animal gato : animales) {
				if (gato.getEspecie().equalsIgnoreCase("Gato")) {
					if (gato.getEstadoSalud()!= Animal.EstadoSalud.ENFERMO) {
						disponibles.add(gato);
					}
				}
			}
			break;
		case 3:
			for (Animal Canario : animales) {
				if (Canario.getEspecie().equalsIgnoreCase("Canario")) {
					if (Canario.getEstadoSalud()!= Animal.EstadoSalud.ENFERMO) {
						disponibles.add(Canario);
					}
				}
			}
			break;
		case 4:
			for (Animal conejo : animales) {
				if (conejo.getEspecie().equalsIgnoreCase("Conejo")) {
					if (conejo.getEstadoSalud()!= Animal.EstadoSalud.ENFERMO) {
						disponibles.add(conejo);
					}
				}
			}
			break;
		case 5:
			for (Animal Hamster : animales) {
				if (Hamster.getEspecie().equalsIgnoreCase("Hámster")) {
					if (Hamster.getEstadoSalud()!= Animal.EstadoSalud.ENFERMO) {
						disponibles.add(Hamster);
					}
				}
			}
			break;		
		}
		
		return disponibles;
	}
	
	public ArrayList<Animal> filtrar (String tipo){
		ArrayList <Animal> disponibles= new ArrayList<>();
		
		for (Animal Hamster : animales) {
			if (Hamster.getEspecie().equalsIgnoreCase(tipo)) {
				if (Hamster.getEstadoSalud()!= Animal.EstadoSalud.ENFERMO) {
					disponibles.add(Hamster);
				}
			}
		}
		
		return disponibles;
		
	}
	
	
	public static Cliente isCliente(Cliente cliente){
		
		Cliente cliente_adoptaLove=null; 
		
		for (Cliente  existe : clientes_AdoptaLove) {
			if (existe!=null) {
				if (existe.getCedula()== cliente.getCedula()) { //SE COMPRUEBA SI YA EXISTE
					cliente_adoptaLove = existe;
					break;
					}
				}
			}
		
		if (cliente_adoptaLove==null) {	
			
			//SI NO EXISTE, SE AGREGA COMO NUEVO CLIENTE
			cliente_adoptaLove = cliente;
			clientes_AdoptaLove.add(cliente_adoptaLove);
		}
		else {
			//SI EXISTE, ENTONCES SE ACTUALIZAN LOS DATOS.
			cliente_adoptaLove.actualizar_datos(cliente.getEdad(),cliente.getTelefono(), cliente.getDireccion());	
		}
		
		return cliente_adoptaLove;
		
	}
	
	public ArrayList <Adopcion>puntos_cliente(ArrayList<Animal> mascotas, Cliente cliente) {
		
		ArrayList<Adopcion> adopciones_realizadas= new ArrayList<>();
		
		int nuevos_puntos=0;
		
		Cliente cliente_adoptaLove = isCliente(cliente);
		
		for (Animal mascota: mascotas) {
			
			if (mascota!=null) {
				Adopcion nueva_adopcion = new Adopcion(mascota, cliente_adoptaLove);
				this.agregarAdopcion(nueva_adopcion);
				adopciones_realizadas.add(nueva_adopcion);
				nuevos_puntos+=5;
						
			}
		}	
		
		return adopciones_realizadas;
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
	
	
	//OTROS MÉTODOS

	public void agregarAnimal(Animal animal) {
		
		if (espaciosDisponibles>0) {
			animales.add(animal);
			espaciosDisponibles--;
			}
	}
	
	public void borrarAnimal(Animal animal) {
		int posicion= animales.indexOf(animal);
		animales.remove(posicion);
		espaciosDisponibles++;
	}
	
	public void agregarAdopcion(Adopcion adopcion) {
		adopciones.add(adopcion);
		CentroAdopcion.adopcionesGenerales.add(adopcion);
		adopcion.getCliente().agregar_puntos(5);
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

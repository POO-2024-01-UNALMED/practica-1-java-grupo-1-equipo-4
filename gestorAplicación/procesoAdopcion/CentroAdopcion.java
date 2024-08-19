package gestorAplicación.procesoAdopcion;
import java.io.Serializable;
import java.util.ArrayList;

import gestorAplicación.servicioAdicional.Cita;
import gestorAplicación.servicioAdicional.Empleado;
import gestorAplicación.servicioAdicional.Tienda;

public class CentroAdopcion implements Serializable{
	
	public static enum tipoServicio{
		VETERINARIA, GUARDERIA, PELUQUERIA
	}
	private ArrayList <Empleado> empleados = new ArrayList<>();//
	private ArrayList < Animal > animales= new ArrayList<Animal>();//
	private ArrayList <Adopcion> adopciones = new ArrayList<Adopcion>();//
	private ArrayList<Cita> citas_agendadas = new ArrayList<>();//
	private static ArrayList <Cliente> clientes_AdoptaLove= new ArrayList<Cliente>();//

	private static final long serialVersionUID = 1L;
	private String nombre;//
	private int espaciosDisponibles;//
	private tipoServicio servicio;//
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
	
	//-----------------------------------------------------------------
	
	public CentroAdopcion() {
		// TODO Auto-generated constructor stub
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
	
	//SOBRECARGA
	public ArrayList <Animal> animalesDisponibles() {
		
		ArrayList <Animal> disponibles= new ArrayList<>();
		
		for (Animal mascota: this.animales) {	
			if (mascota.getEstadoSalud()!= Animal.EstadoSalud.ENFERMO) {
				disponibles.add(mascota);
			}
		}		
		return disponibles;	
	}
	
	public ArrayList<Animal> animalesDisponibles (String tipo){
		ArrayList <Animal> disponibles= new ArrayList<>();
		
		for (Animal mascota : animales) {
			if (mascota.getEspecie().equalsIgnoreCase(tipo)) {
				if (mascota.getEstadoSalud()!= Animal.EstadoSalud.ENFERMO) {
					disponibles.add(mascota);
				}
			}
		}		
		return disponibles;	
	}
	
	
	
	public static Cliente isCliente(Cliente cliente){
		
		Cliente cliente_adoptaLove = null; 
		
		for (Cliente  existe : clientes_AdoptaLove) {
			if (existe!=null) {
				if (existe.getCedula()== cliente.getCedula()) { //SE COMPRUEBA SI YA EXISTE
					cliente_adoptaLove = existe;
					break;
					}
				}
			}
		
		if (cliente_adoptaLove == null) {	
			
			//SI NO EXISTE, SE AGREGA COMO NUEVO CLIENTE
			cliente_adoptaLove = cliente;
			clientes_AdoptaLove.add(cliente_adoptaLove);
		}
		else {
			//SI EXISTE, ENTONCES SE ACTUALIZAN LOS DATOS, LA EDAD, TELEFONO Y DIRECCIÓN.
			cliente_adoptaLove.actualizar_datos(cliente.getEdad(),cliente.getTelefono(), cliente.getDireccion());	
		}
		
		return cliente_adoptaLove;
	}
	
	public ArrayList <Adopcion> registrar_adopciones(ArrayList<Animal> mascotas, Cliente cliente) {
		
		//ARRAY LIST QUE GUARDA LAS ADOPCIONES RECIENTEMENTE HECHAS
		ArrayList<Adopcion> adopciones_realizadas= new ArrayList<>();
		
		Cliente cliente_adoptaLove = isCliente(cliente); //VERIFICA SI EL USUARIO YA ESTÁ REGISTRADO.
		
		for (Animal mascota : mascotas) {
			
			if (mascota!=null) {
				
				Adopcion nueva_adopcion = new Adopcion(mascota, cliente_adoptaLove); 
				
				this.adopciones.add(nueva_adopcion); //SE GUARDA EN EL ARRAYLIST DE ADOPCIONES DE LA SEDE
				nueva_adopcion.getCliente().agregar_puntos(5); //SE LE SUMAN 5 PUNTOS AL CLIENTE
				adopciones_realizadas.add(nueva_adopcion);					
			}
		}		
		return adopciones_realizadas;
	}
	
	public void borrarAnimal(Animal animal) {
		int posicion= animales.indexOf(animal);
		animales.remove(posicion);
		espaciosDisponibles++;
	}
	
	
	public void agregarAnimal(Animal animal) {
		
		if (espaciosDisponibles>0) {
			animales.add(animal);
			espaciosDisponibles--;
			}
	}
	
	
	//----------------------------------------------------------
	public ArrayList <Empleado>tieneEmpleados() {
			
			ArrayList<Empleado> emp_Disponibles = new ArrayList<>();
			
			for (Empleado empleado: this.empleados) {
				
				if (empleado.tieneCupos()) {
					
					emp_Disponibles.add(empleado);
				}
			}
			
			return emp_Disponibles;
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
	
	public ArrayList<Animal> getAnimales(){
		return animales;
	}
	
	public static ArrayList<Cliente> getClientes(){
		return clientes_AdoptaLove;
	}
	
	public ArrayList<Cita> getCitas() {
		return citas_agendadas;
	}
	
		
	public void agregarEmpleado(Empleado empleado) {
		empleados.add(empleado);
	}
	
	public static CentroAdopcion getInstance() {
        if (instance == null) {
            instance = new CentroAdopcion();
        }
        return instance;
    }
	
	//OTROS MÉTODOS

	public void agregarAnimal(Animal animal) {
		
		if (espaciosDisponibles>0) {
			animales.add(animal);
			espaciosDisponibles--;
			}
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

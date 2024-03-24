package gestorAplicación.procesoAdopcion;

public class Animal {
	
	private String nombre;
	private String tipo;
	private int edad;
	private String sexo;
	private EstadoSalud estadoSalud;
	private Sede sede;
	private int id;
	
	//constructor
	
	public Animal(String nombre, String tipo, int edad, String sexo, EstadoSalud estadoSalud, Sede sede) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.edad = edad;
		this.sexo = sexo;
		this.estadoSalud = estadoSalud;
		this.sede = sede;
	}
	
	//setter y getter
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public String getSexo() {
		return sexo;
	}
	
	public int getId() {
		return id;
	}
	
	//VERIFICAR
	public void setEstadoSalud(EstadoSalud estadoSalud) {
		this.estadoSalud = estadoSalud;
	}
	
	public EstadoSalud getEstadoSalud() {
		return estadoSalud;
	}
	
	public void setSede(Sede sede) {
		this.sede = sede;
	}
	
	public Sede getSede() {
		return sede;
	}
	//VERIFICAR
	
	//toString
	
	public String toString() {
		return "Nombre: " + getNombre() + "\nTipo: " + getTipo() + "\nEdad: " + getEdad() + "\nSexo: " + getSexo() + "\nEstado de salud: " + getEstadoSalud() + "\nSede: " + getSede() + "\nID: " + getId();
	}
}
package gestorAplicación.procesoAdopcion;

public class Animal {
	
	private String nombre;
	private String tipo;
	private int edad;
	private String sexo;
	private int id;
	private EstadoSalud estadoSalud;
	
	public static enum EstadoSalud {
		SANO, ENFERMO, ENTRATAMIENTO
		
		//VERIFICAR
	}
	
	//constructor
	
	public Animal(String nombre, String tipo, int edad, String sexo, int id, EstadoSalud estadoSalud) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.edad = edad;
		this.sexo = sexo;
		this.id= id;
		this.estadoSalud = estadoSalud;
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
	
	//VERIFICAR
	
	//toString
	
	public String toString() {
		return "Nombre: " + getNombre() + " Tipo: " + getTipo() + " Edad: " + getEdad() + " Sexo: " + getSexo() + " Estado de salud: " + getEstadoSalud() + " ID: " + getId();
	}
}
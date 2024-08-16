package gestorAplicación.procesoAdopcion;

public class Animal {
	
	public static enum EstadoSalud {
		SANO, ENFERMO, ENTRATAMIENTO
	}
	
	private String nombre;
	private String tipo;
	private int edad;
	private String sexo;
	private EstadoSalud estadoSalud;
	
	//CONSTRUCTOR
	
	public Animal(String nombre, String tipo, int edad, String sexo, EstadoSalud estadoSalud) {//Agregar lista de caracteristicas// 
		this.nombre = nombre;
		this.tipo = tipo;
		this.edad = edad;
		this.sexo = sexo;
		this.estadoSalud = estadoSalud;
	}
	
	public Animal(String nombre, String tipo, int edad, String sexo) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.edad = edad;
		this.sexo = sexo;
	}
	
	
	//MÉTODOS SETTER Y GETTER
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setEspecie(String tipo) {
		this.tipo = tipo;
	}
	
	public String getEspecie() {
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
	
	
	public void setEstadoSalud(EstadoSalud estadoSalud) {
		this.estadoSalud = estadoSalud;
	}
	
	public EstadoSalud getEstadoSalud() {
		return estadoSalud;
	}
	
	//OTROS MÉTODOS
	
	public String toString() {
		if (estadoSalud!=null) {
		return "Nombre: " + getNombre() + ", Especie: " + getEspecie() + ", Edad (meses): " + getEdad() + ", Sexo: " + getSexo() + ", Estado de salud: " + getEstadoSalud();
		}
		else {
			return "Nombre: " + getNombre() + ", Especie: " + getEspecie() + ", Edad (meses): " + getEdad() + ", Sexo: " + getSexo();
			
		}
	}
}
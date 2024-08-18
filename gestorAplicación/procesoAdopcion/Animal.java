package gestorAplicación.procesoAdopcion;
import java.util.List;
import java.util.ArrayList;
public class Animal {
	
	public static enum EstadoSalud {
		SANO, ENFERMO, ENTRATAMIENTO
	}
	
	private String nombre;
	private String tipo;
	private int edad;
	private String sexo;
	private List<String> caracteristicas;
	private EstadoSalud estadoSalud;
	
	//CONSTRUCTOR
	
	public Animal(String nombre, String tipo, int edad, String sexo, EstadoSalud estadoSalud) {
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
	
	public Animal(String nombre, int edad,EstadoSalud estadoSalud,List<String> caracteristicas) {
		this.nombre = nombre;
		this.edad = edad;
		this.estadoSalud = estadoSalud;
		this.caracteristicas=new ArrayList<>(caracteristicas);
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
	
	public List<String> getCaracteristicas(){
		return caracteristicas;
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
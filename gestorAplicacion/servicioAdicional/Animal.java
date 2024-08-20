package gestorAplicacion.servicioAdicional;
import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;
public class Animal implements Serializable{

	private static final long serialVersionUID = 1L;

	public static enum EstadoSalud {
		SANO, ENFERMO, ENTRATAMIENTO
	}
	
	private String nombre;
	private String tipo;
	private int edad;
	private String sexo;
	private List<String> caracteristicas;
	private EstadoSalud estadoSalud;
	private int puntaje;
	
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
	
	public Animal(String nombre, int edad,List<String> caracteristicas) {
		this.nombre = nombre;
		this.edad = edad;
		this.caracteristicas=new ArrayList<>(caracteristicas);
		this.puntaje=100;
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
	
	public int getPuntaje() {
		return puntaje;
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
	
	 public void ajustarPuntos(int calificacion) {
	        switch (calificacion) {
	            case 1:
	                puntaje -= 10;
	                break;
	            case 2:
	                puntaje -= 8;
	                break;
	            case 3:
	                puntaje -= 6;
	                break;
	            case 4:
	                puntaje -= 4;
	                break;
	            case 5:
	                puntaje += 0;
	                break;
	        }

	        if (puntaje < 0) {
	            puntaje = 0;
	        } else if (puntaje > 100) {
	            puntaje = 100;
	        }
	    }
	
	public boolean elegible() {
		return this.puntaje>=40;
	}
}
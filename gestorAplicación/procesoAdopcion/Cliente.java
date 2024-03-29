package gestorAplicación.procesoAdopcion;

public class Cliente extends Persona{
	
	public String toString() {
		
		return "Nombre: " + getNombre() + ", Edad: "+ getEdad()+ ", Cedula: " + getCedula() +", Telefono: " 
				+ getTelefono() + ", Direccion "+ getDireccion() + "\n";	
	}
	
	public Cliente(String nombre,int edad, long cedula,long telefono, String direccion) {
		
		super(nombre,edad,cedula,telefono,direccion);
	}
}

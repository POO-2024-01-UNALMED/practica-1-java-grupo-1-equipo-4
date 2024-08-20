package gestorAplicacion.administracion;
import java.io.Serializable;
import java.time.LocalDate;

import gestorAplicacion.servicioAdicional.Animal;
import gestorAplicacion.servicioAdicional.Cliente;
import gestorAplicacion.servicioAdicional.Cupo;
import gestorAplicacion.servicioAdicional.Empleado;

public class Cita implements Serializable{
	
	//DANIEL ALBERTO ZAPATA CASTAÑO
	//OKY RUIZ DE LA ROSA
	//SALOMÉ MURILLO GAVIRIA
	//NICOLAS DAVID ZAMBRANO MURCIA

	private static final long serialVersionUID = 1L;

    private Animal animal;
    private Cupo cupo;
    private Empleado empleado;
    private Cliente cliente;
    private double costo;
    
    public Cita(Cliente cliente, Animal animal,Empleado empleado, Cupo cupo, int servicio ) {
    	
    	this.cliente=cliente;
    	this.animal=animal;
    	this.empleado=empleado;
    	
    	cupo.setDisponible(false);//PARA MARCAR QUE EL CUPO YA NO ESTARÁ DISPONIBLE 	
    	this.cupo=cupo;
    	
    	if (servicio==1) {
    		this.costo= 10000;//COSTO DE UNA CITA DE GUARDERÍA
    		this.cliente.agregar_puntos(3); //POR CITA DE GUARDERIA GANA 3 PUNTOS
    	}
    	
        if (servicio==2) {
        	this.costo=20000; //COSTO DE UNA CITA DE VETERINARIA
        	this.cliente.agregar_puntos(5);//POR CITA DE VETERINARIA GANA 5 PUNTOS
    		}
        
        if (servicio==3) {
        	this.costo=15000; //COSTO DE UNA CITA DE PELUQUERÍA
        	this.cliente.agregar_puntos(4);//POR CITA DE PELUQUERIA GANA 4 PUNTOS
        }
    		
    	
    	
    }
    public void aplicarDescuento() {
    	this.costo -= (this.costo *0.1);
    }
    

    public Animal getAnimal() {
        return animal;
    }
    
    
    public void setFecha(LocalDate fecha) {
    	this.fecha=fecha;
    }
    
    public String toString() {
    	
    	String profesion="";
    	
    	if (this.empleado.getProfesion()== Empleado.Rol.VETERINARIO) {
    		profesion = "Veterinario";
    	}
      	if (this.empleado.getProfesion()== Empleado.Rol.CUIDADOR) {
    		profesion = "Veterinario";
    	}
      	if (this.empleado.getProfesion()== Empleado.Rol.PELUQUERO) {
    		profesion = "Veterinario";
    	}
    		
    	return "Cliente: " + this.cliente.getNombre() +"\n"
    			+ "Mascota: " + this.animal.getNombre()+ "\n"
    			+ profesion +": " + this.empleado.getNombre() + "\n"
    			+ "Costo cita: " + this.costo + " pesos \n"
    			+ "Fecha de la cita: " + this.cupo.fechaFormateada() +"\n"
    			+ "Hora: " + this.cupo.getHoraInicio() + " - "+ this.cupo.getHoraFin(); 			
    }
    
}



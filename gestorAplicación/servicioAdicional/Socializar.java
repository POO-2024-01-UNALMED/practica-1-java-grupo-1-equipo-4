package gestorAplicación.servicioAdicional;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import gestorAplicación.procesoAdopcion.Animal;
import gestorAplicación.procesoAdopcion.Cliente;


public class Socializar implements Serializable{
	public static Cliente clientePorDefecto;
	public static Animal animalPorDefecto;
//	static {
//        animalPorDefecto =new Animal("Firulais", 4, Arrays.asList("juguetón", "calmado", "activo", "pasivo"));
//        clientePorDefecto =new Cliente("Juan", 30, 1234567890L, 987654321L, true);
//        clientePorDefecto.setMascota(animalPorDefecto);
//	}
	private static final long serialVersionUID = 1L;
	private  ArrayList<Cliente> clientes = new ArrayList<> ();
	private ArrayList<Cita> citas = new ArrayList<> ();
	
	public Socializar(){
		this.clientes= new ArrayList<>();
		this.citas= new ArrayList<>();
		}
	
	public void registroC (Cliente cliente) {
			clientes.add(cliente);
		}

	private boolean posibleMatch(Animal animal, Animal animal2) {
		for (String caracteristicas:animal.getCaracteristicas()) {
			if (animal2.getCaracteristicas().contains(caracteristicas)) {
				return true;
			}
		}
		return false;
	}

	public void match() {
		for (int a=0;a<clientes.size(); a++) {
			for (int l=a+1;l<clientes.size();l++) {
				Cliente persona1 = clientes.get(a);
                Cliente persona2 = clientes.get(l);
                Animal animal1 = persona1.getMascota();
                Animal animal2 = persona2.getMascota();
                
                if (posibleMatch(animal1, animal2)) {
                	LocalDate fechaCita=calcularFechaCita(persona1);
                	Cita cita=new Cita(persona1,persona2,animal1,animal2,fechaCita);
                	citas.add(cita);
                }
			}
		}
	}
    
    private LocalDate calcularFechaCita(Cliente cliente) {
        LocalDate now = LocalDate.now();
        LocalDate fechaCita = now.plusDays(1);
        return fechaCita;
    }
    
    private void reprogramarCita(Cita cita) {
        LocalDate nuevaFecha = calcularProximaFechaDisponible();
        cita.setFecha(nuevaFecha);
        System.out.println("La nueva fecha de la cita es: " + nuevaFecha);
    }

    private LocalDate calcularProximaFechaDisponible() {
        LocalDate nuevaFecha = LocalDate.now().plusDays(1);
        return nuevaFecha;
    }
    
    public void cambiarEstadoCita(Cita cita, Cita.EstadoCita nuevoEstado) {
        cita.setEstado(nuevoEstado);

        switch (nuevoEstado) {
            case ACEPTADA:
                System.out.println("La cita ha sido aceptada.");
                break;
            case RECHAZADA:
                System.out.println("La cita ha sido rechazada.");
                break;
            case APLAZADA:
                System.out.println("La cita ha sido aplazada.");
                reprogramarCita(cita);
                break;
            default:
                break;
        }
    }
    
    public void calificarAnimal(Animal animal, int calificacion) {
        animal.ajustarPuntos(calificacion);

        if (!animal.elegible()) {
            System.out.println("El animal " + animal.getNombre() + " ha sido retirado del programa Socializar debido a un puntaje bajo.");
        }
    }
    
    public ArrayList<Cita> getCitas(){
    	return citas;
    }
    
    public ArrayList<Cliente> getClientes(){
		return clientes;
	}
	
    public void setClientes(ArrayList<Cliente> clientes){
		this.clientes = clientes;
	}
    
    public void setCitas(ArrayList<Cita> citas){
		this.citas = citas;
	}
}


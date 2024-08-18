package gestorAplicación.servicioAdicional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import gestorAplicación.procesoAdopcion.Animal;
import gestorAplicación.procesoAdopcion.Cliente;


public class Socializar{
	private List<Cliente> clientes;
	private List<Animal> animales;
	private List<Cita> citas;
	
	public Socializar(){
		this.clientes= new ArrayList<>();
		this.animales= new ArrayList<>();
		this.citas= new ArrayList<>();
		}
	
	public void registroC (Cliente cliente) {
		if (cliente.isParticipar()) {
			clientes.add(cliente);
		}
	}
	
	public void registroA (Animal animal) {
		animales.add(animal);
	}
	
	private boolean posibleMatch(Animal animal, Animal animal2) {
		for (String caracteristicas:animal.getCaracteristicas()) {
			if (animal2.getCaracteristicas().contains(caracteristicas)) {
				return true;
			}
		}
		return false;
	}
	
	private Cliente buscarCliente(Animal animal) {
        for (Cliente cliente : clientes) {
            if (cliente.isParticipar()) {
                return cliente;
            }
        }
        return null;
    }
	public void match() {
		for (int a=0;a<animales.size(); a++) {
			Animal animal1 = animales.get(a);
			for (int l=0;l<animales.size();l++) {
				Animal animal2=animales.get(l);
				if(animal1.getEdad()==animal2.getEdad()&&posibleMatch(animal1,animal2)) {
					Cita cita=new Cita(buscarCliente(animal1),animal2,LocalDate.now());
					citas.add(cita);
					System.out.println("Cita generada para"+animal1.getNombre()+"y"+animal2.getNombre());
				}
			}
		}
	}
}


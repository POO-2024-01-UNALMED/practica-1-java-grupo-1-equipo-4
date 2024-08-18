package gestorAplicación.servicioAdicional;
import java.util.Arrays;
import gestorAplicación.procesoAdopcion.Animal;
import gestorAplicación.procesoAdopcion.Animal.EstadoSalud;
import gestorAplicación.procesoAdopcion.Cliente;

public class MainSocializar {
	public static void main(String[] args) {
		Cliente persona1=new Cliente("Dani",24,457693830,1076759938,true);
		Cliente persona2=new Cliente("Salo",23,457653830,184950530,true);
	
		
		Animal perro=new Animal("Homero",2,EstadoSalud.SANO,Arrays.asList("jugueton","calmado"));
		Animal gato=new Animal("Ari",3,EstadoSalud.SANO,Arrays.asList("tranquilo","calmado"));
		persona1.setMascota(gato);
		persona2.setMascota(perro);
		
		Socializar socializar=new Socializar();
		
		socializar.registroC(persona2);
		socializar.registroC(persona1);
		socializar.match();
		for (Cita cita:socializar.getCitas()) {
			 System.out.println("Cita entre: " + cita.getCliente().getNombre() + " con su mascota " + 
                     cita.getAnimal().getNombre() + " y " + 
                     cita.getCliente2().getNombre() + 
                     " con su mascota " + cita.getAnimal2().getNombre() +
                    " en la fecha: " + cita.getFecha() +
                    " Estado: " + cita.getEstado());
		}


    	if (!socializar.getCitas().isEmpty()) {
    		Cita primeraCita = socializar.getCitas().get(0);
    		socializar.cambiarEstadoCita(primeraCita, Cita.EstadoCita.ACEPTADA);
    		System.out.println("Nuevo estado de la cita: " + primeraCita.getEstado());

    		socializar.calificarAnimal(primeraCita.getAnimal(), 4);
    		socializar.calificarAnimal(primeraCita.getAnimal2(), 5);

    		System.out.println("Puntaje de " + primeraCita.getAnimal().getNombre() + ": " + primeraCita.getAnimal().getPuntaje());
    		System.out.println("Puntaje de " + primeraCita.getAnimal2().getNombre() + ": " + primeraCita.getAnimal2().getPuntaje());
    	}
	}
}

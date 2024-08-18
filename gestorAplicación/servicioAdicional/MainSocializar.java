package gestorAplicación.servicioAdicional;
import java.util.Arrays;
import gestorAplicación.procesoAdopcion.Animal;
import gestorAplicación.procesoAdopcion.Animal.EstadoSalud;
import gestorAplicación.procesoAdopcion.Cliente;

public class MainSocializar {
	public static void main(String[] args) {
		Socializar socializar=new Socializar();
		Cliente cliente1=new Cliente("Dani",24,457693830,true);
		Cliente cliente2=new Cliente("Salo",23,457653830,true);
		socializar.registroC(cliente2);
		socializar.registroC(cliente1);
		
		Animal perro=new Animal("homero",2,EstadoSalud.SANO,Arrays.asList("jugueton,calmado"));
		Animal gato=new Animal("Ari",2,EstadoSalud.SANO,Arrays.asList("tranquilo","calmado"));
		socializar.registroA(perro);
		socializar.registroA(gato);
		
		socializar.match();
	}
}

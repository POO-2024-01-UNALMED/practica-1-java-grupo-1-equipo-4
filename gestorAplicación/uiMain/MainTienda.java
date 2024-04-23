package gestorAplicación.uiMain;
import gestorAplicación.procesoAdopcion.*;

public class MainTienda {

	public static void main(String[] args) {
	
	CentroAdopcion sede1 = new CentroAdopcion("SEDE 1",25, CentroAdopcion.tipoServicio.GUARDERIA);

	//CREAMOS UN ANIMAL PARA UN CENTRO
	Animal gato1 = new Animal("Reina","Gato",3, "Hembra", Animal.EstadoSalud.SANO);
	
	sede1.agregarAnimal(gato1);
	
	//PERSONA PARA CREAR UNA ADOPCION
	Cliente Oky = new Cliente("Oky Ruiz", 17, 777, 666, "La costa");
	
	Adopcion adopcion1 = new Adopcion(gato1, Oky);
	
	//AGREGAMOS ADOPCION
	sede1.agregarAdopcion(adopcion1);
	
	//PRUEBA DE MÉTODO
	
	long cedula = 776;
	
	boolean respuesta = CentroAdopcion.EsCliente(cedula);
	
	System.out.println("Resultado de la prueba:");
	System.out.println(respuesta);
	
	}	
}

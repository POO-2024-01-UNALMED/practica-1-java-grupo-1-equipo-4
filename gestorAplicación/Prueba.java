package gestorAplicación;

import java.util.ArrayList;

import gestorAplicación.procesoAdopcion.*;
import gestorAplicación.servicioAdicional.*;

public class Prueba {
	public static void main(String[] args) {
		//CREAR ANIMALES
		Animal animal1= new Animal("DOKY", "PERRO", 2, "MACHO", EstadoSalud.SANO);
		Animal animal2= new Animal("EMMA", "LORO", 1, "HEMBRA", EstadoSalud.ENTRATAMIENTO);
		Animal animal3= new Animal("PONCHO", "GATO", 4, "MACHO", EstadoSalud.SANO);
		Animal animal4= new Animal("LUNA", "PERRO", 3, "HEMBRA", EstadoSalud.ENFERMO);
		
	
		
		
	   CentroAdopcion sede1= new CentroAdopcion("SEDE1", 20, CentroAdopcion.tipoServicio.VETERINARIA);
	   
	   sede1.agregarAnimal(animal1);
	   sede1.agregarAnimal(animal2);
	   sede1.agregarAnimal(animal3);
	   sede1.agregarAnimal(animal4);
	   
	   int i=1;
	   for (Animal animal: sede1.consultarAnimales()) {
		   System.out.print("ANIMAL " + i++ + ": " );
		   System.out.println(animal);
	   }
	   
      }
	
	
}

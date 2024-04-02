package gestorAplicación.procesoAdopcion;


//PRUEBAS PARA LA CLASE ANIMAL, PERSONA, CLIENTE, ADOPCION, CENTRO ADOPCION 

public class Pruebas_Clases {

	 public static void main(String[] args) {
		
		//PRUEBA CONSTRUCTOR CENTRO ADOPCIÓN
		CentroAdopcion sede1= new CentroAdopcion("Sede principal", 20, CentroAdopcion.tipoServicio.VETERINARIA);
		
		System.out.println(sede1 + "\n");
		
		//PRUBEA CONSTRUCTOR ANIMAL
		
		Animal animal1= new Animal("Emma","perro",2,"Hembra", Animal.EstadoSalud.SANO);
		
		System.out.println(animal1 + "\n");
		
		//PRUEBA AGREGAR ANIMALES A CENTRO DE ADOPCIÓN
		
		Animal animal2 = new Animal("Luna","perro",2,"Hembra", Animal.EstadoSalud.SANO);
		Animal animal3 = new Animal("Rambo","perro",2,"Macho", Animal.EstadoSalud.ENFERMO);
		Animal animal4 = new Animal("Coronel","perro",2,"Macho", Animal.EstadoSalud.ENTRATAMIENTO);
		Animal animal5 = new Animal("Lucero","perro",2,"Hembra", Animal.EstadoSalud.SANO);	
		
		sede1.agregarAnimal(animal1);
		sede1.agregarAnimal(animal2);
		sede1.agregarAnimal(animal3);
		sede1.agregarAnimal(animal4);
		sede1.agregarAnimal(animal5);
		
		System.out.println(sede1.getEspacios());
		
		int i=0;
		for (Animal animal: sede1.consultarAnimales() ) {
			i++;
			System.out.println("Mascota " + i + " - " +animal);
		}
		
		//PRUEBA BORRAR UN ANIMAL
		System.out.println("\n");
		
		sede1.borrarAnimal(animal1);
		
		int j=0;
		for (Animal animal: sede1.consultarAnimales() ) {
			j++;
			System.out.println("Mascota " + j + " - " +animal);
		}
		System.out.println(sede1.getEspacios());
		
		
		//PRUEBA DE DOS APUNTADORES QUE APUNTAN HACIA AL MISMO OBJETO
		Animal mascota = animal2;
		
		System.out.println(mascota);
		
		sede1.borrarAnimal (mascota);
		System.out.println("\n");
		
		int m=0;
		for (Animal animal: sede1.consultarAnimales() ) {
			m++;
			System.out.println("Mascota " + m + " - " +animal);
		}
		System.out.println(sede1.getEspacios());
			
		
		System.out.println("\n PRUEBA DE LA CLASE PERSONA \n");
		
		
		Persona persona1 = new Persona("Oky",17, 1072253440,3106762877L,"Medellin");
		
		System.out.println(persona1 + "\n");
		
		persona1.setEdad(78);
		persona1.setNombre("Jair");
		persona1.setCedula(1072254378);
		persona1.setTelefono(3135747973L);
		persona1.setDireccion("San Andrés");
		
		System.out.println(persona1);
		
		
		/*/PRUEBA DE LA CLASE CLIENTE
		
		Cliente cliente1 = new Cliente("Claudia",24,234563,34563256,"cartagena");
		Cliente cliente2 = new Cliente ("Linda", 15,543725654,854527625,"vygvvs" );
		
		
		
		//PRUEBA DE LA CLASE ADOPCION

		Adopcion adopcion1 = new Adopcion(animal4,cliente1);	
		Adopcion adopcion2 = new Adopcion (animal5, cliente2);
		
		sede1.agregarAdopcion(adopcion1);
		sede1.agregarAdopcion(adopcion2);
		
		
	
		for (Adopcion adopcion: sede1.getAdopciones()) {
			System.out.println(adopcion + "\n");
		}*/
	}
}

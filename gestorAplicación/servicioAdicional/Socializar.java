package gestorAplicación.servicioAdicional;

import java.util.ArrayList;

import gestorAplicación.procesoAdopcion.Animal;

public class Socializar {
    private List<Cliente> clientes;
    private List<Animal> animales;
    private List<Cita> citas;

    public Socializar() {
        this.clientes = new ArrayList<>();
        this.animales = new ArrayList<>();
        this.citas = new ArrayList<>();
    }

    public void registrarCliente(Cliente cliente) {
        if (cliente.isParticiparSocializar()) {
            clientes.add(cliente);
        }
    }

    public void registrarAnimal(Animal animal) {
        animales.add(animal);
    }

private boolean posibleMatch (Animal animal, Animal animal2){
    for (String caracter: animal.getCaracter()){
        if (animal2.getCaracter.contains(caracter))
        return True;
    }
    return False
}

public void match(){
    for (int a=0; i<animales.size; a++){
        Animal animal= animales.get(a);
        for (int=0; <animales.size; l++){
            Animal animal2= animales.get(l);
            if (animal.getEdad()==animal2.getEdad() && boolean posibleMatch(animal, animal2))
            //Cita cita = new Cita ()
        }
    }
}

}

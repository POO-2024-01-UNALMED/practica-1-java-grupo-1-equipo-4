package gestorAplicación.procesoAdopcion;
import gestorAplicación.servicioAdicional.*;


public class PruebaVoluntarios {
    public static void main(String[] args){
        //creamos una tienda
        Tienda tienda1 = new Tienda();
        //agregamos un voluntario
        tienda1.agregarVoluntario();
        tienda1.mostrarVoluntarios();
    }
}

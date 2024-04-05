package gestorAplicación.servicioAdicional;

import java.util.ArrayList;

import gestorAplicación.procesoAdopcion.CentroAdopcion;

public class pruebaTienda {
    public static void main(String[] args){

        ArrayList <Cita> citas = new ArrayList<>();
        Empleado empliado = new Empleado("David", 23, 3456533, "West Elm", 666, null, citas);

        Tienda tienda1 = new Tienda(empliado);

        CentroAdopcion centro1 = new CentroAdopcion("Huellitas", 3, null, tienda1);
        
        System.out.println(" ");
        System.out.println(centro1.getTienda());
        System.out.println(" ");

        System.out.println("Agregando productos");
        Producto p1 = new Producto("Corta uñas", 30000, 30);
        Producto p2 = new Producto("Shampoo", 45000, "gatos",30);
        Producto p3 = new Producto("Cuido", 20000,"perros", 30);  

        tienda1.agregarProducto(p3);
        tienda1.agregarProducto(p2);
        tienda1.agregarProducto(p1);

        System.out.println("       ");
        System.out.println("Inventario: ");
        System.out.println(tienda1.inventario());
        System.out.println("         ");

        System.out.println(tienda1.compra(2));
        System.out.println("           ");

        System.out.println(tienda1.inventario());


        System.out.println("         ");

        System.out.println(tienda1.compra(3, 5));
        System.out.println("           ");

        System.out.println(tienda1.inventario());
    }
}

package baseDatos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.List;

import gestorAplicación.procesoAdopcion.*;
import gestorAplicación.servicioAdicional.*;



public class Serializador {

    private static File rutaTemp = new File("src\\baseDatos\\temp");


    public static <T> void serializar(T objeto, List<String> nombresArchivos) {
        File[] docs = rutaTemp.listFiles();

        for (File file : docs) {
            limpiarArchivo(file);

            for (String nombreArchivo : nombresArchivos) {
                if (file.getAbsolutePath().contains(nombreArchivo)) {
                    List<?> lista = obtenerLista(objeto, nombreArchivo);
                    if (lista != null) {
                        serializarLista(file, lista);
                    }
                }
            }
        }
    }

    private static <T> List<?> obtenerLista(T objeto, String nombreArchivo) {
        if (objeto instanceof CentroAdopcion) {
            CentroAdopcion ca = (CentroAdopcion) objeto;
            switch (nombreArchivo) {
                case "adopciones": return ca.getAdopciones();
                case "animales": return ca.getAnimales();
                case "clientes": return CentroAdopcion.getClientes();
                case "empleados": return ca.getEmpleados();
            }
        } else if (objeto instanceof Funeraria) {
            Funeraria f = (Funeraria) objeto;
            switch (nombreArchivo) {
                case "tumbas": return f.getTumbas();
                case "cenizas": return f.getCenizas();
            }
        } else if (objeto instanceof Socializar) {
            Socializar sz = (Socializar) objeto;
            switch (nombreArchivo) {
                case "clientes": return sz.getClientes();
                case "citas": return sz.getCitas();
            }
        } else if (objeto instanceof Tienda) {
            Tienda t = (Tienda) objeto;
            switch (nombreArchivo) {
                case "productos": return t.getProductos();
                case "empleados": return t.getEmpleados();
            }
        } else if (objeto instanceof Muerto) {
            Muerto m = (Muerto) objeto;
            switch (nombreArchivo) {
                case "flores": return m.getFlores();
            }
        }
        return null;
    }

    private static void limpiarArchivo(File file) {
        try (PrintWriter pw = new PrintWriter(file)) {
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static <T> void serializarLista(File file, List<T> lista) {
        try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

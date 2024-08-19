package baseDatos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import gestorAplicación.procesoAdopcion.*;
import gestorAplicación.servicioAdicional.*;

import java.io.*;
import java.util.List;

public class Deserializador {

    private static File rutaTemp = new File("src\\baseDatos\\temp");

    public static <T> void deserializar(T objeto, List<String> nombresArchivos) {
        File[] docs = rutaTemp.listFiles();

        for (File file : docs) {
            for (String nombreArchivo : nombresArchivos) {
                if (file.getAbsolutePath().contains(nombreArchivo)) {
                    List<?> lista = deserializarLista(file);
                    asignarLista(objeto, nombreArchivo, lista);
                }
            }
        }
    }

    private static <T> List<?> deserializarLista(File file) {
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            return (List<?>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    private static <T> void asignarLista(T objeto, String nombreArchivo, List<?> lista) {
    	ObjectInputStream ois;
        if (objeto instanceof CentroAdopcion) {
            CentroAdopcion ca = (CentroAdopcion) objeto;
            switch (nombreArchivo) {
                case "adopciones": ca.setAdopciones((ArrayList<Adopcion>) objeto); break;
                case "animales": ca.setAnimales((ArrayList<Animal>) objeto); break;
                case "clientes": ca.setClientes((ArrayList<Cliente>) objeto); break;
                case "empleados": ca.setEmpleados((ArrayList<Empleado>) objeto); break;
            }
        } else if (objeto instanceof Funeraria) {
            Funeraria f = (Funeraria) objeto;
            switch (nombreArchivo) {
                case "tumbas": f.setTumbas((ArrayList<Muerto>) objeto); break;
                case "cenizas": f.setCenizas((ArrayList<Muerto>) objeto); break;
            }
        } else if (objeto instanceof Socializar) {
            Socializar sz = (Socializar) objeto;
            switch (nombreArchivo) {
                case "clientes": sz.setClientes((ArrayList<Cliente>) objeto); break;
                case "citas": sz.setCitas((ArrayList<Cita>) objeto); break;
            }
        } else if (objeto instanceof Tienda) {
            Tienda t = (Tienda) objeto;
            switch (nombreArchivo) {
                case "productos": t.setProductos((ArrayList<Producto>) objeto); break;
                case "empleados": t.setEmpleados((ArrayList<Empleado>) objeto); break;
            }
        } else if (objeto instanceof Muerto) {
            Muerto m = (Muerto) objeto;
            switch (nombreArchivo) {
                case "productos": m.setFlores((ArrayList<String>) objeto); break;
            }
        }
    }
}

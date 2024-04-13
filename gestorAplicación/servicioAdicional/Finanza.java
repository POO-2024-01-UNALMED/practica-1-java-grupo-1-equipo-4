package gestorAplicación.servicioAdicional;

import gestorAplicación.servicioAdicional.Empleado.Rol;
import gestorAplicación.servicioAdicional.Empleado;

public class Finanza {
    private enum clasificacion {
        NOMINA, SERVICIO, IMPUESTO
    };

    private long salidas;
    private long ingresos;
    private long patrimonio = 1000000;
    private long donacion;
    private clasificacion Clasificacion;
    private int sueldoVet = 750000;
    private int sueldoPel = 900000;
    private int sueldoGua = 1200000;
    private int sueldoAsi = 900000;

    public void pagoAdministracion(clasificacion Clasificacion, int cantidad) {
        if (Clasificacion == clasificacion.SERVICIO || Clasificacion == clasificacion.IMPUESTO) {
            patrimonio -= cantidad;
            salidas += cantidad;
        } else if (Clasificacion == clasificacion.NOMINA) {
            for (Empleado empleado : empleado); // cambiar la manera en la que se define la lista de empleados en la clase, preguntar juan si se puede cambiar la privacidad de empleado para hacer uso de este...
                if (Empleado.getProfesion)==Rol.PELUQUERO){ //Que tipo es Rol??
                    patrimonio -= sueldoPel;
                    salidas += sueldoPel;
                } else if (Rol profesion==Rol.VETERINARIO){
                    patrimonio -= sueldoVet;
                    salidas += sueldoVet;
                } else if (Rol profesion==Rol.CUIDADOR){
                    patrimonio -= sueldoGua;
                    salidas += sueldoGua;
                } else if (Rol profesion==Rol.TENDERO){
                    patrimonio -= sueldoAsi;
                    salidas += sueldoAsi;
            }
        }

    }

    // Getter & Setter
    public long getSalidas() {
        return salidas;
    }

    public void setSalidas(long salidas) {
        this.salidas = salidas;
    }

    public long getIngresos() {
        return ingresos;
    }

    public void setIngresos(long ingresos) {
        this.ingresos = ingresos;
    }

    public long getPatrimonio() {
        return patrimonio;
    }

    public void setPatrimonio(long patrimonio) {
        this.patrimonio = patrimonio;
    }

    public long getDonacion() {
        return donacion;
    }

    public void setDonacion(long donacion) {
        this.donacion = donacion;
    }
}
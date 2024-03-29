package gestorAplicación.servicioAdicional;

public class Finanza {
    private enum clasificacion {
        NOMINA, SERVICIO, IMPUESTO
    };

    private long salidas;
    private long ingresos;
    private long patrimonio = 1000000;
    private long donacion;
    private clasificacion Clasificacion;
    private int sueldoVet = 15000;
    private int sueldoPel = 7000;
    private int sueldoGua = 6500;
    private int sueldoAsi = 5500;

    public void pagoAdministracion(clasificacion Clasificacion, int cantidad) {
        if (Clasificacion == clasificacion.SERVICIO || Clasificacion == clasificacion.IMPUESTO) {
            patrimonio -= cantidad;
            salidas += cantidad;
        } else if (Clasificacion == clasificacion.NOMINA) {

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
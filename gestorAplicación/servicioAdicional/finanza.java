package gestorAplicación.servicioAdicional;
public class finanza{
    private enum clasificacion{
        NOMINA, SERVICIO, IMPUESTO
    };
    private long salidas;
    private long ingresos;
    private long patrimonio=1000000;
    private long donacion;
    private clasificacion Clasificacion;

public void pagoAdministracion (clasificacion Clasificacion, int cantidad){
    if (Clasificacion==clasificacion.NOMINA) {

    }
}
public String ventaNueva (Producto producto, int cantidad){

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

public clasificacion getClasificacion() {
    return Clasificacion;
}

public void setClasificacion(clasificacion clasificacion) {
    Clasificacion = clasificacion;
}
}
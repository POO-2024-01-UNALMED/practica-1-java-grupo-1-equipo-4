package gestorAplicación.servicioAdicional;

public class cita {
    private String hora;
    private String fecha;
    private boolean disponibilidad;

// Set&Get disponibilidad
public void setDisponibilidad(boolean disponibilidad) {
    this.disponibilidad = disponibilidad;
}
public boolean getDisponibilidad() {
    return disponibilidad;
}

@Override
public String toString() {
    return "cita [hora=" + hora + ", fecha=" + fecha + ", disponibilidad=" + disponibilidad + "]";
}
}
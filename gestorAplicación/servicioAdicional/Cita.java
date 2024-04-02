package gestorAplicación.servicioAdicional;
public class Cita {
    private String hora;
    private String fecha;
    private boolean disponibilidad;

//CONSTRUCTOR
public Cita(String hora, String fecha, boolean disponibilidad) {
	this.hora =hora;
	this.fecha = fecha;
	this.disponibilidad = disponibilidad;
}
    
    
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
package gestorAplicación.servicioAdicional;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatter;
public class Cupo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private LocalDate dia;
    private String horaInicio;
    private String horaFin;
    private boolean disponible;
    

    public Cupo(LocalDate dia, String horaInicio, String horaFin, boolean disponible) {
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.disponible = disponible;
    }

    // Getters y toString
    public LocalDate getDia() {
    	
    	return dia;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public boolean isDisponible() {
        return disponible;
    }
    
    public void setDisponible(boolean booleano) {
    	
    	this.disponible=booleano;
    }

    @Override
    public String toString() {
    	
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return "De "+ horaInicio + " a "  + horaFin;
    }
    
    public String fechaFormateada() {
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
    	
    	return getDia().format(formatter);
    }
    

    }



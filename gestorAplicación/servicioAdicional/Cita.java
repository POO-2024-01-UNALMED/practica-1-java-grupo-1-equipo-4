package gestorAplicación.servicioAdicional;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Cita {
	
	private String horaInicio;
	private String horaFin;
	private boolean disponibilidad;
	
	//CONSTRUCTOR
	public Cita(String HoraInicio, String HoraFinal) {
		this.horaInicio= HoraInicio;
		this.horaFin = HoraFinal;
		this.disponibilidad=true;
	
}
	
	public boolean getDisponibilidad() {
		return this.disponibilidad;
	}
	
	public void setDisponibilidad(boolean disponibilidad) {
	        this.disponibilidad = disponibilidad;
	}
	
    public String getHoraInicio() {
        return horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }
    
    public String toString() {
    	return " De " + horaInicio + ":" + horaFin;
    }
	
   /* private LocalTime hora;
    private LocalDate fecha;
    private boolean disponibilidad;
    private ArrayList<Cita> citas;

    
    // constructor
    public Cita(LocalTime hora, LocalDate fecha) {
        this.hora = hora;
        this.fecha = fecha;
    }


    public void Agenda() {
        this.citas = new ArrayList<>();
    }

    public void agregarCita(Cita cita) {
        citas.add(cita);
    }

    public List<Cita> citasSemanales(DayOfWeek diaSemana) {
        List<Cita> citasSemanales = new ArrayList<>();
        LocalDate hoy = LocalDate.now();
        LocalDate inicioSemana = hoy.minusDays(hoy.getDayOfWeek().getValue() - diaSemana.getValue());
        LocalDate finSemana = inicioSemana.plusDays(6);
        for (Cita cita : citas) {
            LocalDate fechaCita = cita.getFecha();
            if (fechaCita.isAfter(inicioSemana) && fechaCita.isBefore(finSemana.plusDays(1))) {
                citasSemanales.add(cita);
            }
        }
        return citasSemanales;
    }
    
    public LocalDate getFecha() {
        return fecha;
    }

    // Setters & getters
    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public boolean getDisponibilidad() {
        return disponibilidad;
    }

    @Override
    public String toString() {
        return "cita [hora=" + hora + ", fecha=" + fecha + ", disponibilidad=" + disponibilidad + "]";
    }*/
}
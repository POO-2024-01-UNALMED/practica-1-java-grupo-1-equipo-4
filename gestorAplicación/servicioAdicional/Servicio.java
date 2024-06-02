package gestorAplicación.servicioAdicional;
import java.util.ArrayList;
import java.util.Map;
import gestorAplicación.procesoAdopcion.Animal;
import gestorAplicación.procesoAdopcion.CentroAdopcion;
import gestorAplicación.procesoAdopcion.Cliente;
import gestorAplicación.servicioAdicional.Cita;
import java.util.HashMap;


public class Servicio 
{
    private Animal animal;
    private Cliente cliente;
    private String tipoServicio;
    private double costoServicio;
    private Empleado empleado;
    private  ArrayList<Cita> [] citas_seleccionadas;


    //CONSTRUCTOR 1 PARA VERIFICAR USUARIO Y PARA REGISTRARLO SI NO LO ESTA
    public Servicio(Animal animal, Cliente cliente){
        this.animal = animal;
        this.cliente= cliente;
    }

    //CONSTRUCTOR 2 PARA ASIGNARLE A UN CLIENTE UN SERVICIO DE SU ELECCION
    public Servicio(Animal animal, Cliente persona,Empleado empleado, String tipoServicio, ArrayList<Cita> [] citas_seleccionadas)
    {
        this.animal = animal;
        this.cliente = persona;
        this.empleado=empleado;
        this.tipoServicio = tipoServicio;
        this.citas_seleccionadas= citas_seleccionadas;
    }
    
    
    public void anexo_puntos() {
    	int i=0;
    	
    	for (ArrayList<Cita> dia_citas : this.citas_seleccionadas) {
    		
    		if (dia_citas!=null) {
    			for (Cita cita: dia_citas) {
    				i++;
    			}
    		}
    	}
    	
    	int puntos = i*5;   	
    	this.cliente.agregar_puntos(puntos);
    }
    

    
    public double monto_pagar(int servicio) {
 
    	double valor_pagar=0;	
    	int num_citas=0;
    	
    	for (ArrayList<Cita> cita_dias: this.citas_seleccionadas) {
    		
    		if (cita_dias!=null) {
    			for (Cita cita: cita_dias) {
    				num_citas++;
    			}
    		}
    	}
    	  	
     	switch(servicio) {
     	
     	case 0:
     		valor_pagar = num_citas*10000;
     		break;
     	case 1:
     		valor_pagar= num_citas*15000;
     		break;
     	case 2:
     		valor_pagar= num_citas*15000;
     	}
     	
     	     	
     	return valor_pagar;

    }
    
    public static double descuento(double valor, Cliente cliente) {
     	int puntos= cliente.getPuntos();  	
     	double descuento=0;
     	double valor_pagar= valor;
     	
     	
     	
     	if(puntos>=30) {
     		
     		if (puntos>=100) {
     			descuento = valor_pagar*0.3;
     			cliente.disminuir_puntos(100);
     		}
     		else {
     			if (puntos>=60) {
     				descuento=valor_pagar*0.2;
     				cliente.disminuir_puntos(60);
     			}
     			else {
     				descuento=valor_pagar*0.1;
     				cliente.disminuir_puntos(30);
     			}
     		}
     	}
     	
     	return descuento;
     	
    }
    
    
    



    //METODO SET Y GET
    public void setTipoServicio(String tipoServicio)
    {
        this.tipoServicio = tipoServicio;
    }

    public void setCosto(double costoServicio)
    {
        this.costoServicio = costoServicio;
    }

    public void setAnimal(Animal animal)
    {
        this.animal = animal;
    }

    public void setCliente(Cliente persona)
    {
        this.cliente = persona;
    }

    public void setEmpleado(Empleado empleado)
    {
        this.empleado = empleado;
    }



    public String getTipoServicio()
    {
        return tipoServicio;
    }

    public double getCosto()
    {
        return costoServicio;
    }

    public Animal getAnimal()
    {
        return animal;
    }

    public Cliente getCliente()
    {
        return cliente;
    }

    public Empleado getEmpleado()
    {
        return empleado;
    }
    
    public  ArrayList<Cita> [] citas() {
    	return this.citas_seleccionadas;
    	
    }
    
//    public String getMapa() {
//    	String cadena = "";
//    	
//    	for (String dia: this.mapa.keySet()) {
//    		cadena+= "\n--" + dia + "---\n";
//    		for (Cita cita: mapa.get(dia)) {
//    			cadena+= cita.getHoraInicio() + " a " + cita.getHoraFin() + "\n";
//    		}
//    	}	
//    	return cadena;
//    }

}

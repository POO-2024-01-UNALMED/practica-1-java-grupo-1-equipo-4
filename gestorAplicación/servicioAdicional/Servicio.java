package gestorAplicación.servicioAdicional;
import gestorAplicación.procesoAdopcion.Animal;
import gestorAplicación.procesoAdopcion.Cliente;

public class Servicio 
{
    private Animal animal;
    private Cliente persona;
    private String tipoServicio;
    private int costoServicio;
    private Empleado empleado;


    //CONSTRUCTOR 1 PARA VERIFICAR USUARIO Y PARA REGISTRARLO SI NO LO ESTA
    public Servicio(Animal animal, Cliente persona){
        this.animal = animal;
        this.persona = persona;
    }

    //CONSTRUCTOR 2 PARA ASIGNARLE A UN CLIENTE UN SERVICIO DE SU ELECCION
    public Servicio(Animal animal, Cliente persona, String tipoServicio)
    {
        this.animal = animal;
        this.persona = persona;
        this.tipoServicio = tipoServicio;
    }


    //METODO SET Y GET
    public void setTipoServicio(String tipoServicio)
    {
        this.tipoServicio = tipoServicio;
    }

    public void setCosto(int costoServicio)
    {
        this.costoServicio = costoServicio;
    }

    public void setAnimal(Animal animal)
    {
        this.animal = animal;
    }

    public void setPersona(Cliente persona)
    {
        this.persona = persona;
    }

    public void setEmpleado(Empleado empleado)
    {
        this.empleado = empleado;
    }



    public String getTipoServicio()
    {
        return tipoServicio;
    }

    public int getCosto()
    {
        return costoServicio;
    }

    public Animal getAnimal()
    {
        return animal;
    }

    public Cliente getPersona()
    {
        return persona;
    }

    public Empleado getEmpleado()
    {
        return empleado;
    }

}

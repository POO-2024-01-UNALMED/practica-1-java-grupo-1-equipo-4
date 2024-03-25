package gestorAplicación.servicioAdicional;
import gestorAplicación.procesoAdopcion.Animal;
import gestorAplicación.procesoAdopcion.Persona;

public class Servicio 
{
    private Animal animal;
    private Persona persona;
    private String tipoServicio;
    private int costoServicio;
    private Empleado empleado;

    //FALTA AGREGAR ENUM TIPO SERVICIO PARA QUE EL CLIENTE ELIJA

    //CONSTRUCTOR 1 PARA VERIFICAR USUARIO Y PARA REGISTRARLO SI NO LO ESTA
    public Servicio(Animal animal, Persona persona)
    {
        this.animal = animal;
        this.persona = persona;
    }

    //CONSTRUCTOR 2 PARA ASIGNARLE A UN CLIENTE UN SERVICIO DE SU ELECCION
    public Servicio(Animal animal, Persona persona, String tipoServicio)
    {
        this.animal = animal;
        this.persona = persona;
        this.tipoServicio = tipoServicio;
    }

    //METODO
    //public boolean verificarUsuario(long identificacion){} NO SE SI ESTO ES NECESARIO
    //EL USUARIO SE PUEDE VERIFICAR CON CONDICIONALES LA CLASE MAIN

    //toString NO LO VEO NECESARIO
    

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

    public void setPersona(Persona persona)
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

    public Persona getPersona()
    {
        return persona;
    }

    public Empleado getEmpleado()
    {
        return empleado;
    }

}

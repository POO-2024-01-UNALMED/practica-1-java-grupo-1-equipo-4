package gestorAplicación.servicioAdicional;

public enum TipoServicio 
{
    VETERINARIA("Veterinaria"), 
    PELUQUERIA("Peluquería"), 
    GUARDERIA("Guardería");

    private String tipoServicio;

    TipoServicio(String tipoServicio)
    {
        this.tipoServicio = tipoServicio;
    }

    @Override
    public String toString()
    {
        return tipoServicio;
    }

    // AGREGAR UN switch(tipoServicio) EN LA CLASE MAIN PARA ASIGNARLE A CADA 
    //SERVICIO UN VALOR.
}
    
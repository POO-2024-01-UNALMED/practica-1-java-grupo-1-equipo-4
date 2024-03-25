package gestorAplicación.servicioAdicional;

public enum Funcionalidad 
{
    AGENDAR_SERVICIO("Agendar servicio"),
    SISTEMA_FINANZAS("Sistema finanzas"), 
    ADOPTAR_ANIMAL("Adoptar animal"), 
    TIENDA_DE_MASCOTAS("Tienda de mascotas"), 
    ONG("ONG");
    
    private String funcionalidad;

    Funcionalidad(String funcionalidad)
    {
        this.funcionalidad = funcionalidad;
    }

    @Override
    public String toString()
    {
        return funcionalidad;
    }   
}

package gestorAplicación.servicioAdicional;

public enum Rol
{
    VETERINARIO("Veterinario"), PELUQUERO("Peluquero"), CUIDADOR("Cuidador"), TENDERO("Tendero");

    private String rol;

    Rol(String rol)
    {
        this.rol = rol;
    }

    @Override
    public String toString()
    {
        return rol;
    }
}

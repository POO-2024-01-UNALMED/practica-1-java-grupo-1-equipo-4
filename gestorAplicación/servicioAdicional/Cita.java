package gestorAplicación.servicioAdicional;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

Public class Cita{
    private String Hora;
    private String Fecha;
    private String Nombre;
    private int ID;
    private String Tipo;
    private ArrayList<Cita> citas=new ArrayList<>();
    private ArrayList<Cita> CategoriaCliente=new ArrayList<>();

     //Constructor
    public Cita(String Fecha, String Hora, int ID, String Nombre, String Tipo) {
        this.hora = Hora;
        this.fecha = Fecha;
        this.ID=ID;
        this.Nombre=Nombre;
    }

    //Lista de Tipo Cliente
    List <Cliente> Oro=new ArrayList<>();
    List <Cliente> Plata=new ArrayList<>();
    List <Cliente> Bronce=new ArrayList<>();

    //Metodo para contar las veces que esta el ID
    public static int contCitas(int ID){
        int contID = 0;
        for (Cita cita : citas){
            if (cita.getID()==ID){
                contID++;
            }
        }
        return contID;
    }

    //Metodo para categorizacion
    public static void catgCliente(){
        for (Cita cita: citas){
            int ID=cita.getID();
            int numCitas=contCitas(ID);
            if (numCitas>=10){
                Oro.add(ID);
            }else if (numCitas>=5 && numCitas<=10){
                Plata.add(ID);
            }else if(numCitas>3){
                Bronce.add(ID);
            }
        }
        CategoriaCliente.add(List Oro);
        CategoriaCliente.add(List Plata);
        CategoriaCliente.add(List Bronce);
    }


    //Encuesta Citas
    //Public Static Void Citas (){}
    List <Cita> TE = new ArrayList<>();
    List <Cita> TP = new ArrayList<>();
    List <Cita> TCo = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    System.out.println("¿Es una cita de Emergencia, Prioritaria o Comun?");
    String TC = Scanner.nextLine().toLowerCase; //TC=Tipo Cita
    if (TC.equals("emergencia")){
        System.out.println("Ingresa la fecha para la que deseas tu cita, en el formato dia, mes y año");
        String Fecha = Scanner.nextLine();
        System.out.println("Ingresa la hora para la que deseas tu cita, en el formato horam jornada (am,pm)");
        String Hora = Scanner.nextLine();
        System.out.println("Ingresa tu ID");
        int ID = Scanner.nextLine();
        System.out.println("Ingresa tu nombre");
        String Nombre = Scanner.nextLine().toLowerCase();
        TE.add(new Cita(fecha, Hora, ID, Nombre));
        citas.add(List TE);
    }else if (TC.equals("prioritaria")){
        System.out.println("Ingresa la fecha para la que deseas tu cita, en el formato dia, mes y año");
        String Fecha = Scanner.nextLine();
        System.out.println("Ingresa la hora para la que deseas tu cita, en el formato horam jornada (am,pm)");
        String Hora = Scanner.nextLine();
        System.out.println("Ingresa tu ID");
        int ID = Scanner.nextLine();
        System.out.println("Ingresa tu nombre");
        String Nombre = Scanner.nextLine().toLowerCase();
        TP.add(new Cita(fecha, Hora, ID,Nombre));
        citas.add(List TP);
    }else if (TC.equals("comun")){
        System.out.println("Ingresa la fecha para la que deseas tu cita, en el formato dia, mes y año");
        String Fecha = Scanner.nextLine();
        System.out.println("Ingresa la hora para la que deseas tu cita, en el formato horam jornada (am,pm)");
        String Hora = Scanner.nextLine();
        System.out.println("Ingresa tu ID");
        int ID = Scanner.nextLine();
        System.out.println("Ingresa tu nombre");
        String Nombre = Scanner.nextLine().toLowerCase();
        TCo.add(new Cita(fecha, Hora, ID, Nombre));
        citas.add(List TCo);
    }else{
        System.out.println("Opcion no valida, verifica tu respuesta");
    }

    //Establecer descuento cliente
    public static double aplicarDescuento(int ID, double precioOriginal) {
        double precioFinal = precioOriginal;
        if (CategoriaCliente.Oro.contains(ID)) {
            precioFinal -= precioOriginal * 0.05; // Descuento del 5% para la categoría Oro
        } else if (CategoriaCliente.Plata.contains(ID)) {
            precioFinal -= precioOriginal * 0.10; // Descuento del 10% para la categoría Plata
        } else if (CategoriaCliente.Bronce.contains(ID)) {
            precioFinal -= precioOriginal * 0.15; // Descuento del 15% para la categoría Bronce
        }
        
        return precioFinal;
    }

    //Getters and Setters
    public void setFecha (String Fecha){
        this.Fecha=Fecha;
    }
    public void setHora (String Hora){
        this.Hora=Hora;
    }
    public void setID (int ID){
        this.ID=ID;
    }
    public void setNombre (String Nombre){
        this.Nombre=Nombre;
    }
    public void setTipo(String Tipo){
        this.Tipo=Tipo;
    }
    public String getFecha(){
        return Fecha;
    }
    public String getHora(){
        return Hora;
    }
    public int getID(){
        return ID;
    }
    public String getNombre(){
        return Nombre;
    }
    public String getTipo(){
        return Tipo;
    }

    //To String
    public String toString(){
        return "\nTipo de cita:"+getTipo()+"\nFecha"+getFecha()+"\nHora"+getHora()+"\nID"+getID()+"\nNombre"+getNombre()+"\n";
    }
    @Override
    public String toString() {
        return "cita [hora=" + hora + ", fecha=" + fecha + "]";
    }
}

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Parqueadero {

    private String nombre;
    //  key,value
    //{[a02,Registro:{Vehiculo,Usuario,horaEntrada,horaSalida}]}
    private HashMap<String,Registro> vehiculos;
    private int cantidadEspaciosTotal;
    private List<Registro> historialTotalVehiculos;
    //[a01-a02-a03-a04-b01-b02-b03]
    private String[] parquins;


    public Parqueadero() {
    }
    public Parqueadero(String nombre, HashMap<String, Registro> vehiculos, int cantidadEspaciosTotal, List<Registro> historialTotalVehiculos,String[] parquins) {
        this.nombre = nombre;
        this.vehiculos = vehiculos;
        this.cantidadEspaciosTotal = cantidadEspaciosTotal;
        this.historialTotalVehiculos = historialTotalVehiculos;
        this.parquins = parquins;
    }
    public String[] getParquins(){ return parquins; }
    public void setParquins(String[] parquins){ this.parquins = parquins; }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public HashMap<String, Registro> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(HashMap<String, Registro> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public int getCantidadEspaciosTotal() {
        return cantidadEspaciosTotal;
    }

    public void setCantidadEspaciosTotal(int cantidadEspaciosTotal) {
        this.cantidadEspaciosTotal = cantidadEspaciosTotal;
    }

    public List<Registro> getHistorialTotalVehiculos() {
        return historialTotalVehiculos;
    }

    public void setHistorialTotalVehiculos(List<Registro> historialTotalVehiculos) {
        this.historialTotalVehiculos = historialTotalVehiculos;
    }

    @Override
    public String toString() {
        return "Parqueadero{" +
                "nombre='" + nombre + '\'' +
                ", vehiculos=" + vehiculos +
                ", cantidadEspaciosTotal=" + cantidadEspaciosTotal +
                ", historialTotalVehiculos=" + historialTotalVehiculos +
                ", parquins=" + Arrays.toString(parquins) +
                '}';
    }

    public void mostrarHistorial(LocalDateTime fechaHoraInicioFiltro, LocalDateTime fechaHoraFinFiltro){
        for (Registro historialTotalVehiculo : historialTotalVehiculos) {
            System.out.println(historialTotalVehiculo);
        }
    }
    public List<String> mostrarEspaciosLibres(){
        List<String> parqueaderosLibres = new ArrayList<>();
        if (vehiculos.isEmpty()){
            return Arrays.stream(parquins).toList();
        }
        if(vehiculos.size()==parquins.length) {
            System.out.println("No hay espacios disponibles");
        }else{
            for (String parqueadero : parquins) {
                if (!vehiculos.containsKey(parqueadero)) {
                    System.out.println(parqueadero);
                    parqueaderosLibres.add(parqueadero);
                }
            }
        }
        return parqueaderosLibres;
    }
    public void mostrarVehiculosActivosParquedero(){
        System.out.println("los vehiculos actualmente que se encuentran en el parqueadero:");
        for (String parqueadero : vehiculos.keySet()){
            System.out.println(vehiculos.get(parqueadero).getHoraEntrada()+" - "+vehiculos.get(parqueadero).getVehiculo());
        }
    }
    public void agregarRegistro(){
        System.out.println("Escribe el nombre del parqueadero en el que vas a estacionar:");
        List<String> parqueaderos = this.mostrarEspaciosLibres();

    }
    public void cerrarRegistro(String Parquin){

    }
}
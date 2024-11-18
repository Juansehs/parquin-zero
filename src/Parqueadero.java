import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

public class Parqueadero {

    private String nombre;
    //key(parqueadero),value(informacion registro)
    //{[a02,Registro:{Vehiculo,Usuario,horaEntrada,horaSalida}]}
    private HashMap<String,Registro> vehiculos = new HashMap<>();
    private int cantidadEspaciosTotal;
    private List<Registro> historialTotalVehiculos=new ArrayList<>();
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

    public void mostrarHistorial(){
        Scanner input = new Scanner(System.in);
        System.out.println("Escoja la opcion que desee:\n(1)Ver todo el historial\n(2)Ver solo el historial de hoy\n(3)Realizar el filtro");
        List<Registro> registrosFiltrados = new ArrayList<>();
        LocalDateTime fechaInicio,fechaFin;
        switch (input.nextInt()){
            case 1:
                for (Registro historialTotalVehiculo : historialTotalVehiculos) {
                    System.out.println("\nfecha de entrada: " + historialTotalVehiculo.getHoraEntrada().getDayOfMonth() + "/" + historialTotalVehiculo.getHoraEntrada().getMonthValue() + "/" + historialTotalVehiculo.getHoraEntrada().getYear() + " " + historialTotalVehiculo.getHoraEntrada().getHour() + ":" + historialTotalVehiculo.getHoraEntrada().getMinute());
                    historialTotalVehiculo.getUsuario().mostrarInfo();
                    historialTotalVehiculo.getVehiculo().infoVehiculo();
                }
                break;
            case 2:
                LocalDate fechaHoy = LocalDate.now();
                fechaInicio = fechaHoy.atStartOfDay();
                fechaFin = fechaHoy.atTime(LocalTime.MAX);
                registrosFiltrados = historialTotalVehiculos.stream()
                        .filter(registro -> !registro.getHoraEntrada().isBefore(fechaInicio) && !registro.getHoraEntrada().isAfter(fechaFin))
                        .toList();
                if (!registrosFiltrados.isEmpty()) {
                    System.out.println("Estos son los vehiculos que han estado el dia de hoy(no estan los vehiculos que se encuentran actualmente):");
                    for (Registro registro : registrosFiltrados) {
                        System.out.println("\nfecha de entrada: " + registro.getHoraEntrada().getDayOfMonth() + "/" + registro.getHoraEntrada().getMonthValue() + "/" + registro.getHoraEntrada().getYear() + " " + registro.getHoraEntrada().getHour() + ":" + registro.getHoraEntrada().getMinute());
                        registro.getUsuario().mostrarInfo();
                        registro.getVehiculo().infoVehiculo();
                    }
                } else {
                    System.out.println("No hay registros de vehiculos el dia de hoy.");
                }
                break;
            case 3:
                System.out.println("Ingrese la fecha de inicio:");
                System.out.print("Día: ");
                int diaInicio = input.nextInt();
                System.out.print("Mes (1-12): ");
                int mesInicio = input.nextInt();
                System.out.print("Año: ");
                int anoInicio = input.nextInt();
                System.out.println("Ingrese la fecha de fin:");
                System.out.print("Día: ");
                int diaFin = input.nextInt();
                System.out.print("Mes (1-12): ");
                int mesFin = input.nextInt();
                System.out.print("Año: ");
                int anoFin = input.nextInt();
                fechaInicio = LocalDateTime.of(anoInicio, mesInicio, diaInicio, 0, 0);
                fechaFin = LocalDateTime.of(anoFin, mesFin, diaFin, 23, 59);
                registrosFiltrados = historialTotalVehiculos.stream()
                        .filter(registro -> !registro.getHoraEntrada().isBefore(fechaInicio) && !registro.getHoraEntrada().isAfter(fechaFin))
                        .toList();
                if (!registrosFiltrados.isEmpty()) {
                    System.out.println("Estos son los vehiculos que se encuentran en las fechas dadas:");
                    for (Registro registro : registrosFiltrados) {
                        System.out.println("\nfecha de entrada: " + registro.getHoraEntrada().getDayOfMonth() + "/" + registro.getHoraEntrada().getMonthValue() + "/" + registro.getHoraEntrada().getYear() + " " + registro.getHoraEntrada().getHour() + ":" + registro.getHoraEntrada().getMinute());
                        registro.getUsuario().mostrarInfo();
                        registro.getVehiculo().infoVehiculo();
                    }
                } else {
                    System.out.println("No hay registros en las fechas proporcionado.");
                }
                break;
            default:
                System.out.println("Opcion incorrecta, vuelva a intentarlo");
        }
    }
    public List<String> mostrarEspaciosLibres(){
        List<String> parqueaderosLibres = new ArrayList<>();
        if (vehiculos.isEmpty()){
            return Arrays.stream(parquins).toList();
        }
        if(vehiculos.size()==parquins.length) {
            System.out.println("No hay espacios disponibles en el parqueadero: "+getNombre());
        }else{
            for (String parqueadero : parquins) {
                if (!vehiculos.containsKey(parqueadero)) parqueaderosLibres.add(parqueadero);
            }
        }
        return parqueaderosLibres;
    }
    public void mostrarVehiculosActivosParquedero(){
        if(!vehiculos.isEmpty()) {
            System.out.println("Los vehiculos que se encuentran actualmente en el " + getNombre() + ": ");
            for (String parqueadero : vehiculos.keySet()) {
                System.out.println("\nfecha de entrada: " + vehiculos.get(parqueadero).getHoraEntrada().getDayOfMonth() + "/" + vehiculos.get(parqueadero).getHoraEntrada().getMonthValue() + "/" + vehiculos.get(parqueadero).getHoraEntrada().getYear() + " " + vehiculos.get(parqueadero).getHoraEntrada().getHour() + ":" + vehiculos.get(parqueadero).getHoraEntrada().getMinute());
                vehiculos.get(parqueadero).getUsuario().mostrarInfo();
                vehiculos.get(parqueadero).getVehiculo().infoVehiculo();
            }
        }else System.out.println("No hay vehiculos en el parqueadero");
    }
    public void agregarRegistro(){
        try{
            Scanner input = new Scanner(System.in);
            List<String> parqueaderos = this.mostrarEspaciosLibres();
            while (true){
                Registro registroUsu = new Registro();
                if(parqueaderos.isEmpty()) break;
                System.out.println("Estos son los parquederos disponibles, Escribe el nombre del parqueadero en el que vas a estacionar:");
                System.out.println(parqueaderos);
                String parqueaderoEscogido = input.next();
                if(!parqueaderos.contains(parqueaderoEscogido)) continue;
                registroUsu.realizarRegistro();
                vehiculos.put(parqueaderoEscogido,registroUsu);
                System.out.println("Registro exitoso.");
                break;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public void cerrarRegistro(String cedula,String placa){
        String parqueaderoVehiculo = null;
        for(String key : getVehiculos().keySet()){
            if(Objects.equals(getVehiculos().get(key).getUsuario().getCedula(), cedula) && Objects.equals(getVehiculos().get(key).getVehiculo().getPlaca(), placa)){
                parqueaderoVehiculo = key;
            }
        }
        if(parqueaderoVehiculo!=null){
            getVehiculos().get(parqueaderoVehiculo).registrarSalida();
            System.out.println("Tiempo que ha estado el vehiculo en el parqueadero: "+getVehiculos().get(parqueaderoVehiculo).calcularTiempoEstadia()+" Minutos");
            System.out.println("Buen viaje!!");
            historialTotalVehiculos.add(getVehiculos().get(parqueaderoVehiculo));
            getVehiculos().remove(parqueaderoVehiculo);
        }else
            System.out.println("No hay ningun vehiculo registrado en este parqueadero con ese numero de cedula y/o placa");
    }
}
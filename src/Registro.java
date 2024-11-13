import java.time.LocalDateTime;

public class Registro {
    private Vehiculo vehiculo;
    private LocalDateTime horaEntrada;
    private LocalDateTime horaSalida;
    private   Usuario  usuario;

    public Registro(Vehiculo vehiculo, LocalDateTime horaEntrada) {
        this.vehiculo = vehiculo;
        this.horaEntrada = horaEntrada;
    }

    public void registrarSalida() {
        this.horaSalida = LocalDateTime.now();
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public LocalDateTime getHoraEntrada() {
        return horaEntrada;
    }

    public LocalDateTime getHoraSalida() {
        return horaSalida;
    }

    public long calcularTiempoEstadia() {
        if (horaSalida == null) return -1;
        return java.time.Duration.between(horaEntrada, horaSalida).toMinutes();
    }

    @Override
    public String toString() {
        return "Registro [Vehiculo=" + vehiculo + ", Hora de Entrada=" + horaEntrada + ", Hora de Salida=" + horaSalida + "]";
    }
}

import javax.swing.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Registro {
    private Vehiculo vehiculo;
    private LocalDateTime horaEntrada;
    private LocalDateTime horaSalida;
    private Usuario usuario;

    public Registro() {
    }

    public Registro(Vehiculo vehiculo, LocalDateTime horaEntrada, Usuario usuario) {
        this.vehiculo = vehiculo;
        this.horaEntrada = horaEntrada;
        this.usuario = usuario;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public void setHoraEntrada(LocalDateTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
        return Duration.between(horaEntrada, horaSalida).toMinutes();
    }

    public HashMap<String, Estudiante> conseguirEstudiantes() {
        Estudiante estudiante1 = null;
        String[] nombresestudiantes = {
                "JuanDiego", "Maye", "Luna", "Delani", "Natalia", "Anita", "Ferxxo", "Angela", "Paula"
        };
        String[] cedulasestudiantes = {
                "4343434", "4323265", "4534332", "6642409", "6436433", "65464334", "63463434", "4634364", "434346554"
        };
        HashMap<String, Estudiante> estudiantes = new HashMap<>();
        for (int i = 0; i < nombresestudiantes.length; i++) {
            estudiante1 = new Estudiante();
            estudiante1.setNombre(nombresestudiantes[i]);
            estudiante1.setCedula(cedulasestudiantes[i]);
            estudiantes.put(estudiante1.getCedula(), estudiante1);
        }
        return estudiantes;
    }

public void realizarRegistro() {
    this.setUsuario(this.agregarUsuario());
    this.setVehiculo(this.agregarVehiculo());
    this.setHoraEntrada(LocalDateTime.now());
}

public Usuario agregarUsuario() {
    Scanner input = new Scanner(System.in);
    System.out.println(" Escriba su Numero de Cedula : ");
    String cedula = input.next();
    HashMap<String, Estudiante> estudiantes = this.conseguirEstudiantes();
    HashMap<String, Docente> docentes = this.conseguirDocentes();
    HashMap<String, Visitante> visitantes = this.conseguirVisitantes();
    if (estudiantes.containsKey(cedula))
        return estudiantes.get(cedula);
    if (docentes.containsKey(cedula))
        return docentes.get(cedula);
    if (visitantes.containsKey(cedula))
        return visitantes.get(cedula);
    else {
        Visitante visitante1 = new Visitante();
        visitante1.setCedula(cedula);
        System.out.println(" Ingrese su Nombre ");
        visitante1.setNombre(input.next());
        input.nextLine();
        System.out.println("Ingrese su Motivo de Visita ");
        visitante1.setMotivoVisita(input.nextLine());
        return visitante1;
    }


}

public HashMap<String, Docente> conseguirDocentes() {
    Docente docente1 = null;
    String[] nombres = {
            "Miguelon", "KattyPerry", "Andrescepeda", "Trueno", "CamiloSanchez", "Mia", "Vanessa"
    };
    String[] cedulas = {
            "33232", "545632", "45362", "64637", "35232", "5747372", "436463"
    };
    HashMap<String, Docente> docentes = new HashMap<>();
    for (int i = 0; i < nombres.length; i++) {
        docente1 = new Docente();
        docente1.setNombre(nombres[i]);
        docente1.setCedula(cedulas[i]);
        docentes.put(docente1.getCedula(), docente1);
    }
    return docentes;

}

public HashMap<String, Visitante> conseguirVisitantes() {
    Visitante visitante1 = new Visitante();
    visitante1.setNombre("duki");
    visitante1.setCedula("826");
    HashMap<String, Visitante> visitantes = new HashMap<>();
    visitantes.put(visitante1.getCedula(), visitante1);
    return visitantes;
}

public Vehiculo agregarVehiculo() {
    Scanner input = new Scanner(System.in);
    while (true) {
        System.out.println(" ¿ Que deseas Ingresar ? \n1) Carro  \n2) Moto ");
        switch (input.nextInt()) {
            case 1:
                Carro carro1 = new Carro();
                System.out.println("Por favor digite modelo   :");
                carro1.setModelo(input.next());
                System.out.println("Por favor digite  placa  :");
                carro1.setPlaca(input.next());
                System.out.println("Por favor digite marca  :");
                carro1.setMarca(input.next());
                return carro1;
            case 2:
                Moto moto1 = new Moto();
                System.out.println("Por favor digite Marca   :");
                moto1.setreferencia(input.next());
                System.out.println("Por favor digite su Placa  :");
                moto1.setPlaca(input.next());
                System.out.println("Por favor digite su Cilindraje  :");
                moto1.setCilindraje(input.next());
                return moto1;

            default:
                System.out.println(" Tienes que digitar las opciones correspodinetes! ");
        }
    }
}

@Override
public String toString() {
    return "Registro [Vehiculo=" + vehiculo + ", Hora de Entrada=" + horaEntrada + ", Hora de Salida=" + horaSalida + "]";
}
}

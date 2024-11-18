import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Parqueadero> parqueaderos = getParqueaderos();
        cicloMenu:
        while(true){
            System.out.println("  -------------------------- \n| Bienvenido al Parquin Zero |\n  -------------------------- ");
            System.out.println("Escoja el parqueadero: ");
            for (int i=0;i<parqueaderos.size();i++){
                System.out.println("("+i+") "+parqueaderos.get(i).getNombre());
            }
            Parqueadero parqueaderoEscogido = parqueaderos.get(input.nextInt());
            System.out.println("\nDigite la opcion que desee:\n(1)Registrar entrada de vehiculo\n(2)Registrar salida de vehiculo\n(3)Ver vehiculos del parqueadero\n(4)Mostrar historial de vehiculos\n(5)Atras\n(6)Salir");
            switch (input.nextInt()){
                case 1:
                    parqueaderoEscogido.agregarRegistro();
                    break;
                case 2:
                    System.out.println("Escriba su numero de cedula: ");
                    parqueaderoEscogido.cerrarRegistro(input.next());
                    break;
                case 3:
                    parqueaderoEscogido.mostrarVehiculosActivosParquedero();
                    break;
                case 4:
                    parqueaderoEscogido.mostrarHistorial();
                    break;
                case 5:
                    continue;
                case 6:
                    break cicloMenu;
                default: System.out.println("Opcion incorrecta, vuelva a intentarlo");
            }
        }
    }

    private static List<Parqueadero> getParqueaderos() {
        List<Parqueadero> parqueaderos = new ArrayList<>();
        Parqueadero par1 = new Parqueadero();
        String[] parqueaderos1 = {"a01","a02","a03","a04","b01","b02","b03","b04"};
        par1.setParquins(parqueaderos1);
        par1.setNombre("Parqueadero Sur");
        Parqueadero par2 = new Parqueadero();
        String[] parqueaderos2 = {"a01","a02","b01","b02","c01","c02","d01","d02"};
        par2.setParquins(parqueaderos2);
        par2.setNombre("Parqueadero Norte");
        parqueaderos.add(par1);
        parqueaderos.add(par2);
        return parqueaderos;
    }
}
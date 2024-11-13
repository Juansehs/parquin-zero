public class Main {
    public static void main(String[] args) {
        Parqueadero par1 = new Parqueadero();
        String[] parqueaderos = {"a01","a02","a03","a04","b01","b02","b03"};
        par1.setParquins(parqueaderos);
        par1.agregarRegistro();
    }
}
public class Carro extends Vehiculo {
    private String marca;
    private String modelo;

    public Carro(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    void infoVehiculo() {
        System.out.println("El auto:"+getModelo()+"tiene como placa:"+getPlaca()+"es de la marca "+getMarca());
    }
}

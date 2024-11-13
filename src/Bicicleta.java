public class Bicicleta  extends Vehiculo{
  private   String fabricante;
    private String marco;

    public Bicicleta() {
    }

    public Bicicleta(String placa, String tipodevehiculo, String fabricante, String marco) {
        super(placa, tipodevehiculo);
        this.fabricante = fabricante;
        this.marco = marco;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getMarco() {
        return marco;
    }

    public void setMarco(String marco) {
        this.marco = marco;
    }

    @Override
    void infoVehiculo() {
        System.out.println( "La bicleta es del fabricante"+getFabricante()+"y es de"+getMarco()+"su tamaño de marco"+"su identifiacion es :"+getPlaca());
    }
}

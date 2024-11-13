public class Moto  extends  Vehiculo{
private String cilindraje;
 private String referencia;

    public Moto() {
    }

    public Moto(String placa, String tipodevehiculo, String cilindraje, String referencia) {
        super(placa, tipodevehiculo);
        this.cilindraje = cilindraje;
        this.referencia = referencia;
    }

    public String getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(String cilindraje) {
        this.cilindraje = cilindraje;
    }

    public String getreferencia() {
        return referencia;
    }

    public void setreferencia(String referencia) {
        this.referencia = referencia;
    }

    @Override
    void infoVehiculo() {
        System.out.println("La moto:"+getreferencia()+"tiene como placa:"+ getPlaca()+"Tiene : "+getCilindraje()+"de cilindraje");
    }
}

public  abstract class  Vehiculo {
 private String placa;
 private String tipodevehiculo;

    public Vehiculo() {
    }

    public Vehiculo(String placa, String tipodevehiculo) {
        this.placa = placa;
        this.tipodevehiculo = tipodevehiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipodevehiculo() {
        return tipodevehiculo;
    }

    public void setTipodevehiculo(String tipodevehiculo) {
        this.tipodevehiculo = tipodevehiculo;
    }
    abstract void infoVehiculo();

}


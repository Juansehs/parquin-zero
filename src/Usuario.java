abstract public class Usuario {

    private String nombre;
    private String cedula;
    private String[] objetos;
    
    public void setObjetos(String[] objetos){ this.objetos = objetos; }
    
    public String[] getObjetos(){ return objetos; }

    public void setCedula(String cedula){ this.cedula = cedula; }
    
    public String getCedula(){ return cedula; }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public abstract void mostrarInfo();
}
import java.util.ArrayList;
import java.util.List;

abstract public class Usuario {

    private String nombre;
    private String cedula;
    private List<String> objetos=new ArrayList<>();

    public List<String> getObjetos() {
        return objetos;
    }

    public void setObjetos(List<String> objetos) {
        this.objetos = objetos;
    }

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
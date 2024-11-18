import java.util.List;

public class Docente extends Usuario{

    private boolean activo;

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public void mostrarInfo(){
        System.out.println("El usuario es Docente, nombre: "+getNombre()+", documento: "+getCedula()+", el usuario esta "+(getActivo() ? "Activo":"Desactivo")+" en el sistema");
        if(!getObjetos().isEmpty()){
            List<String> objetos = getObjetos();
            System.out.println("Objetos que trae el usuario: ");
            for (int i=0;i<objetos.size();i++){
                System.out.println("("+i+") "+objetos.get(i));
            }
        }
    }
}

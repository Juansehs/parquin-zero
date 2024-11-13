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
        if(getObjetos().length!=0){
            String[] objetos = getObjetos().clone();
            System.out.println("Objetos que trae el usuario: ");
            for (int i=0;i<objetos.length;i++){
                System.out.println("("+i+") "+objetos[i]);
            }
        }
    }
}

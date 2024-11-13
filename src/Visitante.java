public class Visitante extends Usuario{
    private String motivoVisita;

    public String getMotivoVisita() {
        return motivoVisita;
    }

    public void setMotivoVisita(String motivoVisita) {
        this.motivoVisita = motivoVisita;
    }

    @Override
    public void mostrarInfo(){
        System.out.println("El usuario es Visitante, nombre: "+getNombre()+", documento: "+getCedula()+", el motivo de visita es: "+getMotivoVisita());
        if(getObjetos().length!=0){
            String[] objetos = getObjetos().clone();
            System.out.println("Objetos que trae el visitante: ");
            for (int i=0;i<objetos.length;i++){
                System.out.println("("+i+") "+objetos[i]);
            }
        }
    }
}

import java.util.ArrayList;

public class SistemaOperativo {
    //declaramos los aributos del sistema operativo
    private BloqueMemoria administrarMemoria;
    private ArrayList<Proceso> listaProceso = new ArrayList<Proceso>();
    private Memoria memoria;

    //creamos un constructor y los respectivos getter y setters
    public SistemaOperativo(BloqueMemoria administrarMemoria, Memoria memoria) {
        this.administrarMemoria = administrarMemoria;
        this.memoria = memoria;
        //proceso que siempre se inicia cuando el sistema operativo se crea
        listaProceso.add(Proceso vanguard = new Proceso(1,20));
    }

    public BloqueMemoria getAdministrarMemoria() {
        return administrarMemoria;
    }

    public void setAdministrarMemoria(BloqueMemoria administrarMemoria) {
        this.administrarMemoria = administrarMemoria;
    }

    public ArrayList<Proceso> getListaProceso() {
        return listaProceso;
    }
    //remplazamos el setListaProceso por un agregarProceso
    public void agregarProceso(Proceso ProcesoNuevo) {
        listaProceso.add(ProcesoNuevo);
    }

    public Memoria getMemoria() {
        return memoria;
    }

    public void setMemoria(Memoria memoria) {
        this.memoria = memoria;
    }
    //creacion del metodo crearProceso
    public void crearProceso(int id,int tamanio){

    }
    //creacion del metodo eliminarProceso
    public void eliminarProceso(Proceso proceso){

    }
    //creacion del metodo iniciar
    public void iniciar(){

    }
    //creacion del metodo terminar
    public void terminar(){

    }

}

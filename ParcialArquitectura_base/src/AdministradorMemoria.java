import java.util.ArrayList;

public class AdministradorMemoria {
    private ArrayList<BloqueMemoria> listaBloques;
    private ArrayList<Proceso> listaEspera;

    //Composicion de BloqueMemoria
    public AdministradorMemoria() {
        this.listaBloques = new ArrayList<BloqueMemoria>();
    }

    //Agregacion de ListaEspera
    public void crearListaEspera() {
        this.listaEspera = new ArrayList<Proceso>();
    }

    //agrega procesos a la lista de procesos
    public void addProceso(Proceso p){
        listaEspera.add(p);
    }

    //metodo crearBloque, agrega bloques a la lista de bloques
    public void addBloqueMemoria(BloqueMemoria bm){
        listaBloques.add(bm);
    }

    public void quitarBloqueMemoria(BloqueMemoria bm){
        for (int i = 0; i < listaBloques.size(); i++) {
            if (listaBloques.get(i) != null && (listaBloques.get(i) == bm)){
                listaBloques.remove(i);
            }
        }
    }

    public void quitarProceso(Proceso p){
        for (int i = 0; i < listaEspera.size(); i++) {
            if (listaEspera.get(i) != null && (listaEspera.get(i) == p)) {
                listaEspera.remove(i);
            }
        }
    }
    public ArrayList<BloqueMemoria> getListaBloques() {
        return listaBloques;
    }

    public ArrayList<Proceso> getListaEspera() {
        return listaEspera;
    }


}

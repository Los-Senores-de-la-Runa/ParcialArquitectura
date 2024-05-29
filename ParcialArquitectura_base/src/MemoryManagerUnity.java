import java.util.ArrayList;

public class MemoryManagerUnity {
    private ArrayList<BloqueMemoria> listaBloques = new ArrayList<>();
    private ArrayList<Proceso> listaDeEsperaProcesos = new ArrayList<>();
    private Memoria memoria;

    public MemoryManagerUnity(Memoria memoria , Proceso sO) {
        //Se inicia con un proceso que es el sistema operativo
        BloqueMemoria sistemaOperativo = new BloqueMemoria(250);

        //Al bloque que le corresponde el sistema operativo, se le asigna el sistema operativo
        sistemaOperativo.setProcesoAsignado(sO);
        listaBloques.add(sistemaOperativo);

        this.memoria = memoria;

        //Se crea el resto del bloque donde van a ir el resto de procesos
        BloqueMemoria restoDeProcesos = new BloqueMemoria(0);
        listaBloques.add(restoDeProcesos);
    }

    public ArrayList<BloqueMemoria> getListaBloques() {
        return listaBloques;
    }

    public void setListaBloques(BloqueMemoria bloque) {
        listaBloques.add(bloque);
    }

    public ArrayList<Proceso> getListaDeEsperaProcesos() {
        return listaDeEsperaProcesos;
    }

    public void agregarProcesoListaEspera(Proceso proceso) {
        listaDeEsperaProcesos.add(proceso);
    }


    public void a(){

        //Comenzamos desde los ultimos bloques ya que van a ser los mas pequeños porque van a ser los que se dividen
        for (int i = listaBloques.size()-1; i >= 1; i--) {

            //Si el proceso es menor que la mitad del bloque, se va a dividir
            if (listaDeEsperaProcesos.get(0).getTamanio() < (listaBloques.get(i).getTamano()/2)){

                //Se va a crear otro bloque que va a ser la mitad del primer bloque
                BloqueMemoria bloqueMemoria = new BloqueMemoria(listaBloques.get(i).getTamano()/2);

                //El bloque actual, al dividirse en dos, su tamaño cambia
                listaBloques.get(i).setTamano((listaBloques.get(i).getTamano()/2));

                //Se agrega a la lista de bloques de memoria
                listaBloques.add(bloqueMemoria);
            }
        }
    }

}

import java.util.ArrayList;
import java.util.Random;

public class MemoryManagerUnity {
    private ArrayList<BloqueMemoria> listaBloques = new ArrayList<>();
    private ArrayList<Proceso> listaDeEsperaProcesos = new ArrayList<>();
    private Memoria memoria;

    public MemoryManagerUnity(Memoria memoria , Proceso sO) {
        //Se inicia con un proceso que es el sistema operativo
        BloqueMemoria sistemaOperativo = new BloqueMemoria(250);
        BloqueMemoria bloqueMemoria = new BloqueMemoria(1000);

        //Al bloque que le corresponde el sistema operativo, se le asigna el sistema operativo
        sistemaOperativo.setProcesoAsignado(sO);
        listaBloques.add(sistemaOperativo);
        listaBloques.add(bloqueMemoria);
        this.memoria = memoria;
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
        //inicio del bucle que recorre toda la lista de espera
        for (int i = 0; i < listaDeEsperaProcesos.size(); i++) {
            //contador auxiliar para asegurarnos de que el espacio ocupado no exeda la memoria total
            double contador_tamanio = 0;
            for (int k = 1; k < listaBloques.size(); k++) {

                if (listaBloques.get(k).getProcesoAsignado() != null) {
                    contador_tamanio = contador_tamanio + listaBloques.get(k).getTamano();
                }
            }
            System.out.println(contador_tamanio);//borrar despues. sout de ayuda

            if(contador_tamanio< memoria.getTamanio()){ //if para asegurarnos de que el espacio ocupado no exeda la memoria total

                for (int j = listaBloques.size()-1; j >= 1; j--) { //for que recorre la lista buscando lugares

                    if (listaBloques.get(j).getProcesoAsignado() == null) { //if que verifica que el bloque que se revisa esta actualmente vacio

                        if (listaDeEsperaProcesos.get(i).getTamanio() < (listaBloques.get(j).getTamano() / 2)) { //if para revisar si el proceso puede entrar si dividimos el bloque

                            System.out.println(listaDeEsperaProcesos.get(i).getNombre());
                            //Si el proceso es menor que la mitad del bloque, se va a dividir
                            System.out.println("el bloque de memoria se pudo dividir");
                            //Se va a crear otro bloque que va a ser la mitad del primer bloque
                            BloqueMemoria bloqueMemoria = new BloqueMemoria(listaBloques.get(j).getTamano() / 2);
                            //El bloque actual, al dividirse en dos, su tamaño cambia
                            listaBloques.get(j).setTamano((listaBloques.get(j).getTamano() / 2));
                            //Se agrega a la lista de bloques de memoria
                            listaBloques.add(bloqueMemoria);
                            j++;

                        }else { //en caso de que no se pueda dividir se mete en el ultimo que reviso y se rompe el bucle de lista de bloques
                            System.out.println("el bloque de memoria no se pudo dividir mas, asignando proceso " + listaDeEsperaProcesos.get(i).getNombre() + " a la memoria");
                            listaBloques.get(j).setProcesoAsignado(listaDeEsperaProcesos.get(i));
                            break;
                            //revisamos el siguiente proceso
                        }
                    }
                }
            }

            System.out.println("---------------");
        }
    }
}
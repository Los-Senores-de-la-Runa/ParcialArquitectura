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
    public void mostrarEstadoMemoria() {
        System.out.println("Estado actual de la memoria:");
        for (BloqueMemoria bloque : listaBloques) {
            if (bloque.getProcesoAsignado() != null) {
                System.out.println("Bloque de " + bloque.getTamano() + " KB - Proceso: " + bloque.getProcesoAsignado().getNombre());
            } else {
                System.out.println("Bloque de " + bloque.getTamano() + " KB - Libre");
            }
        }
        System.out.println();
    }


    public void gestion_memoria(){
        int contador = 0;
        boolean condicion_salida = true;
        boolean lista_bloques_emty = false;
        while(condicion_salida){
            for (int i = 0; i < listaBloques.size(); i++) {
                try {
                    if (listaBloques.get(i).getProcesoAsignado()==null && listaBloques.get(i+1).getProcesoAsignado()==null){
                        listaBloques.get(i).setTamano(listaBloques.get(i).getTamano()+listaBloques.get(i+1).getTamano());
                        listaBloques.remove(i+1);
                    }
                }catch (Exception e){
                }

            }
            mostrarEstadoMemoria();
            //comprobar que la listade espera y la lista de bloque este vacia para cortar la ejecucion de el codigo
            for (int i = 1; i < listaBloques.size(); i++) {
                if (listaBloques.get(i).getProcesoAsignado()!=null){
                    lista_bloques_emty = false;
                    break;
                }
                lista_bloques_emty=true;
            }
            if(listaDeEsperaProcesos.isEmpty()&&lista_bloques_emty){
                break;
            }

            //inicio del bucle que recorre toda la lista de espera
            for (int i = 0; i < listaDeEsperaProcesos.size(); i++) {
                //contador auxiliar para asegurarnos de que el espacio ocupado no exeda la memoria total
                double contador_tamanio = 0;
                for (int k = 1; k < listaBloques.size(); k++) {

                    if (listaBloques.get(k).getProcesoAsignado() != null) {
                        contador_tamanio = contador_tamanio + listaBloques.get(k).getTamano();
                    }
                }
//                System.out.println(contador_tamanio);//borrar despues. sout de ayuda

                if(contador_tamanio< memoria.getTamanio()){ //if para asegurarnos de que el espacio ocupado no exeda la memoria total

                    for (int j = listaBloques.size()-1; j >= 1; j--) { //for que recorre la lista buscando lugares

                        if (listaBloques.get(j).getProcesoAsignado() == null) { //if que verifica que el bloque que se revisa esta actualmente vacio

                            if (listaDeEsperaProcesos.get(i).getTamanio() < (listaBloques.get(j).getTamano() / 2)) { //if para revisar si el proceso puede entrar si dividimos el bloque

                                System.out.println(listaDeEsperaProcesos.get(i).getNombre());
                                //Si el proceso es menor que la mitad del bloque, se va a dividir
                                System.out.println("el bloque de memoria se pudo dividir");
                                System.out.println();
                                //Se va a crear otro bloque que va a ser la mitad del primer bloque
                                BloqueMemoria bloqueMemoria = new BloqueMemoria(listaBloques.get(j).getTamano() / 2);
                                //El bloque actual, al dividirse en dos, su tamaño cambia
                                listaBloques.get(j).setTamano((listaBloques.get(j).getTamano() / 2));
                                //Se agrega a la lista de bloques de memoria
                                listaBloques.add(bloqueMemoria);
                                j+=2;

                            }else if(listaDeEsperaProcesos.get(i).getTamanio()<listaBloques.get(j).getTamano()){ //en caso de que no se pueda dividir se mete en el ultimo que reviso y se rompe el bucle de lista de bloques
                                System.out.println("el bloque de memoria no se pudo dividir mas, asignando proceso " + listaDeEsperaProcesos.get(i).getNombre() + " a la memoria");
                                System.out.println("el espacio del bloque que se asigno es de: " + listaBloques.get(j).getTamano());
                                System.out.println();
                                listaBloques.get(j).setProcesoAsignado(listaDeEsperaProcesos.get(i));
                                listaDeEsperaProcesos.remove(i);
                                break;
                                //revisamos el siguiente proceso
                            }
                        }
                    }
                }
//                System.out.println("---------------");
            }

            if (contador > 0){
                //revisar si un proceso termino y liberar el bloque
                for (int m = 1; m < listaBloques.size(); m++) {
                    try {
                        if(listaBloques.get(m).getProcesoAsignado().duracion()){
                            System.out.println("proceso: "+listaBloques.get(m).getProcesoAsignado().getNombre()+ " liberado");
                            listaBloques.get(m).liberarProceso();
                        }
                    }catch (Exception e){

                    }
                }
            }
            contador++;

        }

        }


    }

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SistemaOperativo sistemaOperativo = new SistemaOperativo();
        sistemaOperativo.crearProceso();
        ArrayList<Proceso> coco=sistemaOperativo.getMemoryManagerUnity().getListaDeEsperaProcesos();

//        for (Proceso proceso : coco) {
//            System.out.println(proceso.getNombre());
//       }
//
//        System.out.println(sistemaOperativo.getMemoryManagerUnity().getListaBloques().get(0).getProcesoAsignado().getNombre());
        sistemaOperativo.iniciar();

        for (BloqueMemoria proceso : sistemaOperativo.getMemoryManagerUnity().getListaBloques()) {

         try {
             System.out.println("nombre del proceso: "+proceso.getProcesoAsignado().getNombre());
             System.out.println("tamaño del bloque: " +proceso.getTamano());
             System.out.println("---------------------");
         } catch (Exception e){

         }
        }
    }
}

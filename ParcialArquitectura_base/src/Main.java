import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SistemaOperativo sistemaOperativo = new SistemaOperativo();
        sistemaOperativo.crearProceso();
        ArrayList<Proceso> coco=sistemaOperativo.getMemoryManagerUnity().getListaDeEsperaProcesos();

        for (Proceso proceso : coco) {
            System.out.println(proceso.getNombre());
        }

    }
}

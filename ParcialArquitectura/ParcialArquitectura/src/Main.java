import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Proceso> procesos = new ArrayList<>();

        Proceso p1 = new Proceso(50);
        Proceso p2 = new Proceso(200);
        Proceso p3 = new Proceso(100);

        procesos.add(p1);
        procesos.add(p2);
        procesos.add(p3);

        Proceso.listarProcesos(procesos);

        System.out.println("Ingrese tamaño del nuevo proceso. ");
        int tamano = sc.nextInt();

        Proceso p4 = Proceso.crearProceso(tamano);
        procesos.add(p4);

        System.out.println(p4);

        System.out.println("Lista procesos.");
        Proceso.listarProcesos(procesos);

        System.out.println("Ingrese id del proceso a eliminar.");
        int idEliminar = sc.nextInt();

        Proceso.eliminarProcesoPorId(idEliminar, procesos);

        Proceso.listarProcesos(procesos);

    }
}